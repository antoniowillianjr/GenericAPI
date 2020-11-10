package br.com.antonio.dockerBuild.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.antonio.dockerBuild.data.vo.GenericTransactionVO;
import br.com.antonio.dockerBuild.exception.FieldNotFoundResponse;
import br.com.antonio.dockerBuild.services.GenericInformationsServices;

@RestController
@RequestMapping(value="/api/v1/generic")
public class GenericInformationsController {
	
	@Autowired
	private GenericInformationsServices services;
	
	
	@PostMapping(value = "/partner", consumes = { "application/json"}, produces = { "application/json" })
	public ResponseEntity<?> partnerMock3(@RequestBody GenericTransactionVO gen)
	{
		JSONObject json = new JSONObject(gen);
		if (!json.isNull("partnerId")) {
			GenericTransactionVO generic = services.responsePartners2(gen);
			return new ResponseEntity<>(generic, HttpStatus.OK);			
		}else
		{
			throw new FieldNotFoundResponse("Field 'partnerId' is mandatory and not nullable");
		}		
	}
	

}
