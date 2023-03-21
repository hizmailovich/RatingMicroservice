package com.solvd.rating.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RatingDto(

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        String id,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Long movieId,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Integer amountOfMarks,

        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        Double averageMark

) {
}
