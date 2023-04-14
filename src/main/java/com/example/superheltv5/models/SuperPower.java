package com.example.superheltv5.models;

public class SuperPower {
  private int ID;
  private String name;
 // private String selectedValue;

  public SuperPower() {
  }

  public SuperPower(int ID, String name) {
    this.ID = ID;
    this.name = name;
  }

 /* public SuperPower(String name, String selectedValue) {
    this.name = name;
    this.selectedValue = selectedValue;
  }*/

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  /*public String getSelectedValue() {
    return selectedValue;
  }

  public void setSelectedValue(String selectedValue) {
    this.selectedValue = selectedValue;
  }*/

  /*public void addSuperPower(String superpower) {
  }*/
}
