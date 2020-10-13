package levy.daniel.application.model.persistence.metier.lignedevente.entities.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import levy.daniel.application.model.metier.product.impl.Product;
import levy.daniel.application.model.persistence.metier.bill.entities.jpa.Bill;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * CLASSE LigneDeVente :<br/>
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
@Entity(name = "LigneDeVente")
@Table(name="LIGNESDEVENTE", schema="PUBLIC"
, uniqueConstraints=@UniqueConstraint(name="UNICITE_CODE_LIGNEDEVENTE"
, columnNames={"CODE"})
, indexes={@Index(name="INDEX_PRODUCT_ID_LIGNEDEVENTE", columnList="PRODUCT_ID")})
@FieldDefaults(level=AccessLevel.PRIVATE)
@EqualsAndHashCode(of = {"code"})
@NoArgsConstructor @AllArgsConstructor
@ToString(of = {"id", "code", "productID", "prix", "quantity"})
@Getter
@Setter 
public class LigneDeVente implements Serializable {

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
	 * code metier de la présente ligne de vente (LigneDeVente).
	 */
	@Column(name="CODE"
			, unique = false, updatable = true
			, insertable = true, nullable = false)
	private String code;

	/**
	 * ID en base du Produit (PRODUCT) lié à la présente 
	 * ligne de vente (LigneDeVente).<br/>
	 * Access.WRITE_ONLY pour fonctionner lors de la deserialization
	 * mais ne pas apparaitre lors de la serialization (Object vers JSON). 
	 */
	@Column(name="PRODUCT_ID"
			, unique = false, updatable = true
			, insertable = true, nullable = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long productID;
	
	/**
	 * Produit (PRODUCT) lié à la présente ligne de vente (LigneDeVente).<br/> 
	 * Transient car non persisté en base.<br/>
	 */
	@Transient	
	private transient Product product;
	
	/**
	 * Prix du Produit (PRODUCT) lié à la présente 
	 * ligne de vente (LigneDeVente).<br/>
	 * A priori identique au prix (price) dans le Product, 
	 * mais peut parfois différer (en cas de remise, ...).
	 */
	@Column(name="PRIX"
			, unique = false, updatable = true
			, insertable = true, nullable = false)
	private Double prix;
	
	/**
	 * Quantité du Produit (PRODUCT) lié à la présente 
	 * ligne de vente (LigneDeVente).<br/>
	 */
	@Column(name="QUANTITY"
			, unique = false, updatable = true
			, insertable = true, nullable = false)
	private Double quantity;
	
	/**
	 * Facture (Bill) concernant la présente ligne de vente.<br/>
	 * ATTENTION : référence CIRCULAIRE avec 
	 * la Collection&lt;LigneDeVente&gt; dans Bill.<br/>
	 * Access.WRITE_ONLY pour fonctionner lors de la deserialization
	 * mais ne pas apparaitre lors de la serialization (Object vers JSON).
	 */
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = Bill.class)
	@JoinTable(name = "BILLS_LIGNESDEVENTE",
    joinColumns = @JoinColumn(name = "ID_LIGNEDEVENTE"),
    inverseJoinColumns = @JoinColumn(name = "ID_BILL"))
	private Bill bill;
	

	
	/**
	 * CONSTRUCTEUR MALIN.
	 * 
	 * @param pCode : String : Code metier de la ligne de vente.
	 * @param pProductID : Long : ID en stockage du 
	 * Product concerné par la présente LigneDeVente. 
	 * <strong>Persisté</strong>.
	 * @param pPrix : Double : Prix du Product concerné 
	 * par la présente LigneDeVente.
	 * @param pQuantity : Double : Quantité de Product concerné 
	 * par la présente LigneDeVente.
	 * @param pBill : Bill : Facture contenant la présente LigneDeVente.
	 */
	public LigneDeVente(
			final String pCode
			, final Long pProductID
			, final Double pPrix
			, final Double pQuantity
			, final Bill pBill) {
		
		this(null, pCode, pProductID, null, pPrix, pQuantity, pBill);
		
	} // Fin du CONSTRUCTEUR MALIN.________________________________________
	
	
	
} // FIN DE LA CLASSE LigneDeVente.------------------------------------------
