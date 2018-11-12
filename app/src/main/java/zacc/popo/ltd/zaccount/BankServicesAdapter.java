package zacc.popo.ltd.zaccount;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BankServicesAdapter extends RecyclerView.Adapter<BankServicesAdapter.ServicetViewHolder> {
    Context context;
    ArrayList<BankServicesHObj> arrayList;
    private ListItemClickedBank listItemClicked;
    public interface ListItemClickedBank{
        void onListItemClicked1(int itemClickedPos);
    }

    public BankServicesAdapter(Context context, ArrayList<BankServicesHObj> arrayList,ListItemClickedBank listItemClicked) {
        this.context = context;
        this.arrayList = arrayList;
        this.listItemClicked = listItemClicked;
    }

    @Override
    public ServicetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bank_services_inflate, parent, false);
        ServicetViewHolder contactViewHolder = new ServicetViewHolder(v);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ServicetViewHolder holder, int position) {
        holder.img.setImageResource(arrayList.get(position).getResourceIds());
        holder.textView.setText(arrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    class ServicetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView textView;
        public ImageView img;
        public ServicetViewHolder(View itemView) {
            super(itemView);
            img= itemView.findViewById(R.id.bankServiceImgs);
            textView = itemView.findViewById(R.id.textbservice);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int itemPos = getAdapterPosition();
            listItemClicked.onListItemClicked1(itemPos);
        }
    }
}
