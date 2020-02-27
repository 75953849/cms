package com.briup.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;

@Entity
@Table(name="cms_category")
@ApiModel
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(value="栏目id")
	private Integer id;
	@ApiModelProperty(value="栏目编码",required=true)
	private long code;
	@ApiModelProperty(value="栏目名称",required=true)
	private String name;
	
	@OneToMany(mappedBy="category",cascade=CascadeType.REMOVE)
	@JsonIgnore
	private List<Article> articles;
	

	public Category() {}

	public Category(long code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public Category(Integer id, long code, String name) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", code=" + code + ", name=" + name + "]";
	}
	
	
}
