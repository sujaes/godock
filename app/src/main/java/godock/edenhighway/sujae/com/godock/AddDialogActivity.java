package godock.edenhighway.sujae.com.godock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class AddDialogActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText nameText;
    private Button backButton;
    private Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_dialog_activity);

        nameText = findViewById(R.id.ingredientText);
        backButton = findViewById(R.id.backButton);
        confirmButton = findViewById(R.id.confirmButton);

        backButton.setOnClickListener(this);
        confirmButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.backButton:
                this.finish();
                break;

            case R.id.confirmButton:
                // 입력받은 재료 이름을 DB에 추가, 처리 구현
                String ingredient = nameText.getText().toString();

                this.finish();
                break;
        }
    }
}
