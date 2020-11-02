package rentvent;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "clientes")
public class Clientes {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private long pessoaFisica;

    public Clientes() {}

    public Clientes(long id, String nome, long pessoaFisica) {
    	super();
    	this.id = id;
    	this.nome = nome;
    	this.pessoaFisica = pessoaFisica;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(long pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}
}