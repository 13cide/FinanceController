package com.example.financecontroller.DataClasses;

public class Category {
    private int categoryID;
    private String name;
    private int colorID;
    private int iconID;
    private boolean isIncome;

    public Category(int categoryID, String name, int colorID, int iconID, boolean isIncome) {
        this.categoryID = categoryID;
        this.name = name;
        this.colorID = colorID;
        this.iconID = iconID;
        this.isIncome = isIncome;
    }

    public int getCategoryID() {
        return categoryID;
    }
    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getColorID() {
        return colorID;
    }
    public void setColorID(int colorID) {
        this.colorID = colorID;
    }

    public int getIconID() {
        return iconID;
    }
    public void setIconID(int iconID) {
        this.iconID = iconID;
    }


    public boolean isIncome() {
        return isIncome;
    }
    public void setIncome(boolean income) {
        isIncome = income;
    }
}
