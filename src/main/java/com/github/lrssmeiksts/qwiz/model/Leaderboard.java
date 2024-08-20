package com.github.lrssmeiksts.qwiz.model;

import com.github.lrssmeiksts.qwiz.swagger.DescriptionVariables;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Model of user leaderboard")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Leaderboard {

    @ApiModelProperty(hidden = true, notes = "Unique leaderboard id", example = "1")
    @NotNull
    @Min(value = 1, message = DescriptionVariables.MODEL_ID_MIN)
    @Max(value = Long.MAX_VALUE, message = DescriptionVariables.MODEL_ID_MAX)
    private Long id;

    @ApiModelProperty(hidden = true, notes = "Total score of all quizzes", example = "1")
    @NotNull
    private int totalScore;

    @ApiModelProperty(hidden = true, notes = "Total guessed quizzes", example = "1")
    @NotNull
    private int quizzesGuessed;
}
