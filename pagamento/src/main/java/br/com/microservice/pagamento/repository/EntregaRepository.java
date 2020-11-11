package br.com.microservice.pagamento.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.microservice.pagamento.model.PagamentoPedido;

@Repository
public interface EntregaRepository extends CrudRepository<PagamentoPedido, Long>{

}
