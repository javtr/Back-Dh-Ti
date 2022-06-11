package com.example.Integrador.Dao;

import java.util.List;

public interface Idao <T>{

        T guardar(T t);
        T buscar(Integer id);
        void eliminar(Integer id);
        List<T> buscarTodos();
        T actualizar(T t);
}
