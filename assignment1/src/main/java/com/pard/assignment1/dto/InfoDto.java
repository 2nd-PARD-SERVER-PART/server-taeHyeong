package com.pard.assignment1.dto;

public class InfoDto {
        private String major;
        private int grade;
        private int age;
        private String hobby;
        private String name;
        private String hometown;
        private String introduction;

        public InfoDto(String major, int grade, int age, String hobby, String name, String hometown, String introduction) {
            this.major = major;
            this.grade = grade;
            this.age = age;
            this.hobby = hobby;
            this.name = name;
            this.hometown = hometown;
            this.introduction = introduction;
        }

    public String getMajor() {
        return major;
    }
    public int getGrade() {
        return grade;
    }
    public int getAge() {
        return age;
    }
    public String getHobby() {
        return hobby;
    }
    public String getName() {
        return name;
    }
    public String getHometown() {
        return hometown;
    }
    public String getIntroduction() {
        return introduction;
    }
}
