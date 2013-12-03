package com.abhan.example.abhansharedtwo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AbhanActivity extends Activity implements OnClickListener {
	
	private static final String SHARED_TAG = "AbhanSharedText";
	private TextView txtReceived = null;
	private Button btnReceive = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_abhan);
		initComponent();
	}
	
	private void initComponent() {
		txtReceived = (TextView) findViewById(R.id.txt_received);
		txtReceived.setText(getString(R.string.received) + " --- ");
		btnReceive = (Button) findViewById(R.id.btn_receive);
		btnReceive.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch(view.getId()) {
			case R.id.btn_receive:
				final String userReceivedText = System.getProperty(SHARED_TAG);
				if(userReceivedText != null && userReceivedText.length() > 0 && !userReceivedText.contains("null")) {
					txtReceived.setText(userReceivedText);
				} else {
					txtReceived.setText(getString(R.string.received) + " --- ");
				}
				break;
		}
	}
}