/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.Controlador;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.FabricaPreguntas;
import modelo.FacadePregunta;
import modelo.Materia;
import modelo.Pregunta;
import modelo.Respuesta;

/**
 *
 * @author sgomez
 */
public class Preguntas extends javax.swing.JFrame {
    
    private Controlador c = Controlador.getInstancia();
    private Pregunta modificar;

    /**
     * Creates new form Preguntas
     */
    public Preguntas() {
        initComponents();
        cargarMaterias();
        cargarRespuestas();
        cargarPreguntas();
    }
    
    private void cargarPreguntas(){
        jList1.setModel(new javax.swing.AbstractListModel() {
            Object[] strings = c.getPreguntas().toArray();
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
    }
    
    private void cargarRespuestas(){
        jcRespuesta.setModel(new DefaultComboBoxModel(c.getRespuestas().toArray()));
    }
    
    private void cargarMaterias(){
        jcMateria.setModel(new javax.swing.DefaultComboBoxModel(c.getMaterias().toArray()));
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
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jcMateria = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jcRespuesta = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jtDescripcion = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Preguntas");

        jLabel2.setText("Tipo Pregunta");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Abiera", "Booleana", "Completar", "Seleccion Multiple UR", "Seleccion Multiple MR" }));

        jButton1.setText("Generar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Materia");

        jcMateria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Respuesta");

        jcRespuesta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Descripcion");

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        jButton2.setText("Cargar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, 0, 226, Short.MAX_VALUE)
                            .addComponent(jcMateria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcRespuesta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jtDescripcion)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jcRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (modificar == null){
            String dificultad = JOptionPane.showInputDialog(this, "Ingrese la dificultad de la pregunta");
            String peso_pregunta = JOptionPane.showInputDialog(this, "Ingrese el peso de la pregunta");
            int peso = -1;
            boolean valida = false;
            while(!valida){
                try{
                    peso = Integer.parseInt(peso_pregunta);
                    valida = true;
                }catch(NumberFormatException e){

                }
            }
            Pregunta p = new FacadePregunta().generarPregunta(jComboBox1.getSelectedItem().toString(), dificultad, peso, 0, jtDescripcion.getText());
            //Abiera, Booleana, Completar, Seleccion Multiple UR, Seleccion Multiple MR
            p.setM_Materia((Materia)jcMateria.getSelectedItem());
            p.setM_Respuesta((Respuesta) jcRespuesta.getSelectedItem());
            c.agregarPreguntas(p);
            cargarPreguntas();
            JOptionPane.showMessageDialog(this, "Pregunta almacenada correctamente con el ID "+p.getIdPregunta());
        }else{
            modificar.setDescripcionPregunta(jtDescripcion.getText());
            modificar.setM_Materia((Materia)jcMateria.getSelectedItem());
            modificar.setM_Respuesta((Respuesta) jcRespuesta.getSelectedItem());            
            JOptionPane.showMessageDialog(this, "Pregunta actualizada correctamente con el ID "+modificar.getIdPregunta());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (jList1.getSelectedValue() != null){
            modificar = (Pregunta) jList1.getSelectedValue();
            jcMateria.setSelectedItem(modificar.getM_Materia());
            jcRespuesta.setSelectedItem(modificar.getM_Respuesta());
            jComboBox1.setSelectedItem(modificar.getCaracteristicaPregunta());
            jComboBox1.setEditable(false);
            jtDescripcion.setText(modificar.getDescripcionPregunta());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(jList1.getSelectedValue() != null){
            Pregunta eli = (Pregunta) jList1.getSelectedValue();
            c.eliminarPreguntas(eli);
            cargarPreguntas();
            JOptionPane.showMessageDialog(this, "Se ha eliminado la pregunta con el ID "+eli.getIdPregunta());
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox jcMateria;
    private javax.swing.JComboBox jcRespuesta;
    private javax.swing.JTextField jtDescripcion;
    // End of variables declaration//GEN-END:variables
}
