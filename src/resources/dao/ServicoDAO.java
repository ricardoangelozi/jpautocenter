package resources.dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import resources.entity.Cliente;
import resources.entity.Servico;

public class ServicoDAO extends AbstractDAO<Servico> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7169259076450062745L;

	@Override
	public List<Servico> listar() {
		// TODO Auto-generated method stub
		return null;
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
