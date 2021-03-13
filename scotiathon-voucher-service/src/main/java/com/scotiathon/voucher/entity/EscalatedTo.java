package com.scotiathon.voucher.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "escaled_to")
@Entity
@NoArgsConstructor
public class EscalatedTo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;

	public EscalatedTo(Long id) {
		this.id = id;
	}

}
