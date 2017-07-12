package sg.edu.rp.c346.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;
    CheckBox ckbLike;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        etName = (EditText) findViewById(R.id.editTextName);
        etGPA = (EditText) findViewById(R.id.editTextGPA);
        rgGender=(RadioGroup)findViewById(R.id.RadioGroupGender);
        ckbLike=(CheckBox)findViewById(R.id.checkBoxLikeProgramming);
    }
    @Override
    protected void onPause() {
        super.onPause();

        String strName= etName.getText().toString();
        String strGPA = etGPA.getText().toString();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor prefEdit = prefs.edit();

        prefEdit.putString("name",strName);
        prefEdit.putString("GPA",strGPA);

        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        String strName= prefs.getString("name","John");
        String strGPA = prefs.getString("GPA","");

        etName.setText(strName);
        etGPA.setText(strGPA);


    }
}
