package zacc.popo.ltd.zaccount;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;

public class SplashScreen extends AppCompatActivity {
    Uri deepLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

//        FirebaseDynamicLinks.getInstance()
//                .getDynamicLink(getIntent())
//                .addOnSuccessListener(this, new OnSuccessListener<PendingDynamicLinkData>() {
//                    @Override
//                    public void onSuccess(PendingDynamicLinkData pendingDynamicLinkData) {
//                        // Get deep link from result (may be null if no link is found)
//                        deepLink = null;
//                        if (pendingDynamicLinkData != null) {
//                            deepLink = pendingDynamicLinkData.getLink();
//
//                        }
//
//
//                        // Handle the deep link. For example, open the linked
//                        // content, or apply promotional credit to the user's
//                        // account.
//                        // ...
//
//                        // ...
//                    }
//                })
//                .addOnFailureListener(this, new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(SplashScreen.this, "Link not exist any more", Toast.LENGTH_SHORT).show();
//                    }
//                });
    }
    @Override
    protected void onResume() {

            Thread t = new Thread() {
                public void run() {
                    try {
                        Thread.sleep(3000);

//                        if(deepLink == null) {
                            Intent i = new Intent(SplashScreen.this, MainActivity.class);
                            startActivity(i);

//                        }else {
//                            Intent i1 = new Intent("axisbank",deepLink);
//
//                            startActivity(i1);
//                        }
                        finish();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            };
            t.start();
            super.onResume();




    }
}
