package com.stepcounter;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {

	private SensorManager mSensorManager;
	private Sensor mStepCounter;
	private TextView myStepCounter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		myStepCounter = (TextView) this.findViewById(R.id.textStepCounter);

		mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		mStepCounter = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		myStepCounter.setText(Float.toString(event.values[0])
				+ " " + Float.toString(event.values[1]) + " "
				+ Float.toString(event.values[2]));

	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub

	}

	protected void onResume() {
		super.onResume();
		mSensorManager.registerListener(this, mStepCounter,
				SensorManager.SENSOR_DELAY_NORMAL);
	}

	protected void onPause() {
		super.onPause();
		mSensorManager.unregisterListener(this);
	}

}
