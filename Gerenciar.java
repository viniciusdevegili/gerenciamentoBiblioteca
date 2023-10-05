import java.util.Scanner;

// cria a classe para o gerenciamento da biblioteca

public class Gerenciar {

    public static void main(String[] args) throws Exception {

        // cria o scanner

        Scanner sc = new Scanner(System.in);

        int op = 0;

        // cria o switch case para o menu

        do {
            System.out.println("Minha Biblioteca");
            System.out.println("0 - Sair");
            System.out.println("1 - Criar Autor");
            System.out.println("2 - Criar Livro");
            System.out.println("3 - Criar Biblioteca");
            System.out.println("4 - Adicionar livro");
            System.out.println("5 - Emprestar livro");
            System.out.println("6 - Devolver livro");

            try {
                op = sc.nextInt();
            } catch (Exception e) {
                op = 99;
            }
            switch (op) {
                case 0:
                    System.out.println("Saindo.....");
                    break;

                // cria o case para o autor

                case 1:
                    System.out.println("Digite o nome do autor: ");
                    String nome = sc.next(); // ler o nome do autor
                    new Autor(nome); // criar um novo autor
                    break;

                // cria o case para o livro

                case 2:
                    if (Autor.autores.size() == 0) { // se não existir autor cadastrado, irá imprimir a mensagem
                        System.out.println("Não existe autor cadastrado");
                        break;
                    }
                    System.out.println("Digite o titulo"); // se existir autor cadastrado, irá pedir o titulo
                    String titulo = sc.next();
                    int posicaoAutor = -1; // cria a variavel para a posição do autor
                    do { // tenta ler a posição do autor
                        Autor.listarAutores(); // lista os autores
                        System.out.println("Digite o numero do autor");
                        try { // tenta ler a posição do autor
                            posicaoAutor = sc.nextInt();
                            if (posicaoAutor >= Autor.autores.size()) {
                                throw new Exception("Autor Invalido");
                            }
                        } catch (Exception e) { // se não conseguir ler a posição do autor, irá imprimir a mensagem
                            System.out.println("Autor Invalido");
                            posicaoAutor = -1; // a posição do autor será definida como -1
                        }
                    } while (posicaoAutor < 0); // se a posição do autor for menor que 0, irá imprimir a mensagem
                    Autor autor = Autor.autores.get(posicaoAutor); // cria a variavel para o autor
                    new Livro(titulo, autor, true); // cria um novo livro
                    break;

                // cria o case para a biblioteca

                case 3:
                    if (Livro.livros.size() == 0) { // se não existir livro cadastrado, irá imprimir a mensagem
                        System.out.println("Não existe livro cadastrado");
                        break;
                    }
                    System.out.println("Digite o nome da biblioteca"); // se existir livro cadastrado, irá pedir o nome
                                                                       // da biblioteca
                    String nomeBiblioteca = sc.next(); // ler o nome da biblioteca
                    new Biblioteca(nomeBiblioteca); // criar uma nova biblioteca
                    break;

                // cria o case para adicionar o livro

                case 4:
                    System.out.println("Digite o numero do livro"); // pede o numero do livro
                    int posicaoLivro = -1; // cria a variavel para a posição do livro
                    do {
                        Livro.listarLivros(); // lista os livros
                        System.out.println("Digite o numero do livro"); // pede o numero do livro
                        try { // tenta ler a posição do livro
                            posicaoLivro = sc.nextInt(); // ler a posição do livro
                            if (posicaoLivro >= Livro.livros.size()) { // se a posição do livro for maior ou igual a
                                                                       // quantidade de livros, irá imprimir a mensagem
                                throw new Exception("Livro Invalido");
                            }
                        } catch (Exception e) { // se não conseguir ler a posição do livro, irá imprimir a mensagem
                            System.out.println("Livro Invalido");
                            posicaoLivro = -1;
                        }
                    } while (posicaoLivro < 0); // se a posição do livro for menor que 0, irá imprimir a mensagem
                    break;

                // cria o case para emprestar o livro

                case 5:
                    if (Livro.livros.size() == 0) { // se não existir livro cadastrado, irá imprimir a mensagem
                        System.out.println("Não existe livro cadastrado");
                    } else { // se existir livro cadastrado, irá pedir o numero do livro
                        Livro.listarLivros(); // lista os livros
                        System.out.println("Digite o número do livro que deseja emprestar: ");
                        int posicaoLivroEmprestimo = -1;
                        do { // tenta ler a posição do livro
                            try {
                                posicaoLivroEmprestimo = sc.nextInt();
                                if (posicaoLivroEmprestimo >= Livro.livros.size() || posicaoLivroEmprestimo < 0) {
                                    throw new Exception("Livro Inválido"); // se a posição do livro for maior ou igual a
                                                                           // quantidade de livros, irá imprimir a
                                                                           // mensagem
                                }
                            } catch (Exception e) { // se não conseguir ler a posição do livro, irá imprimir a mensagem
                                System.out.println("Livro Inválido. Digite novamente: ");
                                posicaoLivroEmprestimo = -1;
                                sc.nextLine();
                            }
                        } while (posicaoLivroEmprestimo < 0); // se a posição do livro for menor que 0, irá imprimir a
                                                              // mensagem

                        Livro livroParaEmprestimo = Livro.livros.get(posicaoLivroEmprestimo); // cria a variavel para o
                                                                                              // livro

                        try { // tenta emprestar o livro
                            livroParaEmprestimo.emprestar();
                            System.out.println("Livro emprestado com sucesso.");
                        } catch (Exception e) { // se não conseguir emprestar o livro, irá imprimir a mensagem
                            System.out.println(e.getMessage()); // exibe a mensagem de erro do metódo emprestar
                        }
                    }
                    break;

                // cria o case para devolver o livro

                case 6:
                    if (Livro.livros.size() == 0) {
                        System.out.println("Não existe livro cadastrado");
                    } else {
                        Livro.listarLivros();
                        System.out.println("Digite o número do livro que deseja devolver: ");
                        int posicaoLivroDevolucao = -1;
                        do {
                            try { // tenta ler a posição do livro
                                posicaoLivroDevolucao = sc.nextInt();
                                if (posicaoLivroDevolucao >= Livro.livros.size() || posicaoLivroDevolucao < 0) {
                                    throw new Exception("Livro Inválido");
                                }
                            } catch (Exception e) { // se não conseguir ler a posição do livro, irá imprimir a mensagem
                                System.out.println("Livro Inválido. Digite novamente: ");
                                posicaoLivroDevolucao = -1;
                                sc.nextLine();
                            }
                        } while (posicaoLivroDevolucao < 0); // se a posição do livro for menor que 0, irá imprimir a
                                                             // mensagem

                        Livro livroParaDevolucao = Livro.livros.get(posicaoLivroDevolucao); // cria a variavel para o
                                                                                            // livro

                        try { // tenta devolver o livro
                            livroParaDevolucao.devolver();
                            System.out.println("Livro devolvido com sucesso.");
                        } catch (Exception e) { // se não conseguir devolver o livro, irá imprimir a mensagem
                            System.out.println(e.getMessage()); // exibe a mensagem de erro do metódo devolver
                        }
                    }
                    break;
            }

            // cria o loop para o menu

        } while (op != 0);

        // fecha o scanner

        sc.close();
    }
}