package com.pla8_actividad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {
	@RequestMapping("/")
	public String verPaginaInicio() {
		return "index";
	}
}