package com.wantedpreonboardingbackend.jobs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class NoticeIdDto {
    List<Long> NoticeIds;
}
