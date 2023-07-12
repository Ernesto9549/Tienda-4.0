package com.tienda.service.impl;

import com.tienda.domain.Producto;
import com.tienda.dao.ProductoDao;
import com.tienda.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoDao productoDao;
    
    @Override
    public List<Producto> getProductos(boolean activos) {
        var lista=productoDao.findAll();
        
        if(activos){
            lista.removeIf(e-> !e.isActivo());
        }
        
        return lista;
    }
   @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }
    
    //Ejemplo de un metodo que hace una consulta apliada de JPA
     @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaAmpliada(double precioI,double precio){
       return productoDao.findByPrecioBetweenOrderByDescripcion(precioI, precio);
    }
    
    //Ejemplo de un metodo que hace una consulta apliada de JPA
     @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaJPQL(double precioI,double precio){
       return productoDao.consultaConJPQL(precioI, precio);
    }
    
    
    
}
