package br.com.rfasioli.mongodbpoc.interfaces.controllers;

import br.com.rfasioli.mongodbpoc.business.domains.Operation;
import br.com.rfasioli.mongodbpoc.business.services.OperationUseCase;
import br.com.rfasioli.mongodbpoc.interfaces.converters.OperationDTOToOperationConverter;
import br.com.rfasioli.mongodbpoc.interfaces.converters.OperationToOperationDTOConverter;
import br.com.rfasioli.mongodbpoc.interfaces.dtos.OperationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/operation")
public class OperationController {
    private final OperationToOperationDTOConverter operationToOperationDTOConverter;
    private final OperationDTOToOperationConverter operationDTOToOperationConverter;
    private final OperationUseCase operationUseCase;

    public OperationController(OperationToOperationDTOConverter operationToOperationDTOConverter,
                               OperationDTOToOperationConverter operationDTOToOperationConverter,
                               OperationUseCase operationUseCase) {
        this.operationToOperationDTOConverter = operationToOperationDTOConverter;
        this.operationDTOToOperationConverter = operationDTOToOperationConverter;
        this.operationUseCase = operationUseCase;
    }

    @PostMapping
    private ResponseEntity<String> saveOperation(@RequestBody OperationDTO operationDTO) {
        Operation operation = operationUseCase.save(
                operationDTOToOperationConverter.convert(operationDTO));
        return ResponseEntity.ok("Operação [%s] cadastrada com sucesso.".format(operation.getId()));
    }

    @GetMapping("{id}")
    private ResponseEntity<OperationDTO> find(@PathVariable String id) {
        return ResponseEntity.ok(
                operationToOperationDTOConverter.convert(
                        operationUseCase.findOne(id)));
    }

    @GetMapping
    private ResponseEntity<List<OperationDTO>> getOperations() {
        return ResponseEntity.ok(
                operationUseCase.findAll().stream().map(o ->
                        operationToOperationDTOConverter.convert(o)).collect(Collectors.toList()));
    }

    @PutMapping("{id}/status")
    private ResponseEntity<Boolean> updateStatus(
            @PathVariable String id,
            @RequestParam Operation.STATUS status) {
        return ResponseEntity.ok(operationUseCase.updateStatus(id, status));
    }

}
