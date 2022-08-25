package com.sparta.velog.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sparta.velog.domain.CommentEntity;
import com.sparta.velog.domain.PostEntity;
import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Jacksonized
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EnableJpaRepositories
public class CommentRequestDto {
    @NotBlank
    private Long CommentId;

    @NotBlank
    private String comment;

    public static CommentRequestDto of(CommentEntity commentEntity) {
        return CommentRequestDto.builder()
                .comment(commentEntity.getComment())
                .build();
    }
}