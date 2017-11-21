package com.ramos.controllers;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ramos.models.Usuario;
import com.ramos.utils.Utils;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.MultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;


@Controller
public class IndexController {
	
	public File convert(MultipartFile multipart) throws IllegalStateException, IOException 
	{
	    File convFile = new File( multipart.getOriginalFilename());
	    multipart.transferTo(convFile);
	    return convFile;
	}
	
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
	@GetMapping("/nosotros")
	public String nosotros() {

		return "nosotros";
	}
	
	@GetMapping("/registrarse")
	public String registrarse() {

		return "registrarse";
	}
	
	@PostMapping("/registrarse")
	public String registro(@RequestParam(value = "imagen")MultipartFile multipart_imagen,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "nombres") String nombres,
			@RequestParam(value = "apellidos") String apellidos,
			@RequestParam(value = "username") String username,
			@RequestParam(value = "correo")String correo,
			@RequestParam(value = "telefono")String telefono) throws IllegalStateException, IOException {
		
			File imagen=convert(multipart_imagen);
			String tipo="arren";
			String estado="Habilitado";
			
			ClientConfig clientConfig = new DefaultClientConfig();
		
				Client client = Client.create(clientConfig);
					WebResource webResource = client.resource(Utils.URL_BASE+"/api/v1/usuarios");
		
					FileDataBodyPart fileDataBodyPart = new FileDataBodyPart("imagen",imagen,MediaType.APPLICATION_OCTET_STREAM_TYPE);
					fileDataBodyPart.setContentDisposition(
							FormDataContentDisposition.name("imagen")
							.fileName(imagen.getName()).build());
        
        final MultiPart multiPart = new FormDataMultiPart()
        		.field("password", password, MediaType.TEXT_PLAIN_TYPE)
                .field("username", username, MediaType.TEXT_PLAIN_TYPE)
                .field("nombres", nombres, MediaType.TEXT_PLAIN_TYPE)
                .field("apellidos", apellidos, MediaType.TEXT_PLAIN_TYPE)
                .field("correo", correo, MediaType.TEXT_PLAIN_TYPE)
                .field("tipo", tipo, MediaType.TEXT_PLAIN_TYPE)
                .field("telefono",telefono, MediaType.TEXT_PLAIN_TYPE)
                .field("estado", estado, MediaType.TEXT_PLAIN_TYPE)
                .bodyPart(fileDataBodyPart);
        multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);

        // POST request final
        ClientResponse response = webResource
                .type("multipart/form-data").post(ClientResponse.class,
                        multiPart);
        
        client.destroy();
        
		return "redirect:sesion";
		
	}

}
