package levy.daniel.application.model.metier.customer.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * CLASSE Customer :<br/>
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
@ToString(of = {"id", "code", "name", "email"})
@Getter
@Setter
public class Customer {

	
	/**
	 * ID en base.
	 */
	private Long id;
	
	/**
	 * code metier du Customer.
	 */
	private String code;
	
	/**
	 * nom du Customer.
	 */
	private String name;
	
	/**
	 * e-mail du Customer.
	 */
	private String email;
	
	

} // FIN DE LA CLASSE Customer.----------------------------------------------
