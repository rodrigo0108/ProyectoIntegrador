package com.ramos.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ramos.models.UserLog;
import com.ramos.models.Usuario;
import com.ramos.utils.Utils;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

@Controller
public class SesionController {
	
	@GetMapping("/sesion")
	public String sesion() {

		return "sesion";
	}
	
	@PostMapping("/sesion")
	public String ingresar(@RequestParam(value = "username") String username,
						   @RequestParam(value = "password") String password,
						   HttpSession session,
						   Model model) {
		
		//Inicialización de un objeto de envio
		UserLog userlog= new UserLog();
		
			userlog.setUsername(username);
			userlog.setPassword(password);
			
		ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(Utils.URL_BASE+"/api/v1/login");
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class,userlog);
			
			if(response.getStatus()==200) {
				Usuario usuario= response.getEntity(Usuario.class);
				
				session.setAttribute("usuario", usuario);
				if(usuario.getTipo().equals("admin")) {
					
					return "redirect:home_admin";
					
				}else {
					return "redirect:home_arren";
				}
				
			}else if(response.getStatus()==401){
				model.addAttribute("error", "Credenciales incorrectos");
				return "sesion";
			}else {
				return "redirect:sesion";
			}
		
	}
}
