package anki.personal.fanhaochuan.mako;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Register_Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.register);
        final Button Register_But =  findViewById(R.id.register_but);
        final EditText Register_EditText = findViewById(R.id.regsiter_user_name);
        Register_But.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.register_pre).setVisibility(View.VISIBLE);
                FileHelper File_Register = new FileHelper(getApplicationContext());
                try {


                    File_Register.save("user", "dwadwadawd");
                }catch (Exception e){}
            }
        });
    }
}
