package com.ufps.edu.co.backendInmobiliaria.application.service;

import com.ufps.edu.co.backendInmobiliaria.application.dto.AccountDTO;
import com.ufps.edu.co.backendInmobiliaria.domain.dao.AccountRepository;
import com.ufps.edu.co.backendInmobiliaria.domain.dao.UserRepository;
import com.ufps.edu.co.backendInmobiliaria.domain.entity.Account;
import com.ufps.edu.co.backendInmobiliaria.domain.entity.User;
import com.ufps.edu.co.backendInmobiliaria.infrastructure.adapter.out.response.exception.NotFoundedException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public Account createAccount(AccountDTO accountDTO) {
        if (accountDTO.getUserId() == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }

        User user = userRepository.findById(accountDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + accountDTO.getUserId()));

        Account account = new Account();
        account.setAccount(accountDTO.getAccountNumber());
        account.setBalance(accountDTO.getBalance());
        account.setAccountNumber(account.getAccountNumber());
        account.setUser(user);

        return accountRepository.save(account);
    }

    public AccountDTO getAccountByUserId(Integer id){
         Account account = accountRepository.findByUserId(id);
         return AccountDTO.builder().userId(account.getId()).accountNumber(account.getAccountNumber()).balance(account.getBalance()).build();
    }

}
