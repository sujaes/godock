package godock.edenhighway.sujae.com.godock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class PreferenceActivity extends AppCompatActivity {
    private int count = 0;     // index
    private static final int[] Button_IDs ={ // 12개 버튼의 ID
            R.id.Button1,
            R.id.Button2,
            R.id.Button3,
            R.id.Button4,
            R.id.Button5,
            R.id.Button6,
            R.id.Button7,
            R.id.Button8,
            R.id.Button9,
            R.id.Button10,
            R.id.Button11,
            R.id.Button12
    };

    private List <String>preferenceList = new ArrayList<String>(); // 선호도 리스트
    private List <String>selectedList = new ArrayList<String>(); // 선택된 선호도 리스트

    @Override public void onBackPressed() {
        //super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);


        //서버로 부터 선호도 리스트 받아오기
        preferenceList.add("불고기");
        preferenceList.add("돈까스");
        preferenceList.add("치킨");
        preferenceList.add("짜장면");
        preferenceList.add("김치 볶음밥");
        preferenceList.add("라면");
        preferenceList.add("족발");
        preferenceList.add("탕수육");
        preferenceList.add("잡채");
        preferenceList.add("떡국");
        preferenceList.add("피자");
        preferenceList.add("보쌈");
        preferenceList.add("계란말이");
        preferenceList.add("순대국");
        preferenceList.add("팔보채");
        preferenceList.add("김치전");
        preferenceList.add("해물파전");
        preferenceList.add("닭볶음탕");
        preferenceList.add("소세지볶음");
        preferenceList.add("어묵국");
        preferenceList.add("부대찌개");
        preferenceList.add("국수");

        for(int id:Button_IDs){
            Button button = findViewById(id);
            String nextText = preferenceList.get(count++);
            button.setText(nextText);
            button.setOnClickListener(PreferenceButtonListener);
            //buttons.add(button);
        }


    }
    View.OnClickListener PreferenceButtonListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Button button = (Button)view;
            selectedList.add(button.getText().toString());
            button.setText(preferenceList.get(count++));
            // 10개 선택시 MainActivity로 넘어감
            if(selectedList.size() >= 10) {
                //선택된 음식 출력
                for(String sel: selectedList){
                    System.out.println(sel);
                }
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        }
    };


}



