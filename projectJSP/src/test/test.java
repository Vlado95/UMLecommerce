package test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import fitec.dba.dao.IDao;
import fitec.dba.factory.HbnFactory;
import fitec.dba.hbn.HbnDaoAuteur;
import fitec.dba.hbn.HbnDaoLivre;
import fitec.dba.metier.Auteur;
import fitec.dba.metier.Livre;
import fitec.dba.metier.User;
import junit.framework.TestCase;

public class test extends TestCase {

//	private static SessionFactory sessionFactory;
//
//	private static int counter = 0;
//
//	


	@Before
	public void setUp() {
		//System.out.println("setup " + counter)

	}

	@Test
	// @Transactional
	public void test() {
		// System.out.println("Enter Test 1");
//		assertNotNull("Pas de connexion à Hibernate", sessionFactory);
//		System.out.println("Connexion Hibernate OK");
//		Session session = sessionFactory.openSession();
		
		
		HbnFactory hbnFactory = new HbnFactory();
		User user = hbnFactory.authenticate("vendeuse@gmail.com", "mdp");
		
		if ( user != null && ! user.getId().equals(0)){
			System.out.println("User "+user+" CONNECTED !!");
		}else{
			System.err.println("ERROR CONNECTION : "+user);
		}
		
		HbnDaoAuteur daoAuteur = new HbnDaoAuteur();
		
		List<Auteur> auteurs = daoAuteur.selectAll();
		
		for (Auteur auteur : auteurs) {
			System.out.println(auteur);
			//System.out.println(livre.getAuteur().getNom());

		}
		
		HbnDaoLivre daoLivre = new HbnDaoLivre();

//		 Livre liv = (Livre) daoLivre.searchLike("gas");
//		 System.out.println(liv);
		List<Livre> livres = daoLivre.selectAll();

		for (Livre livre : livres) {
			System.out.println(livre);
			//System.out.println(livre.getAuteur().getNom());

		}


	}

}
