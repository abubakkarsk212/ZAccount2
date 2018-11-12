package zacc.popo.ltd.zaccount;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    Context context;
    ArrayList<ContactCusHObj> arrayList;
    private ListItemClicked listItemClicked;
    public interface ListItemClicked{
        void onListItemClicked(int itemClickedPos);
    }
    public ContactAdapter(Context context, ArrayList<ContactCusHObj> arrayList,ListItemClicked listItemClicked) {
        this.context = context;
        this.arrayList = arrayList;
        this.listItemClicked = listItemClicked;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_inflate, parent, false);
        ContactViewHolder contactViewHolder = new ContactViewHolder(v);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {

holder.img.setImageResource(arrayList.get(position).getResourceIds());
holder.textView.setText(arrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView textView;
        public ImageView img;
        public ContactViewHolder(View itemView) {
            super(itemView);
            img= itemView.findViewById(R.id.axisHori);
            textView = itemView.findViewById(R.id.textHori);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int itemPos =getAdapterPosition();
            listItemClicked.onListItemClicked(itemPos);
        }
    }
}
