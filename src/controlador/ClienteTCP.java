/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sgomez
 */
public class ClienteTCP {
    
    private static final int puerto = 4444;
    private static final String dstServidor = "localhost";
    private static Socket servidor;
    private static BufferedReader isServidor;
    private static PrintWriter osServidor;

    public ClienteTCP() {
        iniciarComunicacionServidor();
    }
    
    
    public void escribirServidor(String user, String pwd) {
        if (osServidor != null) {
            osServidor.println(user + "|" + pwd);
        }
    }
    
    public void escribirServidor(Object o) {
        if (osServidor != null) {
            osServidor.println(o);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(ClienteTCP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void terminarComunicacionServidor() {
        try {
            isServidor.close();
            osServidor.close();
            servidor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String leerServidor(){
        String strLinSer = "";
        try {
            if (isServidor != null && isServidor.ready() ){
                while(isServidor.ready()){
                    strLinSer = isServidor.readLine();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ClienteTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return strLinSer;
    }
    
    
    private void iniciarComunicacionServidor() {

        try {
            servidor = new Socket(dstServidor, puerto);

            try {
                isServidor = new BufferedReader(new InputStreamReader(servidor.getInputStream()));
                osServidor = new PrintWriter(servidor.getOutputStream(), true);
                Thread.sleep(10);
                System.out.println(leerServidor());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException ex) {
                Logger.getLogger(ClienteTCP.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException e) {
            System.out.println("No se puede comunicar con el servidor");
        }

    }
    
}
