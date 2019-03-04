package bc.bca.jpahibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UsuarioTelefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String tipo;

	@Column(nullable = false)
	private String numero;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private UsuarioPessoa usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public UsuarioPessoa getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioPessoa usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "UsuarioTelefone [id=" + id + ", tipo=" + tipo + ", numero=" + numero + ", usuario=" + usuario + "]";
	}
	
	
	

}