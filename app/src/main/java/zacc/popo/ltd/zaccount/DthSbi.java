package zacc.popo.ltd.zaccount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.facebook.ads.AbstractAdListener;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.InterstitialAdListener;

public class DthSbi extends AppCompatActivity {
    EditText mobNo,amunt,userid,mPin;
    Button recharge;
    Spinner spinner;
    String[] provider = {"Select Provider","Tata Sky","Big Tv","Sun Direct","Dish Tv"};
    String proVider ="";
    private com.facebook.ads.InterstitialAd interstitialAd;
    private com.facebook.ads.AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dth_sbi);
        adView = new com.facebook.ads.AdView(DthSbi.this, getString(R.string.banner_DthSbi), AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer =findViewById(R.id.banner_sbiDth1);
        adContainer.addView(adView);
        adView.setAdListener(new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(DthSbi.this, "Connection issue" + adError.getErrorMessage(),
                        Toast.LENGTH_LONG).show(); }});
        adView.loadAd();
        interstitialAd =new com.facebook.ads.InterstitialAd(DthSbi.this,getString(R.string.interstitial_DthSbi));
        interstitialAd.setAdListener(new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) { }
            @Override
            public void onInterstitialDismissed(Ad ad) { }
            @Override
            public void onError(Ad ad, AdError adError) { }
            @Override
            public void onAdLoaded(Ad ad) { }
            @Override
            public void onAdClicked(Ad ad) { }
            @Override
            public void onLoggingImpression(Ad ad) { }});
        interstitialAd.loadAd();
        spinner = findViewById(R.id.provider);
        mobNo = findViewById(R.id.cusId);
        amunt = findViewById(R.id.amtD2);
        userid = findViewById(R.id.uIdD2);
        mPin = findViewById(R.id.mpinD2);
        recharge = findViewById(R.id.rechD2);
        ArrayAdapter arrayAdapter = new ArrayAdapter(DthSbi.this,android.R.layout.simple_spinner_dropdown_item,provider);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 1){
                    proVider = "TataSky";
                }
                else if(i == 2){
                    proVider ="BigTv";
                }else if(i == 3){
                    proVider = "SunDirect";
                }
                else if(i == 4){
                    proVider = "DishTv";
                }
                else {
                    proVider = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

            recharge.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String phNo = "9223440000";
                    String mob = mobNo.getText().toString();
                    String amt = amunt.getText().toString();
                    String uid = userid.getText().toString();
                    String mpi = mPin.getText().toString();
                    String msg = "Sdth " + uid + " " + mpi + " " + proVider + " " + mob + " " + amt;
                    if(mob.length()==0){
                     mobNo.setError("Customer Id cannot be empty");
        }else if(mob.length()<10 && mobNo.length()>0) {
            mobNo.setError("Customer Id cannot be less than 10 digit");
        }
                else {
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address", phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        } else {
                            Toast.makeText(DthSbi.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        }
    @Override
    public void onBackPressed() {
        if (interstitialAd.isAdLoaded()) {
            interstitialAd.show();
            interstitialAd.setAdListener(new AbstractAdListener() {
                @Override
                public void onInterstitialDismissed(Ad ad) {
                    super.onInterstitialDismissed(ad);
                    finish();
                }}); }
        else {
            super.onBackPressed(); } }
    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy(); }
        if (interstitialAd != null) {
            interstitialAd.destroy(); }
        super.onDestroy(); }
    }

