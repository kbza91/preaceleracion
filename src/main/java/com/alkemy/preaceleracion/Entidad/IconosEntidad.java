package com.alkemy.preaceleracion.Entidad;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "iconos_geograficos")
@Data
public class IconosEntidad implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String imagen;
    private String denominacion;

    @Column(name = "fecha_creacion")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaDeCreacion;
    private Double altura;
    private String historia;

    @ManyToMany(mappedBy = "iconos", cascade = CascadeType.ALL)
    private List<CiudadEntidad> ciudad = new ArrayList<>();

    private Boolean habilitado;
}
