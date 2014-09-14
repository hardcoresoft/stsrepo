package com.tnc.service;

import java.util.List;

import com.tnc.domain.TheaterLayout;

public interface TheaterLayoutService
{

    public TheaterLayout findByID(Integer theaterLayoutID);

    public TheaterLayout save(TheaterLayout theaterLayout);

    public TheaterLayout update(TheaterLayout theaterLayout);

    public List<TheaterLayout> list();

    public void delete(Integer id);
}
