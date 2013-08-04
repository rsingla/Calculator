package com.techcodepro.calculator;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Currency extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_currency);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.currency, menu);
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
	
	public boolean convertCurrency(View view) {
		
		GoogleRestCall googleRestCall = new GoogleRestCall();
		
		Spinner spinner1 = (Spinner) findViewById(R.id.currency1);
		Spinner spinner2 = (Spinner) findViewById(R.id.currency2);
	
		TextView tv = (TextView) findViewById(R.id.result_currency);
		String result = googleRestCall.callGoogle( String.valueOf(spinner1.getSelectedItem()),
				String.valueOf(spinner2.getSelectedItem()), setDoubleValue1());
		
		tv.setText("Result = " + result);
		return true;
	}

	private Double setDoubleValue1() {
		EditText editText1 = (EditText) findViewById(R.id.currencyText);
		Double value1 = Double.parseDouble(editText1.getText().toString());
		return value1;
	}

}
