package resources.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import resources.entity.Modelo;
import resources.entity.Veiculo;

public class VeiculoDAO extends AbstractDAO<Veiculo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7304210728808264509L;

	@Override
	public List<Veiculo> listar() {
		Query q = em.createQuery("Select p from Veiculo p", Veiculo.class);
		@SuppressWarnings("unchecked")
		List<Veiculo> veiculo = q.getResultList();
		return veiculo;
	}
	
	public Veiculo listar(String placa) {
			Query q = em.createQuery("from Veiculo where placa = :placa");
			q.setParameter("placa", placa.toUpperCase());
			@SuppressWarnings("unchecked")
			
			int tamanho = q.getResultList().size();
			Veiculo  veiculo = null;
			
			if(tamanho > 0){
				veiculo = (Veiculo) q.getResultList().get(0);
			} 
		
			return veiculo;
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
