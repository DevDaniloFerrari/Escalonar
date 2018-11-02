package base;

import java.util.ArrayList;

/**
 * Classe escrita para simular o escalonamento de processos em um sistema operacional
 * executando um uma máquina com um processador de núcleo único.
 * @author Emerson dos Santos Paduan
 * @version 1.0
 */
public class Escalonador {

    //Constantes para indicar o tipo de ordenação a ser aplicada na lista de processos
    private static final int CHEGADA = 1;
    private static final int DURACAO = 2;
    private static final int PRIORIDADE = 3;
    private static final int NOME = 4;

    private ArrayList<Processo> entrada; //entrada de processos
    private ArrayList<Processo> res; //resultado
    private ArrayList<Processo> pronto; //fila de prontos
    private ArrayList<PCB> graf; //PCB para gerar o gráfico
    //tempos médios de Espera e Turnaround
    private float mEspera, mTurnaround;

    /**
     * Instancia um escalonador sem inicializar a lista de processos.
     * Neste caso, o método <b><I>setEntrada</I></b> deve ser usado para
     * informar a lista de processos.
     */
    public Escalonador() {
        
    }

    /**
     * Instancia um escalonador com a lista de processos.
     * @param lista lista de processos a serem escalonados
     */
    
    public Escalonador(ArrayList<Processo> lista) {
        if(!validaEntrada(lista))
            return;

        entrada = new ArrayList<>();
        for (Processo p : lista) {
            entrada.add(new Processo(p));
        }
    }

    /**
     * Retorna o tempo médio de espera dos processos após a realização do escalonamento
     * @return media de Espera
     */
    public float getmEspera() {
        return mEspera;
    }

    /**
     * Retorna o tempo médio de Turnaround dos processos após a realização do escalonamento
     * @return media de Turnaround
     */
    public float getmTurnaround() {
        return mTurnaround;
    }

    /**
     * Valida se a lista de processos possui apenas valores válidos
     * @param lista lista de processos a ser validada
     * @return true se a lista for válida, ou false caso a lista seja nula ou contenha valores inválidos
     */

    public static boolean validaEntrada(ArrayList<Processo> lista)
    {
        if(lista == null || lista.isEmpty())
            return false;
        //validar os valores
        for(Processo p:lista)
            if(p.getChegada() < 0 || p.getDuracao() < 0 || p.getPrioridade() < 0)
                return false;
        
        return true;
    }

    /**
     * Fornece para o escalonador a lista de processos a serem escalonados.
     * Caso a lista seja inválida, ela não será aceita
     * @param lista lista de processos a ser validada
     */

    public void setEntrada(ArrayList<Processo> lista)
    {
        if(!validaEntrada(lista))
            return;
        
        entrada = new ArrayList<>();
        for (Processo p : lista) {
            entrada.add(new Processo(p));
        }

    }

    /**
     * Ordena uma lista de processos de acordo com a opção
     * @param v lista de processos a ser ordenada
     * @param opcao indica o campo usado para ordenação (por chegada, duração, prioridade ou nome do processo)
     * 
     */
    private void ordenar(ArrayList<Processo> v, int opcao) {
        if (opcao == CHEGADA)
        {
            for (int i = 1; i <= v.size() - 1; i++)
            {
                Processo t = v.get(i);
                int j = i - 1;
                while ((j >= 0) && (v.get(j).getChegada() > t.getChegada()))
                {
                    v.set(j + 1, v.get(j));
                    j--;
                }
                v.set(j + 1, t);
            }
        }
        else    //por duracao
            if (opcao == DURACAO)
            {
                for (int i = 1; i <= v.size() - 1; i++)
                {
                    Processo t = v.get(i);
                    int j = i - 1;
                    while ((j >= 0) && (v.get(j).getDuracao() > t.getDuracao()))
                    {
                        v.set(j + 1, v.get(j));
                        j--;
                    }
                    v.set(j + 1, t);
                }
            }
            else
                if (opcao == PRIORIDADE) //DECRESCENTE
                {
                    for (int i = 1; i <= v.size() - 1; i++)
                    {
                        Processo t = v.get(i);
                        int j = i - 1;
                        while ((j >= 0) && (v.get(j).getPrioridade() < t.getPrioridade()))
                        {
                            v.set(j + 1, v.get(j));
                            j--;
                        }
                        v.set(j + 1, t);
                    }
                }
                else  // por nome
                {
                    for (int i = 1; i <= v.size() - 1; i++)
                    {
                        Processo t = v.get(i);
                        int j = i - 1;
                        while ((j >= 0) && (v.get(j).getId().compareTo(t.getId()) > 0))
                        {
                            v.set(j + 1, v.get(j));
                            j--;
                        }
                        v.set(j + 1, t);
                    }
                }
    }

