package com.github.lrssmeiksts.qwiz.model;

import com.github.lrssmeiksts.qwiz.swagger.DescriptionVariables;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Schema(hidden = true, description = "category id", example = "1")
    @NotNull
    @Min(value = 1, message = DescriptionVariables.MODEL_ID_MIN)
    @Max(value = Long.MAX_VALUE, message = DescriptionVariables.MODEL_ID_MAX)
    private Long id;

    @Schema(description = "quiz id", example = "1")
    @NotNull
    @Min(value = 1, message = DescriptionVariables.MODEL_ID_MIN)
    @Max(value = Long.MAX_VALUE, message = DescriptionVariables.MODEL_ID_MAX)
    private List<Long> quizIds;

    @Schema(description = "category name", example = "educational")
    @NotEmpty
    @Size(min = 1, max = 5, message = "categoryName must be between 1 and 50 characters")
    private String categoryName;
}
