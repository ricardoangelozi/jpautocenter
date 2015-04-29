package resources.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import resources.entity.Cliente;
import resources.entity.Modelo;
import resources.entity.Servico;

public class ServicoDAO extends AbstractDAO<Servico> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7169259076450062745L;

	@Override
	public List<Servico> listar() {
		Query q = em.createQuery("Select p from Servico p", Servico.class);
		@SuppressWarnings("unchecked")
		List<Servico> servico = q.getResultList();
		return servico;
	}

	@Override
	public void incluir(Servico servico) {
		try{
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.persist(servico);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(Servico servico) {
		// TODO Auto-generated method stub
		
	}

}
