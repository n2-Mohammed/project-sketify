package com.sketify.msk;

import android.animation.*;
import android.animation.ObjectAnimator;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.google.firebase.FirebaseApp;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class FullviewActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private String last = "";
	private String url = "";
	
	private LinearLayout linear1;
	private ImageView main;
	
	private TimerTask timer;
	private ObjectAnimator oa_d = new ObjectAnimator();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.fullview);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		main = findViewById(R.id.main);
	}
	
	private void initializeLogic() {
		_custom_loading(true);
		url = getIntent().getStringExtra("main");
		main.setAlpha((float)(0.100d));
		if (!getIntent().getStringExtra("main").equals("")) {
			if (getIntent().getStringExtra("main").equals("avator")) {
				main.setImageResource(R.drawable.default_avatar);
			}
			else {
				if (getIntent().getStringExtra("main").equals(last)) {
					last = getIntent().getStringExtra("main");
					_img(main, url);
				}
				else {
					last = getIntent().getStringExtra("main");
					_img(main, url);
				}
			}
		}
		else {
			main.setImageResource(R.drawable.default_avatar);
			main.setAlpha((float)(.500d));
			final AlertDialog error_dialog = new AlertDialog.Builder(FullviewActivity.this).create();
			LayoutInflater inflater = getLayoutInflater();
			
			View convertView = (View) inflater.inflate(R.layout.error_dialog, null);
			error_dialog.setView(convertView);
			
			error_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);  error_dialog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
			
			LinearLayout e_bg = (LinearLayout) convertView.findViewById(R.id.linear_bg);
			
			LinearLayout e_div = (LinearLayout) convertView.findViewById(R.id.linear_div);
			
			Button e_ok = (Button) convertView.findViewById(R.id.okay_button);
			
			Button e_cancel = (Button) convertView.findViewById(R.id.cancel_button);
			
			ImageView e_header = (ImageView) convertView.findViewById(R.id.img_header);
			
			TextView e_title = (TextView) convertView.findViewById(R.id.txt_title);
			
			TextView e_msg = (TextView) convertView.findViewById(R.id.txt_msg);
			
			_setBgCorners(e_bg, 8, "#FFFFFF");
			_setBgCorners(e_ok, 8, "#F44336");
			_setBgCorners(e_cancel, 8, "#E57373");
			e_header.setElevation(5);
			e_cancel.setVisibility(View.GONE);
			e_div.setVisibility(View.GONE);
			e_msg.setText("File Not Contains Image, An Error Occured!");
			e_ok.setOnClickListener(new View.OnClickListener(){
				    public void onClick(View v){
					error_dialog.dismiss();
					finish();
				}});
			e_cancel.setOnClickListener(new View.OnClickListener(){
				    public void onClick(View v){
					error_dialog.dismiss();
				}});
			error_dialog.show();
			_bounce(e_header);
			SketchwareUtil.showMessage(getApplicationContext(), "An Error Occured");
		}
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						_custom_loading(false);
						main.setAlpha((float)(1));
						/*
View zoomView = new ZoomView(this);

zoomView.setMaxZoom(3.0f);

zoomView.setLayoutParams(new LayoutParams(-1, -1));

this.linear1.addView(zoomView);

this.linear1.removeView(this.main);

zoomView.addView(this.main);
*/
						
					}
				});
			}
		};
		_timer.schedule(timer, (int)(1099));
	}
	
	public void _custom_loading(final boolean _visibility) {
		if (_visibility) {
			if (coreprog == null){
				coreprog = new ProgressDialog(this);
				coreprog.setCancelable(false);
				coreprog.setCanceledOnTouchOutside(false);
				
				coreprog.requestWindowFeature(Window.FEATURE_NO_TITLE);  coreprog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
				
			}
			coreprog.setMessage(null);
			coreprog.show();
			View _view = getLayoutInflater().inflate(R.layout.load, null);
			LinearLayout linear_base = (LinearLayout) _view.findViewById(R.id.linear_base);
			
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.TRANSPARENT);
			gd.setCornerRadius(25);
			linear_base.setBackground(gd);
			coreprog.setContentView(_view);
		}
		else {
			if (coreprog != null){
				coreprog.dismiss();
			}
		}
	}
	private ProgressDialog coreprog;
	{
	}
	
	
	public void _setBgCorners(final View _view, final double _radius, final String _color) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(); 
		gd.setColor(Color.parseColor("#" + _color.replace("#", ""))); /* color */
		gd.setCornerRadius((int)_radius); /* radius */
		gd.setStroke(0, Color.WHITE); /* stroke heigth and color */
		_view.setBackground(gd);
	}
	
	
	public void _bounce(final View _view) {
		oa_d.setTarget(_view);
		oa_d.setPropertyName("rotation");
		oa_d.setFloatValues((float)(90), (float)(0));
		oa_d.setDuration((int)(1000));
		oa_d.setInterpolator(new BounceInterpolator());
		oa_d.start();
	}
	
	
	public void _rippleRoundStroke(final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public void _img(final ImageView _view, final String _str) {
		
		_view.setImageDrawable(null);
		
		Glide.with(getApplicationContext()).load(Uri.parse(_str)).error(R.drawable.ic_sim_card_alert_black).fallback(R.drawable.ic_sim_card_alert_black).into(_view);
		
		
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}