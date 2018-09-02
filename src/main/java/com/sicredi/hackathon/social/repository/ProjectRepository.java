package com.sicredi.hackathon.social.repository;

import com.sicredi.hackathon.social.entity.ProjectEntity;
import com.sicredi.hackathon.social.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

    List<ProjectEntity> findAllByUsersContains(UserEntity user);

}
