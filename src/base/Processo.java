package base;

/**
 * Classe que representa um processo em execução no Sistema Operacional
 * @author Emerson S. Paduan
 * @version 1.0
 */

public class Processo {
    private final String id;
    private int duracao,  chegada, prioridade;
    private int espera, turnaround;
    private int interr;

    /**
     * instancia um novo processo.
     * @param id id do Processo
     * @param chegada tempo de chegada do Processo
     * @param duracao tempo de duração do Processo
     */
    public Processo(String id, int chegada, int duracao){
        this.id = id;
        this.chegada = chegada;
        this.duracao = duracao;
        this.prioridade = 0;
        espera = turnaround = 0;
        interr = chegada;
    }

    /**
     * instancia um novo processo.
     * @param id
     * @param chegada
     * @param duracao
     * @param prioridade
     */
    public Processo(String id, int chegada,int duracao, int prioridade) {
        this.id = id;
        this.chegada = chegada;
        this.duracao = duracao;
        this.prioridade = prioridade;
        espera = turnaround = 0;
        interr = chegada;
    }
    
    /**
     * instancia um novo processo.
     * @param p Processo: um processo
     */
    public Processo(Processo p)
    {
        this.id = p.id;
        this.chegada = p.chegada;
        this.duracao = p.duracao;
        this.prioridade = p.prioridade;
        espera = turnaround = 0;
        interr = p.chegada;
    }

    /**
     * Recebe como parâmentro um processo e verifica se ele é igual ao processo
     * que chamou o método. Igual significa que todos os dados são iguais (ID,
     * Chegada, Duração e Prioridade), não quer dizer que sejam o mesmo objeto.
     * @param p processo a ser comparado
     * @return true (se iguais) / false (caso contrário)
     */
    public boolean igual(Processo p)
    {
        if(p.getId().equals(this.getId()) && p.getChegada() == this.getChegada()
                && p.getDuracao()==this.getDuracao() && p.getPrioridade() == this.getPrioridade())
            return true;
        else
            return false;
    }
    
    /**
     * @return o id (código) do processo
     */
    public String getId() {
        return id;
    }

    /**
     * @return a duracao do processo
     */
    public int getDuracao() {
        return duracao;
    }

    /**
     * decrementa uma unidade de tempo da duração de um processo.
     */
    public void DecDuracao(){
        duracao--;
    }

    /**
     * decrementa "tempo" da duração de um processo.
     * @param tempo
     */
    public void DecDuracao(int tempo){
        duracao -= tempo;
    }

    /**
     * @return o tempo de chegada do processo
     */
    public int getChegada() {
        return chegada;
    }

    /**
     * @return o valor da espera
     */
    public int getEspera() {
        return espera;
    }

    /**
     * @param espera o valor da espera
     */
    public void setEspera(int espera) {
        this.espera = espera;
    }

    /**
     * @return o turnaround
     */
    public int getTurnaround() {
        return turnaround;
    }

    /**
     * @param turnaround o turnaround a ser atribuído
     */
    public void setTurnaround(int turnaround) {
        this.turnaround = turnaround;
    }

    /**
     * @return a prioridade
     */
    public int getPrioridade() {
        return prioridade;
    }

    /**
     * @return the interr
     */
    public int getInterr() {
        return interr;
    }

    /**
     * @param interr the interr to set
     */
    public void setInterr(int interr) {
        this.interr = interr;
    }

}
