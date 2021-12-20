package com.example.wealthrating.rich;

public class financialInfo {

    private Long cash;
    private int numberOfAssets;

    public financialInfo() {
    }

    public financialInfo(Long cash, int numberOfAssets) {
        this.cash = cash;
        this.numberOfAssets = numberOfAssets;
    }

    public Long getCash() {
        return cash;
    }

    public void setCash(Long cash) {
        this.cash = cash;
    }

    public int getNumberOfAssets() {
        return numberOfAssets;
    }

    public void setNumberOfAssets(int numberOfAssets) {
        this.numberOfAssets = numberOfAssets;
    }

    @Override
    public String toString() {
        return "financialInfo{" +
                "cash=" + cash +
                ", numberOfAssets=" + numberOfAssets +
                '}';
    }
}
