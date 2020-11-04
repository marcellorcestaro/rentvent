package rentvent;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Embeddable
public class Enderecos {
    // @Id @GeneratedValue
    // private long id;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;
    
    // private long espacoId;
    
    public Enderecos() {}

    public Enderecos(String cep, String logradouro, String numero, String complemento, String cidade, String uf) {
    	super();
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade; 
        this.uf = uf;
        // this.espacoId = espacoId;
    }

    // public long getId() {
	// 	return id;
	// }

	// public void setId(long id) {
	// 	this.id = id;
	// }

	// public long getEspacoId() {
	// 	return espacoId;
	// }

	// public void setEspacoId(long espacoId) {
	// 	this.espacoId = espacoId;
	// }

	public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    
}
