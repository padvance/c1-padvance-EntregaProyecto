/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import controlador.PersistenciaBD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import modelo.Examen;
import modelo.FacadePregunta;
import modelo.Materia;
import modelo.Pregunta;
import modelo.Respuesta;

/**
 *
 * @author rm-rf
 */
public class ServerTCP implements Runnable {

    private ServerSocket server;
    private int port = 4444;
    private boolean arriba = false;
    protected Thread runningThread = null;
    private PersistenciaBD persistencia;

    public ServerTCP() {
        persistencia = new PersistenciaBD();
    }

    public ServerTCP(int port) {
        this();
        this.port = port;
    }

    public void iniciarServidor() {
        try {
            server = new ServerSocket(port);
            System.out.println("Servidor Java Activo! \n");
            System.out.println("" + server + "\n");
            arriba = true;
//            utilSql.agregarAuditoria(new String[]{"servidor", "localhost"});
        } catch (IOException e) {
            System.err.println("No se pudo iniciar el servidor puerto " + port + " ocupado ");
            e.printStackTrace();
        }
    }

    public synchronized void apagarServidor() {
        this.arriba = false;
        if (this.server != null) {
            if (!this.server.isClosed()) {
                try {
                    this.server.close();
                    System.out.println("Servidor Java Apagado! \n");
                } catch (IOException e) {
                    System.err.println("No se pudo apagar el servidor ");
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void run() {
        synchronized (this) {
            this.runningThread = Thread.currentThread();
        }
        iniciarServidor();
        while (estaArriba()) {
            Socket cliente = null;
            try {
                cliente = this.server.accept();
            } catch (IOException e) {
                if (!estaArriba()) {
                    System.err.println("El servidor se encuentra apagado");
                    return;
                }
                e.printStackTrace();
            }
            if (cliente != null) {
                try {
                    new Thread(new ClienteConectado(cliente, persistencia)).start();
                } catch (IOException e) {
                    System.err.println("Ocurrio un error al momento de leer el cliente");
                    e.printStackTrace();
                }
            }
        }
        System.out.println("El servidor se encuentra apagado");
    }

    private synchronized boolean estaArriba() {
        return this.arriba;
    }
    
    public static void main(String[] args) throws IOException {
        ServerTCP serverTCP = new ServerTCP();
        new Thread(serverTCP).start();
        while (true) {
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class ClienteConectado implements Runnable {

    private Socket cliente;
    private BufferedReader reader;
    private PrintWriter writer;
    private String clientRequest;
    private PersistenciaBD con;

    public ClienteConectado(Socket cliente, PersistenciaBD con) throws IOException {
        this.cliente = cliente;
        reader = new BufferedReader(new InputStreamReader(this.cliente.getInputStream()));
        writer = new PrintWriter(new OutputStreamWriter(this.cliente.getOutputStream()), true);
        writer.println("Bienvenido al Servidor: " + new Date());
        this.con = con;
    }

    @Override
    public void run() {
        while (true) {
            try {
                clientRequest = reader.readLine();

                System.out.println("Recibido de : " + clientRequest);
                
                if (clientRequest.startsWith("001")) {
                    Materia m = new Materia(clientRequest.replaceFirst("001", ""));
                    con.agregarMateria(m);
                    System.out.println("Materia almacenada " + m.getIdMateria());
                    writer.println(m.getIdMateria());
                }else if (clientRequest.startsWith("019")) {
                    Respuesta r = new Respuesta(clientRequest.replaceFirst("019", ""));
                    con.agregarRespuesta(r);
                    System.out.println("Respuesta almacenada " + r.getIdRespuesta());
                    writer.println(r.getIdRespuesta()); 
                }else if (clientRequest.startsWith("003")) {
                    String[] split = clientRequest.replaceFirst("003", "").split("\\|");
                    Pregunta p = new FacadePregunta().generarPregunta(clientRequest, split[2], split[3], split[0], split[1]);
                    Materia m = new Materia();
                    m.setIdMateria(Integer.parseInt(split[4]));
                    
                    Respuesta r = new Respuesta();
                    r.setIdRespuesta(Integer.parseInt(split[5]));
                    
                    p.setM_Materia(m);
                    p.setM_Respuesta(r);
                    con.agregarPregunta(p);
                    System.out.println("Pregunta almacenada " + p.getIdPregunta());
                    writer.println(p.getIdPregunta()); 
                }else if (clientRequest.startsWith("020")) {
                    Examen e = new Examen(clientRequest.replaceFirst("020", ""));
                    con.agregarExamen(e);
                    System.out.println("Examen almacenado " + e.getIdExamen());
                    writer.println(e.getIdExamen()); 
                }else if (clientRequest.startsWith("005")){//Modificar materia
                    Materia m = new Materia(clientRequest.replaceFirst("005", ""));
                    con.modificarMateria(m);
                    System.out.println("Materia actualizada " + m.getIdMateria());
                    writer.println(m.getIdMateria());
                }else if (clientRequest.startsWith("007")){//Modificar pregunta
                    String[] split = clientRequest.replaceFirst("007", "").split("\\|");
                    Pregunta p = new FacadePregunta().generarPregunta(clientRequest, split[2], split[3], split[0], split[1]);
                    Materia m = new Materia();
                    m.setIdMateria(Integer.parseInt(split[4]));
                    
                    Respuesta r = new Respuesta();
                    r.setIdRespuesta(Integer.parseInt(split[5]));
                    
                    p.setM_Materia(m);
                    p.setM_Respuesta(r);
                    con.modificarPregunta(p);
                    System.out.println("Pregunta actualizada " + p.getIdPregunta());
                    writer.println(p.getIdPregunta()); 
                }else if (clientRequest.startsWith("021")){//Modificar Respuesta
                    Respuesta r = new Respuesta(clientRequest.replaceFirst("021", ""));
                    con.modificarRespuesta(r);
                    System.out.println("Respuesta actualizada " + r.getIdRespuesta());
                    writer.println(r.getIdRespuesta()); 
                }else if (clientRequest.startsWith("022")){//Modificar Examen
                    Examen e = new Examen(clientRequest.replaceFirst("022", ""));
                    con.modificarExamen(e);
                    System.out.println("Examen actualizado " + e.getIdExamen());
                    writer.println(e.getIdExamen()); 
                }else if (clientRequest.startsWith("013")){//Eliminar Materia
                    Materia m = new Materia(clientRequest.replaceFirst("013", ""));
                    String res = con.eliminarMateria(m);
                    writer.println(res);
                    System.out.println("Materia eliminada " + m.getIdMateria()+ " " + res);
                }else if (clientRequest.startsWith("015")){//Eliminar Pregunta
                    String[] split = clientRequest.replaceFirst("007", "").split("\\|");
                    Pregunta p = new FacadePregunta().generarPregunta(clientRequest, split[2], split[3], split[0], split[1]);
                    Materia m = new Materia();
                    m.setIdMateria(Integer.parseInt(split[4]));
                    
                    Respuesta r = new Respuesta();
                    r.setIdRespuesta(Integer.parseInt(split[5]));
                    
                    p.setM_Materia(m);
                    p.setM_Respuesta(r);
                    String res = con.eliminarPregunta(p);
                    writer.println(res);
                    System.out.println("Pregunta eliminada " + p.getIdPregunta() + " " + res);
                }
            } catch (Throwable e) {
                System.out.println("Excepción en el servidor " + e);
                writer.println("Adios :");
                try {
                    cliente.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                break;
            }
        }
    }

    public String getClientRequest() {
        return clientRequest;
    }

    public void setClientRequest(String clientRequest) {
        this.clientRequest = clientRequest;
    }

}
