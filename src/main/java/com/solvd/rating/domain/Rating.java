package com.solvd.rating.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    @Id
    private String id;
    private Long movieId;
    private Integer amountOfMarks;
    private Double averageMark;

}
