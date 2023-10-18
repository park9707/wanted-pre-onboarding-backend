package com.wantedpreonboardingbackend.jobs.dto;

import com.wantedpreonboardingbackend.jobs.entity.Company;
import com.wantedpreonboardingbackend.jobs.entity.Notice;
import lombok.Data;

@Data
public class NoticeFindResponseDto {
    private Long noticeId;
    private String companyName;
    private String country;
    private String region;
    private String position;
    private Integer reward;
    private String tech;

    public NoticeFindResponseDto(Notice notice, Company company) {
        this.noticeId = notice.getId();
        this.companyName = company.getName();
        this.country = company.getCountry();
        this.region = company.getRegion();
        this.position = notice.getPosition();
        this.reward = notice.getReward();
        this.tech = notice.getTech();
    }
}
