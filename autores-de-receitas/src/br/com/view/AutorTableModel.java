package br.com.view;

import br.com.model.Autor;
import br.com.model.AutorDAO;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class AutorTableModel extends AbstractTableModel {

    protected static final int COL_ID = 0;
    protected static final int COL_NOME = 1;
    protected static final int COL_EMAIL = 2;
    protected static final int COL_TELEFONE = 3;
    protected static final int COL_RECEITA = 4;

    private final AutorDAO dao = new AutorDAO();
    private List<Autor> autores;

    AutorTableModel(){
        autores = dao.getTodos();
    }

    public Autor get(int linha){
        return autores.get(linha);
    }

    public void editar(int linha, Autor autor){
        dao.adicionar(autor);
        fireTableRowsUpdated(linha, linha);
    }

    public void adicionar(Autor autor){
        var linha = autores.size();
        dao.adicionar(autor);
        this.autores = dao.getTodos();
        fireTableRowsInserted(linha, linha);
    }

    public void remover(int linha, Autor autor){
        dao.remover(autor);
        this.autores = dao.getTodos();
        fireTableRowsDeleted(linha, linha);
    }

    @Override
    public String getColumnName(int column) {
        if (column == COL_ID) return "ID";
        else if (column == COL_NOME) return "Nome";
        else if (column == COL_EMAIL) return "Email";
        else if (column == COL_TELEFONE) return "Telefone";
        else if (column == COL_RECEITA) return "Receita";
        return null;
    }

    @Override
    public int getRowCount() {
        return autores.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        var autor = autores.get(rowIndex);
        if (columnIndex == COL_ID) return autor.getId();
        else if (columnIndex == COL_NOME) return autor.getNome();
        else if (columnIndex == COL_EMAIL) return autor.getEmail();
        else if (columnIndex == COL_TELEFONE) return autor.getTelefone();
        else if (columnIndex == COL_RECEITA) return autor.getReceita();
        return null;
    }
}
