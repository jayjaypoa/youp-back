package com.sicredi.hackathon.social.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sicredi.hackathon.social.domain.ProjectCategory;
import com.sicredi.hackathon.social.domain.ProjectStatus;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project")
@ToString
public class ProjectEntity implements Serializable {

    private static final long serialVersionUID = -7688722208070330673L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = true, length = 1000)
    private String description;

    @Column(nullable = true, length = 1000)
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private ProjectCategory category;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ProjectStatus status;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "favorited_projects",
            joinColumns = @JoinColumn(name = "id_project"),
            inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<UserEntity> users;

}
