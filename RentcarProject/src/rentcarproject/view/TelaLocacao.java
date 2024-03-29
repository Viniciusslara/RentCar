/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package rentcarproject.view;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;import javax.swing.JOptionPane;
import rentcarproject.controller.AluguelDAO;
import rentcarproject.database.Connect;
import rentcarproject.models.Aluguel;
import javax.swing.JOptionPane;
import rentcarproject.controller.AluguelDAO;
import rentcarproject.database.Connect;
import rentcarproject.models.Aluguel;

/**
 *
 * @author vinicius
 */
public class TelaLocacao extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaLocacao
     */
    public TelaLocacao() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldCPF = new javax.swing.JTextField();
        jLabelNasc = new javax.swing.JLabel();
        jTextFieldPlaca = new javax.swing.JTextField();
        jLabelTel = new javax.swing.JLabel();
        jLabelCPF = new javax.swing.JLabel();
        jTextFieldNdiarias = new javax.swing.JTextField();
        jButtonCad = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxPagamento = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabelNome.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabelNome.setText("CPF Cliente:");

        jTextFieldCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCPFActionPerformed(evt);
            }
        });

        jLabelNasc.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabelNasc.setText("Placa do Veiculo:");

        jLabelTel.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabelTel.setText("Numero de Diarias:");

        jLabelCPF.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabelCPF.setText("Metodo de Pagamento:");

        jTextFieldNdiarias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNdiariasActionPerformed(evt);
            }
        });

        jButtonCad.setBackground(new java.awt.Color(0, 0, 0));
        jButtonCad.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCad.setText("REALIZAR LOCAÇÃO");
        jButtonCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 2, 36)); // NOI18N
        jLabel1.setText("REALIZAR LOCAÇÃO");

        jComboBoxPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dinheiro", "Cartao de Credito", "Cartao de Debito" }));
        jComboBoxPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPagamentoActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNome)
                            .addComponent(jLabelNasc)
                            .addComponent(jLabelTel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldCPF, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                            .addComponent(jTextFieldPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                            .addComponent(jTextFieldNdiarias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))))
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCad, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(48, 48, 48)))
                .addGap(352, 352, 352))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCPF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNasc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPlaca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNdiarias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addComponent(jButtonCad, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCPFActionPerformed

    private void jTextFieldNdiariasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNdiariasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNdiariasActionPerformed

    private void jComboBoxPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPagamentoActionPerformed

    private void jButtonCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadActionPerformed
        // TODO add your handling code here:
        
        Aluguel aluguel = new Aluguel();
        AluguelDAO aluguelDao = new AluguelDAO();
        
        aluguel.cliente.setCpf(jTextFieldCPF.getText());
        aluguel.veiculo.setPlaca(jTextFieldPlaca.getText());
        aluguel.setNumDiaria(Integer.parseInt(jTextFieldNdiarias.getText()));
        
        if(jComboBoxPagamento.getSelectedIndex() == 0){
            aluguel.setMetodoPag("Dinheiro");
        }else
            if(jComboBoxPagamento.getSelectedIndex() == 1){
                aluguel.setMetodoPag("Credito");
            }else{
               aluguel.setMetodoPag("Debito");
            }
        
        Connect connect = new Connect();     
       
        
        if(connect.getConnection()){
            if(aluguelDao.validaPlaca(jTextFieldPlaca.getText())){
                try{
                
                    String sql = "SELECT disponibilidade_veiculo FROM tb_veiculos WHERE placa_veiculo = '"+jTextFieldPlaca.getText()+"'";
            
                    PreparedStatement statement = connect.connection.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery();
                
                    while(resultSet.next()){ 
                    
                        if(resultSet.getString("disponibilidade_veiculo").equals("DISPONIVEL")){
                            aluguelDao.create(aluguel);
                        }else{
                            JOptionPane.showMessageDialog(rootPane, "Veiculo ja alugado!", "ERRO", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                
                    resultSet.close();
                    statement.close();
                    connect.close();
                
                }catch(SQLException erro){
                    System.out.println(erro.toString());
                }
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao realizar locação, verifique os dados!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            System.out.println("Erro ao conectar");
        }
     
        
    }//GEN-LAST:event_jButtonCadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCad;
    private javax.swing.JComboBox<String> jComboBoxPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCPF;
    private javax.swing.JLabel jLabelNasc;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelTel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldCPF;
    private javax.swing.JTextField jTextFieldNdiarias;
    private javax.swing.JTextField jTextFieldPlaca;
    // End of variables declaration//GEN-END:variables
}
