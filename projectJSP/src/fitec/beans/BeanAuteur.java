package fitec.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fitec.dba.dao.DaoAuteur;
import fitec.dba.dao.IDao;
import fitec.dba.factory.HbnFactory;
import fitec.dba.hbn.HbnDaoAuteur;
import fitec.dba.metier.Auteur;

@ManagedBean
@SessionScoped
public class BeanAuteur implements Serializable {

	private static final long serialVersionUID = 7015452538909188762L;

	public BeanAuteur() {
	}

	private String like;

	public String getLike() {
		return like;
	}

	public void setLike(String like) {
		this.like = like;
	}

	public List<Auteur> getAllAuteurs() {
		List<Auteur> Auteurs = new ArrayList<Auteur>();
		
		HbnDaoAuteur daoAuteur = new HbnDaoAuteur();

		List<Auteur> auteurs = daoAuteur.selectAll();
		return auteurs;
	}

}
