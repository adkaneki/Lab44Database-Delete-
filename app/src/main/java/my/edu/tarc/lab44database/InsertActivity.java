package my.edu.tarc.lab44database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity {
    private EditText editTextPhone, editTextFirstName, editTextLastName;
    public static final String INSERT_PHONE = "my.edu.tarc.demoroom.PHONE";
    public static final String INSERT_LAST = "my.edu.tarc.demoroom.LAST";
    public static final String INSERT_FIRST = "my.edu.tarc.demoroom.FIRST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        editTextPhone = findViewById(R.id.editTextPhone);
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);

        Button buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(editTextPhone.getText())){
                    editTextPhone.setError("Phone is empty.");
                    return;
                }
                if(TextUtils.isEmpty(editTextFirstName.getText())){
                    editTextFirstName.setError("First name is empty.");
                    return;
                }
                if(TextUtils.isEmpty(editTextLastName.getText())){
                    editTextLastName.setError("Last name is empty.");
                    return;
                }
                String phone, firstName, lastName;
                phone = editTextPhone.getText().toString();
                firstName = editTextFirstName.getText().toString();
                lastName = editTextLastName.getText().toString();

                Intent intent = new Intent();
                intent.putExtra(INSERT_PHONE, phone);
                intent.putExtra(INSERT_FIRST, firstName);
                intent.putExtra(INSERT_LAST, lastName);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
    }
}
