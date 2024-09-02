package net.yyhis.revieworder.auth;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import net.yyhis.revieworder.auth.dto.LoginRequestDto;
import net.yyhis.revieworder.auth.dto.TokenDto;

@Service
public class AuthService {
    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Value("${KEYCLOAK_URL}")
    private String keycloakUrl;
    @Value("${KEYCLOAK_CLIENT_SECRET}")
    private String clientSecret;

    @Value("${KEYCLOAK_CLIENT_ID}")
    private String clientId;

    private final RestTemplate restTemplate;

    public AuthService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<?> keycloakLogin(LoginRequestDto loginRequestDto) {
        HttpEntity<MultiValueMap<String, String>> request = createRequestEntity(createLoginBody(loginRequestDto));

        try {
            ResponseEntity<Map> response = restTemplate.exchange(
                    keycloakUrl + "/protocol/openid-connect/token",
                    HttpMethod.POST,
                    request,
                    Map.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                return ResponseEntity.ok(response.getBody());
            } else {
                return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
            }
        } catch (Exception e) {
            logger.error("Login failed: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Login failed");
        }
    }

    public ResponseEntity<?> keycloakLogout(TokenDto tokenDto) {
        HttpEntity<MultiValueMap<String, String>> request = createRequestEntity(createLogoutBody(tokenDto));

        try {
            ResponseEntity<Map> response = restTemplate.exchange(
                    keycloakUrl + "/protocol/openid-connect/logout",
                    HttpMethod.POST,
                    request,
                    Map.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                return ResponseEntity.ok(response.getBody());
            } else {
                return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
            }
        } catch (Exception e) {
            logger.error("Logout failed: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Logout failed");
        }
    }

    private MultiValueMap<String, String> createLoginBody(LoginRequestDto loginRequestDto) {
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "password");
        body.add("client_id", clientId);
        body.add("client_secret", clientSecret);
        body.add("username", loginRequestDto.getUsername());
        body.add("password", loginRequestDto.getPassword());
        return body;
    }

    private MultiValueMap<String, String> createLogoutBody(TokenDto tokenDto) {
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("client_id", clientId);
        body.add("client_secret", clientSecret);
        body.add("refresh_token", tokenDto.getRefreshToken());
        return body;
    }

    private HttpEntity<MultiValueMap<String, String>> createRequestEntity(MultiValueMap<String, String> body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return new HttpEntity<>(body, headers);
    }
}
