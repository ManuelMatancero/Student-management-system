package com.matancita.web;

import com.matancita.dao.AlumnoDAO;
import com.matancita.domain.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 *
 * @author manue
 */
@WebServlet("/alumnoControlador")
public class ServletControladorAlumno extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "eliminar":
                    this.eliminarAlumno(request, response);
                    break;
                case "modificar":
                    this.modificarAlumno(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "agregar":
                    this.agregarAlumno(request, response);
                    break;
                case "editar":
                    this.editarAlumno(request, response);
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AlumnoDAO alumnoDao = new AlumnoDAO();
        List<Alumno> alumnos = alumnoDao.listarAlumno();

        request.setAttribute("alumnos", alumnos);

        String url = "/WEB-INF/pages/listaAlumnos.jsp";

        request.getRequestDispatcher(url).forward(request, response);

    }

    private void agregarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String noCalle = request.getParameter("noCalle");
        String calle = request.getParameter("calle");
        String pais = request.getParameter("pais");

        AlumnoDAO alumnoDao = new AlumnoDAO();

        Contacto con = new Contacto(telefono, email);
        Domicilio dom = new Domicilio(calle, noCalle, pais);
        Alumno alum = new Alumno(dom, con, nombre, apellido);

        alumnoDao.insertarAlumno(alum);

        this.accionDefault(request, response);
    }

    private void modificarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
        AlumnoDAO alum = new AlumnoDAO();
        Alumno alumno = alum.encontrarAlumnoPorId(new Alumno(idAlumno));

        String nombre = alumno.getNombre();
        String apellido = alumno.getApellido();
        String email = alumno.getContacto().getEmail();
        String telefono = alumno.getContacto().getTelefono();
        String noCalle = alumno.getDomicilio().getNoCalle();
        String calle = alumno.getDomicilio().getCalle();
        String pais = alumno.getDomicilio().getPais();

        request.setAttribute("idAlumno", idAlumno);
        request.setAttribute("nombre", nombre);
        request.setAttribute("apellido", apellido);
        request.setAttribute("email", email);
        request.setAttribute("telefono", telefono);
        request.setAttribute("noCalle", noCalle);
        request.setAttribute("calle", calle);
        request.setAttribute("pais", pais);

        String url = "/WEB-INF/pages/modificarAlumno.jsp";
        request.getRequestDispatcher(url).forward(request, response);

    }

    private void eliminarAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idAlumno = Integer.valueOf(request.getParameter("idAlumno"));
        AlumnoDAO alumnoDao = new AlumnoDAO();
        Alumno alum = alumnoDao.encontrarAlumnoPorId(new Alumno(idAlumno));
        alumnoDao.eliminarAlumno(alum);
        
        this.accionDefault(request, response);
        
    }

    private void editarAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idAlumno = Integer.valueOf(request.getParameter("idAlumno"));
        AlumnoDAO alumnoDao = new AlumnoDAO();
        Alumno alum = alumnoDao.encontrarAlumnoPorId(new Alumno(idAlumno));
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String noCalle = request.getParameter("noCalle");
        String calle = request.getParameter("calle");
        String pais = request.getParameter("pais");
        
        Contacto con = new Contacto(telefono, email);
        Domicilio dom = new Domicilio(calle, noCalle, pais);    
        alum.setNombre(nombre);
        alum.setApellido(apellido);
        alum.setContacto(con);
        alum.setDomicilio(dom);
        
        alumnoDao.modificarAlumno(alum);

        this.accionDefault(request, response);

    }

}
