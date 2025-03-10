
package com.llacuas.crud.producto;

import com.llacuas.crud.categoria.Categoria;
import com.llacuas.crud.productoDetalles.ProductoDetalles;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length = 128,nullable = false,unique = true)
    private String nombre;
    
    private float precio;
    
    @ManyToOne()
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    
    @OneToMany(mappedBy = "producto",cascade = CascadeType.ALL)
    private List<ProductoDetalles> listaProductoDetalles;

    public Producto() {
    }

    public Producto(int id, String nombre, float precio, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }
    
    public Producto(int id) {
        this.id = id;
       
    }

    public Producto(String nombre) {
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public void añadirDetalles(String nombre,String valor){
        this.listaProductoDetalles.add(new ProductoDetalles(nombre, valor, this));
    }

    public List<ProductoDetalles> getListaProductoDetalles() {
        return listaProductoDetalles;
    }

    public void setListaProductoDetalles(List<ProductoDetalles> listaProductoDetalles) {
        this.listaProductoDetalles = listaProductoDetalles;
    }
    
    public void setDetalles(Integer id,String nombre,String valor){
        this.listaProductoDetalles.add(new ProductoDetalles(id, nombre, valor, this));
    }
    
}
