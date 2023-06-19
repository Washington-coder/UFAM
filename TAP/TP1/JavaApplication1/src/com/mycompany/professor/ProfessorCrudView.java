/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.professor;

import com.mycompany.connection.ConnectionJdbc;
import com.mycompany.rit.RitView;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author washington.riega
 */
public class ProfessorCrudView extends javax.swing.JFrame {

    /**
     * Creates new form ProfessorCRUDView
     *
     */
    
    ConnectionJdbc jdbc = new ConnectionJdbc();
    private String pid;
    
    public ProfessorCrudView() {
        initComponents();
        jdbc.Connect();
        Fetch();
    }
    
    private void Fetch(){
        int q;
        try {
            jdbc.pst = jdbc.con.prepareStatement("SELECT * FROM professor");
            jdbc.rs = jdbc.pst.executeQuery();
            ResultSetMetaData rss = jdbc.rs.getMetaData();
            q = rss.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel(); 
            df.setRowCount(0);
            while(jdbc.rs.next()){
                Vector v2 = new Vector();
                for(int a=1; a<=q; a++){
                    v2.add(jdbc.rs.getString("id"));
                    v2.add(jdbc.rs.getString("nome"));
                    v2.add(jdbc.rs.getString("idade"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorCrudView.class.getName()).log(Level.SEVERE, null, ex);
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
        btnCadastro = new javax.swing.JButton();
        btnEdita = new javax.swing.JButton();
        btnDeleta = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtIdade = new javax.swing.JTextField();
        btnVerRit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Professores");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(292, 6, 99, 25);

        btnCadastro.setText("Cadastrar");
        btnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastro);
        btnCadastro.setBounds(35, 110, 100, 46);

        btnEdita.setText("Editar");
        btnEdita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditaActionPerformed(evt);
            }
        });
        getContentPane().add(btnEdita);
        btnEdita.setBounds(160, 110, 80, 46);

        btnDeleta.setText("Deletar");
        btnDeleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletaActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeleta);
        btnDeleta.setBounds(250, 110, 90, 46);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(35, 66, 35, 16);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Idade:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(353, 66, 33, 16);
        getContentPane().add(txtNome);
        txtNome.setBounds(95, 63, 174, 22);
        getContentPane().add(txtIdade);
        txtIdade.setBounds(403, 63, 174, 22);

        btnVerRit.setText("Ver RIT");
        btnVerRit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerRitActionPerformed(evt);
            }
        });
        getContentPane().add(btnVerRit);
        btnVerRit.setBounds(360, 110, 95, 46);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Professor ID", "Nome", "Idade"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(35, 174, 614, 324);

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\washington.riega\\OneDrive - Venturus iTriad\\Área de Trabalho\\UFAM\\TAP\\TP1\\JavaApplication1\\Background_Banner2_Desktop.png")); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, -10, 690, 840);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed
        // TODO add your handling code here:
        String nome = txtNome.getText();
        String idade = txtIdade.getText();
        
        try {
            jdbc.pst = jdbc.con.prepareStatement("INSERT INTO professor (nome,idade)VALUES(?,?)");
            jdbc.pst.setString(1, nome);
            jdbc.pst.setString(2, idade);
            
            int k = jdbc.pst.executeUpdate();
            
            if (k == 1){
                JOptionPane.showMessageDialog(this, "Professor cadastrado com sucesso !");
                txtNome.setText("");
                txtIdade.setText("");
                Fetch();
            }else{
                JOptionPane.showMessageDialog(this, "Houve um erro ao cadastrar o professor");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorCrudView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCadastroActionPerformed

    private void btnEditaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditaActionPerformed
        // TODO add your handling code here:
        String nome = txtNome.getText();
        String idade = txtIdade.getText();
//        String pid = txtpid.getSelectedItem().toString();
        
        try {
            jdbc.pst = jdbc.con.prepareStatement("UPDATE professor SET nome=?,idade=? WHERE id=?");
            
            jdbc.pst.setString(1, nome);
            jdbc.pst.setString(2, idade);
            jdbc.pst.setString(3, pid);
            
            int k = jdbc.pst.executeUpdate();
            if (k == 1){
                JOptionPane.showMessageDialog(this, "O professor foi editado com sucesso !!");
                txtNome.setText("");
                txtIdade.setText("");
                txtNome.requestFocus();
                Fetch();
            }else{
                JOptionPane.showMessageDialog(this, "Deu ruim no update");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorCrudView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditaActionPerformed

    private void btnDeletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletaActionPerformed
        // TODO add your handling code here:
//        String pid =  txtpid.getSelectedItem().toString();
        try {
            jdbc.pst = jdbc.con.prepareStatement("DELETE FROM professor WHERE id=?");
            jdbc.pst.setString(1, pid);
            
            int k = jdbc.pst.executeUpdate();
            
            if (k == 1){
                JOptionPane.showMessageDialog(this, "Professor deletado com sucesso!");
                txtNome.setText("");
                txtIdade.setText("");
                txtNome.requestFocus();
                Fetch();
            }else{
                JOptionPane.showMessageDialog(this, "Nao deu p deletar ):");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorCrudView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeletaActionPerformed

    private void btnVerRitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerRitActionPerformed
        // TODO add your handling code here:
        jdbc.closeConnection();
        RitView tela = new RitView(Integer.parseInt(pid));
        dispose();
        setSize(986, 232);
        tela.show();
    }//GEN-LAST:event_btnVerRitActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int selectedLineIndex = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        
        pid = model.getValueAt(selectedLineIndex, 0).toString();
        String nome = model.getValueAt(selectedLineIndex, 1).toString();
        String idade = model.getValueAt(selectedLineIndex, 2).toString();
        
        
        txtNome.setText(nome);
        txtIdade.setText(idade);
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(ProfessorCrudView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfessorCrudView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfessorCrudView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfessorCrudView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfessorCrudView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastro;
    private javax.swing.JButton btnDeleta;
    private javax.swing.JButton btnEdita;
    private javax.swing.JButton btnVerRit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
