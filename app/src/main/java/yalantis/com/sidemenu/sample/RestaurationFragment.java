package yalantis.com.sidemenu.sample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.support.v7.graphics.Palette;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import com.etiennelawlor.imagegallery.library.ImageGalleryFragment;
import com.etiennelawlor.imagegallery.library.activities.FullScreenImageGalleryActivity;
import com.etiennelawlor.imagegallery.library.activities.ImageGalleryActivity;
import com.etiennelawlor.imagegallery.library.adapters.FullScreenImageGalleryAdapter;
import com.etiennelawlor.imagegallery.library.adapters.ImageGalleryAdapter;
import com.etiennelawlor.imagegallery.library.enums.PaletteColorType;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import tools.CallWebService;
import tools.Photos;

import static yalantis.com.sidemenu.sample.R.layout.activity_restauration_fragment;

/**
 * Created by macbookair on 05/04/2017.
 */

public class RestaurationFragment extends ListFragment implements ImageGalleryAdapter.ImageThumbnailLoader, FullScreenImageGalleryAdapter.FullScreenImageLoader{
private PaletteColorType paletteColorType;


private List<ListItem> l;

    Button button1;

    FragmentManager fm = getFragmentManager();



    public RestaurationFragment(){

        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.d("My fm",""+fm);

       //Log.d("My Button",""+button1);

        //button1 = (Button) getView().findViewById(R.id.button1);

        //Log.d("My Button",""+button1);

        ////button1.setOnClickListener(new View.OnClickListener(){
            //public void onClick(View arg0) {
               // DFragment dFragment = new DFragment();
                // Show DialogFragment

                //dFragment.show(fm,"  show dialod");
          //  }
        //});


        l = new ArrayList<ListItem>();

        l.add(new ListItem("Market Place ", R.drawable.restauration,"MyDescription"));
        l.add(new ListItem("Olives  ", R.drawable.restauration));
        l.add(new ListItem("Morjana ", R.drawable.restauration));
        l.add(new ListItem("Jin-Ja  ", R.drawable.restauration));
        l.add(new ListItem("Al Firma  ", R.drawable.restauration));
        l.add(new ListItem("Sel de Mer  ", R.drawable.restauration));
        l.add(new ListItem("La Cave  ", R.drawable.restauration));
        l.add(new ListItem("Chiringuito ", R.drawable.restauration));
        l.add(new ListItem("Beach Barbecue  ", R.drawable.restauration));
        l.add(new ListItem("Pizzeria  ", R.drawable.restauration));
        l.add(new ListItem("Club House  ", R.drawable.restauration));
        l.add(new ListItem("Oasis   ", R.drawable.restauration));
        l.add(new ListItem("Tutti Frutti   ", R.drawable.restauration));
        l.add(new ListItem("Jockey Club  ", R.drawable.restauration));
        l.add(new ListItem("Atrium   ", R.drawable.restauration));
        l.add(new ListItem("Alias   ", R.drawable.restauration));

        CustomListAdapter customAdapter = new CustomListAdapter(getActivity(),l);

        setListAdapter(customAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        return inflater.inflate(activity_restauration_fragment, container, false);
    }


    public void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        // super.onListItemClick(l, v, position, id);

        Toast.makeText(getActivity(), "Position " + position, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getActivity(), ImageGalleryActivity.class);
        List<Photos> photos = null;
        ArrayList<String> url ;
        switch(position){
            case 0:

                photos = CallWebService.CallMazaganWebphoto("MarketPlace");
                Log.println(Log.ASSERT,"","photos Object 3amer"+photos);
                url= new ArrayList<String>() ;
                Log.println(Log.ASSERT,"","ghir les les url :"+url);

                if (photos != null) {
                    for (Photos p : photos) {

                        url.add(p.getPhoto());
                        Log.println(Log.ASSERT, "My test", "" + p.getPhoto());

                    }

                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList(ImageGalleryActivity.KEY_IMAGES, url);
                    bundle.putString(ImageGalleryActivity.KEY_TITLE, "Carosselle image");
                    intent.putExtras(bundle);
                    ImageGalleryActivity.setImageThumbnailLoader(this);
                    ImageGalleryFragment.setImageThumbnailLoader(this);
                    FullScreenImageGalleryActivity.setFullScreenImageLoader(this);
                    // optionally set background color using Palette for full screen images
                    paletteColorType = PaletteColorType.VIBRANT;

                    startActivity(intent);
                }
                else {
                    Log.println(Log.ASSERT,"My test","nooothing");
                    Toast.makeText(getActivity(), "No Picture", Toast.LENGTH_SHORT).show();

                }


                break;




            case 1:




                photos = CallWebService.CallMazaganWebphoto("Olives");
                Log.println(Log.ASSERT,"","photos Object 3amer"+photos);
                url= new ArrayList<String>() ;
                Log.println(Log.ASSERT,"","ghir les les url :"+url);

                if (photos != null) {
                    for (Photos p : photos) {

                        url.add(p.getPhoto());
                        Log.println(Log.ASSERT, "My test", "" + p.getPhoto());

                    }

                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList(ImageGalleryActivity.KEY_IMAGES, url);
                    bundle.putString(ImageGalleryActivity.KEY_TITLE, "Carosselle image");
                    intent.putExtras(bundle);
                    ImageGalleryActivity.setImageThumbnailLoader(this);
                    ImageGalleryFragment.setImageThumbnailLoader(this);
                    FullScreenImageGalleryActivity.setFullScreenImageLoader(this);
                    // optionally set background color using Palette for full screen images
                    paletteColorType = PaletteColorType.VIBRANT;

                    startActivity(intent);
                }
                else {
                    Log.println(Log.ASSERT,"My test","nooothing");
                    Toast.makeText(getActivity(), "No Picture", Toast.LENGTH_SHORT).show();

                }


                break;
            case 2:



                photos = CallWebService.CallMazaganWebphoto("Morjana");
                Log.println(Log.ASSERT,"","photos Object 3amer"+photos);
                url= new ArrayList<String>() ;
                Log.println(Log.ASSERT,"","ghir les les url :"+url);

                if (photos != null) {
                    for (Photos p : photos) {

                        url.add(p.getPhoto());
                        Log.println(Log.ASSERT, "My test", "" + p.getPhoto());

                    }

                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList(ImageGalleryActivity.KEY_IMAGES, url);
                    bundle.putString(ImageGalleryActivity.KEY_TITLE, "Carosselle image");
                    intent.putExtras(bundle);
                    ImageGalleryActivity.setImageThumbnailLoader(this);
                    ImageGalleryFragment.setImageThumbnailLoader(this);
                    FullScreenImageGalleryActivity.setFullScreenImageLoader(this);
                    // optionally set background color using Palette for full screen images
                    paletteColorType = PaletteColorType.VIBRANT;

                    startActivity(intent);
                }
                else {
                    Log.println(Log.ASSERT,"My test","nooothing");
                    Toast.makeText(getActivity(), "No Picture", Toast.LENGTH_SHORT).show();

                }


                break;
            case 3:




                photos = CallWebService.CallMazaganWebphoto("Jin-Ja");
                Log.println(Log.ASSERT,"","photos Object 3amer"+photos);
                url= new ArrayList<String>() ;
                Log.println(Log.ASSERT,"","ghir les les url :"+url);

                if (photos != null) {
                    for (Photos p : photos) {

                        url.add(p.getPhoto());
                        Log.println(Log.ASSERT, "My test", "" + p.getPhoto());

                    }

                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList(ImageGalleryActivity.KEY_IMAGES, url);
                    bundle.putString(ImageGalleryActivity.KEY_TITLE, "Carosselle image");
                    intent.putExtras(bundle);
                    ImageGalleryActivity.setImageThumbnailLoader(this);
                    ImageGalleryFragment.setImageThumbnailLoader(this);
                    FullScreenImageGalleryActivity.setFullScreenImageLoader(this);
                    // optionally set background color using Palette for full screen images
                    paletteColorType = PaletteColorType.VIBRANT;

                    startActivity(intent);
                }
                else {
                    Log.println(Log.ASSERT,"My test","nooothing");
                    Toast.makeText(getActivity(), "No Picture", Toast.LENGTH_SHORT).show();

                }


                break;
            case 4:
                photos = CallWebService.CallMazaganWebphoto("AlFirma");
                Log.println(Log.ASSERT,"","photos Object 3amer"+photos);
                url= new ArrayList<String>() ;
                Log.println(Log.ASSERT,"","ghir les les url :"+url);

                if (photos != null) {
                    for (Photos p : photos) {

                        url.add(p.getPhoto());
                        Log.println(Log.ASSERT, "My test", "" + p.getPhoto());

                    }

                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList(ImageGalleryActivity.KEY_IMAGES, url);
                    bundle.putString(ImageGalleryActivity.KEY_TITLE, "Carosselle image");
                    intent.putExtras(bundle);
                    ImageGalleryActivity.setImageThumbnailLoader(this);
                    ImageGalleryFragment.setImageThumbnailLoader(this);
                    FullScreenImageGalleryActivity.setFullScreenImageLoader(this);
                    // optionally set background color using Palette for full screen images
                    paletteColorType = PaletteColorType.VIBRANT;

                    startActivity(intent);
                }
                else {
                    Log.println(Log.ASSERT,"My test","nooothing");
                    Toast.makeText(getActivity(), "No Picture", Toast.LENGTH_SHORT).show();

                }


                break;




            case 5:



                photos = CallWebService.CallMazaganWebphoto("SeldeMer");
                Log.println(Log.ASSERT,"","photos Object 3amer"+photos);
                url= new ArrayList<String>() ;
                Log.println(Log.ASSERT,"","ghir les les url :"+url);

                if (photos != null) {
                    for (Photos p : photos) {

                        url.add(p.getPhoto());
                        Log.println(Log.ASSERT, "My test", "" + p.getPhoto());

                    }

                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList(ImageGalleryActivity.KEY_IMAGES, url);
                    bundle.putString(ImageGalleryActivity.KEY_TITLE, "Carosselle image");
                    intent.putExtras(bundle);
                    ImageGalleryActivity.setImageThumbnailLoader(this);
                    ImageGalleryFragment.setImageThumbnailLoader(this);
                    FullScreenImageGalleryActivity.setFullScreenImageLoader(this);
                    // optionally set background color using Palette for full screen images
                    paletteColorType = PaletteColorType.VIBRANT;

                    startActivity(intent);
                }
                else {
                    Log.println(Log.ASSERT,"My test","nooothing");
                    Toast.makeText(getActivity(), "No Picture", Toast.LENGTH_SHORT).show();

                }


                break;
            case 6:



                photos = CallWebService.CallMazaganWebphoto("LaCave");
                Log.println(Log.ASSERT,"","photos Object 3amer"+photos);
                url= new ArrayList<String>() ;
                Log.println(Log.ASSERT,"","ghir les les url :"+url);

                if (photos != null) {
                    for (Photos p : photos) {

                        url.add(p.getPhoto());
                        Log.println(Log.ASSERT, "My test", "" + p.getPhoto());

                    }

                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList(ImageGalleryActivity.KEY_IMAGES, url);
                    bundle.putString(ImageGalleryActivity.KEY_TITLE, "Carosselle image");
                    intent.putExtras(bundle);
                    ImageGalleryActivity.setImageThumbnailLoader(this);
                    ImageGalleryFragment.setImageThumbnailLoader(this);
                    FullScreenImageGalleryActivity.setFullScreenImageLoader(this);
                    // optionally set background color using Palette for full screen images
                    paletteColorType = PaletteColorType.VIBRANT;

                    startActivity(intent);
                }
                else {
                    Log.println(Log.ASSERT,"My test","nooothing");
                    Toast.makeText(getActivity(), "No Picture", Toast.LENGTH_SHORT).show();

                }


                break;
            case 7:



                photos = CallWebService.CallMazaganWebphoto("Chiringuito");
                Log.println(Log.ASSERT,"","photos Object 3amer"+photos);
                url= new ArrayList<String>() ;
                Log.println(Log.ASSERT,"","ghir les les url :"+url);

                if (photos != null) {
                    for (Photos p : photos) {

                        url.add(p.getPhoto());
                        Log.println(Log.ASSERT, "My test", "" + p.getPhoto());

                    }

                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList(ImageGalleryActivity.KEY_IMAGES, url);
                    bundle.putString(ImageGalleryActivity.KEY_TITLE, "Carosselle image");
                    intent.putExtras(bundle);
                    ImageGalleryActivity.setImageThumbnailLoader(this);
                    ImageGalleryFragment.setImageThumbnailLoader(this);
                    FullScreenImageGalleryActivity.setFullScreenImageLoader(this);
                    // optionally set background color using Palette for full screen images
                    paletteColorType = PaletteColorType.VIBRANT;

                    startActivity(intent);
                }
                else {
                    Log.println(Log.ASSERT,"My test","nooothing");
                    Toast.makeText(getActivity(), "No Picture", Toast.LENGTH_SHORT).show();

                }


                break;
            case 8:

                photos = CallWebService.CallMazaganWebphoto("BeachBarbecue");
                Log.println(Log.ASSERT,"","photos Object 3amer"+photos);
                url= new ArrayList<String>() ;
                Log.println(Log.ASSERT,"","ghir les les url :"+url);

                if (photos != null) {
                    for (Photos p : photos) {

                        url.add(p.getPhoto());
                        Log.println(Log.ASSERT, "My test", "" + p.getPhoto());

                    }

                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList(ImageGalleryActivity.KEY_IMAGES, url);
                    bundle.putString(ImageGalleryActivity.KEY_TITLE, "Carosselle image");
                    intent.putExtras(bundle);
                    ImageGalleryActivity.setImageThumbnailLoader(this);
                    ImageGalleryFragment.setImageThumbnailLoader(this);
                    FullScreenImageGalleryActivity.setFullScreenImageLoader(this);
                    // optionally set background color using Palette for full screen images
                    paletteColorType = PaletteColorType.VIBRANT;

                    startActivity(intent);
                }
                else {
                    Log.println(Log.ASSERT,"My test","nooothing");
                    Toast.makeText(getActivity(), "No Picture", Toast.LENGTH_SHORT).show();

                }


                break;




            case 9:


                photos = CallWebService.CallMazaganWebphoto("Pizzeria");
                Log.println(Log.ASSERT,"","photos Object 3amer"+photos);
                url= new ArrayList<String>() ;
                Log.println(Log.ASSERT,"","ghir les les url :"+url);

                if (photos != null) {
                    for (Photos p : photos) {

                        url.add(p.getPhoto());
                        Log.println(Log.ASSERT, "My test", "" + p.getPhoto());

                    }

                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList(ImageGalleryActivity.KEY_IMAGES, url);
                    bundle.putString(ImageGalleryActivity.KEY_TITLE, "Carosselle image");
                    intent.putExtras(bundle);
                    ImageGalleryActivity.setImageThumbnailLoader(this);
                    ImageGalleryFragment.setImageThumbnailLoader(this);
                    FullScreenImageGalleryActivity.setFullScreenImageLoader(this);
                    // optionally set background color using Palette for full screen images
                    paletteColorType = PaletteColorType.VIBRANT;

                    startActivity(intent);
                }
                else {
                    Log.println(Log.ASSERT,"My test","nooothing");
                    Toast.makeText(getActivity(), "No Picture", Toast.LENGTH_SHORT).show();

                }


                break;
            case 10:



                photos = CallWebService.CallMazaganWebphoto("ClubHouse");
                Log.println(Log.ASSERT,"","photos Object 3amer"+photos);
                url= new ArrayList<String>() ;
                Log.println(Log.ASSERT,"","ghir les les url :"+url);

                if (photos != null) {
                    for (Photos p : photos) {

                        url.add(p.getPhoto());
                        Log.println(Log.ASSERT, "My test", "" + p.getPhoto());

                    }

                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList(ImageGalleryActivity.KEY_IMAGES, url);
                    bundle.putString(ImageGalleryActivity.KEY_TITLE, "Carosselle image");
                    intent.putExtras(bundle);
                    ImageGalleryActivity.setImageThumbnailLoader(this);
                    ImageGalleryFragment.setImageThumbnailLoader(this);
                    FullScreenImageGalleryActivity.setFullScreenImageLoader(this);
                    // optionally set background color using Palette for full screen images
                    paletteColorType = PaletteColorType.VIBRANT;

                    startActivity(intent);
                }
                else {
                    Log.println(Log.ASSERT,"My test","nooothing");
                    Toast.makeText(getActivity(), "No Picture", Toast.LENGTH_SHORT).show();

                }


                break;
            case 11:




                photos = CallWebService.CallMazaganWebphoto("Oasis");
                Log.println(Log.ASSERT,"","photos Object 3amer"+photos);
                url= new ArrayList<String>() ;
                Log.println(Log.ASSERT,"","ghir les les url :"+url);

                if (photos != null) {
                    for (Photos p : photos) {

                        url.add(p.getPhoto());
                        Log.println(Log.ASSERT, "My test", "" + p.getPhoto());

                    }

                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList(ImageGalleryActivity.KEY_IMAGES, url);
                    bundle.putString(ImageGalleryActivity.KEY_TITLE, "Carosselle image");
                    intent.putExtras(bundle);
                    ImageGalleryActivity.setImageThumbnailLoader(this);
                    ImageGalleryFragment.setImageThumbnailLoader(this);
                    FullScreenImageGalleryActivity.setFullScreenImageLoader(this);
                    // optionally set background color using Palette for full screen images
                    paletteColorType = PaletteColorType.VIBRANT;

                    startActivity(intent);
                }
                else {
                    Log.println(Log.ASSERT,"My test","nooothing");
                    Toast.makeText(getActivity(), "No Picture", Toast.LENGTH_SHORT).show();

                }


                break;
            case 12:

                photos = CallWebService.CallMazaganWebphoto("TuttiFrutti");
                Log.println(Log.ASSERT,"","photos Object 3amer"+photos);
                url= new ArrayList<String>() ;
                Log.println(Log.ASSERT,"","ghir les les url :"+url);

                if (photos != null) {
                    for (Photos p : photos) {

                        url.add(p.getPhoto());
                        Log.println(Log.ASSERT, "My test", "" + p.getPhoto());

                    }

                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList(ImageGalleryActivity.KEY_IMAGES, url);
                    bundle.putString(ImageGalleryActivity.KEY_TITLE, "Carosselle image");
                    intent.putExtras(bundle);
                    ImageGalleryActivity.setImageThumbnailLoader(this);
                    ImageGalleryFragment.setImageThumbnailLoader(this);
                    FullScreenImageGalleryActivity.setFullScreenImageLoader(this);
                    // optionally set background color using Palette for full screen images
                    paletteColorType = PaletteColorType.VIBRANT;

                    startActivity(intent);
                }
                else {
                    Log.println(Log.ASSERT,"My test","nooothing");
                    Toast.makeText(getActivity(), "No Picture", Toast.LENGTH_SHORT).show();

                }


                break;




            case 13:



                photos = CallWebService.CallMazaganWebphoto("JockeyClub");
                Log.println(Log.ASSERT,"","photos Object 3amer"+photos);
                url= new ArrayList<String>() ;
                Log.println(Log.ASSERT,"","ghir les les url :"+url);

                if (photos != null) {
                    for (Photos p : photos) {

                        url.add(p.getPhoto());
                        Log.println(Log.ASSERT, "My test", "" + p.getPhoto());

                    }

                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList(ImageGalleryActivity.KEY_IMAGES, url);
                    bundle.putString(ImageGalleryActivity.KEY_TITLE, "Carosselle image");
                    intent.putExtras(bundle);
                    ImageGalleryActivity.setImageThumbnailLoader(this);
                    ImageGalleryFragment.setImageThumbnailLoader(this);
                    FullScreenImageGalleryActivity.setFullScreenImageLoader(this);
                    // optionally set background color using Palette for full screen images
                    paletteColorType = PaletteColorType.VIBRANT;

                    startActivity(intent);
                }
                else {
                    Log.println(Log.ASSERT,"My test","nooothing");
                    Toast.makeText(getActivity(), "No Picture", Toast.LENGTH_SHORT).show();

                }


                break;
            case 14:



                photos = CallWebService.CallMazaganWebphoto("Atrium");
                Log.println(Log.ASSERT,"","photos Object 3amer"+photos);
                url= new ArrayList<String>() ;
                Log.println(Log.ASSERT,"","ghir les les url :"+url);

                if (photos != null) {
                    for (Photos p : photos) {

                        url.add(p.getPhoto());
                        Log.println(Log.ASSERT, "My test", "" + p.getPhoto());

                    }

                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList(ImageGalleryActivity.KEY_IMAGES, url);
                    bundle.putString(ImageGalleryActivity.KEY_TITLE, "Carosselle image");
                    intent.putExtras(bundle);
                    ImageGalleryActivity.setImageThumbnailLoader(this);
                    ImageGalleryFragment.setImageThumbnailLoader(this);
                    FullScreenImageGalleryActivity.setFullScreenImageLoader(this);
                    // optionally set background color using Palette for full screen images
                    paletteColorType = PaletteColorType.VIBRANT;

                    startActivity(intent);
                }
                else {
                    Log.println(Log.ASSERT,"My test","nooothing");
                    Toast.makeText(getActivity(), "No Picture", Toast.LENGTH_SHORT).show();

                }


                break;
            case 15:



                photos = CallWebService.CallMazaganWebphoto("Alias");
                Log.println(Log.ASSERT,"","photos Object 3amer"+photos);
                url= new ArrayList<String>() ;
                Log.println(Log.ASSERT,"","ghir les les url :"+url);

                if (photos != null) {
                    for (Photos p : photos) {

                        url.add(p.getPhoto());
                        Log.println(Log.ASSERT, "My test", "" + p.getPhoto());

                    }

                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList(ImageGalleryActivity.KEY_IMAGES, url);
                    bundle.putString(ImageGalleryActivity.KEY_TITLE, "Carosselle image");
                    intent.putExtras(bundle);
                    ImageGalleryActivity.setImageThumbnailLoader(this);
                    ImageGalleryFragment.setImageThumbnailLoader(this);

                    FullScreenImageGalleryActivity.setFullScreenImageLoader(this);
                    // optionally set background color using Palette for full screen images
                    paletteColorType = PaletteColorType.VIBRANT;

                    startActivity(intent);
                }
                else {
                    Log.println(Log.ASSERT,"My test","nooothing");
                    Toast.makeText(getActivity(), "No Picture", Toast.LENGTH_SHORT).show();

                }


                break;
        }}


