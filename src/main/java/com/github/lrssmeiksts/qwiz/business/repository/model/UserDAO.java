package com.github.lrssmeiksts.qwiz.business.repository.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="user")
public class UserDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="leaderboard_id", referencedColumnName = "leaderboard_id", unique = true)
    private LeaderboardDAO leaderboardId;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "userId", fetch = FetchType.LAZY)
    private List<QuizDAO> quizIds;

    //quiz_results

    @Column(name = "email", nullable = false)
    @NotEmpty
    private String email;

    @Column(name = "username", nullable = false)
    @NotEmpty
    private String username;

    @Column(name = "picture_url")
    private String pictureUrl;

    @NotEmpty
    @Column(name = "role", nullable = false)
    private String role;
}
