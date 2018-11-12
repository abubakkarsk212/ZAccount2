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

public class BroadbandIciciR extends AppCompatActivity {
EditText broadNo,operator,amtN,mpin1;
Button recharge;
    private com.facebook.ads.InterstitialAd interstitialAd;
    private com.facebook.ads.AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadband_icici_r);
        adView = new com.facebook.ads.AdView(BroadbandIciciR.this, getString(R.string.banner_broadbandIcici), AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer =findViewById(R.id.banner_iciciBro1);
        adContainer.addView(adView);
        adView.setAdListener(new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(BroadbandIciciR.this, "Connection issue" + adError.getErrorMessage(),
                        Toast.LENGTH_LONG).show(); }});
        adView.loadAd();
        interstitialAd =new com.facebook.ads.InterstitialAd(BroadbandIciciR.this,getString(R.string.interstitial_broadbankIcici));
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
        broadNo = findViewById(R.id.broadBandNI);
        operator = findViewById(R.id.operatBrI);
        amtN = findViewById(R.id.amtBrI);
        mpin1 = findViewById(R.id.mpinBrI);
        recharge = findViewById(R.id.rechBrI);
        recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String b = broadNo.getText().toString();
                String o = operator.getText().toString();
                String amt = amtN.getText().toString();
                String ld = mpin1.getText().toString();
                String msg ="MTOPUPY "+b+" "+o+" "+amt+" "+ld;
                String phNo = "9222208888";
                if(b.length()==0){
                    broadNo.setError("Filled cannot be empty");
                }
                else {
                    Intent intentSms = new Intent(Intent.ACTION_VIEW);
                    intentSms.setType("vnd.android-dir/mms-sms");
                    intentSms.putExtra("sms_body", msg);
                    intentSms.putExtra("address", phNo);
                    if (intentSms.resolveActivity(getPackageManager()) != null) {
                        startActivity(intentSms);
                    } else {
                        Toast.makeText(BroadbandIciciR.this, "Application not found", Toast.LENGTH_SHORT).show();
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
