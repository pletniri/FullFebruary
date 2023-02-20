package com.Month.FullFebruary.Controller;

public class EmployeeDto {
           //Instances
        private String position;
        private String name;
        private String image;

        //Constructor
        public EmployeeDto(String name, String position, String image) {
            this.name = name;
            this.position = position;
            this.image = image;
        }

        //getter and setter


    public String getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

