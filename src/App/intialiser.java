/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.swing.Timer;

/**
 *
 * @author Coutso
 */
public class intialiser {
    //private static Timer t;
    public static void main(String[] args){
        Splash splash = new Splash();
        splash.setVisible(true);
        
        InterfaceConnexion inc = new InterfaceConnexion();
        /*
        t = new Timer(100, new ActionListener() {
            int progress = 0;
            
            @Override
            public void actionPerformed(ActionEvent e){
                progress += 1;
                
                splash.setLoad(progress);
                
                if(progress >= 100){
                    t.stop();
                }
            }
            
        });
        */
        
        try {
            
            for(int i = 0; i < 100; i++){
                Thread.sleep(100);
                splash.setLoad(i);
            }
            
        } catch(InterruptedException e){
            
        }
        
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(intialiser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        splash.setVisible(false);
        inc.setVisible(true);
        
        splash.dispose();
    }
}
