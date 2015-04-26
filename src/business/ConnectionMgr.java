/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;
import java.net.*;
import java.io.*;
import domain.Login;
/**
 *
 * @author root
 */
public class ConnectionMgr {

          
    public static void startSvr() throws Exception
    {
        ServerSocket server = null;
        Socket socket = null;
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        Thread myThread = new Thread();
        SocketMgr socketMgr = new SocketMgr();
        boolean run = true;
        
        server = new ServerSocket(8000,100);
        while(run) {
            System.out.println("Waiting for connection");
            socketMgr.setSocket(server.accept()); 
            System.out.println("Connection accepted");
            Thread socketThread = new Thread(socketMgr);
            socketThread.start();
            
        }
        
    }
    
}