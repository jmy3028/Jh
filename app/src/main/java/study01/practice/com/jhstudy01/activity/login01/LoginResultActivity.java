package study01.practice.com.jhstudy01.activity.login01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import study01.practice.com.jhstudy01.R;

public class LoginResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_result);

        TextView mIdText = findViewById(R.id.id_text);
        TextView mPasswordText = findViewById(R.id.password_text);

        //데이터를 전달해준 Activity로 부터 데이터를 가지고 오는 방법은 getIntent()메서드를 사용해주면 된다.
        Intent intent = getIntent();
        //가져온 데이터를 타입에 맞게 변수에 저장을 해준뒤 사용을 해주면 된다
        //뒤에 들어가 있는 name은 데이터 전달해준 Activity에서 사용한 name을 똑같이 작성을 해주면 된다.
        String mIdResult = intent.getStringExtra("id");
        String mPassResult = intent.getStringExtra("password");


        mIdText.setText(mIdResult);
        mPasswordText.setText(mPassResult);
    }
}
