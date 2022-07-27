package com.elisis.anpmt2.gentype;

import java.util.LinkedHashMap;

import com.elisis.anpmt2.enums.Materials;

public class Isotope {
	
	private int atomicNumber;
	private int atomicWeight;
	private Materials associatedMaterial;
	
	private Isotope(Materials material, int atomicNumber, int atomicWeight) {
		this.atomicNumber = atomicNumber;
		this.atomicNumber = atomicWeight;
		this.associatedMaterial = material;
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
	
	public Materials getAssociatedMaterial() {
		return this.associatedMaterial;
	}
	 
}
