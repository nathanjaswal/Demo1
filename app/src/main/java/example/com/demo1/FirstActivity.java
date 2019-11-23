package example.com.demo1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity implements  View.OnClickListener {

    private TextView textName;
    private Button signInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        textName = findViewById(R.id.txt_name);
        signInBtn = findViewById(R.id.signin_btn);

        signInBtn.setOnClickListener(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

//        signInBtn.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                Toast.makeText(getApplicationContext(), "hello",  Toast.LENGTH_LONG).show();
//            }
//        });
    }

    @Override
    public void onClick(View view){
        if (textName.getText().toString().trim().length() != 0){

            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Write your message here.");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            builder1.setNegativeButton(
                    "No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                            Intent mIntent = new Intent(FirstActivity.this, SecondActivity.class);
                            mIntent.putExtra("name", textName.getText().toString());
                            startActivity(mIntent);
                        }
                    });


            AlertDialog alert11 = builder1.create();
            alert11.show();

        }else{
            textName.setError("Please Enter Name");
        }

    }



}
