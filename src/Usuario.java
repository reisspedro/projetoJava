import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private int id;
    private List<Livro> livrosEmprestados;

    public Usuario(String nome, int id) {
        this.nome = nome;
        this.id = id;
        this.livrosEmprestados = new ArrayList<>();
    }

    public boolean emprestarLivro(Livro livro) {
        livrosEmprestados.add(livro);
        return true;
    }

    public boolean devolverLivro(Livro livro) {
        if (livrosEmprestados.remove(livro)) {
            return true;
        }
        return false;
    }

    public Livro getUltimoLivroEmprestado() {
        if (!livrosEmprestados.isEmpty()) {
            return livrosEmprestados.get(livrosEmprestados.size() - 1);
        }
        return null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void setLivrosEmprestados(List<Livro> livrosEmprestados) {
        this.livrosEmprestados = livrosEmprestados;
    }

    public boolean temLivro(Livro livro) {
        return livrosEmprestados.contains(livro);
    }
}
