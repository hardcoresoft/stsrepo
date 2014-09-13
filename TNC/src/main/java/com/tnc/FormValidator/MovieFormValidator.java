package com.tnc.FormValidator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tnc.domain.Movie;

@Component("movieFormValidator") 
public class MovieFormValidator implements Validator
{

    @Override
    public boolean supports(Class<?> clazz)
    {
        return Movie.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object model, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "movieCode","required.movieCode", "code is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "movieNameTh","required.movieNameTh", "thai name is required.");
    }

}
