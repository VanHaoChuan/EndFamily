package anki.personal.fanhaochuan.mako;

import android.content.*;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.nfc.tech.Ndef;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.IntegerRes;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.CardView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation.*;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.app.*;
import android.webkit.WebView;
import android.widget.*;
import android.view.View.*;
import android.widget.ImageView.*;
import android.media.*;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    int About_Try_Times = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Start_MC();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        CardsOnclick();
        Content_back_color();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.Menu_About:
                Menu_About();
                break;
            case R.id.Menu_Exit:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            //Play_Musics(R.drawable.about_pic, "SITTING_NEXT_TO_U");
            Game_Log();
        }
        if (id == R.id.nav_gallery) {

                Calendar_Show();
        }
        if (id == R.id.nav_slideshow) {
            Jump_QQ("18200425017");

        }
        if (id == R.id.nav_manage) {
            try {
                Login();
            } catch (Exception e) {
                Log.d(null, e.toString());

            }
        }
        if (id == R.id.nav_dayview){
            Day_View();
        }
        if (id == R.id.nav_nightview){
            Night_View();
        }
        if (id == R.id.nav_set){
            Setting();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void CardsOnclick(){
        final CardView Game_Asstes = findViewById(R.id.game_asstes);
        Game_Asstes.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Game_Intent(anki.personal.fanhaochuan.mako.Game_Asstes.class);
            }
        });
        CardView Game_Discussion = findViewById(R.id.game_discussion);
        Game_Discussion.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Game_Intent(anki.personal.fanhaochuan.mako.Game_Discussion.class);
            }
        });
        CardView More_Game = findViewById(R.id.more_games);
        More_Game.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Game_Intent(anki.personal.fanhaochuan.mako.More_Game.class);
            }
        });
    }


    public void Menu_About() {
        final Dialog About_Dialog = new Dialog(this);

        final Dialog Tried_Dialog = new Dialog(MainActivity.this);
        final Button Okey_Button = new Button(this);
        Okey_Button.setText("确认");
        Button About_Button = new Button(this);
        final Button Tried_Button = new Button(this);
        Tried_Button.setText("嗯嗯");
        About_Button.setText("没东西了");
        LinearLayout About_LinearLayout = new LinearLayout(MainActivity.this);
        About_Dialog.setTitle("Just_Develop_For_U");
        About_Dialog.setContentView(About_LinearLayout);
        About_LinearLayout.setOrientation(1);
        About_LinearLayout.addView(About_Button);
        About_LinearLayout.addView(Okey_Button);
        About_Dialog.setCanceledOnTouchOutside(false);
        About_Button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View p1) {

                if (About_Try_Times == 0) {

                    Toast.makeText(MainActivity.this, "哈哈，没啦", Toast.LENGTH_LONG).show();
                    Toast.makeText(MainActivity.this, "真的吗？(多试几次)", Toast.LENGTH_SHORT).show();
                }
                About_Try_Times++;

                if (About_Try_Times == 10) {

                    LinearLayout Tried_LinearLayout = new LinearLayout(MainActivity.this);
                    ImageView Tried_Image = new ImageView(MainActivity.this);
                    Tried_Image.setScaleType((ScaleType.FIT_XY));
                    Tried_Image.setImageResource(R.mipmap.mozu);
                    Tried_LinearLayout.addView(Tried_Image);
                    Tried_LinearLayout.addView(Tried_Button);
                    Tried_LinearLayout.setOrientation(1);
                    Tried_Dialog.setContentView(Tried_LinearLayout);
                    Tried_Dialog.setTitle("嘿嘿");
                    Tried_Dialog.show();
                } else if (About_Try_Times >= 10) {
                    Snackbar.make(p1, "真没啦", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        Okey_Button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View p1) {
                About_Dialog.cancel();
            }
        });
        Tried_Button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View p1) {
                Tried_Dialog.cancel();
            }


        });

        About_Dialog.show();


    }
    public void Calendar_Show() {
        Intent Calendar_Intent = new Intent();
        Calendar_Intent.setClass(MainActivity.this,Calendar_Activity.class);
        startActivity(Calendar_Intent);
    }
    {
/*
public class choose_musics {
        LinearLayout music_linearlayout = new LinearLayout(MainActivity.this);
        final Dialog music_dialog = new Dialog(MainActivity.this);
        Button Music_Button = new Button(MainActivity.this);

        public Dialog Music_Dialog() {
            music_dialog.setContentView(music_linearlayout);
            music_dialog.show();
            return music_dialog;
        }


    }

    public void Play_Musics(int Music_Pic_Id, String Music_Name) {
        choose_musics Choise_Music = new choose_musics();
        Dialog Music_Dialog = Choise_Music.Music_Dialog();
        Animation_Use((View) Choise_Music.music_linearlayout);
        TextView Music_Dialog_Title = new TextView(MainActivity.this);
        Music_Dialog_Title.setText("选一首吧");
        Music_Dialog_Title.setTextSize(15.f);
        Choise_Music.music_linearlayout.setOrientation(LinearLayout.VERTICAL);
        Choise_Music.music_linearlayout.addView(Music_Dialog_Title);
        Choise_Music.music_linearlayout.addView(Music_Names(Music_Name));
        Music_Dialog.setCanceledOnTouchOutside(false);
    }

    void Music_Player(int Music_Raw) {
        MediaPlayer Music_Player = MediaPlayer.create(MainActivity.this, Music_Raw);
        if (!Music_Player.isPlaying()) {
            Music_Player.setLooping(true);
            Music_Player.start();
        }
    }

    public CardView Music_Names(String Name) {
        final TextView Music_Names_Texts = new TextView(MainActivity.this);
        final CardView Music_Names = new CardView(MainActivity.this);
        Music_Names.setClickable(true);
        Music_Names.setElevation(10.0f);
        Music_Names_Texts.setTextSize(35.f);
        Music_Names_Texts.setText(Name);
        Music_Names.addView(Music_Names_Texts);
        Music_Names_Texts.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Music_Names_Texts.getText() == "SITTING_NEXT_TO_U") {
                    Music_Player(R.raw.sickness_cause_love);

                }
            }
        });
        return Music_Names;

    }
*/}//musics
    public void Game_Intent(Class a){
        Intent Game = new Intent();
        Game.setClass(MainActivity.this, a);
        startActivity(Game);
    }
    public void Jump_QQ(String QQ_Number) {
        try {

            Intent intent = new Intent();
            intent.setData(Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3D" + "3h0iN9bPqeZu3T3rY3Ffe1MCFgurADqV"));
            startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "未安装QQ", Toast.LENGTH_LONG).show();
            }
        }
        public void Animation_Use (View view){
            AnimationSet animationSet = new AnimationSet(true);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
            alphaAnimation.setDuration(500);
            animationSet.addAnimation(alphaAnimation);
            view.startAnimation(animationSet);
        }
        public void Login () {
            Intent Login_Intent = new Intent();
            Login_Intent.setClass(MainActivity.this, Login_Activity.class);
            startActivity(Login_Intent);
        }
        public void Night_View() {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            recreate();
        }
        public void Day_View() {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            recreate();
        }
        public void Setting(){
        Game_Intent(Settings_Activity.class);
        }
        public void Content_back_color() {}
    public static String color_num(int len)  {
        try {
            StringBuffer result = new StringBuffer();
            for(int i=0;i<len;i++) {
                result.append(Integer.toHexString(new Random().nextInt(16)));
            }
            return result.toString().toUpperCase();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;

    }
    public void Game_Log(){
        Game_Intent(game_log_Activity.class);
    }
    public void Start_MC(){
        try{
            Intent intent=new Intent();
            intent.setClassName("com.mojang.minecraftpe", "com.mojang.minecraftpe.MainActivity");
            startActivity(intent);
        }catch (Exception e){
            Toast.makeText(MainActivity.this,"安装mc了吗？",Toast.LENGTH_LONG).show();
        }
    }
    }
