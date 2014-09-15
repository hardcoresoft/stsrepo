package com.tnc.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tnc.domain.Movie;
import com.tnc.service.MovieService;

@Controller
public class ImageController
{

    // private static final Logger logger = LoggerFactory.getLogger(ImageController.class);
    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/document/{id}", method = RequestMethod.GET)
    public void getDocumentFileContent(final HttpServletResponse response,
            @PathVariable("id") final Integer movieID) throws IOException
    {

        // Retrieves the product image from my database using the JdbcTemplate
        Movie product = (Movie) movieService.findByID(movieID);

        try
        {
            writeFileContentToHttpResponse(product.getMovieImage(), response);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void writeFileContentToHttpResponse(final Blob image,
            final HttpServletResponse response) throws IOException, SQLException
    {

        ServletOutputStream out = response.getOutputStream();
        InputStream in = image.getBinaryStream();
        int lenght = (int) image.length();
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];

        response.setContentType("image/jpeg");
        while ((lenght = in.read(buffer)) != -1)
        {
            out.write(buffer, 0, lenght);
        }
        in.close();
        out.flush();
    }

}
