package zacc.popo.ltd.zaccount;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

public class OfferListAdapter extends ArrayAdapter<OfferProgressObj> {

    public OfferListAdapter(@NonNull Context context, int resource, @NonNull List<OfferProgressObj> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.offer_list, parent, false);
        }
        ImageView img = convertView.findViewById(R.id.imageList);
        OfferProgressObj offerListObj =getItem(position);
        Glide.with(img.getContext())
                .load(offerListObj.getPhotoUrl())
                .into(img);
        return convertView;
    }
}
