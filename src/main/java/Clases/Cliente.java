package Clases;

public class Cliente {
  private int id_cliente;
  private String nombre;
  private String apellido;
  private int dni;
  private String email;
  private int estado;

  public Cliente(int id, String nombre, String apellido, int dni, String email, int estado) {
    this.setId_cliente(id);
    this.setNombre(nombre);
    this.setApellido(apellido);
    this.setDni(dni);
    this.setEmail(email);
    this.setEstado(estado);
  }

  public int getId_cliente() {
    return id_cliente;
  }

  public void setId_cliente(int id_cliente) {
    this.id_cliente = id_cliente;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public int getDni() {
    return dni;
  }

  public void setDni(int dni) {
    this.dni = dni;
  }

  public String getEMail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getEstado() {
    return estado;
  }

  public void setEstado(int estado) {
    this.estado = estado;
  }
}
