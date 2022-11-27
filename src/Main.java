public class Main {
    public static void main(String[] args) {
        // Create Objects
        Art salvadorDali = new Art("Salvadori","Plastik",10);
        Art picasso = new Art("Picasso","lula",10000);
        Art davinci = new Art("Der Schrei","davinci",250);
        Art laluna = new Art("Sonne im Gesicht","laluna", 500);


        // Create Object of Museum
        Museum museum= new Museum("Susann",new Art[]{salvadorDali});
        Museum museum1=new Museum("Yasso", new Art[]{davinci});
        Museum museum2= new Museum("Houdii",new Art[]{davinci});



        // Add Art to museum
        museum.addArt("Das leben mit Ayhan","Susann",1000);

        // Search in a Museum
        Art ayhan = museum.SearchByName("Salvadori");
        System.out.println(ayhan.getName());

        // To Print Artist, Name, Value
        for (int i = 0; i< museum.getArtObject().length;i++){
            System.out.println("Artist "+museum.getArtObject()[i].getArtist());
            System.out.println("Name "+museum.getArtObject()[i].getName());
            System.out.println("Value "+museum.getArtObject()[i].getValue());
        }
        // Change Value
        museum.getArtObject()[0].setValue(16081999);
        museum.getArtObject()[1].setValue(19051998);


    }
}
