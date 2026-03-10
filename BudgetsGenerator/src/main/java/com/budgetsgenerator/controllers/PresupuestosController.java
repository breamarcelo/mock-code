package com.budgetsgenerator.controllers;

import java.util.ArrayList;
import java.util.List;

import com.budgetsgenerator.dto.CentralitasDTO;
import com.budgetsgenerator.dto.DescuentosDTO;
import com.budgetsgenerator.dto.LineasAdicionalesDTO;
import com.budgetsgenerator.dto.PacksFutbolDTO;
import com.budgetsgenerator.dto.ServiciosAdicionalesDTO;
import com.budgetsgenerator.dto.TarifasDTO;
import com.budgetsgenerator.models.CentralitasEntity;
import com.budgetsgenerator.models.DescuentosEntity;
import com.budgetsgenerator.models.LineasAdicionalesEntity;
import com.budgetsgenerator.models.PacksFutbolEntity;
import com.budgetsgenerator.models.ServiciosAdicionalesEntity;
import com.budgetsgenerator.models.TarifasEntity;
import com.budgetsgenerator.repository.impl.CentralitasDAO;
import com.budgetsgenerator.repository.impl.DescuentosDAO;
import com.budgetsgenerator.repository.impl.LineasAdicionalesDAO;
import com.budgetsgenerator.repository.impl.PackFutbolDAO;
import com.budgetsgenerator.repository.impl.ServiciosAdicionalesDAO;
import com.budgetsgenerator.repository.impl.TarifasDAO;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;

public class PresupuestosController {
    private GridPane view;
    private TarifasDAO tarifasDAO;
    private ServiciosAdicionalesDAO serviciosAdicionalesDAO;
    private LineasAdicionalesDAO lineasAdicionalesDAO;
    private DescuentosDAO descuentosDAO;
    private CentralitasDAO centralitasDAO;
    private PackFutbolDAO packFutbolDAO;

