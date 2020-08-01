package id.javafirst.webinarbisaai.Home.Model;

public class NationModel {
    String nationName;

    int nationImage;

    public NationModel(String nationName, int nationImage) {
        this.nationName = nationName;
        this.nationImage = nationImage;
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }

    public int getNationImage() {
        return nationImage;
    }

    public void setNationImage(int nationImage) {
        this.nationImage = nationImage;
    }
}
