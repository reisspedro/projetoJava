import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Livro> livrosDisponiveis;
    private List<Usuario> usuarios;

    public Biblioteca() {
        this.livrosDisponiveis = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void cadastrarLivros(Livro livro) {
        livrosDisponiveis.add(livro);
    }

    public boolean emprestarLivro(Usuario usuario, Livro livro) {
        if (livrosDisponiveis.contains(livro)) {
            livrosDisponiveis.remove(livro);
            usuario.getLivrosEmprestados().add(livro);
            return true;
        }
        return false;
    }

    public boolean devolverLivro(Usuario usuario, Livro livro) {
        if (usuario.devolverLivro(livro)) {
            livrosDisponiveis.add(livro);
            return true;
        }
        return  false;
    }

    public void listarLivrosDisponiveis() {
        System.out.println("Livros Disponiveis: ");
        System.out.println();
        for (Livro livro : livrosDisponiveis) {
        System.out.println(livro.getTitulo() + " - " + "Autor: " + livro.getAutor() + " - " + "Publicado em: " + livro.getAnoFormatado() + " - " + "Valor: R$" + livro.getPreco());
        }
    }

    public void ordernarLivrosPorAutor() {
        livrosDisponiveis.sort(Comparator.comparing(Livro::getAutor));
    }

    public List<Livro> buscarLivroPorTitulo(String titulo) {
        List<Livro> tituloLivros = new ArrayList<>();
        for (Livro livro : livrosDisponiveis) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                tituloLivros.add(livro);
            }
        }
        return tituloLivros;
    }

    public List<Livro> buscarLivrosPorAutor(String autor) {
        List<Livro> livrosDoAutor = new ArrayList<>();
        for (Livro livro : livrosDisponiveis) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                livrosDoAutor.add(livro);
            }
        }
        return livrosDoAutor;
    }

    public List<Livro> buscarLivrosPorAno(int ano) {
        List<Livro> livrosDoAno = new ArrayList<>();
        for (Livro livro : livrosDisponiveis) {
            if (livro.getAnoDePublicacao() == ano) {
                livrosDoAno.add(livro);
            }
        }
        return livrosDoAno;
    }

    public List<Livro> buscarLivrosPorAnoAnteriores(int ano) {
        List<Livro> livrosAnteriores = new ArrayList<>();
        for (Livro livro : livrosDisponiveis) {
            if (livro.getAnoDePublicacao() < ano) {
                livrosAnteriores.add(livro);
            }
        }
        return livrosAnteriores;
    }

    public List<Livro> buscarLivrosPorAnoPosterior(int ano) {
        List<Livro> livrosPosteriores = new ArrayList<>();
        for (Livro livro : livrosDisponiveis) {
            if (livro.getAnoDePublicacao() > ano) {
                livrosPosteriores.add(livro);
            }
        }
        return livrosPosteriores;
    }

}
