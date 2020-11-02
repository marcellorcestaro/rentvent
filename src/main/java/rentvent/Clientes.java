package rentvent;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Table(name = "clientes")
public class Clientes {
    @Id
    @GeneratedValue
    private long id;
	private String nome;
	
	@OneToOne(cascade = CascadeType.ALL)
    private PessoaFisica pessoaFisica;

    public Clientes() {}

    public Clientes(long id, String nome, PessoaFisica pessoaFisica) {
    	super();
    	this.id = id;
    	this.nome = nome;
    	this.pessoaFisica = pessoaFisica;
    }

    public String getNome() { return nome;}
    public void setNome(String nome) { this.nome = nome;}

	public long getId() { return id;}
	public void setId(long id) { this.id = id;}

	public PessoaFisica getPessoaFisica() { return pessoaFisica;}
	public void setPessoaFisica(PessoaFisica pessoaFisica) { this.pessoaFisica = pessoaFisica;}
}