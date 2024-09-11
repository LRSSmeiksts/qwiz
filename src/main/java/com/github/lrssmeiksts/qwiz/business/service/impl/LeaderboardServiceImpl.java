package com.github.lrssmeiksts.qwiz.business.service.impl;

import com.github.lrssmeiksts.qwiz.business.mappers.LeaderboardMapper;
import com.github.lrssmeiksts.qwiz.business.repository.LeaderboardRepository;
import com.github.lrssmeiksts.qwiz.business.repository.model.LeaderboardDAO;
import com.github.lrssmeiksts.qwiz.business.service.LeaderboardService;
import com.github.lrssmeiksts.qwiz.model.Leaderboard;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class LeaderboardServiceImpl implements LeaderboardService {

    private final LeaderboardRepository leaderboardRepository;
    private final LeaderboardMapper leaderboardMapper;

    @Autowired
    public LeaderboardServiceImpl(LeaderboardRepository leaderboardRepository, LeaderboardMapper leaderboardMapper){
        this.leaderboardRepository = leaderboardRepository;
        this.leaderboardMapper = leaderboardMapper;

    }

    @Override
    public LeaderboardDAO saveLeaderboard(Leaderboard leaderboard){
        LeaderboardDAO savedLeaderboard =leaderboardRepository.save(leaderboardMapper.leaderboardToLeaderboardDAO(leaderboard));
        log.info("New leaderboard has been created");
        return savedLeaderboard;
    }

    @Override
    public void deleteLeaderboardById(Long id) {
        leaderboardRepository.deleteById(id);
        log.info("Leaderboard with ID {} has been deleted.",id);
    }
}
