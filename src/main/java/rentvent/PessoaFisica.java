package rentvent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica {
    @Id @GeneratedValue(generator = "customForeignGenerator")
    private long id;
    private String cpf;
    private String rg;
    private String dataExpedicao;
    private String orgaoEmissor;


    @OneToOne(mappedBy = "pessoa_fisica")
    @PrimaryKeyJoinColumn
    private Clientes clientes;

    public PessoaFisica() {}

    public PessoaFisica(long id, String cpf, String rg, String dataExpedicao, String orgaoEmissor, Clientes clientes) {
        this.id = id;
        this.setCpf(cpf);
        this.setRg(rg);
        this.setDataExpedicao(dataExpedicao);
        this.setOrgaoEmissor(orgaoEmissor);
        this.clientes = clientes;
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public String getDataExpedicao() {
        return dataExpedicao;
    }

    public void setDataExpedicao(String dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
    

    
}