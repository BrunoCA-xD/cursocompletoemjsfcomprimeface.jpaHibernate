package bc.bca.jpahibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import bc.bca.jpahibernate.utils.HibernateUtil;

public class DaoGeneric<E> {

	private EntityManager em = HibernateUtil.getEntityManager();

	public void salvarAtualizar(E entidade) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.merge(entidade);
		transaction.commit();

	}
	public E consultar(E entidade) {
		Object id = HibernateUtil.getPrimaryKey(entidade);
		E e = (E) em.find(entidade.getClass(), id);
		
		return e;
	}
	
	
	public void deletar(E entidade) {
		Object id = HibernateUtil.getPrimaryKey(entidade);
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.createNativeQuery("delete from " + entidade.getClass().getSimpleName() 
				+ " where id =" +id).executeUpdate();
		transaction.commit();
	}

	public List<E> listar(Class<E> entidade){
		List<E> lst = em.createQuery("from " +entidade.getName()).getResultList();
		
		return lst;
	}
}
