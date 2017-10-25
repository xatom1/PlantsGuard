package pl.put.poznan.plantsguard.controller;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.json.Json;
import javax.json.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.put.poznan.plantsguard.model.JsonMeasuresBuilder;
import pl.put.poznan.plantsguard.model.Measure;
import pl.put.poznan.plantsguard.model.MeasureDataSet;
import pl.put.poznan.plantsguard.model.ReportRequest;
import pl.put.poznan.plantsguard.service.MeasureService;

@RestController
public class RestApiController {
	
	@Autowired
	MeasureService measureService;

	@RequestMapping(value="/api/measures/save", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity<Measure> saveMeasure(@RequestBody ReportRequest request) {
		Measure measure = request.createMeasure();
		//measureService.save(measure);
		return new ResponseEntity<Measure>(measure, HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/measures/test", method=RequestMethod.GET)
	public ResponseEntity<ReportRequest> test() {
		ReportRequest report = new ReportRequest("123456",32.4f,32.1f,34.55f,86.5f,21f,64f, 5.32f);
		return new ResponseEntity<ReportRequest>(report,HttpStatus.OK);
	}
	
//	@RequestMapping(value="/api/json/test", method=RequestMethod.GET, produces="application/json")
//	public ResponseEntity<String> testJson() {
//		MeasureDataSet dataSet = MeasuresRepository.generateData(LocalDate.parse("20170101", DateTimeFormatter.BASIC_ISO_DATE), 
//				LocalDate.parse("20170115", DateTimeFormatter.BASIC_ISO_DATE));
//		JsonMeasuresBuilder jsonBuilder = new JsonMeasuresBuilder();
//		JsonObject response = jsonBuilder.createJsonFromDataSet(dataSet);
//		return new ResponseEntity<String>(response.toString(),HttpStatus.OK);
//	}
	
//	@RequestMapping(value="/api/measures/get", method=RequestMethod.GET, produces="application/json")
//	public ResponseEntity<String> getMeasures(@RequestParam("dateFrom") String dateFrom, @RequestParam("dateTo") String dateTo) {
//		MeasureDataSet dataSet = MeasuresRepository.generateData(LocalDate.parse(dateFrom, DateTimeFormatter.BASIC_ISO_DATE), 
//				LocalDate.parse(dateTo, DateTimeFormatter.BASIC_ISO_DATE));
//		JsonMeasuresBuilder jsonBuilder = new JsonMeasuresBuilder();
//		JsonObject response = jsonBuilder.createJsonFromDataSet(dataSet);
//		return new ResponseEntity<String>(response.toString(),HttpStatus.OK);
//	}
}
