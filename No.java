// Definição da classe No, que representa os nós da árvore binária.
class No {
    int valor;           // O valor armazenado no nó.
    No esquerda;         // Referência para o nó filho esquerdo.
    No direita;          // Referência para o nó filho direito.

    public No(int valor) {
        this.valor = valor;
        esquerda = null;  // Inicializa a referência esquerda como nula.
        direita = null;   // Inicializa a referência direita como nula.
    }
}