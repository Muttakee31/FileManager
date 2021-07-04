/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;

/**
 *
 * @author hp
 */

public class FXMLFactory {
    TextField a;
    TableView b;
    TilePane c;
    private static final FXMLFactory INSTANCE = new FXMLFactory();
       public static FXMLFactory getInstance() { 
		return INSTANCE; 
        }
    public final ParentFXML CreateFXML(AnchorPane ap,boolean x) throws IOException {
        ParentFXML o=null;
        
        if (x==true) {
        //    AnchorPane pane = FXMLLoader.load(getClass().getResource("FILENEWERFXML.fxml"));
        //    ap.getChildren().setAll(pane);
            return new Tableview(b,a);
//            Logger.getLogger(FILEFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        else {
        //    AnchorPane pane = FXMLLoader.load(getClass().getResource("FILENEWFXML.fxml"));
        //    ap.getChildren().setAll(pane);
            return new Tilepane(c,a);
        }
    }
}