    @Override
    public void loadFullScreenImage(final ImageView iv, String imageUrl, int width, final LinearLayout bglinearLayout) {
        if (!TextUtils.isEmpty(imageUrl)) {
            Picasso.with(iv.getContext())
                    .load(imageUrl)
                    .resize(width, 0)
                    .into(iv, new Callback() {
                        @Override
                        public void onSuccess() {
                            Bitmap bitmap = ((BitmapDrawable) iv.getDrawable()).getBitmap();
                            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                                public void onGenerated(Palette palette) {
                                    applyPalette(palette, bglinearLayout);
                                }
                            });
                        }

                        @Override
                        public void onError() {

                        }
                    });
        } else {
            iv.setImageDrawable(null);
        }
    }

    private void applyPalette(Palette palette, ViewGroup viewGroup){
        int bgColor = getBackgroundColor(palette);
        if (bgColor != -1)
            viewGroup.setBackgroundColor(bgColor);
    }

    private void applyPalette(Palette palette, View view){
        int bgColor = getBackgroundColor(palette);
        if (bgColor != -1)
            view.setBackgroundColor(bgColor);
    }

    private int getBackgroundColor(Palette palette) {
        int bgColor = -1;

        int vibrantColor = palette.getVibrantColor(0x000000);
        int lightVibrantColor = palette.getLightVibrantColor(0x000000);
        int darkVibrantColor = palette.getDarkVibrantColor(0x000000);

        int mutedColor = palette.getMutedColor(0x000000);
        int lightMutedColor = palette.getLightMutedColor(0x000000);
        int darkMutedColor = palette.getDarkMutedColor(0x000000);

        if (paletteColorType != null) {
            switch (paletteColorType) {
                case VIBRANT:
                    if (vibrantColor != 0) { // primary option
                        bgColor = vibrantColor;
                    } else if (lightVibrantColor != 0) { // fallback options
                        bgColor = lightVibrantColor;
                    } else if (darkVibrantColor != 0) {
                        bgColor = darkVibrantColor;
                    } else if (mutedColor != 0) {
                        bgColor = mutedColor;
                    } else if (lightMutedColor != 0) {
                        bgColor = lightMutedColor;
                    } else if (darkMutedColor != 0) {
                        bgColor = darkMutedColor;
                    }
                    break;
                case LIGHT_VIBRANT:
                    if (lightVibrantColor != 0) { // primary option
                        bgColor = lightVibrantColor;
                    } else if (vibrantColor != 0) { // fallback options
                        bgColor = vibrantColor;
                    } else if (darkVibrantColor != 0) {
                        bgColor = darkVibrantColor;
                    } else if (mutedColor != 0) {
                        bgColor = mutedColor;
                    } else if (lightMutedColor != 0) {
                        bgColor = lightMutedColor;
                    } else if (darkMutedColor != 0) {
                        bgColor = darkMutedColor;
                    }
                    break;
                case DARK_VIBRANT:
                    if (darkVibrantColor != 0) { // primary option
                        bgColor = darkVibrantColor;
                    } else if (vibrantColor != 0) { // fallback options
                        bgColor = vibrantColor;
                    } else if (lightVibrantColor != 0) {
                        bgColor = lightVibrantColor;
                    } else if (mutedColor != 0) {
                        bgColor = mutedColor;
                    } else if (lightMutedColor != 0) {
                        bgColor = lightMutedColor;
                    } else if (darkMutedColor != 0) {
                        bgColor = darkMutedColor;
                    }
                    break;
                case MUTED:
                    if (mutedColor != 0) { // primary option
                        bgColor = mutedColor;
                    } else if (lightMutedColor != 0) { // fallback options
                        bgColor = lightMutedColor;
                    } else if (darkMutedColor != 0) {
                        bgColor = darkMutedColor;
                    } else if (vibrantColor != 0) {
                        bgColor = vibrantColor;
                    } else if (lightVibrantColor != 0) {
                        bgColor = lightVibrantColor;
                    } else if (darkVibrantColor != 0) {
                        bgColor = darkVibrantColor;
                    }
                    break;
                case LIGHT_MUTED:
                    if (lightMutedColor != 0) { // primary option
                        bgColor = lightMutedColor;
                    } else if (mutedColor != 0) { // fallback options
                        bgColor = mutedColor;
                    } else if (darkMutedColor != 0) {
                        bgColor = darkMutedColor;
                    } else if (vibrantColor != 0) {
                        bgColor = vibrantColor;
                    } else if (lightVibrantColor != 0) {
                        bgColor = lightVibrantColor;
                    } else if (darkVibrantColor != 0) {
                        bgColor = darkVibrantColor;
                    }
                    break;
                case DARK_MUTED:
                    if (darkMutedColor != 0) { // primary option
                        bgColor = darkMutedColor;
                    } else if (mutedColor != 0) { // fallback options
                        bgColor = mutedColor;
                    } else if (lightMutedColor != 0) {
                        bgColor = lightMutedColor;
                    } else if (vibrantColor != 0) {
                        bgColor = vibrantColor;
                    } else if (lightVibrantColor != 0) {
                        bgColor = lightVibrantColor;
                    } else if (darkVibrantColor != 0) {
                        bgColor = darkVibrantColor;
                    }
                    break;
                default:
                    break;
            }
        }

        return bgColor;
    }



    @Override
    public void loadImageThumbnail(ImageView iv, String imageUrl, int dimension) {
        if (!TextUtils.isEmpty(imageUrl)) {
            Picasso.with(iv.getContext())
                    .load(imageUrl)
                    .resize(dimension, dimension)
                    .centerCrop()
                    .into(iv);
        } else {
            iv.setImageDrawable(null);
        }
    }
}




