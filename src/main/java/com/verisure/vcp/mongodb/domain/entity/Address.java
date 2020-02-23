package com.verisure.vcp.mongodb.domain.entity;

import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

	@Id
	@GeneratedValue
	private long id;

	public String street;
	public String number;

	@Version
	Long version;

	public Address(String street, String number) {
		this.street = street;
		this.number = number;
	}

}
