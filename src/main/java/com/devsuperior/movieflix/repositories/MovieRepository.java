package com.devsuperior.movieflix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

	@Query("SELECT m "
			+ "FROM Movie m "
			+ "WHERE (m.genre.id = :genreId OR :genreId IS NULL) "
			+ "ORDER BY m.title")
	Page<Movie> findByGenre(Long genreId, Pageable page);
}
	