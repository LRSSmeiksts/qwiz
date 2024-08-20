package com.github.lrssmeiksts.qwiz.business.repository.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "leaderboard")
@Entity
public class LeaderboardDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="leaderboard_id")
    private Long id;

    @Column(name="total_score")
    @NotNull
    private int totalScore;

    @Column(name="quizzes_guessed")
    @NotNull
    private int quizzesGuessed;

}
