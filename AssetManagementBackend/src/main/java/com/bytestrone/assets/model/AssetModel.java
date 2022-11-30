package com.bytestrone.assets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "asset")
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "my_seq", sequenceName = "sequence", allocationSize = 1)
public abstract class AssetModel {

	@Id
	@GeneratedValue(generator = "my_seq")
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@Column(name = "asset_number", unique = true, nullable = false)
	private String assetNumber;

	@Column(name = "asset_type", length = 40, unique = false)
	private String assetType;

	@Column(name = "manufacturing_company", length = 40, unique = false, nullable = false)
	private String manufacturingCompany;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAssetType() {
		return this.assetType;
	}

	public void setAssetNumber(String assetNumber) {
		this.assetNumber = assetNumber;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public String getManufacturingCompany() {
		return manufacturingCompany;
	}

	public void setManufacturingCompany(String manufacturingCompany) {
		this.manufacturingCompany = manufacturingCompany;
	}

	public String getAssetNumber() {
		return assetNumber;
	}

}
