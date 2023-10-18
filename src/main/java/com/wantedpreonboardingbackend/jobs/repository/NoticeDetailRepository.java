package com.wantedpreonboardingbackend.jobs.repository;

import com.wantedpreonboardingbackend.jobs.dto.NoticeIdDto;
import com.wantedpreonboardingbackend.jobs.entity.Company;
import com.wantedpreonboardingbackend.jobs.entity.Notice;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class NoticeDetailRepository {

    private final EntityManager em;

    public List<Notice> searchNotice(String search) {
        return em.createQuery("select distinct n from Notice n join Company c on n.company = c " +
                "where n.position like concat('%', :search, '%') " +
                "or n.tech like concat('%', :search, '%') " +
                "or c.country like concat('%', :search, '%') " +
                "or c.name like concat('%', :search, '%') " +
                "or c.region like concat('%', :search, '%') ", Notice.class)
                .setParameter("search", search)
                .getResultList();
    }

    public List<NoticeIdDto> findCompanyNotice(Company company, Long noticeId) {
        return em.createQuery("select n.id from Notice n where n.company = :company " +
                        "and n.id <> :noticeId", NoticeIdDto.class)
                .setParameter("company", company)
                .setParameter("noticeId", noticeId)
                .getResultList();
    }
}
