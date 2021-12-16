/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bezkoder.springjwt.models;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Gustavo A.
 */

@Entity
@Table(	name = "tema")
public class Tema implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    private String title;

    @Size(max = 255)
    private String description;
    
    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Board idBoard;
    
    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Archivo idArchivo;
    
    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User idUsuario;
    
    public Tema (){}
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
     public Board getBoard() {
        return idBoard;
    }

    public void setBoard(Board idBoard) {
        this.idBoard = idBoard;
    }
    
     public Archivo getArchivo() {
        return idArchivo;
    }

    public void setArchivo(Archivo idArchivo) {
        this.idArchivo = idArchivo;
    }
    
     public User getUser() {
        return idUsuario;
    }

    public void User(User idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    
}
