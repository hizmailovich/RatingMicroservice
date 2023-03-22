package com.solvd.rating.service.impl;

import com.solvd.rating.domain.Rating;
import com.solvd.rating.persistence.RatingRepository;
import com.solvd.rating.service.RatingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;


    @Override
    public Flux<Rating> retrieveAll() {
        return ratingRepository.findAll();
    }

    @Override
    public Mono<Rating> retrieveById(Long ratingId) {
        return ratingRepository.findById(ratingId);
    }

    @Override
    public Mono<Rating> retrieveByMovieId(Long movieId) {
        return ratingRepository.findByMovieId(movieId);
    }

    @Override
    public Mono<Rating> create(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Mono<Rating> update(Long movieId, Integer mark) {
        return retrieveByMovieId(movieId)
                .map(Optional::of)
                .defaultIfEmpty(Optional.empty())
                .flatMap(optionalRating -> {
                            if(optionalRating.isEmpty()){
                                Rating rating = new Rating();
                                rating.setMovieId(movieId);
                                rating.setAmountOfMarks(1);
                                rating.setAverageMark(mark.doubleValue());
                                return create(rating);
                            }
                            Rating rating = optionalRating.get();
                            Integer amountOfMarks = rating.getAmountOfMarks();
                            Double averageMark = rating.getAverageMark();
                            Double newAverageMark = (averageMark * amountOfMarks + mark) / (amountOfMarks + 1);
                            rating.setAmountOfMarks(amountOfMarks + 1);
                            rating.setAverageMark(newAverageMark);
                            return ratingRepository.save(rating);
                        }
                );
    }

    @Override
    public void deleteByMovieId(Long movieId) {
        ratingRepository.deleteByMovieId(movieId).subscribe();
    }

}
