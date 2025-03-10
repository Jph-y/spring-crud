
package com.llacuas.crud.marca;

import com.llacuas.crud.categoria.Categoria;
import com.llacuas.crud.categoria.CategoriaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MarcaController {
    
    @Autowired
    private CategoriaRepositorio categoriaRepo;
    
    @Autowired
    private MarcaRepository marcaRepo;
    
    @GetMapping("/marcas/nuevo")
    public String mostrarFormularioMarca(Model model){
        List<Categoria> listaCategoria = categoriaRepo.findAll();
        model.addAttribute("listaCategoria", listaCategoria);
        model.addAttribute("marca", new Marca());
        return "marca_formulario";
    }
    
    @PostMapping("/marcas/guardar")
    public String guardarMarca(Marca marca){
        marcaRepo.save(marca);
        return "redirect:/marcas";   
    }
    
    @GetMapping("/marcas")
    public String listarMarcas(Model model){
        List<Marca> listaMarcas = marcaRepo.findAll();
        model.addAttribute("listaMarcas", listaMarcas);
        return "marcas";
    }
    
    @GetMapping("marcas/editar/{id}")
    public String editarMarca(@PathVariable("id") Integer id,Model model){
        List<Categoria> listaCategoria = categoriaRepo.findAll();
        Marca marca = marcaRepo.findById(id).get();
        model.addAttribute("listaCategoria", listaCategoria);
        model.addAttribute("marca", marca);
        return "marca_formulario";
    }
    
}
