package app.diego.com.entregable3.Model.POJO;

public class Obra {

    private String artistId;
    private String name;
    private String image;

    public Obra() {
    }

    public Obra(String artistId, String name) {
        this.artistId = artistId;
        this.name = name;
    }

    public Obra(String artistId, String name, String image) {
        this.artistId = artistId;
        this.name = name;
        this.image = image;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
