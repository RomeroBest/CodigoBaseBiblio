package CodigoBaseBiblio;
import java.util.List;
/**
* Esta classe Java inicializa um objeto BookDao, exibe todos os livros do banco de dados e fornece
* feedback se nenhum livro for encontrado.
*/
public class Main {
    private static BookDao bookDao = new BookDao();

    public static void main(String[] args) {
        System.out.println("Iniciando o programa...");
        displayAllBooks();
    }

    private static void displayAllBooks() {
        System.out.println("Buscando livros no banco de dados...");
        List<Book> books = bookDao.getAll();
        if (books.isEmpty()) {
            System.out.println("Nenhum livro encontrado ou houve um erro ao buscar os livros.");
        } else {
            System.out.println("Livros atualmente no banco de dados:");
            for (Book book : books) {
                book.showDetails(); // Mostra todos os detalhes
                System.out.println(); // Adiciona uma linha em branco para melhor legibilidade
            }
        }
    }

}