package br.com.rfasioli.mongodbpoc.business.services;

import br.com.rfasioli.mongodbpoc.business.domains.Operation;

import java.util.List;

public interface OperationUseCase {
    Operation save(Operation operation);
    List<Operation> findAll();
    Operation findOne(String id);
    Boolean updateStatus(String id, Operation.STATUS status);
}
