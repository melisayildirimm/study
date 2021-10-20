package yte.intern.spring_security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import yte.intern.spring_security.domain.Authority;
import yte.intern.spring_security.domain.CustomUser;
import yte.intern.spring_security.repository.AuthorityRepository;
import yte.intern.spring_security.repository.CustomUserRepository;

import javax.transaction.Transactional;
import java.util.Set;

@Component
public class DatabasePopulator {

    private final AuthorityRepository authorityRepository;
    private final CustomUserRepository customUserRepository;
    private final PasswordEncoder passwordEncoder;


    public DatabasePopulator(AuthorityRepository authorityRepository,
                             CustomUserRepository customUserRepository, PasswordEncoder passwordEncoder) {
        this.authorityRepository = authorityRepository;
        this.customUserRepository = customUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void populateDatabase(){
        Authority userAuthority = authorityRepository.save(new Authority(null, "USER", Set.of()));
        Authority adminAuthority = authorityRepository.save(new Authority(null, "ADMIN", Set.of()));

        CustomUser user = new CustomUser(null,"user",passwordEncoder.encode("user"),Set.of(userAuthority));
        customUserRepository.save(user);

        CustomUser admin = new CustomUser(null,"admin",passwordEncoder.encode("admin"),Set.of(adminAuthority));
        customUserRepository.save(admin);

    }
}
