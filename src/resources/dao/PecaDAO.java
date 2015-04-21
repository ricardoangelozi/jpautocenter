package resources.dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import resources.entity.Peca;

public class PecaDAO extends AbstractDAO<Peca> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<Peca> listar() {
		// TODO Auto-generated method stub
		return null;
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
