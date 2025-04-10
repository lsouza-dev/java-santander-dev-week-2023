package me.dio.service.impl;

import me.dio.domain.model.User;
import me.dio.domain.repository.UserRepository;
import me.dio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {

        if(userRepository.existsByAccount_Number(userToCreate.getAccount().getNumber()))
            throw new IllegalArgumentException("This Account number already exists.");

        if(userRepository.existsByCard_Number(userToCreate.getCard().getNumber()))
            throw new IllegalArgumentException("This Card number is already registred.");


        return userRepository.save(userToCreate);
    }
}
