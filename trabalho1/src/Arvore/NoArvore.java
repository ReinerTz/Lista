package Arvore;

/**
 *
 * @author gmannrich
 */
public class NoArvore<T> {
    private T info;
    private NoArvore<T> primeiro;
    private NoArvore<T> proximo;
    
    public NoArvore(T info) {
        this.info = info;
        this.primeiro = null;
        this.proximo = null;
    }
    
    public void inserirFilho(NoArvore<T> sa) {
        sa.proximo = primeiro;
        primeiro = sa;
    }
    
    public NoArvore<T> getPrimeiro() {
        return primeiro;
    }
    
    public NoArvore<T> getProximo() {
        return proximo;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
    
    
}
