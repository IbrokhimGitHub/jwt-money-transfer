package uz.pdp.jwtmoneytransfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class AuthorizationService implements UserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> userList=new ArrayList<>(
                Arrays.asList(
                        new User("pdp", passwordEncoder.encode("pdpUz"), new ArrayList<>()),
                        new User("cardHolder", passwordEncoder.encode("cardHolder"), new ArrayList<>()),
                        new User("pdpCard", passwordEncoder.encode("pdpCard"), new ArrayList<>()),
                        new User("uzCard", passwordEncoder.encode("uzCard"), new ArrayList<>())
                )
        );
        for (User user : userList) {
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        throw new UsernameNotFoundException("user not found");

    }
}
