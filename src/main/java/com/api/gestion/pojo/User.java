package com.api.gestion.pojo;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GeneratedColumn;

import java.io.Serializable;

//CONSULTAS PERSONALIZADAS CON JDBC
@NamedQuery(name = "User.findByEmail", query = "select u from User u where u.email=:email")
@Data
@Entity
@DynamicUpdate
@Table(name = "users")
public class User  {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "numeroDeContacto" )
    private  String numeroDeContacto;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "status")
    private String status;
    @Column(name = "rol")
    private String rol;

}
