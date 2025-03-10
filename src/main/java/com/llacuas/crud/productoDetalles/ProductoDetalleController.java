
package com.llacuas.crud.productoDetalles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductoDetalleController {
    
    @Autowired
    public ProductDetallesRepository productDetallesRepo;
    
    
}
