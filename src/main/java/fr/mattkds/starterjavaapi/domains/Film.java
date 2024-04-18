package fr.mattkds.starterjavaapi.domains;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Data
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Long filmId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "release_year")
    private Short releaseYear;

    @Column(name = "language_id", nullable = false)
    private Long languageId;

    @Column(name = "original_language_id")
    private Long originalLanguageId;

    @Column(name = "rental_duration", nullable = false)
    private Short rentalDuration;

    @Column(name = "rental_rate", nullable = false)
    private BigDecimal rentalRate;

    @Column(name = "length")
    private Short length;

    @Column(name = "replacement_cost", nullable = false)
    private BigDecimal replacementCost;

    @Column(name = "rating", nullable = false)
    private String rating;

    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;

    public void setFilmId(Long id) {
        this.filmId = id;
    }
}
