package gustavo.com.api.config;

import gustavo.com.api.domain.User;
import gustavo.com.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @Bean
    public void startDB() {
        User u1 = new User(null, "Gustavo", "Gustavo@hotmail.com", "123");
        User u2 = new User(null, "Andresa", "Andresa@hotmail.com", "123");
        User u3 = new User(null, "Victorio", "Victorio@hotmail.com", "123");
        User u4 = new User(null, "Soares", "Soares@hotmail.com", "123");

        repository.saveAll(List.of(u1, u2, u3, u4));
    }
}
