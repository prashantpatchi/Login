package win.prashant.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class SqliteHelperClassDemo extends SQLiteOpenHelper {

    //now need to declare databse

    private static  final  String DATABASE_NAME="data";
    private static  final  int DATABASE_vesion=2;

    // this is constructor of this class create database

    public SqliteHelperClassDemo(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_vesion);
    }

    //to crete table this method
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists  Register (name varchar,email varchar,password varchar,mobile varchar,address varchar)");
    }

    // upgrade helper like to add new column like data or age
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    public void insertdata(String name, String email, String passowrd,String mobile, String address)
    {
        // to write database inside database we need get writable datbase method
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("email",email);
        contentValues.put("password",passowrd);
        contentValues.put("mobile",mobile);
        contentValues.put("address",address);
        sqLiteDatabase.insert("Register",null,contentValues);

    }
    public Cursor Loginfunction(String email,String password)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cc = sqLiteDatabase.rawQuery("Select * from Register where email ='"+email+"' and password='",null);
        return cc;
    }

    public void deletedata(String mobile)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        sqLiteDatabase.execSQL("delete from Register where mobile = '"+mobile'");
    }
}
