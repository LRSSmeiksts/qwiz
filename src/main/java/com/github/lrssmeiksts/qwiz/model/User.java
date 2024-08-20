package com.github.lrssmeiksts.qwiz.model;

import com.github.lrssmeiksts.qwiz.business.repository.model.LeaderboardDAO;
import com.github.lrssmeiksts.qwiz.swagger.DescriptionVariables;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Model of user data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @ApiModelProperty(hidden = true, notes = "Unique user id", example = "1")
    @NotNull
    @Min(value = 1, message = DescriptionVariables.MODEL_ID_MIN)
    @Max(value = Long.MAX_VALUE, message = DescriptionVariables.MODEL_ID_MAX)
    private Long id;

    // leaderboard id
    @ApiModelProperty(notes = "User's leaderboard id")
    private LeaderboardDAO leaderboardId;

    // quizzes id's

    // quiz result id's

    @ApiModelProperty(notes = "Email of the user", required = true)
    @NotNull
    @Size(min = 10, max = 200, message = "Email must be between 10 and 120 characters")
    private String email;

    @ApiModelProperty(notes = "Username of the user", required = true)
    @NotNull
    @Size(min = 1, max = 200, message = "Username must be between 1 and 120 characters")
    private String username;

    @ApiModelProperty(notes = "URl for the picture of the user")
    private String pictureUrl;

    @ApiModelProperty(notes = "Role of the user")
    @NotNull
    @Size(min = 1, max = 5, message = "role must be between 1 and 5 characters")
    private String role;
}
