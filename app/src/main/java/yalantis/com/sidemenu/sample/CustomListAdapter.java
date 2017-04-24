package yalantis.com.sidemenu.sample;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends ArrayAdapter<ListItem> {

    public CustomListAdapter(Activity context, List<ListItem> items) {
        super(context, R.layout.list_chambre, items);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            if((getContext().getResources().getConfiguration().locale.getLanguage().contentEquals("ar"))){
                v = vi.inflate(R.layout.list, null);
            }
            else {

                v = vi.inflate(R.layout.list_chambre, null);


            }
        }

        ListItem li = getItem(position);

        TextView txtTitle = (TextView) v.findViewById(R.id.item);
        ImageView imageView = (ImageView) v.findViewById(R.id.icon);
        TextView extratxt = (TextView) v.findViewById(R.id.textView1);

        txtTitle.setText(li.getTitle());
        imageView.setImageResource(li.getImage());
        extratxt.setText((CharSequence) li.getDescription());

        return v;

    };
}