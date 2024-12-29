package com.scm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.entities.User;

import java.lang.foreign.Linker.Option;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,String>
{
    // Optional<User> findbyEmail(String email);
    Optional<User> findByEmail(String email);
}
