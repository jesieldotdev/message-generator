package com.jesiel.bank.credito.service;

import com.jesiel.bank.credito.model.User;
import com.jesiel.bank.credito.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        logger.info("Salvando usuário: {}", user);

        if (user.getName() == null || user.getName().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório.");
        }
        if (user.getLogin() == null || user.getLogin().isEmpty()) {
            throw new IllegalArgumentException("Login é obrigatório.");
        }

        if (user.getAge() == null || user.getAge() <= 0) {
            throw new IllegalArgumentException("Idade inválida.");
        }

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuário não encontrado com ID: " + id)
        );
    }

    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);
        user.setName(userDetails.getName());
        user.setLastName(userDetails.getLastName());
        user.setLogin(userDetails.getLogin());
        user.setAge(userDetails.getAge());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado com ID: " + id);
        }
        userRepository.deleteById(id);
    }
}
