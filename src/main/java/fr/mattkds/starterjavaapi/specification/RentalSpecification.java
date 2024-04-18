package fr.mattkds.starterjavaapi.specification;

import fr.mattkds.starterjavaapi.domains.Film;
import fr.mattkds.starterjavaapi.domains.Inventory;
import fr.mattkds.starterjavaapi.domains.Rental;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

public class RentalSpecification {

    public static Specification<Rental> hasCustomerId(Integer customerId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("customerId"), customerId);
    }

    public static Specification<Rental> hasBeenMadeForFilmId(Integer filmId) {
        return (root, query, criteriaBuilder) -> {
            Join<Rental, Inventory> inventoryJoin = root.join("inventory");
            Join<Inventory, Film> storeJoin = inventoryJoin.join("film");
            return criteriaBuilder.equal(storeJoin.get("filmId"), filmId);
        };
        }

}
