package com.sicredi.hackathon.social.service;

import com.sicredi.hackathon.social.domain.ProjectStatus;
import com.sicredi.hackathon.social.dto.request.EditProjectRequest;
import com.sicredi.hackathon.social.dto.request.RegisterProjectRequest;
import com.sicredi.hackathon.social.dto.response.RegisterProjectResponse;
import com.sicredi.hackathon.social.entity.ProjectEntity;
import com.sicredi.hackathon.social.entity.UserEntity;
import com.sicredi.hackathon.social.exception.status.NotFoundException;
import com.sicredi.hackathon.social.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserService userService;

    public RegisterProjectResponse register(final RegisterProjectRequest request) {

        ProjectEntity projectEntity = ProjectEntity.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .category(request.getCategory())
                .status(ProjectStatus.EM_ANDAMENTO)
                .build();

        projectEntity = projectRepository.save(projectEntity);

        return RegisterProjectResponse.builder()
                .idProject(projectEntity.getId())
                .build();
    }

    public ResponseEntity edit(final EditProjectRequest request) {

        ProjectEntity projectEntity = ProjectEntity.builder()
                .id(request.getId())
                .title(request.getTitle())
                .description(request.getDescription())
                .category(request.getType())
                .build();

        projectRepository.save(projectEntity);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ProjectEntity find(final Long id) {
        return projectRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public ProjectEntity delete(final Long id) {
        ProjectEntity projectEntity = projectRepository.findById(id).orElseThrow(NotFoundException::new);

        projectRepository.delete(projectEntity);

        return projectEntity;
    }

    public List<ProjectEntity> findProjectsByUserLogged(final String email) {
        UserEntity user = userService.findUserByEmail(email);
        return projectRepository.findAllByUsersContains(user);
    }

    public ResponseEntity favorite(Long id, String email) {
        UserEntity user = userService.findUserByEmail(email);
        ProjectEntity project = projectRepository.findById(id).orElseThrow(NotFoundException::new);

        project.getUsers().add(user);
        projectRepository.save(project);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

