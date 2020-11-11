package br.com.microservice.loja.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.microservice.loja.dto.InfoEntregaDTO;
import br.com.microservice.loja.dto.VoucherDTO;

@FeignClient("transportador")
public interface PagamentoClient {

	@RequestMapping(path="/pagamento", method = RequestMethod.POST)
	public VoucherDTO reservaEntrega(InfoEntregaDTO pedidoDTO);
}
