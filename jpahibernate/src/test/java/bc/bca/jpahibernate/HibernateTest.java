package bc.bca.jpahibernate;

import org.junit.Test;

import bc.bca.jpahibernate.dao.DaoGeneric;
import bc.bca.jpahibernate.model.UsuarioPessoa;
import bc.bca.jpahibernate.model.UsuarioTelefone;
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

	@Test
	public void queryListTest() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		java.util.List<UsuarioPessoa> pessoa = daoGeneric.getEm().createQuery(" from UsuarioPessoa where nome='teste1'")
				.getResultList();

		pessoa.forEach(System.out::println);
	}

	@Test
	public void queryListMaxResultTest() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		java.util.List<UsuarioPessoa> pessoa = daoGeneric.getEm().createQuery(" from UsuarioPessoa order by id")
				.setMaxResults(3).getResultList();

		pessoa.forEach(System.out::println);
	}

	@Test
	public void queryListParameterTest() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		java.util.List<UsuarioPessoa> pessoa = daoGeneric.getEm().createQuery(" from UsuarioPessoa where nome = :nome")
				.setParameter("nome", "teste1").getResultList();

		pessoa.forEach(System.out::println);
	}

	@Test
	public void querySumIDTest() {
		// eu não coloquei o atributo idade, então vou somar os ids mesmo...
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		Long quantidade = (Long) daoGeneric.getEm().createQuery(" select sum(u.id) from UsuarioPessoa u ")
				.getSingleResult();

		System.out.println("Quantidade" + quantidade);

	}

	@Test
	public void namedQuery1Test() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		java.util.List<UsuarioPessoa> pessoa = daoGeneric.getEm().createNamedQuery("UsuarioPessoa.findAll")
				.getResultList();

		pessoa.forEach(System.out::println);
	}

	@Test
	public void namedQuery2Test() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		java.util.List<UsuarioPessoa> pessoa = daoGeneric.getEm().createNamedQuery("UsuarioPessoa.buscaPorNome")
				.setParameter("nome", "teste1").getResultList();

		pessoa.forEach(System.out::println);
	}

	@Test
	public void savePhoneTest() {
		DaoGeneric daoGeneric = new DaoGeneric();

		UsuarioPessoa usuario = (UsuarioPessoa) daoGeneric.consultar(new UsuarioPessoa(3L));
		UsuarioTelefone telefone = new UsuarioTelefone();
		telefone.setTipo("celular");
		telefone.setNumero("9989990877");
		telefone.setUsuario(usuario);
		daoGeneric.salvarAtualizar(telefone);
	}
	
	
	@Test
	public void findPhoneTest() {
		DaoGeneric daoGeneric = new DaoGeneric();

		UsuarioPessoa usuario = (UsuarioPessoa) daoGeneric.consultar(new UsuarioPessoa(1L));
		for (UsuarioTelefone telefone : usuario.getTelefones()) {
			System.out.println(telefone);
		}
	
	
	}
}
