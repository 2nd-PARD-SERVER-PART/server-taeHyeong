package protect.pard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import protect.pard.filter.JwtAuthenticationFilter;
import protect.pard.security.TokenProvider;

import java.security.Principal;

@RestController
public class MICController {
    private TokenProvider tokenProvider;
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    public MICController(TokenProvider tokenProvider, JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.tokenProvider = tokenProvider;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @GetMapping("/MIC")
    public Principal helloMIC(Principal principal) {
        return principal;
    }
}
