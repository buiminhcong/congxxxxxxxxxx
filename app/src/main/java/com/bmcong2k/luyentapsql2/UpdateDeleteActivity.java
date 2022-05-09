package com.bmcong2k.luyentapsql2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

import com.bmcong2k.luyentapsql2.dal.SQliteHelper;

import java.util.Calendar;

public class UpdateDeleteActivity extends AppCompatActivity implements View.OnClickListener{


    private Spinner spTacGia, spNXB;
    private EditText eTenSach, eTomtat;
    private RatingBar rtbar;
    private Button btnUpdate, btnBack, btnRemove;
    private Book1 book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);

        initView();

        btnUpdate.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnRemove.setOnClickListener(this);


        Intent intent = getIntent();
        book= (Book1) intent.getSerializableExtra("book");
        eTenSach.setText(book.getTenSach());
        eTomtat.setText(book.getTomTat());
        int p = 0;
        for(int i=0; i<spTacGia.getCount(); i++){
            if(spTacGia.getItemAtPosition(i).toString().equalsIgnoreCase(book.getTacGia())){
                p=i;
                break;
            }
        }
        spNXB.setSelection(p);

        int g = 0;
        for(int i=0; i<spNXB.getCount(); i++){
            if(spNXB.getItemAtPosition(i).toString().equalsIgnoreCase(book.getTacGia())){
                g=i;
                break;
            }
        }
        spTacGia.setSelection(g);
        rtbar.setRating((float) book.getDanhGia());

    }

    private void initView() {

        spNXB = findViewById(R.id.spNXB);
        spTacGia = findViewById(R.id.spTacGia);
        eTenSach = findViewById(R.id.eTenSach);
        eTomtat = findViewById(R.id.eTomTat);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnBack = findViewById(R.id.btnBack);
        btnRemove = findViewById(R.id.btnDelete);
        rtbar = findViewById(R.id.rtBar);
        spNXB.setAdapter(new ArrayAdapter<String>(this, R.layout.item_spriner,
                getResources().getStringArray(R.array.nxb)));
        spTacGia.setAdapter(new ArrayAdapter<String>(this, R.layout.item_spriner,
                getResources().getStringArray(R.array.tacgia)));

    }

    @Override
    public void onClick(View v) {
        SQliteHelper db = new SQliteHelper(this);

        if(v == btnBack){
            finish();
        }

        if(v == btnUpdate){
            String  tenSach = eTenSach.getText().toString();
            String  tacGia = spTacGia.getSelectedItem().toString();
            String  tomTat = eTomtat.getText().toString();
            String  nxb = spNXB.getSelectedItem().toString();
            double danhGia = rtbar.getRating();

            if(!tenSach.isEmpty() && !tacGia.isEmpty()){
                int id = book.getId();
                Book1 i = new Book1(id,tenSach, tacGia, tomTat, nxb,danhGia);
                db.update(i);
                finish();
            }
        }

        if(v == btnRemove){
            int id = book.getId();
            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            builder.setTitle("Thong Bao Xoa");
            builder.setMessage("Ban Co Chac Muon Xoa " + book.getTenSach() + " khong?");
            builder.setIcon(R.drawable.remove);
            builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    db.delete(id);
                    finish();
                }
            });
            builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
}