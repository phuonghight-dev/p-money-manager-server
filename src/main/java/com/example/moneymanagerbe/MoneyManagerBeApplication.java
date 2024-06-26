package com.example.moneymanagerbe;

import com.example.moneymanagerbe.config.properties.AdminInfoProperties;
import com.example.moneymanagerbe.constant.RoleConstant;
import com.example.moneymanagerbe.domain.entity.Role;
import com.example.moneymanagerbe.domain.entity.User;
import com.example.moneymanagerbe.repository.RoleRepository;
import com.example.moneymanagerbe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@RequiredArgsConstructor
@EnableConfigurationProperties({AdminInfoProperties.class})
@SpringBootApplication
public class MoneyManagerBeApplication {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        Environment env = SpringApplication.run(MoneyManagerBeApplication.class, args).getEnvironment();
        String appName = env.getProperty("spring.application.name");
        if (appName != null) {
            appName = appName.toUpperCase();
        }
        String port = env.getProperty("server.port");
        log.info("-------------------------START " + appName
                + " Application------------------------------");
        log.info("   Application         : " + appName);
        log.info("   Url swagger-ui      : http://localhost:" + port + "/swagger-ui.html");
        log.info("-------------------------START SUCCESS " + appName
                + " Application------------------------------");
    }

    @Bean
    CommandLineRunner init(AdminInfoProperties userInfo) {
        return args -> {
            //init role
            if (roleRepository.count() == 0) {
                roleRepository.save(new Role(null, RoleConstant.ADMIN, null));
                roleRepository.save(new Role(null, RoleConstant.USER, null));
            }
            //init admin
            if (userRepository.count() == 0) {
                User admin = User.builder().email(userInfo.getEmail())
                        .password(passwordEncoder.encode(userInfo.getPassword()))
                        .fullName(userInfo.getFullName())
                        .role(roleRepository.findByRoleName(RoleConstant.ADMIN)).build();
                userRepository.save(admin);
            }
        };
    }
}
