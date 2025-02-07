package com.sketify.msk;

import android.Manifest;
import android.animation.*;
import android.animation.ObjectAnimator;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import java.io.*;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class EditPrActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String comments_visibility = "";
	private String yt_url = "";
	private String key = "";
	private String Title = "";
	private String Description = "";
	private String whatsNew = "";
	private HashMap<String, Object> map = new HashMap<>();
	private HashMap<String, Object> data_map = new HashMap<>();
	private boolean dem_Link = false;
	private String demoLink = "";
	private boolean yturlok = false;
	private String icon_url = "";
	private String name = "";
	private String description_ = "";
	private boolean sk_project = false;
	private boolean android_studii = false;
	private boolean sk_apk = false;
	private boolean androidstudioapk = false;
	private String usr_name = "";
	private String project_key = "";
	private String whatsnew = "";
	private String shot1_url = "";
	private String shot2_url = "";
	private String comments = "";
	private double user_projects = 0;
	private HashMap<String, Object> user_Pr = new HashMap<>();
	private String up_icon = "";
	private String up_edit = "";
	private String iconset = "";
	private String shot1_path = "";
	private String shot1_name = "";
	private String shot2_path = "";
	private String shot2_name = "";
	private String apk_path = "";
	private String apk_name = "";
	private String project_patg = "";
	private String project_name = "";
	private String ic_path = "";
	private String ic_name = "";
	private String category = "";
	private double likes = 0;
	private double comments_count = 0;
	private String downloadUrl = "";
	private double downloads = 0;
	private boolean verified = false;
	private String short_url = "";
	private String editor = "";
	private HashMap<String, Object> usr_dwnds = new HashMap<>();
	private String uid = "";
	private String icon_URL = "";
	private String URL = "";
	private String shot1url = "";
	private String shot2url = "";
	private boolean sc1_pick = false;
	private boolean sc2_pick = false;
	private boolean ic_pick = false;
	private boolean ic_picked = false;
	private boolean sc1_picked = false;
	private boolean sc2_picked = false;
	private boolean sc1_true = false;
	private boolean sc2_true = false;
	private boolean ic_true = false;
	private boolean sc1_takedWork = false;
	private boolean sc2_takedWork = false;
	private boolean ic_takedWork = false;
	
	private ArrayList<String> filePath = new ArrayList<>();
	
	private LinearLayout linear_main_project;
	private LinearLayout toolbar;
	private LinearLayout upload_main;
	private ImageView imageview1;
	private TextView textview15;
	private TextView textview26;
	private ScrollView main;
	private LinearLayout linear5;
	private LinearLayout name_linear_ic;
	private LinearLayout vidtrailer_lin;
	private LinearLayout des_linear;
	private LinearLayout linear42;
	private LinearLayout whatsnew_linear;
	private LinearLayout linear51;
	private LinearLayout demo_apk;
	private LinearLayout linear40;
	private LinearLayout linear16;
	private LinearLayout linear17;
	private TextView textview31;
	private ImageView icon_;
	private LinearLayout linear50;
	private EditText title;
	private TextView textview27;
	private TextView textview3;
	private EditText yturl;
	private TextView textview30;
	private LinearLayout linear47;
	private EditText description;
	private TextView textview28;
	private TextView textview4;
	private TextView textview21;
	private TextView textview5;
	private EditText whatnew;
	private TextView textview29;
	private TextView textview36;
	private EditText demolinks;
	private TextView textview37;
	private TextView textview9;
	private Switch switch1;
	
	private DatabaseReference data1 = _firebase.getReference("data1");
	private ChildEventListener _data1_child_listener;
	private ObjectAnimator oa_d = new ObjectAnimator();
	private Calendar c = Calendar.getInstance();
	private DatabaseReference users = _firebase.getReference("users");
	private ChildEventListener _users_child_listener;
	private Intent intent = new Intent();
	private TimerTask timer;
	private Intent sc_pick = new Intent();
	private SharedPreferences file;
	private TimerTask re;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.edit_pr);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear_main_project = findViewById(R.id.linear_main_project);
		toolbar = findViewById(R.id.toolbar);
		upload_main = findViewById(R.id.upload_main);
		imageview1 = findViewById(R.id.imageview1);
		textview15 = findViewById(R.id.textview15);
		textview26 = findViewById(R.id.textview26);
		main = findViewById(R.id.main);
		linear5 = findViewById(R.id.linear5);
		name_linear_ic = findViewById(R.id.name_linear_ic);
		vidtrailer_lin = findViewById(R.id.vidtrailer_lin);
		des_linear = findViewById(R.id.des_linear);
		linear42 = findViewById(R.id.linear42);
		whatsnew_linear = findViewById(R.id.whatsnew_linear);
		linear51 = findViewById(R.id.linear51);
		demo_apk = findViewById(R.id.demo_apk);
		linear40 = findViewById(R.id.linear40);
		linear16 = findViewById(R.id.linear16);
		linear17 = findViewById(R.id.linear17);
		textview31 = findViewById(R.id.textview31);
		icon_ = findViewById(R.id.icon_);
		linear50 = findViewById(R.id.linear50);
		title = findViewById(R.id.title);
		textview27 = findViewById(R.id.textview27);
		textview3 = findViewById(R.id.textview3);
		yturl = findViewById(R.id.yturl);
		textview30 = findViewById(R.id.textview30);
		linear47 = findViewById(R.id.linear47);
		description = findViewById(R.id.description);
		textview28 = findViewById(R.id.textview28);
		textview4 = findViewById(R.id.textview4);
		textview21 = findViewById(R.id.textview21);
		textview5 = findViewById(R.id.textview5);
		whatnew = findViewById(R.id.whatnew);
		textview29 = findViewById(R.id.textview29);
		textview36 = findViewById(R.id.textview36);
		demolinks = findViewById(R.id.demolinks);
		textview37 = findViewById(R.id.textview37);
		textview9 = findViewById(R.id.textview9);
		switch1 = findViewById(R.id.switch1);
		file = getSharedPreferences("file", Activity.MODE_PRIVATE);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		textview26.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_ProgresbarShow("Uploading Project Details...");
				if (Title.equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Name Of Your Project Is Required! (Fix Errors)");
					_ProgresbarDimiss();
				}
				else {
					if (Description.equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "Description is Must (Fix Errors)!");
						_ProgresbarDimiss();
					}
					else {
						if (yturlok) {
							c = Calendar.getInstance();
							data_map = new HashMap<>();
							data_map.put("title", Title);
							data_map.put("description", Description);
							data_map.put("whatsnew", whatsNew);
							data_map.put("updated", "true");
							if (dem_Link) {
								data_map.put("demo", demoLink);
							}
							else {
								data_map.put("demo", "");
							}
							if (new SimpleDateFormat("dd").format(c.getTime()).startsWith("0")) {
								data_map.put("time", "Last Updated, ".concat(new SimpleDateFormat("EEEE").format(c.getTime()).concat("-".concat(new SimpleDateFormat("dd").format(c.getTime()).replace("0", "").concat(" - ".concat(new SimpleDateFormat("mm").format(c.getTime()).concat(", ".concat(new SimpleDateFormat("yyyy").format(c.getTime())))))))));
							}
							else {
								data_map.put("time", "Last Updated, ".concat(new SimpleDateFormat("EEEE").format(c.getTime()).concat("-".concat(new SimpleDateFormat("dd").format(c.getTime()).concat(" - ".concat(new SimpleDateFormat("mm").format(c.getTime()).concat(", ".concat(new SimpleDateFormat("yyyy").format(c.getTime())))))))));
							}
							data_map.put("yt_url", yt_url);
							data_map.put("comments_visibility", comments_visibility);
							data1.child(key).updateChildren(data_map);
							data_map.clear();
							timer = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											SketchwareUtil.showMessage(getApplicationContext(), "Project Details Saved!!");
											_ProgresbarDimiss();
											final AlertDialog success = new AlertDialog.Builder(EditPrActivity.this).create();
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
											
											s_msg.setText("Project Saved Successfully!");
											s_ok.setOnClickListener(new View.OnClickListener(){
												    public void onClick(View v){
													success.dismiss();
													finish();
													comments_visibility = "";
													Title = "";
													demoLink = "";
													yt_url = "";
													Description = "";
												}});
											s_cancel.setOnClickListener(new View.OnClickListener(){
												    public void onClick(View v){
													success.dismiss();
												}});
											success.show();
											_bounce(s_header);
										}
									});
								}
							};
							_timer.schedule(timer, (int)(999));
						}
						else {
							SketchwareUtil.showMessage(getApplicationContext(), "Check Video Trailer Url");
							_ProgresbarDimiss();
						}
					}
				}
			}
		});
		
		icon_.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		title.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (30 < _charSeq.length()) {
					Title = "";
					textview27.setTextColor(0xFFF44336);
				}
				else {
					textview27.setTextColor(0xFF000000);
					if (_charSeq.equals("")) {
						textview27.setText("0".concat("/30"));
					}
					else {
						textview27.setText(String.valueOf((long)(_charSeq.length())).concat("/30"));
						Title = _charSeq;
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
		
		yturl.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (_charSeq.equals("")) {
					yturlok = true;
					yt_url = "";
				}
				else {
					if (_charSeq.contains("http://") || _charSeq.contains("https://")) {
						if ((_charSeq.contains("http://m.youtube.com/") || _charSeq.contains("http://youtu.be/")) || (_charSeq.contains("https://m.youtube.com/") || ((_charSeq.contains("https://youtube.com/") || _charSeq.contains("http://youtu.be/")) || _charSeq.contains("https://youtu.be/")))) {
							textview30.setVisibility(View.GONE);
							yturlok = true;
							yt_url = _charSeq;
						}
						else {
							yturl.setError("Invalid Url");
							textview30.setVisibility(View.GONE);
							yturlok = false;
						}
					}
					else {
						textview30.setVisibility(View.VISIBLE);
						yturlok = false;
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
		
		description.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (2000 < _charSeq.length()) {
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", _charSeq));
					SketchwareUtil.showMessage(getApplicationContext(), "Copied Description Before Clearing!");
					description.setText("");
					Description = "";
					textview28.setTextColor(0xFFF44336);
					SketchwareUtil.showMessage(getApplicationContext(), "Only 2000 Characters Maximum");
				}
				else {
					textview28.setTextColor(0xFF000000);
					if (_charSeq.equals("")) {
						Description = "";
						textview28.setText("0".concat("/2000"));
					}
					else {
						Description = _charSeq;
						textview28.setText(String.valueOf((long)(_charSeq.length())).concat("/2000"));
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
		
		whatnew.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (200 < _charSeq.length()) {
					whatsNew = "";
					SketchwareUtil.showMessage(getApplicationContext(), "Characters Limit Reached");
					textview29.setTextColor(0xFFF44336);
				}
				else {
					textview29.setTextColor(0xFF000000);
					whatsNew = _charSeq;
					textview29.setText(String.valueOf((long)(_charSeq.length())).concat("/200"));
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		demolinks.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (_charSeq.equals("")) {
					dem_Link = false;
				}
				else {
					if (_charSeq.contains("http://") || _charSeq.contains("https://")) {
						textview37.setVisibility(View.GONE);
						demoLink = _charSeq;
						dem_Link = true;
					}
					else {
						dem_Link = false;
						textview37.setVisibility(View.VISIBLE);
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
		
		switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				comments_visibility = "false";
				if (_isChecked) {
					comments_visibility = "true";
				}
				else {
					comments_visibility = "false";
				}
			}
		});
		
		_data1_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(key)) {
					if (_childValue.containsKey("icon")) {
						Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("icon").toString())).into(icon_);
						icon_url = _childValue.get("icon").toString();
					}
					else {
						icon_url = "";
					}
					if (_childValue.containsKey("title")) {
						title.setText(_childValue.get("title").toString());
					}
					if (_childValue.containsKey("description")) {
						description.setText(_childValue.get("description").toString());
					}
					if (_childValue.containsKey("comments_visibility")) {
						comments_visibility = _childValue.get("comments_visibility").toString();
						if (_childValue.get("comments_visibility").toString().equals("true")) {
							switch1.setChecked(true);
						}
						else {
							switch1.setChecked(false);
						}
					}
					if (_childValue.containsKey("yt_url")) {
						yturl.setText(_childValue.get("yt_url").toString());
						yt_url = _childValue.get("yt_url").toString();
					}
					if (_childValue.containsKey("whatsnew")) {
						whatnew.setText(_childValue.get("whatsnew").toString());
					}
					if (_childValue.containsKey("demo")) {
						demoLink = _childValue.get("demo").toString();
						demolinks.setText(_childValue.get("demo").toString());
					}
					else {
						demoLink = "";
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
		data1.addChildEventListener(_data1_child_listener);
		
		_users_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("")) {
					if (_childValue.containsKey("name")) {
						usr_name = _childValue.get("name").toString();
					}
					if (_childValue.containsKey("projects")) {
						user_projects = Double.parseDouble(_childValue.get("projects").toString());
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
	}
	
	private void initializeLogic() {
		_Progress_Create();
		yturlok = true;
		key = getIntent().getStringExtra("key");
		textview30.setVisibility(View.GONE);
		textview37.setVisibility(View.GONE);
		_Elevation(toolbar, 20);
		_rippleRoundStroke(whatsnew_linear, "#FFFFFF", "#EEEEEE", 20, 3, "#3F51B5");
		_rippleRoundStroke(name_linear_ic, "#FFFFFF", "#EEEEEE", 20, 3, "#3F51B5");
		_rippleRoundStroke(vidtrailer_lin, "#FFFFFF", "#EEEEEE", 20, 3, "#3F51B5");
		_rippleRoundStroke(des_linear, "#FFFFFF", "#EEEEEE", 20, 3, "#3F51B5");
		_rippleRoundStroke(icon_, "#FFFFFF", "#EEEEEE", 20, 0, "#3F51B5");
		_rippleRoundStroke(demo_apk, "#FFFFFF", "#EEEEEE", 20, 3, "#3F51B5");
		_rippleRoundStroke(switch1, "#FFFFFF", "#EEEEEE", 20, 3, "#3F51B5");
		_rippleRoundStroke(imageview1, "#536DFE", "#EEEEEE", 50, 0, "#3F51B5");
		_click_effect(textview26, "#EEEEEE");
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (!file.getString("picked_path", "").equals("")) {
			filePath.add((int)(0), file.getString("picked_path", ""));
			file.edit().putString("picked_path", "").commit();
			if (ic_pick) {
				ic_path = filePath.get((int)(0));
				ic_name = Uri.parse(filePath.get((int)(0))).getLastPathSegment();
				icon_.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(filePath.get((int)(0)), 1024, 1024));
				ic_picked = true;
			}
			else {
				if (sc1_pick) {
					shot1_path = filePath.get((int)(0));
					shot1_name = Uri.parse(filePath.get((int)(0))).getLastPathSegment();
					
					sc1_picked = true;
				}
				else {
					if (sc2_pick) {
						shot2_path = filePath.get((int)(0));
						shot2_name = Uri.parse(filePath.get((int)(0))).getLastPathSegment();
						
						sc2_picked = true;
					}
					else {
						
					}
				}
			}
		}
		else {
			
		}
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
	
	
	public void _click_effect(final View _view, final String _c) {
		_view.setBackground(Drawables.getSelectableDrawableFor(Color.parseColor(_c)));
		_view.setClickable(true);
		
	}
	
	public static class Drawables {
		    public static android.graphics.drawable.Drawable getSelectableDrawableFor(int color) {
			        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
				            android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
				            stateListDrawable.addState(
				                new int[]{android.R.attr.state_pressed},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#ffffff"))
				            );
				            stateListDrawable.addState(
				                new int[]{android.R.attr.state_focused},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"))
				            );
				            stateListDrawable.addState(
				                new int[]{},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"))
				            );
				            return stateListDrawable;
				        } else {
				            android.content.res.ColorStateList pressedColor = android.content.res.ColorStateList.valueOf(color);
				            android.graphics.drawable.ColorDrawable defaultColor = new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"));
				            
				android.graphics.drawable.Drawable rippleColor = getRippleColor(color);
				            return new android.graphics.drawable.RippleDrawable(
				                pressedColor,
				                defaultColor,
				                rippleColor
				            );
				        }
			    }
		
		    private static android.graphics.drawable.Drawable getRippleColor(int color) {
			        float[] outerRadii = new float[8];
			        Arrays.fill(outerRadii, 0);
			        android.graphics.drawable.shapes.RoundRectShape r = new android.graphics.drawable.shapes.RoundRectShape(outerRadii, null, null);
			        
			android.graphics.drawable.ShapeDrawable shapeDrawable = new 
			android.graphics.drawable.ShapeDrawable(r);
			        shapeDrawable.getPaint().setColor(color);
			        return shapeDrawable;
			    }
		 
		    private static int lightenOrDarken(int color, double fraction) {
			        if (canLighten(color, fraction)) {
				            return lighten(color, fraction);
				        } else {
				            return darken(color, fraction);
				        }
			    }
		 
		    private static int lighten(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        red = lightenColor(red, fraction);
			        green = lightenColor(green, fraction);
			        blue = lightenColor(blue, fraction);
			        int alpha = Color.alpha(color);
			        return Color.argb(alpha, red, green, blue);
			    }
		 
		    private static int darken(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        red = darkenColor(red, fraction);
			        green = darkenColor(green, fraction);
			        blue = darkenColor(blue, fraction);
			        int alpha = Color.alpha(color);
			 
			        return Color.argb(alpha, red, green, blue);
			    }
		 
		    private static boolean canLighten(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        return canLightenComponent(red, fraction)
			            && canLightenComponent(green, fraction)
			            && canLightenComponent(blue, fraction);
			    }
		 
		    private static boolean canLightenComponent(int colorComponent, double fraction) {
			        int red = Color.red(colorComponent);
			        int green = Color.green(colorComponent);
			        int blue = Color.blue(colorComponent);
			        return red + (red * fraction) < 255
			            && green + (green * fraction) < 255
			            && blue + (blue * fraction) < 255;
			    }
		 
		    private static int darkenColor(int color, double fraction) {
			        return (int) Math.max(color - (color * fraction), 0);
			    }
		 
		    private static int lightenColor(int color, double fraction) {
			        return (int) Math.min(color + (color * fraction), 255);
			    }
	}
	public static class CircleDrawables {
		    public static android.graphics.drawable.Drawable getSelectableDrawableFor(int color) {
			        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
				            android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
				            stateListDrawable.addState(
				                new int[]{android.R.attr.state_pressed},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#ffffff"))
				            );
				            stateListDrawable.addState(
				                new int[]{android.R.attr.state_focused},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"))
				            );
				            stateListDrawable.addState(
				                new int[]{},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"))
				            );
				            return stateListDrawable;
				        } else {
				            android.content.res.ColorStateList pressedColor = android.content.res.ColorStateList.valueOf(color);
				            android.graphics.drawable.ColorDrawable defaultColor = new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"));
				            
				android.graphics.drawable.Drawable rippleColor = getRippleColor(color);
				            return new android.graphics.drawable.RippleDrawable(
				                pressedColor,
				                defaultColor,
				                rippleColor
				            );
				        }
			    }
		
		    private static android.graphics.drawable.Drawable getRippleColor(int color) {
			        float[] outerRadii = new float[180];
			        Arrays.fill(outerRadii, 80);
			        android.graphics.drawable.shapes.RoundRectShape r = new android.graphics.drawable.shapes.RoundRectShape(outerRadii, null, null);
			        
			android.graphics.drawable.ShapeDrawable shapeDrawable = new 
			android.graphics.drawable.ShapeDrawable(r);
			        shapeDrawable.getPaint().setColor(color);
			        return shapeDrawable;
			    }
		 
		    private static int lightenOrDarken(int color, double fraction) {
			        if (canLighten(color, fraction)) {
				            return lighten(color, fraction);
				        } else {
				            return darken(color, fraction);
				        }
			    }
		 
		    private static int lighten(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        red = lightenColor(red, fraction);
			        green = lightenColor(green, fraction);
			        blue = lightenColor(blue, fraction);
			        int alpha = Color.alpha(color);
			        return Color.argb(alpha, red, green, blue);
			    }
		 
		    private static int darken(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        red = darkenColor(red, fraction);
			        green = darkenColor(green, fraction);
			        blue = darkenColor(blue, fraction);
			        int alpha = Color.alpha(color);
			 
			        return Color.argb(alpha, red, green, blue);
			    }
		 
		    private static boolean canLighten(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        return canLightenComponent(red, fraction)
			            && canLightenComponent(green, fraction)
			            && canLightenComponent(blue, fraction);
			    }
		 
		    private static boolean canLightenComponent(int colorComponent, double fraction) {
			        int red = Color.red(colorComponent);
			        int green = Color.green(colorComponent);
			        int blue = Color.blue(colorComponent);
			        return red + (red * fraction) < 255
			            && green + (green * fraction) < 255
			            && blue + (blue * fraction) < 255;
			    }
		 
		    private static int darkenColor(int color, double fraction) {
			        return (int) Math.max(color - (color * fraction), 0);
			    }
		 
		    private static int lightenColor(int color, double fraction) {
			        return (int) Math.min(color + (color * fraction), 255);
		}
	}
	
	public void drawableclass() {
	}
	
	
	public void _Elevation(final View _view, final double _number) {
		
		_view.setElevation((int)_number);
	}
	
	
	public void _ProgresbarDimiss() {
		if(prog != null)
		{
			prog.dismiss();
		}
	}
	
	
	public void _ProgresbarShow(final String _title) {
		prog = new ProgressDialog(EditPrActivity.this);
		prog.setMax(100);
		prog.setTitle("Please wait");
		prog.setMessage(_title);
		prog.setIndeterminate(true);
		prog.setCancelable(false);
		prog.show();
	}
	
	
	public void _Progress_Create() {
	}
	private SpannableString spannable;
	private ProgressDialog prog;
	{
	}
	
	
	public void _bounce(final View _view) {
		oa_d.setTarget(_view);
		oa_d.setPropertyName("rotation");
		oa_d.setFloatValues((float)(90), (float)(0));
		oa_d.setDuration((int)(1000));
		oa_d.setInterpolator(new BounceInterpolator());
		oa_d.start();
	}
	
	
	public void _setBgCorners(final View _view, final double _radius, final String _color) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(); 
		gd.setColor(Color.parseColor("#" + _color.replace("#", ""))); /* color */
		gd.setCornerRadius((int)_radius); /* radius */
		gd.setStroke(1, Color.BLUE); /* stroke heigth and color */
		_view.setBackground(gd);
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