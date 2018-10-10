package com.json.feed.datafeedsample;

import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flowers.jsonfeed.model.JSONDataResponse;

@RestController
@RequestMapping(value="/server",consumes = "application/json", produces = "application/json")
public class SampleDataController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SampleDataController.class);

	@GetMapping("/sampleData")
	public List<JSONDataResponse> getSampleData() {
		LOGGER.info("Before loading data...");
		List<JSONDataResponse> response = null;
		ObjectMapper objectMaper = new ObjectMapper();
		TypeReference<List<JSONDataResponse>> typeReference = new TypeReference<List<JSONDataResponse>>() {	};
		
		InputStream inputStream = TypeReference.class.getResourceAsStream("/jsonData.json");
		try {
			response = objectMaper.readValue(inputStream, typeReference);
		} catch (Exception e) {
			LOGGER.info("Error in loading data...");
			e.getStackTrace();
		}
		LOGGER.info("Loading of data is completed...");
		return response;
	}

}
