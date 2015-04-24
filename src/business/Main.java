/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author root
 */
public class Main {

    /**
     * @param args the command line arguments
     * 
     */
        public static void main(String[] args) 
        {
            try {
                ConnectionMgr.startSvr();
            }
            catch (Exception ex) {
                System.out.println("Exception " + ex.getMessage());
            }
        }
    }
    

