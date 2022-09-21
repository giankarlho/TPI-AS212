package dao;

import java.util.List;

public interface ICRUD<Generic> {

    void registrar(Generic gen) throws Exception;

    void modificar(Generic gen) throws Exception;

    void cambiarEstado(Generic gen) throws Exception;

    void eliminar(int codigo) throws Exception;

    // Tipo -> A: Activos, I: Inactivos, T: Todos
    List<Generic> listarTodos(char tipo) throws Exception;
}
