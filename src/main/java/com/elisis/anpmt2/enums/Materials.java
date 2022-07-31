package com.elisis.anpmt2.enums;

import java.util.BitSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import com.elisis.anpmt2.ANPMT2;
import com.elisis.anpmt2.gentype.Isotope;
import com.elisis.anpmt2.gentype.IsotopeBuilder;
import com.elisis.anpmt2.item.Items;
import com.elisis.anpmt2.loader.MaterialLoader;
import com.elisis.anpmt2.util.MaterialUtils;

public class Materials {

	private final int id;
	private final String name;
	private final SubTags mainSubTag;
	private final LinkedHashSet<SubTags> subTags = new LinkedHashSet<>();
	private final int[] RGBA;
	private BitSet statesToGenerate = new BitSet(8); // 0:S  1:L  2:G  3:P  4:SF  5-7:Reserved
	private LinkedHashMap<String, Isotope> isotopes = new LinkedHashMap<>();
	
	private String subscript = ""; 
	
	//In Kelvin
	private int meltingPoint;
	private int boilingPoint;
	private int sublimationPoint;
	
	
	private boolean active = false;
	private int halfLife = 0;
	
	
	public static final LinkedHashMap<String, Materials> MATERIALS_MAP = new LinkedHashMap<>();
	
	// ELEMENTS
	//public static Materials Hydrogen = new Materials(1, "Hydrogen", SubTags.ELEMENT, "H2", 255, 255, 255, 0).addTags(SubTags._NULL).setHasGas().addIsotopes(1, new int[] {1, 2, 3}).build();
	public static Materials Hydrogen = new Materials(1, "Hydrogen", SubTags.ELEMENT, "H2", 255, 255, 255, 0).addTags(SubTags._NULL).setHasGas()
			.addIsotopes(1, 
					IsotopeBuilder.createGeneric(1, 1).finalise(), IsotopeBuilder.createGeneric(1, 2).finalise(), IsotopeBuilder.createGeneric(1, 3).finalise())
						.build();
	
	
	
	public static Materials Helium = new Materials(2, "Helium", SubTags.ELEMENT, "He", 255, 218, 185, 20).addTags(SubTags.INERT).setHasGas()
			.addIsotopes(2, IsotopeBuilder.createGeneric(1, 3).finalise(), IsotopeBuilder.createGeneric(1, 4).finalise(), IsotopeBuilder.createGeneric(1, 6).finalise())
				.build();
	
