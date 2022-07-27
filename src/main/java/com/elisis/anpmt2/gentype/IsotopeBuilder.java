package com.elisis.anpmt2.gentype;

public class IsotopeBuilder {
	
	private Isotope isotope;
	
	private IsotopeBuilder(Isotope isotope) {
		this.isotope = isotope;
	}
	
	public static IsotopeBuilder createGeneric(int atomicNumber, int atomicWeight) {
		
		Isotope isotope = new Isotope(atomicNumber, atomicWeight)
				.setRadioactive(false);
		//ANPMT2.LOGGER.warn("Isotope weight: " + atomicWeight);

		return new IsotopeBuilder(isotope);
		
	}
	
	public Isotope finalise() {
		return this.isotope;
	}

}
