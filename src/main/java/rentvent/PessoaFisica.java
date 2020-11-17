package rentvent;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Cliente {
    private String cpf;
    private String rg;
    private String dataExpedicao;
    private String orgaoEmissor;

    public PessoaFisica() {}

    /**
     * @param id
     * @param nome
     * @param cpf
     * @param rg
     * @param dataExpedicao
     * @param orgaoEmissor
     */
    public PessoaFisica(long id, String nome, String cpf, String rg, String dataExpedicao, String orgaoEmissor) {
        super(id, nome);
        this.setCpf(cpf);
        this.setRg(rg);
        this.setDataExpedicao(dataExpedicao);
        this.setOrgaoEmissor(orgaoEmissor);
    }

    /**
     * @return the orgaoEmissor
     */
    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    /**
     * @param orgaoEmissor the orgaoEmissor to set
     */
    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    /**
     * @return the dataExpedicao
     */
    public String getDataExpedicao() {
        return dataExpedicao;
    }

    /**
     * @param dataExpedicao the dataExpedicao to set
     */
    public void setDataExpedicao(String dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    

    
}