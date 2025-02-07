package com.sketify.msk;

import android.animation.*;
import android.app.*;
import android.app.AlertDialog;
import android.content.*;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Vibrator;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class PricingsActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private String url = "";
	private HashMap<String, Object> map = new HashMap<>();
	private String beginner = "";
	private String premiumUrl = "";
	private String vipUrl = "";
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	
	private LinearLayout layout_main;
	private LinearLayout load;
	private ScrollView main;
	private ProgressBar progressbar2;
	private LinearLayout linear16;
	private LinearLayout free;
	private LinearLayout premium;
	private LinearLayout vip;
	private LinearLayout linear6;
	private LinearLayout linear5;
	private LinearLayout linear7;
	private Button button2;
	private TextView heading1;
	private TextView price1;
	private TextView textview4;
	private TextView textview1;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private Button button3;
	private TextView heading2;
	private TextView price2;
	private TextView textview6;
	private TextView textview2;
	private LinearLayout linear13;
	private LinearLayout linear14;
	private LinearLayout linear15;
	private Button button4;
	private TextView heading3;
	private TextView rate3;
	private TextView textview10;
	private TextView textview3;
	
	private AlertDialog.Builder premium_d;
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
	
	private DatabaseReference admin = _firebase.getReference("admin");
	private ChildEventListener _admin_child_listener;
	private RequestNetwork internet;
	private RequestNetwork.RequestListener _internet_request_listener;
	private Intent premium_rd = new Intent();
	private Intent vip_rd = new Intent();
	private Intent e = new Intent();
	private AlertDialog.Builder vip_d;
	private Vibrator v;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.pricings);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		layout_main = findViewById(R.id.layout_main);
		load = findViewById(R.id.load);
		main = findViewById(R.id.main);
		progressbar2 = findViewById(R.id.progressbar2);
		linear16 = findViewById(R.id.linear16);
		free = findViewById(R.id.free);
		premium = findViewById(R.id.premium);
		vip = findViewById(R.id.vip);
		linear6 = findViewById(R.id.linear6);
		linear5 = findViewById(R.id.linear5);
		linear7 = findViewById(R.id.linear7);
		button2 = findViewById(R.id.button2);
		heading1 = findViewById(R.id.heading1);
		price1 = findViewById(R.id.price1);
		textview4 = findViewById(R.id.textview4);
		textview1 = findViewById(R.id.textview1);
		linear9 = findViewById(R.id.linear9);
		linear10 = findViewById(R.id.linear10);
		linear11 = findViewById(R.id.linear11);
		button3 = findViewById(R.id.button3);
		heading2 = findViewById(R.id.heading2);
		price2 = findViewById(R.id.price2);
		textview6 = findViewById(R.id.textview6);
		textview2 = findViewById(R.id.textview2);
		linear13 = findViewById(R.id.linear13);
		linear14 = findViewById(R.id.linear14);
		linear15 = findViewById(R.id.linear15);
		button4 = findViewById(R.id.button4);
		heading3 = findViewById(R.id.heading3);
		rate3 = findViewById(R.id.rate3);
		textview10 = findViewById(R.id.textview10);
		textview3 = findViewById(R.id.textview3);
		premium_d = new AlertDialog.Builder(this);
		auth = FirebaseAuth.getInstance();
		internet = new RequestNetwork(this);
		vip_d = new AlertDialog.Builder(this);
		v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				premium_d.setTitle("IMPORTANT INSTRUCTIONS");
				premium_d.setMessage("Hi, User If You want To Buy This Premium Pack Offered In Sketify You will Be Redirected To 3rd Party Site To Finish Payments,Due To Limited Coding In Sketchware, We Can't Track Your Order. So, You will need To Do Additional Steps\n\n• Make Payment of ".concat(price2.getText().toString().concat("(USD):\n• When Payment Is Successful,simple Take a Screenshot of Receipt & Send It To \"sketifyofficial@gmail.com\" from Your Email \"".concat(FirebaseAuth.getInstance().getCurrentUser().getEmail().concat("\". So, We Can Verify The Payment.\n\nAfter Payment Verfication, your Fund May Not Be Returned on Cancelling The Subscription.\n\n * TERMS & CONDITIONS ALSO APPLIES")))));
				premium_d.setPositiveButton("PROCEED", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						v.vibrate((long)(400));
						premium_rd.setAction(Intent.ACTION_VIEW);
						premium_rd.setData(Uri.parse(premiumUrl));
						startActivity(premium_rd);
					}
				});
				premium_d.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				premium_d.setNeutralButton("EMAIL NOW", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						v.vibrate((long)(400));
						e.setAction(Intent.ACTION_VIEW);
						e.setData(Uri.parse("mailto:sketifyofficial@gmail.com"));
						e.putExtra("subject", "Buyed Premium Plan");
						startActivity(e);
					}
				});
				premium_d.create().show();
			}
		});
		
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vip_d.setTitle("IMPORTANT INSTRUCTIONS");
				vip_d.setMessage("Hi, User If You want To Buy This VIP Pack Offered In Sketify You will Be Redirected To 3rd Party Site To Finish Payments,Due To Limited Coding In Sketchware, We Can't Track Your Order. So, You will need To Do Additional Steps\n\n• Make Payment of ".concat(rate3.getText().toString().concat("(USD):\n• When Payment Is Successful,simple Take a Screenshot of Receipt & Send It To \"sketifyofficial@gmail.com\" from Your Email \"".concat(FirebaseAuth.getInstance().getCurrentUser().getEmail().concat("\". So, We Can Verify The Payment.\n\nAfter Payment Verfication, your Fund May Not Be Returned on Canceling The Subscription.\n\n * TERMS & CONDITIONS ALSO APPLIES")))));
				vip_d.setPositiveButton("PROCEED", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						v.vibrate((long)(400));
						vip_rd.setAction(Intent.ACTION_VIEW);
						vip_rd.setData(Uri.parse(vipUrl));
						startActivity(vip_rd);
					}
				});
				vip_d.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				vip_d.setNeutralButton("EMAIL NOW", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						v.vibrate((long)(400));
						e.setAction(Intent.ACTION_VIEW);
						e.setData(Uri.parse("mailto:sketifyofficial@gmail.com"));
						startActivity(e);
					}
				});
				vip_d.create().show();
			}
		});
		
		_admin_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("payments")) {
					if (_childValue.containsKey("pay_url")) {
						url = _childValue.get("pay_url").toString();
					}
					if (_childValue.containsKey("vip_rate")) {
						
					}
					if (_childValue.containsKey("vip_pack")) {
						
					}
					if (_childValue.containsKey("premium_rate")) {
						
					}
					if (_childValue.containsKey("premium_pack")) {
						
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		admin.addChildEventListener(_admin_child_listener);
		
		_internet_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				listmap = new Gson().fromJson(_response, new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
				main.setVisibility(View.VISIBLE);
				load.setVisibility(View.GONE);
				heading1.setText(listmap.get((int)0).get("name").toString());
				price1.setText(listmap.get((int)0).get("amount").toString());
				textview1.setText(listmap.get((int)0).get("benefits").toString());
				heading2.setText(listmap.get((int)1).get("name").toString());
				price2.setText(listmap.get((int)1).get("amount").toString());
				textview2.setText(listmap.get((int)1).get("benefits").toString());
				heading3.setText(listmap.get((int)2).get("name").toString());
				rate3.setText(listmap.get((int)2).get("amount").toString());
				textview3.setText(listmap.get((int)2).get("benefits").toString());
				beginner = listmap.get((int)0).get("link").toString();
				premiumUrl = listmap.get((int)1).get("link").toString();
				vipUrl = listmap.get((int)2).get("link").toString();
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
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
		
		getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_white);
		setTitle("Pricing Plans");
		internet.startRequestNetwork(RequestNetworkController.GET, "https://api.sketify.tk/pricings.json", "s", _internet_request_listener);
		_Elevation(free, 12);
		_Elevation(premium, 12);
		_Elevation(vip, 12);
		_rippleRoundStroke(free, "#FFFFFF", "#EEEEEE", 20, 0, "#3F51B5");
		_rippleRoundStroke(premium, "#FFFFFF", "#EEEEEE", 20, 0, "#3F51B5");
		_rippleRoundStroke(vip, "#FFFFFF", "#EEEEEE", 20, 0, "#3F51B5");
		main.setVisibility(View.GONE);
		load.setVisibility(View.VISIBLE);
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