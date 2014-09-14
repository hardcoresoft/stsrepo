package com.tnc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tnc.dao.TheaterLayoutDao;
import com.tnc.domain.TheaterLayout;

@Service
@Transactional
public class TheaterLayoutServiceImpl implements TheaterLayoutService
{

    @Autowired
    private TheaterLayoutDao theaterLayoutDAO;

    public TheaterLayout findByID(Integer theaterLayoutId)
    {

        return theaterLayoutDAO.get(theaterLayoutId);
    }

    public TheaterLayout save(TheaterLayout theaterLayout)
    {

        return theaterLayoutDAO.saveOrUpdate(theaterLayout);
    }

    public TheaterLayout update(TheaterLayout theaterLayout)
    {

        return theaterLayoutDAO.saveOrUpdate(theaterLayout);
    }

    public List<TheaterLayout> list()
    {

        return theaterLayoutDAO.getAll();
    }

    public void delete(Integer id)
    {

        theaterLayoutDAO.delete(id);
    }

}
