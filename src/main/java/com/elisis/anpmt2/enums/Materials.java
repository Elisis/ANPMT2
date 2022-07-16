package com.elisis.anpmt2.enums;

import java.util.BitSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import com.elisis.anpmt2.ANPMT2;
import com.elisis.anpmt2.loader.MaterialLoader;

public class Materials {

	private final int id;
	private final String name;
	private final SubTags mainSubTag;
	private final LinkedHashSet<SubTags> subTags = new LinkedHashSet<>();
	private final int[] RGBA;
	private BitSet statesToGenerate = new BitSet(8); // 0:S  1:L  2:G  3:P  4:SF  5-7:Reserved
	
	private String subscript = ""; 
	
	//In Kelvin
	private int meltingPoint;
	private int boilingPoint;
	private int sublimationPoint;
	
	
	
	public static final LinkedHashMap<String, Materials> MATERIALS_MAP = new LinkedHashMap<>();
	
	// ELEMENTS
	public static Materials Hydrogen = new Materials(1, "Hydrogen", SubTags.ELEMENT, "H2", 255, 255, 255, 0).addTags(SubTags._NULL).setHasGas().build();
	public static Materials Helium = new Materials(2, "Helium", SubTags.ELEMENT, "He", 255, 218, 185, 20).addTags(SubTags.INERT).setHasGas().build();
	public static Materials Lithium = new Materials(3, "Lithium", SubTags.ELEMENT, "Li", 70, 70, 70, 100).addTags(SubTags.METALLIC, SubTags.WORKABLE, SubTags.DUSTY).setHasSolid().build();
	public static Materials Beryllium = new Materials(4, "Beryllium", SubTags.ELEMENT, "Be", 168, 168, 168, 100).addTags(SubTags.DUSTY).setHasSolid().build();
	public static Materials Boron = new Materials(5, "Boron", SubTags.ELEMENT, "B", 133, 146, 158, 100).addTags(SubTags.DUSTY).setHasSolid().build();
	public static Materials Carbon = new Materials(6, "Carbon", SubTags.ELEMENT, "C", 23, 32, 42, 100).addTags(SubTags.DUSTY, SubTags.MORE_DUSTY).setHasSolid().build();
	public static Materials Nitrogen = new Materials(7, "Nitrogen", SubTags.ELEMENT, "N2", 255, 255, 255, 0).addTags(SubTags.PLACEABLE).setHasGas().build();
	public static Materials Oxygen = new Materials(8, "Oxygen", SubTags.ELEMENT, "O2", 255, 255, 255, 0).addTags(SubTags.PLACEABLE).setHasGas().build();
	public static Materials Fluorine = new Materials(9, "Fluorine", SubTags.ELEMENT, "F2", 254, 255, 232, 40).addTags(SubTags.PLACEABLE).setHasGas().build();
	public static Materials Neon = new Materials(10, "Neon", SubTags.ELEMENT, "Ne", 255, 160, 137, 20).addTags(SubTags.INERT, SubTags.PLACEABLE).setHasGas().build();
	public static Materials Sodium = new Materials(11, "Sodium", SubTags.ELEMENT, "Na", 220, 220, 220, 100).addTags(SubTags.METALLIC, SubTags.DUSTY).setHasSolid();
	public static Materials Magnesium = new Materials(12, "Magnesium", SubTags.ELEMENT, "Mg", 192, 192, 192, 100).addTags(SubTags.METALLIC, SubTags.WORKABLE, SubTags.DUSTY, SubTags.MORE_DUSTY).setHasSolid().build();
	public static Materials Aluminium = new Materials(13, "Aluminium", SubTags.ELEMENT, "Al", 131, 137, 150, 100).addTags(SubTags.METALLIC, SubTags.WORKABLE, SubTags.DUCTILE, SubTags.DUSTY, SubTags.MORE_DUSTY).setHasSolid().build();
	public static Materials Silicon = new Materials(14, "Silicon", SubTags.ELEMENT, "Si", 65, 74, 76, 100).addTags(SubTags._NULL).setHasSolid().build();
	public static Materials Phosphorus = new Materials(15, "Phosphorus", SubTags.ELEMENT, "P", 178, 34, 34, 100).addTags(SubTags.DUSTY).setHasSolid().build();
	
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
	
	private Materials build() {
		MATERIALS_MAP.put(this.name, this);
		ANPMT2.LOGGER.warn("Registered material: " + this.getName() + "\n");
		return this;
	}
	
	public static void init() {
		
		ANPMT2.LOGGER.warn("Registered a total of " + MATERIALS_MAP.values().size() + " materials!\n");
		MaterialLoader.init();
		
	}
	
}
