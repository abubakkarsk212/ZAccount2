package zacc.popo.ltd.zaccount;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class UssdGridAdapter extends RecyclerView.Adapter<UssdGridAdapter.ContactViewHolder> {
    Context context;
    ArrayList<Obj3> arrayList;
    private ussdListClicked listItemClicked;
    public interface ussdListClicked{
        void onussdListClicked(int itemClickedPos);
    }
    public UssdGridAdapter(Context context, ArrayList<Obj3> arrayList, ussdListClicked listItemClicked) {
        this.context = context;
        this.arrayList = arrayList;
        this.listItemClicked = listItemClicked;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_ussdlist_inflate, parent, false);
        ContactViewHolder contactViewHolder = new ContactViewHolder(v);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Glide.with(holder.img.getContext())
                .load(arrayList.get(position).getImgUrl())
                .into(holder.img);
            holder.textView.setText(arrayList.get(position).getTitle());


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
            img= itemView.findViewById(R.id.ussdImg);
            textView = itemView.findViewById(R.id.ussdText);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int itemPos =getAdapterPosition();
            listItemClicked.onussdListClicked(itemPos);
        }
    }
}
