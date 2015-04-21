package resources.dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import resources.entity.Peca_Categoria;

public class PecaCategoriaDAO extends AbstractDAO<Peca_Categoria>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<Peca_Categoria> listar() {
		javax.persistence.Query q = em.createQuery("Select a from Peca_Categoria a", Peca_Categoria.class);
		@SuppressWarnings("unchecked")
		List<Peca_Categoria> peca = q.getResultList();
		return peca;
	}

	@Override
	public void incluir(Peca_Categoria objeto) {
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
	public void excluir(Peca_Categoria objeto) {
		// TODO Auto-generated method stub
		
	}
	
	public Peca_Categoria find(Peca_Categoria objeto){
		Peca_Categoria categoria = em.find(Peca_Categoria.class, objeto.getId());
		return categoria;
	}

}
