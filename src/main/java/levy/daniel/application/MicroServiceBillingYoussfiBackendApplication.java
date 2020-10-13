package levy.daniel.application;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import levy.daniel.application.model.metier.customer.impl.Customer;
import levy.daniel.application.model.metier.product.impl.Product;
import levy.daniel.application.model.persistence.metier.bill.dao.jpaspring.BillDAO;
import levy.daniel.application.model.persistence.metier.bill.entities.jpa.Bill;
import levy.daniel.application.model.persistence.metier.lignedevente.dao.jpaspring.LigneDeVenteDAO;
import levy.daniel.application.model.persistence.metier.lignedevente.entities.jpa.LigneDeVente;
import levy.daniel.application.model.services.metier.customer.ClientCustomerService;
import levy.daniel.application.model.services.metier.product.ClientProductService;

/**
 * CLASSE MicroServiceBillingYoussfiBackendApplication :<br/>
 * .<br/>
 * <strong>EnableFeignClients</strong> permet de scanner et 
 * d'activer toutes les interfaces qui se déclarent FeignClient 
 * (CLIENT WEB) et qui vont chercher des données 
 * dans d'autres MICRO-SERVICES.<br/>
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
@EnableFeignClients
@SpringBootApplication
public class MicroServiceBillingYoussfiBackendApplication { // NOPMD by dan on 06/10/2020 14:38


	
	/**
	 * Point d'entrée de l'application (Micro-Service).
	 * 
	 * @param pArgs : String[] : paramètres de lancement du Micro-Service.
	 */
	public static void main(final String... pArgs) {
		
		SpringApplication
			.run(MicroServiceBillingYoussfiBackendApplication.class, pArgs);
		
	} // Fin de main(...)._________________________________________________
	
	
	
	/**
	 * méthode appliquée au démarrage du Micro-Service.
	 * 
	 * @param pBillDAO : BillDAO.
	 * @param pLigneDeVenteDAO : LigneDeVenteDAO.
	 * @param pClientCustomerService : ClientCustomerService.
	 * @param pClientProductService : ClientProductService.
	 * 
	 * @return CommandLineRunner.
	 */
	@Bean
	public CommandLineRunner start(
			final BillDAO pBillDAO
				, final LigneDeVenteDAO pLigneDeVenteDAO
					, final ClientCustomerService pClientCustomerService
						, final ClientProductService pClientProductService) {
		
		return args -> {
			
			final Customer client1 = pClientCustomerService.findById(1L);
			final Customer client2 = pClientCustomerService.findById(2L);
			final Customer client3 = pClientCustomerService.findById(3L);
			
			System.out.println();
			System.out.println("****************************");
			System.out.println("client1 : " + client1.toString());
			System.out.println("client2 : " + client2.toString());
			System.out.println("client3 : " + client3.toString());
			System.out.println("****************************");
			System.out.println();
						
			final Product product1 = pClientProductService.findById(1L);
			final Product product2 = pClientProductService.findById(2L);
			final Product product3 = pClientProductService.findById(3L);
			final Product product4 = pClientProductService.findById(4L);
			
			System.out.println();
			System.out.println("**************************");
			System.out.println("product1 : " + product1.toString());
			System.out.println("product2 : " + product2.toString());
			System.out.println("product3 : " + product3.toString());
			System.out.println("product4 : " + product4.toString());
			System.out.println("**************************");
			System.out.println();
						
			final Bill bill1 
				= new Bill("bill1", LocalDateTime.now()
							, client1.getId(), null);
					
			final Bill bill2 
				= new Bill("bill2", LocalDateTime.now()
							, client2.getId(), null);
			
			final Bill bill3 
				= new Bill("bill3", LocalDateTime.now()
						, client1.getId(), null);
			
			pBillDAO.save(bill1);
			pBillDAO.save(bill2);
			pBillDAO.save(bill3);
			
			final LigneDeVente ligneDeVente1Bill1 
				= new LigneDeVente("ligneDeVente1Bill1"
						, product1.getId(), product1.getPrice()
							, 3D, bill1);
			final LigneDeVente ligneDeVente2Bill1 
				= new LigneDeVente("ligneDeVente2Bill1"
						, product3.getId(), product3.getPrice(), 1D, bill1);
			final LigneDeVente ligneDeVente3Bill1 
				= new LigneDeVente("ligneDeVente3Bill1"
						, product4.getId(), product4.getPrice(), 2D, bill1);
			
			pLigneDeVenteDAO.save(ligneDeVente1Bill1);
			pLigneDeVenteDAO.save(ligneDeVente2Bill1);
			pLigneDeVenteDAO.save(ligneDeVente3Bill1);
			
//			lignesDeVente1Bill1.add(ligneDeVente1Bill1);
//			lignesDeVente1Bill1.add(ligneDeVente2Bill1);
//			lignesDeVente1Bill1.add(ligneDeVente3Bill1);
			
//			bill1.setLignesDeVente(lignesDeVente1Bill1);
//			pBillDAO.save(bill1);
			
			final LigneDeVente ligneDeVente1Bill2 
				= new LigneDeVente("ligneDeVente1Bill2"
						, product1.getId(), product1.getPrice(), 7D, bill2);
			final LigneDeVente ligneDeVente2Bill2 
				= new LigneDeVente("ligneDeVente2Bill2"
						, product1.getId(), product1.getPrice(), 3D, bill2);
			final LigneDeVente ligneDeVente3Bill2 
				= new LigneDeVente("ligneDeVente3Bill2"
						, product2.getId(), product2.getPrice(), 1D, bill2);
			final LigneDeVente ligneDeVente4Bill2 
				= new LigneDeVente("ligneDeVente4Bill2"
						, product3.getId(), product3.getPrice(), 1D, bill2);
			
			pLigneDeVenteDAO.save(ligneDeVente1Bill2);
			pLigneDeVenteDAO.save(ligneDeVente2Bill2);
			pLigneDeVenteDAO.save(ligneDeVente3Bill2);
			pLigneDeVenteDAO.save(ligneDeVente4Bill2);
			
			final LigneDeVente ligneDeVente1Bill3 
				= new LigneDeVente("ligneDeVente1Bill3"
					, product1.getId(), product1.getPrice()
						, 3D, bill3);
			final LigneDeVente ligneDeVente2Bill3 
				= new LigneDeVente("ligneDeVente2Bill3"
					, product2.getId(), product2.getPrice(), 1D, bill3);
			
			pLigneDeVenteDAO.save(ligneDeVente1Bill3);
			pLigneDeVenteDAO.save(ligneDeVente2Bill3);
			
//			bill2.setLignesDeVente(lignesDeVente2Bill2);
//			pBillDAO.save(bill2);
			
//			pBillDAO.findAll().forEach(System.out::println);
//			System.out.println();
//			pLigneDeVenteDAO.findAll().forEach(System.out::println);
		};
		
	} // Fin de start(...).________________________________________________
	
	

} // FIN DE LA CLASSE MicroServiceBillingYoussfiBackendApplication.----------
