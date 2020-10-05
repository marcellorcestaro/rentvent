package rentvent;

public class FilaLista {
    private Espaco inicio;


    /*
    * Inicializa FilaLista com o inicio nulo
    */
    public FilaLista(){
        this.inicio = null;
    }


    /*
    * Inicializa FilaLista com um espaço já colocado
    */
    public FilaLista(Espaco e){
        this.inicio = e;
    }


    /*
    * Setters
    */
    public void setInicio(Espaco inicio) { this.inicio = inicio; }


    /*
    * Getters
    */
    public Espaco getInicio() { return inicio; }


    /*
    * Retorna se a fila está vazia
    */
    public boolean vazio(){ return this.inicio == null;}


    /*
    * Insere um novo elemento na fila, no final da mesma
    *
    * @param e: Espaço a ser inserido
    * @return sucesso: Indica sucesso da operação
    */
    public boolean inserir(Espaco e){
        if(this.vazio()){
            this.inicio = e;
            return true;
        }

        Espaco iterable = this.inicio;
        while(iterable.getProx() != null){
            iterable = iterable.getProx();
        }
        iterable.setProx(e);
        return true;
    }


    /*
    * Deleta o elemento da fila, ou seja, o primeiro elemento
    *
    * @return sucesso: Indica sucesso da operação
    */
    public boolean deletar(){
        if(this.vazio()){
            System.out.println("\n## A lista está vazia!");
            return false;
        }

        Espaco novoInicio = this.inicio.getProx();
        if(novoInicio == null){
            this.inicio = null;
            return true;
        }

        this.inicio = novoInicio;
        return true;
    }

    public boolean deletar(int id) {
        Espaco aux = inicio;
        while(aux != null) {
            if(aux.getId() == id) {
                Espaco e = aux;
                aux = e.getProx();
                e = null;
                return true;
            }
            aux = aux.getProx();
        }
        return false;
    }


    /*
    * Imprime a fila inteira de espaços a serem aprovados
    */
    public void imprimir(){
        if(!vazio()){
            Espaco iterable = this.inicio;

            while(iterable != null){
                iterable.print();
                iterable = iterable.getProx();
            };
        }
    }

    public Espaco encontrarEspaco(int id) {
        if(!vazio()){
            Espaco aux = inicio;
            while(aux != null) {
                if(aux.getId() == id) {
                    return aux;
                }
                aux = aux.getProx();
            }
        }
        return null;
    }
}
