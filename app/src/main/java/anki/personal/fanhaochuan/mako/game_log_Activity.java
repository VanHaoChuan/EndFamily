package anki.personal.fanhaochuan.mako;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.support.v7.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;

import java.io.File;
import java.io.FileInputStream;

public class game_log_Activity extends Activity {
    File file;
    TextView Logs;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.game_log_main);
        SearchView search = findViewById(R.id.Search_Logs);
        search.setSubmitButtonEnabled(true);
        search.setQueryHint("搜索日志");
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Strings.Logs_Search = newText;
                for (String file:fileList()){
                    if (newText == file)
                    Toast.makeText(game_log_Activity.this,file,Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        Write_Titles();
        FloatingActionButton write_fab = findViewById(R.id.write_logs);
        write_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Write = new Intent();
                Write.setClass(game_log_Activity.this,Write_logs_Activity.class);
                startActivity(Write);
            }
        });

    }
    public void Write_Titles(){
        for (String file:fileList())
        Show_Logs((LinearLayout)findViewById(R.id.game_log_linear),file);
    }
    public void Show_Logs(LinearLayout layouts, String File_Names){
        CardView File_Cards = new CardView(game_log_Activity.this);
        LinearLayout.LayoutParams params_card = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
                LinearLayout.LayoutParams params_text = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
                Logs = new TextView(game_log_Activity.this);
        Logs.setText(File_Names);
        Logs.setTextSize(20);
        Logs.setLayoutParams(params_text);
        params_text.setMargins(20,20,20,20);
        File_Cards.addView(Logs);
        Logs.setGravity(Gravity.CENTER);
        Logs.setTextSize(20f);
        File_Cards.setCardElevation(20);
        File_Cards.setClickable(true);
        File_Cards.setLayoutParams(params_card);
        params_card.setMargins(10,10,10,10);
        layouts.addView(File_Cards);
        CardClick(File_Cards);
    }
    private String read(String File_Name)
    {
        try
        {
            // 打开文件输入流
            FileInputStream fis = openFileInput(File_Name);
            byte[] buff = new byte[1024];
            int hasRead = 0;
            StringBuilder sb = new StringBuilder("");
            while ((hasRead = fis.read(buff)) > 0)
            {
                sb.append(new String(buff, 0, hasRead));
            }
            return sb.toString();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public boolean CardClick(CardView cards){
        cards.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Dialog CardLong = new Dialog(game_log_Activity.this);
                LinearLayout CardLinear = new LinearLayout(game_log_Activity.this);
                CardLinear.setOrientation(LinearLayout.VERTICAL);
                Button Delete_but = new Button(game_log_Activity.this);
                Delete_but.setText("删除");
                Delete_but.setGravity(Gravity.CENTER);
                CardLinear.addView(Delete_but);
                Delete_but.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Snackbar.make(v, "sorry,自己写的日志就是不能删", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                });
                CardLong.setContentView(CardLinear);
                CardLong.show();
                return false;
            }
        });
        return true;
    }
    public class ThreadTest implements Runnable {
        public void run() {
            Log.e("Thread","I'm running!");
        }
    }
}
