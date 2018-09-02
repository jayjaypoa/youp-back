package com.sicredi.hackathon.social.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequest implements Serializable {

    private static final long serialVersionUID = -3747350943292946899L;

    private String email;

    private String password;

    private String picture;

    private String name;

    private String cpf;

    private String phone;

    private LocalDate birthdate;

}
