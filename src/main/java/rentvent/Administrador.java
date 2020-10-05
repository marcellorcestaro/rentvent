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
        SpringApplication.run(Administrador.class, args);
    }

    @Override
    public void run(String... args) {
        
        FilaLista lista = this.inicializarEspacos();
        boolean sair = false;

        Scanner scn = new Scanner(System.in);
        while(!sair){
            System.out.println("\n##### PAINEL DO ADMINISTRADOR #####");
            System.out.println("(1) Listar todos os espaços");
            System.out.println("(2) Aprovar espaço");
            System.out.println("(3) Reprovar espaço");
            System.out.println("(4) Excluir espaço");
            System.out.println("(0) Sair do programa");
            System.out.print("\n\n## Escolha sua opção: ");
            int opc = scn.nextInt();
            switch(opc){
                case 1: listarEspacos(lista);; break;
                case 2: aprovarEspaco(lista); break;
                case 3: reprovarEspaco(lista); break;
                case 4: excluirEspaco(lista); break;
                case 0: sair = true; break;
                default: System.out.println("\n## Opção inválida.");
            }
        }
        System.out.println("\n\n##### FIM DO PROGRAMA #####");
    }

    private void excluirEspaco(FilaLista lista) {
        if(!lista.vazio()){
            Espaco aux = lista.getInicio();
            Scanner scan = new Scanner(System.in);
            System.out.println("\n# Digite o número de identificação (ID) do espaço a ser excluído: ");
            int id = scan.nextInt();
            while(aux != null) {
                if(aux.getId() == id) {
                    if(aux.getDisponibilidade() != "APROVADO"){
                        espacoRepo.delete(aux);
                        System.out.println("\n## Espaço excluido!");
                        aux = null;
                    }
                    else{
                        System.out.println("\n## Não é possível excluir espaços que já foram aprovados.");
                        aux = null;
                    }
                }
                else{
                    aux = aux.getProx();
                }
                
            }
        }
        else {
            System.out.println("\n## Não há espaços para excluir.");
        }
    }

    private void reprovarEspaco(FilaLista lista) {
        if(!lista.vazio()){
            Espaco aux = lista.getInicio();
            Scanner scan = new Scanner(System.in);
            System.out.println("\n# Digite o número de identificação (ID) do espaço a ser reprovado: ");
            int id = scan.nextInt();
            while(aux != null) {
                if(aux.getId() == id) {
                    aux.setDisponibilidade("REPROVADO");
                    espacoRepo.save(aux);
                    System.out.println("\n## Espaço reprovado!");
                    aux = null;
                }
                else{
                    aux = aux.getProx();
                }
            }
        }
        else {
            System.out.println("\n## Não há espaços para reprovar.");
        }
    }

    private void aprovarEspaco(FilaLista lista) {
        if(!lista.vazio()){
            Espaco aux = lista.getInicio();
            Scanner scan = new Scanner(System.in);
            System.out.println("\n# Digite o número de identificação (ID) do espaço a ser aprovado: ");
            int id = scan.nextInt();
            while(aux != null) {
                if(aux.getId() == id) {
                    aux.setDisponibilidade("APROVADO");
                    espacoRepo.save(aux);
                    System.out.println("\n## Espaço aprovado!");
                    aux = null;
                }
                else{
                    aux = aux.getProx();
                }
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
            fila.inserir(e);
            System.out.print(".");
        }
        System.out.print(" Completado!\n");
        return fila;
    }
}
