package com.solvd.rating.web.controller;

import com.solvd.rating.domain.Rating;
import com.solvd.rating.service.RatingService;
import com.solvd.rating.web.dto.RatingDto;
import com.solvd.rating.web.dto.mapper.RatingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ratings")
public class RatingController {

    private final RatingService ratingService;
    private final RatingMapper ratingMapper;

    @GetMapping()
    public Flux<RatingDto> getAll() {
        Flux<Rating> ratings = ratingService.retrieveAll();
        return ratings.map(ratingMapper::toDto);
    }

    @GetMapping("/{ratingId}")
    public Mono<RatingDto> getById(@PathVariable Long ratingId) {
        Mono<Rating> rating = ratingService.retrieveById(ratingId);
        return rating.map(ratingMapper::toDto);
    }

    @PutMapping()
    public Mono<RatingDto> refresh(@RequestParam Long movieId,
                                   @RequestParam Integer mark) {
        Mono<Rating> rating = ratingService.update(movieId, mark);
        return rating.map(ratingMapper::toDto);
    }

}
