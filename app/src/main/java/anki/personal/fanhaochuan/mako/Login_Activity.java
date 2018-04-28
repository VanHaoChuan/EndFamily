package anki.personal.fanhaochuan.mako;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class Login_Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.login_main);

        final LinearLayout Login_Linearlayout = (LinearLayout) findViewById(R.id.login_linearlayout);
        Button Login_Button = (Button) findViewById(R.id.login);
        Button Register_Button = (Button) findViewById(R.id.register_but);
        Login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText user_name = (EditText) findViewById(R.id.user_name);
                EditText password = (EditText) findViewById(R.id.password);
                ProgressBar Login_ProgressBar = (ProgressBar) findViewById(R.id.login_prs);
                if (getViewText(user_name) != null && getViewText(password) != null)
                    Login_ProgressBar.setVisibility(View.VISIBLE);
            }
        });
    }

    public Editable getViewText(EditText editText) {
        return editText.getText();
    }
    public void Register_But_Click(View view){
        Intent Register_Intent = new Intent(this,Register_Activity.class);
        startActivity(Register_Intent);
    }
}