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

        ServerSocket server = null;
        Socket socket = null;
        ObjectInputStream in = null;
        ObjectOutputStream out = null;

    public ConnectionMgr() throws IOException {
        try 
        {
            this.server = new ServerSocket(8000, 100);
            
        }
        catch (IOException ioe)
        {
            System.out.println("ERROR " + ioe.getMessage());
        }
    }
        
    public ObjectInputStream getInStream()
    {return this.in;}
    
    public ObjectOutputStream getOutStrean()
    {return this.out;}
    
          
    public void startSvr() throws IOException
    {
        boolean exit = false;
        try
        {
        while (!exit)
        {
            //Start the server.
            this.socket = server.accept();
            this.in = new ObjectInputStream(socket.getInputStream());
            this.out = new ObjectOutputStream(socket.getOutputStream());
        }
        }
        catch (IOException ioe)
        {
            System.out.println("ERROR " + ioe.getMessage());
        }
    }
    
}