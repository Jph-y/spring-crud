
package com.llacuas.crud.categoria;

import com.llacuas.crud.marca.Marca;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length = 45,nullable = false,unique = true)
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca marca;

    public Categoria() {
    }

    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Categoria(int id, String nombre, Marca marca) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
    }

    public Categoria(String nombre, Marca marca) {
        this.nombre = nombre;
        this.marca = marca;
    }
    

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
    
    
    public Categoria(int id) {
        this.id = id;
    }
    
    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
