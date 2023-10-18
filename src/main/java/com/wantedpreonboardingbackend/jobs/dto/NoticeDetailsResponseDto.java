package com.wantedpreonboardingbackend.jobs.dto;

import com.wantedpreonboardingbackend.jobs.entity.Company;
import com.wantedpreonboardingbackend.jobs.entity.Notice;
import lombok.Data;

import java.util.List;

@Data
public class NoticeDetailsResponseDto {
    private Long noticeId;
    private String companyName;
    private String country;
    private String region;
    private String position;
    private Integer reward;
    private String tech;
    private String content;
    private List<NoticeIdDto> noticeIdList;

    public NoticeDetailsResponseDto(Notice notice, Company company, List<NoticeIdDto> ids) {
        this.noticeId = notice.getId();
        this.companyName = company.getName();
        this.country = company.getCountry();
        this.region = company.getRegion();
        this.position = notice.getPosition();
        this.reward = notice.getReward();
        this.tech = notice.getTech();
        this.content = notice.getContent();
        this.noticeIdList = ids;
    }
}
