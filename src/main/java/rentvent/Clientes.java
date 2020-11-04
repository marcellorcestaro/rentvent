package rentvent;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Clientes {
    @Id
    @GeneratedValue
    private long id;
	private String nome;
	

    public Clientes() {}

    public Clientes(long id, String nome) {
    	super();
    	this.id = id;
    	this.nome = nome;
    }

    public String getNome() { return nome;}
    public void setNome(String nome) { this.nome = nome;}

	public long getId() { return id;}
	public void setId(long id) { this.id = id;}
}