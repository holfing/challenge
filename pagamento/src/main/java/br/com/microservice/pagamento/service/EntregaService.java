package br.com.microservice.pagamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservice.pagamento.dto.EntregaDTO;
import br.com.microservice.pagamento.dto.VoucherDTO;
import br.com.microservice.pagamento.model.PagamentoPedido;
import br.com.microservice.pagamento.repository.EntregaRepository;

@Service
public class EntregaService {
	
	@Autowired
	private EntregaRepository repository;

	public VoucherDTO reservaEntrega(EntregaDTO pedidoDTO) {
		
		PagamentoPedido entrega = new PagamentoPedido();
		entrega.setPedidoId(pedidoDTO.getPedidoId());
		entrega.setDataCompra(pedidoDTO.getDataPagamento());
		entrega.setState(pedidoDTO.getStatePagamento().toString());
		
		repository.save(entrega);
		
		VoucherDTO voucher = new VoucherDTO();
		voucher.setNumero(entrega.getId());
		return voucher;
	}

}
