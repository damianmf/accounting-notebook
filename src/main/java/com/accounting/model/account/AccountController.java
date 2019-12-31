package com.accounting.model.account;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * The type Account controller.
 */
@CrossOrigin
@RestController
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService service;

    /**
     * Instantiates a new Account controller.
     *
     * @param service the service
     */
    public AccountController(AccountService service) {
        this.service = service;
    }

    /**
     * Get status account
     *
     * @return the big decimal
     */
    @GetMapping
    @ResponseBody
    public BigDecimal get() {
        return service.findStatusAccount();
    }

}
