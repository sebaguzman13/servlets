package Clases;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/ClienteController")
public class ClienteController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ClienteController() {
    super();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String accion = null;

    ClientDAO clientDAO = null;
    try {
      clientDAO = new ClientDAO();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    RequestDispatcher dispatcher = null;
    accion = request.getParameter("accion");

    if (accion == null || accion.isEmpty()) {
      dispatcher = request.getRequestDispatcher("Vistas/cliente.jsp");
    } else if (accion.equals("modificar")) {
      dispatcher = request.getRequestDispatcher("Vistas/modificar.jsp");
    } else if (accion.equals("actualizar")) {
      int id = Integer.parseInt(request.getParameter("id"));
      String nombre = request.getParameter("nombre");
      String apellido = request.getParameter("apellido");
      int dni = Integer.parseInt(request.getParameter("dni"));
      String email = request.getParameter("email");
      Cliente socio = new Cliente(id, nombre, apellido, dni, email, 1);
      clientDAO.actualizarCliente(socio);

      dispatcher = request.getRequestDispatcher("Vistas/cliente.jsp");
    } else if (accion.equals("eliminar")) {
      int id = Integer.parseInt(request.getParameter("id"));
      clientDAO.eliminarCliente(id);
      dispatcher = request.getRequestDispatcher("Vistas/cliente.jsp");
    } else if (accion.equals("nuevo")) {
      dispatcher = request.getRequestDispatcher("Vistas/nuevo.jsp");
    } else if (accion.equals("insert")) {

      String nombre = request.getParameter("nombre");
      String apellido = request.getParameter("apellido");
      int dni = Integer.parseInt(request.getParameter("dni"));
      String mail = request.getParameter("mail");
      Cliente socio = new Cliente(0, nombre, apellido, dni, mail, 1);
      clientDAO.insertClient(socio);
      dispatcher = request.getRequestDispatcher("Vistas/cliente.jsp");
    }


    dispatcher.forward(request, response);

  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    doGet(request, response);
  }

}
