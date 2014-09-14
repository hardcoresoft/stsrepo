package com.tnc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.tnc.domain.TheaterLayout;
import com.tnc.service.TheaterLayoutService;

@Controller
@RequestMapping("/theater_layout")
public class TheaterLayoutController
{

    @Autowired
    private TheaterLayoutService theaterLayoutService;

    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/")
    public ModelAndView list()
    {

        ModelAndView modelAndView = new ModelAndView("/theater_layout/theaterLayoutList");

        try
        {
            modelAndView.addObject("theaterLayoutList", theaterLayoutService.list());
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

        ModelAndView modelAndView = new ModelAndView("/theater_layout/theaterLayoutAdd");
        modelAndView.addObject("theaterLayout", new TheaterLayout());

        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String updateHost(@ModelAttribute("theaterLayout") TheaterLayout theaterLayout, BindingResult result,
            SessionStatus status
    // , @RequestParam("file") MultipartFile file
    )
    {

        TheaterLayout theaterLayoutResponse = null;
        // ModelAndView modelAndView = new ModelAndView("/theaterLayout/theaterLayoutView");

        try
        {
            // System.out.println("Name:" + file.getName());
            // System.out.println("size (MB) :" + file.getSize());
            // System.out.println("File:" + file.getName());
            // System.out.println("ContentType:" + file.getContentType());
            //
            // Blob blob = Hibernate.createBlob(file.getInputStream());
            //
            // theaterLayout.setTheaterLayoutImage(blob);

            /** Validate Form */
            if (result.hasErrors())
            {
                if (theaterLayout.getTheaterLayoutId() == null || theaterLayout.getTheaterLayoutId() == 0)
                {

                    return "/theater_layout/theaterLayoutAdd";
                }
                else
                {

                    return "/theater_layout/theaterLayoutEdit";
                }
            }

            if (theaterLayout.getTheaterLayoutId() == null || theaterLayout.getTheaterLayoutId() == 0)
            {

                theaterLayoutResponse = theaterLayoutService.save(theaterLayout);
            }
            else
            {

                theaterLayoutResponse = theaterLayoutService.update(theaterLayout);
            }

            System.out.println("Add theaterLayout update host : " + theaterLayoutResponse.getTheaterLayoutId());
            // modelAndView.addObject(theaterLayoutResponse);

            // redirectAttributes.addFlashAttribute("theaterLayout", theaterLayoutResponse);
        }
        // catch (IOException e) {
        // e.printStackTrace();
        // }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return "redirect:/theater_layout/view/" + theaterLayoutResponse.getTheaterLayoutId();
    }

    @RequestMapping(value = "/edit/{theaterLayoutId}", method = RequestMethod.GET)
    public ModelAndView getEdit(@PathVariable(value = "theaterLayoutId") Integer theaterLayoutId)
    {

        ModelAndView modelAndView = new ModelAndView("/theater_layout/theaterLayoutEdit");
        modelAndView.addObject("theaterLayout", theaterLayoutService.findByID(theaterLayoutId));

        return modelAndView;
    }

    @RequestMapping(value = "/view/{theaterLayoutId}", method = RequestMethod.GET)
    public ModelAndView view(@PathVariable(value = "theaterLayoutId") Integer theaterLayoutId)
    {

        ModelAndView modelAndView = new ModelAndView("/theater_layout/theaterLayoutView");
        modelAndView.addObject("theaterLayout", theaterLayoutService.findByID(theaterLayoutId));

        return modelAndView;
    }

    @RequestMapping("/delete/{theaterLayoutId}")
    public String delete(@PathVariable(value = "theaterLayoutId") Integer theaterLayoutId)
    {

        theaterLayoutService.delete(theaterLayoutId);

        return "redirect:/theater_layout/";
    }
}
