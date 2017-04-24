package yalantis.com.sidemenu.sample;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import android.support.v4.app.ListFragment;
import android.support.v7.graphics.Palette;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.etiennelawlor.imagegallery.library.ImageGalleryFragment;
import com.etiennelawlor.imagegallery.library.activities.FullScreenImageGalleryActivity;
import com.etiennelawlor.imagegallery.library.activities.ImageGalleryActivity;
import com.etiennelawlor.imagegallery.library.adapters.FullScreenImageGalleryAdapter;
import com.etiennelawlor.imagegallery.library.adapters.ImageGalleryAdapter;
import com.etiennelawlor.imagegallery.library.enums.PaletteColorType;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import tools.CallWebService;
import tools.Photos;

import static yalantis.com.sidemenu.sample.R.layout.activity_excursion_fragment;

public class ExcursionFragment extends ListFragment implements ImageGalleryAdapter.ImageThumbnailLoader, FullScreenImageGalleryAdapter.FullScreenImageLoader{
    private PaletteColorType paletteColorType;


    private List<ListItem> l;

    public ExcursionFragment() {

        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        l = new ArrayList<ListItem>();

        l.add(new ListItem("El jadida", R.drawable.jadida));
        l.add(new ListItem("Azemmour", R.drawable.azem));
        l.add(new ListItem("Oualidia", R.drawable.oua));
        l.add(new ListItem("Casablanca", R.drawable.casa));
        l.add(new ListItem("Marrakech", R.drawable.kech));
        l.add(new ListItem("Rabat", R.drawable.rabat));







        CustomListAdapter customAdapter = new CustomListAdapter(getActivity(),l);

        setListAdapter(customAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(activity_excursion_fragment, container, false);
    }


    public void onListItemClick(ListView l, View v, int position, long id) {



        super.onListItemClick(l, v, position, id);

        Toast.makeText(getActivity(), "Position " + position, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), ImageGalleryActivity.class);
        List<Photos> photos = null;
        ArrayList<String> url ;
        switch(position){
            case 0:

                photos = CallWebService.CallMazaganWebphoto("ElJadida");
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



                photos = CallWebService.CallMazaganWebphoto("Azemmour");
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

                photos = CallWebService.CallMazaganWebphoto("Oualidia");
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



                photos = CallWebService.CallMazaganWebphoto("Casablanca");
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



                photos = CallWebService.CallMazaganWebphoto("Marrakech");
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




                photos = CallWebService.CallMazaganWebphoto("Rabat");
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





