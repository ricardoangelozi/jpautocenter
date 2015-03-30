package resources.dao;



import java.io.Serializable;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpautocenter");

	public EntityManager  getEntityManager() throws SQLException {
		
		return emf.createEntityManager(); 
	}
}
