package sg.edu.rp.c346.id22015711.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    EditText editNumber;
    EditText editSize;
    TextView reservationDisplay;
    DatePicker dp;
    TimePicker tp;
    CheckBox cbEnabled;
    CheckBox cbDisabled;
    Button btnReserve;
    Button btnReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editTextName);
        editNumber = findViewById(R.id.editTextNumber);
        editSize = findViewById(R.id.editTextSize);
        reservationDisplay = findViewById(R.id.textView);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        cbEnabled = findViewById(R.id.checkBoxNonSmoking);
        cbDisabled = findViewById(R.id.checkBoxSmoking);
        btnReserve = findViewById(R.id.buttonReserve);
        btnReset = findViewById(R.id.buttonReset);

        dp.updateDate(2020,5,1);
        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);

        btnReserve.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String number = editNumber.getText().toString();
                String size = editSize.getText().toString();

                int day = dp.getDayOfMonth();
                int month = dp.getMonth() + 1;
                int year = dp.getYear();

                int hour = tp.getCurrentHour();
                int minute = tp.getCurrentMinute();

                String message ="Reservation confirmed: \n" +
                        "Name: " + name + "\n" +
                                "Phone: " +  number + "\n" +
                        "Group Size: " + size + "\n" +
                        "Date: " + day + "/" + month + "/" + year + "\n" +
                        "Time: " + hour + ":" + minute + "\n";

                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editName.setText("");
                editNumber.setText("");
                editSize.setText("");

                dp.updateDate(2020, 5, 1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);

                cbDisabled.setChecked(false);
                cbEnabled.setChecked(true);
            }
        });



    }
}