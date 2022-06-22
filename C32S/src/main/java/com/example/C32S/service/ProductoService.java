package com.example.C32S.service;
import com.example.C32S.model.Producto;
import com.example.C32S.repository.IProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    private IProductoRepository iProductoRepository;

    //Se inyecta la dependencia en el constructor
    public ProductoService(IProductoRepository iProductoRepository) {
        this.iProductoRepository = iProductoRepository;
    }
    public Producto crearProducto(Producto producto){
        //PERSISTE un Producto en la BD
        return iProductoRepository.save(producto);
    }
    public List<Producto> obtenerProductos(){
        //OBTIENE todos los productos desde la BD
        return iProductoRepository.findAll();
    }
}
