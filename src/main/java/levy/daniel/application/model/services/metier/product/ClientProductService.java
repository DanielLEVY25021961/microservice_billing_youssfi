package levy.daniel.application.model.services.metier.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import levy.daniel.application.model.metier.product.impl.Product;

/**
 * INTERFACE ClientProductService :<br/>
 * Interface <strong>@FeignClient</strong> chargée d'appeler 
 * le MICRO-SERVICE désigné par <strong>name</strong>.<br/>
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
 * @since 6 oct. 2020
 */
@FeignClient(name = "INVENTORY-SERVICE")
public interface ClientProductService {


	
	/**
	 * Retourne un Product d'ID en stockage pId 
	 * <strong>via le Micro-Service "INVENTORY-SERVICE"</strong>.
	 * 
	 * @param pId : Long.
	 * 
	 * @return Product : le produit d'ID en stockage pId.
	 */
	@GetMapping("/products/{id}")
	Product findById(@PathVariable(name = "id") Long pId);


	
	/**
	 * Retourne la liste de tous les Products dans le stockage 
	 * <strong>via le Micro-Service "INVENTORY-SERVICE"</strong>.
	 * 
	 * @return org.springframework.hateoas.PagedModel<Product>
	 */
	@GetMapping("/products")
	PagedModel<Product> findAll();
	
	
	
} // FIN DE L'INTERFACE ClientProductService.--------------------------------
