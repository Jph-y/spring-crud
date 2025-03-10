
package com.llacuas.crud.productoDetalles;

import com.llacuas.crud.producto.Producto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductoDetalles {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length = 128,nullable = false,unique = true)
    private String nombre;
    
    @Column(length = 128,nullable = false,unique = true)
    private String valor;
    
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    public ProductoDetalles() {
    }

    public ProductoDetalles(int id, String nombre, String valor, Producto producto) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
        this.producto = producto;
    }

    public ProductoDetalles(int id) {
        this.id = id;
    }

    public ProductoDetalles(String nombre, String valor, Producto producto) {
        this.nombre = nombre;
        this.valor = valor;
        this.producto = producto;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Producto getDetalles() {
        return producto;
    }

    public void setDetalles(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return nombre + " " + valor;
    }
    
    
}
