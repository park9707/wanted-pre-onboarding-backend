package com.wantedpreonboardingbackend.jobs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMPANY_ID", columnDefinition = "BIGINT", nullable = false)
    private Long id;

    @Column(name = "NAME", columnDefinition = "VARCHAR(10)", nullable = false)
    private String name;

    @Column(name = "COUNTRY", columnDefinition = "VARCHAR(10)", nullable = false)
    private String country;

    @Column(name = "REGION", columnDefinition = "VARCHAR(10)", nullable = false)
    private String region;
}
