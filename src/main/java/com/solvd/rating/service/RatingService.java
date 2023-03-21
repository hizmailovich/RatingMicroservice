package com.solvd.rating.service;

import com.solvd.rating.domain.Rating;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RatingService {

    Flux<Rating> retrieveAll();

    Mono<Rating> retrieveById(Long ratingId);

    Mono<Rating> retrieveByMovieId(Long movieId);

    Mono<Rating> create(Rating rating);

    Mono<Rating> update(Long movieId, Integer mark);

    void deleteByMovieId(Long movieId);

}
