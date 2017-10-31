package Arvore;

/**
 *
 * @author gmannrich
 */
public class Arvore<T> {

    private NoArvore<T> raiz;

    public Arvore() {
        raiz = null;
    }

    public void SetRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    @Override
    public String toString() {
        if (raiz == null) {
            return "<>";
        } else {
            return obterRepresentacaoTextual(raiz);
        }
    }

    private String obterRepresentacaoTextual(NoArvore<T> no) {
        String resultado = "<";
        resultado += no.getInfo();

        NoArvore<T> p = no.getPrimeiro();

        while (p != null) {
            resultado += obterRepresentacaoTextual(p);
            p = p.getProximo();
        }

        resultado += ">";

        return resultado;
    }

    public boolean pertence(T info) {
        if (raiz == null) {
            return false;
        } else {
            return pertence(raiz, info);
        }

    }

    private boolean pertence(NoArvore<T> no, T info) {
        if (no.getInfo().equals(info)) {
            return true;
        } else {
            NoArvore<T> p = no.getPrimeiro();
            while (p != null) {
                if (pertence(p,info)) {
                    return true;
                }
                p = p.getProximo();
            }
            return false;
        }

    }

    public NoArvore<T> buscar(T info) {
        if (raiz == null) {
            return null;
        } else {
            return buscar(raiz, info);
        }
    }

    //FALTA FINALIZAR
    public NoArvore<T> buscar(NoArvore<T> no, T info) {
        if (no.getInfo().equals(info)) {
            return no;
        } else {
            NoArvore<T> noEncontrado;
            NoArvore<T> p = no.getPrimeiro();

            while (p != null) {
                noEncontrado = buscar(p, info);
                if (noEncontrado != null) {
                    return noEncontrado;
                }

                p = p.getProximo();
            }
        }

        return null;
    }
}
