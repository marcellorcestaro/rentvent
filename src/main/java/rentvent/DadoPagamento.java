package rentvent;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dados_pagamento")
public class DadoPagamento {
    @Id @GeneratedValue
    private long id;
    private String titular;

    @Embedded
    private CartaoCredito cartaoCredito;
    @Embedded
    private ContaBancaria contaBancaria;

    /**
     * @param id
     * @param titular
     * @param cartaoCredito
     * @param contaBancaria
     */
    public DadoPagamento(long id, String titular, CartaoCredito cartaoCredito, ContaBancaria contaBancaria) {
        this.setId(id);
        this.setTitular(titular);
        this.setCartaoCredito(cartaoCredito);
        this.setContaBancaria(contaBancaria);
    }

    /**
     * @return the contaBancaria
     */
    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    /**
     * @param contaBancaria the contaBancaria to set
     */
    public void setContaBancaria(ContaBancaria contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    /**
     * @return the cartaoCredito
     */
    public CartaoCredito getCartaoCredito() {
        return cartaoCredito;
    }

    /**
     * @param cartaoCredito the cartaoCredito to set
     */
    public void setCartaoCredito(CartaoCredito cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
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
