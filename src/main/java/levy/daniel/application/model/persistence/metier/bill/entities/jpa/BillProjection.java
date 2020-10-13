package levy.daniel.application.model.persistence.metier.bill.entities.jpa;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.data.rest.core.config.Projection;

import levy.daniel.application.model.persistence.metier.lignedevente.entities.jpa.LigneDeVente;

/**
 * INTERFACE BillProjection :<br/>
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
 * @since 6 oct. 2020
 */
@Projection(name = "fullBillProjection", types = Bill.class)
public interface BillProjection {

	
	
	/**
	 * @return ID en base de la Bill : Long.
	 */
	Long getId();

	
	
	/**
	 * @return le code de la Bill : String.
	 */
	String getCode();

	
	
	/**
	 * @return la Date de facturation : LocalDateTime.
	 */
	LocalDateTime getDate();

	
	
	/**
	 * @return l'ID en base du Client de la facture : Long.
	 */
	Long getCustomerID();

	
	
	/**
	 * @return la Collection des lignes de vente : 
	 * Collection&lt;LigneDeVente&gt;.
	 */
	Collection<LigneDeVente> getLignesDeVente();
	

} // FIN DE L'INTERFACE BillProjection.--------------------------------------
