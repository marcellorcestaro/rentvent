package rentvent;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DadoPagamento {
    @Id @GeneratedValue
    private long id;
    private String titular;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_fisica_id", insertable = false, updatable = false)
    private PessoaFisica pfisica;

    @Column(name = "pessoa_fisica_id")
    private Long pfisicaId;

    public DadoPagamento() {
    }

    public DadoPagamento(long id, String titular) {
        super();
        this.setId(id);
        this.setTitular(titular);
    }

    public Long getPfisicaId(){
        return this.pfisicaId;
    }

    public void setPfisicaId(Long pfisicaId){
        this.pfisicaId = pfisicaId;
    }

    /**
     * @return the titular
     */
    public String getTitular() {
        return titular;
    }

    /**
     * @param titular the titular to set
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

}