    /**
     * Escalonador First Came, First Served (FCFS)
     * Faz o escalonamento não preemptivo, por ordem de chegada.
     */

    public void escalonarFCFS() {

        //se não há um conjunto de processos válidos não escalona
        if(!validaEntrada(entrada))
            return;
        pronto = new ArrayList<>();
        res = new ArrayList<>();
        graf = new ArrayList<>();
        Processo executando;

        int tempoAtual;

        ordenar(entrada, CHEGADA);
        mEspera = 0;
        mTurnaround = 0;

        tempoAtual = entrada.get(0).getChegada();
        
        pronto.add(entrada.get(0));
        entrada.remove(0);

         //Enquanto existem processos na fila de entrada ou de Prontos
        while (!pronto.isEmpty() || !entrada.isEmpty())
        {
            //se chegaram novos processos, coloca na fila de prontos
            while (!entrada.isEmpty() && entrada.get(0).getChegada() <= tempoAtual)
            {
                if (entrada.get(0).getChegada() <= tempoAtual)
                {
                    pronto.add(entrada.get(0));
                    entrada.remove(0);
                }
            }
            if (!pronto.isEmpty())
            {
                ordenar(pronto, CHEGADA);
                //pega o próximo processo de menor duração na fila de prontos
                executando = pronto.get(0);
                pronto.remove(0);
                
                graf.add(new PCB(executando, tempoAtual));
                
                //calcula os tempos para o processo atual
                executando.setEspera(tempoAtual - executando.getChegada());
                //atualiza o tempo atual
                tempoAtual += executando.getDuracao();
                //atualiza o tempo de execução do processo
                executando.setTurnaround(tempoAtual - executando.getChegada());
                
                graf.get(graf.size() - 1).setInterr(tempoAtual);
                res.add(executando);

                mEspera += executando.getEspera();
                mTurnaround += executando.getTurnaround();
            }
            else
                //há um intervalode tempo "livre", onde não há processos para executar
                if(!entrada.isEmpty())
                {
                    //aponta para o próximo da fila para pegar o tempo de chegada
                    int tempo = entrada.get(0).getChegada();
                    graf.add(new PCB(new Processo("Px", tempoAtual, tempo-tempoAtual), tempoAtual));
                    tempoAtual = tempo;
                    graf.get(graf.size() - 1).setInterr(tempoAtual);
                }
                //tempoAtual++;
        }

        graf.get(graf.size() - 1).setInterr(tempoAtual);
        mEspera /= res.size();
        mTurnaround /= res.size();
    }

