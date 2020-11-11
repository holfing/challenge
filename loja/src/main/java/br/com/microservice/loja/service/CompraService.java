package br.com.microservice.loja.service;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.microservice.loja.client.FornecedorClient;
import br.com.microservice.loja.client.PagamentoClient;
import br.com.microservice.loja.dto.CompraDTO;
import br.com.microservice.loja.dto.InfoEntregaDTO;
import br.com.microservice.loja.dto.InfoPedidoDTO;
import br.com.microservice.loja.dto.VoucherDTO;
import br.com.microservice.loja.model.Compra;
import br.com.microservice.loja.model.CompraState;
import br.com.microservice.loja.repository.CompraRepository;

@Service
public class CompraService {

	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);

	@Autowired
	private FornecedorClient fornecedorClient;

	@Autowired
	private PagamentoClient pagamentoClient;

	@Autowired
	private CompraRepository compraRepository;

	@HystrixCommand(threadPoolKey = "getByIdThreadPool")
	public Compra getById(Long id) {
		return compraRepository.findById(id).orElse(new Compra());
	}

	public Compra reprocessaCompra(Long id) {
		return null;
	}

	public Compra cancelaCompra(Long id) {
		return null;
	}

	@HystrixCommand(fallbackMethod = "realizaCompraFallback", threadPoolKey = "realizaCompraThreadPool")
	public Compra realizaCompra(CompraDTO compra) {
		Compra compraSalva = new Compra();
		compraSalva.setState(CompraState.RECEBIDO);
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());
		compraRepository.save(compraSalva);
		compra.setCompraId(compraSalva.getId());

		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
		compraSalva.setState(CompraState.PEDIDO_REALIZADO);
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraRepository.save(compraSalva);

		InfoEntregaDTO entregaDto = new InfoEntregaDTO();
		entregaDto.setPedidoId(pedido.getId());
		entregaDto.setDataPagamento(LocalDate.now().plusDays(pedido.getTempoDePreparo()));
		entregaDto.setStatePagamento(CompraState.PAGAMENTO_EFETUADO);
		VoucherDTO voucher = pagamentoClient.reservaEntrega(entregaDto);
		compraSalva.setState(CompraState.PAGAMENTO_EFETUADO);
		compraSalva.setDataParaEntrega(voucher.getPrevisaoParaEntrega());
		compraSalva.setVoucher(voucher.getNumero());
		compraRepository.save(compraSalva);
		
		LOG.info("Compra Realizada com sucesso!");

		return compraSalva;
	}

	public Compra realizaCompraFallback(CompraDTO compra) {
		if (compra.getCompraId() != null) {
			return compraRepository.findById(compra.getCompraId()).get();
		}

		Compra compraFallback = new Compra();
		compraFallback.setEnderecoDestino(compra.getEndereco().toString());
		return compraFallback;
	}

}
