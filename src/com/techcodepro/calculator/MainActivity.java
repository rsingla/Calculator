package com.techcodepro.calculator;

import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean clickCurrencyConvertor(View view) {
		Intent currencyIntent = new Intent(MainActivity.this, Currency.class);
		MainActivity.this.startActivity(currencyIntent);
		return true;
	}
	
	public boolean clickCalcConvertor(View view) {
		Intent currencyIntent = new Intent(MainActivity.this, CalculatorActivity.class);
		MainActivity.this.startActivity(currencyIntent);
		return true;
	}
	public boolean clickMetricConvertor(View view) {
		Intent metricConvertorIntent = new Intent(MainActivity.this, ConvertorActivity.class);
		MainActivity.this.startActivity(metricConvertorIntent);
		return true;
	}
	
	
}
