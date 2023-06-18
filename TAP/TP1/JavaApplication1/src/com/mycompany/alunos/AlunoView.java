/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.alunos;

import com.mycompany.connection.ConnectionJdbc;
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
public class AlunoView extends javax.swing.JFrame {

    /**
     * Creates new form AlunoView
     */
    private Integer professor_id;
    private String pid;
    
    public AlunoView(Integer id) {
        professor_id = id;
        initComponents();
        jdbc.Connect();
        Fetch();
    }
    
    ConnectionJdbc jdbc = new ConnectionJdbc();
    
    private void Fetch(){
        int q;
        try {
            jdbc.pst = jdbc.con.prepareStatement("SELECT * FROM alunos WHERE id_tabela_aluno_prof=?");
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
                    v2.add(jdbc.rs.getString("matricula"));
                    v2.add(jdbc.rs.getString("periodo"));
                    v2.add(jdbc.rs.getString("tipo_aluno"));
                    v2.add(jdbc.rs.getString("idade"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoView.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel6 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtMatricula = new javax.swing.JTextField();
        txtPeriodo = new javax.swing.JTextField();
        txtTipoAluno = new javax.swing.JTextField();
        txtIdade = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnCadastra = new javax.swing.JButton();
        btnEdita = new javax.swing.JButton();
        btnDeleta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Alunos");

        jLabel2.setText("Nome:");

        jLabel3.setText("Matricula:");

        jLabel4.setText("Período:");

        jLabel5.setText("Tipo de Aluno:");

        jLabel6.setText("Idade:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Matrícula", "Período", "Tipo de Aluno", "Idade"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnCadastra.setText("Cadastrar");
        btnCadastra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraActionPerformed(evt);
            }
        });

        btnEdita.setText("Editar");
        btnEdita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditaActionPerformed(evt);
            }
        });

        btnDeleta.setText("Deletar");
        btnDeleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(417, 417, 417)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnCadastra)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnEdita))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtTipoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(80, 80, 80)
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(btnDeleta)))))))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastra)
                    .addComponent(btnEdita)
                    .addComponent(btnDeleta))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastraActionPerformed
        // TODO add your handling code here:
        String nome = txtNome.getText();
        String matricula = txtMatricula.getText();
        Integer periodo = Integer.parseInt(txtPeriodo.getText());
        String tipoAluno = txtTipoAluno.getText();
        Integer idade = Integer.parseInt(txtIdade.getText());
      
        try {
            jdbc.pst = jdbc.con.prepareStatement("INSERT INTO alunos (id_tabela_aluno_prof,nome,matricula,periodo,tipo_aluno,idade)VALUES(?,?,?,?,?,?)");
            jdbc.pst.setInt(1, professor_id);
            jdbc.pst.setString(2, nome); 
            jdbc.pst.setString(3, matricula);
            jdbc.pst.setInt(4, periodo);
            jdbc.pst.setString(5, tipoAluno);
            jdbc.pst.setFloat(6, idade);
            
            int k = jdbc.pst.executeUpdate();
            
            if (k == 1){
                JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso !");
                txtNome.setText("");
                txtMatricula.setText("");
                txtPeriodo.setText("");
                txtTipoAluno.setText("");
                txtIdade.setText("");
                Fetch();
            }else{
                JOptionPane.showMessageDialog(this, "Houve um erro ao cadastrar a disciplina");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCadastraActionPerformed

    private void btnEditaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditaActionPerformed
        // TODO add your handling code here:
        String nome = txtNome.getText();
        String matricula = txtMatricula.getText();
        Integer periodo = Integer.parseInt(txtPeriodo.getText());
        String tipoAluno = txtTipoAluno.getText();
        Integer idade = Integer.parseInt(txtIdade.getText());
        
        try {
            jdbc.pst = jdbc.con.prepareStatement("UPDATE alunos SET nome=?,matricula=?,periodo=?,tipo_aluno=?,idade=? WHERE id=?");
           jdbc.pst.setString(1, nome); 
            jdbc.pst.setString(2, matricula);
            jdbc.pst.setInt(3, periodo);
            jdbc.pst.setString(4, tipoAluno);
            jdbc.pst.setFloat(5, idade);
            jdbc.pst.setInt(6, Integer.parseInt(pid));
            
            int k = jdbc.pst.executeUpdate();
            if (k == 1){
                JOptionPane.showMessageDialog(this, "O aluno foi editado com sucesso !!");
                txtNome.setText("");
                txtMatricula.setText("");
                txtPeriodo.setText("");
                txtTipoAluno.setText("");
                txtIdade.setText("");
                Fetch();
            }else{
                JOptionPane.showMessageDialog(this, "Deu ruim no update");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditaActionPerformed

    private void btnDeletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletaActionPerformed
        // TODO add your handling code here:
        try {
            jdbc.pst = jdbc.con.prepareStatement("DELETE FROM disciplina WHERE id=?");
            jdbc.pst.setString(1, pid);
            
            int k = jdbc.pst.executeUpdate();
            
            if (k == 1){
                JOptionPane.showMessageDialog(this, "Aluno deletado com sucesso!");
                txtNome.setText("");
                txtMatricula.setText("");
                txtPeriodo.setText("");
                txtTipoAluno.setText("");
                txtIdade.setText("");
                Fetch();
            }else{
                JOptionPane.showMessageDialog(this, "Não foi possível deletar");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AlunoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeletaActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int selectedLineIndex = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        
        pid = model.getValueAt(selectedLineIndex, 0).toString();
        String nome = model.getValueAt(selectedLineIndex, 1).toString();
        String matricula = model.getValueAt(selectedLineIndex, 2).toString();
        String periodo = model.getValueAt(selectedLineIndex, 3).toString();
        String tipoAluno = model.getValueAt(selectedLineIndex, 4).toString();
        String idade = model.getValueAt(selectedLineIndex, 5).toString();
        
        txtNome.setText(nome);
        txtMatricula.setText(matricula);
        txtPeriodo.setText(periodo);
        txtTipoAluno.setText(tipoAluno);
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
            java.util.logging.Logger.getLogger(AlunoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlunoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlunoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlunoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlunoView(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastra;
    private javax.swing.JButton btnDeleta;
    private javax.swing.JButton btnEdita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPeriodo;
    private javax.swing.JTextField txtTipoAluno;
    // End of variables declaration//GEN-END:variables
}
