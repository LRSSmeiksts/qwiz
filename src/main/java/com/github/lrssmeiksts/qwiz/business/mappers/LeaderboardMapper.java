package com.github.lrssmeiksts.qwiz.business.mappers;


import com.github.lrssmeiksts.qwiz.business.repository.model.LeaderboardDAO;
import com.github.lrssmeiksts.qwiz.model.Leaderboard;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LeaderboardMapper {

    LeaderboardDAO leaderboardToLeaderboardDAO(Leaderboard leaderboard);

    Leaderboard leaderboardDAOToLeaderboard(LeaderboardDAO leaderboardDAO);
}
