/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PilhaLista;

import ListaEncadeada.ListaEncadeada;
import ListaEncadeada.NoLista;
import Pilha.Pilha;
import Pilha.PilhaVaziaException;

/**
 *
 * @author lucasreinert
 */
public class PilhaLista<T> implements Pilha<T> {

    private ListaEncadeada<T> lista = new ListaEncadeada<>();

    @Override

    public void push(T info) {
        lista.inserir(info);
    }

    @Override
    public T pop() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }

        T valor;
        valor = lista.getPrimeiro().getInfo();
        lista.retirar(valor);
        return valor;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }
        return lista.getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        while (!estaVazia()) {
            pop();
        }
    }

    @Override
    public String toString() {
        String resultado = "";

        NoLista<T> p = lista.getPrimeiro();
        while (p != null) {
            resultado = resultado + p.getInfo();
            if (p.getProximo() != null) {
                resultado = resultado + ",";
            }
            p = p.getProximo();
        }
        return resultado;
    }

}
