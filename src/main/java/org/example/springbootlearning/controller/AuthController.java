//package org.example.springbootlearning.controller;
//
//import lombok.AllArgsConstructor;
//import org.example.springbootlearning.dto.AuthResponse;
//import org.example.springbootlearning.dto.LoginRequestDTO;
//import org.example.springbootlearning.filter.JwtUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@AllArgsConstructor
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
//    private JwtUtil jwtUtil;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
//        // Validate user credentials (example only)
//        String username = loginRequest.getUsername();
//        String password = loginRequest.getPassword();
//        log.info("{} {}", username, password);
//
//        // Assume user is authenticated
//        String token = jwtUtil.generateToken(username);
//
//        return ResponseEntity.ok(new AuthResponse(token));
//    }
//
//    @GetMapping("/user")
//    public ResponseEntity<?> getUser(@RequestHeader("Authorization") String authorizationHeader) {
//        String token = authorizationHeader.substring(7); // Remove "Bearer " prefix
//        String username = jwtUtil.extractSubject(token);
//        // Return user details or any other response
//        return ResponseEntity.ok("Username: " + username);
//    }
//}
