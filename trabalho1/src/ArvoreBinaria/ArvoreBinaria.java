/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArvoreBinaria;

/**
 *
 * @author lucasreinert
 */
public class ArvoreBinaria <T> {
    private NoArvoreBinaria<T> raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }
    
    public boolean estaVazia(){
        return raiz == null;
    }
    
    public boolean pertence(T info){
        return pertence(raiz, info);
    }
    
    public boolean pertence(NoArvoreBinaria<T> no, T info){
        if (no == null) {
            return false;
        }
        else{
            return (no.getInfo().equals(info)) ||
                    pertence(no.getEsquerda(),info) ||
                    pertence(no.getDireita(), info);
        }
    }

    private String arvorePre(NoArvoreBinaria<T> no){
        if (no == null){
            return "<>";
        } else{
            return "<" +no.getInfo() + arvorePre(no.getEsquerda()) + arvorePre(no.getDireita()) + ">";
        }
    }
    
    
    
}
