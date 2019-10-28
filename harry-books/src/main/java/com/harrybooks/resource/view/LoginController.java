package com.harrybooks.resource.view;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("app")
public class LoginController {
	@GetMapping(value= {"/login", "/"})
	public ModelAndView login() {
		    ModelAndView mav = new ModelAndView();
		    String errorMessage= "Datos incorrecto, por favor ejecute el Script resources/initScript.sql para poblar la base con usuario y libros!";
		    mav.addObject("errorMsg", errorMessage);
		    mav.setViewName("login");
		    return mav;
    }
}
