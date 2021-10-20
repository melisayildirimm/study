package yte.intern.spring_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.spring_security.domain.Authority;


public interface AuthorityRepository extends JpaRepository<Authority,Long> {

}
