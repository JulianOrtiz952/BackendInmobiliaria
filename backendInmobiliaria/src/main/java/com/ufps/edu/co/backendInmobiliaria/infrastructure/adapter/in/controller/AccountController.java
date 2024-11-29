package com.ufps.edu.co.backendInmobiliaria.infrastructure.adapter.in.controller;

import com.ufps.edu.co.backendInmobiliaria.application.dto.AccountDTO;
import com.ufps.edu.co.backendInmobiliaria.application.service.AccountService;
import com.ufps.edu.co.backendInmobiliaria.domain.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody AccountDTO account){
        return ResponseEntity.ok(accountService.createAccount(account));
    }

    @GetMapping
    public ResponseEntity<AccountDTO> getAccountByUserId(@RequestBody Integer id){
        return ResponseEntity.ok(accountService.getAccountByUserId(id));
    }

}
