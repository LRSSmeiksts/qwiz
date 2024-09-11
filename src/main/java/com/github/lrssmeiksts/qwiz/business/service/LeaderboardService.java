package com.github.lrssmeiksts.qwiz.business.service;

import com.github.lrssmeiksts.qwiz.business.repository.model.LeaderboardDAO;
import com.github.lrssmeiksts.qwiz.model.Leaderboard;
import org.apache.coyote.BadRequestException;

public interface LeaderboardService {
    LeaderboardDAO saveLeaderboard(Leaderboard leaderboard);
    void deleteLeaderboardById(Long id);
}
