package com.sicredi.hackathon.social.repository;


import com.sicredi.hackathon.social.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(final String email);

    Optional<UserEntity> findByEmailAndAndPassword(final String email, final String password);

}
