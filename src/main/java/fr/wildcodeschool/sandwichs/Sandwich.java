package fr.wildcodeschool.sandwichs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Sandwich {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String ingrédients;
	private int calories;

	
	public Sandwich() {}
	
	public Sandwich(String nom, String ingrédients, int calories) {
		this.nom = nom;
		this.ingrédients = ingrédients;
		this.calories = calories;
	}
	
	
    public Long getId() {
        return id;
    }

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getIngrédients() {
		return ingrédients;
	}

	public void setIngrédients(String ingrédients) {
		this.ingrédients = ingrédients;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	@Override
	public String toString() {
		return "Sandwich [id=" + id + ", nom=" + nom + ", ingrédients=" + ingrédients + ", calories=" + calories + "]";
	}
	
	
}
