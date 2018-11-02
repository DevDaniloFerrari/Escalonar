package base;

import java.awt.Color;

/**
 * Esta classe é utilizada pela classe Grafico e pela classe Escalonador
 * 
 * Armazena informação sobre o um bloco de execução no diagrama de Gantt para um processo.
 * Informações sobre um processo: id, inicio e fim de bloco de execução, e cor
 * @author Emerson S. Paduan
 */
public class PCB {
    private final String id;
    private int start, interr;
    private Color c;

    /**
     * Instancia um novo PCB
     * @param p : Processo
     * @param time: tempo de início do bloco de execução
     */
    public PCB(Processo p, int time)
    {
        this.id = p.getId();
        this.start = time;
        c = null;
    }

    /**
     * Retorna o Nome (id) do Processo
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Retorna o tempo de início do bloco atual de execução do processo
     * @return the start
     */
    public int getStart() {
        return start;
    }

    /**
     * Retorna o tempo final do bloco atual de execução do processo
     * @return the interr
     */
    public int getInterr() {
        return interr;
    }

    /**
     * Altera o tempo final do bloco atual de execução do processo
     * @param interr the interr to set
     */
    public void setInterr(int interr) {
        this.interr = interr;
    }

    /**
     * Retorna a cor do bloco atual de execução do processo
     * @return the c
     */
    public Color getColor() {
        return c;
    }

    /**
     * Altera a cor do bloco atual de execução do processo
     * @param c the c to set
     */
    public void setColor(Color c) {
        this.c = c;
    }


}
