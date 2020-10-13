package levy.daniel.application.model.persistence.metier.lignedevente.dao.jpaspring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import levy.daniel.application.model.persistence.metier.lignedevente.entities.jpa.LigneDeVente;

/**
 * INTERFACE LigneDeVenteDAO :<br/>
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
@RepositoryRestResource
public interface LigneDeVenteDAO extends JpaRepository<LigneDeVente, Long> {

} // FIN DE L'INTERFACE LigneDeVenteDAO.-------------------------------------
