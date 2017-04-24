package yalantis.com.sidemenu.sample;

import android.widget.Switch;

/**
 * Created by nabil on 11/2/16.
 */

public class ListItem {

    int image;
    String title;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public ListItem( String title,int image, String description) {
        this.image = image;
        this.title = title;
        Description = description;
    }

    //Switch aSwitch;
    String Description;

    //public Switch getaSwitch() {
      //  return aSwitch;
    //}

   // public void setaSwitch(Switch aSwitch) {
     //   this.aSwitch = aSwitch;
   // }






    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(int image) {
        this.image = image;
    }


    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }

    public ListItem(String title, int image) {
        this.title = title;
        this.image = image;
    }




}
