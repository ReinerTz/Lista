/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilaLista;

import FilaVetor.Fila;
import FilaVetor.FilaVaziaException;
import ListaEncadeada.ListaEncadeada;

/**
 *
 * @author lucasreinert
 */
public class FilaLista<T> implements Fila<T> {
    ListaEncadeada lista;
    
    
    @Override
    public void inserir(T valor) {
//        lista.inserirNoFinal(valor);;
    }

    @Override
    public T retirar() {
        if (estaVazia())
            throw new FilaVaziaException();
        
        T valor;
        valor = (T) lista.getPrimeiro().getInfo();
        return valor;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }
        return (T) lista.getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        try{
            while(true)
                retirar();
        }catch(FilaVaziaException l){
            
        }
    }
    
}
