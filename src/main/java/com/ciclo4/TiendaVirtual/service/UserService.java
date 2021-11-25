package com.ciclo4.TiendaVirtual.service;

import com.ciclo4.TiendaVirtual.model.User;
import com.ciclo4.TiendaVirtual.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.getAll();
    }

    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }

    public User save(User u){
        if(u.getId() == null){
            if(existeEmail(u.getEmail()) == false){
                return userRepository.save(u);
            }else{
                return u;
            }
        }else{
            return u;
        }
    }

    public boolean existeEmail(String email){
        return userRepository.existeEmail(email);
    }

    public User autenticarUsuario(String email, String password){
        Optional<User> uaux = userRepository.autenticarUsuario(email, password);
        if(uaux.isEmpty()){
            return new User(email, password, "NO DEFINIDO");
        }else{
            return uaux.get();
        }
    }
}
