package br.com.rfasioli.mongodbpoc.persistence.repositories;

import br.com.rfasioli.mongodbpoc.persistence.documents.OperationDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends MongoRepository<OperationDocument, String>, OperationRepositoryCustom {
}
