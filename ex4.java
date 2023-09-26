public class ex4 {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(60);
        arvore.inserir(80);

        System.out.println("Árvore original em ordem:");
        arvore.emOrdem();

        arvore.removerMenorElemento();

        System.out.println("\nÁrvore após remover o menor elemento em ordem:");
        arvore.emOrdem();
    }
}