package rentvent;

import java.text.Format;
import java.util.InputMismatchException;
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

    private FilaLista lista;

    @Override
    public void run(String... args) {
        lista = this.inicializarMeusEspacos();
        boolean sair = false;
        
        Scanner scn = new Scanner(System.in);
        while(!sair) {
            System.out.println("\n##### PAINEL DO LOCADOR #####");
            System.out.println("(1) Listar meus espaços");
            System.out.println("(2) Cadastrar novo espaço");
            System.out.println("(3) Alterar um espaço");
            System.out.println("(4) Excluir um espaço");
            System.out.println("(0) Sair do programa");
            System.out.print("\n## Escolha sua opção: ");
        
            String opc = scn.next();
            switch(opc){
                case "1": listarEspacos(); break;
                case "2": cadastrarEspaco(); break;
                case "3": alterarEspaco(); break;
                case "4": excluirEspaco(); break;
                case "0": sair = true; break;
                default: System.out.println("\n## Opção inválida.");
            }
        }
    }

    private void excluirEspaco() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\n# Número do espaço a ser apagado: ");
        try{
            int id = scan.nextInt();
            Espaco e = lista.encontrarEspaco(id);
            if(e != null) {
                espacoRepo.delete(e);
                if(lista.deletar(id)){
                    System.out.println("\n## Espaço excluído com sucesso.");
                }
                else{
                    System.out.println("\n## Houve um erro ao excluir o espaço.");
                }
            }
            else{
                System.out.println("\n## Não foi encontrado espaço com este número.");
            }
        } catch(InputMismatchException err) {
            System.out.println("\n## ERRO. Por favor, digite o algarismo numérico correspondente a opção desejada.");
        }
    }

    private void alterarEspaco() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\n## Número do espaço a ser alterado: ");
        try {
            int id = scan.nextInt();
            Espaco e = lista.encontrarEspaco(id);
            if(e != null) {
                System.out.print("\n# Novo nome do espaço: ");
                scan.nextLine();
                String nome = scan.nextLine();
                System.out.print("\n# Nova capacidade do espaço: ");
                int capacidade = scan.nextInt();
                System.out.print("\n# Novo valor por hora do espaço: ");
                double valorHora = scan.nextDouble();
                System.out.print("\n# Novo valor por dia do espaço: ");
                double valorDia = scan.nextDouble();
                e.setNome(nome);
                e.setCapacidade(capacidade);
                e.setValorHora(valorHora);
                e.setValorDia(valorDia);
                espacoRepo.save(e);
                System.out.println("\n## Espaço atualizado.");
            }
            else{
                System.out.println("\n## Não foi encontrado espaço com este número.");
            }
        } catch(InputMismatchException err) {
            System.out.println("\n## ERRO. Por favor, digite o algarismo numérico para identificar o ID do espaço.");
        }
    }

    private void cadastrarEspaco() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n## Cadastro de novo espaço ##\n");
        System.out.print("\n# Número do novo espaço: ");
        try {
            int id = scan.nextInt();
            System.out.print("\n# Nome do espaço: ");
            scan.nextLine();
            String nome = scan.nextLine();
            System.out.print("\n# Capacidade do espaço: ");
            int capacidade = scan.nextInt();
            System.out.print("\n# Valor por hora do espaço: ");
            double valorHora = scan.nextDouble();
            System.out.print("\n# Valor por dia do espaço: ");
            double valorDia = scan.nextDouble();
            Espaco e = new Espaco(id, nome, capacidade, valorHora, valorDia, "A APROVAR", 1);
            espacoRepo.save(e);
            lista.inserir(e);
            System.out.println("\n## Espaço cadastrado com sucesso.");
        } catch(InputMismatchException err) {
            System.out.println("\n## ERRO: Houve um erro ao cadastrar um novo espaço.");
        }
        
    }

    private void listarEspacos() {
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