package ly.qubit.annualdeclaration.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/users")
public class UserController {
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationRequest request) {
        // Implementation logic for user registration using JPA and database operations
        // Return appropriate response entity based on the result
        return null;
    }
@PostMapping("/api/users/login")
public <UserLoginRequest> ResponseEntity<?> loginUser(@RequestBody UserLoginRequest request) {
        // Implementation logic for user login using JPA and database operations
        // Return appropriate response entity based on the result
        return null;
    }

}
