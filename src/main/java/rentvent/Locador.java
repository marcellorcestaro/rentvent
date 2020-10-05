package rentvent;

import java.text.Format;
import java.util.Scanner;

import org.graalvm.compiler.phases.graph.ScheduledNodeIterator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class Locador implements CommandLineRunner {
    @Autowired
    private EspacoRepo espacoRepo;

    @Override
    public void run(String... args) {
        FilaLista lista = this.inicializarMeusEspacos();
        boolean sair = false;
        
        Scanner scn = new Scanner(System.in);
        while(!sair) {
            System.out.println("\n##### PAINEL DO LOCADOR #####");
            System.out.println("(1) Listar espaços cadastrados");
            System.out.println("(2) Cadastrar novo espaço");
            System.out.println("(2) Alterar espaço");
            System.out.println("(3) Excluir espaço");
            System.out.println("(0) Sair do programa");
            System.out.print("\n## Escolha sua opção: ");
            int opc = scn.nextInt();
            switch(opc){
                case 1: listarEspacos(lista); break;
                case 2: ; break;
                case 3: ; break;
                case 0: sair = true; break;
                default: System.out.println("\n## Opção inválida.");
            }
        }
    }

    private void listarEspacos(FilaLista lista) {
        if(!lista.vazio()){
            lista.imprimir();
        }
        else {
            System.out.println("\n## Não há espaços cadastrados.");
        }
    }


    /**
     * Utiliza o id do locador (neste caso 1) 
     * para buscar todos os espaços atrelados a ele.
     * @return fila de espaços do locador atual.
     */
    public FilaLista inicializarMeusEspacos(){
        FilaLista fila = new FilaLista();
        Iterable<Espaco> espacos = espacoRepo.findAll();
        for(Espaco e: espacos){
            if(e.getLocadorFuncaoClienteId() == 1){
                fila.inserir(e);
            }
        }
        return fila;
    }
}