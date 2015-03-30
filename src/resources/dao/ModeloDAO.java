package resources.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import resources.entity.Marca;
import resources.entity.Modelo;

public class ModeloDAO extends AbstractDAO<Modelo> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<Modelo> listar() {
		Query q = em.createQuery("Select p from Modelo p", Modelo.class);
		@SuppressWarnings("unchecked")
		List<Modelo> modelo = q.getResultList();
		return modelo;
	}

	@Override
	public void incluir(Modelo objeto) {
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.persist(objeto);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Marca find(Marca objeto){
		Marca marcaRetorno = em.find(Marca.class, objeto.getId());
		return marcaRetorno;
	}

	@Override
	public void excluir(Modelo objeto) {
		// TODO Auto-generated method stub
		
	}

}
