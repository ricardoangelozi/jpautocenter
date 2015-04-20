package resources.dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import resources.entity.Automovel;

public class AutomovelDAO extends AbstractDAO<Automovel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<Automovel> listar() {
		javax.persistence.Query q = em.createQuery("Select a from Automovel a", Automovel.class);
		List<Automovel> automoveis = q.getResultList();
		return automoveis;
	}

	@Override
	public void incluir(Automovel objeto) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(objeto);
		tx.commit();
//		em.close();
		
	}

	@Override
	public void excluir(Automovel objeto) {
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//		em.remove(objeto);
//		tx.commit();
//		em.close();
		
	}


}
