
package com.llacuas.crud.producto;

import com.llacuas.crud.categoria.Categoria;
import com.llacuas.crud.categoria.CategoriaRepositorio;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductoController {
    
    @Autowired
    private ProductoRepository productoRepository;
    
    @Autowired
    private CategoriaRepositorio categoriaRepo;
    
    @GetMapping("/productos/nuevo")
    public String mostarFormularioProducto(Model model){
        
        List<Categoria> listaCategorias = categoriaRepo.findAll();
      
        model.addAttribute("producto", new Producto());
        model.addAttribute("listaCategorias", listaCategorias);
        return "producto_formulario";           
    }
    
    @PostMapping("/productos/guardar")
    public String addProducto(Producto producto, HttpServletRequest request){
        productoRepository.save(producto);
        String[] detallesIds = request.getParameterValues("detallesIds");
        String[] detallesNombres = request.getParameterValues("detallesNombres");
        String[] detallesValores = request.getParameterValues("detallesValores");
        
        for (int i = 0; i < detallesNombres.length; i++) {
            if(detallesIds != null && detallesIds.length > 0){
                producto.setDetalles(Integer.valueOf(detallesIds[i]),detallesNombres[i],detallesValores[i]);
            }else{
                producto.añadirDetalles(detallesNombres[i],detallesValores[i]);
            }
        }
        return "redirect:/productos";
    }
    
    @GetMapping("/productos")
    public String listaProductos(Model model){
        List<Producto> listaProductos = productoRepository.findAll();
        model.addAttribute("listaProductos", listaProductos);
        return "productos";
    }
    
    @GetMapping("/productos/editar/{id}")
    public String mostrarFormularioEdit(@PathVariable("id") Integer id,Model model){
        
        Producto producto = productoRepository.findById(id).get();
        model.addAttribute("producto", producto);
        
        List<Categoria> listaCategorias = categoriaRepo.findAll();
         model.addAttribute("listaCategorias", listaCategorias);
         
        return "/producto_formulario";
    }
    
//    @PostMapping("/productos/editarP")
//    public String editarProducto(Producto producto){
//        productoRepository.save(producto);
//        return "/productos";
//    }
//    @PostMapping("/productos/editar/{producto}")
//    public String editarProducto(@PathVariable Producto producto){
//        productoRepository.save(producto);
//        return "/productos";
//    }
    
    @GetMapping("/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") Integer id){
        productoRepository.deleteById(id);
        return "redirect:/productos";
    }
}

