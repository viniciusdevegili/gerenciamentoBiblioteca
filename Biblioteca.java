import java.util.ArrayList;

// cria a classe Biblioteca

public class Biblioteca {
    public String nome;
    public ArrayList<Livro> livros;

    // cria a arraylist para a biblioteca

    public static ArrayList<Biblioteca> bibliotecas = new ArrayList<>();

    // cria o construtor para a biblioteca

    public Biblioteca(String nome) {
        this.nome = nome;
        this.livros = new ArrayList<>();

        bibliotecas.add(this); // adicionar as bibliotecas
    }

    // cria o toString para a biblioteca

    public String toString() {
        return "Nome: " + this.nome;
    }

    // cria o metodo para adicionar o livro

    public void adicionarLivro(Livro livro) {
        this.livros.add(livro);
    }

    // cria o metodo para listar os livros

    public void listarLivros() {
        for (int i = 0; i < this.livros.size(); i++) {
            System.out.println(i + " - " + this.livros.get(i).toString());
        }
    }

    // cria o metodo para listar as bibliotecas

    public static void listarBibliotecas() {
        for (int i = 0; i < bibliotecas.size(); i++) {
            Biblioteca biblioteca = bibliotecas.get(i);
            System.out.println(i + " - " + biblioteca.toString());
            biblioteca.listarLivros();
        }
    }
}
