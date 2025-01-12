package com.jesiel.bank.credito.service;

import com.jesiel.bank.credito.model.User;
import com.jesiel.bank.credito.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Salvar usuário no banco de dados
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Listar todos os usuários
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Buscar usuário pelo ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuário não encontrado com ID: " + id)
        );
    }

    // Atualizar usuário
    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);
        user.setName(userDetails.getName());
//        user.setLastName(userDetails.getLastName());
        user.setLogin(userDetails.getLogin());
        user.setAge(userDetails.getAge());
        return userRepository.save(user);
    }

    // Deletar usuário pelo ID
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado com ID: " + id);
        }
        userRepository.deleteById(id);
    }
}
