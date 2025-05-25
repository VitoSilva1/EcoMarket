package com.ecomarket.user_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomarket.user_service.model.Venta;
import com.ecomarket.user_service.service.VentaService;

@RestController
@RequestMapping ("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;


    @GetMapping
    public ResponseEntity<List<Venta>> listar() {
        List<Venta> ventas = ventaService.findAll();
        if(ventas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ventas);
    }

    @PostMapping
    public ResponseEntity<Venta> guardar(@RequestBody Venta venta){
        Venta ventaNueva = ventaService.save(venta);
        return ResponseEntity.status(HttpStatus.CREATED).body(ventaNueva);
    }

    @GetMapping("/id")
    public ResponseEntity<Venta> buscar (@PathVariable Integer id){
        try{
            Venta venta = ventaService.findById(id);
            return ResponseEntity.ok(venta);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            ventaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
