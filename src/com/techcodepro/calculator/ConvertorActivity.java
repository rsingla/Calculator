package com.techcodepro.calculator;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ConvertorActivity extends FragmentActivity implements OnItemSelectedListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_convertor);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		
		
		getMenuInflater().inflate(R.menu.convertor, menu);
		Spinner conversionTypeSpinner = (Spinner) findViewById(R.id.conversiontype);
		conversionTypeSpinner.setOnItemSelectedListener(this);
		
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
	

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int pos,
			long arg3) {

		selectInnerTypes();
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		selectInnerTypes();
	}


	public boolean selectInnerTypes() {

		Spinner conversionTypeSpinner = (Spinner) findViewById(R.id.conversiontype);
		Spinner conversionSetSpinnerType1 = (Spinner) findViewById(R.id.innerconversiontype1);
		Spinner conversionSetSpinnerType2 = (Spinner) findViewById(R.id.innerconversiontype2);
		String value = String.valueOf(conversionTypeSpinner.getSelectedItem());

		if(value.equalsIgnoreCase("Temperature")) {
			List<String> tempArray = new ArrayList<String>();
			tempArray.add("F");
			tempArray.add("C");
			tempArray.add("K");
			
			ArrayAdapter<String> spinnerArrayAdapter = 
					new ArrayAdapter<String>(this, 
							android.R.layout.simple_spinner_dropdown_item, tempArray);
			 conversionSetSpinnerType1.setAdapter(spinnerArrayAdapter);
			 conversionSetSpinnerType2.setAdapter(spinnerArrayAdapter); 
		
		}
		
		else if(value.equalsIgnoreCase("Data") ) {
			List<String> dataArray = new ArrayList<String>();
			dataArray.add("Bit");
			dataArray.add("Byte");
			dataArray.add("Kilobit");
			dataArray.add("Kilobyte");
			dataArray.add("Megabit");
			dataArray.add("Megabyte");
			dataArray.add("Gigabit");
			dataArray.add("Gigabyte");
			dataArray.add("Terabit");
			dataArray.add("Terabyte");
			dataArray.add("Petabit");
			dataArray.add("Petabyte");
			ArrayAdapter<String> spinnerArrayAdapter = 
					new ArrayAdapter<String>(this, 
							android.R.layout.simple_spinner_dropdown_item, dataArray);
			 conversionSetSpinnerType1.setAdapter(spinnerArrayAdapter);
			 conversionSetSpinnerType2.setAdapter(spinnerArrayAdapter);
	
		}
			return true;
		}

		public boolean typeConvert(View view) {

			Spinner innerconversiontype1 = (Spinner) findViewById(R.id.innerconversiontype1);
			Spinner innerconversiontype2 = (Spinner) findViewById(R.id.innerconversiontype2);

			GoogleRestCall googleRestCall = new GoogleRestCall();

			TextView tv = (TextView) findViewById(R.id.result_metric);
			
			String value1 = String.valueOf(innerconversiontype1.getSelectedItem());
			String value2 = String.valueOf(innerconversiontype2.getSelectedItem());
			String result = googleRestCall.callGoogle(value1.toLowerCase() ,
					value2.toLowerCase(), setDoubleValue1());

			tv.setText( result );
			return true;
		}
		
		private Double setDoubleValue1() {
			EditText editText1 = (EditText) findViewById(R.id.metricsValue);
			Double value1 = Double.parseDouble(editText1.getText().toString());
			return value1;
		}

	}
