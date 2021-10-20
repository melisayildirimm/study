package yte.intern.spring_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.spring_security.domain.CustomUser;

import java.util.Optional;

public interface CustomUserRepository extends JpaRepository<CustomUser, Long>{

    Optional<CustomUser> findByUsername(String username);
}
