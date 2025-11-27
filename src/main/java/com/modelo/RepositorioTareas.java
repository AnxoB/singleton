package com.modelo;

import java.util.ArrayList;
import java.util.List;

public class RepositorioTareas {
    private static RepositorioTareas instance;
    private List<Tarea> tareas;

    private RepositorioTareas(){
        tareas = new ArrayList<>();
    }

    public static RepositorioTareas getInstance(){
        if (instance==null) {
            synchronized (RepositorioTareas.class){
                if (instance==null) {
                    instance=new RepositorioTareas();
                }
            }
        }
        return instance;
    }

    
    public List<Tarea> obtenerTodas(){
        return tareas;
    }

    public Tarea obtenerPorId(int id){
        Tarea t = null;
        for (Tarea tarea : tareas) {
            if (tarea.getId()==id) {
                t=tarea;
            }
        }
        return t;
    }

    public void agregar(Tarea t){
        tareas.add(t);
    }

    public boolean eliminar(int id){
        boolean b = false;
        Tarea tarea = obtenerPorId(id);
        if (tarea!=null) {
            tareas.remove(tarea);
            b=true;
        }
        return b;
    }

    public void marcarCompletada(int id){
        Tarea tarea = obtenerPorId(id);
        if (tarea!=null) {
            tarea.setCompletada(true);
        }
    } 
}
