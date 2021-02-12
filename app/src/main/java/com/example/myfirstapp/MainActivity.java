package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Math.PI;


public class MainActivity extends AppCompatActivity {
    //store the data from the user
    double argMass;
    double argAngle;
    double argVelocity;
    double argInitialHeight;
    double argFinalHeight;
    //after calculation
    double LandingTime;
    double HalfwayTime;

    //arguments for the text from the user
    EditText mass;
    EditText angle;
    EditText velocity;
    EditText Initialheight;
    EditText Finalheight;

    Button inputbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mass = (EditText) findViewById(R.id.MassField);
        angle = (EditText) findViewById(R.id.AngleField);
        velocity = (EditText) findViewById(R.id.VelocityFIeld);
        Initialheight = (EditText) findViewById(R.id.Start);
        Finalheight = (EditText) findViewById(R.id.FinFIeld);

        //button configuration
        inputbutton = (Button) findViewById(R.id.MassKey);
        inputbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //store the values of the input as a double for later calculation
                argMass = Double.valueOf(mass.getText().toString());
                //the angle is in degrees. convert to radian if necessary
                argAngle = Double.valueOf(angle.getText().toString());
                argVelocity = Double.valueOf(velocity.getText().toString());
                argInitialHeight = Double.valueOf(Initialheight.getText().toString());
                argFinalHeight = Double.valueOf(Finalheight.getText().toString());

                //calculations for the result
                //using the data about the object from the user inputs
                double TimeToOtherSide;
                double TimeToOtherSide = 2*argVelocity*Math.sin(argAngle*PI / 180) / 9.8;
                double TimeToLandAfter = 0.0;
                if (argInitialHeight - argFinalHeight < 0)
                {
                    TimeToLandAfter = -1 * (argInitialHeight - argFinalHeight) / (argVelocity * Math.sin(argAngle * PI/ 180));
                }
                else
                {
                    TimeToLandAfter = (argInitialHeight - argFinalHeight) / (argVelocity * Math.sin(argAngle * PI/180));
                }
                LandingTime = TimeToOtherSide + TimeToLandAfter;
                showToast(String.valueOf(LandingTime));
            }
        });
    }
    private void showToast(String text)
    {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }
}