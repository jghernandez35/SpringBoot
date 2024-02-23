package com.bytecode.core.model;

import java.util.Date;

public class Post {
	private int id;
	private String Descripcion;
	private String uriImg = "http://localhost/img/post4.jpg";
	private Date fecha = new Date();
	private String titulo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getUriImg() {
		return uriImg;
	}
	public void setUriImg(String uriImg) {
		this.uriImg = uriImg;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Post(int id, String descripcion, String uriImg, Date fecha, String titulo) {

		this.id = id;
		this.Descripcion = descripcion;
		this.uriImg = uriImg;
		this.fecha = fecha;
		this.titulo = titulo;
	}
	public Post() {

	}


}
