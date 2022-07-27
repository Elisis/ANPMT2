package com.elisis.anpmt2.gentype;

import java.util.LinkedHashMap;

import com.elisis.anpmt2.enums.Materials;

public class Isotope {
	
	private int atomicNumber;
	private int atomicWeight;
	private Materials associatedMaterial;
	private String name;
	
	private boolean active;
	private int halfLife;
	
	Isotope(Materials material, int atomicNumber, int atomicWeight) {
		this.atomicNumber = atomicNumber;
		this.atomicWeight = atomicWeight;
		this.associatedMaterial = material;
		this.name = material.getName() + "-" + atomicWeight; //E.g. Sodium-22
	}
	
	Isotope(int atomicNumber, int atomicWeight) {
		this.atomicNumber = atomicNumber;
		this.atomicWeight = atomicWeight;
	}
	
	public static LinkedHashMap<String, Isotope> createIsotopes(Materials material, int atomicNumber, int[] atomicWeights) {
		
		LinkedHashMap<String, Isotope> isotopeMap = new LinkedHashMap<>();
		String materialName = material.getName();
		
		
		
		for (int weight : atomicWeights) {
			String isotopeName = materialName + "-" + weight;
			isotopeMap.put(isotopeName, new Isotope(material, atomicNumber, weight));
		}
		
		return isotopeMap;
		
	}
	
	
	public int getAtomicNumber() {
		return this.atomicNumber;
	}
	
	public int getAtomicWeight() {
		return this.atomicWeight;
	}
	
	public Isotope setAssociatedMaterial(Materials material) {
		this.associatedMaterial = material;
		this.name = material.getName() + "-" + this.atomicWeight; //E.g. Sodium-22
		return this;
	}
	
	public Materials getAssociatedMaterial() {
		return this.associatedMaterial;
	}
	
	Isotope setRadioactive(boolean active) {
		this.active = active;
		return this;
	}
	
	public boolean getRadioactive() {
		return this.active;
	}
	
	Isotope setHalfLife(int hl) {
		this.halfLife = hl;
		return this;
	}
	
	public int getHalfLife() {
		return this.halfLife;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Isotope setName(String name) {
		this.name = name;
		return this;
	}
	
	
	 
}
