package win.prashant.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends AppCompatActivity {
    EditText editTextdel;
    Button btnDel;

    SqliteHelperClassDemo sqliteHelperClassDemo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        sqliteHelperClassDemo = new SqliteHelperClassDemo(Delete.this);

        editTextdel = findViewById(R.id.editTextMobile);
        btnDel = findViewById(R.id.buttonDelete);

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobile = editTextdel.getText().toString();
                sqliteHelperClassDemo.deletedata(mobile);
                Toast.makeText(getApplicationContext(),"ID deleted ",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
