public class Livro implements Comparable<Livro> {
    private String titulo;
    private String autor;
    private int anoDePublicacao;
    private double preco;

    public Livro(String titulo, String autor, int anoDePublicacao, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
        this.preco = preco;
    }

    @Override
    public int compareTo(Livro outroLivro) {
        return this.titulo.compareTo(outroLivro.getTitulo());
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public void setAnoDePublicacao(int anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getAnoFormatado() {
        if (anoDePublicacao < 0) {
            return Math.abs(anoDePublicacao) + " A.C";
        }
        return anoDePublicacao + "";
    }

    @Override
    public String toString() {
        return titulo + ", Escrito por: " + autor + ", De " + anoDePublicacao + ", Por: R$" + preco;
    }
}
