public class ex2 {
    public static void main(String[] args) {

        ArvoreBinaria arvore = new ArvoreBinaria();
        arvore.raiz = new No(1);
        arvore.raiz.esquerda = new No(2);
        arvore.raiz.direita = new No(3);
        arvore.raiz.esquerda.esquerda = new No(4);
        arvore.raiz.esquerda.direita = new No(5);

        System.out.println("Percorrendo em pré-ordem:");
        arvore.percorrerPreOrdem();

        System.out.println("\nPercorrendo em in-ordem:");
        arvore.percorrerInOrdem();

        System.out.println("\nPercorrendo em pós-ordem:");
        arvore.percorrerPosOrdem();
    }
}
