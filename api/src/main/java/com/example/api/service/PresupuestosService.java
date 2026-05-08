package com.example.api.service;

import org.springframework.stereotype.Service;

import com.example.api.dto.CentralitasDTO;
import com.example.api.dto.DescuentosDTO;
import com.example.api.dto.FibrasDTO;
import com.example.api.dto.PacksFutbolDTO;
import com.example.api.dto.PresupuestosDTO;
import com.example.api.dto.ServiciosAdicionalesDTO;
import com.example.api.dto.StreamingDTO;
import com.example.api.dto.TarifasDTO;
import com.example.api.model.PresupuestosEntity;

@Service
public class PresupuestosService {
    private PresupuestosService instance;

    private PresupuestosService(){}

    public PresupuestosService getInstance() {
        if(instance == null) {
            instance = new PresupuestosService();
        }
        return instance;
    }
    
    public PresupuestosDTO toDto(PresupuestosEntity entity) {
        DescuentosDTO descuento = new DescuentosDTO();
        PacksFutbolDTO packFutbol = new PacksFutbolDTO();
        CentralitasDTO centralita = new CentralitasDTO();
        StreamingDTO streaming = new StreamingDTO();
        FibrasDTO fibra = new FibrasDTO();
        ServiciosAdicionalesDTO serviciosAdicionales = new ServiciosAdicionalesDTO();
        TarifasDTO tarifa = new TarifasDTO();
        PresupuestosDTO dto = new PresupuestosDTO();

        if(entity.getDescuento() != null) {
            descuento.setId(entity.getDescuento().getId());
            descuento.setPorciento(entity.getDescuento().getPorciento());
        }

        if(entity.getPackFutbol() != null) {
            packFutbol.setId(entity.getPackFutbol().getId());
            packFutbol.setNombre(entity.getPackFutbol().getNombre());
            packFutbol.setPrecio(entity.getPackFutbol().getPrecio());
        }

        if(entity.getCentralita() != null) {
            centralita.setId(entity.getCentralita().getId());
            centralita.setNombre(entity.getCentralita().getNombre());
            centralita.setPrecio(entity.getCentralita().getPrecio());
        }

        if(entity.getStreaming() != null) {
            streaming.setId(entity.getStreaming().getId());
            streaming.setNombre(entity.getStreaming().getNombre());
        }

        if(entity.getTarifa() != null) {
            fibra.setId(entity.getFibra().getId());
            fibra.setNombre(entity.getFibra().getNombre());
            fibra.setSobrecargo(entity.getFibra().getSobrecargo());
            
            serviciosAdicionales.setId(entity.getTarifa().getServiciosAdicionales().getId());
            serviciosAdicionales.setRoaming(entity.getTarifa().getServiciosAdicionales().getRoaming());
            serviciosAdicionales.setInternacional(entity.getTarifa().getServiciosAdicionales().getInternacional());
            serviciosAdicionales.setLegalitas(entity.getTarifa().getServiciosAdicionales().isLegalitas());
            serviciosAdicionales.setCloud(entity.getTarifa().getServiciosAdicionales().isCloud());
            serviciosAdicionales.setCiberProteccion(entity.getTarifa().getServiciosAdicionales().isCiberProteccion());
            serviciosAdicionales.setAtencionPersonalizada(entity.getTarifa().getServiciosAdicionales().isAtencionPersonalizada());
            serviciosAdicionales.setCentralita(entity.getTarifa().getServiciosAdicionales().getCentralita());
            serviciosAdicionales.setNumeroBeneficios(entity.getTarifa().getServiciosAdicionales().getNumeroBeneficios());
            serviciosAdicionales.setDescuentoBeneficios(entity.getTarifa().getServiciosAdicionales().getDescuentoBeneficios());
            
            tarifa.setId(entity.getTarifa().getId());
            tarifa.setNombre(entity.getTarifa().getNombre());
            tarifa.setTipo(entity.getTarifa().getTipo());
            tarifa.setLineasMoviles(entity.getTarifa().getLineasMoviles());
            tarifa.setLlamadasMovil(entity.getTarifa().getLlamadasMovil());
            tarifa.setGbMovil(entity.getTarifa().getGbMovil());
            tarifa.setPrecio(entity.getTarifa().getPrecio());
            tarifa.setServiciosAdicionales(serviciosAdicionales);
            tarifa.setTv(entity.getTarifa().isTv());
            tarifa.setStreaming(entity.getTarifa().isStreaming());
        }
        
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setTarifa(tarifa);
        dto.setFibra(fibra);
        dto.setStreaming(streaming);
        dto.setCentralita(centralita);
        dto.setPackFutbol(packFutbol);
        dto.setDescuento(descuento);
        
        return dto;
    }
}
