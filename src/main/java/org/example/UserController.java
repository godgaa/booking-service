package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/users")
    public ResponseEntity<User> findByName(@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok(user);

    }
    @GetMapping("/users")
        public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userRepository.findAll());
        }
}

