package com.ANUINYIF.modernartui;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.style.BulletSpan;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

import java.lang.reflect.Field;

import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity implements View.OnClickListener{

	private Button red,white,blue,yellow,yellowtwo,one;
	private SeekBar seekBarChangeColor;
	private int seekBarValue;
	private ActionBar getBar;
	private int redAlpha,redR,redG,redB,whiteAlpha,whiteR,whiteG,whiteB;
	private int blueAlpha,blueR,blueG,blueB,yellowAlpha,yellowR,yellowG,yellowB;
	private int yellowtwoAlpha,yellowtwoR,yellowtwoG,yellowtwoB,oneAlpha,oneR,oneG,oneB;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setDefaultActionBarColor();
		
//		Set the menu shown as three dots(...)
		try {
	        ViewConfiguration config = ViewConfiguration.get(this);
	        Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
	        if(menuKeyField != null) {
	            menuKeyField.setAccessible(true);
	            menuKeyField.setBoolean(config, false);
	        }
	    } catch (Exception ex) {
	    	return;
	    }
		
//		Initialize components
		red = (Button) findViewById(R.id.btnRed);
		white = (Button) findViewById(R.id.btnWhite);
		blue = (Button) findViewById(R.id.btnBlue);
		yellow = (Button) findViewById(R.id.btnYellow);
		yellowtwo = (Button) findViewById(R.id.btnYellowtwo);
		one = (Button) findViewById(R.id.btnOne);
		seekBarChangeColor = (SeekBar) findViewById(R.id.mySeekBar);
		
//	 	Listen the click event of these buttons
		red.setOnClickListener(this);
		white.setOnClickListener(this);
		blue.setOnClickListener(this);
		yellowtwo.setOnClickListener(this);
		one.setOnClickListener(this);
		yellow.setOnClickListener(this);
		
//		Get the alpha value of the buttons' background
		//Red Button
		ColorDrawable cd1 = (ColorDrawable) red.getBackground();
		int redColor = cd1.getColor();
		redAlpha = cd1.getAlpha();
		redR = Color.red(redColor);
		redG = Color.green(redColor);
		redB = Color.blue(redColor);
		//White Button
		ColorDrawable cd2 = (ColorDrawable) white.getBackground();
		int whiteColor = cd2.getColor();
		whiteAlpha = cd2.getAlpha();
		whiteR = Color.red(whiteColor);
		whiteG = Color.green(whiteColor);
		whiteB = Color.blue(whiteColor);
		//Blue Button
		ColorDrawable cd3 = (ColorDrawable) blue.getBackground();
		final int blueColor = cd3.getColor();
		blueAlpha = cd3.getAlpha();
		blueR = Color.red(blueColor);
		blueG = Color.green(blueColor);
		blueB = Color.blue(blueColor);
		//Yellow Button
		ColorDrawable cd4 = (ColorDrawable) yellow.getBackground();
		final int yellowColor = cd4.getColor();
		yellowAlpha = cd4.getAlpha();
		yellowR = Color.red(yellowColor);
		yellowG = Color.green(yellowColor);
		yellowB = Color.blue(yellowColor);
		//YellowTwo Button
		ColorDrawable cd5 = (ColorDrawable) yellowtwo.getBackground();
		final int yellowtwoColor = cd5.getColor();
		yellowtwoAlpha = cd5.getAlpha();
		yellowtwoR = Color.red(yellowtwoColor);
		yellowtwoG = Color.green(yellowtwoColor);
		yellowtwoB = Color.blue(yellowtwoColor);
		//One Button
		ColorDrawable cd6 = (ColorDrawable) one.getBackground();
		final int oneColor = cd6.getColor();
		oneAlpha = cd6.getAlpha();
		oneR = Color.red(oneColor);
		oneG = Color.green(oneColor);
		oneB = Color.blue(oneColor);
		
		
//		Listen seekBar value change--Change the background of the button
		seekBarChangeColor.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
		
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				red.setBackgroundColor(Color.argb(redAlpha, redR - progress, redG + progress, redB + progress));
				blue.setBackgroundColor(Color.argb(blueAlpha, blueR + progress, blueG - progress, (blueB - progress)));
				yellow.setBackgroundColor(Color.argb(yellowAlpha, yellowR + progress,yellowG + progress, yellowB - progress));
				yellowtwo.setBackgroundColor(Color.argb(yellowtwoAlpha, yellowtwoR - progress, yellowtwoG - progress, yellowtwoB + progress));
				red.setBackgroundColor(Color.argb(redAlpha, redR - progress, redG + progress, redB + progress));
				one.setBackgroundColor(Color.argb(oneAlpha, oneR - progress, oneG + progress, oneB - progress));
			}
		});
		
	}
	
//	Click the button to change the action bar color ~
	@Override
	public void onClick(View v) {
		getBar = getActionBar();
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnRed:
			getBar.setBackgroundDrawable(new ColorDrawable(Color.argb(redAlpha, redR, redG, redB)));
			break;
		case R.id.btnBlue:
			getBar.setBackgroundDrawable(new ColorDrawable(Color.argb(blueAlpha, blueR, blueG, blueB)));
			break;
		case R.id.btnOne:
			getBar.setBackgroundDrawable(new ColorDrawable(Color.argb(oneAlpha, oneR, oneG, oneB)));
			break;
		case R.id.btnWhite:
			getBar.setBackgroundDrawable(new ColorDrawable(Color.argb(whiteAlpha, whiteR, whiteG, whiteB)));
			break;
		case R.id.btnYellow:
			getBar.setBackgroundDrawable(new ColorDrawable(Color.argb(yellowAlpha, yellowR, yellowG, yellowB)));
			break;
		case R.id.btnYellowtwo:
			getBar.setBackgroundDrawable(new ColorDrawable(Color.argb(yellowtwoAlpha, yellowtwoR, yellowtwoG, yellowtwoB)));
			break;
		default:
			break;
		}
	}
	
//	Change action bar background color
	public void setDefaultActionBarColor()
	{
		getBar = getActionBar();
		getBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(51, 153, 255)));
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		
		if (id == R.id.mytitle) {
			final Dialog dialog = new Dialog(this);
			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			dialog.setContentView(R.layout.custome_dialog);
			Button view_moma = (Button) dialog.findViewById(R.id.btnViewMoma);
			Button not_now = (Button) dialog.findViewById(R.id.btnNotNow);
			dialog.show();
			view_moma.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.moma.org"));
					startActivity(intent);
					dialog.dismiss();
				}
			});
			
			not_now.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					dialog.dismiss();
				}
			});

	}
		return true;
	}
}
