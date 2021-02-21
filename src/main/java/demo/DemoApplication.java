package demo;

import com.github.javafaker.Faker;
import demo.dao.ActivityRepository;
import demo.dao.UserRepository;
import demo.dao.UserTypeRepository;
import demo.entity.Activity;
import demo.entity.User;
import demo.entity.UserType;
import java.util.Optional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            UserRepository userRepository,
            UserTypeRepository userTypeRepository,
            ActivityRepository activityRepository) {
        return args -> {
            Optional<User> admin = userRepository.findById(1L);

            if(!admin.isPresent()){
                Faker faker = new Faker();

                String firstName = faker.name().firstName();
                String surName = faker.name().lastName();
                String login = "admin";
                String password = "admin";
                Optional<UserType> userType = userTypeRepository.findById(1L);
                User newUserAdmin = new User();
                newUserAdmin.setFirstName(firstName);
                newUserAdmin.setSurName(surName);
                newUserAdmin.setLogin(login);
                newUserAdmin.setPassword(password);
                newUserAdmin.setUserType(userType.orElseGet(UserType::new));

                userRepository.save(newUserAdmin);

                activityRepository.save(new Activity("go to the shop"));
                activityRepository.save(new Activity("drop the garbage"));
                activityRepository.save(new Activity("write the report"));
                activityRepository.save(new Activity("create an article"));
            }
        };
    }

}
