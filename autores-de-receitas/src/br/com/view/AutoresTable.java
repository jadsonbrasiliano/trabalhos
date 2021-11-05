package br.com.view;

import br.com.model.Autor;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AutoresTable extends JFrame {

    private final AutorTableModel mdlAutor = new AutorTableModel();
    private final JTable tblAutor = new JTable(mdlAutor);
    private final TableRowSorter<AutorTableModel> sorter;

    private final JTextField txtBuscar = new JTextField();

    public AutoresTable(){

        // Propriedades da tela
        setTitle("Autores");
        setSize(640, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        // Controles da tela
        windowClosing();

        // Modo da tabela
        sorter = new TableRowSorter<>(mdlAutor);
        tblAutor.setRowSorter(sorter);
        tblAutor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Componentes da tela
        add(windowPageStart(), BorderLayout.PAGE_START);
        add(new JScrollPane(tblAutor));
        add(windowPageEnd(), BorderLayout.PAGE_END);
    }

    private JPanel windowPageStart(){
        var pnl = new JPanel(new BorderLayout());

        // Implementando o buscador
        txtBuscar.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { atualizarBuscador(); }
            public void removeUpdate(DocumentEvent e) { atualizarBuscador(); }
            public void changedUpdate(DocumentEvent e) { atualizarBuscador(); }

            private void atualizarBuscador(){
                if (txtBuscar.getText().trim().isEmpty()){
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(
                            RowFilter.regexFilter("(?i)" + txtBuscar.getText(),
                                    AutorTableModel.COL_ID,
                                    AutorTableModel.COL_NOME,
                                    AutorTableModel.COL_EMAIL,
                                    AutorTableModel.COL_TELEFONE
                            )
                    );
                }
            }
        });

        pnl.add(new JLabel("Buscar:"), BorderLayout.LINE_START);
        pnl.add(txtBuscar, BorderLayout.CENTER);

        return pnl;
    }

    private JPanel windowPageEnd(){
        var pnl = new JPanel();

        var btnAdicionar = new JButton("Adicionar");
        btnAdicionar.addActionListener(event -> {
            AutorDialog autorDialog = new AutorDialog(new Autor());
            autorDialog.setLocationRelativeTo(this);
            autorDialog.setVisible(true);
            if(!autorDialog.isSalvo()) return;
            mdlAutor.adicionar(autorDialog.getAutor());
        });

        var btnEditar = new JButton("Editar");
        btnEditar.addActionListener(event -> {
            var linha = getSelectedRow();
            if (linha == -1) return;

            var autor = mdlAutor.get(linha);
            var autorDialog = new AutorDialog(autor);

            autorDialog.preencherFields();
            autorDialog.setLocationRelativeTo(this);
            autorDialog.setVisible(true);
            if (!autorDialog.isSalvo()) return;
            mdlAutor.editar(linha, autorDialog.getAutor());
        });

        var btnExcluir = new JButton("Excluir");
        btnExcluir.addActionListener(event -> {
            var linha = getSelectedRow();
            if (linha == -1) return;

            var autor = mdlAutor.get(linha);

            var opcao = JOptionPane.showConfirmDialog(this,
                    "Deseja excluir '" + autor.getNome() + "'?",
                    "Excluir", JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            if (opcao == JOptionPane.YES_OPTION) mdlAutor.remover(linha, autor);
        });

        pnl.add(btnAdicionar);
        pnl.add(btnEditar);
        pnl.add(btnExcluir);

        return pnl;
    }

    private int getSelectedRow(){
        int selectedRow = -1;
        try {
            selectedRow = tblAutor.convertRowIndexToModel(tblAutor.getSelectedRow());
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this,
                    "Nenhuma linha selecionada!",
                    "Mensagem", JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        }
        return selectedRow;
    }

    private void windowClosing(){
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                var opcao = JOptionPane.showConfirmDialog(AutoresTable.this,
                        "Deseja sair da aplicação?",
                        "Sair", JOptionPane.YES_NO_OPTION);
                if (opcao == JOptionPane.YES_OPTION) dispose();
            }
        });
    }
}