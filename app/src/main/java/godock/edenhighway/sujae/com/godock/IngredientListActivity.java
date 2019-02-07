package godock.edenhighway.sujae.com.godock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class IngredientListActivity extends AppCompatActivity {
    CheckBox checkBox;
    Button addButton;
    Button removeButton;
    Button backButton;

    EditText searchText;
    Button searchButton;
    ScrollView resultScrollView;


    private LinkedHashMap<String, String> ingredients;
    private LinkedHashMap<String, String> saveList;

    // 서버, DB 구현 후 디테일 잡을 것
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_list);

        addButton = findViewById(R.id.addButton);
        removeButton = findViewById(R.id.removeButton);
        backButton = findViewById(R.id.backButton);

        searchText = findViewById(R.id.searchText);
        resultScrollView = findViewById(R.id.resultScrollView);
        searchButton = findViewById(R.id.searchButton);

        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // 재료 추가 구현
            }
        });

        removeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
               // 재료 제거 구현
            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        //이 메소드 보단 버튼 클릭 메소드가 더 낫지않을까?
//        searchText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                searchIngredients(s.toString());
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });




        ingredients = new LinkedHashMap<String, String>();
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

        //checkboxLayout.addView(checkBox);
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

    public void searchIngredients(String search){
        ingredients.clear();
        for(int i =0; i< saveList.size();i++){
            if(saveList.get(i).contains(search)){
                ingredients.put(Integer.toString(i),saveList.get(i));
            }
        }
        //userListAdaptor.notifyDataSetChanged();
    }
}
