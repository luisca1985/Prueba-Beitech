package com.example.prueba.model;

import javax.persistence.*;
import lombok.Data;

@Data // Crea todos los métodos getters, setters, equals, hash y toString, en función de los campos.
@Entity(name = "Product") // Prepara este objeto para almacenarlo en un almacén de datos basado en JPA
@Table(name = "\"product\"")
public class Product {
	@Id // Indica que es la clave principal al proveedor JPA
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que se llena automáticamente por el proveedro JPA
	@Column(name = "\"product_id\"") // Indica la información de la columna en la base de datos
	private int productId;
	@Column(name = "\"name\"", length = 191)
	private String name;
	@Column(name = "\"product_description\"", length = 191)
	private String productDescription;
	@Column(name = "\"price\"", precision = 10, scale = 2)
	private double price;
	
	public Product(){}
	
	public Product(String name, String productDescription, double price){
		this.name = name;
		this.productDescription = productDescription;
		this.price = price;
	}
}
