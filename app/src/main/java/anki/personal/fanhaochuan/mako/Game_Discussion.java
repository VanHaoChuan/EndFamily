package anki.personal.fanhaochuan.mako;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Game_Discussion extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.game_discussions);
        WebView Game_Discussion_Web = findViewById(R.id.Game_Discussion);
        WebSettings Game_Asstes_Web_Setting = Game_Discussion_Web.getSettings();
        Game_Asstes_Web_Setting.setJavaScriptEnabled(true);
        Game_Discussion_Web.loadUrl("http://www.mcbbs.net/forum.php");

        final WebView more_games_webview = findViewById(R.id.Game_Discussion);
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

