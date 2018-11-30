package win.prashant.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText edit1,edit2,edit3,edit4,edit5;
    Button btn1;


    //creted refrence of database we created
    SqliteHelperClassDemo sqliteHelperClassDemo;

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent in = new Intent(Register.this,MainActivity.class);

                    startActivity(in);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        sqliteHelperClassDemo = new SqliteHelperClassDemo(Register.this);

        edit1= findViewById(R.id.editTextName);
        edit3= findViewById(R.id.editTextEmail);
        edit2= findViewById(R.id.editTextPassoword);
        edit4= findViewById(R.id.editTextAddress);
        edit5= findViewById(R.id.editTextMobile);
        btn1= findViewById(R.id.buttonRegister);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edit1.getText().toString();
                String email = edit3.getText().toString();
                String password = edit2.getText().toString();
                String mobile = edit5.getText().toString();
                String address = edit4.getText().toString();

                sqliteHelperClassDemo.insertdata(name,email,password,mobile,address);


            }
        });

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

}
