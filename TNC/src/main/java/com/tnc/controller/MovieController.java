package com.tnc.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView getAdd() {
		
		ModelAndView modelAndView = new ModelAndView("/movie/movieAdd");
		modelAndView.addObject("movie", new Movie());

		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("movie") Movie movie
//			, @RequestParam("file") MultipartFile file
			) {
		
		Movie movieResponse = null;
//		ModelAndView modelAndView = new ModelAndView("/movie/movieView");

		try 
		{
//			System.out.println("Name:" + file.getName());
//			System.out.println("size (MB) :" + file.getSize());
//			System.out.println("File:" + file.getName());
//			System.out.println("ContentType:" + file.getContentType());
//			
//			Blob blob = Hibernate.createBlob(file.getInputStream());
//
//			movie.setMovieImage(blob);
			
			movieResponse = movieService.save(movie);
//			modelAndView.addObject(movieResponse);
			
//			redirectAttributes.addFlashAttribute("movie", movieResponse);
		} 
//		catch (IOException e) {
//			e.printStackTrace();
//		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/movie/view/" + movieResponse.getId();
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView getEdit(@RequestParam(value = "id", required = true) Integer movieId) {
		
		ModelAndView modelAndView = new ModelAndView("/movie/movieEdit");
		modelAndView.addObject("movie", movieService.findByID(movieId));

		return modelAndView;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute("movie") Movie movie
									, final RedirectAttributes redirectAttributes) {
		
		try {
			Movie movieResponse = movieService.update(movie);
			
			redirectAttributes. addFlashAttribute("movie", movieResponse);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/movie/view";
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam(value = "id", required = true) Integer movieId) {
		
		ModelAndView modelAndView = new ModelAndView("/movie/movieView");
		modelAndView.addObject("movie", movieService.findByID(movieId));

		return modelAndView;
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam(value = "id", required = true) Integer movieId) {

		movieService.delete(movieId);

		return "redirect:/movie/list";
	}
}