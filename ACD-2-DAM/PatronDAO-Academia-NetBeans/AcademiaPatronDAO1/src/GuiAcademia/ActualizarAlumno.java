/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GuiAcademia;

import factoryDAO.DaoFactory;
import interfaceIDao.IDao;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelosAcademia.Alumno;
import modelosDaos.AlumnoDao;

/**
 *
 * @author lfelipeh
 */
public class ActualizarAlumno extends javax.swing.JFrame {

    private RegistroAlumnos principal;

    public ActualizarAlumno(RegistroAlumnos principal) {
        this.principal = principal;
        initComponents();
        setLabelImage();
    }

    /**
     * Creates new form ActualizarAlumno
     */
    private void setLabelImage() {

        //ESTE CODIGO SE IMPLEMENTA CUANDO CREE EL JLABELIMAGE EN DESIGN.
        Image img1 = Toolkit.getDefaultToolkit().createImage("/home/lfelipeh/Documentos/AD2-DAM/NetBeansProjects/AcademiaPatronDAO1/src/GuiAcademia/images/logo-itaca.jpg");
        img1 = img1.getScaledInstance(jLabelItaca.getWidth(), jLabelItaca.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon img2 = new ImageIcon(img1);
        jLabelItaca.setIcon(img2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelItaca = new javax.swing.JLabel();
        jLabelTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelDni = new javax.swing.JLabel();
        jTextFieldDni = new javax.swing.JTextField();
        jLabelName = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldSurname = new javax.swing.JTextField();
        jLabelLocation = new javax.swing.JLabel();
        jTextFieldLocation = new javax.swing.JTextField();
        jLabelBirth = new javax.swing.JLabel();
        jTextFieldBirth = new javax.swing.JTextField();
        jLabelZip = new javax.swing.JLabel();
        jTextFieldZip = new javax.swing.JTextField();
        jLabelNumberT = new javax.swing.JLabel();
        jTextFieldNumberT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTitle.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(0, 153, 0));
        jLabelTitle.setText("ACTUALIZACIÓN  ALUMNOS IES ÍTACA 2 DAM");

        jPanel1.setLayout(new java.awt.GridLayout(8, 2));

        jLabelDni.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabelDni.setText("Introduzca el dni del alumno: (Cadena Texto)");
        jPanel1.add(jLabelDni);
        jPanel1.add(jTextFieldDni);

        jLabelName.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabelName.setText("Introduzca el nombre del alumno: (Cadena Texto)");
        jPanel1.add(jLabelName);
        jPanel1.add(jTextFieldName);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setText("Introduzca el apellido del alumno: (Cadena Texto)");
        jPanel1.add(jLabel3);
        jPanel1.add(jTextFieldSurname);

        jLabelLocation.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabelLocation.setText(" Introduzca la direccion del alumno: (Cadena Texto)");
        jPanel1.add(jLabelLocation);
        jPanel1.add(jTextFieldLocation);

        jLabelBirth.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabelBirth.setText("Introduzca la fecha de nacimiento:  (Cadena Texto)");
        jPanel1.add(jLabelBirth);
        jPanel1.add(jTextFieldBirth);

        jLabelZip.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabelZip.setText("Introduzca el codigo postal: (Número Entero)");
        jPanel1.add(jLabelZip);
        jPanel1.add(jTextFieldZip);

        jLabelNumberT.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabelNumberT.setText("Introduzca el teléfono del alumno: (Cadena Texto)");
        jPanel1.add(jLabelNumberT);
        jPanel1.add(jTextFieldNumberT);

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel8.setText("Introduzca el Id del alumno: (Número Entero)");
        jPanel1.add(jLabel8);
        jPanel1.add(jTextFieldID);

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Actualizar Alumno");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelItaca, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelItaca, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTitle))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            // Validar el campo de ID antes de convertirlo
            if (jTextFieldID.getText().isEmpty() || !jTextFieldID.getText().matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID válido (solo números).", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int idAlumno = Integer.parseInt(jTextFieldID.getText());

            // Confirmar la actualización
            int confirmation = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea actualizar el registro con ID " + idAlumno + "?",
                    "Confirmar actualización", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                // Crear un objeto Alumno con los datos actualizados
                Alumno updateAlumno = new Alumno();
                // Validar y asignar los datos de los demás campos
                updateAlumno.setDni_alumno(jTextFieldDni.getText());
                updateAlumno.setNombre_alumno(jTextFieldName.getText());
                updateAlumno.setApellido_alumno(jTextFieldSurname.getText());
                updateAlumno.setDireccion_alumno(jTextFieldLocation.getText());
                updateAlumno.setTelefono_alumno(jTextFieldNumberT.getText());
                updateAlumno.setId_alumno(idAlumno);

                if (jTextFieldZip.getText().isEmpty() || !jTextFieldZip.getText().matches("\\d+")) {
                    JOptionPane.showMessageDialog(this, "Por favor, ingrese un código postal válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                updateAlumno.setCodPostal_alumno(Integer.parseInt(jTextFieldZip.getText()));

                updateAlumno.setFecha_nacimiento(jTextFieldBirth.getText());

                // Actualizar el registro en la base de datos
                IDao daoAlumno = DaoFactory.getDaoType(DaoFactory.Daotype.ALUMNO);
                boolean actualizado = daoAlumno.actualizarRegistro(updateAlumno, updateAlumno.getId_alumno());

                if (actualizado) {
                    JOptionPane.showMessageDialog(this, "¡Registro actualizado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    principal.cargarDatosEnTabla();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo actualizar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (EnumConstantNotPresentException | ClassNotFoundException ex) {
            Logger.getLogger(ActualizarAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ActualizarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActualizarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActualizarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActualizarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegistroAlumnos registro;
                try {
                    registro = new RegistroAlumnos();
                    ActualizarAlumno actualizar = new ActualizarAlumno(registro);
                    actualizar.setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ActualizarAlumno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelBirth;
    private javax.swing.JLabel jLabelDni;
    private javax.swing.JLabel jLabelItaca;
    private javax.swing.JLabel jLabelLocation;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelNumberT;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelZip;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldBirth;
    private javax.swing.JTextField jTextFieldDni;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldLocation;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldNumberT;
    private javax.swing.JTextField jTextFieldSurname;
    private javax.swing.JTextField jTextFieldZip;
    // End of variables declaration//GEN-END:variables
}
