package Entities;

import javax.xml.namespace.QName;

public class Brand {
    private int brandID;
    private String name;
    private String countryOfResidence;
    private int netWorth;

    public Brand(int brandID, String name, String countryOfResidence, int netWorth){
        this.brandID = brandID;
        this.name = name;
        this.countryOfResidence = countryOfResidence;
        this.netWorth = netWorth;
    }

    public Brand(String name, String countryOfResidence, int netWorth){
        this.name = name;
        this.countryOfResidence = countryOfResidence;
        this.netWorth = netWorth;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }
    public int getBrandID() {
        return brandID;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }
    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    public void setNetWorth(int netWorth) {
        this.netWorth = netWorth;
    }
    public int getNetWorth() {
        return netWorth;
    }
}
