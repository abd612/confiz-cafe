package com.confiz.confizcafe.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee {

	@Id
	private Integer id;
	private String name;
	private String designation;
	private List<byte[]> fingerPrints;

	public Employee() {
	}

	public Employee(Integer id, String name, String designation, List<byte[]> fingerprint) {
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.fingerPrints = fingerprint;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public List<byte[]> getFingerprint() {
		return fingerPrints;
	}

	public void setFingerprint(List<byte[]> fingerprint) {
		this.fingerPrints = fingerprint;
	}

	public void addFingerprint(byte[] fingerprint) {
		if (this.fingerPrints == null) {
			this.fingerPrints = new ArrayList<byte[]>();
		}
		this.fingerPrints.add(fingerprint);
	}

	public static Employee createEmployee(LinkedHashMap linkedHashMap) {
		Collection keySet = linkedHashMap.keySet();
		Employee employee = new Employee();
		for (Object object : keySet) {
			String field = object.toString();
			switch (field) {
			case "id":
				employee.setId(Integer.parseInt(String.valueOf(linkedHashMap.get(field))));
				break;
			case "name":
				employee.setName(String.valueOf(linkedHashMap.get(field)));
				break;
			case "designation":
				employee.setDesignation(String.valueOf(linkedHashMap.get(field)));
				break;
			case "fingerprint":
				List<String> encodedFingerprints = (List<String>) linkedHashMap.get("fingerprint");
				for (String encodedFingerprint : encodedFingerprints) {
					employee.addFingerprint(Base64.decodeBase64(encodedFingerprint));
				}
				break;
			}
		}
		return employee;
	}
}
