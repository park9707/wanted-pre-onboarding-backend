package com.wantedpreonboardingbackend.jobs.service;

import com.wantedpreonboardingbackend.jobs.dto.NoticeRegisterRequestDto;
import com.wantedpreonboardingbackend.jobs.dto.NoticeUpdateRequestDto;
import com.wantedpreonboardingbackend.jobs.entity.Company;
import com.wantedpreonboardingbackend.jobs.entity.Notice;
import com.wantedpreonboardingbackend.jobs.repository.CompanyRepository;
import com.wantedpreonboardingbackend.jobs.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final CompanyRepository companyRepository;

    public Long registerNotice(NoticeRegisterRequestDto dto) {
        Company company = companyRepository.findById(dto.getCompanyId())
                .orElseThrow(() -> new IllegalArgumentException("Company를 찾을 수 없습니다."));

        Notice notice = Notice.createNotice(dto, company);
        return noticeRepository.save(notice).getId();
    }

    public Notice updateNotice(NoticeUpdateRequestDto dto) {
        Notice notice = noticeRepository.findById(dto.getNoticeId())
                .orElseThrow(() -> new IllegalArgumentException("Notice를 찾을 수 없습니다."));
        return notice.updateNotice(dto);
    }

    public void deleteNotice(Long noticeId) {
        noticeRepository.deleteById(noticeId);
    }
}
