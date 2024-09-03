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
@Table(name="category")
public class CategoryDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "categoryId", fetch = FetchType.LAZY)
    private List<QuizDAO> quizIds;

    @Column(name = "category_name")
    @NotEmpty
    private String categoryName;
}
