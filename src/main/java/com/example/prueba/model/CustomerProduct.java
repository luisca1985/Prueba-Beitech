package com.example.prueba.model;

// import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "CustomerProduct")
@Table(name = "customer_product")
public class CustomerProduct{
	
	// private static final long serialVersionUID = 1359397122293160199L;

	@EmbeddedId
	private CustomerProductId customerProductId;
	
}
