package FlickrJSON.Model.Flickr;

public enum Season {
    Spring(1,"Spring"),Summer(2,"Summer"),Fall(3,"Fall"),Winter(4,"Winter");

    private int seasonID;
    private String name;
    private int sum;


    Season(int seasonID, String name) {
        this.seasonID = seasonID;
        this.name = name;
    }

    public void clear(){
        sum = 0;
    }

    public int getSum() {
        return sum;
    }

    public void setSum() {
        this.sum += 1;
    }

    public int getSeasonID() {
        return seasonID;
    }

    public void setSeasonID(int seasonID) {
        this.seasonID = seasonID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
