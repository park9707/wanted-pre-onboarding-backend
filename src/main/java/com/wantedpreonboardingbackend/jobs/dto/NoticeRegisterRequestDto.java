package com.wantedpreonboardingbackend.jobs.dto;

import lombok.Getter;

@Getter
public class NoticeRegisterRequestDto {
    private Long companyId;
    private String position;
    private Integer reward;
    private String content;
    private String tech;
}
