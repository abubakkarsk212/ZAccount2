package zacc.popo.ltd.zaccount;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;

public class Web_Page extends AppCompatActivity {
    WebView lView;
    ProgressBar progressBar;
    String title;
    RelativeLayout rl;
    TextView webtext;
    ImageView refresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web__page);
        webtext = findViewById(R.id.webtext);
        refresh = findViewById(R.id.imgRefresh);
        if(!isConnected()){
            Snackbar snackbar = Snackbar
                    .make(rl, "No internet connection available", Snackbar.LENGTH_LONG);
            snackbar.show();
        }

        lView = findViewById(R.id.lrweb);
        progressBar = findViewById(R.id.landProgress);
        Intent getUrl = getIntent();
        final String webUrl = getUrl.getStringExtra("key");
       title = getUrl.getStringExtra("title");
        WebSettings settings = lView.getSettings();
        settings.setDomStorageEnabled(true);
//        webR.setColorScheme(R.color.colorExtra);
        lView.setWebViewClient(new MyBrowser());
        //initial url
        lView.getSettings().setLoadsImagesAutomatically(true);
        lView.getSettings().setJavaScriptEnabled(true);
        lView.getSettings().setLoadWithOverviewMode(true);
        lView.getSettings().setUseWideViewPort(true);
        lView.getSettings().setBuiltInZoomControls(true);
        lView.setVerticalScrollBarEnabled(false);
        lView.setHorizontalScrollBarEnabled(false);
        lView.loadUrl(webUrl);
        lView.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
            }

        });
        webtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(webUrl));
                startActivity(browserIntent);
            }
        });
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String newUrl = lView.getUrl();
//                lView.setWebViewClient(new MyBrowser());
                lView.loadUrl(newUrl);
                progressBar.setVisibility(View.VISIBLE);

                lView.setWebViewClient(new WebViewClient() {

                    public void onPageFinished(WebView view, String url) {
                        progressBar.setVisibility(View.GONE);
                    }

                });

            }


        });

    }
    class MyBrowser extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {

            view.loadUrl(url);
            return true;
        }

    }
   //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        menu.add("Share").setIcon(R.drawable.ic_refresh_black_24dp).setShowAsAction(1);
//        return true;
//    }
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//
//
//        //noinspection SimplifiableIfStatement
//     if(item != null) {
//         if (item.getTitle().equals("Share")) {
//             String newUrl = lView.getUrl();
////                lView.setWebViewClient(new MyBrowser());
//             lView.loadUrl(newUrl);
//             progressBar.setVisibility(View.VISIBLE);
//
//             lView.setWebChromeClient(new WebChromeClient() {
//                 public void onProgressChanged(WebView view, int progress) {
//                     //Make the bar disappear after URL is loaded, and changes string to Loading...
//                     setTitle(title);
//
////                        setProgress(progress * 100); //Make the bar disappear after URL is loaded
//                     progressBar.setProgress(progress);
//
//                     // Return the app name after finish loading
//
//                 }
//
//             });
//             lView.setWebViewClient(new WebViewClient() {
//
//                 public void onPageFinished(WebView view, String url) {
//                     progressBar.setVisibility(View.GONE);
//                 }
//
//             });
//
//         }
//     }
//        return super.onOptionsItemSelected(item);
//    }
public boolean isConnected(){
    ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
    boolean isConnected = activeNetwork !=null && activeNetwork.isConnectedOrConnecting();
    return isConnected;
}
}
