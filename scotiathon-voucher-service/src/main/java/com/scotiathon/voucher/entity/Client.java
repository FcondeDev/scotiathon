package com.scotiathon.voucher.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "client")
@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, length = 20, name = "scotia_id")
	private String scotiaId;
	@Column(unique = true, length = 20)
	private String email;
	@Column(length = 60)
	private String password;
	private boolean enabled;
	@Column(name = "user_name")
	private String username;
	@Column(name = "failed_attemps")
	private long failedAttemps;
	@Column(name = "last_date_logged_In")
	private Date lastDateLoggedIn;

}
