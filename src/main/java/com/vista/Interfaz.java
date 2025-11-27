package com.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

public class Interfaz extends JFrame {
    public JButton btnListar = new JButton("Listar Tareas");
    public JButton btnCrear = new JButton("Crear Tarea");
    public JButton btnMarcar = new JButton("Marcar Completada");
    public JButton btnEliminar = new JButton("Eliminar Tarea");
    public JButton btnBuscar = new JButton("Buscar por ID");
    public JButton btnSalir = new JButton("Salir");

    public JTextArea areaTexto = new JTextArea(15, 40);

    public Interfaz() {

        setTitle("Gestor de Tareas - MVC");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(6, 1));
        panelBotones.add(btnListar);
        panelBotones.add(btnCrear);
        panelBotones.add(btnMarcar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnSalir);

        areaTexto.setEditable(false);

        add(panelBotones, BorderLayout.WEST);
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        setVisible(true);
    }

    public String pedirTexto(String msg) {
        return JOptionPane.showInputDialog(this, msg);
    }

    public void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
}
