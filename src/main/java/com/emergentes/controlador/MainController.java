
package com.emergentes.controlador;

import com.emergentes.dao.AvisoDAOimpl;
import com.emergentes.modelo.Evento;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.dao.EventoDAO;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            EventoDAO dao=new AvisoDAOimpl();
            
            int id;
          
            Evento eve=new Evento();
            
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    
                    request.setAttribute("evento", eve);
                    request.getRequestDispatcher("frmEvento.jsp").forward(request,response);
                    break;
                case "edit":
                  
                    id= Integer.parseInt(request.getParameter("id"));
                    eve=dao.getById(id);
                    request.setAttribute("evento", eve);
                    request.getRequestDispatcher("frmEvento.jsp").forward(request,response);
                    break;
                case "delete":
                    
                    id=Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    request.getRequestDispatcher("MainController").forward(request,response);
                    break;
                default:
                   
                    List<Evento> lista=dao.getAll();
                    request.setAttribute("eventos",lista); 
                    request.getRequestDispatcher("listadoEvento.jsp").forward(request,response);
                    break;

            }
        } catch (Exception e) {
            System.out.print("GRAVE HERROR EN EL DO GET" + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        EventoDAO dao=new AvisoDAOimpl();
        
        int id=Integer.parseInt(request.getParameter("id"));
        String titulo=request.getParameter("titulo");
        String expositor=request.getParameter("expositor");
        String fecha=request.getParameter("fecha");
        String hora=request.getParameter("hora");
        int cupo=Integer.parseInt(request.getParameter("cupo"));
        
       Evento eve= new Evento();
        
        eve.setId(id);
        eve.setTitulo(titulo);
        eve.setExpositor(expositor);
        eve.setFecha(fecha);
        eve.setHora(hora);
        eve.setCupo(cupo);
        
        
        if(id == 0){
            try {
                
                dao.insert(eve);
                response.sendRedirect("MainController");
            } catch (Exception ex) {
                //Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Errorrr ojojojoj "+ex.getMessage());
            }  
        }else{
            
            try {
                
                dao.update(eve);
                response.sendRedirect("MainController");
            } catch (Exception ex) {
                //Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Errorrr ojojoj"+ex.getMessage());
            }
            //response.sendRedirect("MainController");  
        }
       
    }    
}
