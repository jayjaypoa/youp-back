package com.sicredi.hackathon.social.dto.request;

import com.sicredi.hackathon.social.domain.ProjectCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterProjectRequest implements Serializable {

    private static final long serialVersionUID = -5285321423835750466L;

    private String title;
    private String description;
    private ProjectCategory category;

}
