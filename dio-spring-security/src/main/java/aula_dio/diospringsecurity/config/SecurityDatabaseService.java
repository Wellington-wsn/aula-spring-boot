package aula_dio.diospringsecurity.config;

import aula_dio.diospringsecurity.model.User;
import aula_dio.diospringsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class SecurityDatabaseService  implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) {  // Retorna uma classe de "spring security"
        User userEntity = userRepository.findByUsername(username); // Interação com o banco de dados, para retornar um usuario pelo 'username'
        if (userEntity == null) { // verificação se o usuario existe
            throw new UsernameNotFoundException(username);
        }
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>(); // validação do usuario pelo spring
        userEntity.getRoles().forEach(role -> { // geração de roles,
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        });
        UserDetails user = new org.springframework.security.core.userdetails.User(userEntity.getUsername(), // Composição de pacote definindo os dados do usuario
                userEntity.getPassword(),
                authorities);
        return user;
    }
}
