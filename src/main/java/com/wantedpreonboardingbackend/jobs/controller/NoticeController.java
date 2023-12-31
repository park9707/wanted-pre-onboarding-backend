package com.wantedpreonboardingbackend.jobs.controller;

import com.wantedpreonboardingbackend.jobs.dto.NoticeDetailsResponseDto;
import com.wantedpreonboardingbackend.jobs.dto.NoticeFindResponseDto;
import com.wantedpreonboardingbackend.jobs.dto.NoticeRegisterRequestDto;
import com.wantedpreonboardingbackend.jobs.dto.NoticeUpdateRequestDto;
import com.wantedpreonboardingbackend.jobs.entity.Notice;
import com.wantedpreonboardingbackend.jobs.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public Long registerNotice(@RequestBody NoticeRegisterRequestDto dto) {
        return noticeService.registerNotice(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/update")
    public Notice updateNotice(@RequestBody NoticeUpdateRequestDto dto) {
        return noticeService.updateNotice(dto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{noticeId}")
    public void deleteNotice(@PathVariable Long noticeId) {
        noticeService.deleteNotice(noticeId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/list")
    public List<NoticeFindResponseDto> findNotice() {
        return noticeService.findNotice();
    }

    @GetMapping("/search")
    public List<NoticeFindResponseDto> searchNotice(@RequestParam String search) {
        return noticeService.searchNotice(search);
    }

    @GetMapping("/{noticeId}")
    public NoticeDetailsResponseDto findNoticeDetail(@PathVariable Long noticeId) {
        return noticeService.findNoticeDetails(noticeId);
    }
}
