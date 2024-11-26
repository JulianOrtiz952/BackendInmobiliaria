package com.ufps.edu.co.backendInmobiliaria.domain.dao;

import com.ufps.edu.co.backendInmobiliaria.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Optional<User> findByName(String name);

}
