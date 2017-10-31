/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaEncadeada;

/**
 *
 * @author lucasreinert
 */
public class ListaEncadeada<ClasseParametrizada> {

    private NoLista primeiro;
    private NoLista ultimo;

    public ListaEncadeada() {
        primeiro = null;
        ultimo = null;
    }

    public NoLista<ClasseParametrizada> getPrimeiro() {
        return primeiro;
    }

    public void inserir(ClasseParametrizada info) {
        NoLista novo = new NoLista();
        novo.setInfo(info);
        novo.setProximo(primeiro);
        primeiro = novo;
    }

    public void exibir() {
        NoLista p = primeiro;

        while (p != null) {
            System.out.println(p.getInfo());
            p = p.getProximo();
        }
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public NoLista<ClasseParametrizada> buscar(ClasseParametrizada info) {
        NoLista p = primeiro;
        while (p != null) {
            if (p.getInfo().equals(info)) {
                return p;
            }
            p.getProximo();
        }
        return null;
    }

    public void retirar(ClasseParametrizada info) {
        NoLista<ClasseParametrizada> anterior = null;
        NoLista<ClasseParametrizada> p = primeiro;

        while ((p != null) && (!p.getInfo().equals(info))) {
            anterior = p;
            p = p.getProximo();
        }

        if (p != null) {
            if (anterior == null) {
                this.primeiro = p.getProximo();
            } else {
                anterior.setProximo(p.getProximo());
            }
        }
    }

    public int obterComprimento() {
        int qtdeNos = 0;

        NoLista<ClasseParametrizada> p = primeiro;

        while (p != null) {
            qtdeNos++;
            p = p.getProximo();
        }

        return qtdeNos;
    }

    public NoLista<ClasseParametrizada> obterNo(int idx) {
        if (idx < 0) {
            throw new IndexOutOfBoundsException();
        }

        NoLista<ClasseParametrizada> p = getPrimeiro();
        for (int i = 0; (p != null) && (i < idx); i++) {
            p = p.getProximo();
        }

        if (p == null) {
            throw new IndexOutOfBoundsException();
        }

        return p;
    }

//            NoLista novo = new NoLista();
//        novo.setInfo(info);
//        novo.setProximo(primeiro);
//        primeiro = novo;
    public void incluir(int index, ClasseParametrizada valor) {
//        NoLista<ClasseParametrizada> anterior = null;
//        NoLista<ClasseParametrizada> p = primeiro;
//        NoLista novo = new NoLista();
//        NoLista aux = new NoLista();    
//        for (int i = 0; i < index; i++) {
//            if (p != null) {
//                anterior = p;
//                p = p.getProximo();
//            } else {
//                break;
//            }
//        }
//        
//        novo.setInfo(valor);
//        novo.setProximo(p.getProximo());
//        p.setProximo(novo);
//        aux = p;
//        p.setProximo(novo);
//        p.getProximo();
//        p.setProximo(aux);
//        primeiro = anterior;
        NoLista<ClasseParametrizada> anterior = null;
        NoLista<ClasseParametrizada> p = primeiro;

        int posicao = 1;

        while ((p != null) && (index >= posicao)) {
            anterior = p;
            p = p.getProximo();
            posicao++;
        }

        NoLista<ClasseParametrizada> novo = new NoLista<>();
        novo.setInfo(valor);

        if (anterior == null) {
            novo.setProximo(primeiro);
            primeiro = novo;
        } else {
            novo.setProximo(anterior.getProximo());
//            primeiro = novo;
        }

    }
    // o de retirar é pra fazer com recursividade.

    public void retirarTodos(ClasseParametrizada valor) {
        NoLista<ClasseParametrizada> anterior = null;
        NoLista<ClasseParametrizada> p = primeiro;

        while (p != null) {
            if (!p.getInfo().equals(valor)) {
                if (anterior == null) {
                    this.primeiro = p.getProximo();
                } else {
                    anterior.setProximo(p.getProximo());
                }
            } else {
                anterior = p;
            }
            p = p.getProximo();
        }
    }

    public void inserirNoFinal(ClasseParametrizada info) {
        NoLista obj;
        obj = new NoLista();
        obj.setInfo(info);
        if (ultimo != null) {
            ultimo.setProximo(obj);
        } else {
            primeiro = obj;
        }
        ultimo = obj;

    }
}
