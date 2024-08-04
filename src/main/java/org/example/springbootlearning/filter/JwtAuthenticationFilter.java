//package org.example.springbootlearning.security;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.example.springbootlearning.controller.AuthController;
//import org.example.springbootlearning.modal.entity.User;
//import org.example.springbootlearning.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import java.io.IOException;
//
//@Component
//public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//    @Autowired
//    private final AuthController authController;
//    @Autowired
//    private UserRepository userRepository;
//
//    public JwtAuthenticationFilter(AuthController authController) {
//        this.authController = authController;
//    }
//
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//            throws ServletException, IOException {
//        String jwt = getJwtFromRequest(request);
//
//        if (StringUtils.hasText(jwt) && validateToken(jwt)) {
//            String username = getUsernameFromJWT(jwt);
//
//            User userDetails = userRepository.findByUsername(username);
//            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//        }
//
//        chain.doFilter(request, response);
//    }
//
//    private String getJwtFromRequest(HttpServletRequest request) {
//        String bearerToken = request.getHeader("Authorization");
//        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
//            return bearerToken.substring(7);
//        }
//        return null;
//    }
//
//    private boolean validateToken(String authToken) {
//        // Thực hiện kiểm tra tính hợp lệ của token
//        return true; // hoặc false nếu không hợp lệ
//    }
//
//    private String getUsernameFromJWT(String token) {
//        // Giải mã JWT và lấy username
//        return "username"; // Thay thế bằng logic của bạn
//    }
//}
