package win.prashant.login;

import android.content.Intent;
import android.database.Cursor;
import android.net.nsd.NsdManager;
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

public class LoginSignup extends AppCompatActivity {

    private TextView mTextMessage;
    EditText editTextLogin,editTextPassword;
    Button btnLogin, btnRegister,delete;
    CheckBox checkBox;
    SqliteHelperClassDemo sqliteHelperClassDemo;
    int count ;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent in = new Intent(LoginSignup.this,MainActivity.class);

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
        setContentView(R.layout.activity_login_signup);

        sqliteHelperClassDemo = new SqliteHelperClassDemo(LoginSignup.this);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        editTextLogin = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassoword);
        btnLogin = findViewById(R.id.button);
        btnRegister = findViewById(R.id.button2);
        delete = findViewById(R.id.buttonDelete);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(LoginSignup.this,Delete.class);
                startActivity(in);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(LoginSignup.this,Register.class);

                startActivity(in);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextLogin.getText().toString();
                String password = editTextPassword.getText().toString();


               Cursor cc =  sqliteHelperClassDemo.Loginfunction(email,password);
               cc.moveToFirst();
               do{
                   count= cc.getCount();

               } while (cc.moveToNext());
                //Toast.makeText(getApplicationContext(),""+count,Toast.LENGTH_SHORT).show();

               if (count ==1)
               {
                   Intent in = new Intent(LoginSignup.this,MainActivity.class);
                   startActivity(in);

               }else

                Toast.makeText(getApplicationContext(),"login failed ",Toast.LENGTH_SHORT).show();
            }
        });
    }


}
