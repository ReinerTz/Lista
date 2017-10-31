/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaEstatica;

import java.util.AbstractList;

/**
 *
 * @author lucasreinert
 */
public class ListaEstatica<ClasseParametrizada> {

    private int tamanho;
    private ClasseParametrizada[] info;

    public ListaEstatica() {
        info =  (ClasseParametrizada[]) new Object[10];
        tamanho = 0;
    }

    public void inserir(ClasseParametrizada valor) {
        if (tamanho == info.length) {
            redimensionar();
        }
        info[tamanho] = valor;
        tamanho += 1;
    }

    private void redimensionar() {
        ClasseParametrizada[] novo;
        novo = (ClasseParametrizada[])new Object[tamanho + 10];
        System.arraycopy(info, 0, novo, 0, tamanho);
        info = (ClasseParametrizada[]) novo;
    }

    public void exibir() {
        for (int i = 0; i < tamanho - 1; i++) {
            System.out.println(info[i]);
        }
    }

    public int buscar(ClasseParametrizada valor) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(ClasseParametrizada valor) {
        int j = buscar(valor);

        if (j > -1) {
            for (int i = j; i < tamanho - 1; i++) {
                info[i] = info[i + 1];
            }
            tamanho--;
        }
    }

    public void liberar() {
        info = (ClasseParametrizada[]) new Object[10];
        tamanho = 0;
    }

    public ClasseParametrizada obterElemento(int posicao) {
        if (posicao <= tamanho) {
            return info[posicao];
        } else {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        String concatenada = "";
        for (int i = 0; i < tamanho; i++) {
            if (i != tamanho - 1) {
                concatenada += info[i] + ",";
            } else {
                concatenada += info[i];
            }
        }
        return concatenada;
    }
    
    public void inverter(){
// Ordem de complexidade quadratica.
//        ClasseParametrizada x;;
//        for (int i = 0 ; i < tamanho ;i++){
//            for (int j = 0; j< tamanho-(i+1);j++){
//                x = info[j];
//                info[j] = info[j+1];
//                info[j+1] = x;
//            }
//        }

// O ALGORITMO NÃO PODE CRIAR NOVOS VETORES
//        ClasseParametrizada[] novo;
//        int x = 0;
//        novo = (ClasseParametrizada[])new Object[info.length];
//        for (int i = tamanho-1; i >= 0; i--) {
//            novo[x] = info[i];
//            x++;
//        }
//        info = (ClasseParametrizada[]) novo;

// Ordem de complexidade linear.
    ClasseParametrizada x; 
    for (int i = 0; i < tamanho/2; i++) {
        x = info[i];
        info[i] = info[tamanho-i-1];
        info[tamanho-i-1] = x;
    }
    }

}
