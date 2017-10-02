/**
 * 
 */
package com.packt.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Dawid Szyndler
 *
 */
@Controller
public class HomeController {
	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("greeting", "Witaj na stronie wypo�yczalni DSmoto");
		model.addAttribute("tagline", "Znajd� auto dla siebie! Najlepsza obs�uga klienta i du�y wyb�r");
		return "welcome";
	}
	
}
