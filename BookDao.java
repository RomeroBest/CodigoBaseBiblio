package CodigoBaseBiblio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
* Data Access Object (DAO) para gerenciar entidades Book no banco de dados.
* Gerencia a conexão com o banco de dados usando ConnectionFactory.
*/
public class BookDao {
    private Connection connection;

    public BookDao() {
        this.connection = ConnectionFactory.getConnection();
        if (this.connection == null) {
            System.out.println("Não foi possível estabelecer conexão com o banco de dados.");
        }
    }

    /**
     * Recupera todos os livros do banco de dados.
     *
     *Uma lista de todos os livros armazenados no banco de dados
     */
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        
        if (connection == null) {
            System.out.println("Conexão com o banco de dados não estabelecida");
            return books;
        }
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Book book = new Book(
                    rs.getString("ISBN"),
                    rs.getString("Titulo"),
                    rs.getString("Autores"),
                    rs.getString("Editora"),
                    rs.getInt("Ano"),
                    rs.getFloat("Preco")
                );
                books.add(book);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar livros: " + e.getMessage());
            e.printStackTrace();
        }
        return books;
    }

}