    /**
     * Escalonador Sortest Job First (SJF) Não-Preemptivo
     * Faz o escalonamento não preemptivo levando em consideração a chegada e tendo
     * como prioridade os processos de menor duração.
     */
    public void escalonarSJFnP() {
        int tempoAtual;
        Processo executando;

        //se não há um conjunt de processos válidos não escalona
        if(!validaEntrada(entrada))
            return;

        res = new ArrayList<>();
        pronto = new ArrayList<>();
        graf = new ArrayList<>();

        ordenar(entrada, CHEGADA);

        mEspera = 0;
        mTurnaround = 0;
        tempoAtual = entrada.get(0).getChegada();
        pronto.add(entrada.get(0));
        entrada.remove(0);

        //Enquanto existem processos na fila de entrada ou de Prontos
        while (!pronto.isEmpty() || !entrada.isEmpty())
        {
            //se chegaram novos processos, coloca na fila de prontos
            while (!entrada.isEmpty() && entrada.get(0).getChegada() <= tempoAtual)
            {
                if (entrada.get(0).getChegada() <= tempoAtual)
                {
                    pronto.add(entrada.get(0));
                    entrada.remove(0);
                }
            }
            //verifica se existem processos na fila de prontos
            if (!pronto.isEmpty())
            {
                //pega o próximo processo de menor duração na fila de prontos
                ordenar(pronto, DURACAO);
                executando = pronto.get(0);
                pronto.remove(0);
                graf.add(new PCB(executando, tempoAtual));
                //calcula a execução do processo atual
                executando.setEspera(tempoAtual - executando.getChegada());
                tempoAtual += executando.getDuracao();
                executando.setTurnaround(tempoAtual - executando.getChegada());

                //adiciona ao Array de saída
                res.add(executando);

                graf.get(graf.size() - 1).setInterr(tempoAtual);
                mEspera += executando.getEspera();
                mTurnaround += executando.getTurnaround();
            }
            else
            {
                 //há um intervalode tempo "livre", onde não há processos para executar
                if(!entrada.isEmpty())
                {
                    //aponta para o próximo da fila para pegar o tempo de chegada
                    int tempo = entrada.get(0).getChegada();
                    graf.add(new PCB(new Processo("Px", tempoAtual, tempo-tempoAtual), tempoAtual));
                    tempoAtual = tempo;
                    graf.get(graf.size() - 1).setInterr(tempoAtual);
                }
            }
        }
        //calcula os tempos médios de espera e turnaround
        mEspera /= res.size();
        mTurnaround /= res.size();
    }

    /**
     * Escalonador Sortest Remaining Time (SRT) Preemptivo
     * Faz o escalonamento preemptivo levando em consideração a chegada e tendo
     * como prioridade os processos de menor duração.
     * É a versão preemptiva do SJF.
     */
    public void escalonarSRT() {
        int tempoAtual;
        Processo executando = null;

        //se não há um conjunto de processos válidos não escalona
        if(!validaEntrada(entrada))
            return;

        res = new ArrayList<>();
        pronto = new ArrayList<>();
        graf = new ArrayList<>();

        ordenar(entrada, CHEGADA);

        mEspera = 0;
        mTurnaround = 0;
        tempoAtual = entrada.get(0).getChegada();
        pronto.add(entrada.get(0));
        entrada.remove(0);

        //Enquanto exixtem processos na fila de entrada ou de Prontos ou o último processo não acabou
        while (!pronto.isEmpty() || !entrada.isEmpty() || executando != null)
        {
            //se chegaram novos processos, coloca na fila de prontos
            while (!entrada.isEmpty() && entrada.get(0).getChegada() <= tempoAtual)
            {
                if (entrada.get(0).getChegada() <= tempoAtual)
                {
                    pronto.add(entrada.get(0));
                    entrada.remove(0);
                    ordenar(pronto, DURACAO);
                }
            }
            //verifica se tem processo na fila de prontos OU algum processo executando
            if (!pronto.isEmpty() || executando != null)
            {
                //Verifica se há prioridade para interromper
                if (executando != null) //se tem processo executando
                {
                    //processo na fila é de menor duração? Sim = troca
                    if (!pronto.isEmpty())
                        if (executando.getDuracao() > pronto.get(0).getDuracao())
                        {
                            executando.setInterr(tempoAtual);//tempo onde foi interrompido
                            graf.get(graf.size() - 1).setInterr(tempoAtual);
                            pronto.add(executando);
                            executando = pronto.get(0);
                            pronto.remove(0);
                            ordenar(pronto, DURACAO);
                            //coloca no grafico e ajusta os valores
                            graf.add(new PCB(executando, tempoAtual));
                            //atualiza o tempo de espera do processo
                            executando.setEspera(executando.getEspera() + tempoAtual - executando.getInterr());
                        }
                }
                else //pega o primeiro dos prontos
                {
                    executando = pronto.get(0);
                    pronto.remove(0);
                    graf.add(new PCB(executando, tempoAtual));
                    //atualiza o tempo de espera do processo
                    executando.setEspera(executando.getEspera() + tempoAtual - executando.getInterr());
                }
                //calcula a execução do processo atual
                tempoAtual++;

                executando.DecDuracao();

                //se terminou adiciona ao Arry de saída
                if (executando.getDuracao() == 0)
                {
                    executando.setTurnaround(tempoAtual - executando.getChegada());
                    res.add(executando);
                    graf.get(graf.size() - 1).setInterr(tempoAtual);
                    mEspera += executando.getEspera();
                    mTurnaround += executando.getTurnaround();
                    executando = null;
                }
            }
            else
            {
                 //há um intervalode tempo "livre", onde não há processos para executar
                if(!entrada.isEmpty())
                {
                    //aponta para o próximo da fila para pegar o tempo de chegada
                    int tempo = entrada.get(0).getChegada();
                    graf.add(new PCB(new Processo("Px", tempoAtual, tempo-tempoAtual), tempoAtual));
                    tempoAtual = tempo;
                    graf.get(graf.size() - 1).setInterr(tempoAtual);
                }
            }

        }
        //calcula os tempos médios de espera e turnaround
        mEspera /= res.size();
        mTurnaround /= res.size();
    }

