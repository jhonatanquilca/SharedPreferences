package com.example.sharedpreferences;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class SharedPreferencesActivity extends Activity {
	private SharedPreferences prefs;
	private String nombrePref="MiPref";
	private EditText editText;
	private SeekBar seekBar;
	private Button btn;
	private static final String TAM_FUENTE_KEY ="tamfuente";
	private static final String VALOR_TEXTO_KEY ="valortexto";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shared_preferences);
		
		editText = (EditText) findViewById(R.id.EditText01);
		seekBar=(SeekBar)findViewById(R.id.SeekBar01);
		btn=(Button)findViewById(R.id.btnSabe);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// obtener los objetos SharedPreferences 
				prefs =getSharedPreferences(nombrePref,MODE_PRIVATE);
				SharedPreferences.Editor editor=prefs.edit();
//				salvar los valores en la view Edit test a preferencias
				editor.putFloat(TAM_FUENTE_KEY, editText.getTextSize());
				editor.putString(VALOR_TEXTO_KEY,editText.getText().toString());
				//salvar valores
				editor.commit();
//				mostar mensaje de archivo salvado
				Toast.makeText(getBaseContext(), "Tamaño de fuente salvado", Toast.LENGTH_SHORT).show();
				
				
			}
		});
		
//		carga el objeto sharede preferences
		SharedPreferences prefs=getSharedPreferences(nombrePref,MODE_PRIVATE);
//		configurar el tamaño de fuente del text view a los valores salvados
		float fontSize=prefs.getFloat(TAM_FUENTE_KEY,12);
		seekBar.setProgress((int)fontSize);
		editText.setText(prefs.getString(VALOR_TEXTO_KEY, ""));
		
		
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shared_preferences, menu);
		return true;
	}

}

