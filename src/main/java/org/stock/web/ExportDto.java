package org.stock.web;

import java.util.Date;
import java.util.List;

public class ExportDto {
	private String BusinessGroup;
	private String RMPMID;
	private String counterPartyName;
	private String country;
	private List<String> coverage;
	private Date defaultDate;
	private String fileId;
	private String fileName;
	private String fileType;
	private Type grrSpreadSheetType;
	private Status grrSpreadSheetStatus;
	private String managingSite;
	private Period period;
	private String pole;
	private String userVpgtt;
	private String vpgttOfficier;
	private String year;
	private String region;
	private String responsible;
	private boolean isSecured;
	public String getBusinessGroup() {
		return BusinessGroup;
	}
	public void setBusinessGroup(String businessGroup) {
		BusinessGroup = businessGroup;
	}
	public String getRMPMID() {
		return RMPMID;
	}
	public void setRMPMID(String rMPMID) {
		RMPMID = rMPMID;
	}
	public String getCounterPartyName() {
		return counterPartyName;
	}
	public void setCounterPartyName(String counterPartyName) {
		this.counterPartyName = counterPartyName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public List<String> getCoverage() {
		return coverage;
	}
	public void setCoverage(List<String> coverage) {
		this.coverage = coverage;
	}
	public Date getDefaultDate() {
		return defaultDate;
	}
	public void setDefaultDate(Date defaultDate) {
		this.defaultDate = defaultDate;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public Type getGrrSpreadSheetType() {
		return grrSpreadSheetType;
	}
	public void setGrrSpreadSheetType(Type grrSpreadSheetType) {
		this.grrSpreadSheetType = grrSpreadSheetType;
	}
	public Status getGrrSpreadSheetStatus() {
		return grrSpreadSheetStatus;
	}
	public void setGrrSpreadSheetStatus(Status grrSpreadSheetStatus) {
		this.grrSpreadSheetStatus = grrSpreadSheetStatus;
	}
	public String getManagingSite() {
		return managingSite;
	}
	public void setManagingSite(String managingSite) {
		this.managingSite = managingSite;
	}
	public Period getPeriod() {
		return period;
	}
	public void setPeriod(Period period) {
		this.period = period;
	}
	public String getPole() {
		return pole;
	}
	public void setPole(String pole) {
		this.pole = pole;
	}
	public String getUserVpgtt() {
		return userVpgtt;
	}
	public void setUserVpgtt(String userVpgtt) {
		this.userVpgtt = userVpgtt;
	}
	public String getVpgttOfficier() {
		return vpgttOfficier;
	}
	public void setVpgttOfficier(String vpgttOfficier) {
		this.vpgttOfficier = vpgttOfficier;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getResponsible() {
		return responsible;
	}
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	public boolean isSecured() {
		return isSecured;
	}
	public void setSecured(boolean isSecured) {
		this.isSecured = isSecured;
	}
	
	
	
}