	public static Materials Lithium = new Materials(3, "Lithium", SubTags.ELEMENT, "Li", 70, 70, 70, 100).addTags(SubTags.METALLIC, SubTags.WORKABLE, SubTags.DUSTY).setHasSolid().setActive(400).build();
	public static Materials Beryllium = new Materials(4, "Beryllium", SubTags.ELEMENT, "Be", 168, 168, 168, 100).addTags(SubTags.DUSTY).setHasSolid().build();
	public static Materials Boron = new Materials(5, "Boron", SubTags.ELEMENT, "B", 133, 146, 158, 100).addTags(SubTags.DUSTY).setHasSolid().build();
	public static Materials Carbon = new Materials(6, "Carbon", SubTags.ELEMENT, "C", 23, 32, 42, 100).addTags(SubTags.DUSTY, SubTags.MORE_DUSTY, SubTags.MINABLE).setHasSolid().build();
	public static Materials Nitrogen = new Materials(7, "Nitrogen", SubTags.ELEMENT, "N2", 255, 255, 255, 0).addTags(SubTags.PLACEABLE).setHasGas().build();
	public static Materials Oxygen = new Materials(8, "Oxygen", SubTags.ELEMENT, "O2", 255, 255, 255, 0).addTags(SubTags.PLACEABLE).setHasGas().build();
	public static Materials Fluorine = new Materials(9, "Fluorine", SubTags.ELEMENT, "F2", 254, 255, 232, 40).addTags(SubTags.PLACEABLE).setHasGas().build();
	public static Materials Neon = new Materials(10, "Neon", SubTags.ELEMENT, "Ne", 255, 160, 137, 20).addTags(SubTags.INERT, SubTags.PLACEABLE).setHasGas().build();
	public static Materials Sodium = new Materials(11, "Sodium", SubTags.ELEMENT, "Na", 220, 220, 220, 100).addTags(SubTags.METALLIC, SubTags.DUSTY).setHasSolid();
	public static Materials Magnesium = new Materials(12, "Magnesium", SubTags.ELEMENT, "Mg", 192, 192, 192, 100).addTags(SubTags.METALLIC, SubTags.WORKABLE, SubTags.DUSTY, SubTags.MORE_DUSTY).setHasSolid().build();
	public static Materials Aluminium = new Materials(13, "Aluminium", SubTags.ELEMENT, "Al", 131, 137, 150, 100).addTags(SubTags.METALLIC, SubTags.WORKABLE, SubTags.DUCTILE, SubTags.DUSTY, SubTags.MORE_DUSTY).setHasSolid().build();
	public static Materials Silicon = new Materials(14, "Silicon", SubTags.ELEMENT, "Si", 65, 74, 76, 100).addTags(SubTags._NULL).setHasSolid().build();
	public static Materials RedPhosphorus = new Materials(15, "Red Phosphorus", SubTags.ELEMENT, "P", 178, 34, 34, 100).addTags(SubTags.DUSTY).setHasSolid().build();
	public static Materials Sulfur = new Materials(16, "Sulfur", SubTags.ELEMENT, "S8", 241, 221, 56, 90).addTags(SubTags.DUSTY).setHasSolid().build();
	public static Materials Chlorine = new Materials(17, "Chlorine", SubTags.ELEMENT, "Cl2", 255, 255, 204, 40).addTags(SubTags._NULL).setHasGas().build();
	public static Materials Argon = new Materials(18, "Argon", SubTags.ELEMENT, "Ar", 255, 255, 255, 0).addTags(SubTags.INERT).setHasGas().build();
	public static Materials Potassium = new Materials(19, "Potassium", SubTags.ELEMENT, "K", 122, 137, 140, 100).addTags(SubTags._NULL).setHasSolid().build();
	public static Materials Calcium = new Materials(20, "Calcium", SubTags.ELEMENT, "Ca", 245, 245, 245, 100).addTags(SubTags._NULL).setHasSolid().build();
	public static Materials Scandium = new Materials(21, "Scandium", SubTags.ELEMENT, "Sc", 211, 211, 211, 100).addTags(SubTags.METALLIC, SubTags.WORKABLE, SubTags.DUCTILE, SubTags.DUSTY).setHasSolid().build();
	public static Materials Titanium = new Materials(22, "Titanium", SubTags.ELEMENT, "Ti", 200, 200, 210, 100).addTags(SubTags.METALLIC, SubTags.WORKABLE, SubTags.DUCTILE, SubTags.DUSTY).setHasSolid().build();
	public static Materials Vanadium = new Materials(23, "Vanadium", SubTags.ELEMENT, "V", 192, 192, 192, 100).addTags(SubTags.DUCTILE).setHasSolid().build();
	public static Materials Chromium = new Materials(24, "Chromium", SubTags.ELEMENT, "Cr", 216, 216, 216, 100).addTags(SubTags._NULL).setHasSolid().build();
	public static Materials Manganese = new Materials(25, "Manganese", SubTags.ELEMENT, "Mn", 59, 60, 54, 100).addTags(SubTags.DUSTY).setHasSolid().build();
	public static Materials Iron = new Materials(26, "Iron", SubTags.ELEMENT, "Fe", 220, 220, 220, 100).addTags(SubTags.METALLIC, SubTags.WORKABLE, SubTags.DUSTY).setHasSolid().build();




	
	
	
	public Materials(int id, String name, SubTags mainSubTag, int r, int g, int b, int a) {
		this.id = id;
		this.name = name;
		this.mainSubTag = mainSubTag;
		this.RGBA = new int[] {r, g, b, a};
	}
	
