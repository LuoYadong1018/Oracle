package com.lyd.oracle.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lyd.oracle.R;
import com.lyd.oracle.dao.PwdDao;
import com.lyd.oracle.model.Tb_info;

public class SetPassword extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setpassword);
        Button submit=findViewById(R.id.login_btn_login);
        final TextView tvUser=findViewById(R.id.login_edit_account);
        final TextView tvPwd=findViewById(R.id.login_edit_pwd);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PwdDao pwdDao=new PwdDao(SetPassword.this);
                String user=tvUser.getText().toString();
                String pwd=tvPwd.getText().toString();
                Tb_info info=new Tb_info(user,pwd);
                if (pwdDao.getCount()==0){
                    pwdDao.add(info);
                    Toast.makeText(SetPassword.this,"添加密码成功！",Toast.LENGTH_SHORT).show();
                }else {
                    pwdDao.update(info);
                    Toast.makeText(SetPassword.this,"更改密码成功！",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
