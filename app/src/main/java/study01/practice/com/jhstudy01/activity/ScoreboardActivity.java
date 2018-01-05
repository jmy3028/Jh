package study01.practice.com.jhstudy01.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import study01.practice.com.jhstudy01.R;

public class ScoreboardActivity extends AppCompatActivity {

    private TextView mScore;
    private TextView mbScore;

    private int mTotalScore = 0;
    private int mbTotalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        mScore = findViewById(R.id.num_text);
        mbScore = findViewById(R.id.bnum_text);

    }
    public void OnClick(View view) {
        switch (view.getId()){
            case R.id.three_point:
                mTotalScore = mTotalScore + 3;
                mScore.setText("" + mTotalScore);
                break;
            case R.id.two_point:
                mTotalScore = mTotalScore + 2;
                mScore.setText("" + mTotalScore);
                break;
            case R.id.free_point:
                mTotalScore = mTotalScore + 1;
                mScore.setText("" + mTotalScore);
                break;
            case R.id.bthree_point:
                mbTotalScore = mbTotalScore + 3;
                mbScore.setText("" + mbTotalScore);
                break;
            case R.id.btwo_point:
                mbTotalScore = mbTotalScore + 2;
                mbScore.setText("" + mbTotalScore);
                break;
            case R.id.bfree_point:
                mbTotalScore = mbTotalScore + 1;
                mbScore.setText("" + mbTotalScore);
                break;
            case R.id.reset_view:
                mTotalScore = 0;
                mbTotalScore = 0;
                mScore.setText("" + mTotalScore);
                mbScore.setText("" + mbTotalScore);
                break;
        }
    }
}
