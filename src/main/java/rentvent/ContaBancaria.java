package rentvent;

import javax.persistence.Embeddable;

@Embeddable
public class ContaBancaria {
    private String banco;
    private String agencia;
    private String conta;


    /**
     * @param banco
     * @param agencia
     * @param conta
     */
    public ContaBancaria(String banco, String agencia, String conta) {
        super();
        this.banco = banco;
        this.agencia = agencia;
        this.conta = conta;
    }

    /**
     * @return the conta
     */
    public String getConta() {
        return conta;
    }

    /**
     * @return the banco
     */
    public String getBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * @return the agencia
     */
    public String getAgencia() {
        return agencia;
    }

    /**
     * @param agencia the agencia to set
     */
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    /**
     * @param conta the conta to set
     */
    public void setConta(String conta) {
        this.conta = conta;
    }

    

    
    
}
