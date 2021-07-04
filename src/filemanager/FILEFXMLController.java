/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FILEFXMLController implements Initializable {
    @FXML
    private Button bt;
    @FXML
    private Button bt1;
    @FXML
    private Button bt2;
    @FXML
    TreeView <String> TV;
    @FXML
    AnchorPane ap;
    @FXML
    
    ImageView ic =new ImageView( new Image("thispc.png"));
    
    public static String st="ThisPC";
    
    public static boolean aa=true;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("FILENEWERFXML.fxml"));
            ap.getChildren().setAll(pane);
            FXMLFactory d=new FXMLFactory();
            d.getInstance().CreateFXML(ap,aa);
            Tree t=new Tree(TV);
            t.createTree(ic);
        } catch (IOException ex) {
            Logger.getLogger(FILEFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void setOnAction2(ActionEvent event) throws IOException {
        //Tx.clear();
        aa=false;
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FILENEWFXML.fxml"));
        ap.getChildren().setAll(pane);
        FXMLFactory d=new FXMLFactory();
        d.getInstance().CreateFXML(ap,aa);
    }
    @FXML    
    private void setOnAction1 (ActionEvent event) throws IOException {
        //Tx.clear();
        aa=true;
        AnchorPane pane2 = FXMLLoader.load(getClass().getResource("FILENEWERFXML.fxml"));
        ap.getChildren().setAll(pane2);
        FXMLFactory d=new FXMLFactory();
        d.getInstance().CreateFXML(ap,aa);
    }
    
    @FXML
    private void setOnAction(ActionEvent event) throws IOException {
        //Tx.clear();
        File a=new File(st);
        st=a.getParent();
        System.out.println(st);
        if (st==null) {st="ThisPC";}
        if (aa==true) {
            AnchorPane pane2 = FXMLLoader.load(getClass().getResource("FILENEWERFXML.fxml"));
            ap.getChildren().setAll(pane2);
            FXMLFactory d=new FXMLFactory();
            d.getInstance().CreateFXML(ap,aa);
            }
        else {
             AnchorPane pane2 = FXMLLoader.load(getClass().getResource("FILENEWFXML.fxml"));
            ap.getChildren().setAll(pane2);
            FXMLFactory d=new FXMLFactory();
            d.CreateFXML(ap,aa);
            }
        }
    }