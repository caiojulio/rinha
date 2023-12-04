package com.rinha.gui;

import com.rinha.loja.Loja;
import com.rinha.perfil.Perfil;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PainelLoja extends PainelFilho {
    Loja loja;
    
    public PainelLoja(mainFrame mainFrame, Perfil player, Loja loja) {
        this.painelPrincipal = mainFrame.getPainelPrincipal();
        this.player = player;
        this.loja = loja;
        initComponents();
    }
    
    // Getters

    public Loja getLoja() {
        return loja;
    }

    public JButton getBotaoComprarMilho() {
        return botaoComprarMilho;
    }

    public JButton getBotaoComprarPocao() {
        return botaoComprarPocao;
    }

    public JButton getBotaoVoltarLoja() {
        return botaoVoltarLoja;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    public JLabel getLabelSaldoCarteira() {
        return labelSaldoCarteira;
    }

    public JTable getTableMilhosLoja() {
        return tableMilhosLoja;
    }

    public JTable getTablePocoesLoja() {
        return tablePocoesLoja;
    }
    
    
    // Atualizações da interface
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tablePocoesLoja = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableMilhosLoja = new javax.swing.JTable();
        botaoVoltarLoja = new javax.swing.JButton();
        botaoComprarPocao = new javax.swing.JButton();
        botaoComprarMilho = new javax.swing.JButton();
        labelSaldoCarteira = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(720, 480));
        setMinimumSize(new java.awt.Dimension(720, 480));
        setPreferredSize(new java.awt.Dimension(720, 480));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaoComprarMilho))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaoComprarPocao)))
                        .addContainerGap(412, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoVoltarLoja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelSaldoCarteira, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoComprarMilho, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoVoltarLoja)
                            .addComponent(labelSaldoCarteira))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoComprarPocao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 78, 78))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botaoVoltarLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarLojaActionPerformed
        // Volta da loja pro Dashboard
        trocarTela("dashboard");
    }//GEN-LAST:event_botaoVoltarLojaActionPerformed

    private void botaoComprarPocaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoComprarPocaoActionPerformed
        // Botao para compra de Pocoes
        int index = this.tablePocoesLoja.getSelectedRow();
        boolean sucess = loja.venderPocaoCura(this.player, index);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoComprarMilho;
    private javax.swing.JButton botaoComprarPocao;
    private javax.swing.JButton botaoVoltarLoja;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelSaldoCarteira;
    private javax.swing.JTable tableMilhosLoja;
    private javax.swing.JTable tablePocoesLoja;
    // End of variables declaration//GEN-END:variables
}