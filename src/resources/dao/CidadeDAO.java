package resources.dao;

import java.util.List;

import resources.entity.Cidade;

public class CidadeDAO extends AbstractDAO<Cidade> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<Cidade> listar() {
		javax.persistence.Query q = em.createQuery("Select a from Cidade a", Cidade.class);
		@SuppressWarnings("unchecked")
		List<Cidade> cidade = q.getResultList();
		return cidade;
	}

	@Override
	public void incluir(Cidade objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Cidade objeto) {
		// TODO Auto-generated method stub
		
	}
	
	public Cidade find(Long id){
		Cidade cidade = em.find(Cidade.class, id);
		return cidade;
		
	}
}
