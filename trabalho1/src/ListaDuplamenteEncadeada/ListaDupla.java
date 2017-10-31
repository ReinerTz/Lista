/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDuplamenteEncadeada;

import ListaEncadeada.NoLista;

/**
 *
 * @author lucasreinert
 */
public class ListaDupla<ClasseParametrizada> {

    private NoListaDupla primeiro;

    public ListaDupla() {
        primeiro = null;
    }

    public NoListaDupla getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(NoListaDupla primeiro) {
        this.primeiro = primeiro;
    }

    public void inserir(ClasseParametrizada info) {
        NoListaDupla<ClasseParametrizada> novo = new NoListaDupla<>();
        novo.setInfo(info);
        novo.setProximo(primeiro);
        novo.setAnterior(null);

        if (primeiro != null) {
            primeiro.setAnterior(novo);
        }
        primeiro = novo;

    }

    public void exibir() {
        NoListaDupla p = primeiro;

        while (p != null) {
            System.out.println(p.getInfo());
            p = p.getProximo();
        }
    }

    public NoListaDupla<ClasseParametrizada> buscar(ClasseParametrizada valor) {
        NoListaDupla p = primeiro;
        while (p != null) {
            if (p.getInfo().equals(valor)) {
                return p;
            }
            p.getProximo();
        }
        return null;
    }

    public void retirar(ClasseParametrizada valor) {
        NoListaDupla<ClasseParametrizada> p = buscar(valor);

        if (p != null) {
            if (primeiro == p) {
                primeiro = p.getProximo();
            } else {
                p.getAnterior().setProximo(p.getProximo());
            }

            if (p.getProximo() != null) {
                p.getProximo().setAnterior(p.getAnterior());
            }
        }
    }

    public NoListaDupla<ClasseParametrizada> obterUltimo() {
        NoListaDupla<ClasseParametrizada> ultimo = new NoListaDupla<>();
        NoListaDupla<ClasseParametrizada> p = primeiro;
        while (p != null) {
            ultimo = p;
            p = p.getProximo();
        }

        return ultimo;
    }

    public void exibirOrdemInversa() {
//        NoListaDupla ultimo = primeiro;
//        while (ultimo.getInfo() != null ) {
//            ultimo = ultimo.getProximo();
//        }
//        
//        while (ultimo.getInfo() != null) {
//            System.out.println(ultimo.getInfo());
//            ultimo = ultimo.getAnterior();
//        }
        NoListaDupla<ClasseParametrizada> p = obterUltimo();

        while (p != null) {
            System.out.println(p.getInfo());
            p = p.getAnterior();
        }

    }

    public void liberar() {
        NoListaDupla<ClasseParametrizada> p = primeiro;
        NoListaDupla<ClasseParametrizada> bkp;

        while (p != null) {
            bkp = p.getProximo();

            p.setProximo(null);
            p.setAnterior(null);

            p = bkp;
        }

        primeiro = null;
    }

    @Override
    public String toString() {
        String resultado = "";
        NoListaDupla<ClasseParametrizada> p = primeiro;
        while (p != null) {
            if (p != primeiro) {
                resultado += ",";
            }

            resultado += p.getInfo();
            p = p.getProximo();

        }
        return resultado;
    }
}
