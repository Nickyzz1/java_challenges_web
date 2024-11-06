package  com.example.demo.filters;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.services.JWTService;
import com.example.demo.controllers.dto.Token;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
// vai no header (gearlemnte), body, pela url no path
// postman
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    final JWTService<Token> jwtService;
    public JWTAuthenticationFilter(JWTService<Token> jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        var jwt = getJwt(request);
        if (jwt == null)
        {
            filterChain.doFilter(request, response);
            return;
        }

        var token = jwtService.validate(jwt);
        if (token == null)
        {
            filterChain.doFilter(request, response);
            return;
        }
        
        var authentication = new UsernamePasswordAuthenticationToken("jao", null, null);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        request.setAttribute("token", token);
        filterChain.doFilter(request, response);
    }
    
    String getJwt(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
