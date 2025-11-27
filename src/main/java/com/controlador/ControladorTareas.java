package com.controlador;

import com.modelo.*;
import com.vista.Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorTareas {

    private Interfaz vista;
    private RepositorioTareas repo;

    public ControladorTareas(Interfaz vista) {
        this.vista = vista;
        this.repo = RepositorioTareas.getInstance();
        iniciarEventos();
    }

    private void iniciarEventos() {

        vista.btnListar.addActionListener(e -> listar());
        vista.btnCrear.addActionListener(e -> crear());
        vista.btnMarcar.addActionListener(e -> marcar());
        vista.btnEliminar.addActionListener(e -> eliminar());
        vista.btnBuscar.addActionListener(e -> buscar());

        vista.btnSalir.addActionListener(e -> System.exit(0));
    }

    private void listar() {
        StringBuilder sb = new StringBuilder();
        for (Tarea t : repo.obtenerTodas()) {
            sb.append(t.getId())
              .append(" - ")
              .append(t.getTitulo())
              .append(" [")
              .append(t.isCompletada() ? "Completada" : "Pendiente")
              .append("]\n");
        }

        vista.areaTexto.setText(sb.toString());
    }

    private void crear() {
        String titulo = vista.pedirTexto("Título de la tarea:");
        String descripcion = vista.pedirTexto("Descripción:");

        if (titulo == null || titulo.isEmpty()) return;

        Tarea t = new Tarea();
        t.setTitulo(titulo);
        t.setDescripcion(descripcion);
        t.setCompletada(false);

        repo.agregar(t);

        vista.mostrarMensaje("Tarea creada con éxito.");
    }

    private void marcar() {
        try {
            int id = Integer.parseInt(vista.pedirTexto("ID de la tarea:"));
            repo.marcarCompletada(id);
            vista.mostrarMensaje("Tarea marcada como completada.");
        } catch (Exception e) {
            vista.mostrarMensaje("ID inválido.");
        }
    }

    private void eliminar() {
        try {
            int id = Integer.parseInt(vista.pedirTexto("ID a eliminar:"));
            if (repo.eliminar(id))
                vista.mostrarMensaje("Tarea eliminada.");
            else
                vista.mostrarMensaje("No existe una tarea con ese ID.");
        } catch (Exception e) {
            vista.mostrarMensaje("ID inválido.");
        }
    }

    private void buscar() {
        try {
            int id = Integer.parseInt(vista.pedirTexto("ID a buscar:"));
            Tarea t = repo.obtenerPorId(id);

            if (t != null)
                vista.areaTexto.setText(t.toString());
            else
                vista.mostrarMensaje("No encontrada.");
        } catch (Exception e) {
            vista.mostrarMensaje("ID inválido.");
        }
    }
}

