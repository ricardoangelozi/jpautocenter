package resources.dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import resources.entity.Cliente;

public class ClienteDAO extends AbstractDAO<Cliente> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7304210728808264509L;

	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void incluir(Cliente objeto) {
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
	public void excluir(Cliente objeto) {
		// TODO Auto-generated method stub
		
	}

	

	}