    /**
     * Escalonador por Prioridade Não-Preemptivo
     * Faz o escalonamento não preemptivo levando em consideração a chegada e tendo
     * como prioridade o valor de prioridade dos processos.
     * Valores maiores de prioridade indicam maior importância.
     */
    public void escalonarPrioridadeNP() {
        int tempoAtual;
        Processo executando;

        //se não há um conjunt de processos válidos não escalona
        if(!validaEntrada(entrada))
            return;

        res = new ArrayList<>();
        pronto = new ArrayList<>();
        graf = new ArrayList<>();

        ordenar(entrada, CHEGADA);

        mEspera = 0;
        mTurnaround = 0;
        tempoAtual = entrada.get(0).getChegada();
        pronto.add(entrada.get(0));
        entrada.remove(0);

        //Enquanto existem processos na fila de entrada ou de Prontos
        while (!pronto.isEmpty() || !entrada.isEmpty())
        {
            //se chegaram novos processos, coloca na fila de prontos
            while (!entrada.isEmpty() && entrada.get(0).getChegada() <= tempoAtual)
            {
                if (entrada.get(0).getChegada() <= tempoAtual)
                {
                    pronto.add(entrada.get(0));
                    entrada.remove(0);
                }
            }
            if (!pronto.isEmpty())
            {
                //pega o próximo processo de maior prioridade na fila de prontos
                ordenar(pronto, PRIORIDADE);
                executando = pronto.get(0);
                pronto.remove(0);

                graf.add(new PCB(executando, tempoAtual));

                //calcula a execução do processo atual
                executando.setEspera(tempoAtual - executando.getChegada());
                tempoAtual += executando.getDuracao();
                executando.setTurnaround(tempoAtual - executando.getChegada());

                //adiciona ao Arry de saída
                res.add(executando);
                //atualiza o tempo de termino de execução no gráfico
                graf.get(graf.size() - 1).setInterr(tempoAtual);

                mEspera += executando.getEspera();
                mTurnaround += executando.getTurnaround();
            }
            else
            {
                //há um intervalode tempo "livre", onde não há processos para executar
                if(!entrada.isEmpty())
                {
                    //aponta para o próximo da fila para pegar o tempo de chegada
                    int tempo = entrada.get(0).getChegada();
                    graf.add(new PCB(new Processo("Px", tempoAtual, tempo-tempoAtual), tempoAtual));
                    tempoAtual = tempo;
                    graf.get(graf.size() - 1).setInterr(tempoAtual);
                }
            }
        }
        //calcula os tempos médios de espera e turnaround
        mEspera /= res.size();
        mTurnaround /= res.size();
    }

