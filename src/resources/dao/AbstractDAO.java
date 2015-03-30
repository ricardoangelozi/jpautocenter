package resources.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

public abstract class AbstractDAO<T> extends JPAUtil {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	EntityManager em;

	public AbstractDAO() {
		try {
			em = getEntityManager();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public abstract List<T> listar();

	public abstract void incluir(T objeto);
	
	public abstract void excluir(T objeto);

}
