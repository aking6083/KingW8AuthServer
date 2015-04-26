/*
 * @desc Starts the auth server
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
    

