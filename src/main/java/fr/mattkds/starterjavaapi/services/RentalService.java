package fr.mattkds.starterjavaapi.services;

import fr.mattkds.starterjavaapi.domains.Film;
import fr.mattkds.starterjavaapi.domains.Rental;
import fr.mattkds.starterjavaapi.repository.RentalRepository;
import fr.mattkds.starterjavaapi.specification.FilmSpecification;
import fr.mattkds.starterjavaapi.specification.RentalSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Page<Rental> getAllRentals(int pageNumber, int pageSize, String sortBy, String sortDir, Integer customerId, Integer filmId) {
        Specification<Rental> specification = Specification.where(null);

        if (customerId != null) {
            specification = specification.and(RentalSpecification.hasCustomerId(customerId));
        }
        if (filmId != null) {
            specification = specification.and(RentalSpecification.hasBeenMadeForFilmId(filmId));
        }
        Pageable page = PageRequest.of(pageNumber, pageSize, Sort.Direction.fromString(sortDir), sortBy);
        return rentalRepository.findAll(specification, page);
    }
}

