
package com.llacuas.crud.marca;

import com.llacuas.crud.categoria.Categoria;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Marca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length = 45,nullable = false,unique = true)
    private String nombre;
    
    @OneToMany
    @JoinColumn(name = "id_marca")
    private List<Categoria> listaCategoria;

    public Marca() {
    }

    public Marca(int id, String nombre, List<Categoria> listaCategoria) {
        this.id = id;
        this.nombre = nombre;
        this.listaCategoria = listaCategoria;
    }

    public Marca(int id) {
        this.id = id;
    }

    public Marca(String nombre, List<Categoria> listaCategoria) {
        this.nombre = nombre;
        this.listaCategoria = listaCategoria;
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

    public List<Categoria> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }
    
    
}
