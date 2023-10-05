import java.util.ArrayList;

// cria a classe do livro

public class Livro {
    public String titulo;
    public Autor autor;
    public boolean disponivel;

    // cria a arraylist para o livro

    public static ArrayList<Livro> livros = new ArrayList<Livro>();

    // cria o construtor para o livro

    public Livro(String titulo, Autor autor, boolean disponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = disponivel;

        livros.add(this); // adicionar os livros
    }

    // cria o toString para o livro

    public String toString() {
        return "Titulo: " + this.titulo
                + "Autor: " + this.autor.nome
                + "Disponivel: " + (this.disponivel ? "Sim" : "Não");
    }

    // cria o metodo para listar os livros

    public static void listarLivros() {
        for (int i = 0; i < livros.size(); i++) {
            System.out.println(i + " - " + livros.get(i).toString());
        }
    }

    // cria o metodo para emprestar o livro

    public void emprestar() throws Exception {
        if (!this.disponivel) {
            throw new Exception("Livro não está disponível");
        }
        this.disponivel = false;
    }

    // cria o metodo para devolver o livro

    public void devolver() throws Exception {
        if (this.disponivel) {
            throw new Exception("Livro ja esta disponivel");
        }
        this.disponivel = true;
    }

}
