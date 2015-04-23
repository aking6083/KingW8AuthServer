/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import domain.Login;
/**
 *
 * @author root
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        
        boolean authentic = false;
        
        ConnectionMgr newConn = new ConnectionMgr();
        SocketMgr newSocket = new SocketMgr();
        newConn.startSvr();
        authentic = newSocket.valid(newConn.getInStream());
        //Login tempLogin = (Login) newConn.getInStream().readObject();
        //System.out.println(tempLogin.getPassword());
        //ObjectOutputStream out = newConn.getOutStrean();
        //ObjectInputStream in = newConn.getInStream();
        //Login testLogin = (Login) in.readObject();
        //System.out.println(testLogin.getUserName());
        //System.out.println("Validating Obect");
        //authentic = newSocket.valid(in);
        //System.out.println("Getting Output");
        ObjectOutputStream out =  newConn.getOutStrean();
        try 
        {
        out.writeBoolean(authentic);
        }
        catch (IOException ioe)
        {
            System.out.println(ioe.getMessage());
        }
      }
    }
    

