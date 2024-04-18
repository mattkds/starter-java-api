package fr.mattkds.starterjavaapi.controllers;

import fr.mattkds.starterjavaapi.domains.Rental;
import fr.mattkds.starterjavaapi.services.RentalService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    /**
     * Paginated Endpoint
     * @param pageNumber the pageNumber
     * @param pageSize the pageSize
     * @param sortBy the field use to sort the page
     * @param sortDir the sort direction of the field
     * @param customerId the filter customerId
     * @param filmId the filter filmId
     * @return a paginated response
     */
    @GetMapping
    public ResponseEntity<Page<Rental>> getAllFilms(@RequestParam(name = "page", defaultValue = "0") int pageNumber,
                                                  @RequestParam(name = "size", defaultValue = "10") int pageSize,
                                                  @RequestParam(name = "sortBy", defaultValue = "rentalId") String sortBy,
                                                  @RequestParam(name = "sortDir", defaultValue = "asc") String sortDir,
                                                  @RequestParam(name = "customerId", required = false) Integer customerId,
                                                  @RequestParam(name = "filmId", required = false) Integer filmId
    ) {
        Page<Rental> rentals = rentalService.getAllRentals(pageNumber, pageSize, sortBy, sortDir, customerId, filmId);
        return ResponseEntity.ok(rentals);
    }
}

