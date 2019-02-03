package com.qa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HERO")
public class Hero {	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long heroID;
	@Column(unique = true, nullable = false)
	private String name;
	@Column(nullable = false)
	private String heroClass;
	@Column(nullable = false)
	private String universe;
	@Column(nullable = false)
	private String difficulty;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private String basic1;
	@Column(nullable = false)
	private String basic2;
	@Column(nullable = false)
	private String basic3;
	@Column(nullable = false)
	private String ult1;
	@Column(nullable = false)
	private String ult2;
	@Column(nullable = false)
	private String trait;
	@Column(nullable = true)
	private String image;
	@Column(nullable = false)
	private  String tag;	
	
	
	public Hero(String name, String heroClass, String universe, String difficulty, String description,
			String basic1, String basic2, String basic3, String ult1, String ult2, String trait, String image, String tag) 
	{
		this.name = name;
		this.heroClass = heroClass;
		this.universe = universe;
		this.difficulty = difficulty;
		this.description = description;
		this.basic1 = basic1;
		this.basic2 = basic2;
		this.basic3 = basic3;
		this.ult1 = ult1;
		this.ult2 = ult2;
		this.trait = trait;
		this.image = image;
		this.tag = tag;
	}
	
	public Hero() 
	{//default constructor
	}

	public Long getId() {
		return heroID;
	}

	public void setId(Long id) {
		this.heroID = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeroClass() {
		return heroClass;
	}

	public void setHeroClass(String heroClass) {
		this.heroClass = heroClass;
	}

	public String getUniverse() {
		return universe;
	}

	public void setUniverse(String universe) {
		this.universe = universe;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBasic1() {
		return basic1;
	}

	public void setBasic1(String basic1) {
		this.basic1 = basic1;
	}

	public String getBasic3() {
		return basic3;
	}

	public void setBasic3(String basic3) {
		this.basic3 = basic3;
	}

	public String getBasic2() {
		return basic2;
	}

	public void setBasic2(String basic2) {
		this.basic2 = basic2;
	}

	public String getUlt1() {
		return ult1;
	}

	public void setUlt1(String ult1) {
		this.ult1 = ult1;
	}

	public String getUlt2() {
		return ult2;
	}

	public void setUlt2(String ult2) {
		this.ult2 = ult2;
	}

	public String getTrait() {
		return trait;
	}

	public void setTrait(String trait) {
		this.trait = trait;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}