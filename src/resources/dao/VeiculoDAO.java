package resources.dao;

import java.util.List;

import javax.persistence.EntityTransaction;

import resources.entity.Veiculo;

public class VeiculoDAO extends AbstractDAO<Veiculo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7304210728808264509L;

	@Override
	public List<Veiculo> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void incluir(Veiculo objeto) {
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
	public void excluir(Veiculo objeto) {
		// TODO Auto-generated method stub
		
	}

	

	}
