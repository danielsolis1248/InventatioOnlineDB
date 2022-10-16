package com.iunis.adventclub.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "userpassword")
    private String userpassword;


    @JoinColumn(name = "idstatus", referencedColumnName = "id")
    @ManyToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    private Status status;

    @JoinColumn(name = "iddatospersonales", referencedColumnName = "id")
    @ManyToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    private DatosPersonales datosPersonales;

    /**
     * Relacion de muchos a muchos con la tabla roles por medio de una
     * tabla intermedia roles_usuarios que no esta mapeada como entity
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "roles_usuarios", joinColumns = @JoinColumn(name = "idusuario"), inverseJoinColumns = @JoinColumn(name = "idrol"))
    private Set<Rol> rol;



    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", usuario='" + username + '\'' +
                ", password='" + userpassword + '\'' +
                ", status=" + status +
                ", rol=" + rol +
                '}';
    }
}
