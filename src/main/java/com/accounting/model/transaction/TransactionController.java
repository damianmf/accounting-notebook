package com.accounting.model.transaction;

import com.accounting.exceptions.ValidationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * The type Transaction controller.
 */
@CrossOrigin
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    /**
     * Get all transactions of single user account persisted in memory.
     *
     * @return the all
     */
    @GetMapping
    @ResponseBody
    public List<TransactionDto> getAll() {
        return service.find();
    }

    /**
     * Get transaction of single user account by id.
     *
     * @param id the id
     * @return the transaction dto
     * @throws ValidationException the validation exception
     */
    @GetMapping("/{id}")
    @ResponseBody
    public TransactionDto get(@PathVariable String id) throws ValidationException {
        return service.find(id);
    }

    /**
     * Create transaction on single user account, transaction has a TransactionType (DEBIT/CREDIT).
     *
     * @param dto the dto
     * @return the transaction dto
     * @throws Exception the exception
     */
    @PostMapping
    @ResponseBody
    public TransactionDto create(@RequestBody TransactionDto dto) throws Exception {
        return service.create(dto);
    }


}
