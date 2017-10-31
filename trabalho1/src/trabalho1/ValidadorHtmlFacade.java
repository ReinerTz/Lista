/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Lucas_Reinert
 */
public class ValidadorHtmlFacade {
    public void processarArquivo(File arquivo) throws IOException{
        Validador valida = new Validador(arquivo);
        valida.validar();
        
    }
}
