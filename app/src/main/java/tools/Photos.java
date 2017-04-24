package tools;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photos {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("Photo")
    @Expose
    private String photo;
    @SerializedName("FK_IdMenu")
    @Expose
    private String fKIdMenu;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getFKIdMenu() {
        return fKIdMenu;
    }

    public void setFKIdMenu(String fKIdMenu) {
        this.fKIdMenu = fKIdMenu;
    }

}