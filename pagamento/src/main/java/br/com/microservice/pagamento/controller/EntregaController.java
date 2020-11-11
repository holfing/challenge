package br.com.microservice.pagamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.pagamento.dto.EntregaDTO;
import br.com.microservice.pagamento.dto.VoucherDTO;
import br.com.microservice.pagamento.service.EntregaService;

@RestController
@RequestMapping("/pagamento")
public class EntregaController {
	
	@Autowired
	private EntregaService entregaService;

	@RequestMapping(method = RequestMethod.POST)
	public VoucherDTO reservaEntrega(@RequestBody EntregaDTO pedidoDTO) {
		return entregaService.reservaEntrega(pedidoDTO);
	}
}
