package com.tnc.controller;

import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tnc.domain.Movie;
import com.tnc.formValidator.MovieFormValidator;
import com.tnc.service.MovieService;

@Controller
@RequestMapping("/movie")
public class MovieController
{

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieFormValidator validator;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder)
    {

//        dataBinder.setDisallowedFields(new String[] { "releasedDate", "expirationDate", "movieImage" });

        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(false));

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/")
    public ModelAndView list()
    {

        ModelAndView modelAndView = new ModelAndView("/movie/movieList");

        try
        {

            modelAndView.addObject("movieList", movieService.list());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView getAdd()
    {

        ModelAndView modelAndView = new ModelAndView("/movie/movieAdd");
        modelAndView.addObject("movie", new Movie());

        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String updateHost(@ModelAttribute("movie") Movie movie, BindingResult result, @RequestParam("movieImage") MultipartFile file)
    {

        Movie movieResponse = null;

        try
        {

            System.out.println("Name:" + file.getOriginalFilename());
            System.out.println("size (MB) :" + file.getSize());
            System.out.println("File:" + file.getName());
            System.out.println("ContentType:" + file.getContentType());
            
//            System.out.println(movie.getMovieImage().);

            Blob blob = new javax.sql.rowset.serial.SerialBlob(file.getBytes());

            movie.setMovieImage(blob);

            /** Validate Form */
            validator.validate(movie, result);
            if (result.hasErrors())
            {
                if (movie.getMovieId() == null || movie.getMovieId() == 0)
                {

                    return "/movie/movieAdd";
                }
                else
                {

                    return "/movie/movieEdit";
                }
            }
            else
            {
                if (movie.getMovieId() == null || movie.getMovieId() == 0)
                {

                    movieResponse = movieService.save(movie);
                }
                else
                {

                    movieResponse = movieService.update(movie);
                }
            }

            System.out.println("Add movie update host : " + movieResponse.getMovieId());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return "redirect:/movie/view/" + movieResponse.getMovieId();
    }

    @RequestMapping(value = "/edit/{movieId}", method = RequestMethod.GET)
    public ModelAndView getEdit(@PathVariable(value = "movieId") Integer movieId)
    {

        ModelAndView modelAndView = new ModelAndView("/movie/movieEdit");
        modelAndView.addObject("movie", movieService.findByID(movieId));

        return modelAndView;
    }

    @RequestMapping(value = "/view/{movieId}", method = RequestMethod.GET)
    public ModelAndView view(@PathVariable(value = "movieId") Integer movieId)
    {

        ModelAndView modelAndView = new ModelAndView("/movie/movieView");
        modelAndView.addObject("movie", movieService.findByID(movieId));

        return modelAndView;
    }

    @RequestMapping("/delete/{movieId}")
    public String delete(@PathVariable(value = "movieId") Integer movieId)
    {

        movieService.delete(movieId);

        return "redirect:/movie/";
    }
}
