package com.bytestrone.assets.viewobjects;

import java.time.LocalDate;

public class SoftwareRequestModel {

	private String assetNumber;
	private String assetType;
	private String manufacturingCompany;
	private String version;
	private String subVersion;
	private String softwareCategory;
	private int licenseYear;
	private String licenseType;
	private String softwareName;
	private int purchased;
	private LocalDate licenseExpiryDate;
	private float licenseCost;

	public String getAssetNumber() {
		return assetNumber;
	}

	public void setAssetNumber(String assetNumber) {
		this.assetNumber = assetNumber;
	}

	public String getAssetType() {
		return assetType;
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

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSubVersion() {
		return subVersion;
	}

	public void setSubVersion(String subVersion) {
		this.subVersion = subVersion;
	}

	public String getSoftwareCategory() {
		return softwareCategory;
	}

	public void setSoftwareCategory(String softwareCategory) {
		this.softwareCategory = softwareCategory;
	}

	public int getLicenseYear() {
		return licenseYear;
	}

	public void setLicenseYear(int licenseYear) {
		this.licenseYear = licenseYear;
	}

	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	public String getSoftwareName() {
		return softwareName;
	}

	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}

	public int getPurchased() {
		return purchased;
	}

	public void setPurchased(int purchased) {
		this.purchased = purchased;
	}

	public LocalDate getLicenseExpiryDate() {
		return licenseExpiryDate;
	}

	public void setLicenseExpiryDate(LocalDate licenseExpiryDate) {
		this.licenseExpiryDate = licenseExpiryDate;
	}

	public float getLicenseCost() {
		return licenseCost;
	}

	public void setLicenseCost(float licenseCost) {
		this.licenseCost = licenseCost;
	}

}
