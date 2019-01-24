package godock.edenhighway.sujae.com.godock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Food_Ingredients_Activity extends AppCompatActivity  implements View.OnClickListener{
    private Button viewlistButton;
    private Button addButton;
    private Button makeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_ingredients_activity);

        viewlistButton = findViewById(R.id.viewlistButton);
        addButton = findViewById(R.id.addButton);
        makeButton = findViewById(R.id.makeButton);

        viewlistButton.setOnClickListener(this);
        addButton.setOnClickListener(this);
        makeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.viewlistButton:
                // 목록으로 보기 구현
                break;
            case R.id.addButton:
                // 재료 추가 팝업 구현
                startActivity(new Intent(getApplicationContext(),AddDialogActivity.class));
                break;
            case R.id.makeButton:
                Intent intent = new Intent(getApplicationContext(), MakeActivity.class);
                startActivity(intent);
                break;
        }
    }


}
