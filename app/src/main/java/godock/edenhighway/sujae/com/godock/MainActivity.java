package godock.edenhighway.sujae.com.godock;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executors;

import godock.edenhighway.sujae.com.godock.calendar.EventDecorator;
import godock.edenhighway.sujae.com.godock.calendar.OneDayDecorator;
import godock.edenhighway.sujae.com.godock.calendar.SaturdayDecorator;
import godock.edenhighway.sujae.com.godock.calendar.SundayDecorator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton buyButton;
    private ImageButton makeButton;


    //달력
    String time,kcal,menu;
    private final OneDayDecorator oneDayDecorator = new OneDayDecorator();
    Cursor cursor;
    MaterialCalendarView materialCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buyButton = (ImageButton)findViewById(R.id.buy);
        buyButton.setOnClickListener(this);

        makeButton = findViewById(R.id.make);
        makeButton.setOnClickListener(this);


        //달력
        materialCalendarView = (MaterialCalendarView)findViewById(R.id.calendarView);

        materialCalendarView.state().edit()
                .setFirstDayOfWeek(Calendar.SUNDAY)
                .setMinimumDate(CalendarDay.from(2017, 0, 1)) // 달력의 시작
                .setMaximumDate(CalendarDay.from(2030, 11, 31)) // 달력의 끝
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();

        materialCalendarView.addDecorators(
                new SundayDecorator(),
                new SaturdayDecorator(),
                oneDayDecorator);

        String[] result = {"2019,01,18","2019,02,18","2019,03,18","2019,04,18"};

        new ApiSimulator(result).executeOnExecutor(Executors.newSingleThreadExecutor());

        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                int Year = date.getYear();
                int Month = date.getMonth() + 1;
                int Day = date.getDay();

                Log.i("Year test", Year + "");
                Log.i("Month test", Month + "");
                Log.i("Day test", Day + "");

                String shot_Day = Year + "," + Month + "," + Day;

                Log.i("shot_Day test", shot_Day + "");
                materialCalendarView.clearSelection();

                Toast.makeText(getApplicationContext(), shot_Day , Toast.LENGTH_SHORT).show();
            }
        });

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


    //달력
    private class ApiSimulator extends AsyncTask<Void, Void, List<CalendarDay>> {

        String[] Time_Result;

        ApiSimulator(String[] Time_Result){
            this.Time_Result = Time_Result;
        }

        @Override
        protected List<CalendarDay> doInBackground(@NonNull Void... voids) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Calendar calendar = Calendar.getInstance();
            ArrayList<CalendarDay> dates = new ArrayList<>();

            /*특정날짜 달력에 점표시해주는곳*/
            /*월은 0이 1월 년,일은 그대로*/
            //string 문자열인 Time_Result 을 받아와서 ,를 기준으로짜르고 string을 int 로 변환
            for(int i = 0 ; i < Time_Result.length ; i ++){
                CalendarDay day = CalendarDay.from(calendar);
                String[] time = Time_Result[i].split(",");
                int year = Integer.parseInt(time[0]);
                int month = Integer.parseInt(time[1]);
                int dayy = Integer.parseInt(time[2]);

                dates.add(day);
                calendar.set(year,month-1,dayy);
            }



            return dates;
        }

        @Override
        protected void onPostExecute(@NonNull List<CalendarDay> calendarDays) {
            super.onPostExecute(calendarDays);

            if (isFinishing()) {
                return;
            }

            materialCalendarView.addDecorator(new EventDecorator(Color.GREEN, calendarDays,MainActivity.this));
        }
    }

    @Override public void onBackPressed() {
        moveTaskToBack(true);
        finish();
        android.os.Process.killProcess(android.os.Process.myPid());

    }

}
