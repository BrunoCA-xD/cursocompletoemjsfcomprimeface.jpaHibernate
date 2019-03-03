package bc.bca.jpahibernate;

import org.junit.Test;

import bc.bca.jpahibernate.utils.HibernateUtil;

public class HibernateTest {

	
	@Test
	public void HibernateUtilTest() {
		HibernateUtil.getEntityManager();
	}
}
