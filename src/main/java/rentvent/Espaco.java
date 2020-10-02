package rentvent;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="espaco")
public class Espaco {
    private String nome;
    private int capacidade;
    private double valor_hora;
    private double valor_dia;
    private String disponibilidade;

    public Espaco prox;

    public Espaco(String n, int c, double vh, double vd, String d){
        this.nome = n;
        this.capacidade = c;
        this.valor_hora = vh;
        this.valor_dia = vd;
        this.disponibilidade = d;
        this.prox = null;
    }

    public void setDisponibilidade(String disponibilidade) { this.disponibilidade = disponibilidade; }

    /*
    * Implementa método para imprimir as informações do espaçó.
    */

    public void print(){
        System.out.println("\n\n#### Espaço: "+ this.nome +" ####");
        System.out.println("# Capacidade: " + this.capacidade);
        System.out.println("# Valor por Hora: " + this.valor_hora);
        System.out.println("# Valor por Dia: " + this.valor_dia);
        System.out.println("# Disponibilidade: " + this.disponibilidade);
        System.out.println("###########################################");
    }
}
