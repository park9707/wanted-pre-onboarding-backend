package com.wantedpreonboardingbackend.jobs.service;

import com.wantedpreonboardingbackend.jobs.dto.NoticeDetailsResponseDto;
import com.wantedpreonboardingbackend.jobs.dto.NoticeFindResponseDto;
import com.wantedpreonboardingbackend.jobs.dto.NoticeIdDto;
import com.wantedpreonboardingbackend.jobs.dto.NoticeRegisterRequestDto;
import com.wantedpreonboardingbackend.jobs.dto.NoticeUpdateRequestDto;
import com.wantedpreonboardingbackend.jobs.entity.Company;
import com.wantedpreonboardingbackend.jobs.entity.Notice;
import com.wantedpreonboardingbackend.jobs.repository.CompanyRepository;
import com.wantedpreonboardingbackend.jobs.repository.NoticeDetailRepository;
import com.wantedpreonboardingbackend.jobs.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final CompanyRepository companyRepository;
    private final NoticeDetailRepository noticeDetailRepository;

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

    public List<NoticeFindResponseDto> findNotice() {
        List<Notice> noticeList = noticeRepository.findAll();
        return noticeList.stream()
                .map(notice -> new NoticeFindResponseDto(notice, notice.getCompany()))
                .toList();
    }

    public List<NoticeFindResponseDto> searchNotice(String search) {
        List<Notice> noticeList = noticeDetailRepository.searchNotice(search);
        return noticeList.stream()
                .map(notice -> new NoticeFindResponseDto(notice, notice.getCompany()))
                .toList();
    }

    public NoticeDetailsResponseDto findNoticeDetails(Long noticeId) {
        Notice notice = noticeRepository.findById(noticeId)
                .orElseThrow(() -> new IllegalArgumentException("Notice를 찾을 수 없습니다."));
        Company company = notice.getCompany();
        List<NoticeIdDto> noticeIds = noticeDetailRepository.findCompanyNotice(company, noticeId);

        return new NoticeDetailsResponseDto(notice, company, noticeIds);
    }
}
