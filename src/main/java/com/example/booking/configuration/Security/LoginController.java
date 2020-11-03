package com.example.booking.configuration.Security;

import com.example.booking.Employee.Employee;
import com.example.booking.Employee.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequestMapping("/login")
public class LoginController {
    
    @Autowired private EmployeeService employeeService;
    @Autowired private JwtService jwtService;

    @PostMapping
    public Token login(@RequestBody Employee employee) throws UsernameNotFoundException{
        try{
            UserDetails dbEmployee = employeeService.authenticate(employee);
            if(dbEmployee != null) {
                String token = jwtService.generateToken(dbEmployee);
                return new Token(token);
            }
            throw new UsernameNotFoundException("Usuário não encontrado.");
        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException("Usuário não encontrado.");
        }
    }
}
