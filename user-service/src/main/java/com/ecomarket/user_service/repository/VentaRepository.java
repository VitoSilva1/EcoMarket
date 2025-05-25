package com.ecomarket.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomarket.user_service.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
}
