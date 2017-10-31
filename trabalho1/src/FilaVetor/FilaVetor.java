/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilaVetor;

import ListaEncadeada.NoLista;

/**
 *
 * @author lucasreinert
 */
public class FilaVetor<T> implements Fila<T> {

    private T[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor(int limite) {
        this.tamanho = 0;
        this.limite = limite;
        info = (T[]) new Object[limite];
        this.inicio = 0;
    }

    @Override
    public void inserir(T valor) {
        if (tamanho == limite) {
            throw new FilaCheiaException();
        }
        int fim;
        fim = (inicio + tamanho) % limite;
        info[fim] = valor;
        tamanho += 1;
    }

    @Override
    public T retirar() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }
        T valor;
        valor = info[inicio];
        inicio = (inicio + 1) % limite;
        tamanho -= 1;
        return valor;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }
        return info[inicio];
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public void liberar() {
        info = (T[]) new Object[limite];
        this.tamanho = 0;
    }

    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
        FilaVetor<T> novo;
        novo = new FilaVetor<T>(f2.limite + this.limite);
//        for (int i = 0; i < tamanho; i++) {
//            nova.inserir(peek());
//            retirar();
//        }
//        for (int i = 0; i < f2.tamanho; i++) {
//            nova.inserir(f2.peek());
//            f2.retirar();
//        }
//        
//        return nova;
        int indice;
        for (int i = 0; i < this.tamanho; i++) {
            indice = (this.inicio + i) % this.limite;
            novo.inserir(this.info[indice]);
        }
        
        for (int i = 0; i < f2.tamanho; i++){
            indice = (f2.inicio + i) % f2.limite;
            novo.inserir(f2.info[indice]);
        }
        return novo;
    }

    @Override
    public String toString() {
        String retorno = "";
        int indice;
        for (int i = tamanho - 1; i >= 0; i--) {
            indice = (i + inicio) % limite;
            if (i > 0) {
                retorno = retorno + ",";
            }
            retorno += info[indice];

        }
        return retorno;
    }
    
    

    public int getLimite() {
        return this.limite;
    }

}
