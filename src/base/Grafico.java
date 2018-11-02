package base;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/**
 * Classe que desenha na interface um gráfico de Gantt representado
 * o escalonamento dos processos.
 * A classe herda de JPanel
 * @author Emerson dos Santos Paduan
 * @version 1.0
 */
public class Grafico extends JPanel {

    final int largura = 20; //largura da barra
    Graphics g;
    private ArrayList<PCB> fila; //fila de PCBs dos processos
    private ArrayList<Color> cores = new ArrayList<>();
    public final static int RET3D = 1;
    public final static int RET_ROUND = 2;
    public final static int RET_ROUND_F = 3;
    private int tipoGrafico;

    /**
     * Recebe como parâmetro a lista de processos escalonados
     * @param f ArrayList: lista de PCB
     * @param tipoGrafico int: tipo de gráfico a ser exibido
     */
    public Grafico(ArrayList<PCB> f, int tipoGrafico) {
        fila = f;
        this.tipoGrafico = tipoGrafico;
        geraCores();
    }

    @Override
    public void paintComponent(Graphics g) {
        int i = 0;
        int posTempo = 50; //posição onde aparece o texto de tempo
        int posPid = 10; //posição onde aparece o texto do nome do processo

        int posIni = 0, posFin;
        int frames;//em quantos frames (pedacinhos) será dividido o gráfico
        int tam;//tamanho de cada bloco (formado por várias 'frames')
        
        //calcula o comprimento total do gráfico baseado no tamanho do formulário em que está inserido
        int comprimento = this.getParent().getWidth() - 60;

        //ajusta o tamanho a partir do calculo acima
        this.setSize(comprimento + 10, this.getHeight());
        this.g = g;
        super.paintComponent(g);
        g.setFont(new Font(g.getFont().getFontName(), Font.PLAIN, 10));

        //calcula o tamanho de cada frame, considerando o intervalo de tempo
        //desde o início do primeiro processo e final do último processo;
        frames = comprimento / fila.get(fila.size() - 1).getInterr() - fila.get(0).getStart();

        if (fila.size() > 0) {
            //escreve o tempo inicial do gráfico
            g.drawString(fila.get(0).getStart() + "", 0, posTempo);
            String txt;

            for (i = 0; i < fila.size(); i++) {
                txt = fila.get(i).getId();
                //calcula a posição onde termina o bloco atual
                posFin = (fila.get(i).getInterr() - fila.get(i).getStart()) * frames + posIni;
                //calcula o tamanho do bloco atual
                tam = posFin - posIni;
                //obtem uma cor e desenha o bloco
                g.setColor(fila.get(i).getColor());
                //exibe quadro "branco" se não houver processo
                if (fila.get(i).getId().equals("Px"))
                    g.drawRect(posIni, 15, tam, largura);
                else
                    switch (tipoGrafico) {
                        case RET3D:
                            g.fill3DRect(posIni, 15, tam, largura, true);
                            break;
                        case RET_ROUND:
                            g.drawRoundRect(posIni, 15, tam, largura, 10, 10);
                            break;
                        case RET_ROUND_F:
                            g.fillRoundRect(posIni, 15, tam, largura, 10, 10);
                            break;
                    }

                //escreve o nome do processo e o tempo final do bloco
                g.setColor(Color.BLACK);
                //Se for um intervalode tempo sem processo não escreve o nome
                if (!txt.equals("Px"))
                    g.drawString(txt, posIni + (tam) / 2, posPid);
                g.drawString(Integer.toString(fila.get(i).getInterr()), posFin - 3, posTempo);
                //atualiza a posição inicial do próximo bloco
                posIni += tam;
            }
        }

    }

    private void geraCores() {
        Random rd = new Random();
        int p, j, bloco;
        Color c;
        //gera uma nova cor para cada processo da fila
        for (p = 0; p < fila.size(); p++) {
            //verifica se o processo já recebeu uma cor e caso afirmativo
            //atribui a mesma cor.
            for (bloco = 0; bloco < p; bloco++) {
                if (fila.get(bloco).getId().equals(fila.get(p).getId())) {
                    fila.get(p).setColor(fila.get(bloco).getColor());
                    break;
                }
            }
            //se achou o processo repetiu a cor e pode ir para o próximo bloco
            if (bloco != p) {
                continue;
            }
            //Indica que não há processo sendo executado
            if (fila.get(p).getId().equals("Px")) {
                fila.get(p).setColor(this.getBackground());//new Color(240,240,240));
                continue;
            }
            
            do {
                //sorteia uma nova cor
                c = new Color(rd.nextInt(255), rd.nextInt(255), rd.nextInt(255));
                //verifica se a cor já foi usada
                for (j = 0; j < cores.size(); j++) {
                    if (cores.get(j).equals(c)) {
                        //p--;
                        break;
                    }
                }
                //se parou antes significa que a cor já foi usada e deve sortear outra
            } while (j < cores.size());
            cores.add(c);
            fila.get(p).setColor(c);
        }
    }

    /**
     * Atualiza a fila de processos que foram escalonados
     * @param fila
     */
    public void reSet(ArrayList<PCB> fila) {
        this.fila = fila;
    }

    /**
     * Remove todos os processos da fila
     */
    public void removeAllP() {
        fila.removeAll(fila);
    }
}
