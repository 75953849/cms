package com.briup.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name="cms_link")
@ApiModel
public class Link {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(value="链接id")
	private Integer id;
	@ApiModelProperty(value="链接名",required=true)
	private String name;
	@ApiModelProperty(value="链接地址",required=true)
	private String url;

	public Link() {}

	public Link(String name, String url) {
		super();
		this.name = name;
		this.url = url;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Link [id=" + id + ", name=" + name + ", url=" + url + "]";
	}
	
}
