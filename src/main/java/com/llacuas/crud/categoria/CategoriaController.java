
package com.llacuas.crud.categoria;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CategoriaController {
    
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;
    
    @GetMapping("/categorias")
    public String listarCategorias(Model model){
        List<Categoria> listaCategorias = categoriaRepositorio.findAll();
        model.addAttribute("listaCategorias", listaCategorias);
        return "categorias";
    }
    
    @GetMapping("/categorias/nuevo")
    public String motrarFormularioCategoria(Model model){
        model.addAttribute("categoria", new Categoria());
        return "categorias_formulario";
    }
    
    @PostMapping("/categorias/guardar")
    public String guardarCategoria(Categoria categoria){
        categoriaRepositorio.save(categoria);
        return"redirect:/categorias";
    }
}