    /**
     * Escalonador por Prioridade Preemptivo
     * Faz o escalonamento preemptivo levando em consideração a chegada e tendo
     * como prioridade o valor de prioridade dos processos.
     * Valores maiores de prioridade indicam maior importância.
     */
    public void escalonarPrioridadeP() {
        int tempoAtual;
        Processo executando = null;

        //se não há um conjunt de processos válidos não escalona
        if(!validaEntrada(entrada))
            return;

        res = new ArrayList<>();
        pronto = new ArrayList<>();
        graf = new ArrayList<>();

        ordenar(entrada, CHEGADA);

        mEspera = 0;
        mTurnaround = 0;
        tempoAtual = entrada.get(0).getChegada();
        pronto.add(entrada.get(0));
        entrada.remove(0);

        //Enquanto exixtem processos na fila de entrada ou de Prontos ou o último processo não acabou
        while (!pronto.isEmpty() || !entrada.isEmpty() || executando != null)
        {
            //se chegaram novos processos, coloca na fila de prontos
            while (!entrada.isEmpty() && entrada.get(0).getChegada() <= tempoAtual)
            {
                if (entrada.get(0).getChegada() <= tempoAtual)
                {
                    pronto.add(entrada.get(0));
                    entrada.remove(0);
                    ordenar(pronto, PRIORIDADE);
                }
            }

            //verifica se tem processos na fila de prontos OU algum executando
            if (!pronto.isEmpty() || executando != null)
            {
                //Verifica se há prioridade para interromper
                if (executando != null) //se tem processo executando
                {
                    //processo na fila é de menor duração? Sim = troca
                    if (!pronto.isEmpty())
                        if (executando.getPrioridade() < pronto.get(0).getPrioridade())
                        {
                            executando.setInterr(tempoAtual);//tempo onde foi interrompido
                            graf.get(graf.size() - 1).setInterr(tempoAtual);
                            pronto.add(executando);
                            executando = pronto.get(0);
                            pronto.remove(0);
                            ordenar(pronto, PRIORIDADE);
                            graf.add(new PCB(executando, tempoAtual));
                        }
                }
                else //pega o primeiro dos prontos
                {
                    executando = pronto.get(0);
                    pronto.remove(0);
                    graf.add(new PCB(executando, tempoAtual));
                    //atualiza o tempo de espera do processo
                    executando.setEspera(executando.getEspera() + tempoAtual - executando.getInterr());
                }
                //calcula a execução do processo atual
                tempoAtual++;
                executando.DecDuracao();

                //se terminou adiciona ao Arry de saída
                if (executando.getDuracao() == 0)
                {
                    executando.setTurnaround(tempoAtual - executando.getChegada());
                    res.add(executando);
                    //atualiza o tempo de termino de execução no gráfico
                    graf.get(graf.size() - 1).setInterr(tempoAtual);

                    mEspera += executando.getEspera();
                    mTurnaround += executando.getTurnaround();
                    executando = null;
                }
            }
            else
            {
                 //há um intervalode tempo "livre", onde não há processos para executar
                if(!entrada.isEmpty())
                {
                    //aponta para o próximo da fila para pegar o tempo de chegada
                    int tempo = entrada.get(0).getChegada();
                    graf.add(new PCB(new Processo("Px", tempoAtual, tempo-tempoAtual), tempoAtual));
                    tempoAtual = tempo;
                    graf.get(graf.size() - 1).setInterr(tempoAtual);
                }
            }
        }
        //calcula os tempos médios de espera e turnaround
        mEspera /= res.size();
        mTurnaround /= res.size();
    }

