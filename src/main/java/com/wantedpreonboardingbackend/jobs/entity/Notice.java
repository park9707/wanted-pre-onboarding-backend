package com.wantedpreonboardingbackend.jobs.entity;

import com.wantedpreonboardingbackend.jobs.dto.NoticeRegisterRequestDto;
import com.wantedpreonboardingbackend.jobs.dto.NoticeUpdateRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NOTICE_ID", columnDefinition = "BIGINT", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    @Column(name = "POSITION", columnDefinition = "VARCHAR(40)", nullable = false)
    private String position;

    @Column(name = "REWARD", columnDefinition = "int", nullable = false)
    private Integer reward;

    @Column(name = "CONTENT", columnDefinition = "VARCHAR(255)", nullable = false)
    private String content;

    @Column(name = "TECH", columnDefinition = "VARCHAR(30)", nullable = false)
    private String tech;

    @Builder
    public Notice(Company company, String position, Integer reward, String content, String tech) {
        this.company = company;
        this.position = position;
        this.reward = reward;
        this.content = content;
        this.tech = tech;
    }

    public static Notice createNotice(NoticeRegisterRequestDto dto, Company company) {
        return builder()
                .company(company)
                .position(dto.getPosition())
                .reward(dto.getReward())
                .content(dto.getContent())
                .tech(dto.getTech())
                .build();
    }

    public Notice updateNotice(NoticeUpdateRequestDto dto) {
        this.position = dto.getPosition();
        this.reward = dto.getReward();
        this.content = dto.getContent();
        this.tech = dto.getTech();
        return this;
    }
}
