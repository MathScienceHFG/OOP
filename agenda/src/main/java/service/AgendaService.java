package service;

import dao.AgendaDao;
import model.Agenda;
import model.User;

import java.util.List;

public class AgendaService {
    private AgendaDao agendaDao = AgendaDao.getInstance();

    public void addAgenda(Agenda agenda){
        this.agendaDao.addAgenda(agenda);
    }



}
