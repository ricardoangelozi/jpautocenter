package resources.dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import resources.entity.Marca;

public class MarcaDAO extends AbstractDAO<Marca> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<Marca> listar() {
		javax.persistence.Query q = em.createQuery("Select a from Marca a", Marca.class);
		@SuppressWarnings("unchecked")
		List<Marca> marca = q.getResultList();
		return marca;
	}
	
	public void incluir(Marca objeto) {
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
	public void excluir(Marca objeto) {
		// TODO Auto-generated method stub
		
	}

}
