package com.example.unimore.web;

import com.example.unimore.web.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class WebActivity extends Activity {

	// Riferimento all'oggetto webview
	WebView web = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Carico il layout
		setContentView(R.layout.activity_web);

		// Recupero l'oggetto webview
		web = (WebView) findViewById(R.id.web);

		// Abilito Javascript e lo Zoom con 2 dita
		web.getSettings().setJavaScriptEnabled(true);
		web.getSettings().setBuiltInZoomControls(true);

		// Carica la Home page
		web.loadUrl("http://www.google.it/");
		
		// Recupero il riferimento alla casella di testo
		final EditText text_url = (EditText)findViewById(R.id.link);
		
		// Recupero il riferimento al bottone
		Button btn = (Button)findViewById(R.id.go);
		
		// Aggiungo un listner al bottone `Naviga`
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// Fa navigare verso l'indirizzo contenuto nella casella di testo
				String url = text_url.getText().toString();
				web.loadUrl(url);
			}
		});
		
		// Aggiorna la barra degli indirizzi
		web.setWebViewClient(new MyWebViewClient());
	}
	
	@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(event.getAction() == KeyEvent.ACTION_DOWN){
            switch(keyCode)
            {
            // Controlla se e' stato premuto il tasto indietro
            case KeyEvent.KEYCODE_BACK:
                if(web != null && web.canGoBack()){
                	// Va indietro nella navigazione
                    web.goBack();
                }else{
                	// Altrimenti chiude l'app
                    finish();
                }
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
	
	// Impedisco che i link vengano aperti dal browser di default
	private class MyWebViewClient extends WebViewClient {
	    @Override
	    public boolean shouldOverrideUrlLoading(WebView view, String url) {
	        view.loadUrl(url);
	        return true;
	    }
	}
}
