package com.emergentes.dao;

import com.emergentes.modelo.Evento;
import java.util.List;

public interface EventoDAO {
    public void insert (Evento evento) throws Exception;
    public void update (Evento evento) throws Exception;
    public void delete (int id) throws Exception;
    public Evento getById (int id) throws Exception;
    public List<Evento> getAll() throws Exception;
}
