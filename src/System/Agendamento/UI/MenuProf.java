/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package System.Agendamento.UI;

import Main.Agendamento;
import Main.Profissional;
import Main.Relatorio;
import Main.Servico;
import Main.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author D4NTES
 */
public class MenuProf extends javax.swing.JFrame {

    /**
     * Creates new form MenuProf
     */
    Agendamento agend = new Agendamento();
    Relatorio relatorio1 = Relatorio.getInstancia();
    Servico servico = new Servico();
    Profissional userlogado;
    
    public MenuProf() {
        initComponents();
    }
    public MenuProf(Profissional usuarioLogado){
        initComponents();
        this.userlogado = usuarioLogado;
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
        jLabel1 = new javax.swing.JLabel();
        rbEditar = new javax.swing.JRadioButton();
        rbVisualizar = new javax.swing.JRadioButton();
        rbAgendar = new javax.swing.JRadioButton();
        rbCancelar = new javax.swing.JRadioButton();
        rbAddHorario = new javax.swing.JRadioButton();
        rbRmvHorario = new javax.swing.JRadioButton();
        rbListarHorario = new javax.swing.JRadioButton();
        rbListar = new javax.swing.JRadioButton();
        BtnAcao = new javax.swing.JButton();
        BtnLogin = new javax.swing.JButton();
        rbRelatorio = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(420, 330));
        setResizable(false);
        setSize(new java.awt.Dimension(420, 330));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("== Menu do Profissional ==");

        buttonGroup1.add(rbEditar);
        rbEditar.setText("Editar Perfil");
        rbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEditarActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbVisualizar);
        rbVisualizar.setText("Visualizar  Perfil");
        rbVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbVisualizarActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbAgendar);
        rbAgendar.setText("Agendar Serviço");
        rbAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAgendarActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbCancelar);
        rbCancelar.setText("Cancelar Serviço");

        buttonGroup1.add(rbAddHorario);
        rbAddHorario.setText("Adicionar Horarios");

        buttonGroup1.add(rbRmvHorario);
        rbRmvHorario.setText("Remover Horarios");

        buttonGroup1.add(rbListarHorario);
        rbListarHorario.setText("Listar Horarios");

        buttonGroup1.add(rbListar);
        rbListar.setText("Listar Agendamentos");
        rbListar.setToolTipText("");

        BtnAcao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnAcao.setText("Confirmar");
        BtnAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAcaoActionPerformed(evt);
            }
        });

        BtnLogin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnLogin.setText("Voltar a Login");
        BtnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLoginActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbRelatorio);
        rbRelatorio.setText("Relatorio de Agendamentos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(rbRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BtnLogin)
                                    .addComponent(rbAgendar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rbCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(rbEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(rbListar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(BtnAcao, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(rbRmvHorario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rbAddHorario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rbListarHorario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rbVisualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(50, 50, 50))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(87, 87, 87))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbEditar)
                    .addComponent(rbAddHorario))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbRmvHorario)
                    .addComponent(rbAgendar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbListarHorario)
                    .addComponent(rbCancelar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbListar)
                    .addComponent(rbVisualizar))
                .addGap(18, 18, 18)
                .addComponent(rbRelatorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnLogin)
                    .addComponent(BtnAcao))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbVisualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbVisualizarActionPerformed

    private void rbAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAgendarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbAgendarActionPerformed

    private void BtnAcaoActionPerformed(java.awt.event.ActionEvent evt) {
        
        if (!rbEditar.isSelected() && !rbAgendar.isSelected() && !rbCancelar.isSelected() &&
        !rbListar.isSelected() && !rbRelatorio.isSelected() && !rbVisualizar.isSelected() &&
        !rbListarHorario.isSelected() && !rbRmvHorario.isSelected() && !rbAddHorario.isSelected()) {
        
        JOptionPane.showMessageDialog(null, "Escolha uma opção antes de continuar.");
        return; 
        }                                        
        if (rbEditar.isSelected()) {
            new EdicaoPerfil(userlogado).setVisible(true);
        } else if (rbAgendar.isSelected()) {
            new CrudScreen(servico.listarServicosString(), "agendar", (Usuario) userlogado).setVisible(true);
        } else if (rbCancelar.isSelected()) {
            new CrudScreen(userlogado.listarAgendamentos(), "cancelar", (Usuario) userlogado).setVisible(true);
        } else if (rbListar.isSelected()) {
            new MonitorInfo(userlogado.listarAgendamentos(), (Usuario)userlogado).setVisible(true);
        } else if (rbRelatorio.isSelected()) {
            new MonitorInfo(relatorio1.visualizarRelatorio((Usuario)userlogado),(Usuario)userlogado).setVisible(true);
        } else if (rbVisualizar.isSelected()) {
            new MonitorInfo(userlogado.visualizarPerfil(),(Usuario)userlogado).setVisible(true);
            
        } else if(rbListarHorario.isSelected()){
            new MonitorInfo(userlogado.listarHorarios(), (Usuario) userlogado).setVisible(true);
        } else if (rbRmvHorario.isSelected()){
            new CrudScreen(userlogado.listarHorarios(), "removerH", (Usuario) userlogado).setVisible(true);
        }else if (rbAgendar.isSelected()){
            new CrudScreen(servico.listarServicosString(), "agendar", (Usuario) userlogado).setVisible(true);
        }
        
        if(rbAddHorario.isSelected()){
           while (true) {
            String horario = JOptionPane.showInputDialog(null, "Digite um horário disponível (Formato: 09:00 - 10:00)\nOu digite 'sair' para finalizar:", "Adicionar Horários", JOptionPane.QUESTION_MESSAGE);
            if (horario == null || horario.equalsIgnoreCase("sair")) {
                break;
            }
            userlogado.adicionarHorario(horario);
            }
        }else{
            this.dispose();
        }
    }
                                           

    private void BtnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLoginActionPerformed
        TelaLogin telalog1 = new TelaLogin();
        telalog1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnLoginActionPerformed

    private void rbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbEditarActionPerformed

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
            java.util.logging.Logger.getLogger(MenuProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuProf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAcao;
    private javax.swing.JButton BtnLogin;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton rbAddHorario;
    private javax.swing.JRadioButton rbAgendar;
    private javax.swing.JRadioButton rbCancelar;
    private javax.swing.JRadioButton rbEditar;
    private javax.swing.JRadioButton rbListar;
    private javax.swing.JRadioButton rbListarHorario;
    private javax.swing.JRadioButton rbRelatorio;
    private javax.swing.JRadioButton rbRmvHorario;
    private javax.swing.JRadioButton rbVisualizar;
    // End of variables declaration//GEN-END:variables
}
