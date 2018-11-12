package zacc.popo.ltd.zaccount;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
public class Invite extends AppCompatActivity {
    private  InterstitialAd mInterstitial;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite);
    }
    public void gmail(View view) {
        Intent intent1 = new Intent(Intent.ACTION_SENDTO);
        intent1.setData(Uri.parse("mailto:"));
        String link = "http://play.google.com/store/apps/details?id=zacc.popo.ltd.zaccount";
        String subject = "A simple guidelines to open Zero balance saving account.An android app available in play store";
        intent1.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent1.putExtra(Intent.EXTRA_TEXT,"Hey!" +
                "\n I got a new awesome app called ZAccount that lets you find all information on Zero balance saving bank account.It gives you a fully A-Z guide to open account in the app itself.It gives you full Bank Customer Care No, Provides Banking Services(Now you able to Check bank balance).All in one app\n\n Try it :"+ " "+ link);
        if (intent1.resolveActivity(getPackageManager()) != null) {
            startActivity(intent1); } }
    public void text(View view) {
        Intent intentSms = new Intent(Intent.ACTION_VIEW);
        intentSms.setType("vnd.android-dir/mms-sms");
        String link = "http://play.google.com/store/apps/details?id=zacc.popo.ltd.zaccount";
        intentSms.putExtra("sms_body", "Hey!" +
                "\n I got a new awesome app called ZAccount that lets you find all information on Zero balance saving bank account.It gives you a fully A-Z guide to open account in the app itself.It gives you full Bank Customer Care No, Provides Banking Services(Now you able to Check bank balance).All in one app\n\n Try it :"+ " "+ link);
        if (intentSms.resolveActivity(getPackageManager()) != null) {
            startActivity(intentSms); } }
    public void whatsapp(View view) {
        boolean isWhatsAppInstalled = true;
        if (isWhatsAppInstalled) {
            Intent intentW = new Intent();
            intentW.setAction(Intent.ACTION_SEND);
            String link = "http://play.google.com/store/apps/details?id=zacc.popo.ltd.zaccount";
            intentW.setType("text/plain");
            intentW.setPackage("com.whatsapp");
            intentW.putExtra(Intent.EXTRA_TEXT, "Hey!" +
                    "\n I got a new awesome app called ZAccount that lets you find all information on Zero balance saving bank account.It gives you a fully A-Z guide to open account in the app itself.It gives you full Bank Customer Care No, Provides Banking Services(Now you able to Check bank balance).All in one app\n\n Try it :"+ " "+ link);
            if (intentW.resolveActivity(getPackageManager()) != null) {
                startActivity(intentW);
            } else {
                Uri uri = Uri.parse("market://details?id=com.whatsapp");
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                Toast.makeText(this, "WhatsApp is not installed", Toast.LENGTH_SHORT).show();
                startActivity(goToMarket); } } }
}
