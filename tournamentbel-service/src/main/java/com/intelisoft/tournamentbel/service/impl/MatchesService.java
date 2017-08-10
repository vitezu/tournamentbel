package com.intelisoft.tournamentbel.service.impl;


import com.intelisoft.tournamentbel.dao.impl.CommandsDaoImpl;
import com.intelisoft.tournamentbel.dao.impl.MatchesDaoImpl;

import com.intelisoft.tournamentbel.dao.util.HibernateUtil;


import com.intelisoft.tournamentbel.entity.*;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import static com.intelisoft.tournamentbel.entity.Periods.NamePeriod.First;
import static com.intelisoft.tournamentbel.entity.Periods.NamePeriod.Second;


/**
 * Created by Pavel on 06.08.2017.
 */
public class MatchesService {

    private final Logger logger =  Logger.getLogger(MatchesService.class);
    MatchesDaoImpl matchesDao = new MatchesDaoImpl();
    public void add (Matches match){
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            matchesDao.save(match, session);
            session.getTransaction().commit();
        }catch  (Exception e){
            logger.error("Error add Matche");
            session.getTransaction().rollback();
        }
    }


}
