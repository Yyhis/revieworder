package net.yyhis.revieworder.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.yyhis.revieworder.auth.dto.LoginRequestDto;
import net.yyhis.revieworder.auth.dto.TokenDto;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto) {
        try {
            return authService.keycloakLogin(loginRequestDto);
        } catch (Exception e) {
            logger.error("Login failed: {}", e.getMessage());
            return ResponseEntity.status(500).body("An error occurred during login");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody TokenDto tokenDto) {
        try {
            return authService.keycloakLogout(tokenDto);
        } catch (Exception e) {
            logger.error("Logout failed: {}", e.getMessage());
            return ResponseEntity.status(500).body("An error occurred during logout");
        }
    }
}