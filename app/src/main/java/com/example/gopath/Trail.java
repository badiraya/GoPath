package com.example.gopath;

public class Trail {
    private String key;
    private String name;
    private String region;
    private String image;
    private int time;
    private int distance;
    private int rating;
    private boolean isFamilyFriendly;

    public Trail() {

    }

    public Trail(String key, String name, String region, String image, int time, int distance, int rating, boolean isFamilyFriendly) {
        this.key = key;
        this.name = name;
        this.region = region;
        this.image = image;
        this.time = time;
        this.distance = distance;
        this.rating = rating;
        this.isFamilyFriendly = isFamilyFriendly;

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {

        this.time = time;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {

        this.rating = rating;
    }


    public boolean isFamilyFriendly() {
        return isFamilyFriendly;
    }

    public void setIsFamilyFriendly(boolean IsfamilyFriendly) {
        isFamilyFriendly = IsfamilyFriendly;
    }    public String toString() {
        return "Trail{" +

                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", image='" + image + '\'' +
                ", time=" + time +
                ", distance=" + distance +
                ", rating=" + rating +
                ", isFamilyFriendly=" + isFamilyFriendly +"}";
    }
}
