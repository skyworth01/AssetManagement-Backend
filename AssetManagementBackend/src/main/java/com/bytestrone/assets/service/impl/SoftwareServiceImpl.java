package com.bytestrone.assets.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bytestrone.assets.model.SoftwareModel;
import com.bytestrone.assets.repository.SoftwareRepository;
import com.bytestrone.assets.service.SoftwareService;
import com.bytestrone.assets.viewobjects.SoftwareRequestModel;

@Service
public class SoftwareServiceImpl implements SoftwareService {

	private SoftwareRepository softwareRepository;
	private ModelMapper modelMapper;

	public SoftwareServiceImpl(SoftwareRepository softwareRespository, ModelMapper modelMapper) {
		super();
		this.softwareRepository = softwareRespository;
		this.modelMapper = modelMapper;
	}

	public SoftwareModel saveSoftware(SoftwareRequestModel software) {
		if (softwareRepository.existsByAssetNumber(software.getAssetNumber())) {  //Checking if asset number already exists || else save data
			return null;
		} else {
			SoftwareModel data = modelMapper.map(software, SoftwareModel.class);	
			data.setInstalled(0);														// Setting status and installed field initially as unallocated and 0
			data.setStatus("Unallocated");
			softwareRepository.save(data);
			return data;
		}

	}

	@Override
	public Page<SoftwareModel> getAllSoftwareAssets(int page, int size) {

		Pageable paging = PageRequest.of(page, size);
		Page<SoftwareModel> pages = softwareRepository.findByStatusOrStatus("Unallocated", "Allocated", paging);   // Getting all active(Unallocated and allocated) items
		if (null != pages) {
			return pages;
		}
		return null;
	}

	@Override
	public Page<SoftwareModel> searchSoftwareItems(int page, int size, String searchTerm) {
		Pageable paging = PageRequest.of(page, size);
		Page<SoftwareModel> pages = softwareRepository.searchSoftware(searchTerm, paging);			// getting items by searching using searchTerm
		if (null != pages) {
			return pages;
		}
		return null;

	}

}
