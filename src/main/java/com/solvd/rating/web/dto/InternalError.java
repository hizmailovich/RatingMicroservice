package com.solvd.rating.web.dto;

import lombok.Builder;

@Builder
public record InternalError(

        String field,
        String message

) {
}
