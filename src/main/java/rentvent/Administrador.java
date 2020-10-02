package rentvent;

import java.util.Optional;
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
        FilaLista fila = new FilaLista();
        this.inicializarEspacos(fila);
        boolean sair = false;

        Scanner scn = new Scanner(System.in);
        while(!sair){
            System.out.println("\n##### PAINEL DO ADMINISTRADOR #####");
            System.out.println("\n(0) Sair do programa");
            System.out.print("\n\n## Escolha sua opção: ");
            int opc = scn.nextInt();
            switch(opc){
                case 1: break;
                case 2: break;
                case 3: break;
                case 0: sair = true; break;
            }
        }
        System.out.println("\n\n##### FIM DO PROGRAMA #####");
    }

    public void inicializarEspacos(FilaLista fila){
        System.out.print("Adicionando espaços a serem analisados ...");
        Iterable<Espaco> espacos = espacoRepo.findAll();
        for(Espaco e: espacos){
            if(e.getDisponibilidade().equals("A APROVAR")){
                fila.inserir(e);
                System.out.print(".");
            }
        }
        System.out.print(" Completado!\n");
    }
}
