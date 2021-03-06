/**
 * Principal.java
 *
 * Created on 08/11/2010
 * last update 01/01/2011
 * @author Emerson dos Santos Paduan
 * @version 1.0
 */

package telas;

import base.Armazenar;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import base.Escalonador;
import base.Processo;
import base.Grafico;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Locale;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Principal extends javax.swing.JFrame {

    private Grafico barra = null;
    private Escalonador e = null;
    private ArrayList<Processo> resp = null;
    ArrayList<Processo> lista_procs = null;
    private int tipoGrafico = Grafico.RET3D; //tipo de gráfico a ser exibido

    /* Instancia o aplicativo */
    public Principal() {
        initComponents();
        ajustaMenu();
        txtQuantum.setVisible(false);
        lbQuantum.setVisible(false);
        btnRun.setEnabled(false);
        e = new Escalonador();
    }

    /* This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        btnRun = new javax.swing.JButton();
        lbQuantum = new javax.swing.JLabel();
        txtQuantum = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEntrada = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSaida = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem4 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem5 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem6 = new javax.swing.JCheckBoxMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jCheckBoxMenuItem7 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem8 = new javax.swing.JCheckBoxMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jCheckBoxMenuItem9 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem10 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem11 = new javax.swing.JCheckBoxMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("telas/Principal"); // NOI18N
        setTitle(bundle.getString("ESCALONAR")); // NOI18N
        setMinimumSize(new java.awt.Dimension(530, 320));

        btnRun.setText(bundle.getString("CALCULAR")); // NOI18N
        btnRun.setToolTipText(bundle.getString("btnCalcular")); // NOI18N
        btnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunActionPerformed(evt);
            }
        });

        lbQuantum.setText(bundle.getString("QUANTUM:")); // NOI18N

        txtQuantum.setText(bundle.getString("0")); // NOI18N
        txtQuantum.setName("txtQuantum"); // NOI18N

        txtEntrada.setColumns(15);
        txtEntrada.setEditable(false);
        txtEntrada.setFont(new java.awt.Font("Arial", 0, 12));
        txtEntrada.setRows(5);
        txtEntrada.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtEntrada.setEnabled(false);
        jScrollPane1.setViewportView(txtEntrada);

        txtSaida.setColumns(20);
        txtSaida.setEditable(false);
        txtSaida.setFont(new java.awt.Font("Arial", 0, 12));
        txtSaida.setRows(5);
        txtSaida.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtSaida.setEnabled(false);
        jScrollPane2.setViewportView(txtSaida);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(bundle.getString("PROCESSOS CARREGADOS:")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(bundle.getString("TEMPOS DE ESPERA E TURNAROUND CALCULADOS:")); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 3, 10));
        jLabel3.setText(bundle.getString("PROCESSO: CHEGADA : DURAÇÃO: PRIORIDADE")); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 3, 10));
        jLabel4.setText(bundle.getString("PROCESSO : ESPERA: TURNAROUND")); // NOI18N

        jMenu1.setMnemonic('E');
        jMenu1.setText(bundle.getString("ESCALONADOR")); // NOI18N

        buttonGroup1.add(jCheckBoxMenuItem1);
        jCheckBoxMenuItem1.setMnemonic('1');
        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText(bundle.getString("FCFS")); // NOI18N
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jCheckBoxMenuItem1);

        buttonGroup1.add(jCheckBoxMenuItem2);
        jCheckBoxMenuItem2.setMnemonic('2');
        jCheckBoxMenuItem2.setText(bundle.getString("SJF")); // NOI18N
        jMenu1.add(jCheckBoxMenuItem2);

        buttonGroup1.add(jCheckBoxMenuItem3);
        jCheckBoxMenuItem3.setMnemonic('3');
        jCheckBoxMenuItem3.setText(bundle.getString("SRT")); // NOI18N
        jMenu1.add(jCheckBoxMenuItem3);

        buttonGroup1.add(jCheckBoxMenuItem4);
        jCheckBoxMenuItem4.setMnemonic('4');
        jCheckBoxMenuItem4.setText(bundle.getString("PRIORIDADE NP")); // NOI18N
        jMenu1.add(jCheckBoxMenuItem4);

        buttonGroup1.add(jCheckBoxMenuItem5);
        jCheckBoxMenuItem5.setMnemonic('5');
        jCheckBoxMenuItem5.setText(bundle.getString("PRIORIDADE P")); // NOI18N
        jMenu1.add(jCheckBoxMenuItem5);

        buttonGroup1.add(jCheckBoxMenuItem6);
        jCheckBoxMenuItem6.setMnemonic('6');
        jCheckBoxMenuItem6.setText(bundle.getString("RR")); // NOI18N
        jCheckBoxMenuItem6.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBoxMenuItem6StateChanged(evt);
            }
        });
        jMenu1.add(jCheckBoxMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setMnemonic('P');
        jMenu2.setText(bundle.getString("PROCESSOS")); // NOI18N

        jMenuItem7.setText(bundle.getString("DIGITAR")); // NOI18N
        jMenuItem7.setName("opcDigitarProcs"); // NOI18N
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuDigitarProcs(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText(bundle.getString("LER DO ARQUIVO")); // NOI18N
        jMenuItem8.setName("MenuLerArquivo"); // NOI18N
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuLerArquivo(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuItem1.setText(bundle.getString("GRAVAR EM AQUIVO")); // NOI18N
        jMenuItem1.setName("MenuGravarArquivo"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuGravarArquivo(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu3.setMnemonic('O');
        jMenu3.setText(bundle.getString("Opcoes")); // NOI18N

        buttonGroup2.add(jCheckBoxMenuItem7);
        jCheckBoxMenuItem7.setSelected(true);
        jCheckBoxMenuItem7.setText(bundle.getString("Portugues")); // NOI18N
        jCheckBoxMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jCheckBoxMenuItem7);

        buttonGroup2.add(jCheckBoxMenuItem8);
        jCheckBoxMenuItem8.setText(bundle.getString("Ingles")); // NOI18N
        jCheckBoxMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jCheckBoxMenuItem8);
        jMenu3.add(jSeparator1);

        buttonGroup3.add(jCheckBoxMenuItem9);
        jCheckBoxMenuItem9.setSelected(true);
        jCheckBoxMenuItem9.setText(bundle.getString("grafico Ret3d")); // NOI18N
        jCheckBoxMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jCheckBoxMenuItem9);

        buttonGroup3.add(jCheckBoxMenuItem10);
        jCheckBoxMenuItem10.setText(bundle.getString("grafico RetRound")); // NOI18N
        jCheckBoxMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jCheckBoxMenuItem10);

        buttonGroup3.add(jCheckBoxMenuItem11);
        jCheckBoxMenuItem11.setText(bundle.getString("grafico RetRoundF")); // NOI18N
        jCheckBoxMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jCheckBoxMenuItem11);

        jMenuBar1.add(jMenu3);

        jMenu5.setMnemonic('x');
        jMenu5.setText("Extra");

        jMenuItem2.setText("Gerar pdf");
        jMenuItem2.setName("jMenuPdf"); // NOI18N
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem2);

        jMenuBar1.add(jMenu5);

        jMenu4.setMnemonic('A');
        jMenu4.setText(bundle.getString("AJUDA")); // NOI18N

        jMenuItem9.setText(bundle.getString("MANUAL")); // NOI18N
        jMenuItem9.setName("MenuManual"); // NOI18N
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuManual(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuSobre.setText(bundle.getString("SOBRE")); // NOI18N
        jMenuSobre.setName("mnSobre"); // NOI18N
        jMenuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSobre(evt);
            }
        });
        jMenu4.add(jMenuSobre);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtQuantum, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbQuantum, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(29, 29, 29)
                        .addComponent(btnRun)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRun)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbQuantum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-570)/2, (screenSize.height-384)/2, 570, 384);
    }// </editor-fold>//GEN-END:initComponents

    //reacarregar os rótulos quando houver mudança de idioma
    private void ReinitComponents() {

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("telas/Principal"); // NOI18N
        setTitle(bundle.getString("ESCALONAR")); // NOI18N
        btnRun.setText(bundle.getString("CALCULAR")); // NOI18N
        btnRun.setToolTipText(bundle.getString("btnCalcular")); // NOI18N
        lbQuantum.setText(bundle.getString("QUANTUM:")); // NOI18N
        txtQuantum.setText(bundle.getString("0")); // NOI18N
        txtQuantum.setName("txtQuantum"); // NOI18N
        jLabel1.setText(bundle.getString("PROCESSOS CARREGADOS:")); // NOI18N
        jLabel2.setText(bundle.getString("TEMPOS DE ESPERA E TURNAROUND CALCULADOS:")); // NOI18N
        jLabel3.setText(bundle.getString("PROCESSO: CHEGADA : DURAÇÃO: PRIORIDADE")); // NOI18N
        jLabel4.setText(bundle.getString("PROCESSO : ESPERA: TURNAROUND")); // NOI18N
        jMenu1.setText(bundle.getString("ESCALONADOR")); // NOI18N
        jCheckBoxMenuItem1.setText(bundle.getString("FCFS")); // NOI18N
        jCheckBoxMenuItem2.setText(bundle.getString("SJF")); // NOI18N
        jCheckBoxMenuItem3.setText(bundle.getString("SRT")); // NOI18N
        jCheckBoxMenuItem4.setText(bundle.getString("PRIORIDADE NP")); // NOI18N
        jCheckBoxMenuItem5.setText(bundle.getString("PRIORIDADE P")); // NOI18N
        jCheckBoxMenuItem6.setText(bundle.getString("RR")); // NOI18N
        jMenu2.setText(bundle.getString("PROCESSOS")); // NOI18N
        jMenuItem7.setText(bundle.getString("DIGITAR")); // NOI18N
        jMenuItem8.setText(bundle.getString("LER DO ARQUIVO")); // NOI18N
        jMenuItem1.setText(bundle.getString("GRAVAR EM AQUIVO")); // NOI18N
        jMenu3.setText(bundle.getString("Opcoes")); // NOI18N
        jCheckBoxMenuItem7.setText(bundle.getString("Portugues")); // NOI18N
        jCheckBoxMenuItem8.setText(bundle.getString("Ingles")); // NOI18N
        jMenu4.setText(bundle.getString("AJUDA")); // NOI18N
        jMenuItem9.setText(bundle.getString("MANUAL")); // NOI18N
        jMenuSobre.setText(bundle.getString("SOBRE")); // NOI18N
        jCheckBoxMenuItem9.setText(bundle.getString("grafico Ret3d")); // NOI18N
        jCheckBoxMenuItem10.setText(bundle.getString("grafico RetRound")); // NOI18N
        jCheckBoxMenuItem11.setText(bundle.getString("grafico RetRoundF")); // NOI18N
    }

    private void MenuSobre(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSobre
        new formSobre(this, true).setVisible(true);

    }//GEN-LAST:event_MenuSobre

    private void btnRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunActionPerformed

        String resultado;
        float mEspera = 0, mTurna = 0;

        if (lista_procs == null || lista_procs.isEmpty()) {
            return;
        }
        //envia para o escalonador a lista de processos a ser escalonada
        e.setEntrada(lista_procs);
        int Q; //valor do Quantum quando executar Round Robin

        switch (buttonGroup1.getSelection().getMnemonic()) {
            case 49:
                e.escalonarFCFS();
                break;
            case 50:
                e.escalonarSJFnP();
                break;
            case 51:
                e.escalonarSRT();
                break;
            case 52:
                e.escalonarPrioridadeNP();
                break;
            case 53:
                e.escalonarPrioridadeP();
                break;
            case 54:
                //antes de acionar o escalonador, valida o Quantum
                try {
                    Q = Integer.parseInt(txtQuantum.getText());
                    if (Q <= 0) {
                        JOptionPane.showMessageDialog(this, java.util.ResourceBundle.getBundle("telas/Principal").getString("VALOR DE QUANTUM INVÁLIDO!"));
                        return;
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, java.util.ResourceBundle.getBundle("telas/Principal").getString("VALOR DE QUANTUM INVÁLIDO!"));
                    return;
                }
                e.escalonarRR(Q);
                break;
        }
        //Exibir respostas na interface
        resp = e.retEscala();
        resultado = "";
        String aux;
        for (Processo p : resp) {
            aux = String.format("%-3s : %02d : %02d \n", p.getId(), p.getEspera(), p.getTurnaround());
            resultado += aux;
            mEspera += p.getEspera();
            mTurna += p.getTurnaround();
        }
        mEspera /= resp.size();
        mTurna /= resp.size();
        aux = String.format(java.util.ResourceBundle.getBundle("telas/Principal").getString("SAIDA"), mEspera, mTurna);
        resultado += aux;
        txtSaida.setText(resultado);

        if (barra != null) {
            this.remove(barra);
        }

        barra = new Grafico(e.retGraf(), tipoGrafico);
        barra.setLocation(30, 20);
        barra.setSize(200, 50);
        barra.setVisible(true);

        this.add(barra);

        barra.repaint();
    }//GEN-LAST:event_btnRunActionPerformed

    private void jCheckBoxMenuItem6StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem6StateChanged
        if (jCheckBoxMenuItem6.isSelected()) {
            lbQuantum.setVisible(true);
            txtQuantum.setVisible(true);
        }
        else {
            lbQuantum.setVisible(false);
            txtQuantum.setVisible(false);
        }
    }//GEN-LAST:event_jCheckBoxMenuItem6StateChanged

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void MenuLerArquivo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuLerArquivo
        String Entrada;

        //cria uma lista temporária para ler o arquivo e validar os dados
        ArrayList<Processo> temp = Armazenar.ler();
        if (temp == null) {
            javax.swing.JOptionPane.showMessageDialog(this, java.util.ResourceBundle.getBundle("telas/Principal").getString("O ARQUIVO DE ENTRADA NÃO FOI CARREGADO!"), java.util.ResourceBundle.getBundle("telas/Principal").getString("ATENÇÃO"), JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        //depois de validar os dados a lista temporária é atribuída para o lista atual de processos
        lista_procs = temp;
        btnRun.setEnabled(true); //habilita para execução.
        
        //Exibe os processos carregados na Interface
        String aux;
        Entrada = "";
        for (Processo p : lista_procs) {
            aux = String.format("%-3S : %02d : %02d : %02d \n", p.getId(), p.getChegada(), p.getDuracao(), p.getPrioridade());
            Entrada += aux;
        }
        txtEntrada.setText(Entrada);


    }//GEN-LAST:event_MenuLerArquivo

    private void MenuDigitarProcs(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuDigitarProcs
        boolean alterou = false;
        //faz uma cópia da lista atual antes de abrir a interface para editar os processos
        ArrayList<Processo> temp = new ArrayList<>();
        if (lista_procs != null && !lista_procs.isEmpty())
            for (Processo p : lista_procs) {
                temp.add(new Processo(p));
            }

        if(lista_procs == null)
            lista_procs = new ArrayList<>();
        new formProcessos(this, true, lista_procs).setVisible(true);

        //se não há nada na lista, não há o que mostrar
        if (lista_procs == null || lista_procs.isEmpty()) {
            txtEntrada.setText("");
            btnRun.setEnabled(true);
            return;
        }

        //Ao retornar da interface, verifica se houve mudança na lista
        if (lista_procs.size() != temp.size()) {
            alterou = true;
        }
        else {
            for (int i = 0; i < lista_procs.size() && (!alterou); i++) {
                if (!lista_procs.get(i).igual(temp.get(i))) {
                    alterou = true;
                }
            }
        }
        //Caso tenha havido alteração, atualiza a interface
        if (alterou) {
            String aux;
            String Entrada = "";

            txtSaida.setText("");
            if (barra != null) {
                this.remove(barra);
            }
            this.repaint();
            for (Processo p : lista_procs) {
                aux = String.format("%-3s : %02d : %02d : %02d \n", p.getId(), p.getChegada(), p.getDuracao(), p.getPrioridade());
                Entrada += aux;
            }
            txtEntrada.setText(Entrada);
            btnRun.setEnabled(true);
        }

    }//GEN-LAST:event_MenuDigitarProcs

    private void MenuGravarArquivo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuGravarArquivo
        if (lista_procs != null) {
            Armazenar.gravar(lista_procs);
        }
    }//GEN-LAST:event_MenuGravarArquivo

    private void jCheckBoxMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem7ActionPerformed
        Locale.setDefault(new Locale("pt", "BR"));
        ReinitComponents();
        this.validate();
    }//GEN-LAST:event_jCheckBoxMenuItem7ActionPerformed
    private void ajustaMenu() {
        Locale atual = this.getLocale();
        if (atual.getLanguage().equals("en")) {
            jCheckBoxMenuItem8.setSelected(true);
        }

    }
    private void jCheckBoxMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem8ActionPerformed
        Locale.setDefault(new Locale("en", "US"));
        ReinitComponents();
        this.validate();
    }//GEN-LAST:event_jCheckBoxMenuItem8ActionPerformed

    private void jCheckBoxMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem9ActionPerformed
        tipoGrafico = Grafico.RET3D;
    }//GEN-LAST:event_jCheckBoxMenuItem9ActionPerformed

    private void jCheckBoxMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem10ActionPerformed
        tipoGrafico = Grafico.RET_ROUND;
    }//GEN-LAST:event_jCheckBoxMenuItem10ActionPerformed

    private void jCheckBoxMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem11ActionPerformed
        tipoGrafico = Grafico.RET_ROUND_F;
    }//GEN-LAST:event_jCheckBoxMenuItem11ActionPerformed

    private void MenuManual(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuManual
        String url = System.getProperty("user.dir") + "\\help.html";
        try {
            java.awt.Desktop.getDesktop().open(new java.io.File(url));
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, java.util.ResourceBundle.getBundle("telas/Principal").getString("help"), java.util.ResourceBundle.getBundle("telas/Principal").getString("ATENÇÃO"), JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_MenuManual

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        float mEspera = 0, mTurna = 0;
        String aux;
       
        if (barra != null) {
            Rectangle screenRect = new Rectangle();
            screenRect.setLocation((int) barra.getLocationOnScreen().getX() - 5, (int) barra.getLocationOnScreen().getY());
            screenRect.setSize(barra.getWidth() + 5, barra.getHeight() + 5);
            Robot robot;
            try {
                Document doc = new Document(PageSize.A4);

                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.pdf", "pdf");
                javax.swing.JFileChooser arquivo = new javax.swing.JFileChooser(System.getProperty("user.dir"));
                arquivo.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);
                arquivo.addChoosableFileFilter(filter);
                if (arquivo.showSaveDialog(arquivo) == javax.swing.JFileChooser.APPROVE_OPTION) {
                    File file = arquivo.getSelectedFile();

                    if (!file.getName().endsWith("pdf"))
                        file = new File(file.getPath() + ".pdf");
                    if (file.exists()) {
                        int opc = JOptionPane.showConfirmDialog(null, "Sobrescrever o arquivo?", "ATENÇÃO", JOptionPane.YES_NO_OPTION);
                        if (opc == JOptionPane.NO_OPTION)
                            return;
                    }

                    FileOutputStream os = new FileOutputStream(file.getPath());
                    PdfWriter writer = PdfWriter.getInstance(doc, os);
                    doc.addAuthor("Emerson S. Paduan");
                    doc.addCreator("Escalonar v1.0");
                    doc.open();
                    PdfContentByte cb = writer.getDirectContent();

                java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("telas/Principal"); // NOI18N
                robot = new Robot();
                BufferedImage image = robot.createScreenCapture(screenRect);
                java.awt.Image x = image;

                    Image im = Image.getInstance(x, null);
                    //ajusta parao gráfico não ultrapassar o tamanho da folha A4
                    //im.scalePercent(50);
                    im.scaleToFit(500, 27);
                    //posiciona o gráfico na folha
                    im.setAbsolutePosition(80, 780);

                    Font f = new Font(Font.getFamily("Arial"), 10);
                    doc.add(new Paragraph("Gantt:", f));
                    doc.add(Chunk.NEWLINE);
                    doc.add(Chunk.NEWLINE);
                    doc.add(Chunk.NEWLINE);
                    doc.add(new Paragraph(bundle.getString("PROCESSOS CARREGADOS:"), f));
                    doc.add(new Paragraph(bundle.getString("PROCESSO: CHEGADA : DURAÇÃO: PRIORIDADE"), f)); // NOI18N
                    for (Processo p : lista_procs) {
                        aux = String.format("%-3s : %02d : %02d : %02d \n", p.getId(), p.getChegada(), p.getDuracao(), p.getPrioridade());
                        doc.add(new Paragraph(aux, f));
                    }

                    cb.addImage(im);
                    doc.add(Chunk.NEWLINE);
                    doc.add(new Paragraph(bundle.getString("PROCESSO : ESPERA: TURNAROUND"), f));
                    for (Processo p : resp) {
                        aux = String.format("%-3s : %02d : %02d \n", p.getId(), p.getEspera(), p.getTurnaround());
                        doc.add(new Paragraph(aux, f));
                        mEspera += p.getEspera();
                        mTurna += p.getTurnaround();
                    }
                    mEspera /= resp.size();
                    mTurna /= resp.size();
                    aux = String.format(java.util.ResourceBundle.getBundle("telas/Principal").getString("SAIDA"), mEspera, mTurna);
                    doc.add(new Paragraph(aux, f));
                    doc.close();
                    javax.swing.JOptionPane.showMessageDialog(null, java.util.ResourceBundle.getBundle("telas/Principal").getString("PDFOK"));
                }
            } catch (Exception ex) {
                javax.swing.JOptionPane.showMessageDialog(null, java.util.ResourceBundle.getBundle("telas/Principal").getString("PDF"));
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /*
     * Inicia o aplicativo
     * @param Nenhum
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if (java.util.ResourceBundle.getBundle("telas/Principal").getString("NIMBUS").equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (UnsupportedLookAndFeelException e) {
                    JOptionPane.showMessageDialog(null, java.util.ResourceBundle.getBundle("telas/Principal").getString("SEU SISTEMA NÃO SUPORTA INTERFACE NIMBUS"), java.util.ResourceBundle.getBundle("telas/Principal").getString("INTERFACE"), JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    javax.swing.JOptionPane.showMessageDialog(null, java.util.ResourceBundle.getBundle("telas/Principal").getString("ERRO: ") + ex.toString());
                }

                new Principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRun;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem10;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem11;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem4;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem5;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem6;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem7;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem8;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuSobre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lbQuantum;
    private javax.swing.JTextArea txtEntrada;
    private javax.swing.JTextField txtQuantum;
    private javax.swing.JTextArea txtSaida;
    // End of variables declaration//GEN-END:variables
}
