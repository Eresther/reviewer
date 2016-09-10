package com.example.androidstudio.loginactivityanicietej;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText_username;
    EditText editText_password;
    Button button_submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_username = (EditText) findViewById(R.id.editText_username);
        editText_password = (EditText) findViewById(R.id.editText_password);
        button_submit = (Button) findViewById(R.id.button_submit);

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateUser(editText_username.getText().toString())){
                    editText_username.setError("Invalid Username");
                    editText_username.requestFocus();
                }else if (!validatePass(editText_password.getText().toString())){
                    editText_password.setError("Invalid Password");
                    editText_password.requestFocus();
                }else{
                    Toast.makeText(MainActivity.this, "Account Validated", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this,Main_Menu.class);
                    startActivity(intent);
                }
            }

            private boolean validateUser(String user){
                if (user == "admin"){
                    return false;
                }else{
                    return true;
                }
            }

            private boolean validatePass(String pass){
                if (pass == "test"){
                    return false;
                }else{
                    return true;
                }
            }
        });

    }
}
