package study01.practice.com.jhstudy01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import study01.practice.com.jhstudy01.activity.RockPaperScissorsActivity;
import study01.practice.com.jhstudy01.activity.ScoreboardActivity;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Map<String, Object>> mMainDataList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.main_list_view);

        mMainDataList = new ArrayList<>();
        addList("농구 점수판 앱","Layout 구성,Button 사용법", ScoreboardActivity.class);
        addList("가위바위보 앱","메서드 사용,기본 if문 사용", RockPaperScissorsActivity.class);


        MainAdapter mainAdapter = new MainAdapter(mMainDataList);

        listView.setAdapter(mainAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Map<String,Object> map = (Map<String,Object>) adapterView.getItemAtPosition(i);
                Intent intent = (Intent) map.get("intent");
                startActivity(intent);

            }
        });

    }

    private void addList(String title, String desc, Class className){
        Map<String,Object> map = new HashMap<>();
        map.put("title",title);
        map.put("desc",desc);
        map.put("intent",new Intent(this,className));
        mMainDataList.add(map);
    }

    private class MainAdapter extends BaseAdapter {

        private ArrayList<Map<String,Object>> mMainDataList;

        public MainAdapter(ArrayList<Map<String, Object>> mMainDataList) {
            this.mMainDataList = mMainDataList;
        }

        @Override
        public int getCount() {
            return mMainDataList.size();
        }

        @Override
        public Object getItem(int i) {
            return mMainDataList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view == null){
                view = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_main_list, viewGroup, false);
            }

            TextView text1 = view.findViewById(R.id.title_text);
            TextView text2 = view.findViewById(R.id.desc_text);

            Map<String, Object> item = mMainDataList.get(i);

            text1.setText((String) item.get("title"));
            text2.setText((String) item.get("desc"));

            return view;
        }
    }
}
