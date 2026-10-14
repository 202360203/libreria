package com.api.libreria.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.libreria.models.PrestamoModel;
import com.api.libreria.repositories.IPrestamoRepository;

@Service
public class PrestamoService {

    @Autowired
    IPrestamoRepository prestamoRepository;

    public ArrayList<PrestamoModel> obtenerPrestamos() {
        return (ArrayList<PrestamoModel>) prestamoRepository.findAll();
    }

    public PrestamoModel guardarPrestamo(PrestamoModel prestamo) {
        return prestamoRepository.save(prestamo);
    }

    public Optional<PrestamoModel> obtenerPorId(Long id) {
        return prestamoRepository.findById(id);
    }

    public PrestamoModel actualizarPrestamo(PrestamoModel request, Long id) {
        PrestamoModel prestamo = prestamoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("No existe un préstamo con ID: " + id));
        prestamo.setLibro(request.getLibro());
        prestamo.setSocio(request.getSocio());
        prestamo.setFechaPrestamo(request.getFechaPrestamo());
        prestamo.setFechaDevolucion(request.getFechaDevolucion());

        return prestamoRepository.save(prestamo);
    }

    public boolean eliminarPrestamo(Long id) {
        try {
            prestamoRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public ArrayList<PrestamoModel> buscarPorLibro(Long isbn) {
        return prestamoRepository.findByLibroIsbn(isbn);
    }

    public ArrayList<PrestamoModel> buscarPorSocio(Long id) {
        return prestamoRepository.findBySocioId(id);
    }
}