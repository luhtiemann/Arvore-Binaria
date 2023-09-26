/*
1. Escreva um algoritmo para inserir um elemento em uma árvore binária de busca.
2. Escreva algoritmos para percorrer uma árvore binária nas formas préordem, inordem e
pósordem.
3. Escreva um algoritmo para remover o maior elemento de uma árvore binária de busca.
4. Escreva um algoritmo para remover o menor elemento de uma árvore binária de busca.
5. Considere que uma árvore binária de busca não possui elementos repetidos. Escreva um
algoritmo que remova um determinado elemento com valor N da árvore.
*/

import java.util.Scanner;

// Definição da classe ArvoreBinaria, que contém a árvore binária e métodos relacionados.
class ArvoreBinaria {
    No raiz;  // A raiz da árvore binária.

    public ArvoreBinaria() {
        raiz = null;  // Inicializa a raiz como nula (árvore vazia).
    }

    // Método para inserir um valor na árvore binária de busca.
    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    // Método auxiliar para inserir um valor na árvore de forma recursiva.
    private No inserirRec(No raiz, int valor) {
        if (raiz == null) {      // Se a raiz for nula, cria um novo nó com o valor.
            raiz = new No(valor);
            return raiz;
        }

        if (valor < raiz.valor) {        // Se o valor for menor que o valor da raiz.
            raiz.esquerda = inserirRec(raiz.esquerda, valor);  // Insere à esquerda.
        } else if (valor > raiz.valor) { // Se o valor for maior que o valor da raiz.
            raiz.direita = inserirRec(raiz.direita, valor);    // Insere à direita.
        }

        return raiz;
    }

    // Método que permite ao usuário inserir valores na árvore interativamente.
    public void inserirComEntradaUsuario() {
        Scanner scanner = new Scanner(System.in);  // Cria um objeto Scanner para entrada do usuário.
        System.out.print("Digite um valor para inserir na árvore (ou -1 para sair): ");

        while (true) {  // Loop infinito para ler valores até que -1 seja inserido.
            int valor = scanner.nextInt();  // Lê o valor inserido pelo usuário.
            if (valor == -1) {
                break;  // Se o usuário inserir -1, sai do loop.
            }

            inserir(valor);  // Chama o método inserir para adicionar o valor à árvore.
            System.out.print("Digite outro valor (ou -1 para sair): ");
        }

        scanner.close();  // Fecha o Scanner após a entrada do usuário ser concluída.
    }

    // Método para percorrer a árvore em pré-ordem
    public void preOrdem(No no) {
        if (no != null) {
            System.out.print(no.valor + " "); // Visita o nó
            preOrdem(no.esquerda); // Percorre a subárvore esquerda
            preOrdem(no.direita);  // Percorre a subárvore direita
        }
    }

    // Método para percorrer a árvore em in-ordem
    public void inOrdem(No no) {
        if (no != null) {
            inOrdem(no.esquerda); // Percorre a subárvore esquerda
            System.out.print(no.valor + " "); // Visita o nó
            inOrdem(no.direita);  // Percorre a subárvore direita
        }
    }

    // Método para percorrer a árvore em pós-ordem
    public void posOrdem(No no) {
        if (no != null) {
            posOrdem(no.esquerda); // Percorre a subárvore esquerda
            posOrdem(no.direita);  // Percorre a subárvore direita
            System.out.print(no.valor + " "); // Visita o nó
        }
    }

    // Método público para iniciar o percurso em pré-ordem
    public void percorrerPreOrdem() {
        preOrdem(raiz);
    }

    // Método público para iniciar o percurso em in-ordem
    public void percorrerInOrdem() {
        inOrdem(raiz);
    }

    // Método público para iniciar o percurso em pós-ordem
    public void percorrerPosOrdem() {
        posOrdem(raiz);
    }

    // Método para encontrar e remover o maior elemento da árvore
    public void removerMaiorElemento() {
        raiz = removerMaiorElementoRecursivamente(raiz);
    }

    private No removerMaiorElementoRecursivamente(No no) {
        if (no == null) {
            return null;
        }

        // Se o nó atual tiver um nó à direita, continuamos descendo pela direita
        if (no.direita != null) {
            no.direita = removerMaiorElementoRecursivamente(no.direita);
            return no;
        }

        // Se o nó atual não tiver um nó à direita, ele é o maior nó
        // Removemos este nó, e o novo nó à direita (subárvore à direita) será
        // o novo nó que ligará ao pai do nó atual.
        return no.esquerda;
    }

    public void removerMenorElemento() {
        raiz = removerMenorElementoRec(raiz);
    }

    private No removerMenorElementoRec(No raiz) {
        if (raiz == null) {
            return raiz;
        }

        if (raiz.esquerda == null) {
            return raiz.direita;
        }

        raiz.esquerda = removerMenorElementoRec(raiz.esquerda);

        return raiz;
    }

    public void emOrdem() {
        emOrdemRec(raiz);
    }

    private void emOrdemRec(No raiz) {
        if (raiz != null) {
            emOrdemRec(raiz.esquerda);
            System.out.print(raiz.valor + " ");
            emOrdemRec(raiz.direita);
        }
    }

    // Método público para remover um elemento da árvore
    public void remover(int valor) {
        raiz = removerRec(raiz, valor);
    }

    // Função recursiva para remover um elemento da árvore
    private No removerRec(No raiz, int valor) {
        // Caso base: se a árvore está vazia ou o valor está na raiz
        if (raiz == null)
            return raiz;

        // Caso contrário, faça a recursão pela subárvore esquerda ou direita
        if (valor < raiz.valor)
            raiz.esquerda = removerRec(raiz.esquerda, valor);
        else if (valor > raiz.valor)
            raiz.direita = removerRec(raiz.direita, valor);
        else {
            // Nodo com apenas um filho ou nenhum filho
            if (raiz.esquerda == null)
                return raiz.direita;
            else if (raiz.direita == null)
                return raiz.esquerda;

            // Nodo com dois filhos: pegue o menor valor na subárvore da direita
            raiz.valor = valorMinimo(raiz.direita);

            // Remova o menor valor
            raiz.direita = removerRec(raiz.direita, raiz.valor);
        }

        return raiz;
    }

    // Função auxiliar para encontrar o menor valor em uma subárvore
    private int valorMinimo(No raiz) {
        int minValor = raiz.valor;
        while (raiz.esquerda != null) {
            minValor = raiz.esquerda.valor;
            raiz = raiz.esquerda;
        }
        return minValor;
    }


}
