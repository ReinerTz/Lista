/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import ListaEstatica.ListaEstatica;
import PilhaLista.PilhaLista;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas_Reinert e Andrey L. Bauler
 */
public class Validador {

    private ListaEstatica<String> tags;
    private PilhaLista<String> pilha;
    private File file;

    public Validador(File file) {
        this.file = file;
        this.tags = new ListaEstatica<>();
        this.pilha = new PilhaLista<>();

        //Inserção manual de todas as tags que fecham na mesma linha
        tags.inserir("META");
        tags.inserir("BASE");
        tags.inserir("BR");
        tags.inserir("COL");
        tags.inserir("COMMAND");
        tags.inserir("HR");
        tags.inserir("IMG");
        tags.inserir("INPUT");
        tags.inserir("LINK");
        tags.inserir("PARAM");
        tags.inserir("SOURCE");
        tags.inserir("!DOCTYPE");
    }

    private boolean EhArqHtml() {
        return file.getName().toUpperCase().contains(".HTML");
    }

    public void validar() throws IOException {
        // O arquivo deve possuir extenção .HTML, para que possa ser validado
        if (!EhArqHtml()) {
            System.out.println("Por favor, selecione um arquivo com extensão '.HTML'.");
            return;
        }
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            verificarArquivo(br);

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo não encotrado!", "Erro", 0);
        }

    }

    public void verificarArquivo(BufferedReader br) throws IOException {
        String readArq;
        String palavra;
        boolean finalTag;
        char caractere;
        boolean estaNaTag = false;
        boolean ehFimTag = false;
        boolean ehTagSingleton = false;
        readArq = br.readLine();
        String salvapalavra = "";
        palavra = "";
        String peek;
        peek = "";

        //Percorre todo o arquivo.
        while (readArq != null) {
            for (int i = 0; i < readArq.length(); i++) {
                caractere = readArq.charAt(i);

                if ((estaNaTag) && (!ehTagSingleton)) {
                    switch (caractere) {
                        case '>':
                            if (ehFimTag) {
                                if (!pilha.estaVazia()) {
                                    peek = pilha.peek();
                                }
                                if (!pilha.pop().equals(palavra)) {
                                    JOptionPane.showMessageDialog(null, "Faltou fechar uma tag.\nTag esperada " + peek + " tag encontrada " + palavra);
                                    return;
                                }
                            } else {
                                if (!ehTagSingleton) {
                                    pilha.push(palavra);
                                }
                            }
                            estaNaTag = false;
                            ehFimTag = false;
                            palavra = "";
                            salvapalavra = "";
                            break;
                        case '/':
                            if (readArq.charAt(i + 1) != '>') {
                                ehFimTag = true;
                            }
                            break;
                        case ' ':
                            if ((estaNaTag) && (!ehTagSingleton)) {
                                estaNaTag = false;
                                ehFimTag = false;
                                pilha.push(palavra);
                                salvapalavra = palavra;
                                palavra = "";
                            }
                            break;

                        default:
                            palavra += caractere;

                            if (tags.buscar(palavra.toUpperCase()) > -1) {
                                ehTagSingleton = true;
                                estaNaTag = false;
                                ehFimTag = false;
                                palavra = "";
                                salvapalavra = "";
                            }
                            break;
                    }
                }

                //Encontrou o início da tag, ou está no meio da tag
                //OBS: Isso deve vir depois do switch, pois eu não vou copiar o caractere '<', e é aqui q eu valido se esta na tag, ou não.
                if (!ehTagSingleton) {
                    if ((readArq.charAt(i) == '/') && (readArq.charAt(i + 1) == '>') && (!estaNaTag)) {
                        estaNaTag = true;
                        ehFimTag = true;
                        palavra = salvapalavra;
                        salvapalavra = "";
                    } else if ((caractere == '<')) {
                        if (estaNaTag) {
                            JOptionPane.showMessageDialog(null, "Você não fechou a tag " + pilha.peek());
                            return;
                        }
                        estaNaTag = true;
                        ehFimTag = false;
                    }
                }
            }
            ehTagSingleton = false;
            readArq = br.readLine();
        }

        if (pilha.estaVazia()) {
            JOptionPane.showMessageDialog(null, "Arquivo validado com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Faltou fechar a(s) tag(s): " + pilha.toString());
        }

    }
}
