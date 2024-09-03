package com.github.lrssmeiksts.qwiz.business.repository.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="quiz")
public class QuizDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserDAO userId;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private CategoryDAO categoryId;

    @Column(name = "title", nullable = false)
    @NotEmpty
    private String title;

    @Column(name = "answer", nullable = false)
    @NotEmpty
    private String answer;

    @Column(name="point_value")
    @NotNull
    private int pointValue;

    @Column(name = "created_at")
    @NotNull
    private LocalDate createdAt;

    public QuizDAO(Long id){this.id = id;}
}
