package com.bmcong2k.luyentapsql2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.bmcong2k.luyentapsql2.dal.SQliteHelper;

import java.util.Calendar;

public class AddActivity extends AppCompatActivity implements View.OnClickListener{


    private Spinner spTacGia, spNhaXB;
    private EditText eTenSach, eTomTat;
    private RatingBar rtDanhGia;
    private Button btnUpdate, btnCancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        initView();
        btnUpdate.setOnClickListener(this);
        btnCancle.setOnClickListener(this);

    }

    private void initView() {

        spNhaXB = findViewById(R.id.spNXB);
        spTacGia = findViewById(R.id.spTacGia);
        eTenSach = findViewById(R.id.eTenSach);
        eTomTat = findViewById(R.id.eTomTat);
        rtDanhGia = findViewById(R.id.rtDanhGia);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnCancle = findViewById(R.id.btnCancle);
        spNhaXB.setAdapter(new ArrayAdapter<String>(this, R.layout.item_spriner,
                getResources().getStringArray(R.array.nxb)));
        spTacGia.setAdapter(new ArrayAdapter<String>(this, R.layout.item_spriner,
                getResources().getStringArray(R.array.tacgia)));

    }

    @Override
    public void onClick(View v) {

        if (v == btnCancle){
            finish();
        }

        if (v == btnUpdate){
            String  tenSach = eTenSach.getText().toString();
            String  tacGia = spTacGia.getSelectedItem().toString();
            String  tomTat = eTomTat.getText().toString();
            String nhaXB = spNhaXB.getSelectedItem().toString();
            double rtBar = rtDanhGia.getRating();

            if(!tenSach.isEmpty() && !tacGia.isEmpty()){
                Book1 i = new Book1(tenSach, tacGia, tomTat, nhaXB,rtBar);
                SQliteHelper db = new SQliteHelper(this);
                db.addItem(i);
                finish();
            }
        }

    }
}