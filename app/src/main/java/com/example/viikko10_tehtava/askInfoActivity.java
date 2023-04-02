package com.example.viikko10_tehtava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class askInfoActivity extends AppCompatActivity {

    private UserStorage storage;
    private User newUser;
    private EditText txtFirstName, txtLastName, txtEmail;
    private Context context;

    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4;

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_info);

        storage = UserStorage.getInstance();
        newUser = null;

        txtFirstName = findViewById(R.id.editTextFirstName);
        txtLastName = findViewById(R.id.editTextLastName);
        txtEmail = findViewById(R.id.editTextEmail);
        context = askInfoActivity.this;

        checkBox1 = findViewById(R.id.cbBachelor);
        checkBox2 = findViewById(R.id.cbMaster);
        checkBox3 = findViewById(R.id.cbDoctor);
        checkBox4 = findViewById(R.id.cbSwimmaster);

        radioGroup = findViewById(R.id.rgStudyType);
    }

    public void createNewUser(View view)    {
        RadioGroup rgStudyType = findViewById(R.id.rgStudyType);
        CheckBox cB1 = findViewById(R.id.cbBachelor);
        CheckBox cB2 = findViewById(R.id.cbMaster);
        CheckBox cB3 = findViewById(R.id.cbDoctor);
        CheckBox cB4 = findViewById(R.id.cbSwimmaster);
        String[] l1 = {"Tietotekniikka", "Tuotantotalous", "Laskennallinen tekniikka", "Sähkötekniikka"};
        String[] l2 = {"Kandidaatin tutkinto", "Diplomi-insinöörin tutkinto", "Tekniikan tohtorin tutkinto", "Uimamaisteri"};

        switch (rgStudyType.getCheckedRadioButtonId()) {
            case R.id.radioButtonTITE:
                newUser = new User(txtFirstName.getText().toString(), txtLastName.getText().toString(), txtEmail.getText().toString(), l1[0]);
                break;

            case R.id.radioButtonTUTA:
                newUser = new User(txtFirstName.getText().toString(), txtLastName.getText().toString(), txtEmail.getText().toString(), l1[1]);
                break;

            case R.id.radioButtonLATE:
                newUser = new User(txtFirstName.getText().toString(), txtLastName.getText().toString(), txtEmail.getText().toString(), l1[2]);
                break;

            case R.id.radioButtonSATE:
                newUser = new User(txtFirstName.getText().toString(), txtLastName.getText().toString(), txtEmail.getText().toString(), l1[3]);
                break;

            default:
                System.out.println("Anna käyttäjän tiedot!");
        }

        if (cB1.isChecked())    {
            newUser.addDegree(l2[0]);
        }
        if (cB2.isChecked())    {
            newUser.addDegree(l2[1]);
        }
        if (cB3.isChecked())    {
            newUser.addDegree(l2[2]);
        }
        if (cB4.isChecked())    {
            newUser.addDegree(l2[3]);
        }
        storage.addUser(newUser);

        storage.saveUsers(context); //saves new user into the file

        //clear old userdata from elements in the app
        txtFirstName.setText("");
        txtLastName.setText("");
        txtEmail.setText("");

        if (checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked() || checkBox4.isChecked())  {
            checkBox1.setChecked(false);
            checkBox2.setChecked(false);
            checkBox3.setChecked(false);
            checkBox4.setChecked(false);
        }

        if (radioGroup.getCheckedRadioButtonId() != -1) {
            radioGroup.clearCheck();
        }
    }
}