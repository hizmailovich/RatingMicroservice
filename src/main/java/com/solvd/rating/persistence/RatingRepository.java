package com.solvd.rating.persistence;

import com.solvd.rating.domain.Rating;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface RatingRepository extends ReactiveMongoRepository<Rating, Long> {

    Mono<Rating> findByMovieId(Long movieId);

    Mono<Void> deleteByMovieId(Long movieId);

}
