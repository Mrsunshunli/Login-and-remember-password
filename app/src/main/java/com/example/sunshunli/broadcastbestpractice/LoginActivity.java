package com.example.sunshunli.broadcastbestpractice;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity{
    private EditText accoutEdit;
    private EditText passwordEdit;
    private Button login;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private CheckBox remeberPass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        accoutEdit=findViewById(R.id.account);
        passwordEdit=findViewById(R.id.password);
        login=findViewById(R.id.login);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        remeberPass = (CheckBox) findViewById(R.id.remeber_pass);
        boolean isRemeber = pref.getBoolean("Remember_password",false);
        if (isRemeber){
            String account = pref.getString("account","");
            String password = pref.getString("password","");
            accoutEdit.setText(account);
            passwordEdit.setText(password);
            remeberPass.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accoutEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if (account.equals("admin")&&password.equals("123456")){

                        editor=pref.edit();
                        if (remeberPass.isChecked()){
                            editor.putBoolean("Remember_password",true);
                            editor.putString("account",account);
                            editor.putString("password",password);
                        }else{
                            editor.clear();
                        }
                editor.apply();

                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "account or password is error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
