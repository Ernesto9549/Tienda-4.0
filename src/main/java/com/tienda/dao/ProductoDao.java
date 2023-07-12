package com.tienda.dao;

import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductoDao extends JpaRepository<Producto,Long>{
    //Ejemplo de un metodo que hace una consulta apliada de JPA
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioI,double precio);
    
    
    //Ejemplo de un metodo que hace una consulta apliada de JPA
    @Query(value="SELECT a FROM Producto a WHERE a.precio BETWEEN:precioINF AND:precioSUP ORDER BY a.descripcion ASC")
    public List<Producto> consultaConJPQL(double precioI,double precio);
    
     //Ejemplo de un metodo que hace una consulta apliada de JPA
    @Query(nativeQuery=true,
            value="SELECT a FROM Producto a WHERE a.precio BETWEEN:precioINF AND:precioSUP ORDER BY a.descripcion ASC")
    public List<Producto> consultaConSQL(double precioI,double precio);
}
