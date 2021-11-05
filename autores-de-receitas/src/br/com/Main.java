package br.com;

import br.com.view.AutoresTable;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    Main(){

        // Propriedades
        setTitle("Início");
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(640, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        // Adicionando os componenetes
        add(windowPageCenter(), BorderLayout.CENTER);
        add(windowPageEnd(), BorderLayout.PAGE_END);
    }

    private JPanel windowPageCenter(){
        var pnl = new JPanel();

        // Carregando a imagem como ícone
        var url = getClass().getResource("/br/com/imagem/ingredientes.jpg");
        ImageIcon icone = null;
        if (url != null) {
            icone = new ImageIcon(url);
        }

        // Criando o icone no rótulo
        var lblIcone = new JLabel();
        lblIcone.setIcon(icone);

        pnl.add(lblIcone);

        return pnl;
    }

    private JPanel windowPageEnd(){
        var pnl = new JPanel();

        var btnEntrar = new JButton("Entrar");
        btnEntrar.addActionListener(event -> {
            btnEntrar.setEnabled(false);
            new AutoresTable().setVisible(true);
            dispose();
        });

        var btnSair = new JButton("Sair");
        btnSair.addActionListener(event -> dispose());

        pnl.add(btnEntrar);
        pnl.add(btnSair);

        return pnl;
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new Main().setVisible(true));
    }
}
