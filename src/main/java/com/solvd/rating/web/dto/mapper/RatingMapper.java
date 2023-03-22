package com.solvd.rating.web.dto.mapper;

import com.solvd.rating.domain.Rating;
import com.solvd.rating.web.dto.RatingDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RatingMapper {

    RatingDto toDto(Rating rating);

}
