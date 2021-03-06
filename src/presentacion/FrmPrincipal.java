package presentacion;

import entidades.*;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import logica.EmpleadoBL;
import logica.SucursalBL;

/**
 *
 * @author deerfox@debian
 */
public class FrmPrincipal extends javax.swing.JFrame {

    public static boolean confirmar(String pregunta) {
        boolean confirmado = false;
        int resultado = JOptionPane.showConfirmDialog(null, pregunta, "Confirmación", JOptionPane.YES_NO_OPTION);
        if (resultado == JOptionPane.YES_OPTION) {
            confirmado = true;
        } else if (resultado == JOptionPane.NO_OPTION) {
            confirmado = false;
        }
        return confirmado;
    }

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
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

        sucuPanel = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnListarSuc = new javax.swing.JButton();
        lblSucuTitle = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblDesc = new javax.swing.JLabel();
        btnInfo = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        emplPanel = new javax.swing.JPanel();
        btnAsignar = new javax.swing.JButton();
        lblEmplTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("EurekaBank Office Manager");
        setPreferredSize(new java.awt.Dimension(630, 420));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        sucuPanel.setToolTipText("Sucursales");
        sucuPanel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        sucuPanel.setName("sucuPanel"); // NOI18N

        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/registrar-suc.png"))); // NOI18N
        btnRegistrar.setText(" Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar-suc.png"))); // NOI18N
        btnModificar.setText(" Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnListarSuc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnListarSuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/listar-suc.png"))); // NOI18N
        btnListarSuc.setText("     Listar");
        btnListarSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarSucActionPerformed(evt);
            }
        });

        lblSucuTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSucuTitle.setText("Sucursales");

        javax.swing.GroupLayout sucuPanelLayout = new javax.swing.GroupLayout(sucuPanel);
        sucuPanel.setLayout(sucuPanelLayout);
        sucuPanelLayout.setHorizontalGroup(
            sucuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sucuPanelLayout.createSequentialGroup()
                .addGroup(sucuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSucuTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(sucuPanelLayout.createSequentialGroup()
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnListarSuc, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sucuPanelLayout.setVerticalGroup(
            sucuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sucuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSucuTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(sucuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListarSuc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblTitle.setText("Le damos la bienvenida a EurekaBank Office Manager");

        lblDesc.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblDesc.setText("Administre fácilmente las sucursales de su banco.");

        btnInfo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnInfo.setText("Información y Soporte");
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        emplPanel.setToolTipText("Empleados");
        emplPanel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        emplPanel.setName("emplPanel"); // NOI18N

        btnAsignar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAsignar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/asignar.png"))); // NOI18N
        btnAsignar.setText("Asignar");
        btnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarActionPerformed(evt);
            }
        });

        lblEmplTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEmplTitle.setText("Empleados");

        javax.swing.GroupLayout emplPanelLayout = new javax.swing.GroupLayout(emplPanel);
        emplPanel.setLayout(emplPanelLayout);
        emplPanelLayout.setHorizontalGroup(
            emplPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblEmplTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        emplPanelLayout.setVerticalGroup(
            emplPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emplPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEmplTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emplPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnInfo)
                            .addGap(324, 324, 324)
                            .addComponent(btnSalir))
                        .addComponent(sucuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sucuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emplPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInfo)
                    .addComponent(btnSalir))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        sucuPanel.getAccessibleContext().setAccessibleName("Sucursales");
        emplPanel.getAccessibleContext().setAccessibleName("Empleados");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        if (confirmar("¿Desea cerrar el programa?"))
            this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (confirmar("¿Desea cerrar el programa?"))
            this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        new FrmInfoSoporte().setVisible(true);
    }//GEN-LAST:event_btnInfoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        new FrmRegistrarSuc().setVisible(true);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        Sucursal suc;
        String codigo = JOptionPane.showInputDialog(null, "Ingrese el código de la sucursal a modificar", "Modificar sucursal", 3);
        if (codigo != null) {
            suc = SucursalBL.buscarSucursal(codigo);
            if (suc != null) {
                new FrmModificarSuc(suc).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Ninguna sucursal está registrada con ese código.", "Código inválido", 1);
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnListarSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarSucActionPerformed
        new FrmListarSuc().setVisible(true);
    }//GEN-LAST:event_btnListarSucActionPerformed

    private void btnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarActionPerformed
        Empleado emp;
        String codigo = JOptionPane.showInputDialog(null, "Ingrese el código del empleado a modificar", "Modificar sucursal", 3);
        if (codigo != null) {
            emp = EmpleadoBL.buscarEmpleado(codigo);
            if (emp != null) {
                new FrmAsignarEmpl(emp).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Ningún empleado está registrado con ese código.", "Código inválido", 1);
            }
        }
    }//GEN-LAST:event_btnAsignarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the FlatLaf Light look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.out.println(ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignar;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnListarSuc;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel emplPanel;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblEmplTitle;
    private javax.swing.JLabel lblSucuTitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel sucuPanel;
    // End of variables declaration//GEN-END:variables
}
