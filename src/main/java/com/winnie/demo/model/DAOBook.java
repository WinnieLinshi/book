package com.winnie.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "book")
public class DAOBook {
	@Id
	@Column
	@NotBlank
	@Size(max = 16)
	private String id;
	@Column
	@NotBlank
	@Size(max = 16)
	private String title;
	@Column
	@NotBlank
	@Size(max = 200)
	private String description;
	@Column
	@NotBlank
	@Size(max = 16)
	private String author;
	@Column
	@NotBlank
	@Size(max = 8)
	@Pattern(regexp="^\\d{4}\\d{2}\\d{2}$")
	private String publishDate;
}