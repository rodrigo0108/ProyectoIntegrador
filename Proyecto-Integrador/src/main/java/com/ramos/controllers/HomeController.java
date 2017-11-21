package com.ramos.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.MultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

@Controller
public class HomeController {
	
	public File convert(MultipartFile multipart) throws IllegalStateException, IOException 
	{
	    File convFile = new File( multipart.getOriginalFilename());
	    multipart.transferTo(convFile);
	    return convFile;
	}
	@GetMapping("/home_admin")
	public String home_admin(HttpSession httpSession) {
		Usuario usuario= (Usuario) httpSession.getAttribute("usuario");
		if(usuario!=null) {
			return "home_admin";
		}else {
			//si no esta logueado redirigige a sesion
			return "redirect:sesion";
		}
		
	}
	@GetMapping("/inmuebles_admin")
	public String inmuebles_admin(Model model,HttpSession httpSession) {
		Usuario usuario= (Usuario) httpSession.getAttribute("usuario");
		if(usuario!=null) {
			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,Boolean.TRUE);
			Client client = Client.create(clientConfig);
			WebResource webResourceGet = client.resource(Utils.URL_BASE+"/api/v1/inmuebles");
			List<Inmueble> inmuebles = webResourceGet.get(new GenericType<List<Inmueble>>() {});
			
			model.addAttribute("inmuebles", inmuebles);
			return "inmuebles_admin";
		}else {
			return "redirect:sesion";
		}
		
	}
	@GetMapping("/eliminar_inmueble_admin/{id}")
	public String eliminar_arren2(@PathVariable int id,Model model,HttpSession httpSession) {
		Usuario usuario= (Usuario) httpSession.getAttribute("usuario");
		if(usuario!=null) {
			return "eliminar_inmueble_admin";
		}else {
			//si no esta logueado redirigige a sesion
			return "redirect:sesion";
		}
		
	}
	//Usuario
	@GetMapping("/editar_usuario_admin/{id}")
	public String editar_usuario_admin(@PathVariable int id,Model model,HttpSession httpSession) {
		Usuario usuario= (Usuario) httpSession.getAttribute("usuario");
		if(usuario!=null) {
			return "editar_usuario_admin";
		}else {
			//si no esta logueado redirigige a sesion
			return "redirect:sesion";
		}
		
	}
	@GetMapping("/eliminar_usuario_admin/{id}")
	public String eliminar_usuario_admin(@PathVariable int id,Model model,HttpSession httpSession) {
		Usuario usuario= (Usuario) httpSession.getAttribute("usuario");
		if(usuario!=null) {
			return "eliminar_usuario_admin";
		}else {
			//si no esta logueado redirigige a sesion
			return "redirect:sesion";
		}
	
		
	}
	
	@GetMapping("/centros_admin")
	public String centros_admin(Model model,HttpSession httpSession) {
		Usuario usuario= (Usuario) httpSession.getAttribute("usuario");
		if(usuario!=null) {
			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,Boolean.TRUE);
			Client client = Client.create(clientConfig);
			WebResource webResourceGet = client.resource(Utils.URL_BASE+"/api/v1/centros_educativos");
			List<CentroEducativo> centro_educativos = webResourceGet.get(new GenericType<List<CentroEducativo>>() {});
			
			model.addAttribute("centro_educativos", centro_educativos);
			return "centros_admin";
		}else {
			//si no esta logueado redirigige a sesion
			return "redirect:sesion";
		}
		
		
	}
	@GetMapping("/usuarios_admin")
	public String usuarios_admin(Model model,HttpSession httpSession) {
		Usuario usuario= (Usuario) httpSession.getAttribute("usuario");
		if(usuario!=null) {
			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,Boolean.TRUE);
			Client client = Client.create(clientConfig);
			WebResource webResourceGet = client.resource(Utils.URL_BASE+"/api/v1/usuarios");
			List<Usuario> usuarios = webResourceGet.get(new GenericType<List<Usuario>>() {});
			
			model.addAttribute("usuarios", usuarios);
			
			return "usuarios_admin";
		}else {
			//si no esta logueado redirigige a sesion
			return "redirect:sesion";
		}
		
		
	}
	@GetMapping("/home_arren")
	public String home_arren(Model model,HttpSession httpSession) {
		
		Usuario usuario= (Usuario) httpSession.getAttribute("usuario");
		if(usuario!=null) {
			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,Boolean.TRUE);
			Client client = Client.create(clientConfig);
			WebResource webResourceGet = client.resource(Utils.URL_BASE+"/api/v1/centros_educativos");
			List<CentroEducativo> centros_educativos = webResourceGet.get(new GenericType<List<CentroEducativo>>() {});
			model.addAttribute("lista", centros_educativos);
			
			return "home_arren";
		}else {
			//si no esta logueado redirigige a sesion
			return "redirect:sesion";
		}
		
	}
	
	@PostMapping("/home_arren")
	public String publicar(@RequestParam(value = "imagen")MultipartFile multipart_imagen,
							HttpSession httpSession,
							@RequestParam(value = "tipo_alquiler") String tipo_alquiler,
							@RequestParam(value = "centro_estudio") String centro_estudio_id,
							@RequestParam(value = "direccion") String direccion,
							@RequestParam(value = "distrito")String distrito,
							@RequestParam(value = "departamento")String departamento,
							@RequestParam(value = "precio")String precio,
							@RequestParam(value = "num_dor")String num_dor,
							@RequestParam(value = "num_ban")String num_ban,
							@RequestParam(value = "area")String area_total,
							@RequestParam(value = "descripcion")String descripcion) throws IllegalStateException, IOException {
		File imagen=convert(multipart_imagen);
		Usuario usuario= (Usuario) httpSession.getAttribute("usuario");
		String id=String.valueOf(usuario.getId());
		
		String longitud="-54.251";
		String latitud="15.5155";
		String estado="habilitado";
		
		ClientConfig clientConfig = new DefaultClientConfig();
		
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(Utils.URL_BASE+"/api/v1/inmuebles");
		
        FileDataBodyPart fileDataBodyPart = new FileDataBodyPart("imagen",
                imagen,
                MediaType.APPLICATION_OCTET_STREAM_TYPE);
        fileDataBodyPart.setContentDisposition(
                FormDataContentDisposition.name("imagen")
                        .fileName(imagen.getName()).build());
        
        final MultiPart multiPart = new FormDataMultiPart()
                .field("tipo", tipo_alquiler, MediaType.TEXT_PLAIN_TYPE)
                .field("direccion", direccion, MediaType.TEXT_PLAIN_TYPE)
                .field("distrito", distrito, MediaType.TEXT_PLAIN_TYPE)
                .field("departamento", departamento, MediaType.TEXT_PLAIN_TYPE)
                .field("longitud", longitud, MediaType.TEXT_PLAIN_TYPE)
                .field("latitud", latitud, MediaType.TEXT_PLAIN_TYPE)
                .field("precio", precio, MediaType.TEXT_PLAIN_TYPE)
                .field("num_dormitorios",num_dor, MediaType.TEXT_PLAIN_TYPE)
                .field("num_banios", num_ban, MediaType.TEXT_PLAIN_TYPE)
                .field("area_total", area_total, MediaType.TEXT_PLAIN_TYPE)
                .field("estado", estado, MediaType.TEXT_PLAIN_TYPE)
                .field("descripcion", descripcion, MediaType.TEXT_PLAIN_TYPE)
                .field("usuario_id", id, MediaType.TEXT_PLAIN_TYPE)
                .field("centro_educativo_id", centro_estudio_id, MediaType.TEXT_PLAIN_TYPE)
                .bodyPart(fileDataBodyPart);
        multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);

        // POST request final
        ClientResponse response = webResource
                .type("multipart/form-data").post(ClientResponse.class,
                        multiPart);
        
        client.destroy();
		
		
		return "redirect:list_arren";
	}
	@GetMapping("/logout")  
    public String logout(HttpSession httpSession) {
    	httpSession.removeAttribute("usuario");
        return "redirect:sesion";
    }
	@GetMapping("/perfil_arren")  
	public String perfil_arren(HttpSession httpSession) {
		Usuario usuario= (Usuario) httpSession.getAttribute("usuario");
		if(usuario!=null) {
			return "perfil_arren";
		}else {
			//si no esta logueado redirigige a sesion
			return "redirect:sesion";
		}
		
		
	}
	
	@GetMapping("/list_arren")
	public String list_arren(HttpSession httpSession,Model model) {
		Usuario usuario= (Usuario) httpSession.getAttribute("usuario");
		if(usuario!=null) {
			String id=String.valueOf(usuario.getId());
			
			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,Boolean.TRUE);
			Client client = Client.create(clientConfig);
			WebResource webResourceGet = client.resource(Utils.URL_BASE+"/api/v1/usuarios/"+id+"/inmuebles");
			List<Inmueble> inmuebles = webResourceGet.get(new GenericType<List<Inmueble>>() {});
			
			model.addAttribute("inmuebles", inmuebles);
			
			return "list_arren";
		}else {
			//si no esta logueado redirigige a sesion
			return "redirect:sesion";
		}
		
		
	}
	
	@GetMapping("/editar_inmueble_arren/{id}")
	public String editar_arren(@PathVariable int id,Model model,Model model2,HttpSession httpSession) {
		Usuario usuario= (Usuario) httpSession.getAttribute("usuario");
		if(usuario!=null) {
			String id_con=String.valueOf(id);
			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,Boolean.TRUE);
			Client client = Client.create(clientConfig);
			WebResource webResourceGet = client.resource(Utils.URL_BASE+"/api/v1/inmuebles/"+id_con);
			ClientResponse response  = webResourceGet.accept("application/json").get(ClientResponse.class);
			Inmueble inmueble1= response.getEntity(Inmueble.class);

			ClientConfig clientConfig2 = new DefaultClientConfig();
			clientConfig2.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,Boolean.TRUE);
			Client client2 = Client.create(clientConfig2);
			WebResource webResourceGet2 = client2.resource(Utils.URL_BASE+"/api/v1/centros_educativos");
			List<CentroEducativo> centros_educativos = webResourceGet2.get(new GenericType<List<CentroEducativo>>() {});
			
			model.addAttribute("inm",inmueble1);
			model2.addAttribute("lista",centros_educativos);
			
			System.out.println(centros_educativos.toString());
			System.out.println(inmueble1.toString());
			return "editar_inmueble_arren";
		}else {
			//si no esta logueado redirigige a sesion
			return "redirect:sesion";
		}
		
	}
	@GetMapping("/eliminar_inmueble_arren/{id}")
	public String eliminar_arren(@PathVariable int id,Model model,HttpSession httpSession) {
		Usuario usuario= (Usuario) httpSession.getAttribute("usuario");
		if(usuario!=null) {
			return "eliminar_inmueble_arren";
		}else {
			//si no esta logueado redirigige a sesion
			return "redirect:sesion";
		}
		
		
		
	}
}
