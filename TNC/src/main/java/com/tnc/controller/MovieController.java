package com.tnc.controller;

import java.io.IOException;
import java.sql.Blob;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tnc.domain.Movie;
import com.tnc.service.MovieService;

@Controller
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@RequestMapping("/list")
	public ModelAndView list() {
		
		ModelAndView modelAndView = new ModelAndView("/movie/movieList");

		try {
			
			modelAndView.addObject("movieList", movieService.list());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return modelAndView;
	}
	
	@RequestMapping("/new")
	public ModelAndView newMovie() {
		
		ModelAndView modelAndView = new ModelAndView("/movie/movieAdd");
		modelAndView.addObject("movie", new Movie());

		return modelAndView;
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("movie") Movie movie,
			@RequestParam("file") MultipartFile file) {

		try 
		{
			System.out.println("Name:" + file.getName());
			System.out.println("size (MB) :" + file.getSize());
			System.out.println("File:" + file.getName());
			System.out.println("ContentType:" + file.getContentType());
			
			Blob blob = Hibernate.createBlob(file.getInputStream());

//			movie.setMovieImage(blob);
			
			movieService.save(movie);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "redirect:/movie/view";
	}
	
	@RequestMapping("/edit")
	public ModelAndView edit(@ModelAttribute("movie") Movie movie) {
		
		ModelAndView modelAndView = new ModelAndView("/movie/movieView");
		modelAndView.addObject("movie", movie);

		return modelAndView;
	}
	
	@RequestMapping("/update")
	public ModelAndView update(@ModelAttribute("movie") Movie movie) {
		
		ModelAndView modelAndView = new ModelAndView("redirect:/movie/view");
		
		try {
			
			modelAndView.addObject("movie", movieService.update(movie));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return modelAndView;
	}

	@RequestMapping("/view")
	public ModelAndView view(@ModelAttribute("movie") Movie movie) {
		
		ModelAndView modelAndView = new ModelAndView("movieView");
		modelAndView.addObject("movie", movie);

		return modelAndView;
	}

	@RequestMapping("/delete/{movieId}")
	public String remove(@PathVariable("movieId") Integer movieId) {

		movieService.delete(movieId);

		return "redirect:/movie/list";
	}
}