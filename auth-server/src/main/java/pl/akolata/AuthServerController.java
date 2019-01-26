package pl.akolata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthServerController {

    private static final Logger logger = LoggerFactory.getLogger(AuthServerController.class);

    @GetMapping("/user")
    public Principal user(Principal user) {
        logger.info("User endpoint here");
        return user;
    }
}
