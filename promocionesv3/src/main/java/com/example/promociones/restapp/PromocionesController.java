package com.example.promociones.restapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.promociones.dto.PromocionDTO;
import com.example.promociones.entity.Promocion;
import com.example.promociones.repository.PromocionRepository;

@RestController
public class PromocionesController {
	
	@Autowired
	private PromocionRepository prepository;
	
	@GetMapping(path="approm/retrieveAll")
	public ResponseEntity<List<Promocion>> retrieveAll(){
		List<Promocion> promociones = prepository.findAll();
		if (promociones.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	    }
		return new ResponseEntity<>(promociones, HttpStatus.OK);
	}
	
	@GetMapping(path="approm/searchByIdProduct/{idProduct}")
	public ResponseEntity<List<Promocion>> searchByIdProduct(@PathVariable Integer idProduct) {
		List<Promocion> promociones = prepository.findByIdProducto(idProduct);
		if (promociones.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	    }
		return new ResponseEntity<>(promociones, HttpStatus.OK);
	}
	
	@GetMapping(path="approm/searchByIdProductAndActiva/{idProduct}")
	public ResponseEntity<List<Promocion>> searchByIdProductAndActiva(@PathVariable Integer idProduct) {
		List<Promocion> promociones = prepository.findByIdProductoAndActivo(idProduct, true);
		if (promociones.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	    }
		return new ResponseEntity<>(promociones, HttpStatus.OK);
	}
	
	@PostMapping(path="approm/create")
	public ResponseEntity<Promocion> create(@RequestBody PromocionDTO promocion) {
		try {
			Promocion createdPromocion = prepository.save(new Promocion(promocion.getIdProducto(),
				promocion.getPorcentaje(),promocion.getDescripcion(),promocion.getActiva()));
			return new ResponseEntity<>(createdPromocion, HttpStatus.CREATED);
		}catch(Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path="approm/update/{idPromocion}")
	public ResponseEntity<Promocion> update(@PathVariable Integer idPromocion, @RequestBody PromocionDTO promocion){
		Optional<Promocion> promocionData = prepository.findById(idPromocion);
		if(promocionData.isPresent()) {
			Promocion modifiedPromocion = promocionData.get();
			modifiedPromocion.setIdProducto(promocion.getIdProducto());
			modifiedPromocion.setDescripcion(promocion.getDescripcion());
			modifiedPromocion.setPorcentaje(promocion.getPorcentaje());
			modifiedPromocion.setActivo(promocion.getActiva());
			try {
				prepository.save(modifiedPromocion);
				return new ResponseEntity<>(modifiedPromocion, HttpStatus.OK);
			}catch(Exception ex) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
}
