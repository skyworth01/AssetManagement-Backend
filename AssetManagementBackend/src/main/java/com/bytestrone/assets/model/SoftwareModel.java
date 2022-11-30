package com.bytestrone.assets.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "software")
public class SoftwareModel extends AssetModel {

	@Column(name = "version", length = 40, unique = false, nullable = false)
	private String version;

	@Column(name = "sub_version", length = 40, unique = false, nullable = false)
	private String subVersion;

	@Column(name = "software_category", length = 40, unique = false, nullable = false)
	private String softwareCategory;

	@Column(name = "license_year", length = 40, unique = false, nullable = false)
	private int licenseYear;

	@Column(name = "license_type", length = 40, unique = false, nullable = false)
	private String licenseType;

	@Column(name = "software_name", length = 40, unique = false, nullable = false)
	private String softwareName;

	@Column(name = "purchased", length = 40, unique = false, nullable = false)
	private int purchased;

	@Column(name = "license_expiry_date", length = 40, unique = false, nullable = false)
	private LocalDate licenseExpiryDate;

	@Column(name = "license_cost", length = 40, unique = false, nullable = false)
	private float licenseCost;

	@Column(name = "status", length = 40, unique = false, nullable = false)
	private String status;

	@Column(name = "installed", length = 40, unique = false, nullable = false)
	private int installed;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getInstalled() {
		return installed;
	}

	public void setInstalled(int installed) {
		this.installed = installed;
	}

}
