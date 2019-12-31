package com.accounting.model.transaction;

import com.accounting.exceptions.ValidationErrorCode;
import com.accounting.exceptions.ValidationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<TransactionDto> find() {
        return repository.findAll().stream().map(TransactionTranslator::toBriefDto).collect(Collectors.toList());
    }

    public TransactionDto find(String id) throws ValidationException {
        return TransactionTranslator.toDto(repository.find(id)
                .orElseThrow(() -> new ValidationException(ValidationErrorCode.RESOURCE_NOT_FOUND,
                        String.format("Resource %s not found", id))));
    }

    public TransactionDto create(TransactionDto dto) throws Exception {
        TransactionValidator.validateTransactionInput(dto);
        return TransactionTranslator.toDto(repository.save(TransactionTranslator.toDomain(dto)));
    }
}
