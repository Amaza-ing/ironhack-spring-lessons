package com.ironhack.w4d4.security;

import com.ironhack.w4d4.model.User;
import com.ironhack.w4d4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Localizamos el usuario en la base de datos con un findByName
        Optional<User> userOptional = userRepository.findByName(username);
        if (userOptional.isEmpty()) throw new UsernameNotFoundException("User: " + username + " does not exist");
        User user = userOptional.get();

//        En las siguientes 2 lineas creamos una lista con todos los roles que tenga el usuario
//        En este caso solo tienen un rol, pero podrían tener varios si los añadimos en nuestra base de datos
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));

//        El objeto userDetails es el objeto que vamos a devolver en este método, contiene los detalles del usuario
//        Es decir, el nombre, la contraseña (encriptada) y su lista de roles
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), roles);
        return userDetails;
    }
}
