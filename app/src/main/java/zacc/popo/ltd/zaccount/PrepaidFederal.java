package zacc.popo.ltd.zaccount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.facebook.ads.AbstractAdListener;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.InterstitialAdListener;

public class PrepaidFederal extends AppCompatActivity {
    EditText mobNo,amtN,lastNo;
    Button recharge;
    private com.facebook.ads.InterstitialAd interstitialAd;
    private com.facebook.ads.AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepaid_federal);

        adView = new com.facebook.ads.AdView(PrepaidFederal.this, getString(R.string.banner_broadbandIcici), AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer =findViewById(R.id.banner_federalP1);
        adContainer.addView(adView);
        adView.setAdListener(new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(PrepaidFederal.this, "Connection issue" + adError.getErrorMessage(),
                        Toast.LENGTH_LONG).show(); }});
        adView.loadAd();
        interstitialAd =new com.facebook.ads.InterstitialAd(PrepaidFederal.this,getString(R.string.interstitial_broadbankIcici));
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
        mobNo = findViewById(R.id.mobPF);
        amtN = findViewById(R.id.amtPF);
        lastNo = findViewById(R.id.mpinPF);
        recharge = findViewById(R.id.rechPF);
        recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String m =mobNo.getText().toString();
                String amt = amtN.getText().toString();
                String l = lastNo.getText().toString();
                String msg = "MTOPUP "+m+" "+amt+" "+l;
                String phNo="9895088888";

                if(m.length()==0){
                    mobNo.setError("Mobile No cannot be empty");
                }else if(m.length()<10 && m.length()>0) {
                    mobNo.setError("Mobile No cannot be less than 10 digit");
                }
                else {
                    Intent intentSms = new Intent(Intent.ACTION_VIEW);
                    intentSms.setType("vnd.android-dir/mms-sms");
                    intentSms.putExtra("sms_body", msg);
                    intentSms.putExtra("address", phNo);
                    if (intentSms.resolveActivity(getPackageManager()) != null) {
                        startActivity(intentSms);
                    } else {
                        Toast.makeText(PrepaidFederal.this, "Application not found", Toast.LENGTH_SHORT).show();
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
