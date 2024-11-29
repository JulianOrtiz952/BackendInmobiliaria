package com.ufps.edu.co.backendInmobiliaria.domain.dao;

import com.ufps.edu.co.backendInmobiliaria.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findByUserId(Integer id);

}
