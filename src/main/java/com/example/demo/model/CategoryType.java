package com.example.demo.model;

public enum CategoryType {
	
	CLOTHES(0, "CLOTHES"),
	ELECTRONICS(1, "ELECTRONICS"),
	SPORTS(2, "SPORTS"),
	VEHICLES(3, "VEHICLES");

	private final Integer categoryId;
	private final String categoryName;

	CategoryType(Integer categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public static CategoryType valueOf(Integer text) {
		for (CategoryType b : CategoryType.values()) {
			if (b.categoryId == text) {
				return b;
			}
		}
		return null;
	}

	public Integer categoryId() {
		return categoryId;
	}

	public String categoryName() {
		return categoryName;
	}

}
