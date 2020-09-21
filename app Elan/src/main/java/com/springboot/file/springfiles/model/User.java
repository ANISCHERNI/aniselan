

package com.springboot.file.springfiles.model;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id ;
	
	
	@Column(name="numFacture")
	private String numFacture ;
	
	@Column(name="val")
	private String 	val ;
	
	@Column(name="codeClient")
	private String codeClient ;
	
	@Column(name="societe")
	private String societe ;
	
	@Column(name="totalHT")
	private String totalHT ;
	
	@Column(name="totalTVA")
	private String totalTVA ;
	
	@Column(name="totalTTC")
	private String totalTTC ;
	
	@Column(name="acompte")
	private String acompte ;
	
	@Column(name="mantantRegle")
	private String mantantRegle ;
	
	@Column(name="soldeDu")
	private String soldeDu ;
	
	@Column(name="fileType")
	private String fileType ;
	
	@Transient
	private MultipartFile file ;
	
	
	
	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getNumFacture() {
		return numFacture;
	}




	public void setNumFacture(String numFacture) {
		this.numFacture = numFacture;
	}




	public String getVal() {
		return val;
	}




	public void setVal(String val) {
		this.val = val;
	}




	public String getCodeClient() {
		return codeClient;
	}




	public void setCodeClient(String codeClient) {
		this.codeClient = codeClient;
	}




	public String getSociete() {
		return societe;
	}




	public void setSociete(String societe) {
		this.societe = societe;
	}




	public String getTotalHT() {
		return totalHT;
	}




	public void setTotalHT(String totalHT) {
		this.totalHT = totalHT;
	}




	public String getTotalTVA() {
		return totalTVA;
	}




	public void setTotalTVA(String totalTVA) {
		this.totalTVA = totalTVA;
	}




	public String getTotalTTC() {
		return totalTTC;
	}




	public void setTotalTTC(String totalTTC) {
		this.totalTTC = totalTTC;
	}




	public String getAcompte() {
		return acompte;
	}




	public void setAcompte(String acompte) {
		acompte = acompte;
	}




	public String getMantantRegle() {
		return mantantRegle;
	}




	public void setMantantRegle(String mantantRegle) {
		this.mantantRegle = mantantRegle;
	}




	public String getSoldeDu() {
		return soldeDu;
	}




	public void setSoldeDu(String soldeDu) {
		this.soldeDu = soldeDu;
	}




	public MultipartFile getFile() {
		return file;
	}




	public void setFile(MultipartFile file) {
		this.file = file;
	}



	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	
	

	
	public User() {
		
	}




	public User(Long id, String numFacture, String val, String codeClient, String societe, String totalHT,
			String totalTVA, String totalTTC, String acompte, String mantantRegle, String soldeDu,String fileType) {
		
		
		this.numFacture = numFacture;
		this.val = val;
		this.codeClient = codeClient;
		this.societe = societe;
		this.totalHT = totalHT;
		this.totalTVA = totalTVA;
		this.totalTTC = totalTTC;
		this.acompte = acompte;
		this.mantantRegle = mantantRegle;
		this.soldeDu = soldeDu;
		this.fileType = fileType;
	}
	
	
}
