package com.sicredi.hackathon.social.controller;


import com.sicredi.hackathon.social.dto.request.EditProjectRequest;
import com.sicredi.hackathon.social.dto.request.RegisterProjectRequest;
import com.sicredi.hackathon.social.dto.request.RegisterUserRequest;
import com.sicredi.hackathon.social.dto.response.RegisterProjectResponse;
import com.sicredi.hackathon.social.entity.ProjectEntity;
import com.sicredi.hackathon.social.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    //@PostMapping
    //public RegisterProjectResponse registerProject(@RequestHeader(value = "Authorization", required = false) final String username, @RequestBody final RegisterProjectRequest request) {
    @RequestMapping(value = "/inserir", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> registerProject(@RequestBody RegisterUserRequest request) {
        return projectService.register(request);
    }

    @PutMapping
    public ResponseEntity editProject(@RequestHeader(value = "Authorization", required = false) final String username, @RequestBody final EditProjectRequest request) {
        return projectService.edit(request);
    }

    @PutMapping("/favorite/{id}")
    public ResponseEntity favorite(@RequestHeader(value = "Authorization", required = false) final String username, @PathVariable("id") final Long id) {
        return projectService.favorite(id, username);
    }

    @GetMapping
    public List<ProjectEntity> findProjectsByUserLogged(@RequestHeader("Authorization") String username) {
        return projectService.findProjectsByUserLogged(username);
    }

    @GetMapping("/{id}")
    public ProjectEntity findProject(@PathVariable("id") final Long id) {
        return projectService.find(id);
    }

    @DeleteMapping("/{id}")
    public ProjectEntity deleteProject(@RequestHeader(value = "Authorization", required = false) final String username, @PathVariable("id") final Long id) {
        return projectService.delete(id);
    }


}
