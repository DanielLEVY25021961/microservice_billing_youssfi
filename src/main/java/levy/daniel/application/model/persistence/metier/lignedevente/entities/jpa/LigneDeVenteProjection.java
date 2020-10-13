package levy.daniel.application.model.persistence.metier.lignedevente.entities.jpa;

import org.springframework.data.rest.core.config.Projection;

import levy.daniel.application.model.persistence.metier.bill.entities.jpa.Bill;

/**
 * INTERFACE LigneDeVenteProjection :<br/>
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
@Projection(name = "fullLigneDeVenteProjection", types = {LigneDeVente.class, Bill.class})
public interface LigneDeVenteProjection {

	
	
	/**
	 * @return ID en base de la LigneDeVente : Long.
	 */
	Long getId();

	
	
	/**
	 * @return le code de la LigneDeVente : String.
	 */
	String getCode();
	
	
	
	/**
	 * @return l'ID stockage du Product concerné par la LigneDeVente : Long.
	 */
	Long getProductID();
	

	
	/**
	 * @return le prix du Product concerné par la LigneDeVente : Double.
	 */
	Double getPrix();
	
	
	
	/**
	 * @return la quantity du Product concerné par la LigneDeVente : Double.
	 */
	Double getQuantity();

	
	
	/**
	 * @return la facture (Bill) contenant la présente ligne de vente.
	 */
	Bill getBill();
	
	

} // FIN DE L'INTERFACE LigneDeVenteProjection.------------------------------
