package godock.edenhighway.sujae.com.godock;

<<<<<<< HEAD
public class Food_Ingredients_Activity {
=======
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Food_Ingredients_Activity extends AppCompatActivity  {
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


        View.OnClickListener buttonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.viewlistButton:
                        // 목록으로 보기 구현
                        break;
                    case R.id.addButton:
                        // 재료 추가 팝업 구현
                        View textView = View.inflate(getApplicationContext(), R.layout.addpopup, null);
                        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                        builder.setTitle("재료 추가");
                        builder.setMessage("추가할 재료의 이름을 입력해주세요.")
                                .setView(textView)
                                .setCancelable(false)
                                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
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
                    case R.id.makeButton:
                        Intent intent = new Intent(getApplicationContext(), MakeActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        };
        viewlistButton.setOnClickListener(buttonListener);
        addButton.setOnClickListener(buttonListener);
        makeButton.setOnClickListener(buttonListener);


    }

>>>>>>> f45acab95b486216adab9cd96a802e6ec2b14169
}
