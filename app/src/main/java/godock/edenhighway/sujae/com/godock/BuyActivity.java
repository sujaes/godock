package godock.edenhighway.sujae.com.godock;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class BuyActivity extends AppCompatActivity {
    ImageSliderAdapter adapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view);
        adapter = new ImageSliderAdapter(this);
        viewPager.setAdapter(adapter);
    }
}
