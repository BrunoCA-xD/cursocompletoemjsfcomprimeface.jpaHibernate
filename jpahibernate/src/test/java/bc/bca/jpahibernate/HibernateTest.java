package bc.bca.jpahibernate;

import org.junit.Test;

import bc.bca.jpahibernate.dao.DaoGeneric;
import bc.bca.jpahibernate.model.UsuarioPessoa;
import bc.bca.jpahibernate.utils.HibernateUtil;

public class HibernateTest {

	@Test
	public void HibernateUtilTest() {
		HibernateUtil.getEntityManager();
	}

	@Test
	public void insertTest() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setLogin("admin");
		pessoa.setSenha("admin");
		pessoa.setNome("teste1");
		pessoa.setSobrenome("teste sobrenome");
		pessoa.setEmail("teste@email.com");

		daoGeneric.salvarAtualizar(pessoa);

	}
	@Test
	public void updateTest() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();

		UsuarioPessoa pessoa = daoGeneric.consultar(new UsuarioPessoa(1L));
		pessoa.setLogin("asd");
		pessoa.setSenha("2223");
		pessoa.setNome("asd1");
		pessoa.setSobrenome("das sobrenome");
		pessoa.setEmail("aaasd@haha.com");

		daoGeneric.salvarAtualizar(pessoa);

	}
	@Test
	public void findTest() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
	
		System.out.println(daoGeneric.consultar(new UsuarioPessoa(2L)));
	}
	
	@Test
	public void deleteTest() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa = daoGeneric.consultar(new UsuarioPessoa(2L));
		daoGeneric.deletar(pessoa);
	}
	
	@Test
	public void List() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		java.util.List<UsuarioPessoa> pessoa = daoGeneric.listar(UsuarioPessoa.class);
		
		pessoa.forEach(System.out::println);
	}
	
}
