package godock.edenhighway.sujae.com.godock;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class BuyActivity extends AppCompatActivity {
    ImageSliderAdapter adapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buyactivity);

        viewPager = findViewById(R.id.view);
        adapter = new ImageSliderAdapter(this);
        viewPager.setAdapter(adapter);

        Button confirmButton = findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // "먹겠습니다" 버튼 누를 시 먹은 데이터 베이스에 추가.
            }
        });
    }
}
