package anki.personal.fanhaochuan.mako;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Game_Asstes extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    super.setContentView(R.layout.game_asstes);
        WebView Game_Asstes_Web = findViewById(R.id.Game_Asstes);
        WebSettings Game_Asstes_Web_Setting = Game_Asstes_Web.getSettings();
        Game_Asstes_Web_Setting.setJavaScriptEnabled(true);
        Game_Asstes_Web.loadUrl("http://www.secretmine.net/minecraftpe");

        final WebView more_games_webview = findViewById(R.id.Game_Asstes);
        more_games_webview.setWebViewClient(new WebViewClient() {
                                                @Override
                                                public boolean shouldOverrideUrlLoading(WebView view, String request) {
                                                    more_games_webview.loadUrl(request);
                                                    return true;
                                                }
                                            }
        );
    }

}
