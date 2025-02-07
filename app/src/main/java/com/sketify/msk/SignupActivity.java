package com.sketify.msk;

import android.animation.*;
import android.animation.ObjectAnimator;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Vibrator;
import android.text.*;
import android.text.Editable;
import android.text.TextWatcher;
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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
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
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class SignupActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> usermap = new HashMap<>();
	private String fontName = "";
	private String typeace = "";
	private String bgc = "";
	private String tc = "";
	private boolean verified = false;
	private double n = 0;
	private String email = "";
	private String reset_Email = "";
	private boolean userName = false;
	
	private ArrayList<HashMap<String, Object>> listColor = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> emails = new ArrayList<>();
	
	private LinearLayout linear1;
	private ScrollView vscroll1;
	private LinearLayout linear2;
	private LinearLayout sketify;
	private LinearLayout linear5;
	private LinearLayout linear3;
	private ImageView imageview1;
	private LinearLayout log_in_layout;
	private LinearLayout sign_up_layout;
	private LinearLayout encrypter_value;
	private LinearLayout encrypter_key;
	private CheckBox checkbox1;
	private Button button1;
	private ProgressBar progressbar1;
	private LinearLayout linear4;
	private ImageView value_img;
	private EditText edittext1;
	private ImageView key_img_2;
	private EditText edittext2;
	private ImageView imageview9;
	private TextView textview5;
	private TextView textview6;
	private LinearLayout linear9;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private LinearLayout linear11;
	private Button button2;
	private ProgressBar progressbar2;
	private LinearLayout linear10;
	private ImageView imageview6;
	private EditText edittext5;
	private ImageView imageview4;
	private EditText edittext3;
	private ImageView imageview5;
	private EditText edittext4;
	private ImageView imageview8;
	private EditText edittext6;
	private TextView textview12;
	private TextView textview13;
	private TextView textview7;
	private TextView textview8;
	private TextView textview9;
	
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
	
	private SharedPreferences preference;
	private Intent go = new Intent();
	private SharedPreferences u;
	private Intent intent = new Intent();
	private DatabaseReference users = _firebase.getReference("users");
	private ChildEventListener _users_child_listener;
	private TimerTask timer;
	private Intent ema = new Intent();
	private Intent terms = new Intent();
	private Intent policy = new Intent();
	private Intent pr = new Intent();
	private ObjectAnimator oa_d = new ObjectAnimator();
	private Vibrator v;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.signup);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		vscroll1 = findViewById(R.id.vscroll1);
		linear2 = findViewById(R.id.linear2);
		sketify = findViewById(R.id.sketify);
		linear5 = findViewById(R.id.linear5);
		linear3 = findViewById(R.id.linear3);
		imageview1 = findViewById(R.id.imageview1);
		log_in_layout = findViewById(R.id.log_in_layout);
		sign_up_layout = findViewById(R.id.sign_up_layout);
		encrypter_value = findViewById(R.id.encrypter_value);
		encrypter_key = findViewById(R.id.encrypter_key);
		checkbox1 = findViewById(R.id.checkbox1);
		button1 = findViewById(R.id.button1);
		progressbar1 = findViewById(R.id.progressbar1);
		linear4 = findViewById(R.id.linear4);
		value_img = findViewById(R.id.value_img);
		edittext1 = findViewById(R.id.edittext1);
		key_img_2 = findViewById(R.id.key_img_2);
		edittext2 = findViewById(R.id.edittext2);
		imageview9 = findViewById(R.id.imageview9);
		textview5 = findViewById(R.id.textview5);
		textview6 = findViewById(R.id.textview6);
		linear9 = findViewById(R.id.linear9);
		linear7 = findViewById(R.id.linear7);
		linear8 = findViewById(R.id.linear8);
		linear11 = findViewById(R.id.linear11);
		button2 = findViewById(R.id.button2);
		progressbar2 = findViewById(R.id.progressbar2);
		linear10 = findViewById(R.id.linear10);
		imageview6 = findViewById(R.id.imageview6);
		edittext5 = findViewById(R.id.edittext5);
		imageview4 = findViewById(R.id.imageview4);
		edittext3 = findViewById(R.id.edittext3);
		imageview5 = findViewById(R.id.imageview5);
		edittext4 = findViewById(R.id.edittext4);
		imageview8 = findViewById(R.id.imageview8);
		edittext6 = findViewById(R.id.edittext6);
		textview12 = findViewById(R.id.textview12);
		textview13 = findViewById(R.id.textview13);
		textview7 = findViewById(R.id.textview7);
		textview8 = findViewById(R.id.textview8);
		textview9 = findViewById(R.id.textview9);
		auth = FirebaseAuth.getInstance();
		preference = getSharedPreferences("preference", Activity.MODE_PRIVATE);
		u = getSharedPreferences("u", Activity.MODE_PRIVATE);
		v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		
		checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				preference.edit().putString("value", "true").commit();
				if (_isChecked) {
					preference.edit().putString("value", "true").commit();
				}
				else {
					preference.edit().remove("value").commit();
					preference.edit().putString("value", "false").commit();
				}
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!edittext1.getText().toString().equals("") && !edittext2.getText().toString().equals("")) {
					final AlertDialog success_dialog = new AlertDialog.Builder(SignupActivity.this).create();
					LayoutInflater inflater = getLayoutInflater();
					
					View convertView = (View) inflater.inflate(R.layout.info, null);
					success_dialog.setView(convertView);
					
					success_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);  success_dialog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
					
					LinearLayout s_bg = (LinearLayout) convertView.findViewById(R.id.linear_bg);
					
					LinearLayout s_div = (LinearLayout) convertView.findViewById(R.id.linear_div);
					
					Button s_ok = (Button) convertView.findViewById(R.id.okay_button);
					
					Button s_cancel = (Button) convertView.findViewById(R.id.cancel_button);
					
					ImageView s_header = (ImageView) convertView.findViewById(R.id.img_header);
					
					TextView s_title = (TextView) convertView.findViewById(R.id.txt_title);
					
					TextView s_msg = (TextView) convertView.findViewById(R.id.txt_msg);
					
					_setBgCorners(s_bg, 8, "#FFFFFF");
					_setBgCorners(s_ok, 8, "#304FFE");
					_setBgCorners(s_cancel, 8, "#304FFE");
					s_header.setElevation(5);
					s_cancel.setVisibility(View.VISIBLE);
					s_div.setVisibility(View.VISIBLE);
					
					
					s_msg.setText("Are You Sure You Agree To Our Agreement?.");
					
					s_title.setText("Agreement");
					s_cancel.setText("LEARN MORE");
					s_ok.setText("AGREE");
					s_ok.setOnClickListener(new View.OnClickListener(){
						    public void onClick(View v){
							success_dialog.dismiss();
							if (edittext1.getText().toString().trim().equals("")) {
								edittext1.setError("Please Enter Email");
								_createSnackBar("Please enter email");
							}
							else {
								if (edittext2.getText().toString().equals("")) {
									_createSnackBar("Please enter password");
									edittext2.setError("Please Enter Password");
								}
								else {
									auth.signInWithEmailAndPassword(edittext1.getText().toString().trim(), edittext2.getText().toString()).addOnCompleteListener(SignupActivity.this, _auth_sign_in_listener);
									button1.setVisibility(View.GONE);
									progressbar1.setVisibility(View.VISIBLE);
								}
							}
						}});
					s_cancel.setOnClickListener(new View.OnClickListener(){
						    public void onClick(View v){
							success_dialog.dismiss();
							
							textview8.performClick();
						}});
					success_dialog.show();
					_bounce(s_header);
				}
			}
		});
		
		imageview9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final AlertDialog success_dialog = new AlertDialog.Builder(SignupActivity.this).create();
				LayoutInflater inflater = getLayoutInflater();
				
				View convertView = (View) inflater.inflate(R.layout.pass_reset, null);
				success_dialog.setView(convertView);
				
				success_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);  success_dialog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
				
				LinearLayout s_bg = (LinearLayout) convertView.findViewById(R.id.linear_bg);
				
				LinearLayout s_div = (LinearLayout) convertView.findViewById(R.id.linear_div);
				
				LinearLayout edittext_l = (LinearLayout)
				convertView.findViewById(R.id.linear_edittext_bg);
				
				Button s_ok = (Button) convertView.findViewById(R.id.okay_button);
				
				Button s_cancel = (Button) convertView.findViewById(R.id.cancel_button);
				
				ImageView s_header = (ImageView) convertView.findViewById(R.id.img_header);
				
				TextView s_title = (TextView) convertView.findViewById(R.id.txt_title);
				
				TextView s_msg = (TextView) convertView.findViewById(R.id.txt_msg);
				
				_setBgCorners(s_bg, 8, "#FFFFFF");
				_setBgCorners(s_ok, 8, "#304FFE");
				_setBgCorners(s_cancel, 8, "#304FFE");
				s_header.setElevation(5);
				final EditText reset_email = new EditText(SignupActivity.this);
				reset_email.setHint("Username/Email");
				reset_email.setSingleLine(true);
				reset_email.setTextSize((float)16);
				reset_email.setTextColor(Color.parseColor("#000000"));
				reset_email.setBackgroundColor(Color.parseColor("#EEEEEE"));
				
				LinearLayout.LayoutParams linear = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
				
				reset_email.setLayoutParams(linear);
				
				reset_email.setText(edittext1.getText().toString());
				
				edittext_l.addView(reset_email);
				
				s_cancel.setVisibility(View.VISIBLE);
				s_div.setVisibility(View.VISIBLE);
				
				
				s_ok.setOnClickListener(new View.OnClickListener(){
					    public void onClick(View v){
						success_dialog.dismiss();
						_ProgresbarShow("Checking...");
						reset_Email = reset_email.getText().toString();
						if (!reset_Email.equals("")) {
							if (reset_Email.contains(".") && reset_Email.contains(" @".trim())) {
								userName = false;
								auth.sendPasswordResetEmail(reset_Email).addOnCompleteListener(_auth_reset_password_listener);
							}
							else {
								n = 0;
								for(int _repeat26 = 0; _repeat26 < (int)(emails.size()); _repeat26++) {
									if (emails.size() == n) {
										_ProgresbarDimiss();
										SketchwareUtil.showMessage(getApplicationContext(), "Not Found!");
									}
									else {
										if (emails.get((int)n).containsKey(reset_Email)) {
											email = emails.get((int)n).get(reset_Email).toString();
											userName = true;
											auth.sendPasswordResetEmail(emails.get((int)n).get(reset_Email).toString()).addOnCompleteListener(_auth_reset_password_listener);
										}
										n++;
									}
								}
							}
						}
						else {
							_ProgresbarDimiss();
						}
					}});
				s_cancel.setOnClickListener(new View.OnClickListener(){
					    public void onClick(View v){
						success_dialog.dismiss();
					}});
				success_dialog.show();
				_bounce(s_header);
			}
		});
		
		textview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				log_in_layout.setVisibility(View.GONE);
				sign_up_layout.setVisibility(View.VISIBLE);
				edittext3.setText(edittext1.getText().toString());
				edittext4.setText(edittext2.getText().toString());
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!edittext5.getText().toString().equals("") && (!edittext3.getText().toString().equals("") && (!edittext4.getText().toString().equals("") && !edittext6.getText().toString().equals("")))) {
					final AlertDialog success_dialog = new AlertDialog.Builder(SignupActivity.this).create();
					LayoutInflater inflater = getLayoutInflater();
					
					View convertView = (View) inflater.inflate(R.layout.info, null);
					success_dialog.setView(convertView);
					
					success_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);  success_dialog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
					
					LinearLayout s_bg = (LinearLayout) convertView.findViewById(R.id.linear_bg);
					
					LinearLayout s_div = (LinearLayout) convertView.findViewById(R.id.linear_div);
					
					Button s_ok = (Button) convertView.findViewById(R.id.okay_button);
					
					Button s_cancel = (Button) convertView.findViewById(R.id.cancel_button);
					
					ImageView s_header = (ImageView) convertView.findViewById(R.id.img_header);
					
					TextView s_title = (TextView) convertView.findViewById(R.id.txt_title);
					
					TextView s_msg = (TextView) convertView.findViewById(R.id.txt_msg);
					
					_setBgCorners(s_bg, 8, "#FFFFFF");
					_setBgCorners(s_ok, 8, "#304FFE");
					_setBgCorners(s_cancel, 8, "#304FFE");
					s_header.setElevation(5);
					s_cancel.setVisibility(View.VISIBLE);
					s_div.setVisibility(View.VISIBLE);
					
					
					s_msg.setText("Are You Sure You Agree To Our Agreements.?");
					s_title.setText("Agreement");
					s_cancel.setText("LEARN MORE");
					s_ok.setText("AGREE");
					s_ok.setOnClickListener(new View.OnClickListener(){
						    public void onClick(View v){
							success_dialog.dismiss();
							if (edittext5.getText().toString().contains(".") || (edittext5.getText().toString().contains("$") || (edittext5.getText().toString().contains("&") || (edittext5.getText().toString().contains("(") || (edittext5.getText().toString().contains("*") || (edittext5.getText().toString().contains(")") || (edittext5.getText().toString().contains("£") || (edittext5.getText().toString().contains("€") || (edittext5.getText().toString().contains("₩") || (edittext5.getText().toString().contains("₹") || (edittext5.getText().toString().contains("=") || (edittext5.getText().toString().contains("÷") || (edittext5.getText().toString().contains("×") || (edittext5.getText().toString().contains("+") || (edittext5.getText().toString().contains("'") || (edittext5.getText().toString().contains("\"") || (edittext5.getText().toString().contains("?") || (edittext5.getText().toString().contains(":") || (edittext5.getText().toString().contains(";") || (edittext5.getText().toString().contains("☆") || (edittext5.getText().toString().contains("`") || (edittext5.getText().toString().contains("\\") || (edittext5.getText().toString().contains("<") || (edittext5.getText().toString().contains(">") || (edittext5.getText().toString().contains("°") || (edittext5.getText().toString().contains("•") || (edittext5.getText().toString().contains("○") || (edittext5.getText().toString().contains("●") || (edittext5.getText().toString().contains("□") || (edittext5.getText().toString().contains("■") || (edittext5.getText().toString().contains("♤") || (edittext5.getText().toString().contains("♡") || (edittext5.getText().toString().contains("◇") || (edittext5.getText().toString().contains("♧") || (edittext5.getText().toString().contains("☆") || (edittext5.getText().toString().contains("▪︎") || (edittext5.getText().toString().contains("¤") || (edittext5.getText().toString().contains("《") || (edittext5.getText().toString().contains("》") || (edittext5.getText().toString().contains("¡") || (edittext5.getText().toString().contains("¿") || (edittext5.getText().toString().contains("^") || (edittext5.getText().toString().contains("?") || (edittext5.getText().toString().contains(",") || (edittext5.getText().toString().contains(" ") || (edittext5.getText().toString().contains("*") || edittext5.getText().toString().contains(" @".trim()))))))))))))))))))))))))))))))))))))))))))))))) {
								edittext5.setError("Username Only Contains Letters or Numbers");
							}
							else {
								if (edittext5.getText().toString().equals("")) {
									_createSnackBar("Please username");
									edittext5.setError("Enter Username");
								}
								else {
									if (edittext3.getText().toString().trim().equals("")) {
										_createSnackBar("Please enter email");
										edittext6.setError("Enter Email");
									}
									else {
										if (edittext4.getText().toString().equals("")) {
											_createSnackBar("Please enter password");
											edittext6.setError("Secure Your Account With Password");
										}
										else {
											if (edittext4.getText().toString().equals(edittext6.getText().toString())) {
												auth.createUserWithEmailAndPassword(edittext3.getText().toString().trim(), edittext4.getText().toString()).addOnCompleteListener(SignupActivity.this, _auth_create_user_listener);
												button2.setVisibility(View.GONE);
												progressbar2.setVisibility(View.VISIBLE);
											}
											else {
												_createSnackBar("Password Doesn't Match");
												edittext6.setError("Didn't Match");
											}
										}
									}
								}
							}
						}});
					s_cancel.setOnClickListener(new View.OnClickListener(){
						    public void onClick(View v){
							success_dialog.dismiss();
							
							textview8.performClick();
						}});
					success_dialog.show();
					_bounce(s_header);
				}
			}
		});
		
		edittext4.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (edittext4.getText().toString().equals(edittext6.getText().toString())) {
					edittext6.setTextColor(0xFF8BC34A);
				}
				else {
					edittext6.setTextColor(0xFFF44336);
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		edittext6.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (_charSeq.equals("")) {
					edittext6.setTextColor(0xFF000000);
				}
				else {
					if (edittext4.getText().toString().equals(_charSeq)) {
						edittext6.setTextColor(0xFF8BC34A);
					}
					else {
						edittext6.setTextColor(0xFFF44336);
					}
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		textview13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext1.setText(edittext3.getText().toString());
				edittext2.setText(edittext6.getText().toString());
				sign_up_layout.setVisibility(View.GONE);
				log_in_layout.setVisibility(View.VISIBLE);
			}
		});
		
		textview7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ema.setAction(Intent.ACTION_VIEW);
				ema.setData(Uri.parse("mailto:sketifyofficial@gmail.com"));
				ema.putExtra("subject", "Reply (or) Mesaage From Sketify User.");
				startActivity(ema);
			}
		});
		
		textview8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				terms.setClass(getApplicationContext(), WebActivity.class);
				terms.putExtra("url", "https://kasimobiles.online/terms");
				startActivity(terms);
			}
		});
		
		textview9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				policy.setClass(getApplicationContext(), WebActivity.class);
				policy.putExtra("url", "https://kasimobiles.online/privacy-policy");
				startActivity(policy);
			}
		});
		
		_users_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("name") && _childValue.containsKey("email")) {
					if (!_childValue.get("email").toString().equals("") && !_childValue.get("name").toString().equals("")) {
						{
							HashMap<String, Object> _item = new HashMap<>();
							_item.put(_childValue.get("name").toString(), _childValue.get("email").toString());
							emails.add(_item);
						}
						
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
		users.addChildEventListener(_users_child_listener);
		
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
				button2.setVisibility(View.VISIBLE);
				progressbar2.setVisibility(View.GONE);
				if (_success) {
					usermap = new HashMap<>();
					usermap.put("name", edittext5.getText().toString());
					usermap.put("email", edittext3.getText().toString().trim());
					usermap.put("pass", edittext4.getText().toString());
					usermap.put("profile", "avator");
					usermap.put("bgc", bgc);
					usermap.put("tc", tc);
					usermap.put("role", "developer");
					usermap.put("downloads", "0");
					usermap.put("likes", "0");
					usermap.put("projects", "0");
					usermap.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
					usermap.put("status", "running");
					users.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(usermap);
					usermap.clear();
					timer = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									// Send Verification Link
									
									auth.getCurrentUser().sendEmailVerification() .addOnCompleteListener(new OnCompleteListener<Void>() {
										@Override
										public void onComplete(Task<Void> task) {
											if (task.isSuccessful()) {
												
												
												SketchwareUtil.showMessage(getApplicationContext(), "Verification Link Has Been Sent To Your Inbox!");
												// Success Dialog For Email Link Sent.
												
												final AlertDialog success = new AlertDialog.Builder(SignupActivity.this).create();
												LayoutInflater inflater = getLayoutInflater();
												
												View convertView = (View) inflater.inflate(R.layout.success, null);
												success.setView(convertView);
												
												success.requestWindowFeature(Window.FEATURE_NO_TITLE);  success.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
												
												success.setCancelable(false);
												
												LinearLayout s_bg = (LinearLayout) convertView.findViewById(R.id.linear_bg);
												
												LinearLayout s_div = (LinearLayout) convertView.findViewById(R.id.linear_div);
												
												Button s_ok = (Button) convertView.findViewById(R.id.okay_button);
												
												Button s_cancel = (Button) convertView.findViewById(R.id.cancel_button);
												
												ImageView s_header = (ImageView) convertView.findViewById(R.id.img_header);
												
												TextView s_title = (TextView) convertView.findViewById(R.id.txt_title);
												
												TextView s_msg = (TextView) convertView.findViewById(R.id.txt_msg);
												
												_setBgCorners(s_bg, 8, "#FFFFFF");
												_setBgCorners(s_ok, 8, "#70C241");
												_setBgCorners(s_cancel, 8, "#9CD57C");
												s_header.setElevation(5);
												s_cancel.setVisibility(View.GONE);
												s_div.setVisibility(View.GONE);
												
												s_msg.setText("Verification Link Has Been Sent To Your Email, Please Click The Link & Verify your Email To Continue Log In. See also in Spam");
												s_ok.setOnClickListener(new View.OnClickListener(){
													    public void onClick(View v){
														success.dismiss();
														log_in_layout.setVisibility(View.VISIBLE);
														sign_up_layout.setVisibility(View.GONE);
														edittext1.setText(edittext3.getText().toString());
														edittext2.setText(edittext6.getText().toString());
														FirebaseAuth.getInstance().signOut();
													}});
												s_cancel.setOnClickListener(new View.OnClickListener(){
													    public void onClick(View v){
														success.dismiss();
														FirebaseAuth.getInstance().signOut();
													}});
												success.show();
												_bounce(s_header);
											} else {
												// Error Happens
												
												final AlertDialog error_dialog = new AlertDialog.Builder(SignupActivity.this).create();
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
										} });
								}
							});
						}
					};
					_timer.schedule(timer, (int)(500));
				}
				else {
					
					// Create Dialog Error
					                          
					final AlertDialog error_dialog = new AlertDialog.Builder(SignupActivity.this).create();
					
					// Get Layout
					                                 
					LayoutInflater inflater = getLayoutInflater();
					View convertView = (View) inflater.inflate(R.layout.error_dialog, null);
					error_dialog.setView(convertView);
					
					// Request No Title, Btns.
					                                                  
					error_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);  error_dialog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
					
					
					// Get Layouts
					                                        
					LinearLayout e_bg = (LinearLayout) convertView.findViewById(R.id.linear_bg);
					
					LinearLayout e_div = (LinearLayout) convertView.findViewById(R.id.linear_div);
					// Get Image in (e_header)           
					       
					ImageView e_header = (ImageView) convertView.findViewById(R.id.img_header);
					// Get Textviews
					                                    
					TextView e_title = (TextView) convertView.findViewById(R.id.txt_title);
					
					TextView e_msg = (TextView) convertView.findViewById(R.id.txt_msg);
					// Get Buttons
					                                        
					Button e_ok = (Button) convertView.findViewById(R.id.okay_button);
					
					Button e_cancel = (Button) convertView.findViewById(R.id.cancel_button);
					
					// Decor
					                                                  
					_setBgCorners(e_bg, 8, "#FFFFFF");
					_setBgCorners(e_ok, 8, "#F44336");
					_setBgCorners(e_cancel, 8, "#E57373");
					e_header.setElevation(5);
					
					// If Canelable Or Not
					                            
					e_cancel.setVisibility(View.GONE);
					e_div.setVisibility(View.GONE);
					
					 // Set Title                           
					                    
					e_title.setText("Error!");
					// Set Message             
					                          
					e_msg.setText(_errorMessage);
					 // Set Okay Btn Text                              
					
					e_ok.setText("OK");
					 // Set Cancel Btn Text                          
					
					e_cancel.setText("CANCEL");
					
					             
					// Okay Btn OnClick
					                                     
					e_ok.setOnClickListener(new View.OnClickListener(){
						    public void onClick(View v){
							error_dialog.dismiss();
							
							     // Done When Ok Clicked
							
							
						}});
					     
					// Cancel Btn OnClick
					                                  
					e_cancel.setOnClickListener(new View.OnClickListener(){
						    public void onClick(View v){
							error_dialog.dismiss();
							
							      // Done When Cancel Clicked
							
							  }});         
					
					 // Show Error
					                           
					     error_dialog.show();
					
					
					  // Bounce Image Header (e_header)
					      
					_bounce(e_header);
					
				}
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				button1.setVisibility(View.VISIBLE);
				progressbar1.setVisibility(View.GONE);
				if (_success) {
					// Check Whether Verified Or Not!
					
					verified = auth.getCurrentUser().isEmailVerified();
					if (verified) {
						v.vibrate((long)(250));
						intent.setClass(getApplicationContext(), MainActivity.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						u.edit().putString("e", edittext1.getText().toString()).commit();
						u.edit().putString("n", edittext2.getText().toString()).commit();
						startActivity(intent);
						finish();
					}
					else {
						
						// Create Dialog Error
						                          
						final AlertDialog error_dialog = new AlertDialog.Builder(SignupActivity.this).create();
						
						// Get Layout
						                                 
						LayoutInflater inflater = getLayoutInflater();
						View convertView = (View) inflater.inflate(R.layout.error_dialog, null);
						error_dialog.setView(convertView);
						
						// Request No Title, Btns.
						                                                  
						error_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);  error_dialog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
						
						
						// Get Layouts
						                                        
						LinearLayout e_bg = (LinearLayout) convertView.findViewById(R.id.linear_bg);
						
						LinearLayout e_div = (LinearLayout) convertView.findViewById(R.id.linear_div);
						// Get Image in (e_header)           
						       
						ImageView e_header = (ImageView) convertView.findViewById(R.id.img_header);
						// Get Textviews
						                                    
						TextView e_title = (TextView) convertView.findViewById(R.id.txt_title);
						
						TextView e_msg = (TextView) convertView.findViewById(R.id.txt_msg);
						// Get Buttons
						                                        
						Button e_ok = (Button) convertView.findViewById(R.id.okay_button);
						
						Button e_cancel = (Button) convertView.findViewById(R.id.cancel_button);
						
						// Decor
						                                                  
						_setBgCorners(e_bg, 8, "#FFFFFF");
						_setBgCorners(e_ok, 8, "#F44336");
						_setBgCorners(e_cancel, 8, "#E57373");
						e_header.setElevation(5);
						
						/*  If Canelable Or Not
                            
e_cancel.setVisibility(View.GONE);
e_div.setVisibility(View.GONE);

*/
						
						
						
						 // Set Title                           
						                    
						e_title.setText("Error!");
						// Set Message             
						                          
						e_msg.setText("Email Is Not Verified yet!, Please Verify Email Or Click Resend To Resend Verification Email");
						 // Set Okay Btn Text                              
						
						e_ok.setText("OK");
						 // Set Cancel Btn Text                          
						
						e_cancel.setText("RESEND");
						
						             
						// Okay Btn OnClick
						                                     
						e_ok.setOnClickListener(new View.OnClickListener(){
							    public void onClick(View v){
								error_dialog.dismiss();
								FirebaseAuth.getInstance().signOut();
								
								     // Done When Ok Clicked
								
								
							}});
						     
						// Cancel Btn OnClick
						                                  
						e_cancel.setOnClickListener(new View.OnClickListener(){
							    public void onClick(View v){
								error_dialog.dismiss();
								
								      // Done When Cancel Clicked
								                                  
								// Send Verification Email
								
								auth.getCurrentUser().sendEmailVerification() .addOnCompleteListener(new OnCompleteListener<Void>() {
									@Override
									public void onComplete(Task<Void> task) {
										if (task.isSuccessful()) {
											showMessage("Verification Link has been sent to your email !"); } else {
											showMessage ("Verification Link could not be sent !");}
									} });
								//powered by ashishtechnozone
								
								FirebaseAuth.getInstance().signOut();
								
								  }});         
						
						 // Show Error
						                           
						     error_dialog.show();
						
						
						  // Bounce Image Header (e_header)
						      
						_bounce(e_header);
						
					}
				}
				else {
					
					// Create Dialog Error
					                          
					final AlertDialog error_dialog = new AlertDialog.Builder(SignupActivity.this).create();
					
					// Get Layout
					                                 
					LayoutInflater inflater = getLayoutInflater();
					View convertView = (View) inflater.inflate(R.layout.error_dialog, null);
					error_dialog.setView(convertView);
					
					// Request No Title, Btns.
					                                                  
					error_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);  error_dialog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
					
					
					// Get Layouts
					                                        
					LinearLayout e_bg = (LinearLayout) convertView.findViewById(R.id.linear_bg);
					
					LinearLayout e_div = (LinearLayout) convertView.findViewById(R.id.linear_div);
					// Get Image in (e_header)           
					       
					ImageView e_header = (ImageView) convertView.findViewById(R.id.img_header);
					// Get Textviews
					                                    
					TextView e_title = (TextView) convertView.findViewById(R.id.txt_title);
					
					TextView e_msg = (TextView) convertView.findViewById(R.id.txt_msg);
					// Get Buttons
					                                        
					Button e_ok = (Button) convertView.findViewById(R.id.okay_button);
					
					Button e_cancel = (Button) convertView.findViewById(R.id.cancel_button);
					
					// Decor
					                                                  
					_setBgCorners(e_bg, 8, "#FFFFFF");
					_setBgCorners(e_ok, 8, "#F44336");
					_setBgCorners(e_cancel, 8, "#E57373");
					e_header.setElevation(5);
					
					// If Canelable Or Not
					                            
					e_cancel.setVisibility(View.GONE);
					e_div.setVisibility(View.GONE);
					
					 // Set Title                           
					                    
					e_title.setText("Error!");
					// Set Message             
					                          
					e_msg.setText(_errorMessage);
					 // Set Okay Btn Text                              
					
					e_ok.setText("OK");
					 // Set Cancel Btn Text                          
					
					e_cancel.setText("CANCEL");
					
					             
					// Okay Btn OnClick
					                                     
					e_ok.setOnClickListener(new View.OnClickListener(){
						    public void onClick(View v){
							error_dialog.dismiss();
							
							     // Done When Ok Clicked
							
							
						}});
					     
					// Cancel Btn OnClick
					                                  
					e_cancel.setOnClickListener(new View.OnClickListener(){
						    public void onClick(View v){
							error_dialog.dismiss();
							
							      // Done When Cancel Clicked
							
							  }});         
					
					 // Show Error
					                           
					     error_dialog.show();
					
					
					  // Bounce Image Header (e_header)
					      
					_bounce(e_header);
					
				}
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				_ProgresbarDimiss();
				if (_success) {
					v.vibrate((long)(250));
					if (userName) {
						final AlertDialog success_dialog = new AlertDialog.Builder(SignupActivity.this).create();
						LayoutInflater inflater = getLayoutInflater();
						
						View convertView = (View) inflater.inflate(R.layout.success, null);
						success_dialog.setView(convertView);
						
						success_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);  success_dialog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
						
						LinearLayout s_bg = (LinearLayout) convertView.findViewById(R.id.linear_bg);
						
						LinearLayout s_div = (LinearLayout) convertView.findViewById(R.id.linear_div);
						
						Button s_ok = (Button) convertView.findViewById(R.id.okay_button);
						
						Button s_cancel = (Button) convertView.findViewById(R.id.cancel_button);
						
						ImageView s_header = (ImageView) convertView.findViewById(R.id.img_header);
						
						TextView s_title = (TextView) convertView.findViewById(R.id.txt_title);
						
						TextView s_msg = (TextView) convertView.findViewById(R.id.txt_msg);
						
						_setBgCorners(s_bg, 8, "#FFFFFF");
						_setBgCorners(s_ok, 8, "#70C241");
						_setBgCorners(s_cancel, 8, "#9CD57C");
						s_header.setElevation(5);
						s_cancel.setVisibility(View.GONE);
						s_div.setVisibility(View.GONE);
						
						
						s_msg.setText("Reset Email Was Successfully Sent To The Provided Username " + reset_Email + ".");
						s_ok.setOnClickListener(new View.OnClickListener(){
							    public void onClick(View v){
								success_dialog.dismiss();
							}});
						s_cancel.setOnClickListener(new View.OnClickListener(){
							    public void onClick(View v){
								success_dialog.dismiss();
							}});
						success_dialog.show();
						_bounce(s_header);
					}
					else {
						final AlertDialog success_dialog = new AlertDialog.Builder(SignupActivity.this).create();
						LayoutInflater inflater = getLayoutInflater();
						
						View convertView = (View) inflater.inflate(R.layout.success, null);
						success_dialog.setView(convertView);
						
						success_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);  success_dialog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
						
						LinearLayout s_bg = (LinearLayout) convertView.findViewById(R.id.linear_bg);
						
						LinearLayout s_div = (LinearLayout) convertView.findViewById(R.id.linear_div);
						
						Button s_ok = (Button) convertView.findViewById(R.id.okay_button);
						
						Button s_cancel = (Button) convertView.findViewById(R.id.cancel_button);
						
						ImageView s_header = (ImageView) convertView.findViewById(R.id.img_header);
						
						TextView s_title = (TextView) convertView.findViewById(R.id.txt_title);
						
						TextView s_msg = (TextView) convertView.findViewById(R.id.txt_msg);
						
						_setBgCorners(s_bg, 8, "#FFFFFF");
						_setBgCorners(s_ok, 8, "#70C241");
						_setBgCorners(s_cancel, 8, "#9CD57C");
						s_header.setElevation(5);
						s_cancel.setVisibility(View.GONE);
						s_div.setVisibility(View.GONE);
						
						
						s_msg.setText("Reset Email Was Successfully Sent To " + reset_Email);
						s_ok.setOnClickListener(new View.OnClickListener(){
							    public void onClick(View v){
								success_dialog.dismiss();
							}});
						s_cancel.setOnClickListener(new View.OnClickListener(){
							    public void onClick(View v){
								success_dialog.dismiss();
							}});
						success_dialog.show();
						_bounce(s_header);
					}
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Error When Sending Reset Email");
				}
			}
		};
	}
	
	private void initializeLogic() {
		if (androidx.core.content.ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) == android.content.pm.PackageManager.PERMISSION_DENIED || androidx.core.content.ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == android.content.pm.PackageManager.PERMISSION_DENIED) {
			
			
			pr.setClass(getApplicationContext(), PermissionActivity.class);
			pr.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(pr);
			finish();
			
		} else {
			//permission is already granted, go away
			if (preference.getString("value", "").equals("true")) {
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					// Check Whether Verified Or Not!
					
					verified = auth.getCurrentUser().isEmailVerified();
					if (verified) {
						intent.setClass(getApplicationContext(), SplashActivity.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						u.edit().putString("e", edittext1.getText().toString()).commit();
						u.edit().putString("n", edittext2.getText().toString()).commit();
						startActivity(intent);
						finish();
					}
					else {
						
						// Create Dialog Error
						                          
						final AlertDialog error_dialog = new AlertDialog.Builder(SignupActivity.this).create();
						
						// Get Layout
						                                 
						LayoutInflater inflater = getLayoutInflater();
						View convertView = (View) inflater.inflate(R.layout.error_dialog, null);
						error_dialog.setView(convertView);
						
						// Request No Title, Btns.
						                                                  
						error_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);  error_dialog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
						
						
						// Get Layouts
						                                        
						LinearLayout e_bg = (LinearLayout) convertView.findViewById(R.id.linear_bg);
						
						LinearLayout e_div = (LinearLayout) convertView.findViewById(R.id.linear_div);
						// Get Image in (e_header)           
						       
						ImageView e_header = (ImageView) convertView.findViewById(R.id.img_header);
						// Get Textviews
						                                    
						TextView e_title = (TextView) convertView.findViewById(R.id.txt_title);
						
						TextView e_msg = (TextView) convertView.findViewById(R.id.txt_msg);
						// Get Buttons
						                                        
						Button e_ok = (Button) convertView.findViewById(R.id.okay_button);
						
						Button e_cancel = (Button) convertView.findViewById(R.id.cancel_button);
						
						// Decor
						                                                  
						_setBgCorners(e_bg, 8, "#FFFFFF");
						_setBgCorners(e_ok, 8, "#F44336");
						_setBgCorners(e_cancel, 8, "#E57373");
						e_header.setElevation(5);
						
						/*  If Canelable Or Not
                            
e_cancel.setVisibility(View.GONE);
e_div.setVisibility(View.GONE);

*/
						
						
						
						 // Set Title                           
						                    
						e_title.setText("Error!");
						// Set Message             
						                          
						e_msg.setText("Email Is Not Verified yet!, Please Verify Email Or Click Resend To Resend Verification Email");
						 // Set Okay Btn Text                              
						
						e_ok.setText("OK");
						 // Set Cancel Btn Text                          
						
						e_cancel.setText("RESEND");
						
						             
						// Okay Btn OnClick
						                                     
						e_ok.setOnClickListener(new View.OnClickListener(){
							    public void onClick(View v){
								error_dialog.dismiss();
								FirebaseAuth.getInstance().signOut();
								
								     // Done When Ok Clicked
								
								
							}});
						     
						// Cancel Btn OnClick
						                                  
						e_cancel.setOnClickListener(new View.OnClickListener(){
							    public void onClick(View v){
								error_dialog.dismiss();
								
								      // Done When Cancel Clicked
								                                  
								// Send Verification Email
								
								auth.getCurrentUser().sendEmailVerification() .addOnCompleteListener(new OnCompleteListener<Void>() {
									@Override
									public void onComplete(Task<Void> task) {
										if (task.isSuccessful()) {
											showMessage("Verification Link has been sent to your email !"); } else {
											showMessage ("Verification Link could not be sent !");}
									} });
								//powered by ashishtechnozone
								
								FirebaseAuth.getInstance().signOut();
								
								  }});         
						
						 // Show Error
						                           
						     error_dialog.show();
						
						
						  // Bounce Image Header (e_header)
						      
						_bounce(e_header);
						
					}
				}
				else {
					log_in_layout.setVisibility(View.VISIBLE);
					sign_up_layout.setVisibility(View.GONE);
				}
			}
			else {
				log_in_layout.setVisibility(View.GONE);
				sign_up_layout.setVisibility(View.VISIBLE);
			}
			_Create_Sharp(encrypter_key, 30, "#FFFFFF");
			_Create_Sharp(encrypter_value, 30, "#FFFFFF");
			_Create_Sharp(linear9, 30, "#FFFFFF");
			_Create_Sharp(linear8, 30, "#FFFFFF");
			_Create_Sharp(linear7, 30, "#FFFFFF");
			_Create_Sharp(linear11, 30, "#FFFFFF");
			_Elevation(encrypter_value, 7);
			_Elevation(encrypter_key, 7);
			_Elevation(linear9, 7);
			_Elevation(linear7, 7);
			_Elevation(linear8, 7);
			_Elevation(linear11, 7);
			_changeActivityFont("calculator");
			_SX_CornerRadius_card(button1, "#3F51B5", 30);
			_SX_CornerRadius_card(button2, "#3F51B5", 30);
			_SX_CornerRadius_card(edittext1, "#FFFFFF", 30);
			_SX_CornerRadius_card(edittext2, "#FFFFFF", 30);
			_SX_CornerRadius_card(edittext3, "#FFFFFF", 30);
			_SX_CornerRadius_card(edittext4, "#FFFFFF", 30);
			_SX_CornerRadius_card(edittext5, "#FFFFFF", 30);
			_SX_CornerRadius_card(edittext6, "#FFFFFF", 30);
			_Elevation(edittext1, 7);
			_Elevation(edittext2, 7);
			_Elevation(edittext3, 7);
			_Elevation(edittext4, 7);
			_Elevation(edittext5, 7);
			_Elevation(edittext6, 7);
			_Elevation(button1, 7);
			_Elevation(button2, 7);
			_initColors();
			bgc = listColor.get((int)SketchwareUtil.getRandom((int)(0), (int)(listColor.size() - 1))).get("b").toString();
			tc = listColor.get((int)SketchwareUtil.getRandom((int)(0), (int)(listColor.size() - 1))).get("a").toString();
		}
		vscroll1.setFillViewport(true);
		vscroll1.setVerticalScrollBarEnabled(false);
		edittext2.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
		
		edittext4.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
		progressbar1.setVisibility(View.GONE);
		progressbar2.setVisibility(View.GONE);
	}
	
	public void _Elevation(final View _view, final double _number) {
		
		_view.setElevation((int)_number);
	}
	
	
	public void _Create_Sharp(final View _view, final double _numb, final String _color) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		gd.setCornerRadius((int)_numb);
		_view.setBackground(gd);
	}
	
	
	public void _createSnackBar(final String _message) {
		_SnackBar(true, false, false, _message);
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
	
	
	public void _SX_CornerRadius_card(final View _view, final String _color, final double _value) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		gd.setCornerRadius((int)_value);
		_view.setBackground(gd);
		
		if (Build.VERSION.SDK_INT >= 21){
			_view.setElevation(5);
		}
	}
	
	
	public void _process_permission() {
		if (androidx.core.content.ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) == android.content.pm.PackageManager.PERMISSION_DENIED || androidx.core.content.ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == android.content.pm.PackageManager.PERMISSION_DENIED) {
			
			
			pr.setClass(getApplicationContext(), PermissionActivity.class);
			pr.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(pr);
			finish();
			
		} else {
			//permission is already granted, go away
		}
	}
	
	
	public void _initColors() {
		_addColor("#FFEBEE", "#F44336");
		_addColor("#FCE4EC", "#E91E63");
		_addColor("#F3E5F5", "#9C27B0");
		_addColor("#EDE7F6", "#673AB7");
		_addColor("#E8EAF6", "#3F51B5");
		_addColor("#E3F2FD", "#2196F3");
		_addColor("#E1F5FE", "#03A9F4");
		_addColor("#E0F7FA", "#00BCD4");
		_addColor("#E0F2F1", "#009688");
		_addColor("#E8F5E9", "#4CAF50");
		_addColor("#F1F8E9", "#8BC34A");
		_addColor("#F9FBE7", "#CDDC39");
		_addColor("#FFFDE7", "#FFEB3B");
		_addColor("#FFF8E1", "#FFC107");
		_addColor("#FFF3E0", "#FF9800");
		_addColor("#FBE9E7", "#FF5722");
		_addColor("#EFEBE9", "#795548");
	}
	
	
	public void _addColor(final String _a, final String _b) {
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("a", _a);
			listColor.add(_item);
		}
		
		listColor.get((int)listColor.size() - 1).put("b", _b);
	}
	
	
	public void _setBgCorners(final View _view, final double _radius, final String _color) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(); 
		gd.setColor(Color.parseColor("#" + _color.replace("#", ""))); /* color */
		gd.setCornerRadius((int)_radius); /* radius */
		gd.setStroke(1, Color.BLUE); /* stroke heigth and color */
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
	
	
	public void _SnackBar(final boolean _isLong, final boolean _isShort, final boolean _isIndefinite, final String _text) {
		// linear1 is your main or base of the UI
		if (_isLong) {
			com.google.android.material.snackbar.Snackbar.make(linear1, _text, com.google.android.material.snackbar.Snackbar.LENGTH_LONG).show();
		}
		else {
			if (_isShort) {
				com.google.android.material.snackbar.Snackbar.make(linear1, _text, com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).show();
			}
			else {
				if (_isIndefinite) {
					com.google.android.material.snackbar.Snackbar.make(linear1, _text, com.google.android.material.snackbar.Snackbar.LENGTH_INDEFINITE).show();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), _text);
				}
			}
		}
	}
	
	
	public void _Progress_Create() {
	}
	private SpannableString spannable;
	private ProgressDialog prog;
	{
	}
	
	
	public void _ProgresbarShow(final String _title) {
		prog = new ProgressDialog(SignupActivity.this);
		prog.setMax(100);
		prog.setTitle("Please wait");
		prog.setMessage(_title);
		prog.setIndeterminate(true);
		prog.setCancelable(false);
		prog.show();
	}
	
	
	public void _ProgresbarDimiss() {
		if(prog != null)
		{
			prog.dismiss();
		}
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