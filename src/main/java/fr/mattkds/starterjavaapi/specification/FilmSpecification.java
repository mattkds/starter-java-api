package fr.mattkds.starterjavaapi.specification;

import fr.mattkds.starterjavaapi.domains.Film;
import fr.mattkds.starterjavaapi.domains.Inventory;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

public class FilmSpecification {

    public static Specification<Film> hasReleaseYear(Integer year) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("releaseYear"), year);
    }
}
