package org.telran.validationexample.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.telran.validationexample.com.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
