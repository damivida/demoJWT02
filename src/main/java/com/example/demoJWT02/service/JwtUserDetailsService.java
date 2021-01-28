package com.example.demoJWT02.service;

import java.security.SecureRandom;
import java.util.ArrayList;

import com.example.demoJWT02.dao.UserDao;
import com.example.demoJWT02.model.DAOUser;
import com.example.demoJWT02.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



/**
 * JWTUserDetailsService implements the Spring Security UserDetailsService interface.
 * It overrides the loadUserByUsername for fetching user details from the database using the username.
 * The Spring Security Authentication Manager calls this method for getting the user details from the database when authenticating the user details provided by the user.
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

          DAOUser user =  userDao.findByUsername(username);


        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());

        //hardcoded user without DB
      /*  if ("admin".equals(username)) {
            return new User("admin", "$2y$12$3ScNCMUBZvGKjChIFlaSs.wY690J/c7jeG.c4dL3qgXfjvR.N5/4K",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }*/
    }


    public DAOUser save(UserDTO user) {

        DAOUser newUser = new DAOUser();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        //newUser.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt("$2a", 12, new SecureRandom())));
        
        return  userDao.save(newUser);
    }
}
