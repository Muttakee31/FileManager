/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FILENEWERFXMLController extends ParentFXML implements Initializable {
    

    private AnchorPane a;
    @FXML
    private TilePane tp1;
    @FXML
    private TextField tf2;
  /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     //   walk();
       
        Tilepane q=new Tilepane(tp1,tf2);
        
        q.dostuff();
        
    }    
    
}
