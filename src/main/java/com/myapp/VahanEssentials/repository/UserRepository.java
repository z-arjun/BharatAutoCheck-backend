package com.myapp.VahanEssentials.repository;

import com.myapp.VahanEssentials.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // UserRepository methods if needed
    User findByUsername(String username);
    User findByEmail(String email);
}
