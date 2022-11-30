package com.bytestrone.assets.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bytestrone.assets.model.SoftwareModel;

public interface SoftwareRepository extends JpaRepository<SoftwareModel, Long> {
	boolean existsByAssetNumber(String assetNumber);

	Page<SoftwareModel> findByStatusOrStatus(String status1, String status2, Pageable pageable);

	@Query("SELECT h FROM SoftwareModel h WHERE h.softwareCategory LIKE CONCAT('%',?1,'%')"
			+ "OR h.softwareName LIKE CONCAT('%',?1,'%')" + "OR h.manufacturingCompany LIKE CONCAT('%',?1,'%')")
	Page<SoftwareModel> searchSoftware(String searchTerm, Pageable pageable);
}