	public Materials(int id, String name, SubTags mainSubTag, String subscript, int r, int g, int b, int a) {
		this.id = id;
		this.name = name;
		this.mainSubTag = mainSubTag;
		this.subscript = subscript;
		this.RGBA = new int[] {r, g, b, a};
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public SubTags getMainSubTag() {
		return this.mainSubTag;
	}
	
	public String getSubscript() {
		return this.subscript;
	}
	
	public Materials setHasSolid() {
		this.statesToGenerate.set(0);
		return this;
	}
	
	public Materials setHasLiquid() {
		this.statesToGenerate.set(1);
		return this;
	}
	
	public Materials setHasGas() {
		this.statesToGenerate.set(2);
		return this;
	}
	
	public Materials setHasPlasma() {
		this.statesToGenerate.set(3);
		return this;
	}
	
	public Materials setMeltingPoint(int p) {
		if (this.sublimationPoint > 0)
			ANPMT2.LOGGER.warn("Material " + this.getName() + " has invalid states. Check definition!\n");
		this.meltingPoint = p;
		return this;
	}
	
	public int getMeltingPoint() {
		return this.meltingPoint;
	}
	
	public Materials setBoilingPoint(int p) {
		if (this.sublimationPoint > 0)
			ANPMT2.LOGGER.warn("Material " + this.getName() + " has invalid states. Check definition!\n");
		this.boilingPoint = p;
		return this;
	}
	
	public int getBoilingPoint() {
		return this.boilingPoint;
	}
	
	public Materials setSublimationPoint(int p) {
		if (this.sublimationPoint > 0 || this.meltingPoint > 0)
			ANPMT2.LOGGER.warn("Material " + this.getName() + " has invalid states. Check definition!\n");
		this.sublimationPoint = p;
		return this;
	}
	
	public int getSublimationPoint() {
		return this.sublimationPoint;
	}
	
	private Materials setStatesToGenerate(BitSet set) {
		this.statesToGenerate = set;
		return this;
	}
	
	public BitSet getStatesToGenerate() {
		return this.statesToGenerate;
	}
	
	public int[] getRGBA() {
		return this.RGBA;
	}
	
	@SuppressWarnings("unchecked")
	public LinkedHashSet<SubTags> getSubTags() {
		return (LinkedHashSet<SubTags>) this.subTags.clone();
	}
	
	private Materials addTags(SubTags... tags) {
        if (tags != null) {
            for (SubTags tag : tags)
                if (tag != null && !this.contains(tag)) {
                    this.subTags.add(tag);
                }
        }
        return this;
    }
	
	public boolean contains(SubTags tag) {
        return this.subTags.contains(tag);
    }
	/*
	private Materials addIsotopes(int atomicNumber, int[] atomicWeights) {
		this.isotopes = Isotope.createIsotopes(this, atomicNumber, atomicWeights);
		return this;
	}
	*/
	private Materials addIsotopes(int atomicNumber, Isotope... isotopes) {
		for (Isotope isotope : isotopes) {
			isotope = isotope.setAssociatedMaterial(this);
			this.isotopes.put(isotope.getName(), isotope);
		}
		return this;
	}
	
	private Materials setActive(int hl) {
		this.active = true;
		this.halfLife = hl;
		return this;
	}
	
	public boolean getActive() {
		return this.active;
	}
	
	public int getHalfLife() {
		return this.halfLife;
	}
	
	@SuppressWarnings("unchecked")
	public LinkedHashMap<String, Isotope> getIsotopes() {
		return (LinkedHashMap<String, Isotope>) this.isotopes.clone();
	}
	
	private Materials build() {
		MATERIALS_MAP.put(this.name, this);
		ANPMT2.LOGGER.warn("Registered material: " + this.getName() + "\n");
		
		for (Map.Entry<String, Isotope> entry : this.getIsotopes().entrySet()) {
			String name = entry.getKey();
			Isotope isotopeObject = entry.getValue(); 
			
			Materials isotopeMaterial = getMaterialObjectFromIsotope(name, isotopeObject);
			MATERIALS_MAP.put(name, isotopeMaterial);
		}
		
		
		return this;
	}
	
	private static Materials getMaterialObjectFromIsotope(String name, Isotope iso) {
		Materials assMaterial = iso.getAssociatedMaterial();
		Materials materialObject = new Materials(assMaterial.getId(), name, SubTags.ELEMENT, assMaterial.getSubscript(), assMaterial.getRGBA()[0], assMaterial.getRGBA()[1], assMaterial.getRGBA()[2], assMaterial.getRGBA()[3])
					.addTags(assMaterial.getSubTags().toArray(new SubTags[0])).setStatesToGenerate(assMaterial.getStatesToGenerate());
		return materialObject;
	}
	
	
	
	
	
	public static void init() {
		
		ANPMT2.LOGGER.warn("Registered a total of " + MATERIALS_MAP.values().size() + " materials!\n");
		
		long startTime = System.currentTimeMillis();
		MaterialLoader.init();
		long endTime = System.currentTimeMillis();
		
		long duration = (endTime - startTime);
		
		ANPMT2.LOGGER.warn("[[Assembled a total of " + MaterialUtils.getItemsToRegisterArray().length + MaterialUtils.getItemBlocksToRegisterArray().length + Items.ampoules.size() + " items!]]");
		ANPMT2.LOGGER.warn("[[Assembly took " + (duration) + "ms]]");
		
	}
	
}
