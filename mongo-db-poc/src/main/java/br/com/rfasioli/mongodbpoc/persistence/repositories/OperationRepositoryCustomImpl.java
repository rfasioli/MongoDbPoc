package br.com.rfasioli.mongodbpoc.persistence.repositories;

import br.com.rfasioli.mongodbpoc.business.domains.Operation;
import br.com.rfasioli.mongodbpoc.persistence.documents.OperationDocument;
import com.mongodb.client.result.UpdateResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class OperationRepositoryCustomImpl implements OperationRepositoryCustom {
    private final MongoTemplate mongoTemplate;

    public OperationRepositoryCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public long updateOperationStatus(String operationId, Operation.STATUS status) {
        Query query = new Query(Criteria.where("_id").is(operationId));
        Update update = new Update();
        update.set("status", status);

        return update(query, update);
    }

    private long update(Query query, Update update) {
        UpdateResult result = mongoTemplate.updateFirst(query, update, OperationDocument.class);
        return (result != null) ? result.getModifiedCount() : 0;
    }

}
