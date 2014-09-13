package com.tnc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
			
			if (movie.getMovieId() == null || movie.getMovieId() == 0) 
			{
				
				movieResponse = movieService.save(movie);
			}
			else
			{
				
				movieResponse = movieService.update(movie);
			}
			
			System.out.println("Add movie update host : " + movieResponse.getMovieId());
//			modelAndView.addObject(movieResponse);
			
//			redirectAttributes.addFlashAttribute("movie", movieResponse);
		} 
//		catch (IOException e) {
//			e.printStackTrace();
//		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/movie/view?id=" + movieResponse.getMovieId();
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView getEdit(@RequestParam(value = "id", required = true) Integer movieId) {
		
		ModelAndView modelAndView = new ModelAndView("/movie/movieEdit");
		modelAndView.addObject("movie", movieService.findByID(movieId));

		return modelAndView;
	}
	
//	@RequestMapping(value = "/edit", method = RequestMethod.POST)
//	public String edit(@ModelAttribute("movie") Movie movie) {
//		
//		Movie movieResponse = null;
//		
//		try {
//			System.out.println("Begin Edit movie update host : " + movie.getMovieId());
//			
//			movieResponse = movieService.update(movie);
//			
//			System.out.println("Edit movie update host : " + movieResponse.getMovieId());
//			
////			redirectAttributes. addFlashAttribute("movie", movieResponse);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return "redirect:/movie/view?id=" + movieResponse.getMovieId();
//	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute("movie") Movie movie) {
		
		Movie movieResponse = null;

		try 
		{
			movieResponse = movieService.save(movie);
			
			System.out.println("edit movie update host : " + movieResponse.getMovieId());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/movie/view?id=" + movieResponse.getMovieId();
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