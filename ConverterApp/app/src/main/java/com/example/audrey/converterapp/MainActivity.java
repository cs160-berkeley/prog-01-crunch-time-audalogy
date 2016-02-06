package com.example.audrey.converterapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Exercise Conversions
    final double JJACK = 10;
    final double PUSHUP = 350;
    final double SITUP = 200;
    final double JOGGING = 12;

    final double SQUAT = 225;
    final double LLIFT = 25;
    final double PLANK = 25;
    final double PULLUP = 100;
    final double CYCLING = 12;
    final double WALKING = 20;
    final double SWIMMING = 13;
    final double STAIRS = 15;

    //Variables
    EditText originalNum;
    double conversionOne, conversionTwo, inputNum, selfUnit, result, calories;
    String selection1, selection2;
    TextView addResult, addCaloriesResult;
    Button btnConvert, btnClear;
    RadioButton radioButtonRep1, radioButtonMin1, radioButtonRep2, radioButtonMin2;

//    Map<String, Double> map = new HashMap<String, Double>();
//    map.put("pushups", PUSHUP);
//    map.put("situps", SITUP);
//    map.put("jumping jacks", JJACK);
//    map.put("jogging", JOGGING);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get results from view
        originalNum = (EditText)findViewById(R.id.editTextNum);
        addResult = (TextView)findViewById(R.id.txtResult);
        addCaloriesResult = (TextView)findViewById(R.id.caloriesResult);
        btnConvert = (Button)findViewById(R.id.btnConvert);
        btnClear = (Button)findViewById(R.id.btnClear);
        radioButtonRep1 = (RadioButton)findViewById(R.id.radioButton1);
        radioButtonMin1 = (RadioButton)findViewById(R.id.radioButton2);
        radioButtonRep2 = (RadioButton)findViewById(R.id.radioButton3);
        radioButtonMin2 = (RadioButton)findViewById(R.id.radioButton4);

        //Add Click Listener to Enter button
        btnConvert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                inputNum = Double.parseDouble(originalNum.getText().toString());
                selfUnit = inputNum / conversionOne;
                //Log.i("inputNum:", Double.toString(inputNum));
                //Log.i("conversionOne:", Double.toString(conversionOne));
                //Log.i("selfUnit:", Double.toString(selfUnit));

                result = selfUnit * conversionTwo;
                calories = Math.round(selfUnit * 100);

                //remove .0 in output format
                DecimalFormat format = new DecimalFormat();
                DecimalFormat precision = new DecimalFormat("0.00");
                format.setDecimalSeparatorAlwaysShown(false);

                addResult.setText(precision.format(result));
                addCaloriesResult.setText(format.format(calories));
            }
        });

        //Add Click Listener to Clear button
        btnClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //http://stackoverflow.com/questions/2470870/force-application-to-restart-on-first-activity
                finish();
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        //Create radioGroup1 and radioGroup2
        final RadioGroup radioGroup1 = (RadioGroup)findViewById(R.id.radio_selection1);
        final RadioGroup radioGroup2 = (RadioGroup)findViewById(R.id.radio_selection2);

        //List 1
        ListView fromListView = (ListView)findViewById(R.id.fromListView);

        final ArrayList<String> fromExercises = new ArrayList<String>();

        fromExercises.add("jumping jacks");
        fromExercises.add("pushups");
        fromExercises.add("situps");
        fromExercises.add("jogging");
        fromExercises.add("squats");
        fromExercises.add("leg-lift");
        fromExercises.add("plank");
        fromExercises.add("pullup");
        fromExercises.add("cycling");
        fromExercises.add("walking");
        fromExercises.add("swimming");
        fromExercises.add("stair-climbing");

        // The adapter converts an ArrayList of objects into View items loaded into the ListView container.
        ArrayAdapter<String> arrayAdapterFrom = new ArrayAdapter<String>(this, R.layout.list_item, fromExercises);

        //set adapter to list view
        fromListView.setAdapter(arrayAdapterFrom);

        //obtain and change background on selected item
        fromListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setSelected(true);
                //Toast.makeText(getApplicationContext(),"You chose: " + fromExercises.get(position), Toast.LENGTH_LONG).show();
                selection1 = fromExercises.get(position);
                //Log.i("selection1:", selection1);
                if (selection1.equals("jumping jacks")) { //== compares string refrences not characters of strings.
                    //Compare strings using .equals() when string is object. When you declare string as String literal then you can compare strings using ==
                    conversionOne = JJACK;
                    radioGroup1.clearCheck();
                    radioButtonMin1.setChecked(true);
                }
                if (selection1.equals("pushups")) {
                    conversionOne = PUSHUP;
                    radioGroup1.clearCheck();
                    radioButtonRep1.setChecked(true);
                }
                if (selection1.equals("situps")) {
                    conversionOne = SITUP;
                    radioGroup1.clearCheck();
                    radioButtonRep1.setChecked(true);
                }
                if (selection1.equals("jogging")) {
                    conversionOne = JOGGING;
                    radioGroup1.clearCheck();
                    radioButtonMin1.setChecked(true);
                }
                if (selection1.equals("squats")) {
                    conversionOne = SQUAT;
                    radioGroup1.clearCheck();
                    radioButtonRep1.setChecked(true);
                }
                if (selection1.equals("leg-lift")) {
                    conversionOne = LLIFT;
                    radioGroup1.clearCheck();
                    radioButtonMin1.setChecked(true);
                }
                if (selection1.equals("plank")) {
                    conversionOne = PLANK;
                    radioGroup1.clearCheck();
                    radioButtonMin1.setChecked(true);
                }
                if (selection1.equals("pullup")) {
                    conversionOne = PULLUP;
                    radioGroup1.clearCheck();
                    radioButtonRep1.setChecked(true);
                }
                if (selection1.equals("cycling")) {
                    conversionOne = CYCLING;
                    radioGroup1.clearCheck();
                    radioButtonMin1.setChecked(true);
                }
                if (selection1.equals("walking")) {
                    conversionOne = WALKING;
                    radioGroup1.clearCheck();
                    radioButtonMin1.setChecked(true);
                }
                if (selection1.equals("swimming")) {
                    conversionOne = SWIMMING;
                    radioGroup1.clearCheck();
                    radioButtonMin1.setChecked(true);
                }
                if (selection1.equals("stair-climbing")) {
                    conversionOne = STAIRS;
                    radioGroup1.clearCheck();
                    radioButtonMin1.setChecked(true);
                }
            }
        });

        //List 2
        ListView toListView = (ListView)findViewById(R.id.toListView);

        final ArrayList<String> toExercises = new ArrayList<String>();

        toExercises.add("jumping jacks");
        toExercises.add("pushups");
        toExercises.add("situps");
        toExercises.add("jogging");
        toExercises.add("squats");
        toExercises.add("leg-lift");
        toExercises.add("plank");
        toExercises.add("pullup");
        toExercises.add("cycling");
        toExercises.add("walking");
        toExercises.add("swimming");
        toExercises.add("stair-climbing");

        ArrayAdapter<String> arrayAdapterTo = new ArrayAdapter<String>(this, R.layout.list_item, toExercises);

        toListView.setAdapter(arrayAdapterTo);

        //obtain and change background on selected item
        toListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setSelected(true);
                //Toast.makeText(getApplicationContext(), "You chose: " + toExercises.get(position), Toast.LENGTH_LONG).show();
                selection2 = toExercises.get(position);
                //Log.i("selection2:", selection2);
                if (selection2.equals("jumping jacks")) {
                    conversionTwo = JJACK;
                    radioGroup2.clearCheck();
                    radioButtonMin2.setChecked(true);
                }
                if (selection2.equals("pushups")) {
                    conversionTwo = PUSHUP;
                    radioGroup2.clearCheck();
                    radioButtonRep2.setChecked(true);
                }
                if (selection2.equals("situps")) {
                    conversionTwo = SITUP;
                    radioGroup2.clearCheck();
                    radioButtonRep2.setChecked(true);
                }
                if (selection2.equals("jogging")) {
                    conversionTwo = JOGGING;
                    radioGroup2.clearCheck();
                    radioButtonMin2.setChecked(true);
                }
                if (selection2.equals("squats")) {
                    conversionTwo = SQUAT;
                    radioGroup2.clearCheck();
                    radioButtonRep2.setChecked(true);
                }
                if (selection2.equals("leg-lift")) {
                    conversionTwo = LLIFT;
                    radioGroup2.clearCheck();
                    radioButtonMin2.setChecked(true);
                }
                if (selection2.equals("plank")) {
                    conversionTwo = PLANK;
                    radioGroup2.clearCheck();
                    radioButtonMin2.setChecked(true);
                }
                if (selection2.equals("pullup")) {
                    conversionTwo = PULLUP;
                    radioButtonRep2.setChecked(true);
                }
                if (selection2.equals("cycling")) {
                    conversionTwo = CYCLING;
                    radioButtonMin2.setChecked(true);
                }
                if (selection2.equals("walking")) {
                    conversionTwo = WALKING;
                    radioGroup2.clearCheck();
                    radioButtonMin2.setChecked(true);
                }
                if (selection2.equals("swimming")) {
                    conversionTwo = SWIMMING;
                    radioGroup2.clearCheck();
                    radioButtonMin2.setChecked(true);
                }
                if (selection2.equals("stair-climbing")) {
                    conversionTwo = STAIRS;
                    radioGroup2.clearCheck();
                    radioButtonMin2.setChecked(true);
                }
            }
        });


//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
