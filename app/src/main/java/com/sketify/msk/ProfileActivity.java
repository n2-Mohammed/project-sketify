package com.sketify.msk;

import android.Manifest;
import android.animation.*;
import android.animation.ObjectAnimator;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.gson.Gson;
import java.io.*;
import java.io.File;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class ProfileActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private FloatingActionButton _fab;
	private HashMap<String, Object> map = new HashMap<>();
	private double n = 0;
	private double user_dwnds = 0;
	private HashMap<String, Object> map2 = new HashMap<>();
	private String key = "";
	private String fontName = "";
	private String typeace = "";
	private String Name = "";
	private String picurl = "";
	private double likes = 0;
	private double projectsss = 0;
	private double pr_differ = 0;
	private HashMap<String, Object> prmap = new HashMap<>();
	private double projects_c = 0;
	private double likes_c = 0;
	private double downloads_c = 0;
	private String like_key = "";
	private double dl_differ = 0;
	private HashMap<String, Object> adminmap = new HashMap<>();
	private boolean verified = false;
	private String stringre = "";
	private double lk_differ = 0;
	private boolean paused = false;
	private double rep_ = 0;
	private boolean No_1 = false;
	private boolean No_2 = false;
	private double mdn = 0;
	private double adn = 0;
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<String> keys = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> UserProjects = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> usermap = new ArrayList<>();
	private ArrayList<String> projects = new ArrayList<>();
	private ArrayList<String> liked = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> downloads = new ArrayList<>();
	private ArrayList<String> shower = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> sjower = new ArrayList<>();
	private ArrayList<String> admins = new ArrayList<>();
	private ArrayList<String> moderators = new ArrayList<>();
	
	private LinearLayout main;
	private LinearLayout acc_banned;
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout top;
	private LinearLayout bottom;
	private LinearLayout base;
	private LinearLayout depart;
	private LinearLayout linear34;
	private LinearLayout ic_linear;
	private TextView textview_username;
	private LinearLayout linear38;
	private LinearLayout linear42;
	private ImageView imageview1;
	private LinearLayout linear43;
	private Button ban_btn;
	private HorizontalScrollView hscroll1;
	private LinearLayout linear33;
	private LinearLayout vip;
	private LinearLayout developer;
	private LinearLayout premium;
	private LinearLayout verified_linear;
	private LinearLayout admin;
	private LinearLayout moderator;
	private ImageView vip_ic;
	private TextView textview21;
	private ImageView developer_ic;
	private TextView textview20;
	private ImageView premium_ic;
	private TextView category;
	private ImageView verified_ic;
	private TextView textview22;
	private ImageView admin_ic;
	private TextView textview25;
	private ImageView moderator_ic;
	private TextView textview23;
	private LinearLayout linear35;
	private LinearLayout linear39;
	private LinearLayout linear41;
	private TextView textview26;
	private TextView textview_projects;
	private TextView textview33;
	private TextView textview34;
	private TextView textview37;
	private TextView textview38;
	private LinearLayout feed;
	private TextView textview_bio;
	private ListView listview1;
	private LinearLayout nothing;
	private ImageView imageview2;
	private TextView textview31;
	private TextView textview32;
	private LinearLayout linear59;
	private LinearLayout linear60;
	private LinearLayout linear61;
	private TextView textview61;
	private LinearLayout linear62;
	private TextView textview60;
	
	private DatabaseReference data1 = _firebase.getReference("data1");
	private ChildEventListener _data1_child_listener;
	private DatabaseReference users = _firebase.getReference("users");
	private ChildEventListener _users_child_listener;
	private StorageReference profile = _firebase_storage.getReference("profile");
	private OnCompleteListener<Uri> _profile_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _profile_download_success_listener;
	private OnSuccessListener _profile_delete_success_listener;
	private OnProgressListener _profile_upload_progress_listener;
	private OnProgressListener _profile_download_progress_listener;
	private OnFailureListener _profile_failure_listener;
	
	private FirebaseAuth aith;
	private OnCompleteListener<AuthResult> _aith_create_user_listener;
	private OnCompleteListener<AuthResult> _aith_sign_in_listener;
	private OnCompleteListener<Void> _aith_reset_password_listener;
	private OnCompleteListener<Void> aith_updateEmailListener;
	private OnCompleteListener<Void> aith_updatePasswordListener;
	private OnCompleteListener<Void> aith_emailVerificationSentListener;
	private OnCompleteListener<Void> aith_deleteUserListener;
	private OnCompleteListener<Void> aith_updateProfileListener;
	private OnCompleteListener<AuthResult> aith_phoneAuthListener;
	private OnCompleteListener<AuthResult> aith_googleSignInListener;
	
	private SharedPreferences data;
	private Intent edit = new Intent();
	private Intent go = new Intent();
	private Intent fullview = new Intent();
	private DatabaseReference admin_users = _firebase.getReference("admin");
	private ChildEventListener _admin_users_child_listener;
	private ObjectAnimator oa_d = new ObjectAnimator();
	private Intent view = new Intent();
	private TimerTask t;
	private AlertDialog.Builder showCase;
	private Intent acc_bab = new Intent();
	private TimerTask r;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.profile);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
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
		_fab = findViewById(R.id._fab);
		
		main = findViewById(R.id.main);
		acc_banned = findViewById(R.id.acc_banned);
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		top = findViewById(R.id.top);
		bottom = findViewById(R.id.bottom);
		base = findViewById(R.id.base);
		depart = findViewById(R.id.depart);
		linear34 = findViewById(R.id.linear34);
		ic_linear = findViewById(R.id.ic_linear);
		textview_username = findViewById(R.id.textview_username);
		linear38 = findViewById(R.id.linear38);
		linear42 = findViewById(R.id.linear42);
		imageview1 = findViewById(R.id.imageview1);
		linear43 = findViewById(R.id.linear43);
		ban_btn = findViewById(R.id.ban_btn);
		hscroll1 = findViewById(R.id.hscroll1);
		linear33 = findViewById(R.id.linear33);
		vip = findViewById(R.id.vip);
		developer = findViewById(R.id.developer);
		premium = findViewById(R.id.premium);
		verified_linear = findViewById(R.id.verified_linear);
		admin = findViewById(R.id.admin);
		moderator = findViewById(R.id.moderator);
		vip_ic = findViewById(R.id.vip_ic);
		textview21 = findViewById(R.id.textview21);
		developer_ic = findViewById(R.id.developer_ic);
		textview20 = findViewById(R.id.textview20);
		premium_ic = findViewById(R.id.premium_ic);
		category = findViewById(R.id.category);
		verified_ic = findViewById(R.id.verified_ic);
		textview22 = findViewById(R.id.textview22);
		admin_ic = findViewById(R.id.admin_ic);
		textview25 = findViewById(R.id.textview25);
		moderator_ic = findViewById(R.id.moderator_ic);
		textview23 = findViewById(R.id.textview23);
		linear35 = findViewById(R.id.linear35);
		linear39 = findViewById(R.id.linear39);
		linear41 = findViewById(R.id.linear41);
		textview26 = findViewById(R.id.textview26);
		textview_projects = findViewById(R.id.textview_projects);
		textview33 = findViewById(R.id.textview33);
		textview34 = findViewById(R.id.textview34);
		textview37 = findViewById(R.id.textview37);
		textview38 = findViewById(R.id.textview38);
		feed = findViewById(R.id.feed);
		textview_bio = findViewById(R.id.textview_bio);
		listview1 = findViewById(R.id.listview1);
		nothing = findViewById(R.id.nothing);
		imageview2 = findViewById(R.id.imageview2);
		textview31 = findViewById(R.id.textview31);
		textview32 = findViewById(R.id.textview32);
		linear59 = findViewById(R.id.linear59);
		linear60 = findViewById(R.id.linear60);
		linear61 = findViewById(R.id.linear61);
		textview61 = findViewById(R.id.textview61);
		linear62 = findViewById(R.id.linear62);
		textview60 = findViewById(R.id.textview60);
		aith = FirebaseAuth.getInstance();
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		showCase = new AlertDialog.Builder(this);
		
		textview_username.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (picurl.equals("")) {
					fullview.setClass(getApplicationContext(), FullviewActivity.class);
					fullview.putExtra("main", "avator");
					startActivity(fullview);
				}
				else {
					fullview.setClass(getApplicationContext(), FullviewActivity.class);
					fullview.putExtra("main", picurl);
					startActivity(fullview);
				}
			}
		});
		
		ban_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (admins.contains(FirebaseAuth.getInstance().getCurrentUser().getEmail()) && moderators.contains(FirebaseAuth.getInstance().getCurrentUser().getEmail())) {
					showCase.setTitle("Set");
					showCase.setMessage("Message");
					showCase.setPositiveButton("BAN", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							final AlertDialog success_dialog = new AlertDialog.Builder(ProfileActivity.this).create();
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
							final EditText reset_email = new EditText(ProfileActivity.this);
							reset_email.setHint("Report...");
							reset_email.setSingleLine(true);
							reset_email.setTextSize((float)16);
							reset_email.setTextColor(Color.parseColor("#000000"));
							reset_email.setBackgroundColor(Color.parseColor("#EEEEEE"));
							
							LinearLayout.LayoutParams linear = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
							
							reset_email.setLayoutParams(linear);
							
							edittext_l.addView(reset_email);
							
							s_title.setText("Ban Account");
							
							s_msg.setText("Tell a Reason to Ban this Account!");
							
							s_header.setImageResource(R.drawable.info);
							s_cancel.setVisibility(View.VISIBLE);
							s_div.setVisibility(View.VISIBLE);
							
							
							s_ok.setOnClickListener(new View.OnClickListener(){
								    public void onClick(View v){
									success_dialog.dismiss();
									
									stringre = reset_email.getText().toString();
									if (!stringre.equals("")) {
										adminmap = new HashMap<>();
										adminmap.put("status", "banned");
										adminmap.put("reported_by", FirebaseAuth.getInstance().getCurrentUser().getEmail());
										adminmap.put("report", stringre);
										users.child(key).updateChildren(adminmap);
										adminmap.clear();
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
					if (verified) {
						showCase.setNegativeButton("UNVERIFY", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								if (verified) {
									adminmap = new HashMap<>();
									adminmap.put("role", "developer");
									users.child(key).updateChildren(adminmap);
									adminmap.clear();
								}
								else {
									adminmap = new HashMap<>();
									adminmap.put("role", "verified");
									users.child(key).updateChildren(adminmap);
									adminmap.clear();
								}
							}
						});
					}
					else {
						showCase.setNegativeButton("VERIFY", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								if (verified) {
									adminmap = new HashMap<>();
									adminmap.put("role", "developer");
									users.child(key).updateChildren(adminmap);
									adminmap.clear();
								}
								else {
									adminmap = new HashMap<>();
									adminmap.put("role", "verified");
									users.child(key).updateChildren(adminmap);
									adminmap.clear();
								}
							}
						});
					}
					showCase.create().show();
				}
				else {
					if (admins.contains(FirebaseAuth.getInstance().getCurrentUser().getEmail())) {
						final AlertDialog success_dialog = new AlertDialog.Builder(ProfileActivity.this).create();
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
						final EditText reset_email = new EditText(ProfileActivity.this);
						reset_email.setHint("Report...");
						reset_email.setSingleLine(true);
						reset_email.setTextSize((float)16);
						reset_email.setTextColor(Color.parseColor("#000000"));
						reset_email.setBackgroundColor(Color.parseColor("#EEEEEE"));
						
						LinearLayout.LayoutParams linear = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
						
						reset_email.setLayoutParams(linear);
						
						edittext_l.addView(reset_email);
						s_cancel.setVisibility(View.VISIBLE);
						s_div.setVisibility(View.VISIBLE);
						
						
						s_ok.setOnClickListener(new View.OnClickListener(){
							    public void onClick(View v){
								success_dialog.dismiss();
								
								stringre = reset_email.getText().toString();
								if (!stringre.equals("")) {
									adminmap = new HashMap<>();
									adminmap.put("ban", key);
									adminmap.put("reported_by", FirebaseAuth.getInstance().getCurrentUser().getEmail());
									adminmap.put("report", stringre);
									admin_users.child("banned").updateChildren(adminmap);
									adminmap.clear();
								}
							}});
						s_cancel.setOnClickListener(new View.OnClickListener(){
							    public void onClick(View v){
								success_dialog.dismiss();
							}});
						success_dialog.show();
						_bounce(s_header);
						SketchwareUtil.showMessage(getApplicationContext(), "admin");
					}
					else {
						if (moderators.contains(FirebaseAuth.getInstance().getCurrentUser().getEmail())) {
							if (verified) {
								adminmap = new HashMap<>();
								adminmap.put("role", "developer");
								users.child(key).updateChildren(adminmap);
								adminmap.clear();
							}
							else {
								adminmap = new HashMap<>();
								adminmap.put("role", "verified");
								users.child(key).updateChildren(adminmap);
								adminmap.clear();
							}
							SketchwareUtil.showMessage(getApplicationContext(), "mod");
						}
					}
				}
			}
		});
		
		linear33.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_custom_loading(true);
			}
		});
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				go.setClass(getApplicationContext(), ProjectViewActivity.class);
				go.putExtra("key", listmap.get((int)_position).get("key").toString());
				go.putExtra("uid", listmap.get((int)_position).get("uid").toString());
				startActivity(go);
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edit.setClass(getApplicationContext(), EditActivity.class);
				edit.putExtra("key", key);
				startActivity(edit);
			}
		});
		
		_data1_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				No_1 = true;
				if (_childValue.get("uid").toString().equals(key)) {
					if (_childValue.isEmpty()) {
						nothing.setVisibility(View.VISIBLE);
						listview1.setVisibility(View.GONE);
						textview_projects.setText("0");
						textview38.setText("0");
						textview34.setText("0");
					}
					else {
						nothing.setVisibility(View.GONE);
						listview1.setVisibility(View.VISIBLE);
						listmap.add((int)0, _childValue);
						listview1.setAdapter(new Listview1Adapter(listmap));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						pr_differ++;
						if (!(pr_differ == projectsss)) {
							prmap = new HashMap<>();
							prmap.put("projects", String.valueOf((long)(pr_differ)));
							users.child(key).updateChildren(prmap);
							prmap.clear();
						}
						dl_differ = dl_differ + Double.parseDouble(_childValue.get("downloads").toString());
						if (!(dl_differ == downloads_c)) {
							prmap = new HashMap<>();
							prmap.put("downloads", String.valueOf((long)(dl_differ)));
							users.child(key).updateChildren(prmap);
							prmap.clear();
						}
						lk_differ = lk_differ + Double.parseDouble(_childValue.get("likes").toString());
						if (!(lk_differ == likes_c)) {
							prmap = new HashMap<>();
							prmap.put("likes", String.valueOf((long)(lk_differ)));
							users.child(key).updateChildren(prmap);
							prmap.clear();
						}
					}
				}
				_ViewSetHeight(listview1, listmap.size() * SketchwareUtil.getDip(getApplicationContext(), (int)(125)));
				Collections.reverse(listmap);
				listview1.setAdapter(new Listview1Adapter(listmap));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.get("uid").toString().equals(key)) {
					if (_childValue.isEmpty()) {
						nothing.setVisibility(View.VISIBLE);
						listview1.setVisibility(View.GONE);
						textview_projects.setText("0");
						textview34.setText("0");
						textview38.setText("0");
					}
					else {
						dl_differ++;
						prmap = new HashMap<>();
						prmap.put("downloads", String.valueOf((long)(downloads_c + dl_differ)));
						users.child(key).updateChildren(prmap);
						prmap.clear();
						nothing.setVisibility(View.GONE);
						listview1.setVisibility(View.VISIBLE);
						n = 0;
						for(int _repeat245 = 0; _repeat245 < (int)(listmap.size()); _repeat245++) {
							if (listmap.get((int)n).get("key").toString().equals(_childKey)) {
								listmap.remove((int)(n));
								listmap.add((int)n, _childValue);
							}
							n++;
						}
						dl_differ = dl_differ + Double.parseDouble(_childValue.get("downloads").toString());
						if (!(dl_differ == downloads_c)) {
							prmap = new HashMap<>();
							prmap.put("downloads", String.valueOf((long)(dl_differ)));
							users.child(key).updateChildren(prmap);
							prmap.clear();
						}
						lk_differ = lk_differ + Double.parseDouble(_childValue.get("likes").toString());
						if (!(lk_differ == likes_c)) {
							prmap = new HashMap<>();
							prmap.put("likes", String.valueOf((long)(lk_differ)));
							users.child(key).updateChildren(prmap);
							prmap.clear();
						}
						listview1.setAdapter(new Listview1Adapter(listmap));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						data.edit().putString("user", new Gson().toJson(listmap)).commit();
					}
				}
				_ViewSetHeight(listview1, listmap.size() * SketchwareUtil.getDip(getApplicationContext(), (int)(125)));
				Collections.reverse(listmap);
				listview1.setAdapter(new Listview1Adapter(listmap));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.get("uid").toString().equals(key)) {
					if (_childValue.isEmpty()) {
						nothing.setVisibility(View.VISIBLE);
						listview1.setVisibility(View.GONE);
						textview_projects.setText("0");
						textview34.setText("0");
						textview38.setText("0");
					}
					else {
						nothing.setVisibility(View.GONE);
						listview1.setVisibility(View.VISIBLE);
						n = 0;
						for(int _repeat198 = 0; _repeat198 < (int)(listmap.size()); _repeat198++) {
							if (listmap.get((int)n).get("key").toString().equals(_childKey)) {
								listmap.remove((int)(n));
							}
							n++;
						}
						if (_childValue.containsKey("downloads")) {
							prmap = new HashMap<>();
							prmap.put("downloads", String.valueOf((long)(downloads_c - Double.parseDouble(_childValue.get("downloads").toString()))));
							users.child(key).updateChildren(prmap);
							prmap.clear();
						}
						listview1.setAdapter(new Listview1Adapter(listmap));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						data.edit().putString("user", new Gson().toJson(listmap)).commit();
					}
				}
				_ViewSetHeight(listview1, listmap.size() * SketchwareUtil.getDip(getApplicationContext(), (int)(125)));
				Collections.reverse(listmap);
				listview1.setAdapter(new Listview1Adapter(listmap));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
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
				No_2 = true;
				if (_childKey.equals(key)) {
					if (_childValue.containsKey("status")) {
						if (!_childValue.get("status").toString().equals("banned")) {
							acc_banned.setVisibility(View.GONE);
							if (_childValue.containsKey("profile")) {
								if (!_childValue.get("profile").toString().equals("")) {
									_setCircleImageURL(imageview1, _childValue.get("profile").toString(), 3, "#3F51B5");
									picurl = _childValue.get("profile").toString();
								}
								else {
									imageview1.setImageResource(R.drawable.default_avatar);
									picurl = _childValue.get("profile").toString();
								}
							}
							else {
								imageview1.setImageResource(R.drawable.default_avatar);
								picurl = _childValue.get("profile").toString();
							}
							if (_childValue.containsKey("name")) {
								Name = _childValue.get("name").toString();
								{
									HashMap<String, Object> _item = new HashMap<>();
									_item.put("name", _childValue.get("name").toString());
									usermap.add((int)0, _item);
								}
								
								textview_username.setText(_childValue.get("name").toString());
							}
							if (_childValue.containsKey("bio")) {
								if (!_childValue.get("bio").toString().equals("")) {
									textview_bio.setVisibility(View.VISIBLE);
									textview_bio.setVisibility(View.VISIBLE);
									textview_bio.setText(_childValue.get("bio").toString());
								}
								else {
									textview_bio.setVisibility(View.GONE);
								}
							}
							else {
								textview_bio.setVisibility(View.GONE);
							}
							if (_childValue.containsKey("role")) {
								if (_childValue.get("role").toString().equals("admin")) {
									admin.setVisibility(View.VISIBLE);
									moderator.setVisibility(View.GONE);
									verified_linear.setVisibility(View.GONE);
									premium.setVisibility(View.GONE);
									developer.setVisibility(View.GONE);
									vip.setVisibility(View.GONE);
									verified = false;
								}
								if (_childValue.get("role").toString().equals("developer")) {
									admin.setVisibility(View.GONE);
									moderator.setVisibility(View.GONE);
									verified_linear.setVisibility(View.GONE);
									premium.setVisibility(View.GONE);
									developer.setVisibility(View.VISIBLE);
									vip.setVisibility(View.GONE);
									verified = false;
								}
								if (_childValue.get("role").toString().equals("moderator")) {
									admin.setVisibility(View.GONE);
									moderator.setVisibility(View.VISIBLE);
									verified_linear.setVisibility(View.GONE);
									premium.setVisibility(View.GONE);
									developer.setVisibility(View.GONE);
									vip.setVisibility(View.GONE);
									verified = false;
								}
								if (_childValue.get("role").toString().equals("verified")) {
									admin.setVisibility(View.GONE);
									moderator.setVisibility(View.GONE);
									verified_linear.setVisibility(View.VISIBLE);
									premium.setVisibility(View.GONE);
									developer.setVisibility(View.GONE);
									vip.setVisibility(View.GONE);
									verified = true;
								}
								if (_childValue.get("role").toString().equals("vip")) {
									admin.setVisibility(View.GONE);
									moderator.setVisibility(View.GONE);
									verified_linear.setVisibility(View.GONE);
									premium.setVisibility(View.GONE);
									developer.setVisibility(View.GONE);
									vip.setVisibility(View.VISIBLE);
									verified = false;
								}
								if (_childValue.get("role").toString().equals("premium")) {
									admin.setVisibility(View.GONE);
									moderator.setVisibility(View.GONE);
									verified_linear.setVisibility(View.GONE);
									premium.setVisibility(View.VISIBLE);
									developer.setVisibility(View.GONE);
									vip.setVisibility(View.GONE);
									verified = false;
								}
							}
							else {
								admin.setVisibility(View.GONE);
								moderator.setVisibility(View.GONE);
								verified_linear.setVisibility(View.GONE);
								premium.setVisibility(View.GONE);
								developer.setVisibility(View.VISIBLE);
								vip.setVisibility(View.GONE);
								verified = false;
							}
							if (_childValue.containsKey("projects")) {
								textview_projects.setText(_childValue.get("projects").toString());
								projects_c = Double.parseDouble(_childValue.get("projects").toString());
							}
							if (_childValue.containsKey("likes")) {
								textview34.setText(_childValue.get("likes").toString());
								likes_c = Double.parseDouble(_childValue.get("likes").toString());
							}
							if (_childValue.containsKey("downloads")) {
								textview38.setText(_childValue.get("downloads").toString());
								downloads_c = Double.parseDouble(_childValue.get("downloads").toString());
							}
						}
						else {
							acc_banned.setVisibility(View.VISIBLE);
							main.setVisibility(View.GONE);
						}
					}
					else {
						acc_banned.setVisibility(View.VISIBLE);
						main.setVisibility(View.GONE);
					}
				}
				else {
					
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(key)) {
					if (_childValue.containsKey("profile")) {
						if (!_childValue.get("profile").toString().equals("")) {
							_setCircleImageURL(imageview1, _childValue.get("profile").toString(), 3, "#3F51B5");
							picurl = _childValue.get("profile").toString();
						}
						else {
							imageview1.setImageResource(R.drawable.default_avatar);
							picurl = _childValue.get("profile").toString();
						}
					}
					else {
						imageview1.setImageResource(R.drawable.default_avatar);
						picurl = _childValue.get("profile").toString();
					}
					if (_childValue.containsKey("name")) {
						Name = _childValue.get("name").toString();
						{
							HashMap<String, Object> _item = new HashMap<>();
							_item.put("name", _childValue.get("name").toString());
							usermap.add((int)0, _item);
						}
						
						textview_username.setText(_childValue.get("name").toString());
					}
					if (_childValue.containsKey("bio")) {
						textview_bio.setVisibility(View.VISIBLE);
						textview_bio.setVisibility(View.VISIBLE);
						textview_bio.setText(_childValue.get("bio").toString());
					}
					else {
						textview_bio.setVisibility(View.GONE);
					}
					if (_childValue.containsKey("role")) {
						if (_childValue.get("role").toString().equals("admin")) {
							admin.setVisibility(View.VISIBLE);
							moderator.setVisibility(View.GONE);
							verified_linear.setVisibility(View.GONE);
							premium.setVisibility(View.GONE);
							developer.setVisibility(View.GONE);
							vip.setVisibility(View.GONE);
						}
						if (_childValue.get("role").toString().equals("developer")) {
							admin.setVisibility(View.GONE);
							moderator.setVisibility(View.GONE);
							verified_linear.setVisibility(View.GONE);
							premium.setVisibility(View.GONE);
							developer.setVisibility(View.VISIBLE);
							vip.setVisibility(View.GONE);
						}
						if (_childValue.get("role").toString().equals("moderator")) {
							admin.setVisibility(View.GONE);
							moderator.setVisibility(View.VISIBLE);
							verified_linear.setVisibility(View.GONE);
							premium.setVisibility(View.GONE);
							developer.setVisibility(View.GONE);
							vip.setVisibility(View.GONE);
						}
						if (_childValue.get("role").toString().equals("verified")) {
							admin.setVisibility(View.GONE);
							moderator.setVisibility(View.GONE);
							verified_linear.setVisibility(View.VISIBLE);
							premium.setVisibility(View.GONE);
							developer.setVisibility(View.GONE);
							vip.setVisibility(View.GONE);
						}
						if (_childValue.get("role").toString().equals("vip")) {
							admin.setVisibility(View.GONE);
							moderator.setVisibility(View.GONE);
							verified_linear.setVisibility(View.GONE);
							premium.setVisibility(View.GONE);
							developer.setVisibility(View.GONE);
							vip.setVisibility(View.VISIBLE);
						}
						if (_childValue.get("role").toString().equals("premium")) {
							admin.setVisibility(View.GONE);
							moderator.setVisibility(View.GONE);
							verified_linear.setVisibility(View.GONE);
							premium.setVisibility(View.VISIBLE);
							developer.setVisibility(View.GONE);
							vip.setVisibility(View.GONE);
						}
					}
					else {
						admin.setVisibility(View.GONE);
						moderator.setVisibility(View.GONE);
						verified_linear.setVisibility(View.GONE);
						premium.setVisibility(View.GONE);
						developer.setVisibility(View.VISIBLE);
						vip.setVisibility(View.GONE);
					}
					if (_childValue.containsKey("projects")) {
						textview_projects.setText(_childValue.get("projects").toString());
						projects_c = Double.parseDouble(_childValue.get("projects").toString());
					}
					if (_childValue.containsKey("likes")) {
						textview34.setText(_childValue.get("likes").toString());
						likes_c = Double.parseDouble(_childValue.get("likes").toString());
					}
					if (_childValue.containsKey("downloads")) {
						textview38.setText(_childValue.get("downloads").toString());
						downloads_c = Double.parseDouble(_childValue.get("downloads").toString());
					}
				}
				else {
					
				}
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
		
		_profile_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_profile_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_profile_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				
			}
		};
		
		_profile_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_profile_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_profile_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_admin_users_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("users")) {
					adn = 0;
					for(int _repeat205 = 0; _repeat205 < (int)(50); _repeat205++) {
						if (_childValue.containsKey("admin".concat(String.valueOf((long)(adn))).trim())) {
							if (!admins.contains(_childValue.get("admin".concat(String.valueOf((long)(adn))).trim()).toString())) {
								admins.add(_childValue.get("admin".concat(String.valueOf((long)(adn))).trim()).toString());
							}
							adn++;
						}
					}
					mdn = 0;
					for(int _repeat236 = 0; _repeat236 < (int)(50); _repeat236++) {
						if (_childValue.containsKey("moderator".concat(String.valueOf((long)(mdn))).trim())) {
							if (!moderators.contains(_childValue.get("moderator".concat(String.valueOf((long)(mdn))).trim()).toString())) {
								moderators.add(_childValue.get("moderator".concat(String.valueOf((long)(mdn))).trim()).toString());
							}
							mdn++;
						}
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("users")) {
					adn = 0;
					for(int _repeat75 = 0; _repeat75 < (int)(50); _repeat75++) {
						if (_childValue.containsKey("admin".concat(String.valueOf((long)(adn))).trim())) {
							if (!admins.contains(_childValue.get("admin".concat(String.valueOf((long)(adn))).trim()).toString())) {
								admins.add(_childValue.get("admin".concat(String.valueOf((long)(adn))).trim()).toString());
								admins.remove((int)(admins.indexOf(_childValue.get("admin".concat(String.valueOf((long)(adn))).trim()).toString())));
							}
							adn++;
						}
					}
					mdn = 0;
					for(int _repeat114 = 0; _repeat114 < (int)(50); _repeat114++) {
						if (_childValue.containsKey("moderator".concat(String.valueOf((long)(mdn))).trim())) {
							if (!moderators.contains(_childValue.get("moderator".concat(String.valueOf((long)(mdn))).trim()).toString())) {
								moderators.add(_childValue.get("moderator".concat(String.valueOf((long)(mdn))).trim()).toString());
								moderators.remove((int)(moderators.indexOf(_childValue.get("moderator".concat(String.valueOf((long)(mdn))).trim()).toString())));
							}
							mdn++;
						}
					}
				}
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("admin")) {
					adn = 0;
					for(int _repeat123 = 0; _repeat123 < (int)(adn); _repeat123++) {
						if (_childValue.containsKey("admin".concat(String.valueOf((long)(adn))).trim())) {
							if (admins.contains(_childValue.get("admin".concat(String.valueOf((long)(adn))).trim()).toString())) {
								admins.remove((int)(admins.indexOf(_childValue.get("admin".concat(String.valueOf((long)(adn))).trim()).toString())));
							}
							adn++;
						}
					}
					mdn = 0;
					for(int _repeat157 = 0; _repeat157 < (int)(mdn); _repeat157++) {
						if (_childValue.containsKey("moderator".concat(String.valueOf((long)(mdn))).trim())) {
							if (moderators.contains(_childValue.get("moderator".concat(String.valueOf((long)(mdn))).trim()).toString())) {
								moderators.remove((int)(moderators.indexOf(_childValue.get("moderator".concat(String.valueOf((long)(mdn))).trim()).toString())));
							}
							mdn++;
						}
					}
				}
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		admin_users.addChildEventListener(_admin_users_child_listener);
		
		aith_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		aith_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		aith_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		aith_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		aith_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		aith_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		aith_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_aith_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_aith_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_aith_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		_Load(true);
		pr_differ = 0;
		paused = false;
		lk_differ = 0;
		dl_differ = 0;
		No_2 = false;
		No_1 = false;
		key = getIntent().getStringExtra("uid");
		like_key = FirebaseAuth.getInstance().getCurrentUser().getUid().concat(getIntent().getStringExtra("uid"));
		ban_btn.setVisibility(View.GONE);
		_changeActivityFont("calculator");
		textview_username.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_bold.ttf"), 1);
		_Elevation(linear34, 23);
		_Elevation(hscroll1, 10);
		listview1.setSelector(android.R.color.transparent);
		if (getIntent().getStringExtra("uid").equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
			_fab.setVisibility(View.VISIBLE);
			textview32.setVisibility(View.VISIBLE);
		}
		else {
			_fab.setVisibility(View.GONE);
			textview32.setVisibility(View.GONE);
		}
		_rippleRoundStroke(vip, "#536DFE", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(developer, "#536DFE", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(premium, "#536DFE", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(verified_linear, "#536DFE", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(admin, "#536DFE", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(moderator, "#536DFE", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(imageview1, "#536DFE", "#EEEEEE", 20, 0, "#3F51B5");
		_rippleRoundStroke(linear34, "#FFFFFF", "#EEEEEE", 30, 3, "#3F51B5");
		listview1.setVerticalScrollBarEnabled(false);
		_makeLinksClickable(textview_bio);
		vip_ic.setColorFilter(Color.parseColor("#FFFFFF"));
		
		premium_ic.setColorFilter(Color.parseColor("#FFFFFF"));
		
		admin_ic.setColorFilter(Color.parseColor("#FFFFFF"));
		
		verified_ic.setColorFilter(Color.parseColor("#FFFFFF"));
		
		moderator_ic.setColorFilter(Color.parseColor("#FFFFFF"));
		
		developer_ic.setColorFilter(Color.parseColor("#FFFFFF"));
		_removeScollBar(vscroll1);
		/*
listview1.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
listview1.setStackFromBottom(false);
textview_bio.setClickable(true);
android.text.util.Linkify.addLinks(textview_bio, android.text.util.Linkify.ALL);
textview_bio.setLinkTextColor(Color.parseColor("#009688"));
textview_bio.setLinksClickable(true);
Collections.reverse(listmap);
*/
		rep_ = 0;
		lk_differ = 0;
		dl_differ = 0;
		pr_differ = 0;
		projectsss = 0;
		likes = 0;
		user_dwnds = 0;
		n = 0;
		_SignalChecker();
	}
	
	@Override
	public void onStart() {
		super.onStart();
		dl_differ = 0;
		pr_differ = 0;
		lk_differ = 0;
		data1.removeEventListener(_data1_child_listener);
		map2 = new HashMap<>();
		map2.put("downloads", "0");
		map2.put("likes", "0");
		users.child(key).updateChildren(map2);
		map2.clear();
		listmap.clear();
		data1.addChildEventListener(_data1_child_listener);
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
	
	
	public void _Elevation(final View _view, final double _number) {
		
		_view.setElevation((int)_number);
	}
	
	
	public void _custom_loading(final boolean _visibility) {
		if (_visibility) {
			if (coreprog == null){
				coreprog = new ProgressDialog(this);
				
				coreprog.requestWindowFeature(Window.FEATURE_NO_TITLE);  coreprog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.WHITE));
				
			}
			coreprog.setMessage(null);
			coreprog.show();
			View _view = getLayoutInflater().inflate(R.layout.badges, null);
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
	
	
	public void _rippleRoundStroke(final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public void _setCircleImageURL(final ImageView _imageview, final String _url, final double _strokeWidth, final String _strokeColor) {
		Glide.with(getApplicationContext()).load(Uri.parse(_url)).transform(new BorderTransformation(this, (float)_strokeWidth, Color.parseColor(_strokeColor))).into(_imageview);
	}
	public class BorderTransformation extends com.bumptech.glide.load.resource.bitmap.BitmapTransformation {
		
		private float strokeWidth;
		private int strokeColor;
		
		    public BorderTransformation(Context context, float strokeWidth, int strokeColor) {
			        super(context);
			this.strokeWidth = strokeWidth;
			this.strokeColor = strokeColor;
			    }
		
		    @Override
		    protected Bitmap transform(com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool pool, Bitmap bmp, int outWidth, int outHeight) {
			    Bitmap sbmp;
			    int radius = bmp.getWidth();
			    if (bmp.getWidth() != radius || bmp.getHeight() != radius) {
				        float smallest = Math.min(bmp.getWidth(), bmp.getHeight());
				        float factor = smallest / radius;
				        sbmp = Bitmap.createScaledBitmap(bmp, (int)(bmp.getWidth() / factor), (int)(bmp.getHeight() / factor), false);
				    } else {
				        sbmp = bmp;
				    }
			
			    Bitmap output = Bitmap.createBitmap(radius, radius,
			            Bitmap.Config.ARGB_8888);
			    Canvas canvas = new Canvas(output);
			
			    final int color = 0xffa19774;
			    final Paint paint = new Paint();
			    final Paint stroke = new Paint();
			
			    final Rect rect = new Rect(0, 0, radius, radius);
			
			    paint.setAntiAlias(true);
			    stroke.setAntiAlias(true);
			
			    paint.setFilterBitmap(true);
			    stroke.setFilterBitmap(true);
			
			    paint.setDither(true);
			    stroke.setDither(true);
			
			    canvas.drawARGB(0, 0, 0, 0);
			    paint.setColor(Color.RED);
			    stroke.setColor(strokeColor); //border color
			    stroke.setStyle(Paint.Style.STROKE);
			    stroke.setStrokeWidth(strokeWidth); //border width
			    canvas.drawCircle(radius / 2 + 0.7f,
			            radius / 2 + 0.7f, radius / 2 + 0.1f, paint);
			    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
			    canvas.drawBitmap(sbmp, rect, rect, paint);
			
			    canvas.drawCircle(radius / 2 + 0.7f,
			            radius / 2 + 0.7f, radius / 2 - stroke.getStrokeWidth()/2 +0.1f, stroke);
			
			    return output;
			    }
		
		    @Override
		    public String getId() {
			        return this.getClass().getName();
			    }
		//DO NOT REMOVE THIS
	}
	
	
	public void _setBgCorners(final View _view, final double _radius, final String _color) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(); 
		gd.setColor(Color.parseColor("#" + _color.replace("#", ""))); /* color */
		gd.setCornerRadius((int)_radius); /* radius */
		gd.setStroke(0, Color.WHITE); /* stroke heigth and color */
		_view.setBackground(gd);
	}
	
	
	public void _makeLinksClickable(final TextView _textView) {
		try {
			String _color = "#0871ff";
			_textView.setClickable(true);
			android.text.util.Linkify.addLinks(_textView, android.text.util.Linkify.ALL);
			_textView.setLinkTextColor(Color.parseColor(_color));
			_textView.setLinksClickable(true); } catch (Exception e) { };
	}
	
	
	public void _ViewSetHeight(final View _view, final double _num1) {
		_view.getLayoutParams().height=(int)(_num1);
	}
	
	
	public void _removeScollBar(final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
	}
	
	
	public void _setRoundCorner(final View _view, final String _color, final double _radius) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor(_color));
		
		gd.setCornerRadius((int)_radius);
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
	
	
	public void _SignalChecker() {
		r = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (No_1 && No_2) {
							r.cancel();
							_Load(false);
							if (nothing.getVisibility() == View.VISIBLE) {
								textview_projects.setText("0");
								textview34.setText("0");
								textview38.setText("0");
							}
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(r, (int)(500), (int)(250));
	}
	
	
	public void _Load(final boolean _visibility) {
		if (_visibility) {
			if (coreprogr == null){
				coreprogr = new ProgressDialog(this);
				coreprogr.setCancelable(false);
				coreprogr.setCanceledOnTouchOutside(false);
				
				coreprogr.requestWindowFeature(Window.FEATURE_NO_TITLE);  coreprogr.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
				
			}
			coreprogr.setMessage(null);
			coreprogr.show();
			View _view = getLayoutInflater().inflate(R.layout.load, null);
			LinearLayout linear_base = (LinearLayout) _view.findViewById(R.id.linear_base);
			
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.TRANSPARENT);
			gd.setCornerRadius(25);
			linear_base.setBackground(gd);
			coreprogr.setContentView(_view);
		}
		else {
			if (coreprogr != null){
				coreprogr.dismiss();
			}
		}
	}
	private ProgressDialog coreprogr;
	{
	}
	
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.apk_cus, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final ImageView imageview_ic = _view.findViewById(R.id.imageview_ic);
			final LinearLayout linear7 = _view.findViewById(R.id.linear7);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final TextView textview_name = _view.findViewById(R.id.textview_name);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final ImageView imageview5 = _view.findViewById(R.id.imageview5);
			final TextView textview_uploader = _view.findViewById(R.id.textview_uploader);
			final ImageView lock = _view.findViewById(R.id.lock);
			final ImageView imageview2 = _view.findViewById(R.id.imageview2);
			final TextView textview_cmt = _view.findViewById(R.id.textview_cmt);
			final ImageView imageview3 = _view.findViewById(R.id.imageview3);
			final TextView textview_likes = _view.findViewById(R.id.textview_likes);
			final ImageView imageview4 = _view.findViewById(R.id.imageview4);
			final TextView textview_dwnd = _view.findViewById(R.id.textview_dwnd);
			
			_Elevation(linear1, 7);
			_rippleRoundStroke(linear1, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
			imageview2.setColorFilter(Color.parseColor("#FBC02D"));
			
			imageview5.setColorFilter(Color.parseColor("#536DFE"));
			if (_data.get((int)_position).containsKey("visibility")) {
				if (_data.get((int)_position).get("visibility").toString().equals("true")) {
					main.setVisibility(View.VISIBLE);
					
					if (_data.get((int)_position).containsKey("icon")) {
						Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("icon").toString())).into(imageview_ic);
					}
					else {
						imageview_ic.setImageResource(R.drawable.android_icon);
					}
					if (_data.get((int)_position).containsKey("title")) {
						textview_name.setText(_data.get((int)_position).get("title").toString());
					}
					if (_data.get((int)_position).containsKey("likes")) {
						textview_likes.setText(_data.get((int)_position).get("likes").toString());
					}
					if (_data.get((int)_position).containsKey("comments")) {
						textview_cmt.setText(_data.get((int)_position).get("comments").toString());
					}
					if (_data.get((int)_position).containsKey("downloads")) {
						textview_dwnd.setText(_data.get((int)_position).get("downloads").toString());
					}
					if (_data.get((int)_position).containsKey("verification")) {
						if (_data.get((int)_position).get("verification").toString().equals("true")) {
							lock.setVisibility(View.VISIBLE);
						}
						else {
							lock.setVisibility(View.GONE);
						}
					}
					else {
						lock.setVisibility(View.GONE);
					}
					textview_uploader.setText(Name);
				}
				else {
					if (_data.get((int)_position).get("uid").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
						if (_data.get((int)_position).containsKey("icon")) {
							Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("icon").toString())).into(imageview_ic);
						}
						else {
							imageview_ic.setImageResource(R.drawable.android_icon);
						}
						if (_data.get((int)_position).containsKey("title")) {
							textview_name.setText(_data.get((int)_position).get("title").toString());
						}
						if (_data.get((int)_position).containsKey("likes")) {
							textview_likes.setText(_data.get((int)_position).get("likes").toString());
						}
						if (_data.get((int)_position).containsKey("comments")) {
							textview_cmt.setText(_data.get((int)_position).get("comments").toString());
						}
						if (_data.get((int)_position).containsKey("downloads")) {
							textview_dwnd.setText(_data.get((int)_position).get("downloads").toString());
						}
						if (_data.get((int)_position).containsKey("verification")) {
							if (_data.get((int)_position).get("verification").toString().equals("true")) {
								lock.setVisibility(View.VISIBLE);
							}
							else {
								lock.setVisibility(View.GONE);
							}
						}
						else {
							lock.setVisibility(View.GONE);
						}
						textview_uploader.setText(Name);
						main.setVisibility(View.VISIBLE);
						
					}
					else {
						linear1.setVisibility(View.GONE);
					}
				}
			}
			else {
				main.setVisibility(View.VISIBLE);
				
				_rippleRoundStroke(imageview_ic, "#FFFFFF", "#FFFFFF", 15, 0, "#FFFFFF");
				if (_data.get((int)_position).containsKey("icon")) {
					Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("icon").toString())).into(imageview_ic);
				}
				else {
					imageview_ic.setImageResource(R.drawable.android_icon);
				}
				if (_data.get((int)_position).containsKey("title")) {
					textview_name.setText(_data.get((int)_position).get("title").toString());
				}
				if (_data.get((int)_position).containsKey("likes")) {
					textview_likes.setText(_data.get((int)_position).get("likes").toString());
				}
				if (_data.get((int)_position).containsKey("comments")) {
					textview_cmt.setText(_data.get((int)_position).get("comments").toString());
				}
				if (_data.get((int)_position).containsKey("downloads")) {
					textview_dwnd.setText(_data.get((int)_position).get("downloads").toString());
				}
				if (_data.get((int)_position).containsKey("verification")) {
					if (_data.get((int)_position).get("verification").toString().equals("true")) {
						lock.setVisibility(View.VISIBLE);
					}
					else {
						lock.setVisibility(View.GONE);
					}
				}
				else {
					lock.setVisibility(View.GONE);
				}
				textview_uploader.setText(Name);
			}
			
			return _view;
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