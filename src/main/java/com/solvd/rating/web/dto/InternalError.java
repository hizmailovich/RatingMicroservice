package com.solvd.rating.web.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public record InternalError(

        String field,
        String message

) {
}
