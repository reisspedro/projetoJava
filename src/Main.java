import javax.swing.*;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //cadastro de livros
        Biblioteca biblioteca = new Biblioteca();

        Livro livro1 = new Livro("Dom Quixote", "Miguel de Cervantes", 1605, 68.06);
        Livro livro2 = new Livro("Guerra e paz", "Liev Tolstói", 1869, 187.90);
        Livro livro3 = new Livro("A Montanha Mágica", "Thomas Mann", 1924, 105.53);
        Livro livro4 = new Livro("Cem Anos de Solidão", "Gabriel Garcia Márquez", 1967, 35.85);
        Livro livro5 = new Livro("Ulisses", "James Joyce", 1922, 39.90);
        Livro livro6 = new Livro("Em Busca do Tempo Perdido", "Marcel Proust", 1913, 89.39);
        Livro livro7 = new Livro("A Divina Comédia: Paraíso, Purgatorio e Inferno", "Dante Alighieri", 1321, 40.66);
        Livro livro8 = new Livro("O Homem sem Qualidades", "Robert Musil", 1930, 134.71);
        Livro livro9 = new Livro("O Processo", "Franz Kafka", 1925, 14.90);
        Livro livro10 = new Livro("O Som e a Fúria", "William Faulkner", 1929, 64.65);
        Livro livro11 = new Livro("Crime e Castigo", "Fiódor Dostoiévski", 1866, 49.50);
        Livro livro12 = new Livro("Orgulho e Preconceito", "Jane Austen", 1813, 14.90);
        Livro livro13 = new Livro("Anna Kariênina", "Liev Tolstói", 1877, 75.89);
        Livro livro14 = new Livro("Grande Sertão: Veredas", "Guimarães Rosa", 1959, 77.66);
        Livro livro15 = new Livro("O Leopardo", "Tomaso di Lampedusa", 1958, 81.93);
        Livro livro16 = new Livro("Édipo Rei", "Sófocles", -427, 19.10);
        Livro livro17 = new Livro("1984", "George Orwell", 1949, 15.99);
        Livro livro18 = new Livro("O Castelo", "Franz Kafka", 1926, 26.68);
        Livro livro19 = new Livro("As Asas da Pomba", "Henry James", 1902, 9.90);
        Livro livro20 = new Livro("Ilíada e Odisseia", "Homero", -750, 40.66);
        Livro livro21 = new Livro("A Vida e as Opinões do Cavalheiro Tristam Shandy", "Laurence Sterne", 1759, 65.82);
        Livro livro22 = new Livro("Doutor Fausto", "Thomas Mann", 1947, 79.92);
        Livro livro23 = new Livro("Lolita", "Vladimir Nabókov", 1955, 73.33);
        Livro livro24 = new Livro("Enquanto Agonizo", "William Faulkner", 1930, 27.36);
        Livro livro25 = new Livro("A Morte de Virgílio", "Hermann Broch", 1945, 68.38);
        Livro livro26 = new Livro("Os Lusíadas", "Luís de Camões", 1572, 19.30);

        biblioteca.cadastrarLivros(livro1);
        biblioteca.cadastrarLivros(livro2);
        biblioteca.cadastrarLivros(livro3);
        biblioteca.cadastrarLivros(livro4);
        biblioteca.cadastrarLivros(livro5);
        biblioteca.cadastrarLivros(livro6);
        biblioteca.cadastrarLivros(livro7);
        biblioteca.cadastrarLivros(livro8);
        biblioteca.cadastrarLivros(livro9);
        biblioteca.cadastrarLivros(livro10);
        biblioteca.cadastrarLivros(livro11);
        biblioteca.cadastrarLivros(livro12);
        biblioteca.cadastrarLivros(livro13);
        biblioteca.cadastrarLivros(livro14);
        biblioteca.cadastrarLivros(livro15);
        biblioteca.cadastrarLivros(livro16);
        biblioteca.cadastrarLivros(livro17);
        biblioteca.cadastrarLivros(livro18);
        biblioteca.cadastrarLivros(livro19);
        biblioteca.cadastrarLivros(livro20);
        biblioteca.cadastrarLivros(livro21);
        biblioteca.cadastrarLivros(livro22);
        biblioteca.cadastrarLivros(livro23);
        biblioteca.cadastrarLivros(livro24);
        biblioteca.cadastrarLivros(livro25);
        biblioteca.cadastrarLivros(livro26);

        //usuario, emprestar e devolver
        Usuario usuario = new Usuario("Jose Abican", 234);

        boolean sucessoEmprestimo = biblioteca.emprestarLivro(usuario, livro8);
        if (sucessoEmprestimo) {
            System.out.println("O Livro " + usuario.getLivrosEmprestados() + " emprestado com sucesso!");
        }

        System.out.println();

        biblioteca.listarLivrosDisponiveis();

        Livro ultimoLivroEmprestado = usuario.getUltimoLivroEmprestado();
        if (ultimoLivroEmprestado != null) {
            boolean sucessoDevolucao = biblioteca.devolverLivro(usuario, usuario.getUltimoLivroEmprestado());
            if (sucessoDevolucao) {
                System.out.println("O Livro [" + ultimoLivroEmprestado.getTitulo() + ", Escrito por: " + ultimoLivroEmprestado.getAutor() + ", De: " + ultimoLivroEmprestado.getAnoFormatado() + ", Valor de: R$" + ultimoLivroEmprestado.getPreco() + "] foi devolvido com sucesso!");
            } else {
                System.out.println("Não foi possivel devolver o livro.");
            }
        } else {
            System.out.println("Nenhum livro para Devolver");
        }

        System.out.println();

        biblioteca.listarLivrosDisponiveis();

        System.out.println();

        //buscas/filtros
        int anoBuscado = 1700;

        System.out.println("Livros antes de " + anoBuscado + ":");
        for (Livro livro : biblioteca.buscarLivrosPorAnoAnteriores(anoBuscado)) {
            if (livro.getAnoDePublicacao() < anoBuscado) {
                System.out.println(livro.getTitulo() + " - " + livro.getAnoFormatado() + " - " + "De: " + livro.getAutor());

            }
        }

        System.out.println();

        System.out.println("Livros depois de " + anoBuscado + ":");
        for (Livro livro : biblioteca.buscarLivrosPorAnoPosterior(anoBuscado)) {
            if (livro.getAnoDePublicacao() > anoBuscado) {
                System.out.println(livro.getTitulo() + " - " + livro.getAnoFormatado() + " - " + "De: " + livro.getAutor());
            }
        }

        System.out.println();

        int anoBuscado2 = 1926;

        System.out.println("livros do ano de " + anoBuscado2 + ":");
        List<Livro> livrosDoAno = biblioteca.buscarLivrosPorAno(anoBuscado2);
        if (livrosDoAno.isEmpty()) {
            System.out.println("Não há livros registrados no ano de " + "''" + anoBuscado2 + "''" + ".");
        } else {
            for (Livro livro : livrosDoAno) {
                System.out.println(livro.getTitulo() + " - " + "Ano: " + livro.getAnoFormatado() + " - " + "De: " + livro.getAutor() + " - " + "Por: R$" + livro.getPreco());
            }
        }

        System.out.println();

        String autorBuscado = "Dante Alighieri";

        System.out.println("Livros do autor " + autorBuscado + ":");
        List<Livro> livrosDoAutor = biblioteca.buscarLivrosPorAutor(autorBuscado);
        if (livrosDoAutor.isEmpty()) {
            System.out.println("Não há livros registrados do autor " + "''" + autorBuscado + "''" + ".");
        } else {
            for (Livro livro : livrosDoAutor) {
                System.out.println(livro.getTitulo() + " - " + "Ano: " + livro.getAnoFormatado() + " - " + "De: " + livro.getAutor() + " - " + "Por: R$" + livro.getPreco());
            }
        }

        System.out.println();

        String tituloBuscado = "Dom Quixote";

        System.out.println("Livros com o titulo " + tituloBuscado + ":");
        List<Livro> tituloLivros = biblioteca.buscarLivroPorTitulo(tituloBuscado);
        if (tituloLivros.isEmpty()) {
            System.out.println("não há livros com o titulo: " + "''" + tituloBuscado + "''" + ".");
        }else {
            for (Livro livro : tituloLivros) {
                System.out.println(livro.getTitulo() + " - " + "Ano: " + livro.getAnoFormatado() + " - " + "De: " + livro.getAutor() + " - " + "Por: R$" + livro.getPreco());
            }
        }
    }
}

