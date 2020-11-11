package br.com.microservice.pagamento.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PagamentoPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long pedidoId;
	
	private LocalDate dataCompra;
	
	private Integer numCartao;
	
	private String state;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

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
	 * @return the dataCompra
	 */
	public LocalDate getDataCompra() {
		return dataCompra;
	}

	/**
	 * @param dataCompra the dataCompra to set
	 */
	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	/**
	 * @return the numCartao
	 */
	public Integer getNumCartao() {
		return numCartao;
	}

	/**
	 * @param numCartao the numCartao to set
	 */
	public void setNumCartao(Integer numCartao) {
		this.numCartao = numCartao;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

}
