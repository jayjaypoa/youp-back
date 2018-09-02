package com.sicredi.hackathon.social.service;

import com.sicredi.hackathon.social.dto.request.LoginRequest;
import com.sicredi.hackathon.social.dto.request.RegisterUserRequest;
import com.sicredi.hackathon.social.dto.response.LoginResponse;
import com.sicredi.hackathon.social.entity.UserEntity;
import com.sicredi.hackathon.social.exception.status.AttemptLoginException;
import com.sicredi.hackathon.social.exception.status.NotFoundException;
import com.sicredi.hackathon.social.repository.ProjectRepository;
import com.sicredi.hackathon.social.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public UserEntity insert(final RegisterUserRequest user) {

        final UserEntity userEntity = UserEntity.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .picture(user.getPicture())
                .name(user.getName())
                .cpf(user.getCpf())
                .phone(user.getPhone())
                .birthdate(user.getBirthdate())
                .build();

        return userRepository.save(userEntity);
    }

    public UserEntity findUserByEmail(final String email) {
        return userRepository.findByEmail(email).orElseThrow(NotFoundException::new);
    }

    public LoginResponse login(final LoginRequest request) {
        userRepository.findByEmailAndAndPassword(request.getEmail(), request.getPassword()).orElseThrow(AttemptLoginException::new);

        return LoginResponse.builder()
                .login(request.getEmail())
                .build();
    }

}
