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
import modelo.Materia;
import modelo.Pregunta;
import modelo.PreguntaAbierta;
import modelo.PreguntaBooleana;
import modelo.PreguntaCompletar;
import modelo.PreguntaSeleccionMultipleMR;
import modelo.PreguntaSeleccionMultipleUR;
import modelo.Respuesta;

/**
 *
 * @author Sgomez
 */
public class Preguntas extends javax.swing.JFrame {
    
    Controlador c;

    /**
     * Creates new form Preguntas
     */
    public Preguntas() {
        initComponents();
        c = new Controlador();
        cargarMaterias();
        cargarRespuestas();
        cargarPreguntas();
    }
    
    private void cargarPreguntas(){
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                c.getPreguntas().toArray()
            },
            new String [] {
                "Preguntas"
            }
        ));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jtDescripcion = new javax.swing.JTextField();

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Preguntas"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setText("Descripcion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcMateria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcRespuesta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jtDescripcion)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String dificultad = JOptionPane.showInputDialog(this, "Ingrese la dificultad de la pregunta");
        String peso_pregunta = JOptionPane.showInputDialog(this, "Ingrese el peso de la pregunta");
        FabricaPreguntas fp = new FabricaPreguntas();
        int peso = -1;
        boolean valida = false;
        while(!valida){
            try{
                peso = Integer.parseInt(peso_pregunta);
                valida = true;
            }catch(NumberFormatException e){

            }
        }
        Pregunta p = null;
        //Abiera, Booleana, Completar, Seleccion Multiple UR, Seleccion Multiple MR
        if (jComboBox1.getSelectedIndex() == 0){
            p = fp.getPregunta("PreguntaAbierta");
            PreguntaAbierta pa = (PreguntaAbierta) p;
            pa.setDificultadPregunta(dificultad);
            pa.setPesoParaCuestionario(peso);
        }else if (jComboBox1.getSelectedIndex() == 1){
            p = fp.getPregunta("PreguntaBooleana");
            PreguntaBooleana pa = (PreguntaBooleana) p;
            pa.setDifultadPregunta(dificultad);
            pa.setPesoParaCuestionario(peso);
        }else if (jComboBox1.getSelectedIndex() == 2){
            p = fp.getPregunta("PreguntaCompletar");
            PreguntaCompletar pa = (PreguntaCompletar) p;
            pa.setDificultadPregunta(dificultad);
            pa.setPersoParaCuestionario(peso);
        }else if (jComboBox1.getSelectedIndex() == 3){
            p = fp.getPregunta("PreguntaSeleccionMultipleUR");
            PreguntaSeleccionMultipleUR pa = (PreguntaSeleccionMultipleUR) p;
            pa.setDificultadPregunta(dificultad);
            pa.setPesoParaCuestionario(peso);
        }else{
            p = fp.getPregunta("PreguntaSeleccionMultipleMR");
            PreguntaSeleccionMultipleMR pa = (PreguntaSeleccionMultipleMR) p;
            pa.setDificultadPregunta(dificultad);
            pa.setPesoParaCuestionario(peso);
        }
        p.setDescripcionPregunta(jtDescripcion.getText());
        p.setM_Materia((Materia)jcMateria.getSelectedItem());
        p.setM_Respuesta((Respuesta) jcRespuesta.getSelectedItem());
        c.agregarPreguntas(p);
        cargarPreguntas();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox jcMateria;
    private javax.swing.JComboBox jcRespuesta;
    private javax.swing.JTextField jtDescripcion;
    // End of variables declaration//GEN-END:variables
}
