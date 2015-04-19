/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.ObjectInputStream;

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
        ObjectInputStream in = newConn.getInStream();
        
        authentic = newSocket.valid(in);
        
        
        
    }
    
}
