package test.openerp.activities.calendar;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TimePicker;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import test.openerp.R;

import static java.lang.Thread.sleep;

public class AddMeetings extends AppCompatActivity {

    @BindView(R.id.activity_add_meetings)
    LinearLayout activity_add_meeting;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.et_date)
    EditText date;

    @BindView(R.id.et_starttime)
    EditText etstarttime;

    @BindView(R.id.et_endtime)
    EditText etendtime;

    TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meetings);

        ButterKnife.bind(this);

        // Initializing Toolbar and setting it as the actionbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add your meetings");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @OnClick(R.id.ib_editdate)
    void onclickPickDate(){
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            date.setText(dayOfMonth + "/" + monthOfYear + "/" + year);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
    }

    @OnClick(R.id.ib_endtime)
    void onclickEndTime() {
            final Calendar c1 = Calendar.getInstance();
            int mHour = c1.get(Calendar.HOUR_OF_DAY);
            int mMinute = c1.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                            etendtime.setText("" + hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
    }

    @OnClick(R.id.ib_starttime)
    void onclickStartTime(){

        final Calendar c1 = Calendar.getInstance();
        int mHour = c1.get(Calendar.HOUR_OF_DAY);
        int mMinute = c1.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        etstarttime.setText(""+hourOfDay+":"+minute);
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}
