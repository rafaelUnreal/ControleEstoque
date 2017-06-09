/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaCaixaView;

import Controller.Controller;
import javafx.embed.swing.JFXPanel;
import javax.swing.JApplet;
import javax.swing.WindowConstants;
import model.ModelBase;
import model.Usuario;

/**
 *
 * @author internet
 */
public class SistemaDeCaixa extends JApplet {
    
    private static final int JFXPANEL_WIDTH_INT = 300;
    private static final int JFXPANEL_HEIGHT_INT = 250;
    private static JFXPanel fxContainer;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
            
          
                Login view = new Login();
                ModelBase model =  new ModelBase();

                Controller controller = new Controller(model,view);
                controller.contol();
                
              
            }
}
   

    