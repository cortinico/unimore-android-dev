//
//	Applicazione di Esempio realizzata da Nicola Corti
//	Linux Day 2012 Pisa - 27 Ottobre 2012
//	Per maggiori info: corti.nico [at] gmail.com

package com.example.unimore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.unimore.R;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Carico il layout
		setContentView(R.layout.activity_main);

		// Recupero il bottone `button1` dal layout
		Button MyButt = (Button) findViewById(R.id.button1);

		// Registro un nuovo listner
		MyButt.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				// Recupero il testo da `editText1`
				EditText MyText = (EditText) findViewById(R.id.editText1);
				String MyName = MyText.getText().toString();

				// Creo un nuovo Intent di Share
				Intent MyShareIntent = new Intent(
						android.content.Intent.ACTION_SEND);
				MyShareIntent.setType("text/plain");
				MyShareIntent.putExtra(android.content.Intent.EXTRA_TEXT,
						MyName + " ha creato la sua prima App Android!");
				startActivity(MyShareIntent);
			}
		});
	}
}
