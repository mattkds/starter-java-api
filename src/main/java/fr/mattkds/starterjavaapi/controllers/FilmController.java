package fr.mattkds.starterjavaapi.controllers;

import fr.mattkds.starterjavaapi.domains.Film;
import fr.mattkds.starterjavaapi.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public ResponseEntity<Page<Film>> getAllFilms(@RequestParam(name = "page", defaultValue = "0") int pageNumber,
                                                  @RequestParam(name = "size", defaultValue = "10") int pageSize,
                                                  @RequestParam(name = "sortBy", defaultValue = "filmId") String sortBy,
                                                  @RequestParam(name = "sortDir", defaultValue = "asc") String sortDir,
                                                  @RequestParam(name = "year", required = false) Integer year,
                                                  @RequestParam(name = "storeId", required = false) Integer storeId
    ) {
        Page<Film> films = filmService.getAllFilms(pageNumber, pageSize, sortBy, sortDir, year, storeId);
        return ResponseEntity.ok(films);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable Long id) {
        Optional<Film> film = filmService.getFilmById(id);
        return film.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Film> createFilm(@RequestBody Film film) {
        Film createdFilm = filmService.saveOrUpdateFilm(film);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFilm);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable Long id, @RequestBody Film film) {
        Optional<Film> existingFilm = filmService.getFilmById(id);
        if (existingFilm.isPresent()) {
            film.setFilmId(id);
            Film updatedFilm = filmService.saveOrUpdateFilm(film);
            return ResponseEntity.ok(updatedFilm);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable Long id) {
        Optional<Film> existingFilm = filmService.getFilmById(id);
        if (existingFilm.isPresent()) {
            filmService.deleteFilm(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
