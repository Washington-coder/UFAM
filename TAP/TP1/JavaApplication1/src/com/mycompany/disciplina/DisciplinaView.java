/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.disciplina;

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
public class DisciplinaView extends javax.swing.JFrame {

    /**
     * Creates new form CreateDisciplina
     */
    ConnectionJdbc jdbc = new ConnectionJdbc();
    private String pid;
    
    private Integer professor_id;
    
    public DisciplinaView(Integer id) {
        professor_id = id;
        initComponents();
        jdbc.Connect();
        Fetch();
    }
    
    private void Fetch(){
        int q;
        try {
            jdbc.pst = jdbc.con.prepareStatement("SELECT * FROM disciplina WHERE id_tabela_professor=?");
            jdbc.pst.setInt(1, professor_id);
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
                    v2.add(jdbc.rs.getString("carga_horaria"));
                    v2.add(jdbc.rs.getString("qtd_max_alunos"));
                    v2.add(jdbc.rs.getString("periodo"));
                    v2.add(jdbc.rs.getString("media"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaView.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtQtdMaxAlunos = new javax.swing.JTextField();
        txtCargaHoraria = new javax.swing.JTextField();
        txtPeriodo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtMedia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnCadastra = new javax.swing.JButton();
        btnEdita = new javax.swing.JButton();
        btnDeleta = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Disciplina");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(431, 0, 83, 25);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(32, 71, 33, 16);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Carga Horaria");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(539, 71, 73, 16);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Quantidade máxima de alunos");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(717, 71, 171, 16);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Período da disciplina");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(205, 71, 110, 16);
        getContentPane().add(txtNome);
        txtNome.setBounds(32, 91, 140, 22);
        getContentPane().add(txtQtdMaxAlunos);
        txtQtdMaxAlunos.setBounds(717, 91, 140, 22);
        getContentPane().add(txtCargaHoraria);
        txtCargaHoraria.setBounds(539, 91, 140, 22);

        txtPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        getContentPane().add(txtPeriodo);
        txtPeriodo.setBounds(205, 91, 140, 22);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Média");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(373, 71, 33, 16);
        getContentPane().add(txtMedia);
        txtMedia.setBounds(373, 91, 140, 22);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Carga Horária", "Quantidade Máxima de Alunos", "Período", "Media da disciplina"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(33, 254, 883, 402);

        btnCadastra.setText("Cadastrar");
        btnCadastra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastra);
        btnCadastra.setBounds(33, 147, 80, 47);

        btnEdita.setText("Editar");
        btnEdita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditaActionPerformed(evt);
            }
        });
        getContentPane().add(btnEdita);
        btnEdita.setBounds(131, 149, 72, 43);

        btnDeleta.setText("Excluir");
        btnDeleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletaActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeleta);
        btnDeleta.setBounds(221, 148, 72, 45);

        btnVoltar.setText("<");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVoltar);
        btnVoltar.setBounds(0, 4, 50, 23);

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\washington.riega\\OneDrive - Venturus iTriad\\Área de Trabalho\\UFAM\\TAP\\TP1\\JavaApplication1\\Background_Banner2_Desktop.png")); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(-5, -29, 960, 870);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastraActionPerformed
        // TODO add your handling code here:
        String nome = txtNome.getText();
        Integer cargaHoraria = Integer.parseInt(txtCargaHoraria.getText());
        Integer qtdMaxAlunos = Integer.parseInt(txtQtdMaxAlunos.getText());
        Integer periodo = Integer.parseInt(txtPeriodo.getSelectedItem().toString());
        Float media = Float.parseFloat(txtMedia.getText());
        
        try {
            jdbc.pst = jdbc.con.prepareStatement("INSERT INTO disciplina (id_tabela_professor,nome,carga_horaria,qtd_max_alunos,periodo,media)VALUES(?,?,?,?,?,?)");
            jdbc.pst.setInt(1, professor_id);
            jdbc.pst.setString(2, nome);
            jdbc.pst.setInt(3, cargaHoraria);
            jdbc.pst.setInt(4, qtdMaxAlunos);
            jdbc.pst.setInt(5, periodo);
            jdbc.pst.setFloat(6, media);
            
            int k = jdbc.pst.executeUpdate();
            
            if (k == 1){
                JOptionPane.showMessageDialog(this, "Disciplina cadastrada com sucesso !");
                txtNome.setText("");
                txtCargaHoraria.setText("");
                txtQtdMaxAlunos.setText("");
                txtMedia.setText("");
                Fetch();
            }else{
                JOptionPane.showMessageDialog(this, "Houve um erro ao cadastrar a disciplina");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCadastraActionPerformed

    private void btnEditaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditaActionPerformed
        // TODO add your handling code here:
        String nome = txtNome.getText();
        Integer cargaHoraria = Integer.parseInt(txtCargaHoraria.getText());
        Integer qtdMaxAlunos = Integer.parseInt(txtQtdMaxAlunos.getText());
        Integer periodo = Integer.parseInt(txtPeriodo.getSelectedItem().toString());
        Float media = Float.parseFloat(txtMedia.getText());
        
        try {
            jdbc.pst = jdbc.con.prepareStatement("UPDATE disciplina SET nome=?,carga_horaria=?,qtd_max_alunos=?,periodo=?,media=? WHERE id=?");
            jdbc.pst.setString(1, nome);
            jdbc.pst.setInt(2, cargaHoraria);
            jdbc.pst.setInt(3, qtdMaxAlunos);
            jdbc.pst.setInt(4, periodo);
            jdbc.pst.setFloat(5, media);
            jdbc.pst.setInt(6, Integer.parseInt(pid));
            
            int k = jdbc.pst.executeUpdate();
            if (k == 1){
                JOptionPane.showMessageDialog(this, "A disciplina foi editada com sucesso !!");
                txtNome.setText("");
                txtCargaHoraria.setText("");
                txtQtdMaxAlunos.setText("");
                txtMedia.setText("");
                Fetch();
            }else{
                JOptionPane.showMessageDialog(this, "Deu ruim no update");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditaActionPerformed

    private void btnDeletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletaActionPerformed
        // TODO add your handling code here:
        try {
            jdbc.pst = jdbc.con.prepareStatement("DELETE FROM disciplina WHERE id=?");
            jdbc.pst.setString(1, pid);
            
            int k = jdbc.pst.executeUpdate();
            
            if (k == 1){
                JOptionPane.showMessageDialog(this, "Disciplina deletada com sucesso!");
                txtNome.setText("");
                txtCargaHoraria.setText("");
                txtQtdMaxAlunos.setText("");
                txtMedia.setText("");
                Fetch();
            }else{
                JOptionPane.showMessageDialog(this, "Não foi possível deletar deletar ):");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeletaActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int selectedLineIndex = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        
        pid = model.getValueAt(selectedLineIndex, 0).toString();
        String nome = model.getValueAt(selectedLineIndex, 1).toString();
        String cargaHoraria = model.getValueAt(selectedLineIndex, 2).toString();
        String qtdMaxAlunos = model.getValueAt(selectedLineIndex, 2).toString();
        String media = model.getValueAt(selectedLineIndex, 2).toString();
        
        txtNome.setText(nome);
        txtCargaHoraria.setText(cargaHoraria);
        txtQtdMaxAlunos.setText(qtdMaxAlunos);
        txtMedia.setText(media);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        RitView tela = new RitView(professor_id);
        dispose();
        setSize(986, 232);
        tela.show();
    }//GEN-LAST:event_btnVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(DisciplinaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisciplinaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisciplinaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisciplinaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new DisciplinaView(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastra;
    private javax.swing.JButton btnDeleta;
    private javax.swing.JButton btnEdita;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCargaHoraria;
    private javax.swing.JTextField txtMedia;
    private javax.swing.JTextField txtNome;
    private javax.swing.JComboBox<String> txtPeriodo;
    private javax.swing.JTextField txtQtdMaxAlunos;
    // End of variables declaration//GEN-END:variables
}
