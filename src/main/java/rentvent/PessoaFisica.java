package rentvent;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Clientes{
    private String cpf;
    private String rg;
    private String dataExpedicao;
    private String orgaoEmissor;

    public PessoaFisica() {}

    public PessoaFisica(long id, String nome, String cpf, String rg, String dataExpedicao, String orgaoEmissor) {
        super(id, nome);
        this.cpf = cpf;
        this.rg = rg;
        this.dataExpedicao = dataExpedicao;
        this.orgaoEmissor = orgaoEmissor;
    }

    public String getOrgaoEmissor() { return orgaoEmissor; }
    public void setOrgaoEmissor(String orgaoEmissor) { this.orgaoEmissor = orgaoEmissor;}

    public String getDataExpedicao() { return dataExpedicao; }
    public void setDataExpedicao(String dataExpedicao) { this.dataExpedicao = dataExpedicao; }

    public String getRg() { return rg;}
    public void setRg(String rg) { this.rg = rg;}

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf;}
}