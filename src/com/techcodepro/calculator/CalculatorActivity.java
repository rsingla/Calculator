package com.techcodepro.calculator;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calculator, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public boolean add(View view) {
		TextView tv = (TextView) findViewById(R.id.result);
		Double value1 =  setDoubleValue1();
		Double value2 =  setDoubleValue2();
		tv.setText("Result = " + (value1+value2));
		return true;
	}
	
	public boolean minus(View view) {
		// Inflate the menu; this adds items to the action bar if it is present.
		TextView tv = (TextView) findViewById(R.id.result);
		Double value1 =  setDoubleValue1();
		Double value2 =  setDoubleValue2();
		tv.setText("Result = " + (value1-value2));
		return true;
	}


	public boolean multiply(View view) {
		// Inflate the menu; this adds items to the action bar if it is present.
		TextView tv = (TextView) findViewById(R.id.result);
		Double value1 =  setDoubleValue1();
		Double value2 =  setDoubleValue2();
		tv.setText("Result = " + (value1*value2));

		return true;
	}

	public boolean divide(View view) {
		// Inflate the menu; this adds items to the action bar if it is present.
		TextView tv = (TextView) findViewById(R.id.result);
		Double value1 =  setDoubleValue1();
		Double value2 =  setDoubleValue2();
		tv.setText("Result = " + (value1/value2));
		return true;
	}

	public boolean power(View view) {
		// Inflate the menu; this adds items to the action bar if it is present.
		TextView tv = (TextView) findViewById(R.id.result);
		Double value1 =  setDoubleValue1();
		Double value2 =  setDoubleValue2();
		tv.setText("Result = " + Math.pow(value1,value2));
		return true;
	}

	public boolean sqrt(View view) {
		// Inflate the menu; this adds items to the action bar if it is present.
		TextView tv = (TextView) findViewById(R.id.result);
		Double value1 = setDoubleValue1();
		tv.setText("Result = " + (Math.sqrt(value1)));
		return true;
	}

	public boolean log(View view) {
		// Inflate the menu; this adds items to the action bar if it is present.
		TextView tv = (TextView) findViewById(R.id.result);
		Double value1 =  setDoubleValue1();
		tv.setText("Result = " + Math.log(value1));
		return true;
	}

	public boolean negative(View view) {
		// Inflate the menu; this adds items to the action bar if it is present.

		Double value1 =  setDoubleValue1();
		Double value2 =  setDoubleValue2();
		if((value1 < 0 && value2 < 0) || (value1 == 0 && value2 == 0)) {
			return false;
		}
		if(value1 > 0) {
			EditText editText1 = (EditText) findViewById(R.id.inputNumber1);
			editText1.setText("-"+ value1);
		}
		
		if(value2 > 0) {
			EditText editText2 = (EditText) findViewById(R.id.inputNumber2);
			editText2.setText("-"+ value2);
		}
		
		return true;
	}


	private Double setDoubleValue1() {
		EditText editText1 = (EditText) findViewById(R.id.inputNumber1);

		Double value1 = Double.parseDouble(editText1.getText().toString());

		return value1;
	}

	private Double setDoubleValue2() {
		EditText editText2 = (EditText) findViewById(R.id.inputNumber2);

		Double value2 = Double.parseDouble(editText2.getText().toString());
		return value2;
	}

	
}
