package com.bytestrone.assets.service;

import org.springframework.data.domain.Page;

import com.bytestrone.assets.model.SoftwareModel;
import com.bytestrone.assets.viewobjects.SoftwareRequestModel;

public interface SoftwareService {
	SoftwareModel saveSoftware(SoftwareRequestModel software);

	Page<SoftwareModel> getAllSoftwareAssets(int page, int size);

	Page<SoftwareModel> searchSoftwareItems(int page, int size, String searchTerm);
}
