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
		    String errorMessage= "Por ahora el único autorizado es admin / 123";
		    mav.addObject("errorMsg", errorMessage);
		    mav.setViewName("login");
		    return mav;
    }
}
