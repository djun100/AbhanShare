package com.abhan.example.abhansharedone;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AbhanActivity extends Activity implements OnClickListener {
	
	private static final String SHARED_TAG = "AbhanSharedText";
	private TextView txtReceived = null;
	private EditText edtUserEntered = null;
	private Button btnSend = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_abhan);
		initComponent();
	}
	
	private void initComponent() {
		txtReceived = (TextView) findViewById(R.id.txt_received);
		txtReceived.setText(getString(R.string.sent) + " --- ");
		edtUserEntered = (EditText) findViewById(R.id.edt_userentered);
		btnSend = (Button) findViewById(R.id.btn_send);
		btnSend.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch(view.getId()) {
			case R.id.btn_send:
				final String userEnteredText = edtUserEntered.getText().toString().trim();
				if(userEnteredText != null && userEnteredText.length() > 0 && !userEnteredText.contains("null")) {
					txtReceived.setText(getString(R.string.sent) + " " + userEnteredText);
					System.setProperty(SHARED_TAG, userEnteredText);
				} else {
					txtReceived.setText(getString(R.string.sent) + " --- ");
				}
				break;
		}
	}
}