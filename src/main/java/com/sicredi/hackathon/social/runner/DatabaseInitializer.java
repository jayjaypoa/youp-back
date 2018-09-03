package com.sicredi.hackathon.social.runner;


import com.sicredi.hackathon.social.domain.ProjectCategory;
import com.sicredi.hackathon.social.domain.ProjectStatus;
import com.sicredi.hackathon.social.entity.ProjectEntity;
import com.sicredi.hackathon.social.entity.UserEntity;
import com.sicredi.hackathon.social.repository.ProjectRepository;
import com.sicredi.hackathon.social.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@Component
public class DatabaseInitializer implements ApplicationRunner {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        UserEntity betinho = userRepository.save(UserEntity.builder()
                .password("poc123")
                .name("betinho")
                .birthdate(LocalDate.of(1988, Month.APRIL, 10))
                .cpf("01234567890")
                .email("betinho@bol.com.br")
                .phone("51999999999")
                .build());
        UserEntity marquinhos = userRepository.save(UserEntity.builder()
                .password("123456")
                .name("marquinhos")
                .birthdate(LocalDate.of(1989, Month.AUGUST, 21))
                .cpf("0987654321")
                .email("marquinhos@aol.com.br")
                .phone("514327432746")
                .build());
        UserEntity bianca = userRepository.save(UserEntity.builder()
                .password("biaforever")
                .name("bia_gatinha_88")
                .birthdate(LocalDate.of(1993, Month.FEBRUARY, 2))
                .cpf("67298933231")
                .email("bia_gatinha_88@bol.com.br")
                .phone("51981212343")
                .build());

        ProjectEntity coisaLegal = projectRepository.save(ProjectEntity.builder()
                .status(ProjectStatus.EM_ANDAMENTO)
                .description("Coisas legais pra escrever aqui")
                .title("Coisa Legal")
                .category(ProjectCategory.Artes)
//                .users(Arrays.asList(betinho, bianca))
                .build());

        ProjectEntity petFriendly = projectRepository.save(ProjectEntity.builder()
                .status(ProjectStatus.EM_ANDAMENTO)
                .description("Animais são legalzinhos")
                .title("Pet Life")
                .category(ProjectCategory.Animais)
//                .users(Arrays.asList(betinho, marquinhos))
                .build());

    }

}