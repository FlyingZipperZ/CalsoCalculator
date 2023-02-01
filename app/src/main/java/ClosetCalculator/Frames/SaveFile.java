package ClosetCalculator.Frames;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
public class SaveFile {
    public static String createSavePopUp(){
        JFrame parentFrame = new JFrame();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");

        int userSelection = fileChooser.showSaveDialog(parentFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
            return fileToSave.getAbsolutePath();
        } else {
            return "";
        }
    }
}