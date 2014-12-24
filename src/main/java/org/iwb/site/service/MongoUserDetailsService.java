package org.iwb.site.service;

import org.iwb.site.bo.User;
import org.iwb.site.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;

/**
 * TODO document me
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public class MongoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ShaPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (this.userDao == null || this.userDao.count() == 0) {
            User root = new User();
            root.setId("iwb-root");
            root.setEmail("void@iwb.org");
            root.setName(root.getId());
            root.setPassword(this.encoder.encodePassword("", root.getId()));
            root.setAuthorities(Arrays.asList(new SimpleGrantedAuthority("super-administrator"), new SimpleGrantedAuthority("administrator"), new SimpleGrantedAuthority("user")));
            return root;
        }
        User user = this.userDao.findOne(username);
        if (user != null) {
            return user;
        }
        throw new UsernameNotFoundException("cannot find " + username);
    }
}
