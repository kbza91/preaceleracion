package com.alkemy.preaceleracion.Entidad;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "continente")
@Data
public class ContinenteEntidad implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String imagen;
    private String denominacion;

    @OneToMany
    private List<CiudadEntidad> ciudades;
    private Boolean habilitado;

}
