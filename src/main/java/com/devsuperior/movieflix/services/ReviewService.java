package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.ReviewRepository;

@Service	
public class ReviewService {
	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private AuthService authService;
	
	@Transactional(readOnly = false)
	public ReviewDTO insert(ReviewDTO dto) {
		Review entity = new Review();
		Movie movie = new Movie();
		entity.setId(dto.getId());
		entity.setText(dto.getText());
		movie.setId(dto.getMovieId());
		entity.setMovie(movie);
		entity.setUser(authService.authenticated());
		entity = repository.save(entity);
		return new ReviewDTO(entity);
	}
}
