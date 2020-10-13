package levy.daniel.application.model.persistence.metier.bill.entities.jpa;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import levy.daniel.application.model.metier.customer.impl.Customer;
import levy.daniel.application.model.persistence.metier.lignedevente.entities.jpa.LigneDeVente;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * CLASSE Bill :<br/>
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
@Entity(name = "Bill")
@Table(name="BILLS", schema="PUBLIC"
, uniqueConstraints=@UniqueConstraint(name="UNICITE_CODE_BILL"
, columnNames={"CODE"})
, indexes={@Index(name="INDEX_DATE_BILL", columnList="DATE")})
@FieldDefaults(level=AccessLevel.PRIVATE)
@EqualsAndHashCode(of = {"code"})
@NoArgsConstructor @AllArgsConstructor
@ToString(of = {"id", "code", "date", "customerID"})
@Getter
@Setter 
public class Bill implements Serializable {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ID en base.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	/**
	 * code metier de la facture (Bill).
	 */
	@Column(name="CODE"
			, unique = false, updatable = true
			, insertable = true, nullable = false)
	private String code;

	/**
	 * date de la facture (Bill).
	 */
	@Column(name="DATE"
			, unique = false, updatable = true
			, insertable = true, nullable = false)
	private LocalDateTime date;
	
	
	/**
	 * ID en base du Client (CUSTOMER) lié à la présente facture (Bill).<br/>
	 * Access.WRITE_ONLY pour fonctionner lors de la deserialization
	 * mais ne pas apparaitre lors de la serialization (Object vers JSON).
	 */
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name="CUSTOMER_ID"
			, unique = false, updatable = true
			, insertable = true, nullable = false)
	private Long customerID;
	
	/**
	 * Customer lié à la présente facture.<br/>
	 * Transient pour ne pas être persisté dans le stockage.<br/>
	 */
	@Transient	
	private transient Customer customer;
	
	/**
	 * Collection des lignes de vente composant la présente facture (Bill).
	 */
	@OneToMany(targetEntity=LigneDeVente.class, mappedBy = "bill")
	private Collection<LigneDeVente> lignesDeVente;
	
	
	
	/**
	 * CONSTRUCTEUR MALIN.
	 * 
	 * @param pCode : String : code metier du Bill.
	 * @param pDate : LocalDateTime : date de facturation.
	 * @param pCustomerID : Long : ID dans le stockage du Customer 
	 * lié à la présente Bill. <strong>persisté</strong>
	 * @param pLignesDeVente : Collection&lt;LigneDeVente&gt; : 
	 * Ensemble des lignes de vente contenues dans la présente Bill.
	 */
	public Bill(
			final String pCode
			, final LocalDateTime pDate
			, final Long pCustomerID
			, final Collection<LigneDeVente> pLignesDeVente) {
		
		this(null, pCode, pDate, pCustomerID, null, pLignesDeVente);
		
	} // Fin du CONSTRUCTEUR MALIN.________________________________________
	
	

} // FIN DE LA CLASSE Bill.--------------------------------------------------
