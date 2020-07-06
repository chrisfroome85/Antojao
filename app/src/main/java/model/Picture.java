package model;

public class Picture {

    private String picture;
    private String userName;
    private String time;
    private String ratingNumber = "0";

    public Picture(String picture, String userName, String time, String ratingNumber) {
        this.picture = picture;
        this.userName = userName;
        this.time = time;
        this.ratingNumber = ratingNumber;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRatingNumber() {
        return ratingNumber;
    }

    public void setRatingNumber(String ratingNumber) {
        this.ratingNumber = ratingNumber;
    }
}
