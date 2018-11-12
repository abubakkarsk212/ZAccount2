package zacc.popo.ltd.zaccount;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomerGridAdapter extends ArrayAdapter<CustomerObj> {
    public CustomerGridAdapter(@NonNull Context context, int resource, @NonNull List<CustomerObj> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.customer_layout_grid, parent, false);
        }
        ImageView img = convertView.findViewById(R.id.cus1);
        TextView txt = convertView.findViewById(R.id.cus11);
        CustomerObj customerObj =getItem(position);
        img.setImageResource(customerObj.getResourceIds());
        txt.setText(customerObj.getName());
        return convertView;
    }
}
