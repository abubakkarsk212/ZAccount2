package zacc.popo.ltd.zaccount;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProcessAdapter extends RecyclerView.Adapter<ProcessAdapter.ContactViewHolder> {
    Context context;
    ArrayList<ProcessObj> arrayList;
    public ProcessAdapter(Context context, ArrayList<ProcessObj> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.process_open_layout, parent, false);
        ContactViewHolder contactViewHolder = new ContactViewHolder(v);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        final ProcessObj a = arrayList.get(position);
holder.textView.setText(a.getSteps());
if(a.getCounter().equals("")){
    holder.counterLL.setVisibility(View.GONE);
}else{
    holder.counterT.setText(a.getCounter());
}
        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.shared_pref),Context.MODE_PRIVATE);
       SharedPreferences.Editor editor = sharedPref.edit();
if((a.getIsButton()).equals("1")){
    holder.actionButton.setText(a.getButtontext());
    holder.actionButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int noOfVisits = sharedPref.getInt("isRate",1);
            if(noOfVisits!= -1){
                noOfVisits+=2;
                editor.putInt("isRate",noOfVisits);
                editor.apply();
            }
            if((a.getIsPlayOrLink()).equals("play")){
                boolean isAppInstalled = appInstalledOrNot(a.getLink());
                if(isAppInstalled){
                    Intent LaunchIntent = context.getPackageManager()
                            .getLaunchIntentForPackage(a.getLink());
                    context.startActivity(LaunchIntent);
                }
                else {
                    try {
                        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + a.getLink())));
                    } catch (android.content.ActivityNotFoundException anfe) {
                        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + a.getLink())));
                    }
                }

            }
            else if((a.getIsPlayOrLink()).equals("link")){
            //Code to go webview
                Intent i = new Intent(context, Web_Page.class);
                i.putExtra("key",a.getLink());
                i.putExtra("title",a.getWebtitle());
                context.startActivity(i);
            }

            else if((a.getIsPlayOrLink()).equals("blocator")){
               Intent i= new Intent(context,SelectBank.class);
                i.putExtra("key",a.getLink());
                i.putExtra("type","db");
                i.putExtra("title",a.getButtontext());
                context.startActivity(i);
            }
            else{
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(a.getLink()));
                context.startActivity(browserIntent);
            }
        }
    });
}
else {
    holder.actionButton.setVisibility(View.GONE);
}

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder{
        public TextView counterT;
        public TextView textView;
        TextView actionButton;
        LinearLayout counterLL;
        public ContactViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textC);
            counterT = itemView.findViewById(R.id.counter);
            actionButton = itemView.findViewById(R.id.clickB);
            counterLL = itemView.findViewById(R.id.counterLL);
        }

    }
    private boolean appInstalledOrNot(String uri) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
        }

        return false;
    }
}
