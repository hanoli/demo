package com.example.demo.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Imagen;
import com.example.demo.services.FileService;
import com.example.demo.services.ImagenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/api")
@Api
public class ImagenesRestController {
	
	@Autowired
    ImagenService imagenService;
	
	
	/*@Autowired
    FileService fileService;
	
	@ApiOperation(value = "getFolios", notes = "Obtiene todos los folios generados")
	@GetMapping("/listaFolios")
	public List<Folio> getFolios(){
		return folioService.getLista();
	}
	
	
	
	@ApiOperation(value = "getFolios", notes = "Obtiene todos los folios Aprobados")
	@GetMapping("/listaFoliosAprobados")
	public List<FoliosAprobados> getFoliosAprobados(){
		return folioService.getListaAprobados();
	}
	
	@ApiOperation(value = "getFolioById", notes = "Obtiene un solo folio de la Base de Datos por su Id")
	@GetMapping("/idFolio/{id}")
	public ResponseEntity<?> getFolioById(@PathVariable Long id){
		Folio folio = folioService.folioId(id);
		
		Map<String,Object> response = new HashMap<>();
		
		if(folio == null) {
			response.put("mensaje", "El Id de folio no existe");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(folio, HttpStatus.OK); 
	}
	
	@ApiOperation(value = "guardaFolio", notes = "Guarda un folio en la BD")
	@PostMapping("/guardarFolio")
	public ResponseEntity<?> guardaFolio(@RequestBody Folio folio ) {
			
		
		Map<String,Object> response = new HashMap<>();
		
		try {
			folioService.guardaFolio(folio);	
		}catch (Exception e) {
			response.put("mensaje", "Hubo un problema al guardar el folio");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El folio se guardo con exito");
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
		
	}
	
	
	
	@ApiOperation(value = "Eliminar", notes = "Elimina un Folio en la BD")
	@DeleteMapping("/eliminarFolio/{id}")
	public void eliminar(@PathVariable Long id) {
		
		folioService.Eliminar(id);
		
	}
	
	
	
	
	
	
	 @PostMapping("/upload")
	// public ResponseEntity<FileMessage> uploadFiles(@RequestParam("files")MultipartFile[] files){
	 public ResponseEntity<FileMessage> uploadFiles(@RequestBody FileDTO file){
	        String message = "";
	        
	        byte[] fileBytes = Base64.getDecoder().decode(file.getBase64());
	        String decodedFile = new String(fileBytes);
	        System.out.println("Archivo " + file.getNameFile() + " se subio con exito");
	        
	  
	        try{
	        	
	        	
	        	
	            List<String> fileNames = new ArrayList<>();

	            Arrays.asList(file.getNameFile()).stream().forEach(arch->{
	                fileNames.add(arch);
	            });

	            message = "100";
	            return ResponseEntity.status(HttpStatus.OK).body(new FileMessage(message));
	        }catch (Exception e){
	            message = "-1";
	            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new FileMessage(message));
	        }
	    }
	
	
     
	 @ApiOperation(value = "getEndFolio", notes = "Obtiene el ultimo folio generado")
		@GetMapping("/getEndFolio")
		public Integer getEndFolio(){
			return folioService.getEndFolio();
		}*/
	 
	
	
	 @ApiOperation(value = "getImagenByFolio", notes = "Obtiene imagen por folio")
		@GetMapping("/getImagenByFolio/{folio}")
		public ResponseEntity<?>  getImagenByFolio(@PathVariable String folio){
			
		 List<Imagen> imagen = imagenService.getImagenByFolio(folio);
			
			Map<String,Object> response = new HashMap<>();
			
			/*if(folio == null) {
				response.put("mensaje", "La marca no existe");
				return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
			}*/
			
			return new ResponseEntity(imagen, HttpStatus.OK);
		}
	 
	 
	 	/*@PostMapping("/folios/getFiltros")
	    public ResponseEntity<?> getFiltros(@RequestBody FolioDTO folioDTO) {

	 		System.out.println("FechaInicio in controller: " + folioDTO.getFechaInicio());
	 		
	        Map<String,Object> response = new HashMap<>();

	        List<Folio> result = folioService.getByFiltros(folioDTO);

	        if(result.isEmpty()) {
	            response.put("mensaje", "No se encontraron resultados");
	            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
	        }

	          return new ResponseEntity(result,HttpStatus.OK);

	    }
	 	
	 	
	 	@ApiOperation(value = "recibeFolios", notes = "recibe folios seleccionados")
		@PostMapping("/foliosSelect")
		public ResponseEntity<?> foliosSelect(@RequestBody List<Folio> folio ) {
				
	 		System.out.println("El folio se recibio con exito " + folio.size());
	 		
	 		List<FoliosAprobados> folios = new ArrayList<>();
	 		Map<String,Object> response = new HashMap<>();
			
			try {
				
				for (Folio dataFolio : folio) {
					FoliosAprobados foliosAprobados = new FoliosAprobados();
					System.out.println(dataFolio.getFolio());
					System.out.println(dataFolio.getMarca());
					System.out.println(dataFolio.getModelo());
					System.out.println(dataFolio.getNumSerie());
					System.out.println(dataFolio.getTipoEquipo());
					System.out.println(dataFolio.getFecha());
					System.out.println(dataFolio.getCliente().getId());
					
					foliosAprobados.setFolio(dataFolio.getFolio());
					foliosAprobados.setMarca(dataFolio.getMarca());
					foliosAprobados.setModelo(dataFolio.getModelo());
					foliosAprobados.setNumSerie(dataFolio.getNumSerie());
					foliosAprobados.setTipoEquipo(dataFolio.getTipoEquipo());
					foliosAprobados.setFecha(dataFolio.getFecha());
					foliosAprobados.setCliente(1);
					foliosAprobados.setEstatus(0);
					
					folios.add(foliosAprobados);
					
					//folioService.guardaFolioAprobado(foliosAprobados);
				}
				
				for (FoliosAprobados dataFolioAproba : folios) {
					System.out.println("dataFolioAproba.getFolio: " + dataFolioAproba.getFolio());
					System.out.println("dataFolioAproba.getMarca: " + dataFolioAproba.getMarca());
					System.out.println("dataFolioAproba.getModelo: " + dataFolioAproba.getModelo());
					System.out.println("dataFolioAproba.getNumSerie: " + dataFolioAproba.getNumSerie());
					System.out.println("dataFolioAproba.getTipoEquipo: " + dataFolioAproba.getTipoEquipo());
					System.out.println("dataFolioAproba.getFecha: " + dataFolioAproba.getFecha());
					System.out.println("dataFolioAproba.getCliente: " + dataFolioAproba.getCliente());
					System.out.println("dataFolioAproba.getEstatus: " + dataFolioAproba.getEstatus());
					
					folioService.guardaFolioAprobado(dataFolioAproba);
				}
				
				
				//folioService.guardaFolioAprobado(folio);	
			}catch (Exception e) {
				response.put("mensaje", "Hubo un problema al guardar el folio");
				return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			response.put("mensaje", "Exito al guardar folios");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
			
		}*/
	
	
}
