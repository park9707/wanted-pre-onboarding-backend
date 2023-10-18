package com.wantedpreonboardingbackend.jobs.dto;

import lombok.Getter;

@Getter
public class NoticeUpdateRequestDto {
    private Long noticeId;
    private String position;
    private Integer reward;
    private String content;
    private String tech;
}
