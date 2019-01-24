package godock.edenhighway.sujae.com.godock;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class RecipeActivity extends AppCompatActivity implements View.OnClickListener{
    Button completeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_activity);

        completeButton = findViewById(R.id.completeButton);
        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 재료별 동적인 체크박스 구현 필요

                View checkBoxView = View.inflate(getApplicationContext(), R.layout.category_checkboxes2, null);
                CheckBox checkBox1 = (CheckBox) checkBoxView.findViewById(R.id.checkbox1);
                CheckBox checkBox2 = (CheckBox) checkBoxView.findViewById(R.id.checkbox2);
                CheckBox checkBox3 = (CheckBox) checkBoxView.findViewById(R.id.checkbox3);
                CheckBox checkBox4 = (CheckBox) checkBoxView.findViewById(R.id.checkbox4);
                CheckBox checkBox5 = (CheckBox) checkBoxView.findViewById(R.id.checkbox5);
                CheckBox checkBox6 = (CheckBox) checkBoxView.findViewById(R.id.checkbox6);

                checkBox1.setOnCheckedChangeListener(CheckBoxListener);
                checkBox1.setText("재료 1");
                checkBox2.setOnCheckedChangeListener(CheckBoxListener);
                checkBox2.setText("재료 2");
                checkBox3.setOnCheckedChangeListener(CheckBoxListener);
                checkBox3.setText("재료 3");
                checkBox4.setOnCheckedChangeListener(CheckBoxListener);
                checkBox4.setText("재료 4");
                checkBox5.setOnCheckedChangeListener(CheckBoxListener);
                checkBox5.setText("재료 5");
                checkBox6.setOnCheckedChangeListener(CheckBoxListener);
                checkBox6.setText("재료 6");

                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                builder.setTitle("다 쓴 재료를 선택해주세요!");
                builder.setMessage("다음 요리에 참고됩니다.")
                        .setView(checkBoxView)
                        .setCancelable(false)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);

                            }
                        })
                        .setNegativeButton("아직 안만들었습니다", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        }).show();

            }
        });
    }

    @Override
    public void onClick(View view) {

    }

    CompoundButton.OnCheckedChangeListener CheckBoxListener = new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            // 체크박스 선택시 해당 카테고리를 참조해서 결과 보여주도록 함.
        }
    };
}
