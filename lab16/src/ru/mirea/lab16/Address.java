package ru.mirea.lab16;

public final class Address {
    private String cityName;
    private int zipCode;
    private String streetName;
    private int buildingNumber;
    private char buildingLetter;
    private int apartmentNumber;
    private Address EMPTY_ADDRESS;
    public Address(){
        cityName="";
        zipCode=0;
        streetName="";
        buildingNumber=0;
        buildingLetter=' ';
        apartmentNumber=0;
    }
    public Address(String cityName,String streetName, int buildingNumber, char buildingLetter, int apartmentNumber, int zipCode){
        this.cityName=cityName;
        this.streetName=streetName;
        this.buildingNumber=buildingNumber;
        this.buildingLetter=buildingLetter;
        this.apartmentNumber=apartmentNumber;
        this.zipCode=zipCode;
        if (cityName.equals("")||streetName.equals("")){
            EMPTY_ADDRESS=this;
        }
    }
    public String getCityName() {
        return cityName;
    }
    public int getZipCode() {
        return zipCode;
    }
    public String getStreetName() {
        return streetName;
    }
    public int getBuildingNumber() {
        return buildingNumber;
    }
    public char getBuildingLetter() {
        return buildingLetter;
    }
    public int getApartmentNumber() {
        return apartmentNumber;
    }
    public String toString(){
        if (buildingLetter!=' ')
            return "City:"+cityName+" Street:"+streetName+" Building:"+buildingNumber+" Building letter:"+buildingLetter+" Apartment:"+apartmentNumber+ "Zip code:"+zipCode;
        else
            return "City:"+cityName+" Street:"+streetName+" Building:"+buildingNumber+" Apartment:"+apartmentNumber+ "Zip code:"+zipCode;
    }
}
