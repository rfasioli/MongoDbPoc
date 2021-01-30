package br.com.rfasioli.mongodbpoc.persistence.repositories;

import br.com.rfasioli.mongodbpoc.business.domains.Operation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationDomainRepository extends MongoRepository<Operation, String> {
}
