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

public class BankServiceGridAdapter extends ArrayAdapter<BankServicesGridObj> {
    public BankServiceGridAdapter(@NonNull Context context, int resource, @NonNull List<BankServicesGridObj> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.bankservice_layout_grid, parent, false);
        }
        ImageView img = convertView.findViewById(R.id.cus12);
        TextView txt = convertView.findViewById(R.id.cus112);
       BankServicesGridObj customerObj =getItem(position);
        img.setImageResource(customerObj.getResourceIds());
        txt.setText(customerObj.getName());
        return convertView;
    }
}
