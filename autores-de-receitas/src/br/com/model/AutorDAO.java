package br.com.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO {

    private static final String SELECT_TODOS = "SELECT * FROM Autor";

    private static final String INSERT = "INSERT INTO Autor SET nome=?,  email=?, telefone=?, receita=?";
    private static final String UPDATE = "UPDATE Autor SET nome=?, email=?, telefone=?, receita=? WHERE id=?";
    private static final String DELETE = "DELETE FROM Autor WHERE id=?";

    private Autor doResultSet(ResultSet rs) throws SQLException {
        return new Autor(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("email"),
                rs.getString("telefone"),
                rs.getString("receita")
        );
    }

    public List<Autor> getTodos(){
        var autores = new ArrayList<Autor>();

        try (var conn = ConexaoBD.getConnection();
             var stmt = conn.createStatement();
             var rs = stmt.executeQuery(SELECT_TODOS)) {

            while (rs.next()) { autores.add(doResultSet(rs)); }
        }
        catch (SQLException e){ e.printStackTrace(); }

        return autores;
    }

    public void adicionar(Autor autor){
        if (autor == null) return;

        var sql = autor.getId() == -1 ? INSERT : UPDATE;

        try (var conn = ConexaoBD.getConnection();
             var stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, autor.getNome());
            stmt.setString(2, autor.getEmail());
            stmt.setString(3, autor.getTelefone());
            stmt.setString(4, autor.getReceita());

            if (autor.getId() == -1){
                stmt.executeUpdate();
                var rs = stmt.getGeneratedKeys();
                if (rs.next()){
                    autor.setId(rs.getInt(1));
                }
            } else {
                stmt.setInt(5, autor.getId());
                stmt.executeUpdate();
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void remover(Autor autor){
        if (autor.getId() == -1) return;

        try (var conn = ConexaoBD.getConnection();
             var stmt = conn.prepareStatement(DELETE)) {
            stmt.setInt(1, autor.getId());
            stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
