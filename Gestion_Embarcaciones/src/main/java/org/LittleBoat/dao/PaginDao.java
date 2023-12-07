/**
 * La clase abstracta PaginDao proporciona metodos y atributos necesarios para porder pagiar los resultados en la base de datos,
 * ademas de ello se tienen dos metodos a implementar countALl y countRecords.
 * @version 1.0
* */
package org.LittleBoat.dao;

import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Getter
@Setter
public abstract class PaginDao {
    private int pages;
    private final int limit = 5;
    private int totalRecords;

    /**
     * Metodo para calcular el limite de una consulta SQL, necesario para la sentencia SQL
     * @param page el número de pagina sobre el cual se quieren traer los registros
     * @return el limite de elementos a etregrar.
    * */
    protected int calculateOffset (int page) {
        int offset = (page -1) * limit;
        System.out.println("Page: " + page + ", Offset: " + offset);
        return (page -1) * limit;
    }

    /**
     * Calcula el número de paginas necesarias según el tamaño de registros tendro de una tabla en la base de datos
    * */
    protected int calculatePages () {
        return ((int) countRecords() / limit);
    }

    /**
     * Clase a implementar para devolver los registros según la pagina proporcionada.
     * @param page el número de pagina para buscar los registros.
     * @return una lista de los registro de la pagina.
    * */
    public abstract List<?> findPage(int page);

    /**
     * Clase a implementar que cuenta cuantos registros tiene cierta tabla en la base de datos
     * @return el número de registros detro de una tabla.
    * */
    protected abstract int countRecords ();

}
