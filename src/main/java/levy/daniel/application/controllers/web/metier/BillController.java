package levy.daniel.application.controllers.web.metier;

import java.util.Collection;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import levy.daniel.application.model.metier.customer.impl.Customer;
import levy.daniel.application.model.metier.product.impl.Product;
import levy.daniel.application.model.persistence.metier.bill.dao.jpaspring.BillDAO;
import levy.daniel.application.model.persistence.metier.bill.entities.jpa.Bill;
import levy.daniel.application.model.persistence.metier.lignedevente.entities.jpa.LigneDeVente;
import levy.daniel.application.model.services.metier.customer.ClientCustomerService;
import levy.daniel.application.model.services.metier.product.ClientProductService;



/**
 * CLASSE BillController :<br/>
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
 * @since 7 oct. 2020
 */
@RestController(value="BillController")
@RequestMapping(value="/app/fullBills/")
public class BillController {
	
	// ************************ATTRIBUTS************************************/

	/**
	 * DAO pour les Bill.
	 */
	@Autowired
	private transient BillDAO billDAO;
	
	/**
	 * Client Feign pour le Micro-Service CUSTOMER-SERVICE.
	 */
	@Autowired
	private transient ClientCustomerService clientCustomerService;
	
	/**
	 * Client Feign pour le Micro-Service INVENTORY-SERVICE.
	 */
	@Autowired
	private transient ClientProductService clientProductService;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(BillController.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.
	 */
	public BillController() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	/**
	 * 
	 * @param pId : Long : ID stockage de la Bill
	 * 
	 * @return Bill : la Bill complétée par les informations 
	 * provenant des Micro-Services metier.
	 */
	@GetMapping("{id}")
	public Bill findById(@PathVariable(name = "id") final Long pId) {
		
		final Optional<Bill> billOptional = this.billDAO.findById(pId);
		
		Bill bill = null;
		
		if (billOptional.isPresent()) {
			
			bill = billOptional.get();
			
			final Customer client 
				= this.clientCustomerService.findById(bill.getCustomerID());
			
			bill.setCustomer(client);
			
			final Collection<LigneDeVente> lignes = bill.getLignesDeVente();
			
			for (final LigneDeVente ligne : lignes) {
				
				final Product produit 
					= this.clientProductService.findById(ligne.getProductID());
				
				ligne.setProduct(produit);
			}
			
		}
				
		return bill;
		
	} // Fin de findById(...)._____________________________________________
	
	

} // FIN DE LA CLASSE BillController.----------------------------------------
