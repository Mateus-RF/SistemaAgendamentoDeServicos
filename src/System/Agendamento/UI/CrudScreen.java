/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package System.Agendamento.UI;

import Main.Administrador;
import Main.Agendamento;
import Main.Profissional;
import Main.Relatorio;
import Main.Servico;
import Main.Usuario;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author D4NTES
 */
public class CrudScreen extends javax.swing.JFrame {

    /**
     * Creates new form CrudScreen
     */
    int condition = 1;
    Servico servicoEscolhido = null;
    List<Profissional> profissionais;
    List<String> horariosDisponiveis;
    String horarioEscolhido;       
    Date dataHora;
    
    Servico servico = new Servico();
    Agendamento agend = new Agendamento();
    private String condicao;
    Usuario userLogado;
    Profissional userLogadoP, profissional;
    Administrador userLogadoA;
    public CrudScreen() {
        initComponents();
    }
  
    public CrudScreen(String c, String condicao, Usuario usuarioLogado) {
        initComponents();
        jTextArea1.setText(c);
        this.condicao = condicao;
        if (usuarioLogado instanceof Profissional profissional1){
            this.userLogadoP =profissional1;
        }else if(usuarioLogado instanceof Administrador administrador){
            this.userLogadoA = administrador;
        }else{
            this.userLogado = usuarioLogado;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfIdServ = new javax.swing.JTextField();
        BtnAction = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(420, 330));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("=== CrudScreen ===");

        jLabel2.setText("ID:");

        BtnAction.setText("Confirmar");
        BtnAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActionActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        Voltar.setText("Voltar");
        Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 109, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(130, 130, 130))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Voltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnAction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfIdServ))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfIdServ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(BtnAction)
                        .addGap(18, 18, 18)
                        .addComponent(Voltar)
                        .addContainerGap(149, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnActionActionPerformed(java.awt.event.ActionEvent evt) {
        String entrada = tfIdServ.getText().trim();
    
        if (condicao == null) {
            JOptionPane.showMessageDialog(null, "Erro inesperado: Nenhuma ação foi definida.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        try {
            if (condicao.equals("agendar") && condition == 4) {
                // Aqui é o momento de pegar a DATA e não um número
                if (userLogadoP != null) {
                    processarDataProfissional(entrada);
                } else if (userLogado != null) {
                    processarDataUsuario(entrada);
                }
            } else {
                // Casos normais que precisam de número (ID)
                int id = Integer.parseInt(entrada);
    
                if (userLogadoP != null) {
                    processarAcaoProfissional(id);
                } else if (userLogadoA != null) {
                    processarAcaoAdministrador(id, condicao);
                } else {
                    processarAcaoUsuario(id, condicao);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro: Digite um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Digite um número de ID válido!");
        }
    }
    
    
    // ---------------------- MÉTODOS AUXILIARES ----------------------//
    
    private void processarAcaoProfissional(int id) {
        switch (condicao) {
            case "agendar":
                processarAgendamento(id);
                break;
    
            case "cancelar":
                try {
                    agend.cancelarAgendamento((Usuario) userLogadoP, id);
                } catch (NullPointerException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao cancelar: O ID fornecido não existe.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                break;
    
            case "removerH":
                try {
                    userLogadoP.removerHorario(id);
                    jTextArea1.setText(userLogadoP.listarHorarios());
                } catch (NullPointerException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao remover horário: Nenhum horário encontrado com esse ID.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                break;
    
            default:
                JOptionPane.showMessageDialog(null, "Ação desconhecida!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void processarAcaoAdministrador(int id, String condicao) {
        if ("excluirServico".equals(condicao)) {
            try {
                servico.excluirServico(id);
                jTextArea1.setText(servico.listarServicosString());
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir serviço: O ID não foi encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void processarAcaoUsuario(int id, String condicao) {
        switch (condicao) {
            case "agendar":
                processarAgendamento(id);
                break;
    
            case "cancelar":
                try {
                    agend.cancelarAgendamento(userLogado, id);
                } catch (NullPointerException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao cancelar: O ID fornecido não existe.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                break;
    
            default:
                JOptionPane.showMessageDialog(null, "Ação desconhecida!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void processarAgendamento(int id) {
        switch (condition) {
            case 1:
                if (id >= 1 && id <= Servico.listarServicos().size()) {
                    servicoEscolhido = Servico.listarServicos().get(id - 1);
                    profissionais = servicoEscolhido.getProfissionaisDisponiveis();
                    
                    StringBuilder text = new StringBuilder("Profissionais disponíveis para o serviço:\n");
                    for (int i = 0; i < profissionais.size(); i++) {
                        text.append((i + 1)).append(". ").append(profissionais.get(i).getNome()).append("\n");
                    }
                    
                    jTextArea1.setText(text.toString());
                    condition++;
                } else {
                    JOptionPane.showMessageDialog(null, "ID de serviço inválido.");
                }
                break;
    
            case 2:
                if (id >= 1 && id <= profissionais.size()) {
                    profissional = profissionais.get(id - 1);
                    horariosDisponiveis = profissional.getHorariosDisponiveis();
    
                    StringBuilder text2 = new StringBuilder("Horários disponíveis para " + profissional.getNome() + ":");
                    if (horariosDisponiveis.isEmpty()) {
                        text2 = new StringBuilder("Este profissional não tem horários disponíveis.");
                    } else {
                        for (int i = 0; i < horariosDisponiveis.size(); i++) {
                            text2.append("\n").append(i + 1).append(". ").append(horariosDisponiveis.get(i));
                        }
                        condition++;
                    }
                    jTextArea1.setText(text2.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "ID de profissional inválido.");
                }
                break;
    
            case 3:
                if (id >= 1 && id <= horariosDisponiveis.size()) {
                    horarioEscolhido = horariosDisponiveis.get(id- 1);
                    jTextArea1.setText("Digite a data do agendamento (formato: yyyy-MM-dd)");
                    jLabel2.setText("Data:");
                    tfIdServ.setText("");
                    condition++;
                } else {
                    JOptionPane.showMessageDialog(null, "ID de horário inválido.");
                }
                break;
    
            case 4:
                String data = tfIdServ.getText();
                try {
                    dataHora = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm").parse(data + " " + horarioEscolhido);
                    agend.agendarServico((Usuario) userLogadoP, servicoEscolhido, profissional, dataHora);
                    condition = 1;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Formato de data ou horário inválido.");
                }
                break;
    
            default:
                JOptionPane.showMessageDialog(null, "Condição desconhecida.");
        }


    }
    private void processarDataProfissional(String data) {
        try {
            dataHora = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm").parse(data + " " + horarioEscolhido);
            agend.agendarServico((Usuario) userLogadoP, servicoEscolhido, profissional, dataHora);
            condition = 1;
            tfIdServ.setText("");
            jLabel2.setText("ID:");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato de data inválido. Use o formato yyyy-MM-dd");
        }
    }
    
    private void processarDataUsuario(String data) {
        try {
            dataHora = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm").parse(data + " " + horarioEscolhido);
            agend.agendarServico(userLogado, servicoEscolhido, profissional, dataHora);
            condition = 1;
            tfIdServ.setText("");
            jLabel2.setText("ID:");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato de data inválido. Use o formato yyyy-MM-dd");
        }
    }
    
        
                                             

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
       if (userLogadoA != null){
           new MenuAdmin(userLogadoA).setVisible(true);
       }else if(userLogadoP != null){
           new MenuProf(userLogadoP).setVisible(true);
       }else{
           new MenuUser(userLogado).setVisible(true);
       }
       this.dispose();
    }//GEN-LAST:event_VoltarActionPerformed

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
            java.util.logging.Logger.getLogger(CrudScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrudScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrudScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrudScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrudScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAction;
    private javax.swing.JButton Voltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField tfIdServ;
    // End of variables declaration//GEN-END:variables
}
