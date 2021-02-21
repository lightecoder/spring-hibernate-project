package demo.controller;

import demo.dao.UserRepository;
import demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Slf4j
@Controller
@SessionAttributes(names = {"user"})
public class ClientController {

    private final UserRepository userRepository;

    @Autowired
    public ClientController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ModelAttribute(name = "user")
    public User user() {
        return new User();
    }

    @GetMapping("/client")
    public String client() {
        return "client";
    }

    @GetMapping("/internationalClient")
    public String international() {
        return "client";
    }


}
