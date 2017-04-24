package tools;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Menus implements Serializable{

    @SerializedName("idSubMenu")
    @Expose
    private String idSubMenu;
    @SerializedName("Titre")
    @Expose
    private String titre;
    @SerializedName("description")
    @Expose
    private String description;

    public String getIdSubMenu() {
        return idSubMenu;
    }

    public void setIdSubMenu(String idSubMenu) {
        this.idSubMenu = idSubMenu;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}