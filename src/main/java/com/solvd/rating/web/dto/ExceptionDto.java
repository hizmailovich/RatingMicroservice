package com.solvd.rating.web.dto;

import lombok.Builder;

@Builder
public record ExceptionDto(

        String field,
        String message

) {
}
