package fr.mattkds.starterjavaapi.services;

import fr.mattkds.starterjavaapi.domains.Rental;
import fr.mattkds.starterjavaapi.repository.RentalRepository;
import fr.mattkds.starterjavaapi.specification.RentalSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 * Rental Service Class
 * This Service deals with rentals data
 * New line comment
 * test
 * test of local work
 */
@Service
public class RentalService {

    private final RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
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

