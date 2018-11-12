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

public class DthFederal extends AppCompatActivity {
    EditText mobNo,amunt,mPin;
    Button recharge1;
    Spinner spinner1;
    String[] provider1 = {"Select Provider","Airtel Digital Tv","Tata Sky","Big Tv","Sun Direct","Dish Tv","Videocon D2H"};
    String proVider ="";
    private com.facebook.ads.InterstitialAd interstitialAd;
    private com.facebook.ads.AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dth_federal);
        adView = new com.facebook.ads.AdView(DthFederal.this, getString(R.string.banner_DthFederal), AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer =findViewById(R.id.banner_federalDt1);
        adContainer.addView(adView);
        adView.setAdListener(new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(DthFederal.this, "Connection issue" + adError.getErrorMessage(),
                        Toast.LENGTH_LONG).show(); }});
        adView.loadAd();
        interstitialAd =new com.facebook.ads.InterstitialAd(DthFederal.this,getString(R.string.interstitial_DthFederal));
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

        spinner1 = findViewById(R.id.providerF);
        mobNo = findViewById(R.id.cusIdF);
        amunt = findViewById(R.id.amtD2F);
        mPin = findViewById(R.id.mpinD2F);
        recharge1 = findViewById(R.id.rechD2F);
        ArrayAdapter arrayAdapter = new ArrayAdapter(DthFederal.this,android.R.layout.simple_spinner_dropdown_item,provider1);
        spinner1.setAdapter(arrayAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 1){
                    proVider = "A";
                }
                else if(i == 2){
                    proVider = "T";
                }else if(i == 3){
                    proVider ="B";

                }
                else if(i == 4){
                    proVider = "S";

                }
                else if(i == 5){
                    proVider = "D";
                }
                else if(i == 6){
                    proVider ="V";
                }
                else {
                    proVider = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        recharge1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phNo = "9895088888";
                String mob = mobNo.getText().toString();
                String amt = amunt.getText().toString();
                String mpi = mPin.getText().toString();
                String msg = "DTH " +proVider + " "+mob+" "  + amt+ " "+mpi;
                if(mob.length()==0){
                    mobNo.setError("Customer Id cannot be empty");
                }
                else {
                    Intent intentSms = new Intent(Intent.ACTION_VIEW);
                    intentSms.setType("vnd.android-dir/mms-sms");
                    intentSms.putExtra("sms_body", msg);
                    intentSms.putExtra("address", phNo);
                    if (intentSms.resolveActivity(getPackageManager()) != null) {
                        startActivity(intentSms);
                    } else {
                        Toast.makeText(DthFederal.this, "Application not found", Toast.LENGTH_SHORT).show();
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