    public PresupuestosController(GridPane view) {
        this.view = view;
        this.tarifasDAO = new TarifasDAO(TarifasEntity.class);
        this.serviciosAdicionalesDAO = new ServiciosAdicionalesDAO(ServiciosAdicionalesEntity.class);
        this.lineasAdicionalesDAO = new LineasAdicionalesDAO(LineasAdicionalesEntity.class);
        this.descuentosDAO = new DescuentosDAO(DescuentosEntity.class);
        this.centralitasDAO = new CentralitasDAO(CentralitasEntity.class);
        this.packFutbolDAO = new PackFutbolDAO(PacksFutbolEntity.class);

        ComboBox<TarifasDTO> tarifasCombo = new ComboBox<>();
        ComboBox<String> fibraCombo = new ComboBox<>();
        ComboBox<String> streamingCombo = new ComboBox<>();
        ComboBox<LineasAdicionalesDTO> lineasAdicionalesCombo = new ComboBox<>();
        ComboBox<DescuentosDTO> descuentoCombo = new ComboBox<>();
        ComboBox<CentralitasDTO> centralitaCombo = new ComboBox<>();
        ComboBox<PacksFutbolDTO> packsFutbolCombo = new ComboBox<>();
        
        
        List<TarifasDTO> tarifas = getTarifas();
        for(TarifasDTO tarifa : tarifas) {
            tarifasCombo.getItems().add(tarifa);
        }

        List<LineasAdicionalesDTO> lineasAdicionales = getLineasAdicionales();
        for(LineasAdicionalesDTO lineaAdicional : lineasAdicionales) {
            lineasAdicionalesCombo.getItems().add(lineaAdicional);
        }

        List<DescuentosDTO> descuentos = getDecuentos();
        for(DescuentosDTO descuento :  descuentos) {
            descuentoCombo.getItems().add(descuento);
        }

        List<CentralitasDTO> centralitas = getCentralitas();
        for(CentralitasDTO centralita : centralitas) {
            centralitaCombo.getItems().add(centralita);
        }

        List<PacksFutbolDTO> packsFutbol = getPacksFutbol();
        for(PacksFutbolDTO packFutbol : packsFutbol) {
            packsFutbolCombo.getItems().add(packFutbol);
        }
        
        tarifasCombo.setConverter(new StringConverter<TarifasDTO>() {
            @Override
            public String toString(TarifasDTO object) {
                return object == null ? "" : object.getNombre();
            }
            @Override
            public TarifasDTO fromString(String string) {
                return null;
            }
        });

        lineasAdicionalesCombo.setConverter(new StringConverter<LineasAdicionalesDTO>() {
            @Override
            public String toString(LineasAdicionalesDTO object) {
                return object == null ? "" : object.getNombre();
            }
            @Override
            public LineasAdicionalesDTO fromString(String string) {
                return null;
            }
        });

        descuentoCombo.setConverter(new StringConverter<DescuentosDTO>() {
            @Override
            public String toString(DescuentosDTO object) {
                return object == null ? "" : object.getPorciento() + "%";
            }
            @Override
            public DescuentosDTO fromString(String string) {
                return null;
            }
        });

        centralitaCombo.setConverter(new StringConverter<CentralitasDTO>() {
            @Override
            public String toString(CentralitasDTO object) {
                return object == null ? "" : object.getNombre();
            }
            @Override
            public CentralitasDTO fromString(String string) {
                return null;
            }
        });

        packsFutbolCombo.setConverter(new StringConverter<PacksFutbolDTO>() {
            @Override
            public String toString(PacksFutbolDTO object) {
                return object == null ? "" : object.getNombre();
            }
            @Override
            public PacksFutbolDTO fromString(String string) {
                return null;
            }
        });

        streamingCombo.setDisable(true);
        streamingCombo.getItems().addAll("Amazon Prime", "Disney+", "Netflix");
        tarifasCombo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            fibraCombo.getItems().clear();
            fibraCombo.getItems().addAll(newValue.getOpcionFibra1(), newValue.getOpcionFibra2() + " (+" + newValue.getSobrecargoFibra() + "€)");
            streamingCombo.setDisable(!newValue.isStreaming());
        });


        this.view.add(tarifasCombo, 0, 2, 2, 1);
        this.view.add(fibraCombo, 0, 4, 1, 1);
        this.view.add(streamingCombo, 1, 4, 1, 1);
        this.view.add(lineasAdicionalesCombo, 0, 6, 2, 1);
        this.view.add(descuentoCombo, 3, 2, 1, 1);
        this.view.add(centralitaCombo, 2, 4, 2, 1);
        this.view.add(packsFutbolCombo, 2, 6, 2, 1);
    }

    public ServiciosAdicionalesDTO mapServiciosAdicionalesToDTO(ServiciosAdicionalesEntity entity) {
        ServiciosAdicionalesDTO dto = new ServiciosAdicionalesDTO();
        dto.setId(entity.getId());
        dto.setRoaming(entity.getRoaming());
        dto.setLegalitas(entity.isLegalitas());
        dto.setCloud(entity.isCloud());
        dto.setCiberProteccion(entity.isCiberProteccion());
        dto.setAtencionPersonalizada(entity.isAtencionPersonalizada());
        dto.setCentralita(entity.getCentralita());
        dto.setNumBeneficios(entity.getNumBeneficios());
        dto.setDescuentoBeneficios(entity.getDescuentoBeneficios());
        return dto;
    }

    public TarifasDTO mapTarifasToDTO(TarifasEntity entity) {
        TarifasDTO dto = new TarifasDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setTipo(entity.getTipo());
        dto.setLineasMoviles(entity.getLineasMoviles());
        dto.setLlamadasMovil(entity.getLlamadasMovil());
        dto.setGbMovil(entity.getGbMovil());
        dto.setOpcionFibra1(entity.getOpcionFibra1());
        dto.setOpcionFibra2(entity.getOpcionFibra2());
        dto.setSobrecargoFibra(entity.getSobrecargoFibra());
        dto.setPrecio(entity.getPrecio());
        dto.setServiciosAdicionales(mapServiciosAdicionalesToDTO(entity.getServiciosAdicionales()));
        dto.setTv(entity.isTv());
        dto.setStreaming(entity.isStreaming());
        return dto;
    }

    public LineasAdicionalesDTO mapLineasAdicionalesToDTO(LineasAdicionalesEntity entity){
        LineasAdicionalesDTO dto = new LineasAdicionalesDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setTipo(entity.getTipo());
        dto.setNumLineas(entity.getNumLineas());
        dto.setLlamadas(entity.getLlamadas());
        dto.setGb(entity.getGb());
        dto.setFibra(entity.getFibra());
        dto.setPrecio(entity.getPrecio());
        return dto;
    }

    public DescuentosDTO mapDescuentosToDTO(DescuentosEntity entity) {
        DescuentosDTO dto = new DescuentosDTO();
        dto.setId(entity.getId());
        dto.setPorciento(entity.getPorciento());
        return dto;
    }

    public CentralitasDTO mapCentralitasToDTO(CentralitasEntity entity) {
        CentralitasDTO dto = new CentralitasDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setPrecio(entity.getPrecio());
        return dto;
    }

    public PacksFutbolDTO mapPacksFutbolToDTO(PacksFutbolEntity entity) {
        PacksFutbolDTO dto = new PacksFutbolDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setPrecio(entity.getPrecio());
        return dto;
    }

    public List<TarifasDTO> getTarifas(){
        List<TarifasEntity> tarifasEntities = tarifasDAO.findall();
        List<TarifasDTO> tarifasDTOs = new ArrayList<>();
        for(TarifasEntity tarifaEntity : tarifasEntities) {
            tarifasDTOs.add(mapTarifasToDTO(tarifaEntity));
        }
        return tarifasDTOs;
    }

    public List<LineasAdicionalesDTO> getLineasAdicionales() {
        List<LineasAdicionalesEntity> lineasAdicionalesEntities = lineasAdicionalesDAO.findall();
        List<LineasAdicionalesDTO> lineasAdicionalesDTOs = new ArrayList<>();
        for(LineasAdicionalesEntity lineaAdicionalEntity : lineasAdicionalesEntities) {
            lineasAdicionalesDTOs.add(mapLineasAdicionalesToDTO(lineaAdicionalEntity));
        }
        return lineasAdicionalesDTOs;
    }

    public List<DescuentosDTO> getDecuentos() {
        List<DescuentosEntity> descuentosEntities = descuentosDAO.findall();
        List<DescuentosDTO> descuentosDTOs = new ArrayList<>();
        for(DescuentosEntity descuentoEntity : descuentosEntities) {
            descuentosDTOs.add(mapDescuentosToDTO(descuentoEntity));
        }
        return descuentosDTOs;
    }

    public List<CentralitasDTO> getCentralitas() {
        List<CentralitasEntity> centralitasEntities = centralitasDAO.findall();
        List<CentralitasDTO> centralitasDTOs = new ArrayList<>();
        for(CentralitasEntity centralitasEntity : centralitasEntities) {
            centralitasDTOs.add(mapCentralitasToDTO(centralitasEntity));
        }
        return centralitasDTOs;
    }

    public List<PacksFutbolDTO> getPacksFutbol() {
        List<PacksFutbolEntity> packsFutbolEntities = packFutbolDAO.findall();
        List<PacksFutbolDTO> packsFutbolDTOs = new ArrayList<>();
        for(PacksFutbolEntity packFutbolEntity : packsFutbolEntities) {
            packsFutbolDTOs.add(mapPacksFutbolToDTO(packFutbolEntity));
        }
        return packsFutbolDTOs;
    }
}
