package me.hjava.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import me.hjava.entity.Konyv;
import me.hjava.service.IKonyvService;

@Controller
@RequestMapping("konyvtar")
public class KonyvController {
	@Autowired
	private IKonyvService konyvService;
	@GetMapping("konyv/{id}")
	public ResponseEntity<Konyv> getKonyvById(@PathVariable("id") Integer id) {
		Konyv konyv = konyvService.getKonyvById(id);
		return new ResponseEntity<Konyv>(konyv, HttpStatus.OK);
	}
	@GetMapping("konyvek")
	public ResponseEntity<List<Konyv>> getAllKonyv() {
		List<Konyv> list = konyvService.getAllKonyv();
		return new ResponseEntity<List<Konyv>>(list, HttpStatus.OK);
	}
	@PostMapping("konyv")
	public ResponseEntity<Void> createKonyv(@RequestBody Konyv konyv, UriComponentsBuilder builder) {
        boolean flag = konyvService.createKonyv(konyv);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/konyv/{id}").buildAndExpand(konyv.getK_id()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("konyv")
	public ResponseEntity<Konyv> updateKonyv(@RequestBody Konyv konyv) {
		konyvService.updateKonyv(konyv);
		return new ResponseEntity<Konyv>(konyv, HttpStatus.OK);
	}
	@DeleteMapping("konyv/{id}")
	public ResponseEntity<Void> deleteKonyv(@PathVariable("id") Integer id) {
		konyvService.deleteKonyv(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 