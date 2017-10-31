/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;

/**
 *
 * @author Lucas_Reinert
 */
public class teste {
    public static void main(String[] args) throws IOException {
        JButton bt = new JButton();
        JFileChooser fc = new JFileChooser();
        ValidadorHtmlFacade html = new ValidadorHtmlFacade();

        fc.setCurrentDirectory(new File (""));
        fc.setDialogTitle("Selecione um Arquivo");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if (fc.showOpenDialog(bt) == JFileChooser.APPROVE_OPTION)
            html.processarArquivo(fc.getSelectedFile());
    }
}
