package com.example.C32S.controller;

import com.example.C32S.model.Producto;
import com.example.C32S.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ProductoController {

    //Se inyecta la dependencia
    @Autowired
    private ProductoService productoService;

    @PostMapping("/producto")
    public Producto guardar(@RequestBody Producto producto){
        return productoService.crearProducto(producto);
    }

    @GetMapping("/productos")
    public List<Producto> obtenerProductos(){
        return productoService.obtenerProductos();
    }

}
