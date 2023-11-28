package com.rinha.gui;

import com.rinha.ataque.Ataque;
import com.rinha.batalha.Batalha;
import com.rinha.galos.*;
import com.rinha.loja.Loja;
import com.rinha.perfil.Perfil;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class mainFrame extends javax.swing.JFrame {
    // Informações do PLayer
    Perfil player = new Perfil("Desafiante");
        
    // Informações dos Galos
    Galinheiro galinheiro = new Galinheiro();
    ArrayList<Galo> galosIniciais = galinheiro.gerarGalosIniciais();
    
    // Informações da Loja
    Loja loja = new Loja(20);
    
    // Informações da Batalha
    Batalha batalhaAtual;
    int usuarioAtq = 0;
    
    // Informações para navegação da interface
    String ultimaTela = "telaDashBoard";
    
    // Construtor
    public mainFrame() {
        initComponents();
    }
    
    /*
    * Minhas funções para auxiliar nas informações da interface
    */
    public void trocarTela(String nomeDoCard){
        CardLayout cl = (CardLayout) this.painelPrincipal.getLayout();
        cl.show(this.painelPrincipal, nomeDoCard);
    }
    
    public void voltarTela(){
        CardLayout cl = (CardLayout) this.painelPrincipal.getLayout();
        cl.show(this.painelPrincipal, this.ultimaTela);
    }
    
    public void updateLabelsPPeNomeAtaque(){
        // Atualiza label do pp e do nome do ataque
        Ataque ataque;
        if (usuarioAtq != 0){
            // Nome do ataque
            ataque = this.batalhaAtual.getPlayer().getAtaque(usuarioAtq);
            this.labelPP.setText("PP: " + ataque.getPontosDePoderAtual());
            this.labelNomeAtq.setText(ataque.getNomeAtaque());
        }
        else {
            // Caso ainda não haja ataque selecionado
            this.labelNomeAtq.setText("Selecione o Ataque");
            this.labelPP.setText("");
        }
        // Botoes dos ataques dos galos
        botaoAtqBasico.setText(batalhaAtual.getPlayer().getAtaque(1).getNomeAtaque());
        botaoAtqTipificado.setText(batalhaAtual.getPlayer().getAtaque(2).getNomeAtaque());
        botaoAtqAgil.setText(batalhaAtual.getPlayer().getAtaque(3).getNomeAtaque());
        botaoAtqUltimate.setText(batalhaAtual.getPlayer().getAtaque(4).getNomeAtaque());
    }
    
    public void updateLabelsFoto(){
        // Atualiza as fotos de batalha dos Galos
        labelFotoMaquina.setIcon(batalhaAtual.getMaquina().getFotoBatalha());
        labelFotoPlayer.setIcon(batalhaAtual.getPlayer().getFotoBatalha());
    }
    
    public void updateBarrasVida(){
        // Atualização das barras de vida e das labels com o valor
        this.vidaMaquina.setValue(batalhaAtual.getMaquina().getPercentualVidaAtual());
        this.labelVidaMaquina.setText(Integer.toString(batalhaAtual.getMaquina().getVidaAtual()));
        this.vidaPlayer.setValue(batalhaAtual.getPlayer().getPercentualVidaAtual());
        this.labelVidaPlayer.setText(Integer.toString(batalhaAtual.getPlayer().getVidaAtual()));
    }
    
    public void updateInfoTelaBatalha(){
        // Atualiza as informações da tela de batalha
        this.updateLabelsPPeNomeAtaque();
        this.updateLabelsFoto();
        this.updateBarrasVida();
    }
    
    public void updateTablePocoesLoja(){
        DefaultTableModel table = (DefaultTableModel) this.tablePocoesLoja.getModel();
        table.setRowCount(0);
        int tamanho = this.loja.getQuantidadePocoes();
        for (int index = 0; index < tamanho; index++){
            Object[] dados = this.loja.getInfoPocoes(index);
            table.addRow(dados);
        }
    }
    
    public void updateTableMilhosLoja(){
        DefaultTableModel table = (DefaultTableModel) this.tableMilhosLoja.getModel();
        table.setRowCount(0);
        int tamanho = loja.getQuantidadeMilhos();
        for (int index = 0; index < tamanho; index++){
            Object[] dados = loja.getInfoMilhos(index);
            table.addRow(dados);
        }
    }
    
    public void updateInfoTelaLoja(){
        this.updateTableMilhosLoja();
        this.updateTablePocoesLoja();
        this.labelSaldoCarteira.setText(Integer.toString(player.getCarteira().getSaldo()));
    }
    
    public void updateTableGaloDex(){
        DefaultTableModel table = (DefaultTableModel) this.tableGaloDex.getModel();
        table.setRowCount(0);
        int tamanho = player.getGaloDex().getTamanho();
        for (int index = 0; index < tamanho; index++){
            Object[] dados = player.getGaloDex().getInfoGalo(index);
            table.addRow(dados);
        }
    }
    
    public void updateInfoGaloDex(){
        this.labelApelidoAtacanteGaloDex.setText(player.getGaloDex().getAtacante().getApelido());
        this.labelFotoAtacanteGaloDex.setIcon(player.getGaloDex().getAtacante().getFotoBatalha());
        this.labelNomeAtacanteGaloDex.setText("" + player.getGaloDex().getAtacante().getNome());
        this.labelAgilidadeAtacanteGaloDex.setText("Agilidade: " + player.getGaloDex().getAtacante().getAgilidade());
        this.labelForcaAtacanteGaloDex.setText("Força: " + player.getGaloDex().getAtacante().getForca());
        this.labelDefesaAtacanteGaloDex.setText("Defesa: " + player.getGaloDex().getAtacante().getDefesa());
        this.updateTableGaloDex();
        
    }
    
    public void abrirGaloDex(){
        dialogGaloDex.setVisible(true);
        this.updateTableGaloDex();
    }

    /*
    * Funções para batalha
    */
    public void criarBatalhaRapida(){
        this.batalhaAtual = new Batalha(player);
    }

    /*
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogGaloDex = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableGaloDex = new javax.swing.JTable();
        botaoSelecionarAtacante = new javax.swing.JButton();
        labelSelecione = new javax.swing.JLabel();
        labelFotoAtacanteGaloDex = new javax.swing.JLabel();
        labelApelidoAtacanteGaloDex = new javax.swing.JLabel();
        labelForcaAtacanteGaloDex = new javax.swing.JLabel();
        labelAgilidadeAtacanteGaloDex = new javax.swing.JLabel();
        labelDefesaAtacanteGaloDex = new javax.swing.JLabel();
        labelNomeAtacanteGaloDex = new javax.swing.JLabel();
        painelPrincipal = new javax.swing.JPanel();
        telaInicial = new javax.swing.JPanel();
        botaoPlay = new javax.swing.JButton();
        labelRinhaNome = new javax.swing.JLabel();
        labelBackgroundTelaInicial = new javax.swing.JLabel();
        telaDashBoard = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        botaoTorneios = new javax.swing.JButton();
        botaoLoja = new javax.swing.JButton();
        botaoPerfil = new javax.swing.JButton();
        botaoPartidaRapida = new javax.swing.JButton();
        botaoGaloDex = new javax.swing.JButton();
        labelBackgroundDashBoard = new javax.swing.JLabel();
        telaLoja = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePocoesLoja = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableMilhosLoja = new javax.swing.JTable();
        botaoVoltarLoja = new javax.swing.JButton();
        botaoComprarPocao = new javax.swing.JButton();
        botaoComprarMilho = new javax.swing.JButton();
        labelSaldoCarteira = new javax.swing.JLabel();
        telaBatalha = new javax.swing.JPanel();
        labelFotoPlayer = new javax.swing.JLabel();
        painelFuncoesAtaque = new javax.swing.JPanel();
        botaoAtqBasico = new javax.swing.JButton();
        botaoAtqTipificado = new javax.swing.JButton();
        botaoAtqUltimate = new javax.swing.JButton();
        botaoAtqAgil = new javax.swing.JButton();
        botaoAtacar = new javax.swing.JButton();
        labelPP = new javax.swing.JLabel();
        labelNomeAtq = new javax.swing.JLabel();
        labelFotoMaquina = new javax.swing.JLabel();
        vidaMaquina = new javax.swing.JProgressBar();
        vidaPlayer = new javax.swing.JProgressBar();
        labelNomePlayer = new javax.swing.JLabel();
        labelNomeMaquina = new javax.swing.JLabel();
        botaoDesistir = new javax.swing.JButton();
        labelVidaPlayer = new javax.swing.JLabel();
        labelVidaMaquina = new javax.swing.JLabel();
        telaBemVindo = new javax.swing.JPanel();
        botaoInicial2 = new javax.swing.JButton();
        botaoInicial0 = new javax.swing.JButton();
        botaoInicial1 = new javax.swing.JButton();
        labelBemVindo = new javax.swing.JLabel();
        telaGaloDex = new javax.swing.JPanel();

        dialogGaloDex.setMaximumSize(dialogGaloDex.getPreferredSize());
        dialogGaloDex.setMinimumSize(dialogGaloDex.getPreferredSize());
        dialogGaloDex.setPreferredSize(new java.awt.Dimension(600, 400));
        dialogGaloDex.setResizable(false);
        dialogGaloDex.setSize(new java.awt.Dimension(600, 400));
        dialogGaloDex.setLocationRelativeTo(null);
        dialogGaloDex.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableGaloDex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Galo", "Tipo", "Raridade", "Nivel", "Vida"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableGaloDex);
        if (tableGaloDex.getColumnModel().getColumnCount() > 0) {
            tableGaloDex.getColumnModel().getColumn(0).setResizable(false);
            tableGaloDex.getColumnModel().getColumn(1).setResizable(false);
            tableGaloDex.getColumnModel().getColumn(2).setResizable(false);
            tableGaloDex.getColumnModel().getColumn(3).setResizable(false);
            tableGaloDex.getColumnModel().getColumn(4).setResizable(false);
        }

        dialogGaloDex.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 480, 160));

        botaoSelecionarAtacante.setText("Selecionar");
        botaoSelecionarAtacante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSelecionarAtacanteActionPerformed(evt);
            }
        });
        dialogGaloDex.getContentPane().add(botaoSelecionarAtacante, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 130, 40));

        labelSelecione.setFont(new java.awt.Font("sansserif", 0, 13)); // NOI18N
        labelSelecione.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSelecione.setText("<html> <p align=\"justify\"> Escolha um galo da sua GaloDex e clique em Selecionar pra defini-lo como seu galo Atacante.</p> </html>");
        labelSelecione.setToolTipText("");
        dialogGaloDex.getContentPane().add(labelSelecione, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 130, 90));
        dialogGaloDex.getContentPane().add(labelFotoAtacanteGaloDex, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 150, 150));

        labelApelidoAtacanteGaloDex.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        labelApelidoAtacanteGaloDex.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelApelidoAtacanteGaloDex.setText("...");
        dialogGaloDex.getContentPane().add(labelApelidoAtacanteGaloDex, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 167, 45));

        labelForcaAtacanteGaloDex.setText("Força:");
        dialogGaloDex.getContentPane().add(labelForcaAtacanteGaloDex, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, -1, -1));

        labelAgilidadeAtacanteGaloDex.setText("Agilidade:");
        dialogGaloDex.getContentPane().add(labelAgilidadeAtacanteGaloDex, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, -1));

        labelDefesaAtacanteGaloDex.setText("Defesa:");
        dialogGaloDex.getContentPane().add(labelDefesaAtacanteGaloDex, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, -1, -1));

        labelNomeAtacanteGaloDex.setText("Galo Alguma Coisa");
        dialogGaloDex.getContentPane().add(labelNomeAtacanteGaloDex, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("rinha");
        setMinimumSize(new java.awt.Dimension(720, 480));
        setName("mainFrame"); // NOI18N
        setResizable(false);
        setSize(getPreferredSize());

        painelPrincipal.setAlignmentX(0.0F);
        painelPrincipal.setAlignmentY(0.0F);
        painelPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        painelPrincipal.setMaximumSize(getPreferredSize());
        painelPrincipal.setMinimumSize(getPreferredSize());
        painelPrincipal.setName(""); // NOI18N
        painelPrincipal.setPreferredSize(getPreferredSize());
        painelPrincipal.setLayout(new java.awt.CardLayout());

        telaInicial.setAlignmentX(0.0F);
        telaInicial.setAlignmentY(0.0F);
        telaInicial.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        telaInicial.setMaximumSize(getPreferredSize());
        telaInicial.setMinimumSize(getPreferredSize());
        telaInicial.setName(""); // NOI18N
        telaInicial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botaoPlay.setBackground(new java.awt.Color(246, 110, 21));
        botaoPlay.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        botaoPlay.setForeground(new java.awt.Color(238, 240, 242));
        botaoPlay.setText("play");
        botaoPlay.setBorder(null);
        botaoPlay.setFocusPainted(false);
        botaoPlay.setRolloverEnabled(false);
        botaoPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPlayActionPerformed(evt);
            }
        });
        telaInicial.add(botaoPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 200, 50));

        labelRinhaNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/nomerinha.png"))); // NOI18N
        telaInicial.add(labelRinhaNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 240, 90));

        labelBackgroundTelaInicial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/telaInicial.gif"))); // NOI18N
        telaInicial.add(labelBackgroundTelaInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 480));

        painelPrincipal.add(telaInicial, "telaInicial");

        telaDashBoard.setForeground(new java.awt.Color(255, 255, 255));
        telaDashBoard.setAlignmentX(0.0F);
        telaDashBoard.setAlignmentY(0.0F);
        telaDashBoard.setMaximumSize(getPreferredSize());
        telaDashBoard.setMinimumSize(getPreferredSize());
        telaDashBoard.setPreferredSize(getPreferredSize());
        telaDashBoard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome do Desafiante 3");
        telaDashBoard.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 280, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Milhos:");
        telaDashBoard.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Poções de Cura:");
        telaDashBoard.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        botaoTorneios.setBackground(new java.awt.Color(255, 135, 30));
        botaoTorneios.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        botaoTorneios.setForeground(new java.awt.Color(255, 255, 255));
        botaoTorneios.setText("Torneios");
        botaoTorneios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoTorneiosActionPerformed(evt);
            }
        });
        telaDashBoard.add(botaoTorneios, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 386, 182, 54));

        botaoLoja.setBackground(new java.awt.Color(75, 150, 187));
        botaoLoja.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        botaoLoja.setForeground(new java.awt.Color(255, 255, 255));
        botaoLoja.setText("Loja");
        botaoLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLojaActionPerformed(evt);
            }
        });
        telaDashBoard.add(botaoLoja, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 386, 182, 54));

        botaoPerfil.setBackground(new java.awt.Color(228, 56, 82));
        botaoPerfil.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        botaoPerfil.setForeground(new java.awt.Color(255, 255, 255));
        botaoPerfil.setText("Perfil");
        botaoPerfil.setAlignmentY(0.0F);
        botaoPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPerfilActionPerformed(evt);
            }
        });
        telaDashBoard.add(botaoPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 100, 31));

        botaoPartidaRapida.setBackground(new java.awt.Color(255, 135, 30));
        botaoPartidaRapida.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        botaoPartidaRapida.setForeground(new java.awt.Color(255, 255, 255));
        botaoPartidaRapida.setText("Partida Rápida");
        botaoPartidaRapida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPartidaRapidaActionPerformed(evt);
            }
        });
        telaDashBoard.add(botaoPartidaRapida, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 182, 54));

        botaoGaloDex.setBackground(new java.awt.Color(228, 56, 82));
        botaoGaloDex.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        botaoGaloDex.setForeground(new java.awt.Color(255, 255, 255));
        botaoGaloDex.setText("GaloDex");
        botaoGaloDex.setAlignmentY(0.0F);
        botaoGaloDex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGaloDexActionPerformed(evt);
            }
        });
        telaDashBoard.add(botaoGaloDex, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 83, 100, 31));

        labelBackgroundDashBoard.setForeground(new java.awt.Color(255, 255, 255));
        labelBackgroundDashBoard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/telaDashboard.png"))); // NOI18N
        labelBackgroundDashBoard.setToolTipText("");
        telaDashBoard.add(labelBackgroundDashBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 480));

        painelPrincipal.add(telaDashBoard, "telaDashBoard");

        telaLoja.setAlignmentX(0.0F);
        telaLoja.setAlignmentY(0.0F);
        telaLoja.setMaximumSize(getPreferredSize());
        telaLoja.setMinimumSize(getPreferredSize());

        tablePocoesLoja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Restauração", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablePocoesLoja);
        if (tablePocoesLoja.getColumnModel().getColumnCount() > 0) {
            tablePocoesLoja.getColumnModel().getColumn(0).setResizable(false);
            tablePocoesLoja.getColumnModel().getColumn(1).setResizable(false);
        }

        tableMilhosLoja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Xp", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableMilhosLoja);
        if (tableMilhosLoja.getColumnModel().getColumnCount() > 0) {
            tableMilhosLoja.getColumnModel().getColumn(0).setResizable(false);
            tableMilhosLoja.getColumnModel().getColumn(1).setResizable(false);
        }

        botaoVoltarLoja.setText("Voltar");
        botaoVoltarLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarLojaActionPerformed(evt);
            }
        });

        botaoComprarPocao.setText("Comprar");
        botaoComprarPocao.setToolTipText("");
        botaoComprarPocao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoComprarPocaoActionPerformed(evt);
            }
        });

        botaoComprarMilho.setText("Comprar");
        botaoComprarMilho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoComprarMilhoActionPerformed(evt);
            }
        });

        labelSaldoCarteira.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelSaldoCarteira.setText("Tua Grana");

        javax.swing.GroupLayout telaLojaLayout = new javax.swing.GroupLayout(telaLoja);
        telaLoja.setLayout(telaLojaLayout);
        telaLojaLayout.setHorizontalGroup(
            telaLojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaLojaLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(telaLojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(telaLojaLayout.createSequentialGroup()
                        .addGroup(telaLojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(telaLojaLayout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaoComprarMilho))
                            .addGroup(telaLojaLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaoComprarPocao)))
                        .addContainerGap(412, Short.MAX_VALUE))
                    .addGroup(telaLojaLayout.createSequentialGroup()
                        .addComponent(botaoVoltarLoja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelSaldoCarteira, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );
        telaLojaLayout.setVerticalGroup(
            telaLojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaLojaLayout.createSequentialGroup()
                .addGroup(telaLojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(telaLojaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoComprarMilho, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(telaLojaLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(telaLojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoVoltarLoja)
                            .addComponent(labelSaldoCarteira))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(telaLojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoComprarPocao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 78, 78))
        );

        painelPrincipal.add(telaLoja, "telaLoja");

        telaBatalha.setAlignmentX(0.0F);
        telaBatalha.setAlignmentY(0.0F);
        telaBatalha.setMaximumSize(getPreferredSize());
        telaBatalha.setMinimumSize(getPreferredSize());
        telaBatalha.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelFotoPlayer.setMaximumSize(labelFotoPlayer.getPreferredSize());
        labelFotoPlayer.setMinimumSize(labelFotoPlayer.getPreferredSize());
        telaBatalha.add(labelFotoPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 150, 150));

        painelFuncoesAtaque.setBackground(new java.awt.Color(238, 240, 242));

        botaoAtqBasico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtqBasicoActionPerformed(evt);
            }
        });

        botaoAtqTipificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtqTipificadoActionPerformed(evt);
            }
        });

        botaoAtqUltimate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtqUltimateActionPerformed(evt);
            }
        });

        botaoAtqAgil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtqAgilActionPerformed(evt);
            }
        });

        botaoAtacar.setText("Atacar");
        botaoAtacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtacarActionPerformed(evt);
            }
        });

        labelPP.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        labelPP.setText("PP:");
        labelPP.setAlignmentY(0.0F);

        labelNomeAtq.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        labelNomeAtq.setText("Ataque");

        javax.swing.GroupLayout painelFuncoesAtaqueLayout = new javax.swing.GroupLayout(painelFuncoesAtaque);
        painelFuncoesAtaque.setLayout(painelFuncoesAtaqueLayout);
        painelFuncoesAtaqueLayout.setHorizontalGroup(
            painelFuncoesAtaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFuncoesAtaqueLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(painelFuncoesAtaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoAtqTipificado, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoAtqBasico, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelFuncoesAtaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoAtqAgil, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoAtqUltimate, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelFuncoesAtaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPP)
                    .addComponent(labelNomeAtq)
                    .addComponent(botaoAtacar, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelFuncoesAtaqueLayout.setVerticalGroup(
            painelFuncoesAtaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFuncoesAtaqueLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(painelFuncoesAtaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelFuncoesAtaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(botaoAtqAgil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoAtqBasico, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFuncoesAtaqueLayout.createSequentialGroup()
                        .addComponent(labelNomeAtq)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelPP, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(painelFuncoesAtaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAtqTipificado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoAtqUltimate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoAtacar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        telaBatalha.add(painelFuncoesAtaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 720, 160));

        labelFotoMaquina.setMaximumSize(new java.awt.Dimension(140, 140));
        labelFotoMaquina.setMinimumSize(new java.awt.Dimension(140, 140));
        labelFotoMaquina.setPreferredSize(new java.awt.Dimension(140, 140));
        telaBatalha.add(labelFotoMaquina, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 140, 140));
        telaBatalha.add(vidaMaquina, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 200, 20));
        telaBatalha.add(vidaPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 200, 20));

        labelNomePlayer.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        telaBatalha.add(labelNomePlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, -1, -1));

        labelNomeMaquina.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        telaBatalha.add(labelNomeMaquina, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, -1, -1));

        botaoDesistir.setBackground(new java.awt.Color(228, 56, 82));
        botaoDesistir.setText("Desistir");
        botaoDesistir.setToolTipText("");
        botaoDesistir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDesistirActionPerformed(evt);
            }
        });
        telaBatalha.add(botaoDesistir, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        labelVidaPlayer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        telaBatalha.add(labelVidaPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 40, -1));

        labelVidaMaquina.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelVidaMaquina.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        telaBatalha.add(labelVidaMaquina, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 40, -1));

        painelPrincipal.add(telaBatalha, "telaBatalha");

        telaBemVindo.setAlignmentX(0.0F);
        telaBemVindo.setAlignmentY(0.0F);
        telaBemVindo.setMaximumSize(getPreferredSize());
        telaBemVindo.setMinimumSize(getPreferredSize());
        telaBemVindo.setPreferredSize(new java.awt.Dimension(720, 480));
        telaBemVindo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botaoInicial2.setIcon(galosIniciais.get(2).getFotoBatalha());
        botaoInicial2.setMaximumSize(new java.awt.Dimension(150, 150));
        botaoInicial2.setMinimumSize(new java.awt.Dimension(150, 150));
        botaoInicial2.setPreferredSize(new java.awt.Dimension(150, 150));
        botaoInicial2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoInicial2ActionPerformed(evt);
            }
        });
        telaBemVindo.add(botaoInicial2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, -1, -1));

        botaoInicial0.setIcon(galosIniciais.get(0).getFotoBatalha());
        botaoInicial0.setMaximumSize(new java.awt.Dimension(150, 150));
        botaoInicial0.setMinimumSize(new java.awt.Dimension(150, 150));
        botaoInicial0.setPreferredSize(new java.awt.Dimension(150, 150));
        botaoInicial0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoInicial0ActionPerformed(evt);
            }
        });
        telaBemVindo.add(botaoInicial0, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        botaoInicial1.setIcon(galosIniciais.get(1).getFotoBatalha());
        botaoInicial1.setMaximumSize(new java.awt.Dimension(150, 150));
        botaoInicial1.setMinimumSize(new java.awt.Dimension(150, 150));
        botaoInicial1.setPreferredSize(new java.awt.Dimension(150, 150));
        botaoInicial1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoInicial1ActionPerformed(evt);
            }
        });
        telaBemVindo.add(botaoInicial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, -1, -1));

        labelBemVindo.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        labelBemVindo.setText("<html> <p align=\"center\">Bem-vindo, desafiante!<br> Escolha com sabedoria um dos Galos abaixo para ser seu inicial. </p> </html>");
        telaBemVindo.add(labelBemVindo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

        painelPrincipal.add(telaBemVindo, "telaBemVindo");

        telaGaloDex.setAlignmentX(0.0F);
        telaGaloDex.setAlignmentY(0.0F);
        telaGaloDex.setMaximumSize(getPreferredSize());
        telaGaloDex.setMinimumSize(getPreferredSize());
        telaGaloDex.setPreferredSize(new java.awt.Dimension(720, 480));

        javax.swing.GroupLayout telaGaloDexLayout = new javax.swing.GroupLayout(telaGaloDex);
        telaGaloDex.setLayout(telaGaloDexLayout);
        telaGaloDexLayout.setHorizontalGroup(
            telaGaloDexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        telaGaloDexLayout.setVerticalGroup(
            telaGaloDexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        painelPrincipal.add(telaGaloDex, "telaGaloDex");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        painelPrincipal.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPlayActionPerformed
        // botaoPlay encaminha a tela para o dashboard
        trocarTela("telaBemVindo");
        galosIniciais = galinheiro.gerarGalosIniciais();
        
    }//GEN-LAST:event_botaoPlayActionPerformed

    private void botaoPartidaRapidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPartidaRapidaActionPerformed
        // botaoPartidaRapida gera e encaminha para uma partida aleatória
        if (player.getGaloDex().getAtacante() == null){
            this.abrirGaloDex();
        }
        else {
            trocarTela("telaBatalha");
            criarBatalhaRapida();
            updateInfoTelaBatalha();
            // Informações adicionais para a batalha rápida
            vidaMaquina.setValue(100);
            vidaPlayer.setValue(100);
        }
    }//GEN-LAST:event_botaoPartidaRapidaActionPerformed

    private void botaoTorneiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoTorneiosActionPerformed
       
    }//GEN-LAST:event_botaoTorneiosActionPerformed

    private void botaoAtqTipificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtqTipificadoActionPerformed
        // Seleciona o Atq2 para o usarioAtq (Ataque Tipificado)
        usuarioAtq = 2;
        updateLabelsPPeNomeAtaque();
    }//GEN-LAST:event_botaoAtqTipificadoActionPerformed

    private void botaoAtqBasicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtqBasicoActionPerformed
        // Seleciona o Atq1 para o usarioAtq (Ataque Basico)
        usuarioAtq = 1;
        updateLabelsPPeNomeAtaque();
    }//GEN-LAST:event_botaoAtqBasicoActionPerformed

    private void botaoAtqAgilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtqAgilActionPerformed
        // Seleciona o Atq3 para o usarioAtq (Ataque Agil)
        usuarioAtq = 3;
        updateLabelsPPeNomeAtaque();
    }//GEN-LAST:event_botaoAtqAgilActionPerformed

    private void botaoAtqUltimateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtqUltimateActionPerformed
        // Seleciona o Atq4 para o usarioAtq (Ataque Ultimate)
        usuarioAtq = 4;
        updateLabelsPPeNomeAtaque();
    }//GEN-LAST:event_botaoAtqUltimateActionPerformed

    private void botaoAtacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtacarActionPerformed
        // Variável de controle para a maquina aguardar a vez
        boolean turnoMaquina = false;
        
        if (usuarioAtq != 0){
            turnoMaquina = batalhaAtual.turnoPlayer(usuarioAtq);
        }
        System.out.println(turnoMaquina);
        if (turnoMaquina){
            batalhaAtual.turnoMaquina();
        }
        // Atualiza as informações
        this.usuarioAtq = 0;
        updateInfoTelaBatalha();
    }//GEN-LAST:event_botaoAtacarActionPerformed

    private void botaoDesistirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDesistirActionPerformed
        // Sai da tela de batalha para tela dashboard
        this.trocarTela("telaDashBoard");
    }//GEN-LAST:event_botaoDesistirActionPerformed

    private void botaoGaloDexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGaloDexActionPerformed
        // Abre diretamente a GaloDex
        this.abrirGaloDex();
    }//GEN-LAST:event_botaoGaloDexActionPerformed

    private void botaoSelecionarAtacanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSelecionarAtacanteActionPerformed
        // Seleciona o atacante do player
        int index = tableGaloDex.getSelectedRow();
        if (index >= 0){
            // SelectedRow retorna o índice da linha selecionada, caso não haja linha selecionda, retorna -1
            player.getGaloDex().setAtacante(player.getGaloDex().getGalo(index));
            this.updateInfoGaloDex();
            // Log no terminal
            System.out.println("O galo atacante atual é:" + player.getGaloDex().getAtacante().getApelido());
        }
    }//GEN-LAST:event_botaoSelecionarAtacanteActionPerformed

    private void botaoInicial0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoInicial0ActionPerformed
        // TODO add your handling code here:
        player.getGaloDex().addGalo(galosIniciais.get(0));
        trocarTela("telaDashBoard");
    }//GEN-LAST:event_botaoInicial0ActionPerformed

    private void botaoInicial1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoInicial1ActionPerformed
        // TODO add your handling code here:
        player.getGaloDex().addGalo(galosIniciais.get(1));
        trocarTela("telaDashBoard");
    }//GEN-LAST:event_botaoInicial1ActionPerformed

    private void botaoInicial2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoInicial2ActionPerformed
        // TODO add your handling code here:
        player.getGaloDex().addGalo(galosIniciais.get(2));
        trocarTela("telaDashBoard");
    }//GEN-LAST:event_botaoInicial2ActionPerformed

    private void botaoVoltarLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarLojaActionPerformed
        // Volta da loja pro Dashboard
        trocarTela("telaDashBoard");
    }//GEN-LAST:event_botaoVoltarLojaActionPerformed

    private void botaoLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLojaActionPerformed
        // Vai para tela da loja
        trocarTela("telaLoja");
        this.updateInfoTelaLoja();
    }//GEN-LAST:event_botaoLojaActionPerformed

    private void botaoComprarPocaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoComprarPocaoActionPerformed
        // Botao para compra de Pocoes
        int index = this.tablePocoesLoja.getSelectedRow();
        boolean sucess = loja.venderPocaoCura(player, index);
        System.out.println(sucess);
        this.updateInfoTelaLoja();
    }//GEN-LAST:event_botaoComprarPocaoActionPerformed

    private void botaoComprarMilhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoComprarMilhoActionPerformed
        // Botao para compra de Milhos
        int index = this.tableMilhosLoja.getSelectedRow();
        boolean sucess = this.loja.venderMilho(player, index);
        System.out.println(sucess);
        this.updateInfoTelaLoja();
    }//GEN-LAST:event_botaoComprarMilhoActionPerformed

    private void botaoPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPerfilActionPerformed
        // Abre o perfil
    }//GEN-LAST:event_botaoPerfilActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAtacar;
    private javax.swing.JButton botaoAtqAgil;
    private javax.swing.JButton botaoAtqBasico;
    private javax.swing.JButton botaoAtqTipificado;
    private javax.swing.JButton botaoAtqUltimate;
    private javax.swing.JButton botaoComprarMilho;
    private javax.swing.JButton botaoComprarPocao;
    private javax.swing.JButton botaoDesistir;
    private javax.swing.JButton botaoGaloDex;
    private javax.swing.JButton botaoInicial0;
    private javax.swing.JButton botaoInicial1;
    private javax.swing.JButton botaoInicial2;
    private javax.swing.JButton botaoLoja;
    private javax.swing.JButton botaoPartidaRapida;
    private javax.swing.JButton botaoPerfil;
    private javax.swing.JButton botaoPlay;
    private javax.swing.JButton botaoSelecionarAtacante;
    private javax.swing.JButton botaoTorneios;
    private javax.swing.JButton botaoVoltarLoja;
    private javax.swing.JDialog dialogGaloDex;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelAgilidadeAtacanteGaloDex;
    private javax.swing.JLabel labelApelidoAtacanteGaloDex;
    private javax.swing.JLabel labelBackgroundDashBoard;
    private javax.swing.JLabel labelBackgroundTelaInicial;
    private javax.swing.JLabel labelBemVindo;
    private javax.swing.JLabel labelDefesaAtacanteGaloDex;
    private javax.swing.JLabel labelForcaAtacanteGaloDex;
    private javax.swing.JLabel labelFotoAtacanteGaloDex;
    private javax.swing.JLabel labelFotoMaquina;
    private javax.swing.JLabel labelFotoPlayer;
    private javax.swing.JLabel labelNomeAtacanteGaloDex;
    private javax.swing.JLabel labelNomeAtq;
    private javax.swing.JLabel labelNomeMaquina;
    private javax.swing.JLabel labelNomePlayer;
    private javax.swing.JLabel labelPP;
    private javax.swing.JLabel labelRinhaNome;
    private javax.swing.JLabel labelSaldoCarteira;
    private javax.swing.JLabel labelSelecione;
    private javax.swing.JLabel labelVidaMaquina;
    private javax.swing.JLabel labelVidaPlayer;
    private javax.swing.JPanel painelFuncoesAtaque;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JTable tableGaloDex;
    private javax.swing.JTable tableMilhosLoja;
    private javax.swing.JTable tablePocoesLoja;
    private javax.swing.JPanel telaBatalha;
    private javax.swing.JPanel telaBemVindo;
    private javax.swing.JPanel telaDashBoard;
    private javax.swing.JPanel telaGaloDex;
    private javax.swing.JPanel telaInicial;
    private javax.swing.JPanel telaLoja;
    private javax.swing.JProgressBar vidaMaquina;
    private javax.swing.JProgressBar vidaPlayer;
    // End of variables declaration//GEN-END:variables
}