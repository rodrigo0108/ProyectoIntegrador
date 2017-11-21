package com.ramos.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ramos.models.CentroEducativo;
import com.ramos.models.Inmueble;
import com.ramos.models.Usuario;
import com.ramos.utils.Utils;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

@Controller
public class EmpiezaController {
	
	@GetMapping("/empieza")
	public String empieza(Model model) {
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResourceGet = client.resource(Utils.URL_BASE+"/api/v1/centros_educativos");
		List<CentroEducativo> centros_educativos = webResourceGet.get(new GenericType<List<CentroEducativo>>() {});
		
		model.addAttribute("lista", centros_educativos);
		return "empieza";
	}
	
	@GetMapping("/vista/{id}")
	public String vista(@PathVariable int id,Model model) {
		String id_con=String.valueOf(id);
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResourceGet = client.resource(Utils.URL_BASE+"/api/v1/centros_educativos/"+id_con+"/inmuebles");
		List<Inmueble> inmuebles = webResourceGet.get(new GenericType<List<Inmueble>>() {});
		
		model.addAttribute("lista2", inmuebles);
		return "vista";
	}
	
	@GetMapping("vista/vista2/{id}")
	public String vista2(@PathVariable int id,Model model,Model model2) {
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResourceGet = client.resource(Utils.URL_BASE+"/api/v1/inmuebles/"+id);
		ClientResponse response  = webResourceGet.accept("application/json").get(ClientResponse.class);
		Inmueble inmueble= response.getEntity(Inmueble.class);
		String id_usuario=String.valueOf(inmueble.getUsuario_id());
		/***********************/
		ClientConfig clientConfig2 = new DefaultClientConfig();
		clientConfig2.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,Boolean.TRUE);
		Client client2 = Client.create(clientConfig2);
		WebResource webResourceGet2 = client2.resource(Utils.URL_BASE+"/api/v1/usuarios/"+id_usuario);
		ClientResponse response2  = webResourceGet2.accept("application/json").get(ClientResponse.class);
		Usuario usuario= response2.getEntity(Usuario.class);
		
		
		model.addAttribute("inmueble",inmueble);
		model2.addAttribute("usuario",usuario);
		return "vista2";
	}
	
}
