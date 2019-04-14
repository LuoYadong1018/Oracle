package com.lyd.oracle.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.lyd.oracle.R;
import com.lyd.oracle.dao.PwdDao;
public class Login  extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        final EditText txtpwd=findViewById(R.id.login_edit_pwd);
        final EditText txtuser=findViewById(R.id.login_edit_account);
        TextView changepwd=findViewById(R.id.login_text_change_pwd);
        Button btlogin=findViewById(R.id.login_btn_login);
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=txtuser.getText().toString();
                String pwd=txtpwd.getText().toString();
                Intent intent=new Intent(Login.this, MainActivity.class);
                PwdDao pwdDAO=new PwdDao(Login.this);
                if(pwdDAO.getCount()==0||pwdDAO.find().getPwd().isEmpty()){
                    if(pwd.isEmpty()){
                        startActivity(intent);
                    }else{
                        Toast.makeText(Login.this, "请不要输入任何密码登录", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    if(pwdDAO.find().getPwd().equals(pwd)){
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(Login.this, "请输入正确的密码", Toast.LENGTH_SHORT).show();
                    }
                }
                txtpwd.setText("");
            }
        });
        changepwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login.this, SetPassword.class);
                startActivity(intent);
            }
        });
    }
}
