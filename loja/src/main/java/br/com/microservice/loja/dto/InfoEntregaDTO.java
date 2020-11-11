package br.com.microservice.loja.dto;

import java.time.LocalDate;

import br.com.microservice.loja.model.CompraState;

public class InfoEntregaDTO {

	private Long pedidoId;
	
	private Long fornecedorId;

	private LocalDate dataPagamento;
	
	private CompraState statePagamento;

	/**
	 * @return the pedidoId
	 */
	public Long getPedidoId() {
		return pedidoId;
	}

	/**
	 * @param pedidoId the pedidoId to set
	 */
	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	/**
	 * @return the fornecedorId
	 */
	public Long getFornecedorId() {
		return fornecedorId;
	}

	/**
	 * @param fornecedorId the fornecedorId to set
	 */
	public void setFornecedorId(Long fornecedorId) {
		this.fornecedorId = fornecedorId;
	}

	/**
	 * @return the dataPagamento
	 */
	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	/**
	 * @param dataPagamento the dataPagamento to set
	 */
	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	/**
	 * @return the statePagamento
	 */
	public CompraState getStatePagamento() {
		return statePagamento;
	}

	/**
	 * @param statePagamento the statePagamento to set
	 */
	public void setStatePagamento(CompraState statePagamento) {
		this.statePagamento = statePagamento;
	}

}
