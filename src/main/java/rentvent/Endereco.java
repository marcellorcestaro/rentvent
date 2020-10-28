package rentvent;

import javax.persistence.Id;

public class Endereco {
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;
    @Id
    private int espacoId;

    public Endereco(String cep, String logradouro, String numero, String complemento, String cidade, String uf,
            int espacoId) {
        this.setCep(cep);
        this.setLogradouro(logradouro);
        this.setNumero(numero);
        this.setComplemento(complemento);
        this.setCidade(cidade);
        this.setUf(uf);
        this.espacoId = espacoId;
    }

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
