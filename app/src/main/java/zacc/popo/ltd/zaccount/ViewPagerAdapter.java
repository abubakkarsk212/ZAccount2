package zacc.popo.ltd.zaccount;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ViewPagerAdapter extends PagerAdapter {
    private Context mContext;
    private ArrayList<ViewPagerUrlObj> ids;
    public ViewPagerAdapter(Context context, ArrayList<ViewPagerUrlObj> ids) {
        this.mContext = context;
        this.ids = ids;
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup collection, int position) {
//        ModelObject modelObject = ModelObject.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.custom_viewpager_layout, collection, false);
        ViewPagerUrlObj viewPagerUrlObj = ids.get(position);
        ImageView img = layout.findViewById(R.id.imageViewP);
        Glide.with(img.getContext())
                .load(viewPagerUrlObj.getUrl())
                .into(img);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewPagerUrlObj.getChannelid().equals("savingaccount") ||viewPagerUrlObj.getChannelid().equals("promotion")){
                    Intent i = new Intent(mContext, BankPage.class);
                    i.putExtra("key", viewPagerUrlObj.getBankid());
                    i.putExtra("flag", Integer.parseInt(viewPagerUrlObj.getFlag()));
                    i.putExtra("title", viewPagerUrlObj.getType());
                    mContext.startActivity(i);
                }
                else if(viewPagerUrlObj.getChannelid().equals("appupdate") || viewPagerUrlObj.getChannelid().equals("feedback")){

                    try {
                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + "zacc.popo.ltd.zaccount"));
                        mContext.startActivity(i);
                    } catch (android.content.ActivityNotFoundException anfe) {
                        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + "zacc.popo.ltd.zaccount"));
                        mContext.startActivity(i);
                    }
                }
                else if(viewPagerUrlObj.getChannelid().equals("bankservice")){
                    Intent i = new Intent(mContext, SelectBank.class);
                    i.putExtra("key", viewPagerUrlObj.getBankid());
                    i.putExtra("type", viewPagerUrlObj.getType());
                    i.putExtra("title",viewPagerUrlObj.getFlag());
                    mContext.startActivity(i);
                }
                else if(viewPagerUrlObj.getChannelid().equals("newsletter") || viewPagerUrlObj.getChannelid().equals("feedback")){
                    Intent i = new Intent(mContext, Web_Page.class);
                    i.putExtra("key",viewPagerUrlObj.getBankid());
                    i.putExtra("title",viewPagerUrlObj.getType());
                    mContext.startActivity(i);
                }
            }
        });
        collection.addView(layout);
        return layout;
    }
    @Override
    public int getCount() {
        return ids.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
