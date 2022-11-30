package com.bytestrone.assets.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bytestrone.assets.model.SoftwareModel;
import com.bytestrone.assets.service.SoftwareService;
import com.bytestrone.assets.viewobjects.SoftwareRequestModel;
import com.bytestrone.assets.viewobjects.SoftwareVO;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/asset")
public class AssetController {

	private SoftwareService softwareService;
	private ModelMapper modelMapper;

	public AssetController(SoftwareService softwareService, ModelMapper modelMapper) {
		super();
		this.softwareService = softwareService;
		this.modelMapper = modelMapper;
	}

	// Add Software Asset
	@PostMapping
	public ResponseEntity<Map<String, String>> saveSoftware(@RequestBody SoftwareRequestModel software) {
		Map<String, String> response = new HashMap<>();
		if (null != softwareService.saveSoftware(software)) {		
			response.put("message", "Software Asset Added");
			response.put("status", "added");

			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} else {
			response.put("message", "Asset already existing");
			response.put("status", "false");
			return new ResponseEntity<>(response, HttpStatus.OK);

		}

	}

	// Get All Software
	@GetMapping
	public ResponseEntity<Map<String, Object>> getAllSoftwareAssets(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {

		// Calling service function
		Page<SoftwareModel> pages = softwareService.getAllSoftwareAssets(page, size);

		// returning response data
		return responseData(pages);

	}

	// Search Software
	@GetMapping("search")
	public ResponseEntity<Map<String, Object>> searchSoftwareAssets(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam String searchTerm) {

		// Calling service function
		Page<SoftwareModel> pages = softwareService.searchSoftwareItems(page, size, searchTerm);
		return responseData(pages);

	}

	// Response function - Creating response data
	public ResponseEntity<Map<String, Object>> responseData(Page<SoftwareModel> pages) {
		if (!pages.isEmpty()) {
			List<SoftwareModel> softwareItems = pages.getContent();
			TypeToken<List<SoftwareVO>> outputData = new TypeToken<>() {			
			};
			List<SoftwareVO> data = modelMapper.map(softwareItems, outputData.getType());	//	Mapping List to list

			Map<String, Object> response = new HashMap<>();
			response.put("Softwares", data);
			response.put("currentPage", pages.getNumber());
			response.put("totalItems", pages.getTotalElements());
			response.put("totalPages", pages.getTotalPages());
			return new ResponseEntity<>(response, HttpStatus.OK);

		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
