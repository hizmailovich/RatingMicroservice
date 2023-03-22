package com.solvd.rating.web.dto;

public record InternalError(

        String field,
        String message

) {
}
