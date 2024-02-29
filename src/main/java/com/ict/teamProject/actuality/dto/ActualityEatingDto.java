package com.ict.teamProject.actuality.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Alias("ActualityEatingDto")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActualityEatingDto {
	private String id;
	private Date ae_date;
	private String ae_diettype;
	private String ae_foodname;
	private int calory;
	private int carbohydrate;
	private int protein;
	private int fat;
	private int sodium;
	private int cholesterol;
}
