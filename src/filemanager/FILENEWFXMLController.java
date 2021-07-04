/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;



public class FILENEWFXMLController extends ParentFXML implements Initializable {
    @FXML
    public TextField tf1;
    @FXML
    public TableView<Fileinfo> tv;
    @FXML
    public TableColumn<Fileinfo,String> n;
    @FXML
    public TableColumn<Fileinfo,String> d;
    @FXML
    public TableColumn<Fileinfo,String> s;
    AnchorPane a;
    ObservableList<Fileinfo> list1=FXCollections.observableArrayList();

    
    @Override
    public void initialize(URL url1, ResourceBundle rb0) {
        // TODO
            Tableview c=new Tableview(tv,tf1);
            c.dostuff();
           // ObservableList<Fileinfo> list=FXCollections.observableArrayList ();
            
        }
    
    
      
}
  
