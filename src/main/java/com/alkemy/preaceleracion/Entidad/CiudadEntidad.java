package com.alkemy.preaceleracion.Entidad;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ciudad")
@Data
public class CiudadEntidad implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String imagen;
    private String denominacion;

    @Column(name = "num_habitantes")
    private Long numHabitantes;
    private Double supTotal;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "continente_id", insertable = false, updatable = false)
    private ContinenteEntidad continente;

    @Column(name = "continente_id")
    private String continenteId;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "icono_ciudad",
                joinColumns = @JoinColumn(name = "pais_id"),
                inverseJoinColumns = @JoinColumn(name = "icono_id"))
    private List<IconosEntidad> iconos = new ArrayList<>();
    private Boolean habilitado;

}
