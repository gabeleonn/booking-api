package com.example.booking.configuration.Security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.booking.Employee.EmployeeService;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtFilter extends OncePerRequestFilter {

    private JwtService jwtService;
    private EmployeeService employeeService;

    public JwtFilter(JwtService jwt, EmployeeService service) {
        this.jwtService = jwt;
        this.employeeService = service;
    }
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String auth = request.getHeader("Authorization");

        if (auth != null && auth.startsWith("Bearer ")) {
            String token = auth.split(" ")[1];
            Boolean isTokenValid = jwtService.validateToken(token);
            if (isTokenValid) {
                String userLogin = jwtService.getEmployeeEmail(token);
                UserDetails employee = employeeService.loadUserByUsername(userLogin);
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(employee, null, employee.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
            
        }

        filterChain.doFilter(request, response);
    }
    
}
