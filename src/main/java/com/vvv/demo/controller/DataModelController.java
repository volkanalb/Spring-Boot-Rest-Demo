package com.vvv.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.vvv.demo.model.DataModel;
import com.vvv.demo.model.exception.DataNotFoundException;
import com.vvv.demo.service.IDataModelService;

@RestController
public class DataModelController {
	private static final Logger logger = LoggerFactory.getLogger(DataModelController.class);

	@Autowired
	private IDataModelService dataModelService;

	@GetMapping(value = "/")
	public String homePage() {

		return "Home page";
	}

	@GetMapping(value = "/model")
	public List<DataModel> findAll() {
		return dataModelService.findAll();
	}

	@GetMapping("/model/{id}")
	DataModel oneModel(@PathVariable Integer id) {
		logger.debug("@GetMapping by Id");
		try {
			return dataModelService.findOne(id);
		} catch (DataNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}

	@PostMapping("/model")
	DataModel insertModel(@RequestBody DataModel newModel) {
		logger.debug("@PostMapping");
		dataModelService.insert(newModel);
		return newModel;
	}

	@PutMapping("/model")
	DataModel replaceModel(@RequestBody DataModel newModel) {
		logger.debug("@PutMapping by Id : " + newModel.toString());
		dataModelService.insert(newModel);
		return newModel;
	}

	@DeleteMapping("/model/{id}")
	void deleteEmployee(@PathVariable Integer id) {
		logger.debug("@DeleteMapping by Id :" + id);
		try {
			dataModelService.delete(id);
		} catch (DataNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}
}
