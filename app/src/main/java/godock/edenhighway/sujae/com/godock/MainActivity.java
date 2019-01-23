package godock.edenhighway.sujae.com.godock;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton buyButton;
    private ImageButton makeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buyButton = (ImageButton)findViewById(R.id.buy);
        buyButton.setOnClickListener(this);

        makeButton = findViewById(R.id.make);
        makeButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buy:
                View checkBoxView = View.inflate(this, R.layout.category_checkboxes, null);
                CheckBox checkBox1 = (CheckBox) checkBoxView.findViewById(R.id.checkbox1);
                CheckBox checkBox2 = (CheckBox) checkBoxView.findViewById(R.id.checkbox2);
                CheckBox checkBox3 = (CheckBox) checkBoxView.findViewById(R.id.checkbox3);
                CheckBox checkBox4 = (CheckBox) checkBoxView.findViewById(R.id.checkbox4);
                CheckBox checkBox5 = (CheckBox) checkBoxView.findViewById(R.id.checkbox5);
                CheckBox checkBox6 = (CheckBox) checkBoxView.findViewById(R.id.checkbox6);

                checkBox1.setOnCheckedChangeListener(CheckBoxListener);
                checkBox1.setText("한식");
                checkBox2.setOnCheckedChangeListener(CheckBoxListener);
                checkBox2.setText("중식");
                checkBox3.setOnCheckedChangeListener(CheckBoxListener);
                checkBox3.setText("일식");
                checkBox4.setOnCheckedChangeListener(CheckBoxListener);
                checkBox4.setText("양식");
                checkBox5.setOnCheckedChangeListener(CheckBoxListener);
                checkBox5.setText("안주류");
                checkBox6.setOnCheckedChangeListener(CheckBoxListener);
                checkBox6.setText("다이어트");

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("카테고리 설정");
                builder.setMessage("카테고리를 설정해주세요!")
                        .setView(checkBoxView)
                        .setCancelable(false)
                        .setPositiveButton("결과보기", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(getApplicationContext(), BuyActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("돌아가기", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        }).show();
                break;

            case R.id.make:
                Intent intent = new Intent(getApplicationContext(), Food_Ingredients_Activity.class);
                startActivity(intent);
                break;
        }
    }

    CompoundButton.OnCheckedChangeListener CheckBoxListener = new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            // 체크박스 선택시 해당 카테고리를 참조해서 결과 보여주도록 함.
        }
    };
}
