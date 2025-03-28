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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author D4NTES
 */
public class MenuUser extends javax.swing.JFrame {

    /**
     * Creates new form MenuUserProf
     */
    Agendamento agend = new Agendamento();
    Usuario user = new Usuario();
    Relatorio relatorio1 = Relatorio.getInstancia();
    Servico servico = new Servico();
    Usuario usuarioLogado;
    public MenuUser() {
        initComponents();
    }
    public MenuUser(Usuario cliente) {
        initComponents();
        usuarioLogado = cliente;
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
        PnlCliente = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rbPerfil = new javax.swing.JRadioButton();
        rbVisualizar = new javax.swing.JRadioButton();
        rbAgendar = new javax.swing.JRadioButton();
        rbCancelar = new javax.swing.JRadioButton();
        rbListar = new javax.swing.JRadioButton();
        rbMudarProf = new javax.swing.JRadioButton();
        rbRelatorio = new javax.swing.JRadioButton();
        BtnConfirmar = new javax.swing.JButton();
        BtnLClienteLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(420, 332));
        setSize(new java.awt.Dimension(420, 330));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PnlCliente.setMinimumSize(new java.awt.Dimension(420, 330));
        PnlCliente.setPreferredSize(new java.awt.Dimension(420, 330));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("== Menu do Cliente ==");

        buttonGroup1.add(rbPerfil);
        rbPerfil.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbPerfil.setText("Editar Perfil");

        buttonGroup1.add(rbVisualizar);
        rbVisualizar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbVisualizar.setText("Visualizar o Perfil");

        buttonGroup1.add(rbAgendar);
        rbAgendar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbAgendar.setText("Agendar Serviço");

        buttonGroup1.add(rbCancelar);
        rbCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbCancelar.setText("Cancelar Serviço");

        buttonGroup1.add(rbListar);
        rbListar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbListar.setText("Listar Agendamentos");

        buttonGroup1.add(rbMudarProf);
        rbMudarProf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbMudarProf.setText("Mudar para Profissional");

        buttonGroup1.add(rbRelatorio);
        rbRelatorio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbRelatorio.setText("Relatorio de Serviços");

        BtnConfirmar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnConfirmar.setText("Confimar");
        BtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConfirmarActionPerformed(evt);
            }
        });

        BtnLClienteLogin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnLClienteLogin.setText("Voltar a Login");
        BtnLClienteLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLClienteLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnlClienteLayout = new javax.swing.GroupLayout(PnlCliente);
        PnlCliente.setLayout(PnlClienteLayout);
        PnlClienteLayout.setHorizontalGroup(
            PnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlClienteLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(PnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbMudarProf)
                    .addGroup(PnlClienteLayout.createSequentialGroup()
                        .addGroup(PnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbCancelar)
                            .addGroup(PnlClienteLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(BtnLClienteLogin)))
                        .addGroup(PnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PnlClienteLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(PnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rbListar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rbRelatorio)
                                    .addComponent(rbVisualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlClienteLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(PnlClienteLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PnlClienteLayout.setVerticalGroup(
            PnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlClienteLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbPerfil)
                    .addComponent(rbVisualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbAgendar)
                    .addComponent(rbListar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbCancelar)
                    .addComponent(rbRelatorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbMudarProf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(PnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnLClienteLogin)
                    .addComponent(BtnConfirmar))
                .addGap(64, 64, 64))
        );

        getContentPane().add(PnlCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 342));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentHidden

    private void BtnLClienteLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLClienteLoginActionPerformed
        new TelaLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnLClienteLoginActionPerformed

    private void BtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {
        boolean condicional = true;
        if (rbPerfil.isSelected()) {
            EdicaoPerfil perfil = new EdicaoPerfil(usuarioLogado);
            perfil.setVisible(true);

        } else if (rbAgendar.isSelected()) {
            CrudScreen agendServ = new CrudScreen(servico.listarServicosString(), "agendar", usuarioLogado);
            agendServ.setVisible(true);

        } else if (rbCancelar.isSelected()) {
            CrudScreen agendServ = new CrudScreen(usuarioLogado.listarAgendamentos(), "cancelar", usuarioLogado);
            agendServ.setVisible(true);

        } else if (rbListar.isSelected()) {
            new MonitorInfo(usuarioLogado.listarAgendamentos(), usuarioLogado).setVisible(true);

        } else if (rbMudarProf.isSelected()) {
            if (usuarioLogado instanceof Profissional) {
                JOptionPane.showMessageDialog(this, "Você já é um profissional!", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                Profissional profissionalService = new Profissional();
                Profissional novoProfissional = profissionalService.cadastrarProfissional(usuarioLogado);
                usuarioLogado.transferirAgendamentosParaProfissional(novoProfissional);
                if (novoProfissional != null) {
                    Profissional usuarioLogado = novoProfissional;
                    JOptionPane.showMessageDialog(this, "Agora você é um profissional!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    MenuProf menu = new MenuProf(usuarioLogado);
                    menu.setVisible(true);
                }
            }

        } else if (rbRelatorio.isSelected()) {
            new MonitorInfo(relatorio1.visualizarRelatorio(usuarioLogado), usuarioLogado).setVisible(true);

        } else if (rbVisualizar.isSelected()) {
            new MonitorInfo(usuarioLogado.visualizarPerfil(), usuarioLogado).setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Escolha uma opção");
            condicional = false;
        }
        if (condicional == true){
            condicional = true;
            this.dispose();
        }
        
    }                                            

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
            java.util.logging.Logger.getLogger(MenuUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnConfirmar;
    private javax.swing.JButton BtnLClienteLogin;
    private javax.swing.JPanel PnlCliente;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton rbAgendar;
    private javax.swing.JRadioButton rbCancelar;
    private javax.swing.JRadioButton rbListar;
    private javax.swing.JRadioButton rbMudarProf;
    private javax.swing.JRadioButton rbPerfil;
    private javax.swing.JRadioButton rbRelatorio;
    private javax.swing.JRadioButton rbVisualizar;
    // End of variables declaration//GEN-END:variables
}
