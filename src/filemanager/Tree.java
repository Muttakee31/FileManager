/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;

/**
 *
 * @author hp
 */
public class Tree {
       TreeView <String> t;
       Tree() {} 
       Tree(TreeView <String> t) {
           this.t=t;
       }
      
       public void Maketree(TreeItem<String> p,String ad) {
        File r = new File(ad);
        File[] list = r.listFiles();
        if (list == null) return;
        for ( File f : list ) {
            IconAdapter a=new IconAdapter(f);
            if (f.isDirectory()) {
                 String t=f.getAbsolutePath();
                // System.out.println("Dir:" + f+"\n");
                 TreeItem <String> n= new TreeItem<>(f.getName(),a.Makeicon());
                 p.getChildren().add(n);
                // Maketree(n,t);
            }
        }
    }
    
    public void createTree(ImageView ic) {
        ic.setFitWidth(20);
        ic.setFitHeight(20);
        TreeItem <String> root= new TreeItem<>("My Computer",ic);
        String array[]={"C:\\Users\\hp\\Desktop\\","C:\\Users\\hp\\Documents\\","C:\\Users\\hp\\Downloads\\",
            "C:\\Users\\hp\\Music\\","C:\\Users\\hp\\Pictures\\","C:\\Users\\hp\\Videos\\"};
        String ara[]={"Desktop","Documents","Downloads","Music","Pictures","Videos"};
        for (int i=0;i<6;i++) {
        File z=new File(array[i]);
        IconAdapter y=new IconAdapter(z);
        ImageView aa=y.Makeicon();
        TreeItem <String> n= new TreeItem<>(ara[i],aa);
        root.getChildren().add(n);
        Maketree(n,array[i]);
        }
        File[] list =File.listRoots();
        for (File f:list) {
            if (f.getAbsolutePath()=="C:\\"|| f.getAbsolutePath()=="H:\\") {
                continue;
            }
            File z=new File(f.getAbsolutePath());
            IconAdapter y=new IconAdapter(z);
            ImageView aa=y.Makeicon();
            TreeItem <String> n=new TreeItem<>(f.getAbsolutePath(),aa);
            root.getChildren().add(n);
            Maketree(n,f.getAbsolutePath());
            //System.out.println(f.getAbsolutePath());
        }
        t.setRoot(root);
      //  Maketree(n6,"F:\\");
     //   Maketree(n7,"H:\\");
        //Maketree(n4,"C:\\Users\\hp\\Pictures\\");
        }
}
