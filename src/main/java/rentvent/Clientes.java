package rentvent;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "clientes")
public class Clientes {
	@Id
	@GeneratedValue
	private long id;
	private String nome;

	@OneToOne
	@PrimaryKeyJoinColumn
	private PessoaFisica pessoaFisica;

	public Clientes() {}
	
	public Clientes(long id, String nome, PessoaFisica pessoaFisica) {
		this.id = id;
		this.setNome(nome);	
		this.pessoaFisica = pessoaFisica;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

    
}