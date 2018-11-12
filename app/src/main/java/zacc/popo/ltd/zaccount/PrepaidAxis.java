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

public class PrepaidAxis extends AppCompatActivity {
EditText mobNo,operator,amount,acct;
Button rechAx;
    private com.facebook.ads.InterstitialAd interstitialAd;
    private com.facebook.ads.AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepaid_axis);
        adView = new com.facebook.ads.AdView(PrepaidAxis.this, getString(R.string.banner_broadbandAXis), AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer =findViewById(R.id.banner_axisprepaid1);
        adContainer.addView(adView);
        adView.setAdListener(new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(PrepaidAxis.this, "Connection issue" + adError.getErrorMessage(),
                        Toast.LENGTH_LONG).show(); }});
        adView.loadAd();
        interstitialAd =new com.facebook.ads.InterstitialAd(PrepaidAxis.this,getString(R.string.interstitial_broadbankAxis));
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
        mobNo = findViewById(R.id.mobAx);
        operator = findViewById(R.id.operatAx);
        amount = findViewById(R.id.amtAx);
        acct = findViewById(R.id.mpinAx);
        rechAx = findViewById(R.id.rechAx);
        rechAx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phNo = "5676782";
                String mob = mobNo.getText().toString();
                String opt = operator.getText().toString();
                String amt = amount.getText().toString();
                String mpi = acct.getText().toString();
                String msg = "MOBILE " + mob + " " + opt + " " + amt + " " + mpi;
                if (mob.length() == 0) {
                    mobNo.setError("Mobile No cannot be empty");
                } else if (mob.length() < 10 && mobNo.length() > 0) {
                    mobNo.setError("Mobile No cannot be less than 10 digit");
                } else {
                    Intent intentSms = new Intent(Intent.ACTION_VIEW);
                    intentSms.setType("vnd.android-dir/mms-sms");
                    intentSms.putExtra("sms_body", msg);
                    intentSms.putExtra("address", phNo);
                    if (intentSms.resolveActivity(getPackageManager()) != null) {
                        startActivity(intentSms);
                    } else {
                        Toast.makeText(PrepaidAxis.this, "Application not found", Toast.LENGTH_SHORT).show();
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
