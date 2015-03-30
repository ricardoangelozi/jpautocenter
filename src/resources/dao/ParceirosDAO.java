package resources.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import resources.entity.Parceiro;

public class ParceirosDAO extends AbstractDAO<Parceiro> {

	private static final long serialVersionUID = -6832558394700303342L;
	
	@Override
	public List<Parceiro> listar() {
		Query q = em.createQuery("Select p from Parceiro p", Parceiro.class);
		@SuppressWarnings("unchecked")
		List<Parceiro> parceiros = q.getResultList();
		return parceiros;
	}

	@Override
	public void incluir(Parceiro objeto) {
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
	public void excluir(Parceiro objeto) {
		// TODO Auto-generated method stub
		
	}

	}
