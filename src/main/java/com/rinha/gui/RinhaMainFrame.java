package com.rinha.gui;

import com.rinha.batalha.Batalha;
import com.rinha.galos.*;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class RinhaMainFrame extends javax.swing.JFrame {
    
    /**
     * Creates new form RinhaMainFrame
     */
    private GaloItaipava player = new GaloItaipava(3, "Eu mermo");
    private GaloCego maquina = new GaloCego(3, "Ele mermo");
    private int turno = 0;
    private Random random = new Random();
    
    public RinhaMainFrame() {
        initComponents();
        jProgressBar1.setValue(100);
        jProgressBar2.setValue(100);
    }
    
    public void receberAtaque(){
        int d;
        d = maquina.atacar(player, random.nextInt(0, 3)+1);
        player.setVida( player.getVida() - d );
        jProgressBar1.setValue(jProgressBar1.getValue() - d);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jButton1 = new javax.swing.JButton();
        painelPrincipal = new javax.swing.JPanel();
        telaInicial = new javax.swing.JPanel();
        menu = new javax.swing.JButton();
        telaLoja = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        telaBatalha = new javax.swing.JPanel();
        atck1 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();
        atck2 = new javax.swing.JButton();
        atck3 = new javax.swing.JButton();
        atck4 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("rinha");
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(720, 480));
        setPreferredSize(new java.awt.Dimension(720, 480));
        setSize(getPreferredSize());

        painelPrincipal.setMinimumSize(getMinimumSize());
        painelPrincipal.setLayout(new java.awt.CardLayout());

        telaInicial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/menuIcon.png"))); // NOI18N
        menu.setContentAreaFilled(false);
        menu.setMaximumSize(new java.awt.Dimension(50, 50));
        menu.setMinimumSize(new java.awt.Dimension(50, 50));
        menu.setPreferredSize(new java.awt.Dimension(50, 50));
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });
        telaInicial.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, -1));

        painelPrincipal.add(telaInicial, "telaInicial");

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jButton5.setText("jButton5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout telaLojaLayout = new javax.swing.GroupLayout(telaLoja);
        telaLoja.setLayout(telaLojaLayout);
        telaLojaLayout.setHorizontalGroup(
            telaLojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaLojaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(telaLojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(telaLojaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5))
                    .addComponent(jLabel2))
                .addGap(403, 544, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        telaLojaLayout.setVerticalGroup(
            telaLojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaLojaLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(telaLojaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton5))
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        painelPrincipal.add(telaLoja, "telaLoja");

        atck1.setText(player.getAtaque(0));
        atck1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atck1ActionPerformed(evt);
            }
        });

        atck2.setText(player.getAtaque(1));
        atck2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atck2ActionPerformed(evt);
            }
        });

        atck3.setText(player.getAtaque(2));
        atck3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atck3ActionPerformed(evt);
            }
        });

        atck4.setText(player.getAtaque(3));
        atck4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atck4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout telaBatalhaLayout = new javax.swing.GroupLayout(telaBatalha);
        telaBatalha.setLayout(telaBatalhaLayout);
        telaBatalhaLayout.setHorizontalGroup(
            telaBatalhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaBatalhaLayout.createSequentialGroup()
                .addGroup(telaBatalhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(telaBatalhaLayout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addGroup(telaBatalhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(telaBatalhaLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(telaBatalhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(telaBatalhaLayout.createSequentialGroup()
                                .addComponent(atck3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(atck4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(telaBatalhaLayout.createSequentialGroup()
                                .addComponent(atck1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(atck2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(260, Short.MAX_VALUE))
        );
        telaBatalhaLayout.setVerticalGroup(
            telaBatalhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaBatalhaLayout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122)
                .addGroup(telaBatalhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(atck1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(atck2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(telaBatalhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(atck3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(atck4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96))
        );

        painelPrincipal.add(telaBatalha, "telaBatalha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Teste p = new Teste();
        jPanel1.add(p);
        jPanel1.revalidate();
        jPanel1.repaint();
        p.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) painelPrincipal.getLayout();
        cl.show(painelPrincipal, "telaBatalha");

    }//GEN-LAST:event_menuActionPerformed

    private void atck1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atck1ActionPerformed
        // Ataque 1
        int dano;
        int vidaAdversario;
        dano = player.atacar(maquina, 1);
        vidaAdversario = maquina.getVida();
        maquina.setVida(vidaAdversario - dano);
        jProgressBar2.setValue(maquina.getVida());
        turno = 0;
        receberAtaque();
    }//GEN-LAST:event_atck1ActionPerformed

    private void atck2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atck2ActionPerformed
        // TODO add your handling code here:
        int dano;
        int vidaAdversario;
        dano = player.atacar(maquina, 2);
        vidaAdversario = maquina.getVida();
        maquina.setVida(vidaAdversario - dano);
        jProgressBar2.setValue(maquina.getVida());
        turno = 0;
        receberAtaque();
    }//GEN-LAST:event_atck2ActionPerformed

    private void atck3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atck3ActionPerformed
        int dano;
        int vidaAdversario;
        dano = player.atacar(maquina, 3);
        vidaAdversario = maquina.getVida();
        maquina.setVida(vidaAdversario - dano);
        jProgressBar2.setValue(maquina.getVida());
        turno = 0;
        receberAtaque();
    }//GEN-LAST:event_atck3ActionPerformed

    private void atck4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atck4ActionPerformed
        int dano;
        int vidaAdversario;
        dano = player.atacar(maquina, 4);
        vidaAdversario = maquina.getVida();
        maquina.setVida(vidaAdversario - dano);
        jProgressBar2.setValue(maquina.getVida());
        turno = 0;
        receberAtaque();
    }//GEN-LAST:event_atck4ActionPerformed

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
            java.util.logging.Logger.getLogger(RinhaMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RinhaMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RinhaMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RinhaMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RinhaMainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atck1;
    private javax.swing.JButton atck2;
    private javax.swing.JButton atck3;
    private javax.swing.JButton atck4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JButton menu;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPanel telaBatalha;
    private javax.swing.JPanel telaInicial;
    private javax.swing.JPanel telaLoja;
    // End of variables declaration//GEN-END:variables
}
