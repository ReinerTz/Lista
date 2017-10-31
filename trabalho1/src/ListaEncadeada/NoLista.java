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
public class NoLista<ClasseParametrizada> {
     private ClasseParametrizada info;
     private NoLista proximo;

    public ClasseParametrizada getInfo() {
        return info;
    }

    public void setInfo(ClasseParametrizada info) {
        this.info = info;
    }

    public NoLista<ClasseParametrizada> getProximo() {
        return proximo;
    }

    public void setProximo(NoLista<ClasseParametrizada> proximo) {
        this.proximo = proximo;
    }

    
    
    
     
}
