package com.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.interfaces.UserRepository;
import com.model.MyUserPrincipal;
import com.model.User;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@Component
public class UserDetailsSecurityService implements UserDetailsService {
    private static final Logger LOG = LoggerFactory.getLogger(UserDetailsSecurityService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByName(s);
        System.out.println("user from db = " + user);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        InitialContext ic;
        try {
            ic = new InitialContext();
            DataSource myDS = (DataSource) ic.lookup("java:comp/env/jdbc/confluence");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        System.out.println("name = " + user.getName() + "pass = " + user.getPass());
//        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPass(), true, true, true,
//                true, AuthorityUtils.createAuthorityList("ADMIN", "DB", "1", "ROLE_ADMIN", "ROLE_DB", "ROLE_1"));
        return new MyUserPrincipal(user);

    }
}
