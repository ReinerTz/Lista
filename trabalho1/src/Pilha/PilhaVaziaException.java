/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pilha;

/**
 *
 * @author lucasreinert
 */
public class PilhaVaziaException extends RuntimeException {

    public PilhaVaziaException() {
        super("A pilha está vazia");
    }
    
    
}
