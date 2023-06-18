/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.disciplina;

import com.mycompany.productcrud.productForm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author washington.riega
 */
public class DisciplinaView extends javax.swing.JFrame {

    /**
     * Creates new form CreateDisciplina
     */
    private Integer professor_id;
    
    public DisciplinaView(Integer id) {
        professor_id = id;
        initComponents();
        Connect();
        Fetch();
        LoadProductNo();
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/javacrud","root","Was120603@");
        } catch(ClassNotFoundException ex) {
            System.out.println("Driver do JDBC não encontrado !");
            ex.printStackTrace();
        } catch(SQLException ex){
            System.out.println("Falha ao conectar ao banco de dados!");
            ex.printStackTrace();
        } 
    }
    
    public void LoadProductNo(){
        try {
            pst = con.prepareStatement("SELECT id FROM disciplina");
            rs = pst.executeQuery();
            txtpid.removeAllItems();
            while(rs.next()){
                txtpid.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void Fetch(){
        int q;
        try {
            pst = con.prepareStatement("SELECT * FROM disciplina WHERE id_tabela_professor=?");
            pst.setInt(1, professor_id);
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel(); 
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for(int a=1; a<=q; a++){
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("nome"));
                    v2.add(rs.getString("carga_horaria"));
                    v2.add(rs.getString("qtd_max_alunos"));
                    v2.add(rs.getString("periodo"));
                    v2.add(rs.getString("media"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
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
        txtpid = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnPesquisa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Disciplina");

        jLabel2.setText("Nome");

        jLabel3.setText("Carga Horaria");

        jLabel4.setText("Quantidade máxima de alunos");

        jLabel5.setText("Período da disciplina");

        txtPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));

        jLabel6.setText("Média");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Período", "Média", "Carga Horária", "Quantidade Máxima de Alunos"
            }
        ));
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

        btnDeleta.setText("Excluir");
        btnDeleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletaActionPerformed(evt);
            }
        });

        txtpid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Pesquisar:");

        btnPesquisa.setText("Selecionar");
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(78, 78, 78)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtQtdMaxAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCadastra)
                                .addGap(39, 39, 39)
                                .addComponent(btnEdita)
                                .addGap(33, 33, 33)
                                .addComponent(btnDeleta)
                                .addGap(83, 83, 83)
                                .addComponent(jLabel7)
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                    .addComponent(txtpid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(66, 66, 66))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQtdMaxAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeleta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtpid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisa)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

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
            pst = con.prepareStatement("INSERT INTO disciplina (id_tabela_professor,nome,carga_horaria,qtd_max_alunos,periodo,media)VALUES(?,?,?,?,?,?)");
            pst.setInt(1, professor_id);
            pst.setString(2, nome);
            pst.setInt(3, cargaHoraria);
            pst.setInt(4, qtdMaxAlunos);
            pst.setInt(5, periodo);
            pst.setFloat(6, media);
            
            int k = pst.executeUpdate();
            
            if (k == 1){
                JOptionPane.showMessageDialog(this, "Disciplina cadastrada com sucesso !");
                txtNome.setText("");
                txtCargaHoraria.setText("");
                txtQtdMaxAlunos.setText("");
                txtMedia.setText("");
                Fetch();
                LoadProductNo();
            }else{
                JOptionPane.showMessageDialog(this, "Houve um erro ao cadastrar a disciplina");
            }
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
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
            pst = con.prepareStatement("UPDATE professor SET nome=?,carga_horaria=?,qtd_max_alunos=?,periodo=?,media=? WHERE id=?");
            pst.setString(1, nome);
            pst.setInt(2, cargaHoraria);
            pst.setInt(3, qtdMaxAlunos);
            pst.setInt(4, periodo);
            pst.setFloat(5, media);
            pst.setInt(6, professor_id);
            
            int k = pst.executeUpdate();
            if (k == 1){
                JOptionPane.showMessageDialog(this, "A disciplina foi editada com sucesso !!");
                txtNome.setText("");
                txtCargaHoraria.setText("");
                txtQtdMaxAlunos.setText("");
                txtMedia.setText("");
                Fetch();
                LoadProductNo();
            }else{
                JOptionPane.showMessageDialog(this, "Deu ruim no update");
            }
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditaActionPerformed

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed
        // TODO add your handling code here:
        String pid =  txtpid.getSelectedItem().toString();
        
        try {
            pst = con.prepareStatement("SELECT * FROM disciplina WHERE id=?");
            pst.setString(1,pid);
            rs=pst.executeQuery();
            
            if(rs.next() == true){
                txtNome.setText(rs.getString(3));
                txtCargaHoraria.setText(rs.getString(4));
                txtQtdMaxAlunos.setText(rs.getString(5));
                txtMedia.setText(rs.getString(6));
            }else{
                JOptionPane.showMessageDialog(this, "Não foi encontrado nenhuma disciplina com esse ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPesquisaActionPerformed

    private void btnDeletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletaActionPerformed
        // TODO add your handling code here:
        String pid =  txtpid.getSelectedItem().toString();
        try {
            pst = con.prepareStatement("DELETE FROM disciplina WHERE id=?");
            pst.setString(1, pid);
            
            int k = pst.executeUpdate();
            
            if (k == 1){
                JOptionPane.showMessageDialog(this, "Disciplina deletada com sucesso!");
                txtNome.setText("");
                txtCargaHoraria.setText("");
                txtQtdMaxAlunos.setText("");
                txtMedia.setText("");
                Fetch();
                LoadProductNo();
            }else{
                JOptionPane.showMessageDialog(this, "Não foi possível deletar deletar ):");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeletaActionPerformed

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
    private javax.swing.JButton btnPesquisa;
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
    private javax.swing.JComboBox<String> txtpid;
    // End of variables declaration//GEN-END:variables
}