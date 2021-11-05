package br.com.view;

import br.com.model.Autor;

import javax.swing.*;
import java.awt.*;

public class AutorDialog extends JDialog {

    JTextField txtNome = new JTextField();
    JTextField txtEmail = new JTextField();
    JTextField txtTelefone = new JTextField();

    private final Autor autor;
    private boolean salvo = false;

    public AutorDialog(Autor autor){

        // Propriedades da tela
        setTitle("Autor");
        setSize(480, 320);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);

        // Componentes da tela
        add(windowPageStart(), BorderLayout.PAGE_START);
        add(windowPageCenter(), BorderLayout.CENTER);
        add(windowPageEnd(), BorderLayout.PAGE_END);

        this.autor = autor;
    }

    private JPanel windowPageStart(){
        var pnl = new JPanel();
        pnl.add(new JLabel("Gerenciamento do Autor"));
        return pnl;
    }

    private JPanel windowPageCenter(){
        var pnl = new JPanel(new GridBagLayout());

        var grd = new GridBagConstraints();
        grd.insets = new Insets(10, 5, 10, 5);

        // labels
        grd.gridx = 0; grd.gridy = 0;
        pnl.add(new JLabel("Nome:"), grd);
        grd.gridy = 1;
        pnl.add(new JLabel("Email:"), grd);
        grd.gridy = 2;
        pnl.add(new JLabel("Telefone:"), grd);

        // fields
        grd.fill = GridBagConstraints.HORIZONTAL;
        grd.gridx = 1; grd.gridy = 0;
        grd.weightx = 3;
        pnl.add(txtNome, grd);
        grd.gridy = 1;
        pnl.add(txtEmail, grd);
        grd.gridy = 2;
        pnl.add(txtTelefone, grd);

        return pnl;
    }

    private JPanel windowPageEnd(){
        var pnl = new JPanel();

        var btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(event -> {
            if (txtNome.getText().equals("")
                    || txtEmail.getText().equals("")
                    || txtTelefone.getText().equals("")) return;
            this.salvo = true;
            JOptionPane.showMessageDialog(this,
                    "Concluido com sucesso!",
                    "Salvo", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        });

        var btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(event -> dispose());

        pnl.add(btnSalvar);
        pnl.add(btnCancelar);

        return pnl;
    }

    public boolean isSalvo() { return salvo; }

    public Autor getAutor(){
        autor.setNome(txtNome.getText());
        autor.setEmail(txtEmail.getText());
        autor.setTelefone(txtTelefone.getText());
        return autor;
    }

    public void preencherFields(){
        txtNome.setText(autor.getNome());
        txtEmail.setText(autor.getEmail());
        txtTelefone.setText(autor.getTelefone());
    }
}
