/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import static filemanager.FILEFXMLController.st;
import java.io.File;
import java.text.SimpleDateFormat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author hp
 */
public class Tableview extends ParentFXML{
      TableView tv;
      TextField tf;
      Tableview(TableView a,TextField f) {
          this.tv=a;
          this.tf=f;
      }
      public void MakeTable(String ad) {
            File r = new File(ad);
            File[] list ;
            if (ad=="ThisPC") {
                list = r.listRoots();
            }
        else {
                list = r.listFiles();
        }
        tv.setEditable(true);
        tv.getColumns().clear();        
        
        TableColumn img = new TableColumn<>("Icon");
        img.setCellValueFactory(new PropertyValueFactory<>("icon"));
        tv.getColumns().add(img);
        
        TableColumn Name = new TableColumn<>("Name"); 
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tv.getColumns().add(Name);
        
        TableColumn Date = new TableColumn<>("Date"); 
        Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
        tv.getColumns().add(Date);
        TableColumn Size = new TableColumn<>("Size"); 
        Size.setCellValueFactory(new PropertyValueFactory<>("Size"));
        tv.getColumns().add(Size);
         
         ObservableList<Fileinfo> list1=FXCollections.observableArrayList ();
        //    MakeTable(list1,"F://");
      //  n.setCellValueFactory(new PropertyValueFactory<>("Name"));
      //  d.setCellValueFactory(new PropertyValueFactory<>("Date"));
     //   s.setCellValueFactory(new PropertyValueFactory<>("Size"));
            tv.setItems(list1);
               // System.out.println(f.GetSize());
               // System.out.println(f.GetDate());
        tf.appendText(ad);
        SimpleDateFormat s = new SimpleDateFormat("yyyy,MMM d");
        if (list == null) return;
        for ( File f : list ) {
            Fileinfo ob;
            IconAdapter ada=new IconAdapter(f);
            String t=f.getAbsolutePath();
            if (ad=="ThisPC") {
                ob = new Fileinfo(f,ada.Makeicon(),f.getAbsolutePath(),String.valueOf(s.format(f.lastModified())),String.valueOf(f.length()));
            }
            else {
                 ob= new Fileinfo(f,ada.Makeicon(),f.getName(),String.valueOf(s.format(f.lastModified())),String.valueOf(f.length()));
            }
            list1.add(ob);
                }
            }
        
        void mouseon(File f) {
            //System.out.println(f.getAbsolutePath());
            tf.clear();
            //st=f.getAbsolutePath();
            tf.appendText(f.getAbsolutePath());
            SimpleDateFormat s = new SimpleDateFormat("yyyy,MMM d");
            tv.getItems().clear();
            ObservableList<Fileinfo> list2=FXCollections.observableArrayList ();
            
            tv.getColumns().clear();        
            TableColumn img = new TableColumn<>("Icon");
            img.setCellValueFactory(new PropertyValueFactory<>("icon"));
            tv.getColumns().add(img);
        
        TableColumn Name = new TableColumn<>("Name"); 
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tv.getColumns().add(Name);
        
        TableColumn Date = new TableColumn<>("Date"); 
        Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
        tv.getColumns().add(Date);
        
        TableColumn Size = new TableColumn<>("Size"); 
        Size.setCellValueFactory(new PropertyValueFactory<>("Size"));
        tv.getColumns().add(Size);
            tv.setItems(list2);
        File[] myfile=f.listFiles();
            tv.refresh();
            if(!f.isFile()) {
            for (File q:myfile) {
                IconAdapter ada=new IconAdapter(q);
                Fileinfo ob = new Fileinfo(q,ada.Makeicon(),q.getName(),String.valueOf(s.format(q.lastModified())),String.valueOf(q.length()));
                list2.add(ob);
                initiatemouse();
                }
            }
            
        }
        void initiatemouse() {
            tv.setRowFactory( tv -> {
                TableRow<Fileinfo> row = new TableRow<>();
                row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    String d = row.getItem().getName();
                    File a=row.getItem().getFile();
                    st=a.getAbsolutePath();
                    //System.out.println(s);
                    // MakeTable(list1,"");
                     mouseon(a);
                }
            });
            return row ;
            });
        }
      @Override
      public void dostuff() {
            MakeTable(st);
            initiatemouse();
            }    
}
