package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
  Connection conexion = null;

  public ClientDAO() throws ClassNotFoundException {
    Conexion con = new Conexion();
    conexion = con.getConnection();
  }

  public List<Cliente> listClients() {
    PreparedStatement ps;
    ResultSet rs;
    List<Cliente> list = new ArrayList<>();

    try {
      ps = conexion.prepareStatement("SELECT * FROM cliente");
      rs = ps.executeQuery();

      while (rs.next()) {
        int id = rs.getInt("id_cliente");
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        int dni = rs.getInt("dni");
        String email = rs.getString("email");
        int estado = rs.getInt("estado");
        Cliente cliente = new Cliente(id, nombre, apellido, dni, email, estado);
        list.add(cliente);
      }
      return list;
    } catch (SQLException e) {
      System.out.println("Error de Conexion");
      return null;
    }
  }

  public boolean insertClient(Cliente cliente) {
    PreparedStatement ps;

    try {
      ps = conexion.prepareStatement("insert into cliente (nombre,apellido,dni,email,estado) values(?,?,?,?,?)");
      //ps.setString(0, null);
      ps.setString(1, cliente.getNombre());
      ps.setString(2, cliente.getApellido());
      ps.setInt(3, cliente.getDni());
      ps.setString(4, cliente.getEMail());
      ps.setInt(5, cliente.getEstado());
      ps.execute();
      return true;
    } catch (SQLException e) {
      System.out.println("Error al insertar cliente");
      return false;
    }
  }

  public boolean actualizarCliente(Cliente cliente) {
    PreparedStatement ps;
    try {
      ps = conexion.prepareStatement("update cliente set nombre=? ,apellido=?,dni=?,email=?,estado=? where id_socio=?");
      ps.setString(1, cliente.getNombre());
      ps.setString(2, cliente.getApellido());
      ps.setInt(3, cliente.getDni());
      ps.setString(4, cliente.getEMail());
      ps.setInt(5, cliente.getEstado());
      ps.setInt(6, cliente.getId_cliente());
      ps.execute();
      return true;
    } catch (SQLException e) {
      System.out.println("Error al insertar cliente");
      return false;
    }
  }

  public boolean eliminarCliente(int _id) {
    PreparedStatement ps;
    try {
      ps = conexion.prepareStatement("delete from cliente where id_cliente=?");
      ps.setInt(1, _id);
      ps.execute();
      return true;
    } catch (SQLException e) {
      System.out.println("Error al insertar cliente");
      return false;
    }
  }

  public Cliente mostrarCliente(int _id) {
    PreparedStatement ps;
    ResultSet rs;
    Cliente socio = null;

    try {
      ps = conexion.prepareStatement("select * from cliente where id_cliente=?");
      ps.setInt(1, _id);
      rs = ps.executeQuery();
      while (rs.next()) {
        int id = rs.getInt("id_cliente");
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        int dni = rs.getInt("dni");
        String email = rs.getString("email");
        int estado = rs.getInt("estado");
        socio = new Cliente(id, nombre, apellido, dni, email, estado);
      }
      return socio;
    } catch (SQLException e) {
      System.out.println("Error al insertar cliente");
      return null;
    }
  }
}
