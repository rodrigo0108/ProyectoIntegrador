package com.ramos.models;

public class Usuario {

	private int id;
	private String username;
	private String nombres;
	private String apellidos;
	private String correo;
	private String tipo;
	private String telefono;
	private String estado;
	private String imagen;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Usuario(int id, String username, String nombres, String apellidos, String correo, String tipo,
			String telefono, String estado, String imagen) {
		super();
		this.id = id;
		this.username = username;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.tipo = tipo;
		this.telefono = telefono;
		this.estado = estado;
		this.imagen = imagen;
	}
	public Usuario() {
		super();
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", nombres=" + nombres + ", apellidos=" + apellidos
				+ ", correo=" + correo + ", tipo=" + tipo + ", telefono=" + telefono + ", estado=" + estado
				+ ", imagen=" + imagen + "]";
	}
	
	
	
}
