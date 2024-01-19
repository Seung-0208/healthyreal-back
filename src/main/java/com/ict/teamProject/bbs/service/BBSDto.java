package com.ict.teamProject.bbs.service;
import org.apache.ibatis.type.Alias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("BBSDto")
public class BBSDto {
	private String no;
	private String id;
	private int type;
	private String Content;
	private char disclosureYN;
	private String hashTag;
	private java.sql.Date postDate;
}
