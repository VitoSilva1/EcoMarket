package com.ecomarket.user_service.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="venta")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String marca;

    @Column(nullable=true)
    private String modelo;

    @Column(nullable = false)
    private String tipo_producto;

    @JsonProperty("fecha_venta")

    @Column(nullable = true)
    private Date fecha_venta;

    @Column(nullable = false)
    private String nombre_cliente;

}
