package com.bmcong2k.luyentapsql2.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.bmcong2k.luyentapsql2.Book1;

import java.util.ArrayList;
import java.util.List;

public class SQliteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "sach1.db";
    private static int DATABASE_VERSION = 1;

    public SQliteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create database only 1
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE book1(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tenSach TEXT, " +
                "tacGia TEXT," +
                "tomTat TEXT," +
                "nxb TEXT," +
                "danhGia INTEGER)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }


    // getAll
    public List<Book1> getAll() {
        List<Book1> list = new ArrayList<>();
        SQLiteDatabase st = getReadableDatabase();
        Cursor rs = st.query("book1", null, null, null,
                null, null, null);

        while (rs != null && rs.moveToNext()) {
            int id = rs.getInt(0);
            String tenSach = rs.getString(1);
            String tacGia = rs.getString(2);
            String tomTat = rs.getString(3);
            String nxb = rs.getString(4);
            int danhGia = rs.getInt(5);
            list.add(new Book1(id, tenSach, tacGia, tomTat, nxb,danhGia));
        }
        return list;
    }

    public long addItem(Book1 i) {
        ContentValues values = new ContentValues();
        values.put("tenSach", i.getTenSach());
        values.put("tacGia", i.getTacGia());
        values.put("tomTat", i.getTomTat());
        values.put("nxb", i.getNxb());
        values.put("danhGia", i.getDanhGia());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.insert("book1", null, values);
    }
//
//    //get item by date
//    public List<Item> getByDate(String date) {
//        List<Item> list = new ArrayList<>();
//        String whereClause = "date like ?";
//        String[] whereAgrg = {date};
//        SQLiteDatabase st = getReadableDatabase();
//        Cursor rs = st.query("items", null,
//                whereClause, whereAgrg, null, null, null);
//
//        while (rs != null && rs.moveToNext()) {
//            int id = rs.getInt(0);
//            String title = rs.getString(1);
//            String category = rs.getString(2);
//            String price = rs.getString(3);
//            list.add(new Item(id, title, category, price, date));
//        }
//        return list;
//    }
//
    // Update
    public int update(Book1 i){
        ContentValues values = new ContentValues();
        values.put("tenSach", i.getTenSach());
        values.put("tacGia", i.getTacGia());
        values.put("tomTat", i.getTomTat());
        values.put("nxb", i.getNxb());
        values.put("danhGia", i.getDanhGia());

        String whereClause = "id=?";
        String[] whereAgrg = {Integer.toString(i.getId())};

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.update("book1", values, whereClause, whereAgrg);
    }
//    //Delete
    public int delete(int id){
        String whereClause = "id=?";
        String[] whereAgrg = {Integer.toString(id)};
        SQLiteDatabase db = getWritableDatabase();
        return db.delete("book1", whereClause, whereAgrg);
    }
//   // Search name
//    public List<Item> searchByTitle(String key) {
//        List<Item> list = new ArrayList<>();
//        //select * from items where title like %key%
//        String whereClause = "title like ?";
//        String[] whereAgrg = {"%" + key + "%"};
//        SQLiteDatabase st = getReadableDatabase();
//        Cursor rs = st.query("items", null,
//                whereClause, whereAgrg, null, null, null);
//
//        while (rs != null && rs.moveToNext()) {
//            int id = rs.getInt(0);
//            String title = rs.getString(1);
//            String category = rs.getString(2);
//            String price = rs.getString(3);
//            String date = rs.getString(4);
//            list.add(new Item(id, title, category, price, date));
//        }
//        return list;
//    }
//
//    public List<Book> searchBynhaXB(String nhaXB) {
//        List<Book> list = new ArrayList<>();
//        //SELECT * FROM Khachhang where Thanhpho = "Bắc Ninh" ORDER BY MaBuudien DESC
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor rs = db.rawQuery("SELECT * FROM book WHERE nhaXB = ? ORDER BY gia DESC",
//                new String[]{nhaXB});
//
//        while (rs != null && rs.moveToNext()) {
//            int id = rs.getInt(0);
//            String ten = rs.getString(1);
//            String nxb = rs.getString(2);
//            String nhaXB1 = rs.getString(3);
//            String gia = rs.getString(4);
//            list.add(new Book(id, ten, nxb, nhaXB1, gia));
//        }
//        return list;
//    }
////      // serch from to
//    public List<Book> searchByPriceFromTo(String from, String to) {
//        List<Book> list = new ArrayList<>();
//        //select * from items where title like %key%
//        String whereClause = "gia BETWEEN ? AND ?";
//        String[] whereAgrg = {from.trim(), to.trim()};
//        SQLiteDatabase st = getReadableDatabase();
//        Cursor rs = st.query("book", null,
//                whereClause, whereAgrg, null, null, null);
//
//        while (rs != null && rs.moveToNext()) {
//            int id = rs.getInt(0);
//            String ten = rs.getString(1);
//            String nxb = rs.getString(2);
//            String nhaXB = rs.getString(3);
//            String gia = rs.getString(4);
//            list.add(new Book(id, ten, nxb, nhaXB, gia));
//        }
//        return list;
//    }
}
