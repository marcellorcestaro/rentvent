package rentvent;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="espaco")
public class Espaco {
    @Id
    private int id;
    private String nome;
    private int capacidade;
    private double valor_hora;
    private double valor_dia;
    private String disponibilidade;
    private int locadorFuncaoClienteId;
    @Transient
    private Espaco prox;

    public Espaco(){}

    /*
    * Inicializa Espaço sem um próximo
    */
    public Espaco(int id, String n, int c, double vh, double vd, String d, int l){
        this.id = id;
        this.nome = n;
        this.capacidade = c;
        this.valor_hora = vh;
        this.valor_dia = vd;
        this.disponibilidade = d;
        this.locadorFuncaoClienteId = l;
        this.prox = null;
    }


    /*
    * Setters
    */
    public void setDisponibilidade(String disponibilidade) { this.disponibilidade = disponibilidade; }
    public void setProx(Espaco prox) { this.prox = prox; }


    /*
    * Getters
    */
    public int getId() { return id; }
    public Espaco getProx() { return prox; }
    public String getNome() { return nome; }
    public void setNome(String n) { this.nome = n; }
    public String getDisponibilidade() { return disponibilidade; }
    public int getCapacidade() { return capacidade; }
    public void setCapacidade(int c) { this.capacidade = c; }
    public double getValorHora() { return valor_hora; }
    public void setValorHora(double vh) { this.valor_hora = vh; }
    public double getValorDia() { return valor_dia; }
    public void setValorDia(double vd) { this.valor_dia = vd; }
    public int getLocadorFuncaoClienteId() { return locadorFuncaoClienteId; }

    /*
    * Implementa método para imprimir as informações do espaçó.
    */
    public void print(){
        System.out.println("\n\n#### Espaço: "+ this.nome +" ####");
        System.out.println("# ID: " + this.id);
        System.out.println("# Capacidade: " + this.capacidade);
        System.out.println(String.format("# Valor por Hora: %.2f", this.valor_hora));
        System.out.println(String.format("# Valor por Dia: %.2f", this.valor_dia));
        System.out.println("# Disponibilidade: " + this.disponibilidade);
        System.out.println("##################\n");
    }
}
