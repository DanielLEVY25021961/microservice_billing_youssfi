package levy.daniel.application.model.services.metier.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import levy.daniel.application.model.metier.customer.impl.Customer;

/**
 * INTERFACE ClientCustomerService :<br/>
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
@FeignClient(name = "CUSTOMER-SERVICE")
public interface ClientCustomerService {


	
	/**
	 * Retourne un Customer d'ID en stockage pId 
	 * <strong>via le Micro-Service "CUSTOMER-SERVICE"</strong>.
	 * 
	 * @param pId : Long.
	 * 
	 * @return Customer : le client d'ID en stockage pId.
	 */
	@GetMapping("/customers/{id}")
	Customer findById(@PathVariable(name = "id") Long pId);

	
	
	/**
	 * Retourne la liste de tous les Customers dans le stockage 
	 * <strong>via le Micro-Service "CUSTOMER-SERVICE"</strong>.
	 * 
	 * @return org.springframework.hateoas.PagedModel<Customer>
	 */
	@GetMapping("/customers")
	PagedModel<Customer> findAll();
	
	
	
} // FIN DE L'INTERFACE ClientCustomerService.-------------------------------
