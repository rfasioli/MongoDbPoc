package br.com.rfasioli.mongodbpoc.persistence.repositories;

import br.com.rfasioli.mongodbpoc.business.domains.Operation;

public interface OperationRepositoryCustom {
    long updateOperationStatus(String operationId, Operation.STATUS status);
}
