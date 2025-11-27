package com.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz{
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Gestor de Tareas");
        ventana.setSize(600, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();


        JButton listarTareas = new JButton("Listar Tareas");
        listarTareas.setBounds(50, 100, 150, 30);
        panel.add(listarTareas);
        JButton crearTarea = new JButton("Crear Tarea");
        crearTarea.setBounds(50, 150, 150, 30);
        panel.add(crearTarea);
        JButton eliminarTarea = new JButton("Eliminar Tarea");
        eliminarTarea.setBounds(50, 200, 150, 30);
        panel.add(eliminarTarea);
        JButton buscarTarea = new JButton("Eliminar Tarea");
        buscarTarea.setBounds(50, 200, 150, 30);
        panel.add(buscarTarea);
        


        ventana.add(panel);

        listarTareas.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
            
        });

        crearTarea.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
            
        });

        eliminarTarea.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
            
        });

        buscarTarea.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
            
        });

        ventana.setVisible(true);
    }
}
