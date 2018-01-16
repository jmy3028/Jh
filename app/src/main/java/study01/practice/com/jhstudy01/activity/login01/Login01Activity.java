package study01.practice.com.jhstudy01.activity.login01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import study01.practice.com.jhstudy01.R;

public class Login01Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login01);

        final EditText mIdEdit = findViewById(R.id.id_edit_text);
        final EditText mPasswordEdit = findViewById(R.id.password_edit_text);
        Button mLoginButton = findViewById(R.id.login_button);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent는 다음 Activity와 다음 데이터를 전송하기 위해 필요하다
                Intent intent = new Intent(Login01Activity.this, LoginResultActivity.class);
                //putExtra()는 타입에 따라 다음 Activity로 전송할 수 있다.
                intent.putExtra("id", mIdEdit.getText().toString());
                intent.putExtra("password", mPasswordEdit.getText().toString());
                //다음 Activity를 실행시켜주는 메서드
                startActivity(intent);
                //Activity를 종료 시켜주는 메서드
                finish();
            }
        });
    }
}
