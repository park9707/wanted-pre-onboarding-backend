package com.wantedpreonboardingbackend.jobs.repository;

import com.wantedpreonboardingbackend.jobs.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
