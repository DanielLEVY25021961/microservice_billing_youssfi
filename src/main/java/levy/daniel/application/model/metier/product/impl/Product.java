package levy.daniel.application.model.metier.product.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * CLASSE Product :<br/>
 * .<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author Daniel Lévy
 * @version 1.0
 * @since 4 oct. 2020
 */
@FieldDefaults(level=AccessLevel.PRIVATE)
@EqualsAndHashCode(of = {"code"})
@NoArgsConstructor @AllArgsConstructor
@ToString(of = {"id", "code", "name", "price"})
@Getter
@Setter
public class Product {
	
	/**
	 * ID en base.
	 */
	private Long id;
	
	/**
	 * code metier du Product.
	 */
	private String code;
	
	/**
	 * nom du Product.
	 */
	private String name;
	
	/**
	 * e-mail du Product.
	 */
	private Double price;
	
} // FIN DE LA CLASSE Product.-----------------------------------------------
