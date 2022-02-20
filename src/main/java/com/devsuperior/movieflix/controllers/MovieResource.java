package com.devsuperior.movieflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieResource {
	
	@Autowired
	public MovieService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<MovieDTO> findByGenre(
			@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<Page<MovieDTO>> findByGenre(
			@RequestParam(value = "genreId", required = false) Long genreId,
			Pageable pageable) {
		
		Page<MovieDTO> list = service.findByGenre(genreId, pageable);		
		return ResponseEntity.ok().body(list);
	}
}
