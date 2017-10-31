/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilaVetor;

/**
 *
 * @author lucasreinert
 */
public class FilaCheiaException extends RuntimeException {

    public FilaCheiaException() {
        super("Fila está cheia");
    }
    
    
}
