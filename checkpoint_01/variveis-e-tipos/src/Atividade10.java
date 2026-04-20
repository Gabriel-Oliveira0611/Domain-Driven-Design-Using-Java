public class Atividade10 {
    static void main(String[] args) {
        String titulo = "O pequeno principe";
        String autor = "Antoine de Saint-Exupéry";
        int paginas = 96;
        double preco = 39.90;
        char categoria = 'T';

        String categoriaDescricao;

        if (categoria == 'F') {
            categoriaDescricao = "Ficção";
        } else if (categoria == 'N') {
            categoriaDescricao = "Não-ficção";
        } else if (categoria == 'T') {
            categoriaDescricao = "Tecnologia";
        } else if (categoria == 'H') {
            categoriaDescricao = "História";
        } else {
            categoriaDescricao = "Categori Inválida";
        }

        System.out.println(
                "\n -> Livro cadastrado: " + titulo
                +"\n -> Autor: " + autor
                +"\n -> Páginas: " + paginas
                +"\n -> Custo: R$" + preco
                +"\n -> Categoria: " + categoriaDescricao
        );
    }
}
