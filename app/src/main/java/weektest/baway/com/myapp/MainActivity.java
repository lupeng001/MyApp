package weektest.baway.com.myapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import weektest.baway.com.bean.LoginBean;
import weektest.baway.com.p.Presenter_lei;

public class MainActivity extends AppCompatActivity {
private EditText login_user;
private EditText login_pwd;
private CheckBox login_check;
private TextView login_zhuce;
private Button login_denglu;
    private String user;
    private String pwd;
    private Presenter_lei presenter_lei;
    private ImageView login_eye;
    private boolean isHideFirst = true;// 输入框密码是否是隐藏的，默认为true
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    login_user = findViewById(R.id.login_user);
    login_pwd = findViewById(R.id.login_pwd);
    login_check = findViewById(R.id.login_check);
    login_zhuce = findViewById(R.id.login_text);
    login_denglu = findViewById(R.id.login_button);
    presenter_lei = new Presenter_lei(this);
    login_eye = findViewById(R.id.login_eye);
    login_eye.setImageResource(R.mipmap.login_icon_eye);
        sp = getSharedPreferences("Main", MODE_PRIVATE);
        boolean b = sp.getBoolean("one", false);
        if (b){
            String user1 = sp.getString("user", "");
            String pwd1 = sp.getString("pwd", "");
            login_user.setText(user1);
            login_pwd.setText(pwd1);
                login_check.setChecked(true);
        }
        login_denglu.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            user = login_user.getText().toString();
            pwd = login_pwd.getText().toString();
            if (user.equals("")|| pwd.equals("")){

                Toast.makeText(MainActivity.this,"账号或密码不能为空",Toast.LENGTH_LONG).show();
            }
            else {
                SharedPreferences.Editor edit = sp.edit();
                if (login_check.isChecked()){
                    edit.putBoolean("one",true);
                    edit.putString("user",user);
                    edit.putString("pwd",pwd);

                }
                else {
                    edit.clear();

                }                edit.commit();
                presenter_lei.getLogin(user,pwd);
            }
        }
    });
    login_eye.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isHideFirst==true){
                login_eye.setImageResource(R.mipmap.login_icon_eye);
                HideReturnsTransformationMethod method = HideReturnsTransformationMethod.getInstance();
                login_pwd.setTransformationMethod(method);
                isHideFirst = false;

            }else {
                login_eye.setImageResource(R.mipmap.login_icon_phone);
                TransformationMethod method = PasswordTransformationMethod.getInstance();
                login_pwd.setTransformationMethod(method);
                isHideFirst = true;
            }
            int index = login_pwd.getText().toString().length();
            login_pwd.setSelection(index);

        }
    });

    }

    public void getLogin(final String url) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson =new Gson();
                LoginBean loginBean = gson.fromJson(url, LoginBean.class);
                String status = loginBean.getStatus();
                if (status.equals("0000")){
                    Intent intent =new Intent(MainActivity.this,ShowActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(MainActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
