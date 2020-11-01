package com.example.booking.Employee;

import com.example.booking.Department.Department;
import com.example.booking.Department.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements UserDetailsService {

    @Autowired private EmployeeRepository repository;
    @Autowired private DepartmentRepository deptRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee employee = repository.findByEmail(email).get();
        return User.builder()
                    .username(employee.getEmail())
                    .password(employee.getPassword())
                    .roles("ADMIN")
                    .build();
    }

    public Department getEmployeeDepartment(Integer id) {
        return deptRepository.getOne(id);
    }

}
