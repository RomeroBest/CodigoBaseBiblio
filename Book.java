package CodigoBaseBiblio;

public class Book extends Item implements IRenewable {
    private String isbn;
    private String autores;
    private float preco;

    public Book() {
        this("", "", "", "", -1, 0.0f);
    }

    public Book(String isbn, String titulo, String autores, String editora, int ano, float preco) {
        super(titulo, editora, ano);
        this.isbn = isbn;
        this.autores = autores;
        this.preco = preco;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public void showDetails() {
        System.out.println("Detalhes do Livro:");
        System.out.println("Título: " + title);
        System.out.println("ISBN: " + isbn);
        System.out.println("Autores: " + autores);
        System.out.println("Editora: " + publisher);
        System.out.println("Ano: " + year);
        System.out.println("Preço: R$ " + String.format("%.2f", preco));
        System.out.println("Disponível: " + (isAvailable ? "Sim" : "Não"));
    }
    

    @Override
    public void renew() {
        if (isAvailable) {
            borrow();
        } else {
            System.out.println("Livro '" + title + "' renovado.");
        }
    }

    @Override
    public String toString() {
        return "Livro: " + title + 
               ", ISBN: " + isbn + 
               ", Autores: " + autores + 
               ", Editora: " + publisher + 
               ", Ano: " + year + 
               ", Preço: R$ " + String.format("%.2f", preco);
    }
    
}