    /**
     * Escalonador Round Robin
     * Faz o escalonamento preemptivo Round Robin levando em consideração a
     * ordem de chegada dos processos.
     * @param quantum valor do quantum a ser utilizado no escalonamento
     */
    public void escalonarRR(int quantum) {
        int tempoAtual;
        Processo executando = null;

        //se não há um conjunt de processos válidos não escalona
        if(!validaEntrada(entrada) || quantum <= 0)
            return;

        res = new ArrayList<>();
        pronto = new ArrayList<>();
        graf = new ArrayList<>();

        ordenar(entrada, CHEGADA);

        mEspera = 0;
        mTurnaround = 0;
        tempoAtual = entrada.get(0).getChegada();
        pronto.add(entrada.get(0));
        entrada.remove(0);

        //Enquanto existem processos na fila de entrada ou de Prontos ou o último processo não acabou
        while (!pronto.isEmpty() || !entrada.isEmpty() || executando != null)
        {
            //se chegaram novos processos, coloca na fila de prontos
            while (!entrada.isEmpty() && entrada.get(0).getChegada() <= tempoAtual)
            {
                if (entrada.get(0).getChegada() <= tempoAtual)
                {
                    pronto.add(entrada.get(0));
                    entrada.remove(0);
                }
            }

            //verifica se tem processos na fila de prontos OU algum executando
            if (!pronto.isEmpty() || executando != null)
            {
                if (executando != null) //se tem processo executando
                {
                    //tem processo na fila de pronto? Sim = Troca
                    if (!pronto.isEmpty())
                    {
                        executando.setInterr(tempoAtual);//tempo onde foi interrompido
                        graf.get(graf.size() - 1).setInterr(tempoAtual);
                        pronto.add(executando);
                        executando = pronto.get(0);
                        pronto.remove(0);
                        //atualiza o tempo de espera do processo
                        executando.setEspera(executando.getEspera() + tempoAtual - executando.getInterr());
                        //coloca no grafico e ajusta os valores
                        graf.add(new PCB(executando, tempoAtual));
                    }
                }
                else
                {
                    //pega o primeiro dos prontos caso exista
                    if (!pronto.isEmpty())
                    {
                        executando = pronto.get(0);
                        pronto.remove(0);
                        //coloca no grafico e ajusta os valores
                        graf.add(new PCB(executando, tempoAtual));
                        //atualiza o tempo de espera do processo
                        executando.setEspera(executando.getEspera() + tempoAtual - executando.getInterr());
                    }
                }
                //calcula a execução do processo atual

                if (executando.getDuracao() > quantum)
                {
                    tempoAtual += quantum;
                    executando.DecDuracao(quantum);
                }
                else
                {
                    tempoAtual += executando.getDuracao();
                    executando.DecDuracao(executando.getDuracao());
                }

                //se terminou adiciona ao Arry de saída
                if (executando.getDuracao() == 0)
                {
                    executando.setTurnaround(tempoAtual - executando.getChegada());
                    res.add(executando);
                    //ajusta o último tempo de execução no gráfico
                    graf.get(graf.size() - 1).setInterr(tempoAtual);
                    mEspera += executando.getEspera();
                    mTurnaround += executando.getTurnaround();
                    executando = null;
                }
            }
            else
            {
                 //há um intervalode tempo "livre", onde não há processos para executar
                if(!entrada.isEmpty())
                {
                    //aponta para o próximo da fila para pegar o tempo de chegada
                    int tempo = entrada.get(0).getChegada();
                    graf.add(new PCB(new Processo("Px", tempoAtual, tempo-tempoAtual), tempoAtual));
                    tempoAtual = tempo;
                    graf.get(graf.size() - 1).setInterr(tempoAtual);
                }
            }

        }
        //calcula os tempos médios de espera e turnaround
        mEspera /= res.size();
        mTurnaround /= res.size();
    }

    /**
     * Retorna uma lista de processos ordenada pelo nome dos processos.
     * Estes processos armazenam seus tempo de espera e turnaround durante o escalonamento
     * @return ArrayList de processos ou null
     */

     public ArrayList retEscala() {

        ordenar(res, NOME);
        return res;
    }

    /**
     * Retorna uma lista de <I>PCB</I>'s representando o resultado do escalonamento no gráfico de Gantt
     * @return ArrayList de processos ou null
     */

     public ArrayList retGraf()
    {
         return graf;
     }

}
