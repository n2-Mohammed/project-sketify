package com.sketify.msk;

import android.animation.*;
import android.animation.ObjectAnimator;
import android.app.*;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class SplashActivity extends AppCompatActivity {
	
	private String package_name = "";
	private String fontName = "";
	private String typeace = "";
	private HashMap<String, Object> vC = new HashMap<>();
	private String version = "";
	private String versionName = "";
	private String versionCode = "";
	private boolean truee = false;
	
	private ArrayList<HashMap<String, Object>> vC_list = new ArrayList<>();
	private ArrayList<String> vC_Keys = new ArrayList<>();
	
	private LinearLayout main;
	private LinearLayout imgs_gotta;
	private LinearLayout online;
	private LinearLayout offline;
	private LinearLayout btm_draw;
	private ImageView img_lg;
	private ImageView img_txt;
	private ProgressBar progress;
	private TextView txt_cnting;
	private LinearLayout linear_txts;
	private LinearLayout btnss;
	private TextView textview;
	private Button go_offline;
	private Button retry;
	private TextView website_go_on;
	
	private Intent intent = new Intent();
	private RequestNetwork net;
	private RequestNetwork.RequestListener _net_request_listener;
	private AlertDialog.Builder net_error;
	private Intent view_upd = new Intent();
	private FirebaseAuth auth;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private OnCompleteListener<Void> auth_updateEmailListener;
	private OnCompleteListener<Void> auth_updatePasswordListener;
	private OnCompleteListener<Void> auth_emailVerificationSentListener;
	private OnCompleteListener<Void> auth_deleteUserListener;
	private OnCompleteListener<Void> auth_updateProfileListener;
	private OnCompleteListener<AuthResult> auth_phoneAuthListener;
	private OnCompleteListener<AuthResult> auth_googleSignInListener;
	
	private Intent go = new Intent();
	private ObjectAnimator oa_d = new ObjectAnimator();
	private Intent view_web = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.splash);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		main = findViewById(R.id.main);
		imgs_gotta = findViewById(R.id.imgs_gotta);
		online = findViewById(R.id.online);
		offline = findViewById(R.id.offline);
		btm_draw = findViewById(R.id.btm_draw);
		img_lg = findViewById(R.id.img_lg);
		img_txt = findViewById(R.id.img_txt);
		progress = findViewById(R.id.progress);
		txt_cnting = findViewById(R.id.txt_cnting);
		linear_txts = findViewById(R.id.linear_txts);
		btnss = findViewById(R.id.btnss);
		textview = findViewById(R.id.textview);
		go_offline = findViewById(R.id.go_offline);
		retry = findViewById(R.id.retry);
		website_go_on = findViewById(R.id.website_go_on);
		net = new RequestNetwork(this);
		net_error = new AlertDialog.Builder(this);
		auth = FirebaseAuth.getInstance();
		
		go_offline.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), OfflineActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
		
		retry.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				online.setVisibility(View.VISIBLE);
				offline.setVisibility(View.GONE);
				net.startRequestNetwork(RequestNetworkController.GET, "https://sketify.tk", "nothing", _net_request_listener);
			}
		});
		
		website_go_on.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				view_web.setAction(Intent.ACTION_VIEW);
				view_web.setData(Uri.parse(website_go_on.getText().toString()));
				startActivity(view_web);
			}
		});
		
		_net_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					if (_tag.equals("nothing")) {
						intent.setClass(getApplicationContext(), HomeActivity.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(intent);
						finish();
					}
					else {
						if (_tag.equals("beta")) {
							SketchwareUtil.showMessage(getApplicationContext(), "You are Using Beta Version!");
							go.setClass(getApplicationContext(), HomeActivity.class);
							go.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
							startActivity(go);
							finish();
						}
						else {
							if (_tag.equals("update")) {
								SketchwareUtil.showMessage(getApplicationContext(), "Check For Updates 😇");
								go.setClass(getApplicationContext(), HomeActivity.class);
								go.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
								startActivity(go);
								finish();
							}
							else {
								SketchwareUtil.showMessage(getApplicationContext(), "Version Control Management Fatal Error!!");
								final AlertDialog error_dialog = new AlertDialog.Builder(SplashActivity.this).create();
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
							}
						}
					}
				}
				else {
					intent.setClass(getApplicationContext(), SignupActivity.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(intent);
					finish();
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				online.setVisibility(View.GONE);
				offline.setVisibility(View.VISIBLE);
			}
		};
		
		auth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		auth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		String versionName = "null";
		int versionCode = -1;
		
		try {
			android.content.pm.PackageInfo packageInfo = SplashActivity.this.getPackageManager().getPackageInfo(getPackageName(), 0);
			versionName = packageInfo.versionName;
			versionCode = packageInfo.versionCode;
		} catch (android.content.pm.PackageManager.NameNotFoundException e) {
			e.printStackTrace();
		}
		package_name = "com.sketify.msk";
		truee = false;
		_Moreblocks();
		net.startRequestNetwork(RequestNetworkController.GET, "https://google.com", "nothing", _net_request_listener);
		offline.setVisibility(View.GONE);
	}
	
	public void _Elevation(final View _view, final double _number) {
		
		_view.setElevation((int)_number);
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
	
	
	public void _Moreblocks() {
		_Elevation(go_offline, 7);
		_Elevation(retry, 7);
		_rippleRoundStroke(go_offline, "#3D5AFE", "#FFFFFF", 20, 2, "#FFFFFF");
		_rippleRoundStroke(retry, "#3D5AFE", "#FFFFFF", 20, 2, "#FFFFFF");
		_changeActivityFont("calculator");
	}
	
	
	public void _changeActivityFont(final String _fontname) {
		fontName = "fonts/".concat(_fontname.concat(".ttf"));
		overrideFonts(this,getWindow().getDecorView()); 
	} 
	private void overrideFonts(final android.content.Context context, final View v) {
		
		try {
			Typeface 
			typeace = Typeface.createFromAsset(getAssets(), fontName);;
			if ((v instanceof ViewGroup)) {
				ViewGroup vg = (ViewGroup) v;
				for (int i = 0;
				i < vg.getChildCount();
				i++) {
					View child = vg.getChildAt(i);
					overrideFonts(context, child);
				}
			}
			else {
				if ((v instanceof TextView)) {
					((TextView) v).setTypeface(typeace);
				}
				else {
					if ((v instanceof EditText )) {
						((EditText) v).setTypeface(typeace);
					}
					else {
						if ((v instanceof Button)) {
							((Button) v).setTypeface(typeace);
						}
					}
				}
			}
		}
		catch(Exception e)
		
		{
			SketchwareUtil.showMessage(getApplicationContext(), "Error Loading Font");
		};
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