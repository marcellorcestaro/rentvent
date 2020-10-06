package rentvent;

import java.text.Format;
import java.util.Scanner;

import org.graalvm.compiler.phases.graph.ScheduledNodeIterator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class Administrador implements CommandLineRunner {
    @Autowired
    private EspacoRepo espacoRepo;

    public static void main(String[] args) {
        SpringApplication.run(Locador.class, args);
    }

    @Override
    public void run(String... args) {
        
        FilaLista lista = this.inicializarEspacos();
        boolean sair = false;

        Scanner scn = new Scanner(System.in);
        while(!sair){
            System.out.println("\n##### PAINEL DO ADMINISTRADOR #####");
            System.out.println("(1) Listar espaços a serem aprovados");
            System.out.println("(2) Aprovar espaço");
            System.out.println("(3) Reprovar espaço");
            System.out.println("(0) Sair do programa");
            System.out.print("\n## Escolha sua opção: ");
            int opc = scn.nextInt();
            switch(opc){
                case 1: listarEspacos(lista);; break;
                case 2: aprovarEspaco(lista); break;
                case 3: reprovarEspaco(lista); break;
                case 0: sair = true; break;
                default: System.out.println("\n## Opção inválida.");
            }
        }
        System.out.println("\n\n##### FIM DO PROGRAMA #####");
    }

    

    private void reprovarEspaco(FilaLista lista) {
        if(!lista.vazio()){
            Espaco comeco = lista.getInicio();
            comeco.print();
            Scanner scn = new Scanner(System.in);
            System.out.print("Você tem certeza que quer reprovar este espaço?\n(1) Sim\n(2) Não\nResposta: ");
            int opc = scn.nextInt();
            switch(opc){
                case 1:
                    comeco.setDisponibilidade("REPROVADO");
                    espacoRepo.save(comeco);
                    lista.deletar();
                    System.out.println("\n# Espaço reprovado!");
                    break;
                case 2: System.out.println("\n# Operação cancelada!"); break;
                default: System.out.println("\n# Opção inválida. Operação cancelada."); break;
            }
        }
        else {
            System.out.println("\n## Não há espaços para reprovar.");
        }
    }

    private void aprovarEspaco(FilaLista lista) {
        if(!lista.vazio()){
            Espaco comeco = lista.getInicio();
            comeco.print();
            Scanner scn = new Scanner(System.in);
            System.out.print("Você tem certeza que quer aprovar este espaço?\n(1) Sim\n(2) Não\nResposta: ");
            int opc = scn.nextInt();
            switch(opc){
                case 1:
                    comeco.setDisponibilidade("APROVADO");
                    espacoRepo.save(comeco);
                    lista.deletar();
                    System.out.println("\n# Espaço aprovado!");
                    break;
                case 2: System.out.println("\n# Operação cancelada!"); break;
                default: System.out.println("\n# Opção inválida. Operação cancelada."); break;
            }
        }
        else {
            System.out.println("\n## Não há espaços para aprovar.");
        }
    }

    private void listarEspacos(FilaLista fila) {
        if(!fila.vazio()){
            fila.imprimir();
        }
        else {
            System.out.println("\n## Não há espaços cadastrados.");
        }
    }

    public FilaLista inicializarEspacos(){
        FilaLista fila = new FilaLista();
        System.out.print("Adicionando espaços a serem analisados ...");
        Iterable<Espaco> espacos = espacoRepo.findAll();
        for(Espaco e: espacos){
            if(e.getDisponibilidade().equals("A APROVAR")){
                fila.inserir(e);
            }
            System.out.print(".");
        }
        System.out.print(" Completado!\n");
        return fila;
    }
}
