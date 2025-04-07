package vocaltranslate_backend.vocaltranslate.service;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vocaltranslate_backend.vocaltranslate.entity.User;
import vocaltranslate_backend.vocaltranslate.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("User not found with username : "+ username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),
        Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
    }
}
