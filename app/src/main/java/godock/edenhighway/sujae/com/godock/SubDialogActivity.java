package godock.edenhighway.sujae.com.godock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class SubDialogActivity extends AppCompatActivity{
    LinearLayout checkboxLayout;
    CheckBox checkBox;
    Button backButton,  confirmButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subdialog);
        checkboxLayout = findViewById(R.id.checkboxLayout);
        backButton = findViewById(R.id.backButton);
        confirmButton = findViewById(R.id.confirmButton);

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 다쓴 재료를 냉장고 DB에서 제거 구현
                //
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
        LinkedHashMap<String, String> ingredients = new LinkedHashMap<String, String>();
        ingredients.put("1", "재료 1");
        ingredients.put("2", "재료 2");
        ingredients.put("3", "재료 3");
        ingredients.put("4", "재료 4");
        ingredients.put("5", "재료 5");
        ingredients.put("6", "재료 6");

        Set<?> set = ingredients.entrySet();
        Iterator<?> iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry me = (Map.Entry) iterator.next();
            checkBox = new CheckBox(this);
            checkBox.setId(Integer.parseInt(me.getKey().toString()));
            checkBox.setText(me.getValue().toString());
            checkBox.setOnClickListener(SelectSubtractIngredient(checkBox));

            checkboxLayout.addView(checkBox);
        }

    }

    View.OnClickListener SelectSubtractIngredient(final Button button) {
        return new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println(button.getId());
                System.out.println(button.getText().toString());
            }
        };
    }
}
