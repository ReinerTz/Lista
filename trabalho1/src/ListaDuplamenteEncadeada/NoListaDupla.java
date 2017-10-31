/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDuplamenteEncadeada;

/**
 *
 * @author lucasreinert
 */
public class NoListaDupla<ClasseParametrizada> {
    private NoListaDupla anterior;
    private NoListaDupla proximo;
    private ClasseParametrizada info;
    
    public NoListaDupla getAnterior() {
        return anterior;
    }

    public void setAnterior(NoListaDupla anterior) {
        this.anterior = anterior;
    }

    public NoListaDupla getProximo() {
        return proximo;
    }

    public void setProximo(NoListaDupla proximo) {
        this.proximo = proximo;
    }

    public ClasseParametrizada getInfo() {
        return info;
    }

    public void setInfo(ClasseParametrizada info) {
        this.info = info;
    }

    
    
    
}
