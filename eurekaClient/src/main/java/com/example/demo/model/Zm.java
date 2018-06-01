package com.example.demo.model;

class Zm {
    private String elephant;
    private  String rat;
    private   String chickens;

    public Zm(){
        System.out.println("AAA");

    }

    public String getElephant() {
        return elephant;
    }

    public void setElephant(String elephant) {
        this.elephant = elephant;
    }

    public String getRat() {
        return rat;
    }

    public void setRat(String rat) {
        this.rat = rat;
    }

    public String getChickens() {
        return chickens;
    }

    public void setChickens(String chickens) {
        this.chickens = chickens;
    }

    @Override
    public String toString() {
        return "zm{" +
                "elephant='" + elephant + '\'' +
                ", rat='" + rat + '\'' +
                ", chickens='" + chickens + '\'' +
                '}';
    }
}