package fr.mattkds.starterjavaapi.controllers.dto;

import lombok.Data;

@Data
public class FilmStatisticsDTO {
    private Integer rentalId;
    private Double averageRating;
    private Long totalLength;
}

