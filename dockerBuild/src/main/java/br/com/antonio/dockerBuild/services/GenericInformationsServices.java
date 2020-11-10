package br.com.antonio.dockerBuild.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.antonio.dockerBuild.data.vo.GenericInformationsVO;
import br.com.antonio.dockerBuild.data.vo.GenericTransactionVO;
import br.com.antonio.dockerBuild.exception.ArrayTooLargeResponse;
import br.com.antonio.dockerBuild.exception.FieldNotFoundResponse;

@Service
public class GenericInformationsServices {

	private final AtomicLong counter = new AtomicLong();

//*****************************************************************************************************************************************	
	//// Partners2 -- Testes Post com bodyRequest e Rotas e Response Personalizado
	public GenericTransactionVO responsePartners2(GenericTransactionVO gen) {
		JSONObject json = new JSONObject(gen);
		String p = json.getString("partnerId");

		switch (p) {
		case "1": {
			GenericTransactionVO gen2 = mockGenericResponse1(gen);

			return gen2;
		}
		case "2": {
			GenericTransactionVO gen2 = mockGeneric2(gen);

			return gen2;
		}
		default: {
			throw new FieldNotFoundResponse("Partner ID not found");
		}

		}

	}

// MOCK PARTNER_ID ================= 1
	// MockGeneric Response Personalizado
	private GenericTransactionVO mockGenericResponse1(GenericTransactionVO gen) {
		GenericTransactionVO gg = new GenericTransactionVO();
		gg.setTransactionStatus("Status da Transação: " + HttpStatus.OK.value());
		JSONObject json = new JSONObject(gen);
		JSONArray jgen = json.getJSONArray("generic");

		List<GenericInformationsVO> aa = new ArrayList<GenericInformationsVO>();

		for (int i = 0; i < jgen.length(); i++) {

			GenericInformationsVO bb = mockGenericResponse1_1(i, gen);
			aa.add(bb);
		}
		gg.setGeneric(aa);
		return gg;
	}

	// MockGeneric List generic
	// mock opcao 01
	private GenericInformationsVO mockGenericResponse1_1(int i, GenericTransactionVO gen) {
		GenericInformationsVO gen10 = new GenericInformationsVO();

		JSONObject json = new JSONObject(gen);
		JSONArray jgen = json.getJSONArray("generic");
		JSONObject jobj = jgen.getJSONObject(i);
		String ide = jobj.getString("id");
		String value = jobj.getString("value");

		gen10.setId(ide);
		gen10.setValue(value);
		return gen10;
	}

// MOCK PARTNER_ID =============== 2
	// MOCK opcao 02
	private GenericTransactionVO mockGeneric2(GenericTransactionVO gen) {
		GenericTransactionVO gg = new GenericTransactionVO();
		JSONObject json = new JSONObject(gen);
		JSONArray jgen = json.getJSONArray("generic");
		String tt = json.getString("transactionType");
		gg.setTransactionType(tt);


		//Array generic must be less to 20
		int maxArray = 10;
		
		List<GenericInformationsVO> aa = new ArrayList<GenericInformationsVO>();

		if (jgen.length() < maxArray) {
			for (int i = 0; i < jgen.length(); i++) {

			GenericInformationsVO bb = mockGeneric2_1(i, gen);
			aa.add(bb);
		}
		gg.setGeneric(aa);
		return gg;
		}else
		{
			throw new ArrayTooLargeResponse("Array 'generic' is too large");
		}
		
	}

	// mock da Generic Informations
	private GenericInformationsVO mockGeneric2_1(int i, GenericTransactionVO gen) {
		GenericInformationsVO gen10 = new GenericInformationsVO();
		long id = counter.incrementAndGet();
		String id2 = String.valueOf(id);

		JSONObject json = new JSONObject(gen);
		JSONArray jgen = json.getJSONArray("generic");
		JSONObject jobj = jgen.getJSONObject(i);
		String ide = jobj.getString("id");
		String value = jobj.getString("value");

		gen10.setId("ID_REQUEST_" + id2 + "_" + ide);
		gen10.setValue("VALUE_REQUEST_" + id2 + "_" + value);
		return gen10;
	}

}