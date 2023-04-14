package com.example.superheltv5.models;

public class City {
  private int cityID;
  private String cityName;
  //TODO understand
  private String selectedValue;

  public City() {
  }

  public City(int cityID, String cityName) {
    this.cityID = cityID;
    this.cityName = cityName;
  }

  public int getCityID() {
    return cityID;
  }

  public void setCityID(int cityID) {
    this.cityID = cityID;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  //TODO selected

  public String getSelectedValue() {
    return selectedValue;
  }

  public void setSelectedValue(String selectedValue) {
    this.selectedValue = selectedValue;
  }
}
