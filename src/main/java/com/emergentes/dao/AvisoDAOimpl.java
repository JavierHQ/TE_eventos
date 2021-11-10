package com.emergentes.dao;

import com.emergentes.modelo.Evento;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AvisoDAOimpl extends ConexionBD implements EventoDAO {

    @Override
    public void insert(Evento evento) throws Exception {
        try {
            this.conectar();
            String sql = "insert into seminarios (titulo, expositor, fecha, hora, cupo) values (?,?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, evento.getTitulo());
            ps.setString(2, evento.getExpositor());
            ps.setString(3, evento.getFecha());
            ps.setString(4, evento.getHora());
            ps.setInt(5, evento.getCupo());
            //ejecuta ka consulta
            ps.executeUpdate();
        } catch (Exception e) {
            //throw e;
            System.out.println("Erorrr no esta insertando "+ e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Evento evento) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE seminarios set titulo=?, expositor=?, fecha=?, hora=?, cupo=? where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, evento.getTitulo());
            ps.setString(2, evento.getExpositor());
            ps.setString(3, evento.getFecha());
            ps.setString(4, evento.getHora());
            ps.setInt(5, evento.getCupo());
            ps.setInt(6,evento.getId());
            //ejecuta ka consulta
            ps.executeUpdate();
        } catch (Exception e) {
            //throw e;
            System.out.println("Erorrr no esta Editando "+ e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE from seminarios where id=? ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            //ejecuta ka consulta
            ps.executeUpdate();
        } catch (Exception e) {
            //throw e;
            System.out.println("Erorrr no esta eliminando "+ e);
        } finally {
            this.desconectar();
        }
    }

    @Override     //para obtener un objeto
    public Evento getById(int id) throws Exception {
        Evento eve = new Evento();// creamos un objeto
        try {
            this.conectar();
            String sql = "select * from seminarios where id =?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            //ejecutamos la consulta
            ResultSet rs = ps.executeQuery();//obtenemos el registro

            if (rs.next()) {
                eve.setId(rs.getInt("id"));
                eve.setTitulo(rs.getString("titulo"));
                eve.setExpositor(rs.getString("expositor"));
                eve.setFecha(rs.getString("fecha"));
                eve.setHora(rs.getString("hora"));
                eve.setCupo(rs.getInt("cupo"));
            }

        } catch (Exception e) {
            // e;
            System.out.println("Erorrr no esta reconociendo "+ e);
        } finally {
            this.desconectar();
        }
        return eve;
    }

    @Override
    public List<Evento> getAll() throws Exception {

        List<Evento> lista = null;
        try {
            this.conectar();//conectamos a la base de datos
            String sql="select * from seminarios";
            PreparedStatement  ps =this.conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            lista=new ArrayList<Evento>();
            while(rs.next()){//par ver si hay registros 
                Evento eve=new Evento();
                eve.setId(rs.getInt("id"));
                eve.setTitulo(rs.getString("titulo"));
                eve.setExpositor(rs.getString("expositor"));  
                eve.setFecha(rs.getString("fecha"));
                eve.setHora(rs.getString("hora"));
                eve.setCupo(rs.getInt("cupo"));
                
                //adicionar a la coneccion 
                lista.add(eve);
            }
        } catch (Exception e) {
           // throw e;
            System.out.println("Erorrr no esta sacando la lista "+ e);

        } finally {
            this.desconectar();
        }
        return lista;
    }
}
