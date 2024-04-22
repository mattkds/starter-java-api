package fr.mattkds.starterjavaapi.services;

import fr.mattkds.starterjavaapi.domains.Film;
import fr.mattkds.starterjavaapi.repository.FilmRepository;
import fr.mattkds.starterjavaapi.specification.FilmSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public Page<Film> getAllFilms(int pageNumber, int pageSize, String sortBy, String sortDirection, Integer year, Integer storeId) {
        Specification<Film> specification = Specification.where(null);

        if (year != null) {
            specification = specification.and(FilmSpecification.hasReleaseYear(year));
        }
        Pageable page = PageRequest.of(pageNumber, pageSize, Sort.Direction.fromString(sortDirection), sortBy);
        return filmRepository.findAll(specification, page);
    }

    public Optional<Film> getFilmById(Long id) {
        return filmRepository.findById(id);
    }

    public Film saveOrUpdateFilm(Film film) {
        return filmRepository.save(film);
    }

    public void deleteFilm(Long id) {
        filmRepository.deleteById(id);
    }
}

