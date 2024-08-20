package com.github.lrssmeiksts.qwiz.business.repository;

import com.github.lrssmeiksts.qwiz.business.repository.model.LeaderboardDAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderboardRepository extends JpaRepository<LeaderboardDAO, Long> {
}
