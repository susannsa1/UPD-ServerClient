public class Art {
    private String name;
    private String artist;
    private int value;

    //Contructor
    public Art(String name, String artist, int value) {
        this.name = name;
        this.artist = artist;
        this.value = value;
    }

    // Return the name
    public String getName() {
        return name;
    }

    // Return the artist
    public String getArtist(){
        return artist;
    }


    //Return the value
    public int getValue(){
        return value;
    }

    // Change / Set the Value
    public void setValue(int value) {
        this.value = value;
    }
}
