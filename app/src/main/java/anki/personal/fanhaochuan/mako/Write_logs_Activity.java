package anki.personal.fanhaochuan.mako;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.*;

public class Write_logs_Activity extends Activity {
    String[] files;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.game_log_write);
        final TextInputEditText Text_Stream = findViewById(R.id.Logs);
        FloatingActionButton Save = findViewById(R.id.write_logs);
        final TextInputEditText File_Name = findViewById(R.id.File_Name);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String File_Name_String = File_Name.getText().toString();
                String Texts = Text_Stream.getText().toString();
                Creat_Logs(File_Name_String,Texts);
                Strings.Logs_Massage =false;
            }
        });
    }
    public  void Creat_Logs(String File_Name,String File_Texts){
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput(File_Name+"\n"+File_Texts, Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            Toast.makeText(Write_logs_Activity.this,"创建成功",Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Toast.makeText(Write_logs_Activity.this,test.list().length,Toast.LENGTH_LONG).show();
    }
    public void restart_main_logs(){

        if (Strings.Logs_Massage!= null){
            if (Strings.Logs_Massage == false){
                Strings.Logs_Massage = true;
            }}
    }
}
