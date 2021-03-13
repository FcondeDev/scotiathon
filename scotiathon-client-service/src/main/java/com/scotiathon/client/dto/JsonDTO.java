package com.scotiathon.client.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonDTO<T> implements Serializable {

	private static final long serialVersionUID = -2447990576703231795L;
	private transient T data;

}
