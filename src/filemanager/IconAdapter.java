/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.awt.image.BufferedImage;
import java.io.File;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author hp
 */
public class IconAdapter {
    private File file;
    IconAdapter(File a) {
        this.file=a;
        
    }
    
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    ImageView Makeicon() {
        ImageIcon icon = (ImageIcon) FileSystemView.getFileSystemView().getSystemIcon(file);
        BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        icon.paintIcon(null, bufferedImage.getGraphics(), 0, 0);
        Image fxImage = SwingFXUtils.toFXImage(bufferedImage, null);
        ImageView ic = new ImageView(fxImage);
        return ic;
    }
    
}
