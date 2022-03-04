package com.example.recyclerview_test1;

public class IconListModel {
    String iconName;
    String iconNumber;
    String iconShort;
    int iconImage;

    public IconListModel(String iconName, String iconNumber, String iconShort, int iconImage) {
        this.iconName = iconName;
        this.iconNumber = iconNumber;
        this.iconShort = iconShort;
        this.iconImage = iconImage;
    }

    public String getIconName() {
        return iconName;
    }

    public String getIconNumber() {
        return iconNumber;
    }

    public String getIconShort() {
        return iconShort;
    }

    public int getIconImage() {
        return iconImage;
    }
}
