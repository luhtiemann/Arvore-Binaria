public class ex5 {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(70);
        arvore.inserir(60);
        arvore.inserir(80);

        System.out.println("Árvore em ordem:");
        arvore.emOrdem();

        int valorParaRemover = 30;
        arvore.remover(valorParaRemover);

        System.out.println("\nÁrvore após a remoção de " + valorParaRemover + ":");
        arvore.emOrdem();
    }
}
