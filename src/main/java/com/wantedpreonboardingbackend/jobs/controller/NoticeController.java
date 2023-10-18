package com.wantedpreonboardingbackend.jobs.controller;

import com.wantedpreonboardingbackend.jobs.dto.NoticeRegisterRequestDto;
import com.wantedpreonboardingbackend.jobs.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Long registerNotice(@RequestBody NoticeRegisterRequestDto dto) {
        return noticeService.registerNotice(dto);
    }
}
