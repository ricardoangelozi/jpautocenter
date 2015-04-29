package resources.dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import resources.entity.Cidade;
import resources.entity.Peca;

public class PecaDAO extends AbstractDAO<Peca> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<Peca> listar() {
		javax.persistence.Query q = em.createQuery("Select a from Peca a", Peca.class);
		@SuppressWarnings("unchecked")
		List<Peca> peca = q.getResultList();
		return peca;
	}

	@Override
	public void incluir(Peca objeto) {
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.persist(objeto);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(Peca objeto) {
		// TODO Auto-generated method stub
		
	}

}
