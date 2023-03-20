package com.suavelomito.bootcamp.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="admin")
public class Admin {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="idusuario")
    private int idusuario;

@Column(name="username")
    private String username;

@Column(name="pass")
    private String pass;

@Column(name="mail")
    private String mail;

}
