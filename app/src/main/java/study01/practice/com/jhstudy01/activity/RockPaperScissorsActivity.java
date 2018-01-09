package study01.practice.com.jhstudy01.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import study01.practice.com.jhstudy01.R;

public class RockPaperScissorsActivity extends AppCompatActivity {

    private int aTeam;
    private int bTeam;
    private TextView mATeamText;
    private TextView mBTeamText;
    private TextView mTotalText;
    private TextView mAScoreText;
    private TextView mBScoreText;
    private int mAMax = 0;
    private int mBMax = 0;
    private int a = 0;
    private int mADoubleclick = 1;
    private int mBDoubleclick = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);

        Button mATeamButton = findViewById(R.id.random_a_button);
        final Button mBTeamButton = findViewById(R.id.random_b_button);
        Button mResetButton = findViewById(R.id.reset_button);

        mAScoreText = findViewById(R.id.ateam_score);
        mBScoreText = findViewById(R.id.bteam_score);

        mATeamText = findViewById(R.id.ateam_text);
        mBTeamText = findViewById(R.id.bteam_text);
        mTotalText = findViewById(R.id.total_text);

        // A팀 랜덤 묵찌빠 클릭시 발생되는 이벤트
        mATeamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //A팀 묵찌빠 값을 random 함수를 통해 0~2까지 3개의 숫자를 랜덤으로
                //가져와서 (0 = 묵 , 1 = 찌 , 2 = 빠) 변환 시켜주는 작업을 해준다.
                Random random = new Random();
                aTeam = random.nextInt(3);
                if (aTeam == 0) {
                    mATeamText.setText("묵");
                } else if (aTeam == 1) {
                    mATeamText.setText("찌");
                } else {
                    mATeamText.setText("빠");
                }

                //A팀이 두번 클릭을 했는지 확인해 주는 작업을 if문을 사용해서 해주고 있다.
                if (mADoubleclick < 2) {
                    //한번 클릭시 compareOne() 메서드를 이용해서 누가 이겼는지 확인 후 화면에 보여준다.
                    compareOne(1);
                    //2번 클릭을 방지 하기 위해 값을 증가시키는 역할을 해준다.
                    mADoubleclick = mADoubleclick + 1;
                } else {
                    //만약 mADoubleclick이 2일 경우에 아래에 코드를 실행시켜 화면에 띄워준다.
                    Toast.makeText(RockPaperScissorsActivity.this, "두번누르셨습니다.", Toast.LENGTH_SHORT).show();

                }
            }
        });

        // B팀 랜덤 묵찌빠 클릭시 발생되는 이벤트
        mBTeamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //B팀 묵찌빠 값을 random 함수를 통해 0~2까지 3개의 숫자를 랜덤으로
                //가져와서 (0 = 묵 , 1 = 찌 , 2 = 빠) 변환 시켜주는 작업을 해준다.
                Random random = new Random();
                bTeam = random.nextInt(3);
                if (bTeam == 0) {
                    mBTeamText.setText("묵");
                } else if (bTeam == 1) {
                    mBTeamText.setText("찌");
                } else {
                    mBTeamText.setText("빠");
                }

                //B팀이 두번 클릭을 했는지 확인해 주는 작업을 if문을 사용해서 해주고 있다.
                if (mBDoubleclick < 2) {
                    //한번 클릭시 compareOne() 메서드를 이용해서 누가 이겼는지 확인 후 화면에 보여준다.
                    compareOne(1);
                    //2번 클릭을 방지 하기 위해 값을 증가시키는 역할을 해준다.
                    mBDoubleclick = mBDoubleclick + 1;
                } else {
                    //만약 mADoubleclick이 2일 경우에 아래에 코드를 실행시켜 화면에 띄워준다.
                    Toast.makeText(RockPaperScissorsActivity.this, "두번누르셨습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 처음부터 다시하기 클릭시 발생되는 이벤트
        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //모든 값을 초기화 해주는 작업(화면에 보여주는 것 포함)
                mATeamText.setText("");
                mBTeamText.setText("");
                mAScoreText.setText("0");
                mBScoreText.setText("0");
                mTotalText.setText("");
                mAMax = 0;
                mBMax = 0;
            }
        });
    }

    /*
        compareOne()메서드에서는 A팀과 B팀이 한번씩 클릭을 했을 때 코드가 실행이 되며,
        A팀 혹은 B팀이 클릭 했을 때에는 실행이 안된다.

        compareOne()메서드에서 하는 일은 if문을 통해 A,B팀이 각각 한번씩 눌러졌을 때,
        a에 2라는 숫자가 저장이 되며 조건을 충족 시킨 후 compare()메서드를 실행 시켜주고,
        A,B팀에 총점이 3점이 되었는지 까지 비교를 해서 화면에 보여주는 역할을 해준다.

        * if문에 조건들이 충족이 안됬을 경우에는 아무 작업을 안하고 중단이 된다.
     */
    public void compareOne(int mClickPoint) {
        // a = A,B팀이 한번클릭 할때마다 값 1을 전달을 해주고 저장해주는 역할을 해준다.
        // 즉 각각 한번씩 눌렸는지 안눌렸는지 판단 해주는 변수
        a = a + mClickPoint;
        // a의 숫자가 2가 되였을 경우(A,B팀이 각각 한번씩 눌렀을 경우)에 조건에 충족이 되어
        // compare()메서드와 총점 비교를 수행 해준다.
        if (a == 2) {
            //한 경기가 끝난 후 다음 경기를 하기 위해 a의 값을 초기화 해준다.
            a = 0;

            // aTeam 과 bTeam을 비교해주고 화면에 출력을 해준다.
            compare(aTeam, bTeam);
            //A,B팀이 더블클릭을 안하고 정상적으로 compare()메서드가 실행이 됬으면
            //다음 경기를 위해 더블클릭에 값을 초기화 해준다.
            mADoubleclick = 0;
            mBDoubleclick = 0;

            //A 혹은 B팀에 최종 결과 값이 3점을 획득 했을 시 참안에 있는 코드를 실행시키고
            //결과를 출력해준다. 단 충족이 안됐을 경우 아무것도 실행 시키지 않는다.
            if (mAMax >= 3 || mBMax >= 3) {
                if (mAMax == 3) {
                    mTotalText.setText("A팀 승리!");
                } else {
                    mTotalText.setText("B팀 승리!");
                }
                //최종 결과가 나오고 난 후에는 결과값을 초기화 해준다.
                mAMax = 0;
                mBMax = 0;
            }
        }

    }

    /*
        comare()메서드 에서는 각팀에 묵,찌,빠를 확인후 이긴팀을 가려내는 역할을 해준다.
        여기에서는 A팀 혹은 B팀이 빠였을 때 상대편이 묵을 냈는지 내지 않았는지 비교를 해서
        처리를 해주고 A,B팀이 같은 수를 내었는지 판단을 해서 화면에 보여준다.
     */
    public void compare(int ateam, int bteam) {
        //A,B팀이 같은 수를 내었는가 비교를 해준다.
        if (ateam == bteam) {
            Toast.makeText(this, "비겼습니다. 버튼을 다시 눌러주세요!", Toast.LENGTH_SHORT).show();
        } else {
            //A,B팀이 다른 수를 내었으면, 각팀에 빠와 묵을 가졌는지 확인을 하여 화면에 출력해준다.
            if (ateam == 2) {
                if (bteam == 0) {
                    mAMax = mAMax + 1;
                    mAScoreText.setText(mAMax + "");
                } else {
                    mBMax = mBMax + 1;
                    mBScoreText.setText(mBMax + "");
                }
            } else if (bteam == 2) {
                if (ateam == 0) {
                    mBMax = mBMax + 1;
                    mBScoreText.setText(mBMax + "");
                } else {
                    mAMax = mAMax + 1;
                    mAScoreText.setText(mAMax + "");
                }
            } else {
                //위에 조건에 충족이 되지 않고, 다른 수가 생겼을 경우에 아래에 코드에서 실행후
                //결과값을 출력해준다.
                if (ateam > bteam) {
                    mBMax = mBMax + 1;
                    mBScoreText.setText(mBMax + "");
                } else {
                    mAMax = mAMax + 1;
                    mAScoreText.setText(mAMax + "");
                }
            }

        }
    }
}
