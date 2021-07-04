/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import static filemanager.FILEFXMLController.st;
import java.io.File;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;

/**
 *
 * @author hp
 */
public class Tilepane extends ParentFXML {
     TilePane z;
     TextField e;
     Tilepane(TilePane a,TextField c) {
         this.z=a;
         this.e=c;
     }

     public Button filebutton(File a,String b,ImageView c,String d) {
         return new Button(d,c) {
             public String path=a.getAbsolutePath();
             @Override
             public String toString() {
                st=path;
                return path;
                }
         };
     }
     
      public void walk( String path ) {
        e.clear();
        e.appendText(path);
        z.setHgap(30);
        z.setVgap(40);
        File root = new File( path );
        st=path;
        String b=null;
        File[] list = root.listFiles(); 
        if (path=="ThisPC") {
             list=root.listRoots();
        }
         else {
             list = root.listFiles();
         }
        
        if (list == null) return;
        for ( File f : list ) {
            IconAdapter a=new IconAdapter(f);
            if (path=="ThisPC") {b=f.getAbsolutePath();}
            else {b=f.getName();}
                Button bt = filebutton(f,f.getName(),a.Makeicon(),b);
            z.getChildren().add(bt);
            //System.out.println(f.getAbsolutePath());
            bt.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if(event.getClickCount()==2){
                        System.out.println(bt.toString());
                        NewTilepane(bt.toString());
                        
                        }
                    }
                });
            
        }
      }
      void NewTilepane(String s) {
        e.clear();
        z.getChildren().clear();
        e.appendText(s);
        z.setHgap(20);
        z.setVgap(30);
        File[] list;
        File root = new File(s);
        list = root.listFiles();
        if (list == null) return;
        for ( File f : list ) {
            IconAdapter a=new IconAdapter(f);
            Button bt = filebutton(f,f.getName(),a.Makeicon(),f.getName());
            z.getChildren().add(bt);
              bt.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if(event.getClickCount()==2){
                        //System.out.println(bt.toString());
                        NewTilepane(bt.toString());
                        }
                    }
                });
        }
      }
       @Override
      public void dostuff() {
            walk(st);
      }  
            
}
           // tp.setTileAlignment(Pos.TOP_LEFT);