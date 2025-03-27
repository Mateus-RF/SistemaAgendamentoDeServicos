/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package System.Agendamento.UI;

import Main.Administrador;
import Main.Servico;
import Main.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author D4NTES
 */
public class MenuAdmin extends javax.swing.JFrame {

    /**
     * Creates new form MenuAdmin
     */
    Servico servico = new Servico();
    Administrador userLogado;
    public MenuAdmin() {
        initComponents();
    }
    public MenuAdmin(Usuario usuarioLogado) {
        initComponents();
        this.userLogado = (Administrador) usuarioLogado;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        rbCadastrar = new javax.swing.JRadioButton();
        BtnVoltarLogin = new javax.swing.JButton();
        BtnConfirmar = new javax.swing.JButton();
        rbEditarServ = new javax.swing.JRadioButton();
        rbExcuirServ = new javax.swing.JRadioButton();
        rbListar = new javax.swing.JRadioButton();
        rbAtribuirProf = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(420, 330));
        setResizable(false);
        setSize(new java.awt.Dimension(420, 330));

        buttonGroup1.add(rbCadastrar);
        rbCadastrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbCadastrar.setText("Cadastrar Serviço");
        rbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCadastrarActionPerformed(evt);
            }
        });

        BtnVoltarLogin.setText("Voltar");
        BtnVoltarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVoltarLoginActionPerformed(evt);
            }
        });

        BtnConfirmar.setText("Confimar");
        BtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConfirmarActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbEditarServ);
        rbEditarServ.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbEditarServ.setText("Editar Serviço");

        buttonGroup1.add(rbExcuirServ);
        rbExcuirServ.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbExcuirServ.setText("Excluir Serviço");

        buttonGroup1.add(rbListar);
        rbListar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbListar.setText("Listar Serviços");

        buttonGroup1.add(rbAtribuirProf);
        rbAtribuirProf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbAtribuirProf.setText("Atribuir Profissional");
        rbAtribuirProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAtribuirProfActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Administrador do Sistema");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbAtribuirProf)
                            .addComponent(rbExcuirServ, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbEditarServ, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(rbCadastrar)
                            .addComponent(rbListar))
                        .addGap(105, 108, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(BtnVoltarLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(rbCadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbEditarServ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbExcuirServ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbListar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbAtribuirProf)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnVoltarLogin)
                    .addComponent(BtnConfirmar))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnVoltarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVoltarLoginActionPerformed
        new TelaLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnVoltarLoginActionPerformed

    private void rbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCadastrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbCadastrarActionPerformed

    private void rbAtribuirProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAtribuirProfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbAtribuirProfActionPerformed

    private void BtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfirmarActionPerformed
        if(rbCadastrar.isSelected()){
            new CadastroServico(userLogado).setVisible(true);
        }else if(rbEditarServ.isSelected()){
            new EdicaoServico(userLogado).setVisible(true);
        }else if(rbExcuirServ.isSelected()){
            new CrudScreen(servico.listarServicosString(), "excluirServico", (Usuario) userLogado).setVisible(true);
        }else if(rbListar.isSelected()){
            new MonitorInfo(servico.listarServicosString(), (Usuario) userLogado).setVisible(true);
        }else if(rbAtribuirProf.isSelected()){
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma opção!");
            return;
        }
        this.dispose();
    }//GEN-LAST:event_BtnConfirmarActionPerformed

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
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnConfirmar;
    private javax.swing.JButton BtnVoltarLogin;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton rbAtribuirProf;
    private javax.swing.JRadioButton rbCadastrar;
    private javax.swing.JRadioButton rbEditarServ;
    private javax.swing.JRadioButton rbExcuirServ;
    private javax.swing.JRadioButton rbListar;
    // End of variables declaration//GEN-END:variables
}
