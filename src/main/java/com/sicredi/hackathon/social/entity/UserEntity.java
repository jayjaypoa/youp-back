package com.sicredi.hackathon.social.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(of = "id")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
@ToString
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 7366539098994678983L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String email;

    @Column(nullable = false, length = 30)
    private String password;

    @Column(nullable = true)
    private String picture;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String cpf;

    @Column(nullable = true)
    private String phone;

    @Column(nullable = true)
    private LocalDate birthdate;

    @JsonIgnore
    @ManyToMany(mappedBy = "users")
    private List<ProjectEntity> favorites = new ArrayList<>();

}
