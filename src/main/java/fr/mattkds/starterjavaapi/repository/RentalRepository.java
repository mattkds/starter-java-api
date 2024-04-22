package fr.mattkds.starterjavaapi.repository;

import fr.mattkds.starterjavaapi.controllers.dto.FilmStats;
import fr.mattkds.starterjavaapi.domains.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer>, JpaSpecificationExecutor<Rental> {
    @Query(value  = "SELECT r.customer as rentalId, AVG(f.rentalDuration) as averageRentalDuration, SUM(f.length) as totalLength, count(distinct f.filmId) as numberOfFilmRented, STRING_AGG(f.title, ', ') as concatTitle FROM Rental r JOIN r.inventory.film f GROUP BY r.customer")
    List<FilmStats> getFilmStatisticsByRental();
}

