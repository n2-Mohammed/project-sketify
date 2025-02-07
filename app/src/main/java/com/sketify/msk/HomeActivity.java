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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.appbar.AppBarLayout;
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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class HomeActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private FloatingActionButton _fab;
	private DrawerLayout _drawer;
	private String icon_path = "";
	private String PATH_SKETCHWARE = "";
	private String PATH_HIDE_SKETCHLIB = "";
	private String PATH_SKETCHLIB = "";
	private double number = 0;
	private String up_edit = "";
	private String up_icon = "";
	private String project_key = "";
	private String icon_url = "";
	private HashMap<String, Object> data_map = new HashMap<>();
	private String priv_text = "";
	private String charSeq = "";
	private HashMap<String, Object> temp_map1 = new HashMap<>();
	private String temp_decrypted = "";
	private HashMap<String, Object> temp_map2 = new HashMap<>();
	private String line = "";
	private String privacy_text = "";
	private String change_name = "";
	private String name = "";
	private String email = "";
	private String mblock_name = "";
	private String mblock_key = "";
	private String publish_c = "";
	private String publish_c_t = "";
	private String code_key = "";
	private double search_n = 0;
	private double search_n1 = 0;
	private double n = 0;
	private String app_version = "";
	private String fontName = "";
	private String typeace = "";
	private String avator = "";
	private double new_n = 0;
	private double vis = 0;
	private boolean profile = false;
	private double log_anim_N = 0;
	private double log_anim_L = 0;
	private boolean No_1 = false;
	private boolean No_2 = false;
	private boolean No_3 = false;
	private boolean No_4 = false;
	private double back = 0;
	private String Sketify_Directory = "";
	private String Sketify_Hidden_Path = "";
	private String Sketchware_Path = "";
	private boolean vip = false;
	private boolean premium = false;
	private String projects = "";
	private boolean developer = false;
	private boolean main = false;
	private boolean control = false;
	private HashMap<String, Object> updator = new HashMap<>();
	private HashMap<String, Object> updater = new HashMap<>();
	private boolean goTop = false;
	private boolean goBottom = false;
	private String versionName = "";
	private boolean cancel = false;
	private String str = "";
	private boolean isSearching = false;
	
	private ArrayList<String> temp_str1 = new ArrayList<>();
	private ArrayList<String> copy_list = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> temp_listmap1 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> temp_listmap2 = new ArrayList<>();
	private ArrayList<String> temp_str2 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap1 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap2 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap3 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> gridmap1 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> gridmap2 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> gridmap3 = new ArrayList<>();
	private ArrayList<String> category = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> newsmap = new ArrayList<>();
	private ArrayList<String> news_keys = new ArrayList<>();
	private ArrayList<String> pr = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> categorymap = new ArrayList<>();
	
	private LinearLayout appbar;
	private LinearLayout linear1;
	private LinearLayout progress;
	private LinearLayout navigation_linear;
	private LinearLayout toolbar;
	private LinearLayout tablayout;
	private ImageView imageview5;
	private EditText search_text;
	private ImageView imageview_logo;
	private ImageView profilee;
	private LinearLayout base;
	private LinearLayout trash;
	private LinearLayout layouts_main;
	private LinearLayout layout1;
	private LinearLayout layout2;
	private LinearLayout layout3;
	private LinearLayout layout4;
	private ListView listview1;
	private ScrollView vscroll1;
	private LinearLayout line_home;
	private LinearLayout new_gridlayout;
	private LinearLayout popular_gridlayout;
	private LinearLayout editor_gridlayout;
	private LinearLayout linear5;
	private HorizontalScrollView hscroll1;
	private ImageView imageview2;
	private TextView textview2;
	private TextView new_seemore;
	private LinearLayout new_grid_line;
	private LinearLayout linear7;
	private HorizontalScrollView hscroll2;
	private ImageView imageview3;
	private TextView textview3;
	private TextView popular_seemore;
	private LinearLayout popular_grid_line;
	private LinearLayout linear10;
	private HorizontalScrollView hscroll3;
	private ImageView imageview4;
	private TextView textview5;
	private TextView editor_seemore;
	private LinearLayout editor_grid_line;
	private ListView listview2;
	private ListView listview3;
	private ListView listview4;
	private ProgressBar progressbar1;
	private LinearLayout home;
	private LinearLayout allapps;
	private LinearLayout newss;
	private LinearLayout categoryy;
	private ImageView imageview11;
	private TextView textview9;
	private ImageView imageview10;
	private TextView textview8;
	private ImageView news_dot;
	private ImageView imageview9;
	private TextView textview7;
	private ImageView imageview8;
	private TextView textview6;
	private LinearLayout _drawer_main;
	private LinearLayout _drawer_linear_btm;
	private ScrollView _drawer_vscroll1;
	private LinearLayout _drawer_linear5;
	private LinearLayout _drawer_linear54;
	private LinearLayout _drawer_linear1;
	private LinearLayout _drawer_profile;
	private LinearLayout _drawer_pricings;
	private LinearLayout _drawer_p_manage;
	private LinearLayout _drawer_linear58;
	private LinearLayout _drawer_codes;
	private LinearLayout _drawer_share;
	private LinearLayout _drawer_linear61;
	private LinearLayout _drawer_community;
	private LinearLayout _drawer_blog;
	private LinearLayout _drawer_linear60;
	private LinearLayout _drawer_discord;
	private LinearLayout _drawer_rateus;
	private LinearLayout _drawer_settings;
	private LinearLayout _drawer_about_us;
	private LinearLayout _drawer_linear53;
	private ImageView _drawer_profilepic;
	private LinearLayout _drawer_linear3;
	private TextView _drawer_name;
	private LinearLayout _drawer_linear4;
	private TextView _drawer_email;
	private ImageView _drawer_img1;
	private TextView _drawer_textview6;
	private ImageView _drawer_img2;
	private TextView _drawer_textview31;
	private ImageView _drawer_img3;
	private TextView _drawer_textview9;
	private ImageView _drawer_img4;
	private TextView _drawer_textview5;
	private ImageView _drawer_img5;
	private TextView _drawer_textview30;
	private ImageView _drawer_img6;
	private TextView _drawer_textview3;
	private ImageView _drawer_img7;
	private TextView _drawer_textview8;
	private ImageView _drawer_img8;
	private TextView _drawer_textview33;
	private ImageView _drawer_img11;
	private TextView _drawer_textview34;
	private ImageView _drawer_img9;
	private TextView _drawer_textview7;
	private ImageView _drawer_img10;
	private TextView _drawer_textview29;
	private ImageView _drawer_web_logo;
	private ImageView _drawer_twitter_logo;
	private ImageView _drawer_yt_logo;
	
	private DatabaseReference users = _firebase.getReference("users");
	private ChildEventListener _users_child_listener;
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
	
	private Intent intent = new Intent();
	private TimerTask timer;
	private DatabaseReference data1 = _firebase.getReference("data1");
	private ChildEventListener _data1_child_listener;
	private AlertDialog.Builder p_publish_dialog;
	private AlertDialog.Builder account_dialog;
	private AlertDialog.Builder mblock_publish;
	private AlertDialog.Builder c_publish;
	private SharedPreferences data;
	private TimerTask data_load;
	private TimerTask update_time;
	private AlertDialog.Builder update_dialog;
	private Intent update_intent = new Intent();
	private AlertDialog.Builder exit;
	private SharedPreferences m;
	private AlertDialog.Builder delete;
	private TimerTask click;
	private DatabaseReference admin = _firebase.getReference("admin");
	private ChildEventListener _admin_child_listener;
	private Intent ctg = new Intent();
	private SharedPreferences user_facility;
	private ObjectAnimator obj = new ObjectAnimator();
	private Intent tp = new Intent();
	private DatabaseReference news = _firebase.getReference("news");
	private ChildEventListener _news_child_listener;
	private Intent view = new Intent();
	private Intent view_profile = new Intent();
	private Intent view_codes = new Intent();
	private Intent goto_community = new Intent();
	private Intent about_elme = new Intent();
	private Intent setting_mera_dhobada = new Intent();
	private Intent bog_view = new Intent();
	private Intent yt_view = new Intent();
	private RequestNetwork Net;
	private RequestNetwork.RequestListener _Net_request_listener;
	private Intent web = new Intent();
	private ObjectAnimator oa_d = new ObjectAnimator();
	private SharedPreferences file;
	private Intent p_manage_goon = new Intent();
	private Intent twitter = new Intent();
	private AlertDialog.Builder upd;
	private Intent view_upd = new Intent();
	private TimerTask anim;
	private TimerTask t;
	private TimerTask anim_logo1;
	private TimerTask anim_logo2;
	private ObjectAnimator anim1 = new ObjectAnimator();
	private SharedPreferences user;
	private TimerTask bck;
	private TimerTask serch;
	private Intent prplans = new Intent();
	private Intent diacord = new Intent();
	private SharedPreferences transferdata;
	private SharedPreferences export;
	private RequestNetwork NetonStart;
	private RequestNetwork.RequestListener _NetonStart_request_listener;
	private Intent rateus_gonon = new Intent();
	private AlertDialog.Builder recaptcha;
	private SharedPreferences recaptchafile;
	private TimerTask faber;
	private RequestNetwork reqnet;
	private RequestNetwork.RequestListener _reqnet_request_listener;
	private TimerTask omTes;
	private ObjectAnimator oa_title = new ObjectAnimator();
	private SharedPreferences first;
	private ObjectAnimator oa_fab = new ObjectAnimator();
	private Intent acc_bab = new Intent();
	private AlertDialog.Builder dialog;
	private Intent view_go = new Intent();
	private Intent restart = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home);
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
		_fab = findViewById(R.id._fab);
		
		_drawer = findViewById(R.id._drawer);
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(HomeActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = findViewById(R.id._nav_view);
		
		appbar = findViewById(R.id.appbar);
		linear1 = findViewById(R.id.linear1);
		progress = findViewById(R.id.progress);
		navigation_linear = findViewById(R.id.navigation_linear);
		toolbar = findViewById(R.id.toolbar);
		tablayout = findViewById(R.id.tablayout);
		imageview5 = findViewById(R.id.imageview5);
		search_text = findViewById(R.id.search_text);
		imageview_logo = findViewById(R.id.imageview_logo);
		profilee = findViewById(R.id.profilee);
		base = findViewById(R.id.base);
		trash = findViewById(R.id.trash);
		layouts_main = findViewById(R.id.layouts_main);
		layout1 = findViewById(R.id.layout1);
		layout2 = findViewById(R.id.layout2);
		layout3 = findViewById(R.id.layout3);
		layout4 = findViewById(R.id.layout4);
		listview1 = findViewById(R.id.listview1);
		vscroll1 = findViewById(R.id.vscroll1);
		line_home = findViewById(R.id.line_home);
		new_gridlayout = findViewById(R.id.new_gridlayout);
		popular_gridlayout = findViewById(R.id.popular_gridlayout);
		editor_gridlayout = findViewById(R.id.editor_gridlayout);
		linear5 = findViewById(R.id.linear5);
		hscroll1 = findViewById(R.id.hscroll1);
		imageview2 = findViewById(R.id.imageview2);
		textview2 = findViewById(R.id.textview2);
		new_seemore = findViewById(R.id.new_seemore);
		new_grid_line = findViewById(R.id.new_grid_line);
		linear7 = findViewById(R.id.linear7);
		hscroll2 = findViewById(R.id.hscroll2);
		imageview3 = findViewById(R.id.imageview3);
		textview3 = findViewById(R.id.textview3);
		popular_seemore = findViewById(R.id.popular_seemore);
		popular_grid_line = findViewById(R.id.popular_grid_line);
		linear10 = findViewById(R.id.linear10);
		hscroll3 = findViewById(R.id.hscroll3);
		imageview4 = findViewById(R.id.imageview4);
		textview5 = findViewById(R.id.textview5);
		editor_seemore = findViewById(R.id.editor_seemore);
		editor_grid_line = findViewById(R.id.editor_grid_line);
		listview2 = findViewById(R.id.listview2);
		listview3 = findViewById(R.id.listview3);
		listview4 = findViewById(R.id.listview4);
		progressbar1 = findViewById(R.id.progressbar1);
		home = findViewById(R.id.home);
		allapps = findViewById(R.id.allapps);
		newss = findViewById(R.id.newss);
		categoryy = findViewById(R.id.categoryy);
		imageview11 = findViewById(R.id.imageview11);
		textview9 = findViewById(R.id.textview9);
		imageview10 = findViewById(R.id.imageview10);
		textview8 = findViewById(R.id.textview8);
		news_dot = findViewById(R.id.news_dot);
		imageview9 = findViewById(R.id.imageview9);
		textview7 = findViewById(R.id.textview7);
		imageview8 = findViewById(R.id.imageview8);
		textview6 = findViewById(R.id.textview6);
		_drawer_main = _nav_view.findViewById(R.id.main);
		_drawer_linear_btm = _nav_view.findViewById(R.id.linear_btm);
		_drawer_vscroll1 = _nav_view.findViewById(R.id.vscroll1);
		_drawer_linear5 = _nav_view.findViewById(R.id.linear5);
		_drawer_linear54 = _nav_view.findViewById(R.id.linear54);
		_drawer_linear1 = _nav_view.findViewById(R.id.linear1);
		_drawer_profile = _nav_view.findViewById(R.id.profile);
		_drawer_pricings = _nav_view.findViewById(R.id.pricings);
		_drawer_p_manage = _nav_view.findViewById(R.id.p_manage);
		_drawer_linear58 = _nav_view.findViewById(R.id.linear58);
		_drawer_codes = _nav_view.findViewById(R.id.codes);
		_drawer_share = _nav_view.findViewById(R.id.share);
		_drawer_linear61 = _nav_view.findViewById(R.id.linear61);
		_drawer_community = _nav_view.findViewById(R.id.community);
		_drawer_blog = _nav_view.findViewById(R.id.blog);
		_drawer_linear60 = _nav_view.findViewById(R.id.linear60);
		_drawer_discord = _nav_view.findViewById(R.id.discord);
		_drawer_rateus = _nav_view.findViewById(R.id.rateus);
		_drawer_settings = _nav_view.findViewById(R.id.settings);
		_drawer_about_us = _nav_view.findViewById(R.id.about_us);
		_drawer_linear53 = _nav_view.findViewById(R.id.linear53);
		_drawer_profilepic = _nav_view.findViewById(R.id.profilepic);
		_drawer_linear3 = _nav_view.findViewById(R.id.linear3);
		_drawer_name = _nav_view.findViewById(R.id.name);
		_drawer_linear4 = _nav_view.findViewById(R.id.linear4);
		_drawer_email = _nav_view.findViewById(R.id.email);
		_drawer_img1 = _nav_view.findViewById(R.id.img1);
		_drawer_textview6 = _nav_view.findViewById(R.id.textview6);
		_drawer_img2 = _nav_view.findViewById(R.id.img2);
		_drawer_textview31 = _nav_view.findViewById(R.id.textview31);
		_drawer_img3 = _nav_view.findViewById(R.id.img3);
		_drawer_textview9 = _nav_view.findViewById(R.id.textview9);
		_drawer_img4 = _nav_view.findViewById(R.id.img4);
		_drawer_textview5 = _nav_view.findViewById(R.id.textview5);
		_drawer_img5 = _nav_view.findViewById(R.id.img5);
		_drawer_textview30 = _nav_view.findViewById(R.id.textview30);
		_drawer_img6 = _nav_view.findViewById(R.id.img6);
		_drawer_textview3 = _nav_view.findViewById(R.id.textview3);
		_drawer_img7 = _nav_view.findViewById(R.id.img7);
		_drawer_textview8 = _nav_view.findViewById(R.id.textview8);
		_drawer_img8 = _nav_view.findViewById(R.id.img8);
		_drawer_textview33 = _nav_view.findViewById(R.id.textview33);
		_drawer_img11 = _nav_view.findViewById(R.id.img11);
		_drawer_textview34 = _nav_view.findViewById(R.id.textview34);
		_drawer_img9 = _nav_view.findViewById(R.id.img9);
		_drawer_textview7 = _nav_view.findViewById(R.id.textview7);
		_drawer_img10 = _nav_view.findViewById(R.id.img10);
		_drawer_textview29 = _nav_view.findViewById(R.id.textview29);
		_drawer_web_logo = _nav_view.findViewById(R.id.web_logo);
		_drawer_twitter_logo = _nav_view.findViewById(R.id.twitter_logo);
		_drawer_yt_logo = _nav_view.findViewById(R.id.yt_logo);
		auth = FirebaseAuth.getInstance();
		p_publish_dialog = new AlertDialog.Builder(this);
		account_dialog = new AlertDialog.Builder(this);
		mblock_publish = new AlertDialog.Builder(this);
		c_publish = new AlertDialog.Builder(this);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		update_dialog = new AlertDialog.Builder(this);
		exit = new AlertDialog.Builder(this);
		m = getSharedPreferences("t", Activity.MODE_PRIVATE);
		delete = new AlertDialog.Builder(this);
		user_facility = getSharedPreferences("facility", Activity.MODE_PRIVATE);
		Net = new RequestNetwork(this);
		file = getSharedPreferences("file", Activity.MODE_PRIVATE);
		upd = new AlertDialog.Builder(this);
		user = getSharedPreferences("settings", Activity.MODE_PRIVATE);
		transferdata = getSharedPreferences("transferdata", Activity.MODE_PRIVATE);
		export = getSharedPreferences("export", Activity.MODE_PRIVATE);
		NetonStart = new RequestNetwork(this);
		recaptcha = new AlertDialog.Builder(this);
		recaptchafile = getSharedPreferences("recaptchafile", Activity.MODE_PRIVATE);
		reqnet = new RequestNetwork(this);
		first = getSharedPreferences("first", Activity.MODE_PRIVATE);
		dialog = new AlertDialog.Builder(this);
		
		imageview5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_drawer.openDrawer(GravityCompat.START);
			}
		});
		
		search_text.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		search_text.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (_charSeq.equals("")) {
					isSearching = false;
					if (!data.getString("data1", "").equals("")) {
						listmap2 = new Gson().fromJson(data.getString("data1", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
					}
					listview2.setAdapter(new Listview2Adapter(listmap2));
					((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
				}
				else {
					_SetView(layout2, "layout2");
					if (!data.getString("data1", "").equals("")) {
						listmap2 = new Gson().fromJson(data.getString("data1", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
						if (_charSeq.length() > 0) {
							search_n1 = listmap2.size() - 1;
							search_n = listmap2.size();
							for(int _repeat158 = 0; _repeat158 < (int)(search_n); _repeat158++) {
								if (listmap2.get((int)search_n1).get("title").toString().toLowerCase().contains(_charSeq.toLowerCase())) {
									
								}
								else {
									listmap2.remove((int)(search_n1));
								}
								search_n1--;
							}
						}
					}
					listview2.setAdapter(new Listview2Adapter(listmap2));
					((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
					isSearching = true;
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		imageview_logo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		profilee.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (control) {
					view_profile.setClass(getApplicationContext(), ProfileActivity.class);
					view_profile.putExtra("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
					startActivity(view_profile);
				}
			}
		});
		
		base.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				listview1.setAdapter(new Listview1Adapter(listmap1));
				((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
				listview2.setAdapter(new Listview2Adapter(listmap2));
				((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
				listview3.setAdapter(new Listview3Adapter(listmap3));
				((BaseAdapter)listview3.getAdapter()).notifyDataSetChanged();
			}
		});
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				_custom_loading(true);
				click = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_custom_loading(false);
								intent.setClass(getApplicationContext(), ProjectViewActivity.class);
								intent.putExtra("key", listmap1.get((int)_position).get("key").toString());
								intent.putExtra("uid", listmap1.get((int)_position).get("uid").toString());
								intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
								startActivity(intent);
							}
						});
					}
				};
				_timer.schedule(click, (int)(2500));
			}
		});
		
		new_seemore.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), SeemoreActivity.class);
				intent.putExtra("mode", "new");
				intent.putExtra("title", "New Projects");
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
		
		popular_seemore.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), SeemoreActivity.class);
				intent.putExtra("mode", "editor");
				intent.putExtra("title", "Editor's Choice");
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
		
		editor_seemore.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), SeemoreActivity.class);
				intent.putExtra("mode", "open");
				intent.putExtra("title", "Open Sourced");
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
		
		listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				intent.setClass(getApplicationContext(), ProjectViewActivity.class);
				intent.putExtra("key", listmap2.get((int)_position).get("key").toString());
				intent.putExtra("uid", listmap2.get((int)_position).get("uid").toString());
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
		
		listview3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				ctg.setClass(getApplicationContext(), CategoryActivity.class);
				ctg.putExtra("c", category.get((int)(_position)));
				startActivity(ctg);
			}
		});
		
		listview4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (newsmap.get((int)_position).containsKey("img")) {
					if (newsmap.get((int)_position).get("img").toString().equals("")) {
						
					}
					else {
						view.setClass(getApplicationContext(), FullviewActivity.class);
						view.putExtra("main", newsmap.get((int)_position).get("img").toString());
						startActivity(view);
					}
				}
				else {
					
				}
			}
		});
		
		home.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_SetView(layout1, "layout1");
			}
		});
		
		allapps.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_SetView(layout2, "layout2");
				if (!data.getString("data1", "").equals("")) {
					listmap2 = new Gson().fromJson(data.getString("data1", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
					listview2.setAdapter(new Listview2Adapter(listmap2));
					((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
				}
			}
		});
		
		newss.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				news_dot.setVisibility(View.GONE);
				textview7.setTranslationY((float)(0));
				imageview9.setTranslationY((float)(0));
				_SetView(layout4, "layout4");
			}
		});
		
		categoryy.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_SetView(layout3, "layout3");
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				reqnet.startRequestNetwork(RequestNetworkController.GET, "https://sketify.tk", "a", _reqnet_request_listener);
				_FabProgress(true);
			}
		});
		
		_users_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				No_1 = true;
				_removeScollBar(_drawer_vscroll1);
				if (FirebaseAuth.getInstance().getCurrentUser().getUid().equals(_childKey)) {
					if (_childValue.containsKey("status")) {
						if (!_childValue.get("status").toString().equals("banned")) {
							if (_childValue.containsKey("name")) {
								name = _childValue.get("name").toString();
								email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
								_drawer_name.setText(name);
								_drawer_email.setText(email);
								_drawer_linear1.setElevation((int)20);
								_drawer_linear_btm.setElevation((int)15);
							}
							if (_childValue.containsKey("profile")) {
								if (_childValue.get("profile").toString().equals("")) {
									profilee.setImageResource(R.drawable.default_avatar);
								}
								else {
									_setCircleImageURL(profilee, _childValue.get("profile").toString(), 3, "#3F51B5");
									avator = _childValue.get("profile").toString();
									_setCircleImageURL(_drawer_profilepic, _childValue.get("profile").toString(), 3, "#3F51B5");
								}
							}
							else {
								profilee.setImageResource(R.drawable.default_avatar);
							}
							if (_childValue.containsKey("role")) {
								if (_childValue.get("role").toString().equals("vip")) {
									premium = false;
									vip = true;
									developer = false;
									main = false;
								}
								else {
									if (_childValue.get("role").toString().equals("premium")) {
										vip = false;
										premium = true;
										developer = false;
										main = false;
									}
									else {
										if (_childValue.get("role").toString().equals("developer")) {
											premium = false;
											vip = false;
											developer = true;
											main = false;
										}
										else {
											if (_childValue.get("role").toString().equals("verified")) {
												premium = false;
												vip = false;
												developer = true;
												main = false;
											}
											else {
												if (_childValue.get("role").toString().equals("admin") || _childValue.get("role").toString().equals("moderator")) {
													premium = false;
													vip = false;
													developer = false;
													main = true;
												}
											}
										}
									}
								}
							}
							if (_childValue.containsKey("projects")) {
								projects = _childValue.get("projects").toString();
							}
						}
						else {
							acc_bab.setClass(getApplicationContext(), AccBannedActivity.class);
							acc_bab.putExtra("reported_by", _childValue.get("reported_by").toString());
							acc_bab.putExtra("reason", _childValue.get("reason").toString());
							startActivity(acc_bab);
							finish();
						}
					}
					else {
						acc_bab.setClass(getApplicationContext(), AccBannedActivity.class);
						acc_bab.putExtra("reported_by", _childValue.get("reported_by").toString());
						acc_bab.putExtra("reason", _childValue.get("reason").toString());
						startActivity(acc_bab);
						finish();
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (FirebaseAuth.getInstance().getCurrentUser().getUid().equals(_childKey)) {
					if (_childValue.containsKey("name")) {
						name = _childValue.get("name").toString();
						email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
						_drawer_name.setText(name);
						_drawer_email.setText(email);
						_drawer_linear1.setElevation((int)20);
						_drawer_linear_btm.setElevation((int)15);
					}
					if (_childValue.containsKey("profile")) {
						if (_childValue.get("profile").toString().equals("")) {
							profilee.setImageResource(R.drawable.default_avatar);
						}
						else {
							if (_childValue.get("profile").toString().equals("avator")) {
								avator = "https://firebasestorage.googleapis.com/v0/b/sketify-f7280.appspot.com/o/profile%2Fdefault_avatar.png?alt=media&token=34a2571b-7553-4dd1-a14f-4c1af525c094";
								_setCircleImageURL(profilee, avator, 3, "#3F51B5");
								_setCircleImageURL(_drawer_profilepic, avator, 3, "#3F51B5");
								_removeScollBar(_drawer_vscroll1);
							}
							else {
								_setCircleImageURL(profilee, _childValue.get("profile").toString(), 3, "#3F51B5");
								avator = _childValue.get("profile").toString();
								_setCircleImageURL(_drawer_profilepic, _childValue.get("profile").toString(), 3, "#3F51B5");
								_removeScollBar(_drawer_vscroll1);
							}
						}
					}
					else {
						profilee.setImageResource(R.drawable.default_avatar);
					}
					if (_childValue.containsKey("role")) {
						if (_childValue.get("role").toString().equals("vip")) {
							premium = false;
							vip = true;
							developer = false;
							main = false;
						}
						else {
							if (_childValue.get("role").toString().equals("premium")) {
								vip = false;
								premium = true;
								developer = false;
								main = false;
							}
							else {
								if (_childValue.get("role").toString().equals("developer")) {
									premium = false;
									vip = false;
									developer = true;
									main = false;
								}
								else {
									if (_childValue.get("role").toString().equals("verified")) {
										premium = false;
										vip = false;
										developer = true;
										main = false;
									}
									else {
										if (_childValue.get("role").toString().equals("admin") || _childValue.get("role").toString().equals("moderator")) {
											premium = false;
											vip = false;
											developer = false;
											main = true;
										}
									}
								}
							}
						}
					}
					if (_childValue.containsKey("projects")) {
						projects = _childValue.get("projects").toString();
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
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		users.addChildEventListener(_users_child_listener);
		
		_data1_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				pr.add(_childKey);
				profile = true;
				No_2 = true;
				gridmap1.add((int)0, _childValue);
				listmap2.add((int)0, _childValue);
				_new_grid();
				if (_childValue.containsKey("editor")) {
					if (_childValue.get("editor").toString().equals("true")) {
						gridmap2.add((int)0, _childValue);
						_popular_grid();
					}
				}
				if (_childValue.containsKey("open")) {
					if (_childValue.get("open").toString().equals("true")) {
						gridmap3.add((int)0, _childValue);
						_editor_grid();
					}
				}
				data.edit().putString("data1", new Gson().toJson(listmap2)).commit();
				listview2.setAdapter(new Listview2Adapter(listmap2));
				((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
				/*
Collections.reverse(gridmap1);
Collections.reverse(gridmap3); */
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				n = 0;
				for(int _repeat375 = 0; _repeat375 < (int)(gridmap1.size()); _repeat375++) {
					if (gridmap1.get((int)n).get("key").toString().equals(_childKey)) {
						gridmap1.remove((int)(n));
						gridmap1.add((int)n, _childValue);
					}
					n++;
				}
				_new_grid();
				if (_childValue.containsKey("editor")) {
					if (_childValue.get("editor").toString().equals("true")) {
						n = 0;
						for(int _repeat440 = 0; _repeat440 < (int)(gridmap3.size()); _repeat440++) {
							if (gridmap3.get((int)n).get("key").toString().equals(_childKey)) {
								gridmap3.remove((int)(n));
								gridmap3.add((int)n, _childValue);
							}
							n++;
						}
					}
					_popular_grid();
				}
				if (_childValue.containsKey("open")) {
					if (_childValue.get("open").toString().equals("true")) {
						n = 0;
						for(int _repeat418 = 0; _repeat418 < (int)(gridmap3.size()); _repeat418++) {
							if (gridmap3.get((int)n).get("key").toString().equals(_childKey)) {
								gridmap3.remove((int)(n));
								gridmap3.add((int)n, _childValue);
							}
							n++;
						}
					}
					_editor_grid();
				}
				n = 0;
				for(int _repeat460 = 0; _repeat460 < (int)(listmap2.size()); _repeat460++) {
					if (listmap2.get((int)n).get("key").toString().equals(_childKey)) {
						listmap2.remove((int)(n));
						listmap2.add((int)n, _childValue);
					}
					n++;
				}
				data.edit().putString("data1", new Gson().toJson(listmap2)).commit();
				listview2.setAdapter(new Listview2Adapter(listmap2));
				((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				n = 0;
				for(int _repeat175 = 0; _repeat175 < (int)(gridmap1.size()); _repeat175++) {
					if (gridmap1.get((int)n).get("key").toString().equals(_childKey)) {
						gridmap1.remove((int)(n));
						listmap2.remove((int)(n));
					}
					n++;
				}
				_new_grid();
				if (_childValue.containsKey("open")) {
					if (_childValue.get("open").toString().equals("true")) {
						n = 0;
						for(int _repeat55 = 0; _repeat55 < (int)(gridmap3.size()); _repeat55++) {
							if (gridmap3.get((int)n).get("key").toString().equals(_childKey)) {
								gridmap3.remove((int)(n));
							}
							n++;
						}
					}
					_editor_grid();
				}
				if (_childValue.containsKey("editor")) {
					if (_childValue.get("editor").toString().equals("true")) {
						n = 0;
						for(int _repeat139 = 0; _repeat139 < (int)(gridmap3.size()); _repeat139++) {
							if (gridmap3.get((int)n).get("key").toString().equals(_childKey)) {
								gridmap3.remove((int)(n));
							}
							n++;
						}
					}
					_popular_grid();
				}
				data.edit().putString("data1", new Gson().toJson(listmap2)).commit();
				listview2.setAdapter(new Listview2Adapter(listmap2));
				((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		data1.addChildEventListener(_data1_child_listener);
		
		_admin_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				No_4 = true;
				if (_childKey.equals("general")) {
					if (_childValue.containsKey("radar")) {
						if (_childValue.get("radar").toString().equals("disabled")) {
							view_upd.setClass(getApplicationContext(), UpdateActivity.class);
							view_upd.putExtra("url", _childValue.get("url").toString());
							view_upd.putExtra("updates", _childValue.get("updates").toString());
							view_upd.putExtra("dr_link", _childValue.get("direct_link").toString());
							view_upd.putExtra("version", _childValue.get("version").toString());
							startActivity(view_upd);
							SketchwareUtil.showMessage(getApplicationContext(), "Update Required!");
							finish();
						}
					}
					if (_childValue.containsKey("update")) {
						if (_childValue.get("update").toString().equals("available")) {
							dialog.setTitle("Changes In Sketfify");
							dialog.setMessage("A Small Changes have Been Added in Sketify, If you want to Enjou that Small Small Change Click GO else Continue By Clicking LATER");
							dialog.setPositiveButton("GO", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									view_go.setAction(Intent.ACTION_VIEW);
									view_go.setData(Uri.parse("https://project.sketchub.in/?id=2372"));
									startActivity(view_go);
								}
							});
							dialog.setNegativeButton("LATER", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									
								}
							});
							dialog.create().show();
						}
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("general")) {
					if (_childValue.containsKey("radar")) {
						if (_childValue.get("radar").toString().equals("disabled")) {
							view_upd.setClass(getApplicationContext(), UpdateActivity.class);
							view_upd.putExtra("url", _childValue.get("url").toString());
							view_upd.putExtra("updates", _childValue.get("updates").toString());
							view_upd.putExtra("dr_link", _childValue.get("direct_link").toString());
							view_upd.putExtra("version", _childValue.get("version").toString());
							startActivity(view_upd);
							SketchwareUtil.showMessage(getApplicationContext(), "Update Required!");
							finish();
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
				if (_childKey.equals("general")) {
					if (_childValue.containsKey("radar")) {
						if (_childValue.get("radar").toString().equals("disabled")) {
							view_upd.setClass(getApplicationContext(), UpdateActivity.class);
							view_upd.putExtra("url", _childValue.get("url").toString());
							view_upd.putExtra("updates", _childValue.get("updates").toString());
							view_upd.putExtra("dr_link", _childValue.get("direct_link").toString());
							view_upd.putExtra("version", _childValue.get("version").toString());
							startActivity(view_upd);
							SketchwareUtil.showMessage(getApplicationContext(), "Update Required!");
							finish();
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
		admin.addChildEventListener(_admin_child_listener);
		
		_news_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				No_3 = true;
				newsmap.add((int)0, _childValue);
				if (!news_keys.contains(_childKey)) {
					news_keys.add((int)(0), _childKey);
					news_dot.setVisibility(View.VISIBLE);
					textview7.setTranslationY((float)(-9));
					imageview9.setTranslationY((float)(-9));
				}
				else {
					news_dot.setVisibility(View.GONE);
					textview7.setTranslationY((float)(0));
					imageview9.setTranslationY((float)(0));
				}
				listview4.setAdapter(new Listview4Adapter(newsmap));
				((BaseAdapter)listview4.getAdapter()).notifyDataSetChanged();
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				for(int _repeat287 = 0; _repeat287 < (int)(newsmap.size()); _repeat287++) {
					if (newsmap.get((int)n).get("key").toString().equals(_childKey)) {
						newsmap.remove((int)(n));
						newsmap.add((int)n, _childValue);
					}
					n++;
				}
				listview4.setAdapter(new Listview4Adapter(newsmap));
				((BaseAdapter)listview4.getAdapter()).notifyDataSetChanged();
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				n = 0;
				for(int _repeat19 = 0; _repeat19 < (int)(newsmap.size()); _repeat19++) {
					if (newsmap.get((int)n).get("key").toString().equals(_childKey)) {
						newsmap.remove((int)(n));
					}
					n++;
				}
				listview4.setAdapter(new Listview4Adapter(newsmap));
				((BaseAdapter)listview4.getAdapter()).notifyDataSetChanged();
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		news.addChildEventListener(_news_child_listener);
		
		_Net_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				_refresh();
				if (_response.contains("news set true")) {
					omTes = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									news_dot.setVisibility(View.VISIBLE);
									imageview9.setTranslationY((float)(-5));
									textview7.setTranslationY((float)(-5));
								}
							});
						}
					};
					_timer.schedule(omTes, (int)(1000));
				}
				else {
					news_dot.setVisibility(View.GONE);
					imageview9.setTranslationY((float)(0));
					textview7.setTranslationY((float)(0));
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
				layouts_main.setVisibility(View.GONE);
				progress.setVisibility(View.VISIBLE);
				_fab.setVisibility(View.GONE);
				
				final AlertDialog error_dialog = new AlertDialog.Builder(HomeActivity.this).create();
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
					}});
				e_cancel.setOnClickListener(new View.OnClickListener(){
					    public void onClick(View v){
						error_dialog.dismiss();
					}});
				error_dialog.show();
				_bounce(e_header);
			}
		};
		
		_NetonStart_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				linear1.setVisibility(View.VISIBLE);
				progress.setVisibility(View.GONE);
				_drawer_main.setVisibility(View.VISIBLE);
				_fab.show();
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
				((BaseAdapter)listview3.getAdapter()).notifyDataSetChanged();
				((BaseAdapter)listview4.getAdapter()).notifyDataSetChanged();
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
				linear1.setVisibility(View.GONE);
				progress.setVisibility(View.VISIBLE);
				_fab.hide();
				_drawer_main.setVisibility(View.INVISIBLE);
				
				final AlertDialog error_dialog = new AlertDialog.Builder(HomeActivity.this).create();
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
		};
		
		_reqnet_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				omTes = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_FabProgress(false);
								if (vip) {
									intent.setClass(getApplicationContext(), UploadActivity.class);
									intent.putExtra("mode", "project");
									startActivity(intent);
								}
								else {
									if (premium) {
										if ((50 < Double.parseDouble(projects)) || (50 == Double.parseDouble(projects))) {
											final AlertDialog error_dialog = new AlertDialog.Builder(HomeActivity.this).create();
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
											
											e_msg.setText("Project Limit Reached For Premium Account, Buy VIP Account For Your Unlimited Project Slots & 90% Increased Higher Project Verfication System & Free 2 Months Promotion System.");
											e_ok.setOnClickListener(new View.OnClickListener(){
												    public void onClick(View v){
													error_dialog.dismiss();
												}});
											e_cancel.setOnClickListener(new View.OnClickListener(){
												    public void onClick(View v){
													error_dialog.dismiss();
												}});
											error_dialog.show();
											_bounce(e_header);
										}
										else {
											intent.setClass(getApplicationContext(), UploadActivity.class);
											intent.putExtra("mode", "project");
											startActivity(intent);
										}
									}
									else {
										if (developer) {
											if ((10 < Double.parseDouble(projects)) || (10 == Double.parseDouble(projects))) {
												final AlertDialog error_dialog = new AlertDialog.Builder(HomeActivity.this).create();
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
												
												e_msg.setText("Project Limit Reached For Your Free Developer Account, Buy VIP (or) Premium Account Now To Access More Features");
												e_ok.setOnClickListener(new View.OnClickListener(){
													    public void onClick(View v){
														error_dialog.dismiss();
													}});
												e_cancel.setOnClickListener(new View.OnClickListener(){
													    public void onClick(View v){
														error_dialog.dismiss();
													}});
												error_dialog.show();
												_bounce(e_header);
											}
											else {
												intent.setClass(getApplicationContext(), UploadActivity.class);
												intent.putExtra("mode", "project");
												startActivity(intent);
											}
										}
										else {
											if (main) {
												intent.setClass(getApplicationContext(), UploadActivity.class);
												intent.putExtra("mode", "project");
												startActivity(intent);
											}
											else {
												intent.setClass(getApplicationContext(), UploadActivity.class);
												intent.putExtra("mode", "project");
												startActivity(intent);
												SketchwareUtil.showMessage(getApplicationContext(), "Fake ID");
											}
										}
									}
								}
							}
						});
					}
				};
				_timer.schedule(omTes, (int)(1200));
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
				final AlertDialog error_dialog = new AlertDialog.Builder(HomeActivity.this).create();
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
				
				e_msg.setText("Server Connection Timed Out!, Network Error.");
				e_ok.setOnClickListener(new View.OnClickListener(){
					    public void onClick(View v){
						error_dialog.dismiss();
						
					}});
				e_cancel.setOnClickListener(new View.OnClickListener(){
					    public void onClick(View v){
						error_dialog.dismiss();
					}});
				error_dialog.show();
				_bounce(e_header);
			}
		};
		
		_drawer_pricings.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_drawer.closeDrawer(GravityCompat.START);
				prplans.setClass(getApplicationContext(), PricingsActivity.class);
				prplans.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(prplans);
			}
		});
		
		_drawer_share.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_drawer.closeDrawer(GravityCompat.START);
				shareApplication();
			}
		});
		
		_drawer_discord.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				diacord.setClass(getApplicationContext(), WebActivity.class);
				diacord.putExtra("url", "https://discord.gg/tENVnJc6Z5");
				startActivity(diacord);
			}
		});
		
		_drawer_rateus.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				rateus_gonon.setClass(getApplicationContext(), RatingsActivity.class);
				rateus_gonon.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(rateus_gonon);
			}
		});
		
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
		No_1 = false;
		No_2 = false;
		No_3 = false;
		No_4 = false;
			StrictMode.VmPolicy.Builder builder = 
						new StrictMode.VmPolicy.Builder(); 
						StrictMode.setVmPolicy(builder.build());
						if(Build.VERSION.SDK_INT>=24){ 
								    try{
												java.lang.reflect.Method m = 
										        StrictMode.class.getMethod(
												"disableDeathOnFileUriExposure"); 
										        m.invoke(null); 
										}
									catch(Exception e){ 
												showMessage(e.toString()); 
										} 
						}
		
		search_text.setVisibility(View.GONE);
		progress.setVisibility(View.VISIBLE);
		linear1.setVisibility(View.GONE);
		_drawer_main.setVisibility(View.GONE);
		_fab.hide();
		_rippleRoundStroke(profilee, "#FFFFFF", "#E0E0E0", 50, 3, "#FFFFFF");
		_rippleRoundStroke(appbar, "#FFFFFF", "#FFFFFF", 20, 0, "#FFFFFF");
		_SetView(layout1, "layout1");
		_OnCreate();
		category.add("Tools");
		category.add("UI & UX");
		category.add("Social");
		category.add("Videography");
		category.add("Bussiness");
		category.add("Books & References");
		category.add("Entertainment");
		category.add("Example & Tutorials");
		category.add("Games");
		category.add("Photography");
		category.add("Productivity");
		category.add("Music & Video");
		category.add("Multi - Device");
		category.add("Education");
		category.add("Communication");
		category.add("Others");
		listview3.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, category));
		((BaseAdapter)listview3.getAdapter()).notifyDataSetChanged();
		_Elevation(appbar, 7);
		_Elevation(navigation_linear, 8);
		listview1.setVerticalScrollBarEnabled(false);
		listview2.setVerticalScrollBarEnabled(false);
		listview3.setVerticalScrollBarEnabled(false);
		_Toolbar(false);
		_MakeDirectory();
		_extra();
		_ListviewProbablity();
		trash.setVisibility(View.VISIBLE);
		base.setVisibility(View.VISIBLE);
		tablayout.setVisibility(View.VISIBLE);
		_MakeDrawerItems();
	}
	
	@Override
	public void onBackPressed() {
		back++;
		if (back == 2) {
			back = 0;
			finishAffinity();
		}
		else {
			if (back == 1) {
				bck = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								back = 0;
							}
						});
					}
				};
				_timer.schedule(bck, (int)(1010));
				SketchwareUtil.showMessage(getApplicationContext(), "Tap again To exit!");
			}
			else {
				SketchwareUtil.showMessage(getApplicationContext(), "Tap again To exit!");
			}
		}
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
	
	
	public void _extra() {
	}
	private SpannableString spannable;
	private ProgressDialog prog;
	{
	}
	
	
	public void _ProgresbarShow(final String _title) {
		prog = new ProgressDialog(HomeActivity.this);
		prog.setMax(100);
		prog.setMessage(_title);
		prog.setIndeterminate(true);
		prog.setCancelable(false);
		prog.show();
	}
	
	
	public void _gd(final View _view, final double _numb, final String _color) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		gd.setCornerRadius((int)_numb);
		_view.setBackground(gd);
	}
	
	
	public void _priv_snap(final String _text) {
		
	}
	
	
	public void _moreblock(final double _pos) {
		mblock_publish.setTitle("Moreblock Name");
		final EditText m_edit = new EditText(HomeActivity.this);
		m_edit.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		m_edit.setText(temp_listmap2.get((int)_pos).get("name").toString());
		
		com.google.android.material.textfield.TextInputLayout textinput1 = new com.google.android.material.textfield.TextInputLayout(HomeActivity.this);
		textinput1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		textinput1.setPadding(25, 0, 25, 0);
		textinput1.addView(m_edit);
		mblock_publish.setView(textinput1);
		mblock_publish.setPositiveButton("Publish", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				mblock_name = m_edit.getText().toString();
				if (mblock_name.trim().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Title empty");
				}
				else {
					mblock_key = "";
					data_map = new HashMap<>();
					data_map.put("code", temp_listmap2.get((int)_pos).get("code").toString());
					data_map.put("title", mblock_name.trim());
					data_map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
					data_map.put("key", mblock_key);
					
					data_map.clear();
					SketchwareUtil.showMessage(getApplicationContext(), "Moreblock Published");
					mblock_name = "";
				}
			}
		});
		mblock_publish.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				
			}
		});
		mblock_publish.create().show();
	}
	
	
	public void _Toolbar(final boolean _v) {
		if (_v) {
			getSupportActionBar().show();
		}
		else {
			getSupportActionBar().hide();
		}
	}
	
	
	public void _new_grid() {
		GridView new_grid = new GridView(HomeActivity.this);
		
		new_grid.setLayoutParams(new GridView.LayoutParams(gridmap1.size()*(int)getDip(105), GridLayout.LayoutParams.WRAP_CONTENT));
				
		new_grid.setNumColumns(gridmap1.size());
					new_grid.setBackgroundColor(Color.WHITE);
				
		new_grid.setVerticalSpacing(4);
				
		new_grid.setHorizontalSpacing(4);
				
		new_grid.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
				
		new_grid.setAdapter(new Listview1Adapter(gridmap1));
		
		((BaseAdapter)new_grid.getAdapter()).notifyDataSetChanged();
		
		new_grid_line.removeAllViews();
		
		new_grid_line.addView(new_grid);
				
		new_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
						  @Override
						  public void onItemClick(AdapterView parent, View view, int _pos, long id) {
								
				
				intent.setClass(getApplicationContext(), ProjectViewActivity.class);
				
				intent.putExtra("key", gridmap1.get((int)_pos).get("key").toString());
				
				intent.putExtra("uid", gridmap1.get((int)_pos).get("uid").toString());
								intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				
				startActivity(intent);
				
				
			}
		});
	}
	
	
	public void _popular_grid() {
		GridView popular_grid = new GridView(HomeActivity.this);
		
		popular_grid.setLayoutParams(new GridView.LayoutParams(gridmap2.size()*(int)getDip(105), GridLayout.LayoutParams.WRAP_CONTENT));
				
		popular_grid.setNumColumns(gridmap2.size());
					popular_grid.setBackgroundColor(Color.WHITE);
				
		popular_grid.setVerticalSpacing(4);
				
		popular_grid.setHorizontalSpacing(4);
				
		popular_grid.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
				
		popular_grid.setAdapter(new Listview1Adapter(gridmap2));
		
		((BaseAdapter)popular_grid.getAdapter()).notifyDataSetChanged();
				
		popular_grid_line.removeAllViews();
		
		popular_grid_line.addView(popular_grid);
				
		popular_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
						  @Override
						  public void onItemClick(AdapterView parent, View view, int _pos, long id) {
				
				intent.setClass(getApplicationContext(), ProjectViewActivity.class);
								
				intent.putExtra("key", gridmap2.get((int)_pos).get("key").toString());
				
				intent.putExtra("uid", gridmap2.get((int)_pos).get("uid").toString());
								intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				
				startActivity(intent);
				
			}
		});
	}
	
	
	public void _editor_grid() {
		GridView editor_grid = new GridView(HomeActivity.this);
		
		editor_grid.setLayoutParams(new GridView.LayoutParams(gridmap3.size()*(int)getDip(105), GridLayout.LayoutParams.WRAP_CONTENT));
				
		editor_grid.setNumColumns(gridmap3.size());
					editor_grid.setBackgroundColor(Color.WHITE);
				
		editor_grid.setVerticalSpacing(4);
				
		editor_grid.setHorizontalSpacing(4);
				
		editor_grid.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
				
		editor_grid.setAdapter(new Listview1Adapter(gridmap3));
		
		((BaseAdapter)editor_grid.getAdapter()).notifyDataSetChanged();
		
		editor_grid_line.removeAllViews();
		
		editor_grid_line.addView(editor_grid);
				
		editor_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
						  @Override
						  public void onItemClick(AdapterView parent, View view, int _pos, long id) {
				
				intent.setClass(getApplicationContext(), ProjectViewActivity.class);
								
				intent.putExtra("key", gridmap3.get((int)_pos).get("key").toString());
				
				intent.putExtra("uid", gridmap3.get((int)_pos).get("uid").toString());
								intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				
				startActivity(intent);
				
			}
		});
	}
	
	
	public void _SortMap(final ArrayList<HashMap<String, Object>> _listMap, final String _key, final boolean _isNumber, final boolean _Ascending) {
		/*
final Object _keyObject = _key;
Collections.sort(_listMap, new Comparator<HashMap<String,Object>>(){
public int compare(HashMap<String,Object> _compareMap1, HashMap<String,Object> _compareMap2){
if (_isNumber) {
int _count1 = Integer.valueOf(_compareMap1.get(_key).toString());
int _count2 = Integer.valueOf(_compareMap2.get(_key).toString());
if (_Ascending) {
return _count1 < _count2 ? -1 : _count1 < _count2 ? 1 : 0;
}
else {
return _count1 > _count2 ? -1 : _count1 > _count2 ? 1 : 0;
}
}
else {
if (_Ascending) {
return (_compareMap1.get(_key).toString()).compareTo(_compareMap2.get(_key).toString());
}
else {
return (_compareMap2.get(_key).toString()).compareTo(_compareMap1.get(_key).toString());
}
}
}});
///Use true or false blocks if sorting number of listmap
*/
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
			View _view = getLayoutInflater().inflate(R.layout.custom_dialog, null);
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
		new_seemore.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_bold.ttf"), 1);
		popular_seemore.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_bold.ttf"), 1);
		editor_seemore.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_bold.ttf"), 1);
	}
	
	
	public void _OnCreate() {
		back = 0;
		_rippleRoundStroke(editor_gridlayout, "#FFFFFF", "#E0E0E0", 10, 0, "#536DFE");
		_rippleRoundStroke(popular_gridlayout, "#FFFFFF", "#E0E0E0", 10, 0, "#536DFE");
		_rippleRoundStroke(new_gridlayout, "#FFFFFF", "#E0E0E0", 10, 0, "#536DFE");
		_rippleRoundStroke(editor_seemore, "#FFFFFF", "#E0E0E0", 0, 0, "#536DFE");
		_rippleRoundStroke(new_seemore, "#FFFFFF", "#E0E0E0", 0, 0, "#536DFE");
		_rippleRoundStroke(popular_seemore, "#FFFFFF", "#E0E0E0", 0, 0, "#536DFE");
		_rippleRoundStroke(toolbar, "#FFFFFF", "#FFFFFF", 20, 0, "#FFFFFF");
		_removeScollBar(listview3);
		_removeScollBar(listview4);
		_Elevation(navigation_linear, 10);
		
		final androidx.swiperefreshlayout.widget.SwipeRefreshLayout sl = new androidx.swiperefreshlayout.widget.SwipeRefreshLayout(HomeActivity.this);
		sl.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT, android.widget.LinearLayout.LayoutParams.MATCH_PARENT));
		sl.setColorSchemeResources(R.color.colorAccent);
		layout1.removeView(vscroll1);
		sl.addView(vscroll1);
		layout1.addView(sl);
		
		
		
		
		sl.setOnRefreshListener(new androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				sl.setRefreshing(false);
				
				
				restart.setClass(getApplicationContext(), HomeActivity.class);
				startActivity(restart);
				finish();
				
				overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
				
			}
		} );
		
		
		file.edit().remove("picked_path").commit();
		file.edit().putString("picked_path", "").commit();
		if (user.getString("new", "").equals("")) {
			new_gridlayout.setVisibility(View.VISIBLE);
			user.edit().putString("new", "true").commit();
		}
		if (user.getString("popular", "").equals("")) {
			popular_gridlayout.setVisibility(View.VISIBLE);
			user.edit().putString("popular", "true").commit();
		}
		if (user.getString("verified", "").equals("")) {
			editor_gridlayout.setVisibility(View.VISIBLE);
			user.edit().putString("verified", "true").commit();
		}
		if (user.getString("new", "").equals("true")) {
			new_gridlayout.setVisibility(View.VISIBLE);
		}
		else {
			new_gridlayout.setVisibility(View.GONE);
		}
		if (user.getString("popular", "").equals("true")) {
			popular_gridlayout.setVisibility(View.VISIBLE);
		}
		else {
			popular_gridlayout.setVisibility(View.GONE);
		}
		if (user.getString("verified", "").equals("true")) {
			editor_gridlayout.setVisibility(View.VISIBLE);
		}
		else {
			editor_gridlayout.setVisibility(View.GONE);
		}
		transferdata.edit().putString("tranfer", "no").commit();
		export.edit().putString("exported", "false").commit();
		
		// Make Fab Gone When Scroll
		
		  goTop = true;
		
		
		goBottom = false;
		
		listview2.setOnScrollListener(new AbsListView.OnScrollListener()
		{
			
			private int one;
			
			// one
			 @Override public void onScrollStateChanged(AbsListView view, int scrollState){
				
				
				if (listview2.getLastVisiblePosition() == listview2.getAdapter().getCount() -1 && listview2.getChildAt(listview2.getChildCount() - 1).getBottom() <= listview2.getHeight()){
					
				}
				
			}
			 // end one
			
			 @Override public void onScroll(AbsListView view, int two, int visible_items, int total_item)
			{
				if(one<two){
					
					if (goTop) {
						
						goBottom = true;
						
						goTop = false;
						_fab.hide();
						
					}
				} if(one>two)
				{
					
					
					  
					
					
					if (goBottom) {
						
						goBottom = false;
						
						goTop = true;
						_fab.show();
						
						
					}
				}
				one=two; 
				
				     }
			
		});
		
		
		
		android.graphics.drawable.GradientDrawable G1 = new android.graphics.drawable.GradientDrawable();
		G1.setColor(Color.parseColor("#FFFFFF"));
		G1.setCornerRadius((float)20);
		G1.setStroke((int) 0,
		Color.parseColor("#" + "#3F51B5".replace("#", "")));
		android.graphics.drawable.RippleDrawable R1 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#BDBDBD")}), G1, null);
		_drawer_blog.setBackground(R1);
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor("#FFFFFF"));
		GG.setCornerRadius((float)20);
		GG.setStroke((int) 0,
		Color.parseColor("#" + "#3F51B5".replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#BDBDBD")}), GG, null);
		_drawer_settings.setBackground(RE);
		android.graphics.drawable.GradientDrawable G2 = new android.graphics.drawable.GradientDrawable();
		G2.setColor(Color.parseColor("#FFFFFF"));
		G2.setCornerRadius((float)20);
		G2.setStroke((int) 0,
		Color.parseColor("#" + "#3F51B5".replace("#", "")));
		android.graphics.drawable.RippleDrawable R2 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#BDBDBD")}), G2, null);
		_drawer_community.setBackground(R2);
		android.graphics.drawable.GradientDrawable y = new android.graphics.drawable.GradientDrawable();
		y.setColor(Color.parseColor("#FFFFFF"));
		y.setCornerRadius((float)20);
		y.setStroke((int) 0,
		Color.parseColor("#" + "#3F51B5".replace("#", "")));
		android.graphics.drawable.RippleDrawable Ry = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#BDBDBD")}), y, null);
		_drawer_rateus.setBackground(Ry);
		android.graphics.drawable.GradientDrawable G = new android.graphics.drawable.GradientDrawable();
		G.setColor(Color.parseColor("#FFFFFF"));
		G.setCornerRadius((float)20);
		G.setStroke((int) 0,
		Color.parseColor("#" + "#3F51B5".replace("#", "")));
		android.graphics.drawable.RippleDrawable R3 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#BDBDBD")}), G, null);
		_drawer_codes.setBackground(R3);
		android.graphics.drawable.GradientDrawable G4 = new android.graphics.drawable.GradientDrawable();
		G4.setColor(Color.parseColor("#FFFFFF"));
		G4.setCornerRadius((float)20);
		G4.setStroke((int) 0,
		Color.parseColor("#" + "#3F51B5".replace("#", "")));
		android.graphics.drawable.RippleDrawable R4 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#BDBDBD")}), G4, null);
		_drawer_about_us.setBackground(R4);
		android.graphics.drawable.GradientDrawable G5 = new android.graphics.drawable.GradientDrawable();
		G5.setColor(Color.parseColor("#FFFFFF"));
		G5.setCornerRadius((float)20);
		G5.setStroke((int) 0,
		Color.parseColor("#" + "#3F51B5".replace("#", "")));
		android.graphics.drawable.RippleDrawable R5 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#BDBDBD")}), G5, null);
		_drawer_profile.setBackground(R5);
		android.graphics.drawable.GradientDrawable G6 = new android.graphics.drawable.GradientDrawable();
		G6.setColor(Color.parseColor("#FFFFFF"));
		G6.setCornerRadius((float)20);
		G6.setStroke((int) 0,
		Color.parseColor("#" + "#3F51B5".replace("#", "")));
		android.graphics.drawable.RippleDrawable R6 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#BDBDBD")}), G6, null);
		_drawer_linear1.setBackground(R6);
		android.graphics.drawable.GradientDrawable G7 = new android.graphics.drawable.GradientDrawable();
		G7.setColor(Color.parseColor("#FFFFFF"));
		G7.setCornerRadius((float)20);
		G7.setStroke((int) 0,
		Color.parseColor("#" + "#3F51B5".replace("#", "")));
		android.graphics.drawable.RippleDrawable R7 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#BDBDBD")}), G7, null);
		_drawer_p_manage.setBackground(R7);
		android.graphics.drawable.GradientDrawable G8 = new android.graphics.drawable.GradientDrawable();
		G8.setColor(Color.parseColor("#FFFFFF"));
		G8.setCornerRadius((float)20);
		G8.setStroke((int) 0,
		Color.parseColor("#" + "#3F51B5".replace("#", "")));
		android.graphics.drawable.RippleDrawable R8 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#BDBDBD")}), G8, null);
		_drawer_yt_logo.setBackground(R8);
		android.graphics.drawable.GradientDrawable G9 = new android.graphics.drawable.GradientDrawable();
		G9.setColor(Color.parseColor("#FFFFFF"));
		G9.setCornerRadius((float)20);
		G9.setStroke((int) 0,
		Color.parseColor("#" + "#3F51B5".replace("#", "")));
		android.graphics.drawable.RippleDrawable R9 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#BDBDBD")}), G9, null);
		_drawer_web_logo.setBackground(R9);
		android.graphics.drawable.GradientDrawable G10 = new android.graphics.drawable.GradientDrawable();
		G10.setColor(Color.parseColor("#FFFFFF"));
		G10.setCornerRadius((float)20);
		G10.setStroke((int) 0,
		Color.parseColor("#" + "#3F51B5".replace("#", "")));
		android.graphics.drawable.RippleDrawable R10 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#BDBDBD")}), G10, null);
		_drawer_twitter_logo.setBackground(R10);
		android.graphics.drawable.GradientDrawable G11 = new android.graphics.drawable.GradientDrawable();
		G11.setColor(Color.parseColor("#FFFFFF"));
		G11.setCornerRadius((float)20);
		G11.setStroke((int) 0,
		Color.parseColor("#" + "#3F51B5".replace("#", "")));
		android.graphics.drawable.RippleDrawable R11 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#BDBDBD")}), G11, null);
		_drawer_share.setBackground(R11);
		android.graphics.drawable.GradientDrawable G12 = new android.graphics.drawable.GradientDrawable();
		G12.setColor(Color.parseColor("#FFFFFF"));
		G12.setCornerRadius((float)20);
		G12.setStroke((int) 0,
		Color.parseColor("#" + "#3F51B5".replace("#", "")));
		android.graphics.drawable.RippleDrawable R12 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#BDBDBD")}), G12, null);
		_drawer_pricings.setBackground(R12);
		android.graphics.drawable.GradientDrawable G13 = new android.graphics.drawable.GradientDrawable();
		G13.setColor(Color.parseColor("#FFFFFF"));
		G13.setCornerRadius((float)20);
		G13.setStroke((int) 0,
		Color.parseColor("#" + "#3F51B5".replace("#", "")));
		android.graphics.drawable.RippleDrawable R13 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#BDBDBD")}), G13, null);
		_drawer_discord.setBackground(R13);
		android.graphics.drawable.GradientDrawable G14 = new android.graphics.drawable.GradientDrawable();
		G14.setColor(Color.parseColor("#EEEEEE"));
		G14.setCornerRadius((float)20);
		G14.setStroke((int) 3,
		Color.parseColor("#" + "#3F51B5".replace("#", "")));
		android.graphics.drawable.RippleDrawable R14 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#BDBDBD")}), G14, null);
		_drawer_linear1.setBackground(R14);
		
		// Copied From Sketify!
		if (!FileUtil.isExistFile("/Android/data/com.sketify.msk/Read Me.txt")) {
			FileUtil.writeFile("/Sketify/Read Me.txt", "Warning.\nPlease Do Not Change or Delete Any Files In This Folder. if This Folder is Deleted, Sketify Will Not Run or Forcely Stoped or It May Cause Errors.");
		}
		if (!FileUtil.isExistFile("/Sketify/help.txt")) {
			FileUtil.writeFile("/Sketify/help.txt", "Note. \n\n~ SW Project Folder Will Have Sketchware Projects .sk files, There You can get the Exported projects of Sketchware  with that files.\n\n~ Downloads Folder will Have Downloaded Apk's From Sketify, (Sketchware Apk (or) Android Studio Apks).\n\n~ Android Studio Folder will Have Separated .zip Files Of Downloaded Android Studio Project in Sketify");
		}
		_rippleRoundStroke(home, "#FFFFFF", "#BDBDBD", 15, 0, "#FFFFFF");
		_rippleRoundStroke(allapps, "#FFFFFF", "#BDBDBD", 15, 0, "#FFFFFF");
		_rippleRoundStroke(newss, "#FFFFFF", "#BDBDBD", 15, 0, "#FFFFFF");
		_rippleRoundStroke(categoryy, "#FFFFFF", "#BDBDBD", 15, 0, "#FFFFFF");
		news_dot.setVisibility(View.GONE);
		imageview9.setTranslationY((float)(0));
		textview7.setTranslationY((float)(0));
		_CheckCaptcha();
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
		gd.setStroke(0, Color.WHITE); /* stroke heigth and color */
		_view.setBackground(gd);
	}
	
	
	public void _removeScollBar(final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
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
	
	
	public void _refresh() {
		imageview_logo.setVisibility(View.VISIBLE);
		search_text.setVisibility(View.GONE);
		imageview_logo.setAlpha((float)(1));
		search_text.setAlpha((float)(0));
		control = false;
		linear1.setVisibility(View.GONE);
		progress.setVisibility(View.VISIBLE);
		_drawer_main.setVisibility(View.GONE);
		_fab.hide();
		data_load = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (No_1 && (No_2 && (No_3 && No_4))) {
							data_load.cancel();
							linear1.setVisibility(View.VISIBLE);
							progress.setVisibility(View.GONE);
							_drawer_main.setVisibility(View.VISIBLE);
							_fab.show();
							control = true;
							_CheckControl();
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(data_load, (int)(5000), (int)(50));
	}
	
	
	public void _CheckControl() {
		/*
search_text.setVisibility(View.GONE);
imageview_logo.setAlpha((float)(1));
imageview_logo.setVisibility(View.VISIBLE);
search_text.setAlpha((float)(0));
serch = new TimerTask() {
@Override
public void run() {
runOnUiThread(new Runnable() {
@Override
public void run() {
if (No_1 && (No_2 && (No_3 && No_4))) {
serch.cancel();
anim_logo1 = new TimerTask() {
@Override
public void run() {
runOnUiThread(new Runnable() {
@Override
public void run() {
ObjectAnimator anim1 = ObjectAnimator.ofFloat(imageview_logo, "Alpha", 1, 0);
anim1.setDuration(2650);
anim1.start();
anim_logo2 = new TimerTask() {
@Override
public void run() {
runOnUiThread(new Runnable() {
@Override
public void run() {
ObjectAnimator anim = ObjectAnimator.ofFloat(search_text, "Alpha", 0, 1);
anim.setDuration(2500);
anim.start();
t = new TimerTask() {
@Override
public void run() {
runOnUiThread(new Runnable() {
@Override
public void run() {
anim_logo1.cancel();
anim_logo2.cancel();
t.cancel();
search_text.setVisibility(View.VISIBLE);
search_text.setAlpha((float)(1));
imageview_logo.setAlpha((float)(0));
imageview_logo.setVisibility(View.GONE);
control = true;
}
});
}
};
_timer.schedule(t, (int)(688));
}
});
}
};
_timer.schedule(anim_logo2, (int)(2600));
}
});
}
};
_timer.schedule(anim_logo1, (int)(2000));
}
}
});
}
};
_timer.scheduleAtFixedRate(serch, (int)(999), (int)(250));
*/
		this.imageview_logo.setVisibility(0);
		
		this.search_text.setVisibility(8);
		
		this.imageview_logo.setAlpha(1.0f);
		
		this.search_text.setAlpha(0.0f);
		
		this.t = new TimerTask() {
			
			public void run() {
				
				HomeActivity.this.runOnUiThread(new Runnable() {
					
					public void run() {
						
						HomeActivity.this.oa_title.setTarget(imageview_logo);
						
						HomeActivity.this.oa_title.setPropertyName("alpha");
						
						HomeActivity.this.oa_title.setFloatValues(new float[]{1.0f, 0.0f});
						
						HomeActivity.this.oa_title.setDuration(1000);
						
						HomeActivity.this.oa_title.setInterpolator(new LinearInterpolator());
						
						HomeActivity.this.oa_title.start();
						
						HomeActivity.this.t = new TimerTask() {
							
							public void run() {
								
								HomeActivity.this.runOnUiThread(new Runnable() {
									
									public void run() {
										
										HomeActivity.this.imageview_logo.setVisibility(8);
										
										HomeActivity.this.search_text.setVisibility(0);
										
										HomeActivity.this.oa_title.setTarget(search_text);
										
										HomeActivity.this.oa_title.setPropertyName("alpha");
										
										HomeActivity.this.oa_title.setFloatValues(new float[]{0.0f, 1.0f});
										
										HomeActivity.this.oa_title.setDuration(800);
										
										HomeActivity.this.oa_title.setInterpolator(new LinearInterpolator());
										
										HomeActivity.this.oa_title.start();
										
									}
									
								});
								
							}
							
						};
						
						HomeActivity.this._timer.schedule(HomeActivity.this.t, 1100);
						
					}
					
				});
				
			}
			
		};
		
		this._timer.schedule(this.t, 3000);
		
		
		control = true;
	}
	
	
	public void _library() {
	}
	public static abstract class Animation {
			public static final int DIRECTION_LEFT = 1;
			public static final int DIRECTION_RIGHT = 2;
			public static final int DIRECTION_UP = 3;
			public static final int DIRECTION_DOWN = 4;
			public static final int DURATION_DEFAULT = 300; // 300 ms
			public static final int DURATION_SHORT = 100;	// 100 ms
			public static final int DURATION_LONG = 500;	// 500 ms
			View view;
			public abstract void animate();
	}
	
	
	public interface AnimationListener {
			public void onAnimationEnd(Animation animation);
	}
	
	
	
	public interface Combinable {
			public void animate();
			public AnimatorSet getAnimatorSet();
			public Animation setInterpolator(TimeInterpolator interpolator);
			public long getDuration();
			public Animation setDuration(long duration);
			public Animation setListener(AnimationListener listener);
	}
	
	
	public class BlindAnimation extends Animation {
			TimeInterpolator interpolator;
			long duration;
			AnimationListener listener;
			public BlindAnimation(View view) {
					this.view = view;
					interpolator = new AccelerateDecelerateInterpolator();
					duration = DURATION_LONG;
					listener = null;
			}
			@Override
			public void animate() {
					final ViewGroup parent = (ViewGroup) view.getParent(), animationLayout = new FrameLayout(view.getContext());
					final int positionView = parent.indexOfChild(view);
					animationLayout.setLayoutParams(view.getLayoutParams());
					parent.removeView(view);
					animationLayout.addView(view);
					parent.addView(animationLayout, positionView);
					final float originalScaleY = view.getScaleY();
					ObjectAnimator scaleY = ObjectAnimator.ofFloat(animationLayout,
							View.SCALE_Y, 0f), scaleY_child = ObjectAnimator.ofFloat(view,
							View.SCALE_Y, 2.5f);
					animationLayout.setPivotX(1f);
					animationLayout.setPivotY(1f);
					view.setPivotX(1f);
					view.setPivotY(1f);
					AnimatorSet blindAnimationSet = new AnimatorSet();
					blindAnimationSet.playTogether(scaleY, scaleY_child);
					blindAnimationSet.setInterpolator(interpolator);
					blindAnimationSet.setDuration(duration / 2);
					blindAnimationSet.addListener(new AnimatorListenerAdapter() {
							@Override
							public void onAnimationEnd(Animator animation) {
									view.setVisibility(View.INVISIBLE);
									view.setScaleY(originalScaleY);
									animationLayout.removeAllViews();
									parent.removeView(animationLayout);
									if (animationLayout.getLayoutParams() != null) {
						                    			parent.addView(view, positionView, animationLayout.getLayoutParams());
						                	}else{
											parent.addView(view, positionView);
						                	}
									if (getListener() != null) {
											getListener().onAnimationEnd(BlindAnimation.this);
									}
							}
					});
					blindAnimationSet.start();
			}
			public TimeInterpolator getInterpolator() {
					return interpolator;
			}
			public BlindAnimation setInterpolator(TimeInterpolator interpolator) {
					this.interpolator = interpolator;
					return this;
			}
			public long getDuration() {
					return duration;
			}
			public BlindAnimation setDuration(long duration) {
					this.duration = duration;
					return this;
			}
			public AnimationListener getListener() {
					return listener;
			}
			public BlindAnimation setListener(AnimationListener listener) {
					this.listener = listener;
					return this;
			}
	}
	
	
	public class BlinkAnimation extends Animation {
			int numOfBlinks, blinkCount = 0;
			TimeInterpolator interpolator;
			long duration;
			AnimationListener listener;
			public BlinkAnimation(View view) {
					this.view = view;
					numOfBlinks = 2;
					interpolator = new AccelerateDecelerateInterpolator();
					duration = DURATION_LONG;
					listener = null;
			}
			@Override
			public void animate() {
					long singleBlinkDuration = duration / numOfBlinks / 2;
					if (singleBlinkDuration == 0)
						singleBlinkDuration = 1;
					ObjectAnimator fadeOut = ObjectAnimator.ofFloat(view, View.ALPHA, 0), fadeIn = ObjectAnimator
							.ofFloat(view, View.ALPHA, 1);
					final AnimatorSet blinkAnim = new AnimatorSet();
					blinkAnim.playSequentially(fadeOut, fadeIn);
					blinkAnim.setInterpolator(interpolator);
					blinkAnim.setDuration(singleBlinkDuration);
					blinkAnim.addListener(new AnimatorListenerAdapter() {
							@Override
							public void onAnimationEnd(Animator animation) {
									blinkCount++;
									if (blinkCount == numOfBlinks) {
											if (getListener() != null) {
													getListener().onAnimationEnd(BlinkAnimation.this);
											}
									} else {
											blinkAnim.start();
									}
							}
					});
					blinkAnim.start();
			}
			public int getNumOfBlinks() {
					return numOfBlinks;
			}
			public BlinkAnimation setNumOfBlinks(int numOfBlinks) {
					this.numOfBlinks = numOfBlinks;
					return this;
			}
			public TimeInterpolator getInterpolator() {
					return interpolator;
			}
			public BlinkAnimation setInterpolator(TimeInterpolator interpolator) {
					this.interpolator = interpolator;
					return this;
			}
			public long getDuration() {
					return duration;
			}
			public BlinkAnimation setDuration(long duration) {
					this.duration = duration;
					return this;
			}
			public AnimationListener getListener() {
					return listener;
			}
			public BlinkAnimation setListener(AnimationListener listener) {
					this.listener = listener;
					return this;
			}
	}
	
	
	public class BounceAnimation extends Animation {
			float bounceDistance;
			int numOfBounces, bounceCount = 0;
			TimeInterpolator interpolator;
			long duration;
			AnimationListener listener;
			public BounceAnimation(View view) {
					this.view = view;
					bounceDistance = 20;
					numOfBounces = 2;
					interpolator = new AccelerateDecelerateInterpolator();
					duration = DURATION_LONG;
					listener = null;
			}
			@Override
			public void animate() {
					long singleBounceDuration = duration / numOfBounces / 4;
					if (singleBounceDuration == 0)
						singleBounceDuration = 1;
					final AnimatorSet bounceAnim = new AnimatorSet();
					bounceAnim.playSequentially(ObjectAnimator.ofFloat(view,
							View.TRANSLATION_Y, bounceDistance), ObjectAnimator.ofFloat(
							view, View.TRANSLATION_Y, -bounceDistance), ObjectAnimator
							.ofFloat(view, View.TRANSLATION_Y, bounceDistance),
							ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, 0));
					bounceAnim.setInterpolator(interpolator);
					bounceAnim.setDuration(singleBounceDuration);
					ViewGroup parentView = (ViewGroup) view.getParent(), rootView = (ViewGroup) view
							.getRootView();
					while (!parentView.equals(rootView)) {
							parentView.setClipChildren(false);
							parentView = (ViewGroup) parentView.getParent();
					}
					rootView.setClipChildren(false);
					bounceAnim.addListener(new AnimatorListenerAdapter() {
							@Override
							public void onAnimationEnd(Animator animation) {
									bounceCount++;
									if (bounceCount == numOfBounces) {
											if (getListener() != null) {
													getListener().onAnimationEnd(BounceAnimation.this);
											}
									} else {
											bounceAnim.start();
									}
							}
					});
					bounceAnim.start();
			}
			public float getBounceDistance() {
					return bounceDistance;
			}
			public BounceAnimation setBounceDistance(float bounceDistance) {
					this.bounceDistance = bounceDistance;
					return this;
			}
			public int getNumOfBounces() {
					return numOfBounces;
			}
			public BounceAnimation setNumOfBounces(int numOfBounces) {
					this.numOfBounces = numOfBounces;
					return this;
			}
			public TimeInterpolator getInterpolator() {
					return interpolator;
			}
			public BounceAnimation setInterpolator(TimeInterpolator interpolator) {
					this.interpolator = interpolator;
					return this;
			}
			public long getDuration() {
					return duration;
			}
			public BounceAnimation setDuration(long duration) {
					this.duration = duration;
					return this;
			}
			public AnimationListener getListener() {
					return listener;
			}
			public BounceAnimation setListener(AnimationListener listener) {
					this.listener = listener;
					return this;
			}
	}
	
	
	
	public static class ExplodeAnimation extends Animation {
			public final static int MATRIX_1X2 = 12;
			public final static int MATRIX_1X3 = 13;
			public final static int MATRIX_2X1 = 21;
			public final static int MATRIX_2X2 = 22;
			public final static int MATRIX_2X3 = 23;
			public final static int MATRIX_3X1 = 31;
			public final static int MATRIX_3X2 = 32;
			public final static int MATRIX_3X3 = 33;
			private int xParts, yParts;
			ViewGroup parentView;
			int matrix;
			TimeInterpolator interpolator;
			long duration;
			AnimationListener listener;
			public ExplodeAnimation(View view) {
					this.view = view;
					setExplodeMatrix(MATRIX_3X3);
					interpolator = new AccelerateDecelerateInterpolator();
					duration = DURATION_LONG;
					listener = null;
			}
			@Override
			public void animate() {
					final LinearLayout explodeLayout = new LinearLayout(view.getContext());
					LinearLayout[] layouts = new LinearLayout[yParts];
					parentView = (ViewGroup) view.getParent();
					explodeLayout.setLayoutParams(view.getLayoutParams());
					explodeLayout.setOrientation(LinearLayout.VERTICAL);
					explodeLayout.setClipChildren(false);
			
					view.setDrawingCacheEnabled(true);
					Bitmap viewBmp = view.getDrawingCache(true);
					int totalParts = xParts * yParts, bmpWidth = viewBmp.getWidth()
							/ xParts, bmpHeight = viewBmp.getHeight() / yParts, widthCount = 0, heightCount = 0, middleXPart = (xParts - 1) / 2;
					int[] translation = new int[2];
					ImageView[] imageViews = new ImageView[totalParts];
					for (int i = 0; i < totalParts; i++) {
							int translateX = 0, translateY = 0;
							if (i % xParts == 0) {
									if (i != 0)
										heightCount++;
									widthCount = 0;
									layouts[heightCount] = new LinearLayout(view.getContext());
									layouts[heightCount].setClipChildren(false);
									translation = sideTranslation(heightCount, bmpWidth, bmpHeight,
											xParts, yParts);
									translateX = translation[0];
									translateY = translation[1];
							} else if (i % xParts == xParts - 1) {
									translation = sideTranslation(heightCount, -bmpWidth,
											bmpHeight, xParts, yParts);
									translateX = translation[0];
									translateY = translation[1];
							} else {
									if (widthCount == middleXPart) {
											if (heightCount == 0) {
													translateX = 0;
													if (yParts != 1) {
															translateY = -bmpHeight;
													}
											} else if (heightCount == yParts - 1) {
													translateX = 0;
													translateY = bmpHeight;
											}
									}
							}
							if (xParts == 1) {
									translation = sideTranslation(heightCount, 0, bmpHeight,
											xParts, yParts);
									translateX = translation[0];
									translateY = translation[1];
							}
				
							imageViews[i] = new ImageView(view.getContext());
							imageViews[i]
									.setImageBitmap(Bitmap.createBitmap(viewBmp, bmpWidth
											* widthCount, bmpHeight * heightCount, bmpWidth,
											bmpHeight));
							imageViews[i].animate().translationXBy(translateX)
									.translationYBy(translateY).alpha(0)
									.setInterpolator(interpolator).setDuration(duration);
							layouts[heightCount].addView(imageViews[i]);
							widthCount++;
					}
					for (int i = 0; i < yParts; i++)
						explodeLayout.addView(layouts[i]);
					final int positionView = parentView.indexOfChild(view);
					parentView.removeView(view);
					parentView.addView(explodeLayout, positionView);
					ViewGroup rootView = (ViewGroup) explodeLayout.getRootView();
					while (!parentView.equals(rootView)) {
							parentView.setClipChildren(false);
							parentView = (ViewGroup) parentView.getParent();
					}
					rootView.setClipChildren(false);
					imageViews[0].animate().setListener(new AnimatorListenerAdapter() {
				
							@Override
							public void onAnimationEnd(Animator animation) {
									parentView = (ViewGroup) explodeLayout.getParent();
									view.setLayoutParams(explodeLayout.getLayoutParams());
									view.setVisibility(View.INVISIBLE);
									parentView.removeView(explodeLayout);
									parentView.addView(view, positionView);
									if (getListener() != null) {
											getListener().onAnimationEnd(ExplodeAnimation.this);
									}
							}
					});
			}
			private int[] sideTranslation(int heightCount, int bmpWidth, int bmpHeight,
					int xParts, int yParts) {
					int[] translation = new int[2];
					int middleYPart = (yParts - 1) / 2;
					if (heightCount == 0) {
							translation[0] = -bmpWidth;
							translation[1] = -bmpHeight;
					} else if (heightCount == yParts - 1) {
							translation[0] = -bmpWidth;
							translation[1] = bmpHeight;
					}
					if (yParts % 2 != 0) {
							if (heightCount == middleYPart) {
									translation[0] = -bmpWidth;
									translation[1] = 0;
							}
					}
					return translation;
			}
			public int getExplodeMatrix() {
					return matrix;
			}
			public ExplodeAnimation setExplodeMatrix(int matrix) {
					this.matrix = matrix;
					xParts = matrix / 10;
					yParts = matrix % 10;
					return this;
			}
			public TimeInterpolator getInterpolator() {
					return interpolator;
			}
			public ExplodeAnimation setInterpolator(TimeInterpolator interpolator) {
					this.interpolator = interpolator;
					return this;
			}
			public long getDuration() {
					return duration;
			}
			public ExplodeAnimation setDuration(long duration) {
					this.duration = duration;
					return this;
			}
			public AnimationListener getListener() {
					return listener;
			}
			public ExplodeAnimation setListener(AnimationListener listener) {
					this.listener = listener;
					return this;
			}
	}
	
	
	public class FadeInAnimation extends Animation implements Combinable {
			TimeInterpolator interpolator;
			long duration;
			AnimationListener listener;
			public FadeInAnimation(View view) {
					this.view = view;
					interpolator = new AccelerateDecelerateInterpolator();
					duration = DURATION_LONG;
					listener = null;
			}
			@Override
			public void animate() {
					getAnimatorSet().start();
			}
			@Override
			public AnimatorSet getAnimatorSet() {
					view.setAlpha(0f);
					view.setVisibility(View.VISIBLE);
					AnimatorSet fadeSet = new AnimatorSet();
					fadeSet.play(ObjectAnimator.ofFloat(view, View.ALPHA, 1f));
					fadeSet.setInterpolator(interpolator);
					fadeSet.setDuration(duration);
					fadeSet.addListener(new AnimatorListenerAdapter() {
							@Override
							public void onAnimationEnd(Animator animation) {
									if (getListener() != null) {
											getListener().onAnimationEnd(FadeInAnimation.this);
									}
							}
					});
					return fadeSet;
			}
			public TimeInterpolator getInterpolator() {
					return interpolator;
			}
			public FadeInAnimation setInterpolator(TimeInterpolator interpolator) {
					this.interpolator = interpolator;
					return this;
			}
			public long getDuration() {
					return duration;
			}
			public FadeInAnimation setDuration(long duration) {
					this.duration = duration;
					return this;
			}
			public AnimationListener getListener() {
					return listener;
			}
			public FadeInAnimation setListener(AnimationListener listener) {
					this.listener = listener;
					return this;
			}
	}
	
	
	public class FadeOutAnimation extends Animation implements Combinable {
			TimeInterpolator interpolator;
			long duration;
			AnimationListener listener;
			public FadeOutAnimation(View view) {
					this.view = view;
					interpolator = new AccelerateDecelerateInterpolator();
					duration = DURATION_LONG;
					listener = null;
			}
			@Override
			public void animate() {
					getAnimatorSet().start();
			}
			@Override
			public AnimatorSet getAnimatorSet() {
					final float originalAlpha = view.getAlpha();
					AnimatorSet fadeSet = new AnimatorSet();
					fadeSet.play(ObjectAnimator.ofFloat(view, View.ALPHA, 0f));
					fadeSet.setInterpolator(interpolator);
					fadeSet.setDuration(duration);
					fadeSet.addListener(new AnimatorListenerAdapter() {
							@Override
							public void onAnimationEnd(Animator animation) {
									view.setVisibility(View.INVISIBLE);
									view.setAlpha(originalAlpha);
									if (getListener() != null) {
											getListener().onAnimationEnd(FadeOutAnimation.this);
									}
							}
					});
					return fadeSet;
			}
			public TimeInterpolator getInterpolator() {
					return interpolator;
			}
			public FadeOutAnimation setInterpolator(TimeInterpolator interpolator) {
					this.interpolator = interpolator;
					return this;
			}
			public long getDuration() {
					return duration;
			}
			public FadeOutAnimation setDuration(long duration) {
					this.duration = duration;
					return this;
			}
			public AnimationListener getListener() {
					return listener;
			}
			public FadeOutAnimation setListener(AnimationListener listener) {
					this.listener = listener;
					return this;
			}
	}
	
	
	public static class FlipHorizontalAnimation extends Animation implements Combinable {
			public static final int PIVOT_CENTER = 0, PIVOT_LEFT = 1, PIVOT_RIGHT = 2;
			float degrees;
			int pivot;
			TimeInterpolator interpolator;
			long duration;
			AnimationListener listener;
			public FlipHorizontalAnimation(View view) {
					this.view = view;
					degrees = 360;
					pivot = PIVOT_CENTER;
					interpolator = new AccelerateDecelerateInterpolator();
					duration = DURATION_LONG;
					listener = null;
			}
			@Override
			public void animate() {
					getAnimatorSet().start();
			}
			@Override
			public AnimatorSet getAnimatorSet() {
					ViewGroup parentView = (ViewGroup) view.getParent(), rootView = (ViewGroup) view
							.getRootView();
					while (parentView != rootView) {
							parentView.setClipChildren(false);
							parentView = (ViewGroup) parentView.getParent();
					}
					rootView.setClipChildren(false);
					float pivotX, pivotY, viewWidth = view.getWidth(), viewHeight = view
							.getHeight();
					switch (pivot) {
						case PIVOT_LEFT:
							pivotX = 0f;
							pivotY = viewHeight / 2;
							break;
						case PIVOT_RIGHT:
							pivotX = viewWidth;
							pivotY = viewHeight / 2;
							break;
						default:
							pivotX = viewWidth / 2;
							pivotY = viewHeight / 2;
							break;
					}
					view.setPivotX(pivotX);
					view.setPivotY(pivotY);
					AnimatorSet flipSet = new AnimatorSet();
					flipSet.play(ObjectAnimator.ofFloat(view, View.ROTATION_Y,
							view.getRotationY() + degrees));
					flipSet.setInterpolator(interpolator);
					flipSet.setDuration(duration);
					flipSet.addListener(new AnimatorListenerAdapter() {
							@Override
							public void onAnimationEnd(Animator animation) {
									if (getListener() != null) {
											getListener().onAnimationEnd(FlipHorizontalAnimation.this);
									}
							}
					});
					return flipSet;
			}
			public float getDegrees() {
					return degrees;
			}
			public FlipHorizontalAnimation setDegrees(float degrees) {
					this.degrees = degrees;
					return this;
			}
			public int getPivot() {
					return pivot;
			}
			public FlipHorizontalAnimation setPivot(int pivot) {
					this.pivot = pivot;
					return this;
			}
			public TimeInterpolator getInterpolator() {
					return interpolator;
			}
			public FlipHorizontalAnimation setInterpolator(TimeInterpolator interpolator) {
					this.interpolator = interpolator;
					return this;
			}
			public long getDuration() {
					return duration;
			}
			public FlipHorizontalAnimation setDuration(long duration) {
					this.duration = duration;
					return this;
			}
			public AnimationListener getListener() {
					return listener;
			}
			public FlipHorizontalAnimation setListener(AnimationListener listener) {
					this.listener = listener;
					return this;
			}
	}
	
	
	public static class FlipHorizontalToAnimation extends Animation {
			public static final int PIVOT_CENTER = 0, PIVOT_LEFT = 1, PIVOT_RIGHT = 2;
			View flipToView;
			int pivot, direction;
			TimeInterpolator interpolator;
			long duration;
			AnimationListener listener;
			public FlipHorizontalToAnimation(View view) {
					this.view = view;
					flipToView = null;
					pivot = PIVOT_CENTER;
					direction = DIRECTION_RIGHT;
					interpolator = new AccelerateDecelerateInterpolator();
					duration = DURATION_LONG;
					listener = null;
			}
			@Override
			public void animate() {
					ViewGroup parentView = (ViewGroup) view.getParent(), rootView = (ViewGroup) view
							.getRootView();
					float pivotX, pivotY, flipAngle = 270f, viewWidth = view.getWidth(), viewHeight = view
							.getHeight();
					final float originalRotationY = view.getRotationY();
					switch (pivot) {
						case PIVOT_LEFT:
							pivotX = 0f;
							pivotY = viewHeight / 2;
							break;
						case PIVOT_RIGHT:
							pivotX = viewWidth;
							pivotY = viewHeight / 2;
							break;
						default:
							pivotX = viewWidth / 2;
							pivotY = viewHeight / 2;
							flipAngle = 90f;
							break;
					}
					view.setPivotX(pivotX);
					view.setPivotY(pivotY);
					flipToView.setLayoutParams(view.getLayoutParams());
					flipToView.setLeft(view.getLeft());
					flipToView.setTop(view.getTop());
					flipToView.setPivotX(pivotX);
					flipToView.setPivotY(pivotY);
					flipToView.setVisibility(View.VISIBLE);
					while (parentView != rootView) {
							parentView.setClipChildren(false);
							parentView = (ViewGroup) parentView.getParent();
					}
					rootView.setClipChildren(false);
					AnimatorSet flipToAnim = new AnimatorSet();
					if (direction == DIRECTION_RIGHT) {
							flipToView.setRotationY(270f);
							flipToAnim.playSequentially(ObjectAnimator.ofFloat(view,
									View.ROTATION_Y, 0f, flipAngle), ObjectAnimator.ofFloat(
									flipToView, View.ROTATION_Y, 270f, 360f));
					} else {
							flipToView.setRotationY(-270f);
							flipToAnim.playSequentially(ObjectAnimator.ofFloat(view,
									View.ROTATION_Y, 0f, -flipAngle), ObjectAnimator.ofFloat(
									flipToView, View.ROTATION_Y, -270f, -360f));
					}
					flipToAnim.setInterpolator(interpolator);
					flipToAnim.setDuration(duration / 2);
					flipToAnim.addListener(new AnimatorListenerAdapter() {
							@Override
							public void onAnimationEnd(Animator animation) {
									view.setVisibility(View.INVISIBLE);
									view.setRotationY(originalRotationY);
									if (getListener() != null) {
											getListener()
													.onAnimationEnd(FlipHorizontalToAnimation.this);
									}
							}
					});
					flipToAnim.start();
			}
			public View getFlipToView() {
					return flipToView;
			}
			public FlipHorizontalToAnimation setFlipToView(View flipToView) {
					this.flipToView = flipToView;
					return this;
			}
			public int getPivot() {
					return pivot;
			}
			public FlipHorizontalToAnimation setPivot(int pivot) {
					this.pivot = pivot;
					return this;
			}
			public int getDirection() {
					return direction;
			}
			public FlipHorizontalToAnimation setDirection(int direction) {
					this.direction = direction;
					return this;
			}
			public TimeInterpolator getInterpolator() {
					return interpolator;
			}
			public FlipHorizontalToAnimation setInterpolator(
					TimeInterpolator interpolator) {
					this.interpolator = interpolator;
					return this;
			}
			public long getDuration() {
					return duration;
			}
			public FlipHorizontalToAnimation setDuration(long duration) {
					this.duration = duration;
					return this;
			}
			public AnimationListener getListener() {
					return listener;
			}
			public FlipHorizontalToAnimation setListener(AnimationListener listener) {
					this.listener = listener;
					return this;
			}
	}
	
	
	public static class FlipVerticalAnimation extends Animation implements Combinable {
			public static final int PIVOT_CENTER = 0, PIVOT_TOP = 1, PIVOT_BOTTOM = 2;
			float degrees;
			int pivot;
			TimeInterpolator interpolator;
			long duration;
			AnimationListener listener;
			public FlipVerticalAnimation(View view) {
					this.view = view;
					degrees = 360;
					pivot = PIVOT_CENTER;
					interpolator = new AccelerateDecelerateInterpolator();
					duration = DURATION_LONG;
					listener = null;
			}
			@Override
			public void animate() {
					getAnimatorSet().start();
			}
			@Override
			public AnimatorSet getAnimatorSet() {
					ViewGroup parentView = (ViewGroup) view.getParent(), rootView = (ViewGroup) view
							.getRootView();
					while (parentView != rootView) {
							parentView.setClipChildren(false);
							parentView = (ViewGroup) parentView.getParent();
					}
					rootView.setClipChildren(false);
					float pivotX, pivotY, viewWidth = view.getWidth(), viewHeight = view
							.getHeight();
					switch (pivot) {
						case PIVOT_TOP:
							pivotX = viewWidth / 2;
							pivotY = 0f;
							break;
						case PIVOT_BOTTOM:
							pivotX = viewWidth / 2;
							pivotY = viewHeight;
							break;
						default:
							pivotX = viewWidth / 2;
							pivotY = viewHeight / 2;
							break;
					}
					view.setPivotX(pivotX);
					view.setPivotY(pivotY);
					AnimatorSet flipSet = new AnimatorSet();
					flipSet.play(ObjectAnimator.ofFloat(view, View.ROTATION_X,
							view.getRotationX() + degrees));
					flipSet.setInterpolator(interpolator);
					flipSet.setDuration(duration);
					flipSet.addListener(new AnimatorListenerAdapter() {
							@Override
							public void onAnimationEnd(Animator animation) {
									if (getListener() != null) {
											getListener().onAnimationEnd(FlipVerticalAnimation.this);
									}
							}
					});
					return flipSet;
			}
			public float getDegrees() {
					return degrees;
			}
			public FlipVerticalAnimation setDegrees(float degrees) {
					this.degrees = degrees;
					return this;
			}
			public int getPivot() {
					return pivot;
			}
			public FlipVerticalAnimation setPivot(int pivot) {
					this.pivot = pivot;
					return this;
			}
			public TimeInterpolator getInterpolator() {
					return interpolator;
			}
			public FlipVerticalAnimation setInterpolator(TimeInterpolator interpolator) {
					this.interpolator = interpolator;
					return this;
			}
			public long getDuration() {
					return duration;
			}
			public FlipVerticalAnimation setDuration(long duration) {
					this.duration = duration;
					return this;
			}
			public AnimationListener getListener() {
					return listener;
			}
			public FlipVerticalAnimation setListener(AnimationListener listener) {
					this.listener = listener;
					return this;
			}
	}
	
	
	public static class FlipVerticalToAnimation extends Animation {
			public static final int PIVOT_CENTER = 0, PIVOT_TOP = 1, PIVOT_BOTTOM = 2;
			View flipToView;
			int pivot, direction;
			TimeInterpolator interpolator;
			long duration;
			AnimationListener listener;
			public FlipVerticalToAnimation(View view) {
					this.view = view;
					flipToView = null;
					pivot = PIVOT_CENTER;
					direction = DIRECTION_UP;
					interpolator = new AccelerateDecelerateInterpolator();
					duration = DURATION_LONG;
					listener = null;
			}
			@Override
			public void animate() {
					ViewGroup parentView = (ViewGroup) view.getParent(), rootView = (ViewGroup) view
							.getRootView();
					float pivotX, pivotY, flipAngle = 270f, viewWidth = view.getWidth(), viewHeight = view
							.getHeight();
					final float originalRotationX = view.getRotationX();
					switch (pivot) {
						case PIVOT_TOP:
							pivotX = viewWidth / 2;
							pivotY = 0f;
							break;
						case PIVOT_BOTTOM:
							pivotX = viewWidth / 2;
							pivotY = viewHeight;
							break;
						default:
							pivotX = viewWidth / 2;
							pivotY = viewHeight / 2;
							flipAngle = 90f;
							break;
					}
					view.setPivotX(pivotX);
					view.setPivotY(pivotY);
					flipToView.setLayoutParams(view.getLayoutParams());
					flipToView.setLeft(view.getLeft());
					flipToView.setTop(view.getTop());
					flipToView.setPivotX(pivotX);
					flipToView.setPivotY(pivotY);
					flipToView.setVisibility(View.VISIBLE);
					while (parentView != rootView) {
							parentView.setClipChildren(false);
							parentView = (ViewGroup) parentView.getParent();
					}
					rootView.setClipChildren(false);
					AnimatorSet flipToAnim = new AnimatorSet();
					if (direction == DIRECTION_UP) {
							flipToView.setRotationX(270f);
							flipToAnim.playSequentially(ObjectAnimator.ofFloat(view,
									View.ROTATION_X, 0f, flipAngle), ObjectAnimator.ofFloat(
									flipToView, View.ROTATION_X, 270f, 360f));
					} else if (direction == DIRECTION_UP) {
							flipToView.setRotationX(-270f);
							flipToAnim.playSequentially(ObjectAnimator.ofFloat(view,
									View.ROTATION_X, 0f, -flipAngle), ObjectAnimator.ofFloat(
									flipToView, View.ROTATION_X, -270f, -360f));
					}
					flipToAnim.setInterpolator(interpolator);
					flipToAnim.setDuration(duration / 2);
					flipToAnim.addListener(new AnimatorListenerAdapter() {
							@Override
							public void onAnimationEnd(Animator animation) {
									view.setVisibility(View.INVISIBLE);
									view.setRotationX(originalRotationX);
									if (getListener() != null) {
											getListener().onAnimationEnd(FlipVerticalToAnimation.this);
									}
							}
					});
					flipToAnim.start();
			}
			public View getFlipToView() {
					return flipToView;
			}
			public FlipVerticalToAnimation setFlipToView(View flipToView) {
					this.flipToView = flipToView;
					return this;
			}
			public int getPivot() {
					return pivot;
			}
			public FlipVerticalToAnimation setPivot(int pivot) {
					this.pivot = pivot;
					return this;
			}
			public int getDirection() {
					return direction;
			}
			public FlipVerticalToAnimation setDirection(int direction) {
					this.direction = direction;
					return this;
			}
			public TimeInterpolator getInterpolator() {
					return interpolator;
			}
			public FlipVerticalToAnimation setInterpolator(TimeInterpolator interpolator) {
					this.interpolator = interpolator;
					return this;
			}
			public long getDuration() {
					return duration;
			}
			public FlipVerticalToAnimation setDuration(long duration) {
					this.duration = duration;
					return this;
			}
			public AnimationListener getListener() {
					return listener;
			}
			public FlipVerticalToAnimation setListener(AnimationListener listener) {
					this.listener = listener;
					return this;
			}
	}
	
	
	public static class RotationAnimation extends Animation implements Combinable {
			public static final int PIVOT_CENTER = 0, PIVOT_TOP_LEFT = 1,
					PIVOT_TOP_RIGHT = 2, PIVOT_BOTTOM_LEFT = 3, PIVOT_BOTTOM_RIGHT = 4;
			float degrees;
			int pivot;
			TimeInterpolator interpolator;
			long duration;
			AnimationListener listener;
			public RotationAnimation(View view) {
					this.view = view;
					degrees = 360;
					pivot = PIVOT_CENTER;
					interpolator = new AccelerateDecelerateInterpolator();
					duration = DURATION_LONG;
					listener = null;
			}
			@Override
			public void animate() {
					getAnimatorSet().start();
			}
			@Override
			public AnimatorSet getAnimatorSet() {
					ViewGroup parentView = (ViewGroup) view.getParent(), rootView = (ViewGroup) view
							.getRootView();
					while (parentView != rootView) {
							parentView.setClipChildren(false);
							parentView = (ViewGroup) parentView.getParent();
					}
					rootView.setClipChildren(false);
					float pivotX, pivotY, viewWidth = view.getWidth(), viewHeight = view
							.getHeight();
					switch (pivot) {
						case PIVOT_TOP_LEFT:
							pivotX = 1f;
							pivotY = 1f;
							break;
						case PIVOT_TOP_RIGHT:
							pivotX = viewWidth;
							pivotY = 1f;
							break;
						case PIVOT_BOTTOM_LEFT:
							pivotX = 1f;
							pivotY = viewHeight;
							break;
						case PIVOT_BOTTOM_RIGHT:
							pivotX = viewWidth;
							pivotY = viewHeight;
							break;
						default:
							pivotX = viewWidth / 2;
							pivotY = viewHeight / 2;
							break;
					}
					view.setPivotX(pivotX);
					view.setPivotY(pivotY);
					AnimatorSet rotationSet = new AnimatorSet();
					rotationSet.play(ObjectAnimator.ofFloat(view, View.ROTATION,
							view.getRotation() + degrees));
					rotationSet.setInterpolator(interpolator);
					rotationSet.setDuration(duration);
					rotationSet.addListener(new AnimatorListenerAdapter() {
							@Override
							public void onAnimationEnd(Animator animation) {
									if (getListener() != null) {
											getListener().onAnimationEnd(RotationAnimation.this);
									}
							}
					});
					return rotationSet;
			}
			public float getDegrees() {
					return degrees;
			}
			public RotationAnimation setDegrees(float degrees) {
					this.degrees = degrees;
					return this;
			}
			public int getPivot() {
					return pivot;
			}
			public RotationAnimation setPivot(int pivot) {
					this.pivot = pivot;
					return this;
			}
			public TimeInterpolator getInterpolator() {
					return interpolator;
			}
			public RotationAnimation setInterpolator(TimeInterpolator interpolator) {
					this.interpolator = interpolator;
					return this;
			}
			public long getDuration() {
					return duration;
			}
			public RotationAnimation setDuration(long duration) {
					this.duration = duration;
					return this;
			}
			public AnimationListener getListener() {
					return listener;
			}
			public RotationAnimation setListener(AnimationListener listener) {
					this.listener = listener;
					return this;
			}
	}
	
	
	public class HighlightAnimation extends Animation {
			int color;
			TimeInterpolator interpolator;
			long duration;
			AnimationListener listener;
			public HighlightAnimation(View view) {
					this.view = view;
					color = Color.YELLOW;
					interpolator = new AccelerateDecelerateInterpolator();
					duration = DURATION_LONG;
					listener = null;
			}
			@Override
			public void animate() {
					final FrameLayout highlightFrame = new FrameLayout(view.getContext());
					android.view.ViewGroup.LayoutParams layoutParams = new android.view.ViewGroup.LayoutParams(view.getWidth(),
							view.getHeight());
					ImageView highlightView = new ImageView(view.getContext());
					highlightView.setBackgroundColor(color);
					highlightView.setAlpha(0.5f);
					highlightView.setVisibility(View.VISIBLE);
					final ViewGroup parentView = (ViewGroup) view.getParent();
					final int positionView = parentView.indexOfChild(view);
					parentView.addView(highlightFrame, positionView, layoutParams);
					highlightFrame.setX(view.getLeft());
					highlightFrame.setY(view.getTop());
					parentView.removeView(view);
					highlightFrame.addView(view);
					highlightFrame.addView(highlightView);
					highlightView.animate().alpha(0).setInterpolator(interpolator)
							.setDuration(duration)
							.setListener(new AnimatorListenerAdapter() {
									@Override
									public void onAnimationEnd(Animator animation) {
											highlightFrame.removeAllViews();
											parentView.addView(view, positionView);
											view.setX(highlightFrame.getLeft());
											view.setY(highlightFrame.getTop());
											parentView.removeView(highlightFrame);
											if (getListener() != null) {
													getListener().onAnimationEnd(
															HighlightAnimation.this);
											}
									}
							});
			}
			public int getColor() {
					return color;
			}
			public HighlightAnimation setColor(int color) {
					this.color = color;
					return this;
			}
			public TimeInterpolator getInterpolator() {
					return interpolator;
			}
			public HighlightAnimation setInterpolator(TimeInterpolator interpolator) {
					this.interpolator = interpolator;
					return this;
			}
			public long getDuration() {
					return duration;
			}
			public HighlightAnimation setDuration(long duration) {
					this.duration = duration;
					return this;
			}
			public AnimationListener getListener() {
					return listener;
			}
			public HighlightAnimation setListener(AnimationListener listener) {
					this.listener = listener;
					return this;
			}
	}
	
	
	public static class PathAnimation extends Animation implements Combinable {
			public static final int ANCHOR_CENTER = 0, ANCHOR_TOP_LEFT = 1,
					ANCHOR_TOP_RIGHT = 2, ANCHOR_BOTTOM_LEFT = 3,
					ANCHOR_BOTTOM_RIGHT = 4;
			ArrayList<Point> points;
			int anchorPoint;
			TimeInterpolator interpolator;
			long duration;
			AnimationListener listener;
			public PathAnimation(View view) {
					this.view = view;
					points = null;
					anchorPoint = ANCHOR_CENTER;
					interpolator = new AccelerateDecelerateInterpolator();
					duration = DURATION_LONG;
					listener = null;
			}
			@Override
			public void animate() {
					getAnimatorSet().start();
			}
			@Override
			public AnimatorSet getAnimatorSet() {
					ViewGroup parentView = (ViewGroup) view.getParent(), rootView = (ViewGroup) view
							.getRootView();
					while (!parentView.equals(rootView)) {
							parentView.setClipChildren(false);
							parentView = (ViewGroup) parentView.getParent();
					}
					rootView.setClipChildren(false);
					AnimatorSet pathSet = new AnimatorSet();
					int numOfPoints = points.size();
					AnimatorSet[] pathAnimSetArray = new AnimatorSet[numOfPoints];
					List<Animator> pathAnimList = new ArrayList<Animator>();
					parentView = (ViewGroup) view.getParent();
					int parentWidth = parentView.getWidth(), parentHeight = parentView
							.getHeight(), viewWidth = view.getWidth(), viewHeight = view
							.getHeight();
					float posX, posY;
					for (int i = 0; i < numOfPoints; i++) {
							posX = (points.get(i).x / 100f * parentWidth);
							posY = (points.get(i).y / 100f * parentHeight);
				
							switch (anchorPoint) {
								case ANCHOR_CENTER:
									posX = posX - viewWidth / 2;
									posY = posY - viewHeight / 2;
									break;
								case ANCHOR_TOP_RIGHT:
									posX -= viewWidth;
									break;
								case ANCHOR_BOTTOM_LEFT:
									posY -= viewHeight;
									break;
								case ANCHOR_BOTTOM_RIGHT:
									posX = posX - viewWidth;
									posY = posY - viewHeight;
									break;
								default:
									break;
							}
							pathAnimSetArray[i] = new AnimatorSet();
							pathAnimSetArray[i].playTogether(
									ObjectAnimator.ofFloat(view, View.X, posX),
									ObjectAnimator.ofFloat(view, View.Y, posY));
							pathAnimList.add(pathAnimSetArray[i]);
					}
					pathSet.playSequentially(pathAnimList);
					pathSet.setInterpolator(interpolator);
					pathSet.setDuration(duration / numOfPoints);
					pathSet.addListener(new AnimatorListenerAdapter() {
				
							@Override
							public void onAnimationEnd(Animator animation) {
									if (getListener() != null) {
											getListener().onAnimationEnd(PathAnimation.this);
									}
							}
					});
					return pathSet;
			}
			public ArrayList<Point> getPoints() {
					return points;
			}
			public PathAnimation setPoints(ArrayList<Point> points) {
					this.points = points;
					return this;
			}
			public int getAnchorPoint() {
					return anchorPoint;
			}
			public PathAnimation setAnchorPoint(int anchorPoint) {
					this.anchorPoint = anchorPoint;
					return this;
			}
			public TimeInterpolator getInterpolator() {
					return interpolator;
			}
			public PathAnimation setInterpolator(TimeInterpolator interpolator) {
					this.interpolator = interpolator;
					return this;
			}
			public long getDuration() {
					return duration;
			}
			public PathAnimation setDuration(long duration) {
					this.duration = duration;
					return this;
			}
			public AnimationListener getListener() {
					return listener;
			}
			public PathAnimation setListener(AnimationListener listener) {
					this.listener = listener;
					return this;
			}
	}
	
	
	public class ShakeAnimation extends Animation {
			float shakeDistance;
			int numOfShakes, shakeCount = 0;
			TimeInterpolator interpolator;
			long duration;
			AnimationListener listener;
			public ShakeAnimation(View view) {
					this.view = view;
					shakeDistance = 20;
					numOfShakes = 2;
					interpolator = new AccelerateDecelerateInterpolator();
					duration = DURATION_LONG;
					listener = null;
			}
			@Override
			public void animate() {
					long singleShakeDuration = duration / numOfShakes / 2;
					if (singleShakeDuration == 0)
						singleShakeDuration = 1;
					final AnimatorSet shakeAnim = new AnimatorSet();
					shakeAnim
							.playSequentially(ObjectAnimator.ofFloat(view,
									View.TRANSLATION_X, shakeDistance), ObjectAnimator
									.ofFloat(view, View.TRANSLATION_X, -shakeDistance),
									ObjectAnimator.ofFloat(view, View.TRANSLATION_X,
											shakeDistance), ObjectAnimator.ofFloat(view,
											View.TRANSLATION_X, 0));
					shakeAnim.setInterpolator(interpolator);
					shakeAnim.setDuration(singleShakeDuration);
					ViewGroup parentView = (ViewGroup) view.getParent(), rootView = (ViewGroup) view
							.getRootView();
					while (!parentView.equals(rootView)) {
							parentView.setClipChildren(false);
							parentView = (ViewGroup) parentView.getParent();
					}
					rootView.setClipChildren(false);
					shakeAnim.addListener(new AnimatorListenerAdapter() {
							@Override
							public void onAnimationEnd(Animator animation) {
									shakeCount++;
									if (shakeCount == numOfShakes) {
											if (getListener() != null) {
													getListener().onAnimationEnd(ShakeAnimation.this);
											}
									} else {
											shakeAnim.start();
									}
							}
					});
					shakeAnim.start();
			}
			public float getShakeDistance() {
					return shakeDistance;
			}
			public ShakeAnimation setShakeDistance(float shakeDistance) {
					this.shakeDistance = shakeDistance;
					return this;
			}
			public int getNumOfShakes() {
					return numOfShakes;
			}
			public ShakeAnimation setNumOfShakes(int numOfShakes) {
					this.numOfShakes = numOfShakes;
					return this;
			}
			public TimeInterpolator getInterpolator() {
					return interpolator;
			}
			public ShakeAnimation setInterpolator(TimeInterpolator interpolator) {
					this.interpolator = interpolator;
					return this;
			}
			public long getDuration() {
					return duration;
			}
			public ShakeAnimation setDuration(long duration) {
					this.duration = duration;
					return this;
			}
			public AnimationListener getListener() {
					return listener;
			}
			public ShakeAnimation setListener(AnimationListener listener) {
					this.listener = listener;
					return this;
			}
	}
	
	
	public class SlideInAnimation extends Animation implements Combinable {
			int direction;
			TimeInterpolator interpolator;
			long duration;
			AnimationListener listener;
			public SlideInAnimation(View view) {
					this.view = view;
					direction = DIRECTION_LEFT;
					interpolator = new AccelerateDecelerateInterpolator();
					duration = DURATION_LONG;
					listener = null;
			}
			@Override
			public void animate() {
					getAnimatorSet().start();
			}
			@Override
			public AnimatorSet getAnimatorSet() {
					ViewGroup parentView = (ViewGroup) view.getParent(), rootView = (ViewGroup) view
							.getRootView();
					while (!parentView.equals(rootView)) {
							parentView.setClipChildren(false);
							parentView = (ViewGroup) parentView.getParent();
					}
					rootView.setClipChildren(false);
					int[] locationView = new int[2];
					view.getLocationOnScreen(locationView);
					ObjectAnimator slideAnim = null;
					switch (direction) {
						case DIRECTION_LEFT:
							slideAnim = ObjectAnimator.ofFloat(view, View.X, -locationView[0]
									- view.getWidth(), view.getX());
							break;
						case DIRECTION_RIGHT:
							slideAnim = ObjectAnimator.ofFloat(view, View.X,
									rootView.getRight(), view.getX());
							break;
						case DIRECTION_UP:
							slideAnim = ObjectAnimator.ofFloat(view, View.Y, -locationView[1]
									- view.getHeight(), view.getY());
							break;
						case DIRECTION_DOWN:
							slideAnim = ObjectAnimator.ofFloat(view, View.Y,
									rootView.getBottom(), view.getY());
							break;
						default:
							break;
					}
					AnimatorSet slideSet = new AnimatorSet();
					slideSet.play(slideAnim);
					slideSet.setInterpolator(interpolator);
					slideSet.setDuration(duration);
					slideSet.addListener(new AnimatorListenerAdapter() {
							@Override
							public void onAnimationStart(Animator animation) {
									view.setVisibility(View.VISIBLE);
							}
							@Override
							public void onAnimationEnd(Animator animation) {
									if (getListener() != null) {
											getListener().onAnimationEnd(SlideInAnimation.this);
									}
							}
					});
					return slideSet;
			}
			public int getDirection() {
					return direction;
			}
			public SlideInAnimation setDirection(int direction) {
					this.direction = direction;
					return this;
			}
			public TimeInterpolator getInterpolator() {
					return interpolator;
			}
			public SlideInAnimation setInterpolator(TimeInterpolator interpolator) {
					this.interpolator = interpolator;
					return this;
			}
			public long getDuration() {
					return duration;
			}
			public SlideInAnimation setDuration(long duration) {
					this.duration = duration;
					return this;
			}
			public AnimationListener getListener() {
					return listener;
			}
			public SlideInAnimation setListener(AnimationListener listener) {
					this.listener = listener;
					return this;
			}
	}
	
	
	public class SlideOutAnimation extends Animation implements Combinable {
			int direction;
			TimeInterpolator interpolator;
			long duration;
			AnimationListener listener;
			ValueAnimator slideAnim;
			public SlideOutAnimation(View view) {
					this.view = view;
					direction = DIRECTION_LEFT;
					interpolator = new AccelerateDecelerateInterpolator();
					duration = DURATION_LONG;
					listener = null;
			}
			@Override
			public void animate() {
					getAnimatorSet().start();
			}
			@Override
			public AnimatorSet getAnimatorSet() {
					ViewGroup parentView = (ViewGroup) view.getParent(), rootView = (ViewGroup) view
							.getRootView();
					while (!parentView.equals(rootView)) {
							parentView.setClipChildren(false);
							parentView = (ViewGroup) parentView.getParent();
					}
					rootView.setClipChildren(false);
					final int[] locationView = new int[2];
					view.getLocationOnScreen(locationView);
					switch (direction) {
						case DIRECTION_LEFT:
							slideAnim = ObjectAnimator.ofFloat(view, View.X, -locationView[0]
									- view.getWidth());
							break;
						case DIRECTION_RIGHT:
							slideAnim = ObjectAnimator.ofFloat(view, View.X,
									rootView.getRight());
							break;
						case DIRECTION_UP:
							slideAnim = ObjectAnimator.ofFloat(view, View.Y, -locationView[1]
									- view.getHeight());
							break;
						case DIRECTION_DOWN:
							slideAnim = ObjectAnimator.ofFloat(view, View.Y,
									rootView.getBottom());
							break;
						default:
							break;
					}
					AnimatorSet slideSet = new AnimatorSet();
					slideSet.play(slideAnim);
					slideSet.setInterpolator(interpolator);
					slideSet.setDuration(duration);
					slideSet.addListener(new AnimatorListenerAdapter() {
							@Override
							public void onAnimationEnd(Animator animation) {
									view.setVisibility(View.INVISIBLE);
									slideAnim.reverse();
									if (getListener() != null) {
											getListener().onAnimationEnd(SlideOutAnimation.this);
									}
							}
					});
					return slideSet;
			}
			public int getDirection() {
					return direction;
			}
			public SlideOutAnimation setDirection(int direction) {
					this.direction = direction;
					return this;
			}
			public TimeInterpolator getInterpolator() {
					return interpolator;
			}
			public SlideOutAnimation setInterpolator(TimeInterpolator interpolator) {
					this.interpolator = interpolator;
					return this;
			}
			public long getDuration() {
					return duration;
			}
			public SlideOutAnimation setDuration(long duration) {
					this.duration = duration;
					return this;
			}
			public AnimationListener getListener() {
					return listener;
			}
			public SlideOutAnimation setListener(AnimationListener listener) {
					this.listener = listener;
					return this;
			}
	}
	
	
	public class TransferAnimation extends Animation {
			View destinationView;
			int transX, transY;
			TimeInterpolator interpolator;
			long duration;
			AnimationListener listener;
			ViewGroup parentView;
			public TransferAnimation(View view) {
					this.view = view;
					destinationView = null;
					interpolator = new AccelerateDecelerateInterpolator();
					duration = DURATION_LONG;
					listener = null;
			}
			@Override
			public void animate() {
					parentView = (ViewGroup) view.getParent();
					final ViewGroup rootView = (ViewGroup) view.getRootView();
					while (!parentView.equals(rootView)) {
							parentView.setClipChildren(false);
							parentView = (ViewGroup) parentView.getParent();
					}
					rootView.setClipChildren(false);
					final float scaleX = (float) destinationView.getWidth()
							/ ((float) view.getWidth()), scaleY = (float) destinationView
							.getHeight() / ((float) view.getHeight());
					int[] locationDest = new int[2], locationView = new int[2];
					view.getLocationOnScreen(locationView);
					destinationView.getLocationOnScreen(locationDest);
					transX = locationDest[0] - locationView[0];
					transY = locationDest[1] - locationView[1];
					transX = transX - view.getWidth() / 2 + destinationView.getWidth() / 2;
					transY = transY - view.getHeight() / 2 + destinationView.getHeight()
							/ 2;
					view.animate().scaleX(scaleX).scaleY(scaleY).translationX(transX)
							.translationY(transY).setInterpolator(interpolator)
							.setDuration(duration)
							.setListener(new AnimatorListenerAdapter() {
									@Override
									public void onAnimationEnd(Animator animation) {
											if (getListener() != null) {
													getListener()
															.onAnimationEnd(TransferAnimation.this);
											}
									}
							});
			}
			public View getDestinationView() {
					return destinationView;
			}
			public TransferAnimation setDestinationView(View destinationView) {
					this.destinationView = destinationView;
					return this;
			}
			public TimeInterpolator getInterpolator() {
					return interpolator;
			}
			public TransferAnimation setInterpolator(TimeInterpolator interpolator) {
					this.interpolator = interpolator;
					return this;
			}
			public long getDuration() {
					return duration;
			}
			public TransferAnimation setDuration(long duration) {
					this.duration = duration;
					return this;
			}
			public AnimationListener getListener() {
					return listener;
			}
			public TransferAnimation setListener(AnimationListener listener) {
					this.listener = listener;
					return this;
			}
	}
	
	
	public static class FoldLayout extends ViewGroup {
		    public static enum Orientation {
			        VERTICAL,
			        HORIZONTAL
			    }
		    private final String FOLDING_VIEW_EXCEPTION_MESSAGE = "Folding Layout can only 1 child at " +
		            "most";
		    private final float SHADING_ALPHA = 0.8f;
		    private final float SHADING_FACTOR = 0.5f;
		    private final int DEPTH_CONSTANT = 1500;
		    private final int NUM_OF_POLY_POINTS = 8;
		    private Rect[] mFoldRectArray;
		    private Matrix [] mMatrix;
		    private Orientation mOrientation = Orientation.HORIZONTAL;
		    private float mAnchorFactor = 0;
		    private float mFoldFactor = 0;
		    private int mNumberOfFolds = 2;
		    private boolean mIsHorizontal = true;
		    private int mOriginalWidth = 0;
		    private int mOriginalHeight = 0;
		    private float mFoldMaxWidth = 0;
		    private float mFoldMaxHeight = 0;
		    private float mFoldDrawWidth = 0;
		    private float mFoldDrawHeight = 0;
		    private boolean mIsFoldPrepared = false;
		    private boolean mShouldDraw = true;
		    private Paint mSolidShadow;
		    private Paint mGradientShadow;
		    private LinearGradient mShadowLinearGradient;
		    private Matrix mShadowGradientMatrix;
		    private float [] mSrc;
		    private float [] mDst;
		    private float mPreviousFoldFactor = 0;
		    private Bitmap mFullBitmap;
		    private Rect mDstRect;
		    public FoldLayout(Context context) {
			        super(context);
			    }
		    public FoldLayout(Context context, AttributeSet attrs) {
			        super(context, attrs);
			    }
		    public FoldLayout(Context context, AttributeSet attrs, int defStyle) {
			        super(context, attrs, defStyle);
			    }
		    @Override
		    protected boolean addViewInLayout(View child, int index, android.view.ViewGroup.LayoutParams params,
		                                      boolean preventRequestLayout) {
			        throwCustomException(getChildCount());
			        boolean returnValue = super.addViewInLayout(child, index, params, preventRequestLayout);
			        return returnValue;
			    }
		    @Override
		    public void addView(View child, int index, android.view.ViewGroup.LayoutParams params) {
			        throwCustomException(getChildCount());
			        super.addView(child, index, params);
			    }
		    @Override
		    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
			        View child = getChildAt(0);
			        measureChild(child,widthMeasureSpec, heightMeasureSpec);
			        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
			    }
		    @Override
		    protected void onLayout(boolean changed, int l, int t, int r, int b) {
			        View child = getChildAt(0);
			        child.layout(0, 0, child.getMeasuredWidth(), child.getMeasuredHeight());
			        updateFold();
			    }
		    private class NumberOfFoldingLayoutChildrenException extends RuntimeException {
			        public NumberOfFoldingLayoutChildrenException(String message) {
				            super(message);
				        }
			    }
		    private void throwCustomException (int numOfChildViews) {
			        if (numOfChildViews == 1) {
				            throw new NumberOfFoldingLayoutChildrenException(FOLDING_VIEW_EXCEPTION_MESSAGE);
				        }
			    }
		    public void setFoldFactor(float foldFactor) {
			        if (foldFactor != mFoldFactor) {
				            mFoldFactor = foldFactor;
				            calculateMatrices();
				            invalidate();
				        }
			    }
		    public void setOrientation(Orientation orientation) {
			        if (orientation != mOrientation) {
				            mOrientation = orientation;
				            updateFold();
				        }
			    }
		    public void setAnchorFactor(float anchorFactor) {
			        if (anchorFactor != mAnchorFactor) {
				            mAnchorFactor = anchorFactor;
				            updateFold();
				        }
			    }
		    public void setNumberOfFolds(int numberOfFolds) {
			        if (numberOfFolds != mNumberOfFolds) {
				            mNumberOfFolds = numberOfFolds;
				            updateFold();
				        }
			    }
		    public float getAnchorFactor() {
			        return mAnchorFactor;
			    }
		    public Orientation getOrientation() {
			        return mOrientation;
			    }
		    public float getFoldFactor() {
			        return mFoldFactor;
			    }
		    public int getNumberOfFolds() {
			        return mNumberOfFolds;
			    }
		    private void updateFold() {
			        prepareFold(mOrientation, mAnchorFactor, mNumberOfFolds);
			        calculateMatrices();
			        invalidate();
			    }
		    private void prepareFold(Orientation orientation, float anchorFactor, int numberOfFolds) {
			        mSrc = new float[NUM_OF_POLY_POINTS];
			        mDst = new float[NUM_OF_POLY_POINTS];
			        mDstRect = new Rect();
			        mFoldFactor = 0;
			        mPreviousFoldFactor = 0;
			        mIsFoldPrepared = false;
			        mSolidShadow = new Paint();
			        mGradientShadow = new Paint();
			        mOrientation = orientation;
			        mIsHorizontal = (orientation == Orientation.HORIZONTAL);
			        if (mIsHorizontal) {
				            mShadowLinearGradient = new LinearGradient(0, 0, SHADING_FACTOR, 0, Color.BLACK,
				                    Color.TRANSPARENT, android.graphics.Shader.TileMode.CLAMP);
				        } else {
				            mShadowLinearGradient = new LinearGradient(0, 0, 0, SHADING_FACTOR, Color.BLACK,
				                    Color.TRANSPARENT, android.graphics.Shader.TileMode.CLAMP);
				        }
			        mGradientShadow.setStyle(android.graphics.Paint.Style.FILL);
			        mGradientShadow.setShader(mShadowLinearGradient);
			        mShadowGradientMatrix = new Matrix();
			        mAnchorFactor = anchorFactor;
			        mNumberOfFolds = numberOfFolds;
			        mOriginalWidth = getMeasuredWidth();
			        mOriginalHeight = getMeasuredHeight();
			        mFoldRectArray = new Rect[mNumberOfFolds];
			        mMatrix = new Matrix [mNumberOfFolds];
			        for (int x = 0; x < mNumberOfFolds; x++) {
				            mMatrix[x] = new Matrix();
				        }
			        int h = mOriginalHeight;
			        int w = mOriginalWidth;
			        int delta = Math.round(mIsHorizontal ? ((float) w) / ((float) mNumberOfFolds) :
			                ((float) h) /((float) mNumberOfFolds));
			
			        for (int x = 0; x < mNumberOfFolds; x++) {
				            if (mIsHorizontal) {
					                int deltap = (x + 1) * delta > w ? w - x * delta : delta;
					                mFoldRectArray[x] = new Rect(x * delta, 0, x * delta + deltap, h);
					            } else {
					                int deltap = (x + 1) * delta > h ? h - x * delta : delta;
					                mFoldRectArray[x] = new Rect(0, x * delta, w, x * delta + deltap);
					            }
				        }
			        if (mIsHorizontal) {
				            mFoldMaxHeight = h;
				            mFoldMaxWidth = delta;
				        } else {
				            mFoldMaxHeight = delta;
				            mFoldMaxWidth = w;
				        }
			        mIsFoldPrepared = true;
			    }
		    private void calculateMatrices() {
			        mShouldDraw = true;
			        if (!mIsFoldPrepared) {
				            return;
				        }
			        if (mFoldFactor == 1) {
				            mShouldDraw = false;
				            return;
				        }
			        mPreviousFoldFactor = mFoldFactor;
			        for (int x = 0; x < mNumberOfFolds; x++) {
				            mMatrix[x].reset();
				        }
			        float cTranslationFactor = 1 - mFoldFactor;
			        float translatedDistance = mIsHorizontal ? mOriginalWidth * cTranslationFactor :
			                mOriginalHeight * cTranslationFactor;
			        float translatedDistancePerFold = Math.round(translatedDistance / mNumberOfFolds);
			
			        mFoldDrawWidth = mFoldMaxWidth < translatedDistancePerFold ?
			                translatedDistancePerFold : mFoldMaxWidth;
			        mFoldDrawHeight = mFoldMaxHeight < translatedDistancePerFold ?
			                translatedDistancePerFold : mFoldMaxHeight;
			
			        float translatedDistanceFoldSquared = translatedDistancePerFold * translatedDistancePerFold;
			
			        float depth = mIsHorizontal ?
			                (float)Math.sqrt((double)(mFoldDrawWidth * mFoldDrawWidth -
			                        translatedDistanceFoldSquared)) :
			                (float)Math.sqrt((double)(mFoldDrawHeight * mFoldDrawHeight -
			                        translatedDistanceFoldSquared));
			
			        float scaleFactor = DEPTH_CONSTANT / (DEPTH_CONSTANT + depth);
			        float scaledWidth, scaledHeight, bottomScaledPoint, topScaledPoint, rightScaledPoint,
			                leftScaledPoint;
			        if (mIsHorizontal) {
				            scaledWidth = mFoldDrawWidth * cTranslationFactor;
				            scaledHeight = mFoldDrawHeight * scaleFactor;
				        } else {
				            scaledWidth = mFoldDrawWidth * scaleFactor;
				            scaledHeight = mFoldDrawHeight * cTranslationFactor;
				        }
			        topScaledPoint = (mFoldDrawHeight - scaledHeight) / 2.0f;
			        bottomScaledPoint = topScaledPoint + scaledHeight;
			        leftScaledPoint = (mFoldDrawWidth - scaledWidth) / 2.0f;
			        rightScaledPoint = leftScaledPoint + scaledWidth;
			        float anchorPoint = mIsHorizontal ? mAnchorFactor * mOriginalWidth :
			                mAnchorFactor * mOriginalHeight;
			
			        float midFold = mIsHorizontal ? (anchorPoint / mFoldDrawWidth) : anchorPoint /
			                mFoldDrawHeight;
			        mSrc[0] = 0;
			        mSrc[1] = 0;
			        mSrc[2] = 0;
			        mSrc[3] = mFoldDrawHeight;
			        mSrc[4] = mFoldDrawWidth;
			        mSrc[5] = 0;
			        mSrc[6] = mFoldDrawWidth;
			        mSrc[7] = mFoldDrawHeight;
			
			        for (int x = 0; x < mNumberOfFolds; x++) {
				            boolean isEven = (x % 2 == 0);
				            if (mIsHorizontal) {
					                mDst[0] = (anchorPoint > x * mFoldDrawWidth) ? anchorPoint + (x - midFold) *
					                        scaledWidth : anchorPoint - (midFold - x) * scaledWidth;
					                mDst[1] = isEven ? 0 : topScaledPoint;
					                mDst[2] = mDst[0];
					                mDst[3] = isEven ? mFoldDrawHeight: bottomScaledPoint;
					                mDst[4] = (anchorPoint > (x + 1) * mFoldDrawWidth) ? anchorPoint + (x + 1 - midFold)
					                        * scaledWidth : anchorPoint - (midFold - x - 1) * scaledWidth;
					                mDst[5] = isEven ? topScaledPoint : 0;
					                mDst[6] = mDst[4];
					                mDst[7] = isEven ? bottomScaledPoint : mFoldDrawHeight;
					            } else {
					                mDst[0] = isEven ? 0 : leftScaledPoint;
					                mDst[1] = (anchorPoint > x * mFoldDrawHeight) ? anchorPoint + (x - midFold) *
					                        scaledHeight : anchorPoint - (midFold - x) * scaledHeight;
					                mDst[2] = isEven ? leftScaledPoint: 0;
					                mDst[3] = (anchorPoint > (x + 1) * mFoldDrawHeight) ? anchorPoint + (x + 1 -
					                        midFold) * scaledHeight : anchorPoint - (midFold - x - 1) * scaledHeight;
					                mDst[4] = isEven ? mFoldDrawWidth : rightScaledPoint;
					                mDst[5] = mDst[1];
					                mDst[6] = isEven ? rightScaledPoint : mFoldDrawWidth;
					                mDst[7] = mDst[3];
					            }
				            for (int y = 0; y < 8; y ++) {
					                mDst[y] = Math.round(mDst[y]);
					            }
				            if (mIsHorizontal) {
					                if (mDst[4] <= mDst[0] || mDst[6] <= mDst[2]) {
						                    mShouldDraw = false;
						                    return;
						                }
					            } else {
					                if (mDst[3] <= mDst[1] || mDst[7] <= mDst[5]) {
						                    mShouldDraw = false;
						                    return;
						                }
					            }
				            mMatrix[x].setPolyToPoly(mSrc, 0, mDst, 0, NUM_OF_POLY_POINTS / 2);
				        }
			        int alpha = (int) (mFoldFactor * 255 * SHADING_ALPHA);
			        mSolidShadow.setColor(Color.argb(alpha, 0, 0, 0));
			        if (mIsHorizontal) {
				            mShadowGradientMatrix.setScale(mFoldDrawWidth, 1);
				            mShadowLinearGradient.setLocalMatrix(mShadowGradientMatrix);
				        } else {
				            mShadowGradientMatrix.setScale(1, mFoldDrawHeight);
				            mShadowLinearGradient.setLocalMatrix(mShadowGradientMatrix);
				        }
			        mGradientShadow.setAlpha(alpha);
			    }
		    @Override
		    protected void dispatchDraw(Canvas canvas) {
			        if (!mIsFoldPrepared || mFoldFactor == 0) {
				            super.dispatchDraw(canvas);
				            return;
				        }
			        if (!mShouldDraw) {
				            return;
				        }
			        Rect src;
			        for (int x = 0; x < mNumberOfFolds; x++) {
				            src = mFoldRectArray[x];
				            canvas.save();
				            canvas.concat(mMatrix[x]);
				            canvas.clipRect(0, 0, src.right - src.left, src.bottom - src.top);
				            if (mIsHorizontal) {
					                canvas.translate(-src.left, 0);
					            } else {
					                canvas.translate(0, -src.top);
					            }
				            super.dispatchDraw(canvas);
				            if (mIsHorizontal) {
					                canvas.translate(src.left, 0);
					            } else {
					                canvas.translate(0, src.top);
					            }
				            if (x % 2 == 0) {
					                canvas.drawRect(0, 0, mFoldDrawWidth, mFoldDrawHeight, mSolidShadow);
					            } else {
					                canvas.drawRect(0, 0, mFoldDrawWidth, mFoldDrawHeight, mGradientShadow);
					            }
				
				            canvas.restore();
				        }
			    }
	}
	
	
	public class FoldAnimation extends Animation {
			private final int ANTIALIAS_PADDING = 1;
			int numOfFolds;
			FoldLayout.Orientation orientation;
			float anchorFactor;
			TimeInterpolator interpolator;
			long duration;
			AnimationListener listener;
			public FoldAnimation(View view) {
					this.view = view;
					numOfFolds = 1;
					orientation = FoldLayout.Orientation.HORIZONTAL;
					anchorFactor = 0f;
					interpolator = new AccelerateDecelerateInterpolator();
					duration = DURATION_LONG;
					listener = null;
			}
			@Override
			public void animate() {
					final ViewGroup parentView = (ViewGroup) view.getParent();
					final int positionView = parentView.indexOfChild(view);
					final FoldLayout mFoldLayout = new FoldLayout(view.getContext());
					mFoldLayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(view.getWidth(), view
							.getHeight()));
					mFoldLayout.setX(view.getLeft());
					mFoldLayout.setY(view.getTop());
					parentView.removeView(view);
					parentView.addView(mFoldLayout, positionView);
					mFoldLayout.addView(view);
					view.setPadding(ANTIALIAS_PADDING, ANTIALIAS_PADDING,
							ANTIALIAS_PADDING, ANTIALIAS_PADDING);
					mFoldLayout.setNumberOfFolds(numOfFolds);
					mFoldLayout.setOrientation(orientation);
					mFoldLayout.setAnchorFactor(anchorFactor);
					ObjectAnimator foldAnim = ObjectAnimator.ofFloat(mFoldLayout,
							"foldFactor", 0, 1);
					foldAnim.setDuration(duration);
					foldAnim.setInterpolator(interpolator);
					foldAnim.addListener(new AnimatorListenerAdapter() {
							@Override
							public void onAnimationEnd(Animator animation) {
									view.setVisibility(View.INVISIBLE);
									mFoldLayout.removeAllViews();
									parentView.removeView(mFoldLayout);
									parentView.addView(view, positionView);
									if (getListener() != null) {
											getListener().onAnimationEnd(FoldAnimation.this);
									}
							}
					});
					foldAnim.start();
			}
			public int getNumOfFolds() {
					return numOfFolds;
			}
			public FoldAnimation setNumOfFolds(int numOfFolds) {
					this.numOfFolds = numOfFolds;
					return this;
			}
			public FoldLayout.Orientation getOrientation() {
					return orientation;
			}
			public FoldAnimation setOrientation(FoldLayout.Orientation orientation) {
					this.orientation = orientation;
					return this;
			}
			public float getAnchorFactor() {
					return anchorFactor;
			}
			public FoldAnimation setAnchorFactor(float anchorFactor) {
					this.anchorFactor = anchorFactor;
					return this;
			}
			public TimeInterpolator getInterpolator() {
					return interpolator;
			}
			public FoldAnimation setInterpolator(TimeInterpolator interpolator) {
					this.interpolator = interpolator;
					return this;
			}
			public long getDuration() {
					return duration;
			}
			public FoldAnimation setDuration(long duration) {
					this.duration = duration;
					return this;
			}
			public AnimationListener getListener() {
					return listener;
			}
			public FoldAnimation setListener(AnimationListener listener) {
					this.listener = listener;
					return this;
			}
	}
	
	
	public class ParallelAnimator extends Animation {
			ArrayList<Combinable> combinableList;
			TimeInterpolator interpolator;
			long duration;
			ParallelAnimatorListener listener;
			public ParallelAnimator() {
					interpolator = null;
					duration = 0;
					combinableList = new ArrayList<Combinable>();
					listener = null;
			}
			public ParallelAnimator add(Combinable combinable) {
					combinableList.add(combinable);
					return this;
			}
			@Override
			public void animate() {
					ArrayList<Animator> animatorList = new ArrayList<Animator>();
					for (int i = 0; i < combinableList.size(); i++) {
							if (duration > 0) {
									combinableList.get(i).setDuration(duration);
							}
							animatorList.add(combinableList.get(i).getAnimatorSet());
					}
					AnimatorSet parallelSet = new AnimatorSet();
					parallelSet.playTogether(animatorList);
					if (interpolator != null) {
							parallelSet.setInterpolator(interpolator);
					}
					parallelSet.addListener(new AnimatorListenerAdapter() {
							@Override
							public void onAnimationEnd(Animator animation) {
									if (getListener() != null) {
											getListener().onAnimationEnd(ParallelAnimator.this);
									}
							}
					});
					parallelSet.start();
			}
			public TimeInterpolator getInterpolator() {
					return interpolator;
			}
			public ParallelAnimator setInterpolator(TimeInterpolator interpolator) {
					this.interpolator = interpolator;
					return this;
			}
			public long getDuration() {
					return duration;
			}
			public ParallelAnimator setDuration(long duration) {
					this.duration = duration;
					return this;
			}
			public ParallelAnimatorListener getListener() {
					return listener;
			}
			public ParallelAnimator setListener(ParallelAnimatorListener listener) {
					this.listener = listener;
					return this;
			}
	}
	
	
	public interface ParallelAnimatorListener {
			public void onAnimationEnd(ParallelAnimator parallelAnimator);
	}
	
	
	public class PuffInAnimation extends Animation {
			TimeInterpolator interpolator;
			long duration;
			AnimationListener listener;
			public PuffInAnimation(View view) {
					this.view = view;
					interpolator = new AccelerateDecelerateInterpolator();
					duration = DURATION_LONG;
					listener = null;
			}
			@Override
			public void animate() {
					ViewGroup parentView = (ViewGroup) view.getParent(), rootView = (ViewGroup) view
							.getRootView();
					while (parentView != rootView) {
							parentView.setClipChildren(false);
							parentView = (ViewGroup) parentView.getParent();
					}
					rootView.setClipChildren(false);
					view.setScaleX(4f);
					view.setScaleY(4f);
					view.setAlpha(0f);
					view.animate().scaleX(1f).scaleY(1f).alpha(1f)
							.setInterpolator(interpolator).setDuration(duration)
							.setListener(new AnimatorListenerAdapter() {
									@Override
									public void onAnimationStart(Animator animation) {
											view.setVisibility(View.VISIBLE);
									}
									@Override
									public void onAnimationEnd(Animator animation) {
											if (getListener() != null) {
													getListener().onAnimationEnd(PuffInAnimation.this);
											}
									}
							});
			}
			public TimeInterpolator getInterpolator() {
					return interpolator;
			}
			public PuffInAnimation setInterpolator(TimeInterpolator interpolator) {
					this.interpolator = interpolator;
					return this;
			}
			public long getDuration() {
					return duration;
			}
			public PuffInAnimation setDuration(long duration) {
					this.duration = duration;
					return this;
			}
			public AnimationListener getListener() {
					return listener;
			}
			public PuffInAnimation setListener(AnimationListener listener) {
					this.listener = listener;
					return this;
			}
	}
	
	
	public class PuffOutAnimation extends Animation {
			TimeInterpolator interpolator;
			long duration;
			AnimationListener listener;
			public PuffOutAnimation(View view) {
					this.view = view;
					interpolator = new AccelerateDecelerateInterpolator();
					duration = DURATION_LONG;
					listener = null;
			}
			@Override
			public void animate() {
					ViewGroup parentView = (ViewGroup) view.getParent(), rootView = (ViewGroup) view
							.getRootView();
					while (parentView != rootView) {
							parentView.setClipChildren(false);
							parentView = (ViewGroup) parentView.getParent();
					}
					rootView.setClipChildren(false);
					final float originalScaleX = view.getScaleX(), originalScaleY = view
							.getScaleY(), originalAlpha = view.getAlpha();
					view.animate().scaleX(4f).scaleY(4f).alpha(0f)
							.setInterpolator(interpolator).setDuration(duration)
							.setListener(new AnimatorListenerAdapter() {
									@Override
									public void onAnimationEnd(Animator animation) {
											view.setVisibility(View.INVISIBLE);
											view.setScaleX(originalScaleX);
											view.setScaleY(originalScaleY);
											view.setAlpha(originalAlpha);
											if (getListener() != null) {
													getListener().onAnimationEnd(PuffOutAnimation.this);
											}
									}
							});
			}
			public TimeInterpolator getInterpolator() {
					return interpolator;
			}
			public PuffOutAnimation setInterpolator(TimeInterpolator interpolator) {
					this.interpolator = interpolator;
					return this;
			}
			public long getDuration() {
					return duration;
			}
			public PuffOutAnimation setDuration(long duration) {
					this.duration = duration;
					return this;
			}
			public AnimationListener getListener() {
					return listener;
			}
			public PuffOutAnimation setListener(AnimationListener listener) {
					this.listener = listener;
					return this;
			}
	}
	
	
	public class UnfoldAnimation extends Animation {
			private final int ANTIALIAS_PADDING = 1;
			int numOfFolds;
			FoldLayout.Orientation orientation;
			float anchorFactor;
			TimeInterpolator interpolator;
			long duration;
			AnimationListener listener;
			public UnfoldAnimation(View view) {
					this.view = view;
					numOfFolds = 1;
					orientation = FoldLayout.Orientation.HORIZONTAL;
					anchorFactor = 0f;
					interpolator = new AccelerateDecelerateInterpolator();
					duration = DURATION_LONG;
					listener = null;
			}
			@Override
			public void animate() {
					final ViewGroup parentView = (ViewGroup) view.getParent();
					final int positionView = parentView.indexOfChild(view);
					final FoldLayout mFoldLayout = new FoldLayout(view.getContext());
					mFoldLayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(view.getWidth(), view
							.getHeight()));
					mFoldLayout.setX(view.getLeft());
					mFoldLayout.setY(view.getTop());
					parentView.removeView(view);
					parentView.addView(mFoldLayout, positionView);
					mFoldLayout.addView(view);
					view.setPadding(ANTIALIAS_PADDING, ANTIALIAS_PADDING,
							ANTIALIAS_PADDING, ANTIALIAS_PADDING);
					mFoldLayout.setNumberOfFolds(numOfFolds);
					mFoldLayout.setOrientation(orientation);
					mFoldLayout.setAnchorFactor(anchorFactor);
					mFoldLayout.setFoldFactor(1);
					 mFoldLayout.setVisibility(View.INVISIBLE);
					final ObjectAnimator foldInAnim = ObjectAnimator.ofFloat(mFoldLayout,
							"foldFactor", 1, 0);
					foldInAnim.setDuration(duration);
					foldInAnim.setInterpolator(interpolator);
					foldInAnim.addListener(new AnimatorListenerAdapter() {
							@Override
							public void onAnimationEnd(Animator animation) {
									if (getListener() != null) {
											getListener().onAnimationEnd(UnfoldAnimation.this);
									}
							}
					});
					foldInAnim.start();
					ObjectAnimator foldOutAnim = ObjectAnimator.ofFloat(mFoldLayout,
							"foldFactor", 1);
					foldOutAnim.setDuration(1);
					foldOutAnim.addListener(new AnimatorListenerAdapter() {
							@Override
							public void onAnimationEnd(Animator animation) {
									mFoldLayout.setVisibility(View.VISIBLE);
									view.setVisibility(View.VISIBLE);
									foldInAnim.start();
							}
					});
					foldOutAnim.start();
			}
			public int getNumOfFolds() {
					return numOfFolds;
			}
			public UnfoldAnimation setNumOfFolds(int numOfFolds) {
					this.numOfFolds = numOfFolds;
					return this;
			}
			public FoldLayout.Orientation getOrientation() {
					return orientation;
			}
			public UnfoldAnimation setOrientation(FoldLayout.Orientation orientation) {
					this.orientation = orientation;
					return this;
			}
			public float getAnchorFactor() {
					return anchorFactor;
			}
			public UnfoldAnimation setAnchorFactor(float anchorFactor) {
					this.anchorFactor = anchorFactor;
					return this;
			}
			public TimeInterpolator getInterpolator() {
					return interpolator;
			}
			public UnfoldAnimation setInterpolator(TimeInterpolator interpolator) {
					this.interpolator = interpolator;
					return this;
			}
			public long getDuration() {
					return duration;
			}
			public UnfoldAnimation setDuration(long duration) {
					this.duration = duration;
					return this;
			}
			public AnimationListener getListener() {
					return listener;
			}
			public UnfoldAnimation setListener(AnimationListener listener) {
					this.listener = listener;
					return this;
			}
	}
	
	
	public class ScaleOutAnimation extends Animation implements Combinable {
			TimeInterpolator interpolator;
			long duration;
			AnimationListener listener;
			public ScaleOutAnimation(View view) {
					this.view = view;
					interpolator = new AccelerateDecelerateInterpolator();
					duration = DURATION_LONG;
					listener = null;
			}
			@Override
			public void animate() {
					getAnimatorSet().start();
			}
			@Override
			public AnimatorSet getAnimatorSet() {
					final float originalScaleX = view.getScaleX(), originalScaleY = view
							.getScaleY();
					AnimatorSet scaleSet = new AnimatorSet();
					scaleSet.playTogether(ObjectAnimator.ofFloat(view, View.SCALE_X, 0f),
							ObjectAnimator.ofFloat(view, View.SCALE_Y, 0f));
					scaleSet.setInterpolator(interpolator);
					scaleSet.setDuration(duration);
					scaleSet.addListener(new AnimatorListenerAdapter() {
							@Override
							public void onAnimationEnd(Animator animation) {
									view.setVisibility(View.INVISIBLE);
									view.setScaleX(originalScaleX);
									view.setScaleY(originalScaleY);
									if (getListener() != null) {
											getListener().onAnimationEnd(ScaleOutAnimation.this);
									}
							}
					});
					return scaleSet;
			}
			public TimeInterpolator getInterpolator() {
					return interpolator;
			}
			public ScaleOutAnimation setInterpolator(TimeInterpolator interpolator) {
					this.interpolator = interpolator;
					return this;
			}
			public long getDuration() {
					return duration;
			}
			public ScaleOutAnimation setDuration(long duration) {
					this.duration = duration;
					return this;
			}
			public AnimationListener getListener() {
					return listener;
			}
			public ScaleOutAnimation setListener(AnimationListener listener) {
					this.listener = listener;
					return this;
			}
	}
	
	
	public class ScaleInAnimation extends Animation implements Combinable {
			TimeInterpolator interpolator;
			long duration;
			AnimationListener listener;
			public ScaleInAnimation(View view) {
					this.view = view;
					interpolator = new AccelerateDecelerateInterpolator();
					duration = DURATION_LONG;
					listener = null;
			}
			@Override
			public void animate() {
					getAnimatorSet().start();
			}
			@Override
			public AnimatorSet getAnimatorSet() {
					view.setScaleX(0f);
					view.setScaleY(0f);
					view.setVisibility(View.VISIBLE);
					AnimatorSet scaleSet = new AnimatorSet();
					scaleSet.playTogether(ObjectAnimator.ofFloat(view, View.SCALE_X, 1f),
							ObjectAnimator.ofFloat(view, View.SCALE_Y, 1f));
					scaleSet.setInterpolator(interpolator);
					scaleSet.setDuration(duration);
					scaleSet.addListener(new AnimatorListenerAdapter() {
							@Override
							public void onAnimationEnd(Animator animation) {
									if (getListener() != null) {
											getListener().onAnimationEnd(ScaleInAnimation.this);
									}
							}
					});
					return scaleSet;
			}
			public TimeInterpolator getInterpolator() {
					return interpolator;
			}
			public ScaleInAnimation setInterpolator(TimeInterpolator interpolator) {
					this.interpolator = interpolator;
					return this;
			}
			public long getDuration() {
					return duration;
			}
			public ScaleInAnimation setDuration(long duration) {
					this.duration = duration;
					return this;
			}
			public AnimationListener getListener() {
					return listener;
			}
			public ScaleInAnimation setListener(AnimationListener listener) {
					this.listener = listener;
					return this;
			}
	}
	
	
	public class SlideInUnderneathAnimation extends Animation {
			int direction;
			TimeInterpolator interpolator;
			long duration;
			AnimationListener listener;
			public SlideInUnderneathAnimation(View view) {
					this.view = view;
					direction = DIRECTION_LEFT;
					interpolator = new AccelerateDecelerateInterpolator();
					duration = DURATION_LONG;
					listener = null;
			}
			@Override
			public void animate() {
					final ViewGroup parentView = (ViewGroup) view.getParent();
					final FrameLayout slideInFrame = new FrameLayout(view.getContext());
					final int positionView = parentView.indexOfChild(view);
					slideInFrame.setLayoutParams(view.getLayoutParams());
					slideInFrame.setClipChildren(true);
					parentView.removeView(view);
					slideInFrame.addView(view);
					parentView.addView(slideInFrame, positionView);
					ObjectAnimator slideInAnim = null;
					float viewWidth = view.getWidth(), viewHeight = view.getHeight();
					switch (direction) {
						case DIRECTION_LEFT:
							view.setTranslationX(-viewWidth);
							slideInAnim = ObjectAnimator.ofFloat(view, View.TRANSLATION_X,
									slideInFrame.getX());
							break;
						case DIRECTION_RIGHT:
							view.setTranslationX(viewWidth);
							slideInAnim = ObjectAnimator.ofFloat(view, View.TRANSLATION_X,
									slideInFrame.getX());
							break;
						case DIRECTION_UP:
							view.setTranslationY(-viewHeight);
							slideInAnim = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y,
									slideInFrame.getY());
							break;
						case DIRECTION_DOWN:
							view.setTranslationY(viewHeight);
							slideInAnim = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y,
									slideInFrame.getY());
							break;
						default:
							break;
					}
					slideInAnim.setInterpolator(interpolator);
					slideInAnim.setDuration(duration);
					slideInAnim.addListener(new AnimatorListenerAdapter() {
							@Override
							public void onAnimationStart(Animator animation) {
									view.setVisibility(View.VISIBLE);
							}
							@Override
							public void onAnimationEnd(Animator animation) {
									slideInFrame.removeAllViews();
									view.setLayoutParams(slideInFrame.getLayoutParams());
									parentView.addView(view, positionView);
									if (getListener() != null) {
											getListener().onAnimationEnd(
													SlideInUnderneathAnimation.this);
									}
							}
					});
					slideInAnim.start();
			}
			public int getDirection() {
					return direction;
			}
			public SlideInUnderneathAnimation setDirection(int direction) {
					this.direction = direction;
					return this;
			}
			public TimeInterpolator getInterpolator() {
					return interpolator;
			}
			public SlideInUnderneathAnimation setInterpolator(
					TimeInterpolator interpolator) {
					this.interpolator = interpolator;
					return this;
			}
			public long getDuration() {
					return duration;
			}
			public SlideInUnderneathAnimation setDuration(long duration) {
					this.duration = duration;
					return this;
			}
			public AnimationListener getListener() {
					return listener;
			}
			public SlideInUnderneathAnimation setListener(AnimationListener listener) {
					this.listener = listener;
					return this;
			}
	}
	
	
	public class SlideOutUnderneathAnimation extends Animation {
			int direction;
			TimeInterpolator interpolator;
			long duration;
			AnimationListener listener;
			ValueAnimator slideAnim;
			public SlideOutUnderneathAnimation(View view) {
					this.view = view;
					direction = DIRECTION_LEFT;
					interpolator = new AccelerateDecelerateInterpolator();
					duration = DURATION_LONG;
					listener = null;
			}
			@Override
			public void animate() {
					final ViewGroup parentView = (ViewGroup) view.getParent();
					final FrameLayout slideOutFrame = new FrameLayout(view.getContext());
					final int positionView = parentView.indexOfChild(view);
					slideOutFrame.setLayoutParams(view.getLayoutParams());
					slideOutFrame.setClipChildren(true);
					parentView.removeView(view);
					slideOutFrame.addView(view);
					parentView.addView(slideOutFrame, positionView);
					switch (direction) {
						case DIRECTION_LEFT:
							slideAnim = ObjectAnimator.ofFloat(view, View.TRANSLATION_X,
									view.getTranslationX() - view.getWidth());
							break;
						case DIRECTION_RIGHT:
							slideAnim = ObjectAnimator.ofFloat(view, View.TRANSLATION_X,
									view.getTranslationX() + view.getWidth());
							break;
						case DIRECTION_UP:
							slideAnim = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y,
									view.getTranslationY() - view.getHeight());
							break;
						case DIRECTION_DOWN:
							slideAnim = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y,
									view.getTranslationY() + view.getHeight());
							break;
						default:
							break;
					}
					AnimatorSet slideSet = new AnimatorSet();
					slideSet.play(slideAnim);
					slideSet.setInterpolator(interpolator);
					slideSet.setDuration(duration);
					slideSet.addListener(new AnimatorListenerAdapter() {
							@Override
							public void onAnimationEnd(Animator animation) {
									view.setVisibility(View.INVISIBLE);
									slideAnim.reverse();
									slideOutFrame.removeAllViews();
									parentView.removeView(slideOutFrame);
									parentView.addView(view, positionView);
									if (getListener() != null) {
											getListener().onAnimationEnd(
													SlideOutUnderneathAnimation.this);
									}
							}
					});
					slideSet.start();
			}
			public int getDirection() {
					return direction;
			}
			public SlideOutUnderneathAnimation setDirection(int direction) {
					this.direction = direction;
					return this;
			}
			public TimeInterpolator getInterpolator() {
					return interpolator;
			}
			public SlideOutUnderneathAnimation setInterpolator(
					TimeInterpolator interpolator) {
					this.interpolator = interpolator;
					return this;
			}
			public long getDuration() {
					return duration;
			}
			public SlideOutUnderneathAnimation setDuration(long duration) {
					this.duration = duration;
					return this;
			}
			public AnimationListener getListener() {
					return listener;
			}
			public SlideOutUnderneathAnimation setListener(AnimationListener listener) {
					this.listener = listener;
					return this;
			}
	}
	{
	}
	
	
	public void _MakeDirectory() {
		Sketchware_Path = FileUtil.getExternalStorageDir().concat("/.sketchware/");
		Sketify_Hidden_Path = FileUtil.getExternalStorageDir().concat("/Android/data/com.sketify.msk/");
		Sketify_Directory = FileUtil.getExternalStorageDir().concat("/Sketify/");
		if (!FileUtil.isExistFile(Sketchware_Path)) {
			FileUtil.makeDir(Sketchware_Path);
		}
		if (!FileUtil.isExistFile(Sketify_Hidden_Path)) {
			FileUtil.makeDir(Sketify_Hidden_Path);
		}
		if (!FileUtil.isExistFile(Sketify_Directory)) {
			FileUtil.makeDir(Sketify_Directory);
		}
		imageview2.setColorFilter(Color.parseColor("#000000"));
		imageview4.setColorFilter(Color.parseColor("#000000"));
	}
	
	
	public void _ListviewProbablity() {
		_Elevation(new_gridlayout, 7);
		_gd(new_gridlayout, 4, "#FFFFFF");
		listview2.setSelector(android.R.color.transparent);
		hscroll1.setHorizontalScrollBarEnabled(false);
		_Elevation(popular_gridlayout, 7);
		_gd(popular_gridlayout, 4, "#FFFFFF");
		listview4.setSelector(android.R.color.transparent);
		hscroll2.setHorizontalScrollBarEnabled(false);
		_Elevation(editor_gridlayout, 7);
		_gd(editor_gridlayout, 4, "#FFFFFF");
		hscroll3.setHorizontalScrollBarEnabled(false);
	}
	
	
	public void _MakeDrawerItems() {
		
		_drawer_img2.setColorFilter(Color.parseColor("#536DFE"));
		
		_drawer_img1.setColorFilter(Color.parseColor("#536DFE"));
		
		_drawer_img3.setColorFilter(Color.parseColor("#536DFE"));
		
		_drawer_img4.setColorFilter(Color.parseColor("#536DFE"));
		
		_drawer_img5.setColorFilter(Color.parseColor("#536DFE"));
		
		_drawer_img6.setColorFilter(Color.parseColor("#536DFE"));
		
		_drawer_img7.setColorFilter(Color.parseColor("#536DFE"));
		
		_drawer_img8.setColorFilter(Color.parseColor("#536DFE"));
		
		_drawer_img9.setColorFilter(Color.parseColor("#536DFE"));
		
		_drawer_img10.setColorFilter(Color.parseColor("#536DFE"));
		
		_drawer_yt_logo.setColorFilter(Color.parseColor("#536DFE"));
		
		_drawer_twitter_logo.setColorFilter(Color.parseColor("#536DFE"));
		
		_drawer_web_logo.setColorFilter(Color.parseColor("#536DFE"));
		
		_drawer_img11.setColorFilter(Color.parseColor("#536DFE"));
		
		_drawer_profile.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
				view_profile.setClass(getApplicationContext(), ProfileActivity.class);
				view_profile.putExtra("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
				startActivity(view_profile);
				overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
			}
		});
		_drawer_codes.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
				view_codes.setClass(getApplicationContext(), JavacodesActivity.class);
				view_codes.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(view_codes);
				overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
			}
		});
		_drawer_p_manage.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
				p_manage_goon.setClass(getApplicationContext(), ProjectManagerActivity.class);
				p_manage_goon.putExtra("mode", "project");
				startActivity(p_manage_goon);
				overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
			}
		});
		_drawer_community.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
				goto_community.setClass(getApplicationContext(), LikedProjectsActivity.class);
				goto_community.putExtra("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
				goto_community.putExtra("mode", "user");
				startActivity(goto_community);
			}
		});
		_drawer_blog.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
				bog_view.setClass(getApplicationContext(), WebActivity.class);
				bog_view.putExtra("url", "https://sketifyurl.page.link/sketify-blog");
				startActivity(bog_view);
			}
		});
		_drawer_yt_logo.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
				yt_view.setClass(getApplicationContext(), WebActivity.class);
				yt_view.putExtra("url", "https://youtube.com/channel/UCQfkZXnb2fdmqqSWijGINqw");
				startActivity(yt_view);
				overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
			}
		});
		_drawer_twitter_logo.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
				twitter.setClass(getApplicationContext(), WebActivity.class);
				twitter.putExtra("url", "https://sketifyurl.page.link/twitter-profile");
				startActivity(twitter);
				overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
			}
		});
		_drawer_web_logo.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
				web.setClass(getApplicationContext(), WebActivity.class);
				web.putExtra("url", "https://sketify.tk");
				web.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(web);
				overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
			}
		});
		_drawer_about_us.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
				about_elme.setClass(getApplicationContext(), AboutActivity.class);
				about_elme.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(about_elme);
			}
		});
		_drawer_settings.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
				setting_mera_dhobada.setClass(getApplicationContext(), SettingsActivity.class);
				setting_mera_dhobada.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(setting_mera_dhobada);
			}
		});
	}
	
	
	public void _setView(final View _view) {
		layout1.setVisibility(View.GONE);
		layout2.setVisibility(View.GONE);
		layout3.setVisibility(View.GONE);
		layout4.setVisibility(View.GONE);
		layouts_main.setVisibility(View.VISIBLE);
		_view.setVisibility(View.VISIBLE);
	}
	
	
	public void _BTMNavi(final boolean _f, final boolean _s, final boolean _t, final boolean _fo) {
		if (_f) {
			_SetColorTextview("#304FFEE", textview9);
			_SetColorImage("#304FFEE", imageview11);
			
			_SetColorTextview("#8CNEFF", textview8);
			_SetColorImage("#8CNEFF", imageview10);
			
			_SetColorTextview("#8CNEFF", textview7);
			_SetColorImage("#8CNEFF", imageview9);
			
			_SetColorTextview("#8CNEFF", textview6);
			_SetColorImage("#8CNEFF", imageview8);
		}
		if (_s) {
			_SetColorTextview("#304FFEE", textview8);
			_SetColorImage("#304FFEE", imageview10);
			
			_SetColorTextview("#8CNEFF", textview9);
			_SetColorImage("#8CNEFF", imageview11);
			
			_SetColorTextview("#8CNEFF", textview7);
			_SetColorImage("#8CNEFF", imageview9);
			
			_SetColorTextview("#8CNEFF", textview6);
			_SetColorImage("#8CNEFF", imageview8);
		}
		if (_t) {
			_SetColorTextview("#304FFEE", textview7);
			_SetColorImage("#304FFEE", imageview9);
			
			_SetColorTextview("#8CNEFF", textview9);
			_SetColorImage("#8CNEFF", imageview11);
			
			_SetColorTextview("#8CNEFF", textview8);
			_SetColorImage("#8CNEFF", imageview10);
			
			_SetColorTextview("#8CNEFF", textview6);
			_SetColorImage("#8CNEFF", imageview8);
		}
		if (_fo) {
			_SetColorTextview("#304FFEE", textview6);
			_SetColorImage("#304FFEE", imageview8);
			
			_SetColorTextview("#8CNEFF", textview9);
			_SetColorImage("#8CNEFF", imageview11);
			
			_SetColorTextview("#8CNEFF", textview8);
			_SetColorImage("#8CNEFF", imageview10);
			
			_SetColorTextview("#8CNEFF", textview7);
			_SetColorImage("#8CNEFF", imageview9);
		}
	}
	
	
	public void _SetView(final View _view, final String _layout) {
		_setView(_view);
		if (_layout.equals("layout1")) {
			if (control) {
				_fab.show();
				appbar.setVisibility(View.VISIBLE);
				_BTMNavi(true, false, false, false);
			}
			else {
				_fab.hide();
				appbar.setVisibility(View.VISIBLE);
				_BTMNavi(true, false, false, false);
			}
		}
		
		if (_layout.equals("layout2")) {
			_setView(_view);
			if (control) {
				_fab.show();
				appbar.setVisibility(View.VISIBLE);
				_BTMNavi(false, true, false, false);
			}
			else {
				_fab.hide();
				appbar.setVisibility(View.VISIBLE);
				_BTMNavi(false, true, false, false);
			}
			
		}
		if (_layout.equals("layout3")) {
			_setView(_view);
			if (control) {
				_fab.hide();
				appbar.setVisibility(View.GONE);
				_BTMNavi(false, false, false, true);
			}
			else {
				_fab.hide();
				appbar.setVisibility(View.GONE);
				_BTMNavi(false, false, false, true);
			}
			
		}
		if (_layout.equals("layout4")) {
			_setView(_view);
			if (control) {
				_fab.hide();
				appbar.setVisibility(View.GONE);
				_BTMNavi(false, false, true, false);
			}
			else {
				_fab.hide();
				appbar.setVisibility(View.GONE);
				_BTMNavi(false, false, true, false);
			}
			
		}
	}
	
	
	public void _SetColorImage(final String _c, final ImageView _v) {
		_v.setColorFilter(Color.parseColor("#607D8B"));
		if (_c.equals("#304FFEE")) {
			_v.setColorFilter(Color.parseColor("#304FFE"));
		}
	}
	
	
	public void _SetColorTextview(final String _c, final TextView _v) {
		if (_c.equals("#304FFEE")) {
			_v.setTextColor(0xFF304FFE);
		}
		else {
			_v.setTextColor(0xFF607D8B);
		}
	}
	
	
	public void _FabProgress(final boolean _start) {
		
		if (_start) {
			
			this._fab.setImageResource(R.drawable.load);
			
			this.oa_fab.setTarget(this._fab);
			
			this.oa_fab.setPropertyName("rotation");
			
			this.oa_fab.setFloatValues(new float[]{0.0f, 360.0f});
			
			this.oa_fab.setDuration(750);
			
			this.oa_fab.setInterpolator(new LinearInterpolator());
			
			this.oa_fab.start();
			
			return;
			
		}
		
		if (this.oa_fab.isRunning()) {
			
			this.oa_fab.cancel();
			
		}
		
		this._fab.setImageResource(R.drawable.ic_add_white);
		
		this._fab.setRotation(0.0f);
		
	}
	
	
	public void _reCaptcha() {
		
		final Dialog diaalog = new Dialog(HomeActivity.this);
		
		diaalog.setTitle("reCaptcha");
		
		LinearLayout layllout = new LinearLayout(HomeActivity.this);
		layllout.setOrientation(LinearLayout.VERTICAL);
		layllout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		final WebView rv = new WebView(this);
		rv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		rv.setBackgroundColor(Color.TRANSPARENT);
		rv.getSettings().setJavaScriptEnabled(true);
				rv.getSettings().setSupportZoom(true);
				
				rv.setWebViewClient(new WebViewClient() {
						@Override
						public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
								final String _url = _param2;
								if (_url.contains("sketchware")) {
										rv.stopLoading();
					     diaalog.dismiss();
					
					first.edit().remove("reCaptcha").commit();
					first.edit().putString("reCaptcha", "true").commit();
					SketchwareUtil.showMessage(getApplicationContext(), "Thank You, Human.");
					_CheckCaptcha();
								}
								else {
										if (!_url.contains("http://updatify.rf.gd/recaptcha")) {
												rv.loadUrl("http://updatify.rf.gd/recaptcha");
										}
								}
								super.onPageStarted(_param1, _param2, _param3);
						}
						
						@Override
						public void onPageFinished(WebView _param1, String _param2) {
								final String _url = _param2;
								
								super.onPageFinished(_param1, _param2);
						}
				});
		rv.loadUrl("http://updatify.rf.gd/recaptcha");
		layllout.addView(rv);
		diaalog.setContentView(layllout);
		diaalog.setCancelable(false);
		diaalog.show();
	}
	
	
	public void _ShareApp() {
		/* 
// Put This In OnCreate
	StrictMode.VmPolicy.Builder builder = 
				new StrictMode.VmPolicy.Builder(); 
				StrictMode.setVmPolicy(builder.build());
				if(Build.VERSION.SDK_INT>=24){ 
					    try{
								java.lang.reflect.Method m = 
						        StrictMode.class.getMethod(
								"disableDeathOnFileUriExposure"); 
						        m.invoke(null); 
							}
						catch(Exception e){ 
								showMessage(e.toString()); 
							} 
				}

*/
		/*
//Use Were You  want To Share App
shareApplication();
*/
	}
	private void shareApplication() { 						android.content.pm.ApplicationInfo app = 						getApplicationContext().getApplicationInfo(); 						String filePath = app.sourceDir;						Intent intent = new Intent(Intent.ACTION_SEND); 						intent.setType("*/*"); 						java.io.File originalApk = new java.io.File(filePath); 						try { 								java.io.File tempFile = new java.io.File(getExternalCacheDir() + "/ExtractedApk"); 						 		if (!tempFile.isDirectory()) 									if (!tempFile.mkdirs()) 									return; 									tempFile = new java.io.File(tempFile.getPath() + "/" + 									"base.apk");									if (!tempFile.exists()) 										{											try{													if (!tempFile.createNewFile()) { 															return; }											}											catch (java.io.IOException e){} 									} 									java.io.InputStream in = new java.io.FileInputStream (originalApk);									java.io.OutputStream out = new java.io.FileOutputStream(tempFile);									byte[] buf = new byte[1024];									int len; 									while ((len = in.read(buf)) > 0) { 												out.write(buf, 0, len); 								} 									in.close(); 									out.close(); 									intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(tempFile));									startActivity(Intent.createChooser(intent, "Share app via"));					} 						catch (java.io.IOException e) 						{ showMessage(e.toString()); 					} 		}
	{
	}
	
	
	public void _CheckCaptcha() {
		if (first.getString("reCaptcha", "").equals("true")) {
			Net.startRequestNetwork(RequestNetworkController.POST, "https://sketify.tk/news.php", "a", _Net_request_listener);
		}
		else {
			Net.startRequestNetwork(RequestNetworkController.POST, "https://sketify.tk/news.php", "a", _Net_request_listener);
		}
	}
	
	
	public void _setCircleImagePath(final ImageView _imageview, final String _path, final double _strokeWidth, final String _strokeColor) {
		Glide.with(getApplicationContext()).load(Uri.fromFile(new java.io.File(_path))).transform(new BorderTransformation2(this, (float)_strokeWidth, Color.parseColor(_strokeColor))).into(_imageview);
	}
	public class BorderTransformation2 extends com.bumptech.glide.load.resource.bitmap.BitmapTransformation {
		
		private float strokeWidth;
		private int strokeColor;
		
		    public BorderTransformation2(Context context, float strokeWidth, int strokeColor) {
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
				_view = _inflater.inflate(R.layout.grid, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView icon = _view.findViewById(R.id.icon);
			final TextView title = _view.findViewById(R.id.title);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView likes = _view.findViewById(R.id.likes);
			final ImageView imageview2 = _view.findViewById(R.id.imageview2);
			final TextView comments = _view.findViewById(R.id.comments);
			
			_rippleRoundStroke(icon, "#FFFFFF", "#FFFFFF", 20, 0, "#FFFFFF");
			icon.setImageResource(R.drawable.android_icon);
			imageview2.setColorFilter(Color.parseColor("#FBC02D"));
			if (_data.get((int)_position).containsKey("icon")) {
				if (!_data.get((int)_position).get("icon").toString().equals("")) {
					Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("icon").toString())).into(icon);
				}
			}
			if (_data.get((int)_position).containsKey("title")) {
				title.setText(_data.get((int)_position).get("title").toString());
			}
			if (_data.get((int)_position).containsKey("likes")) {
				likes.setText(_data.get((int)_position).get("likes").toString());
			}
			if (_data.get((int)_position).containsKey("comments")) {
				comments.setText(_data.get((int)_position).get("comments").toString());
			}
			
			return _view;
		}
	}
	
	public class Listview2Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview2Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
			if (_data.get((int)_position).containsKey("title")) {
				textview_name.setText(_data.get((int)_position).get("title").toString());
			}
			if (_data.get((int)_position).containsKey("name")) {
				textview_uploader.setText(_data.get((int)_position).get("name").toString());
			}
			if (_data.get((int)_position).containsKey("likes")) {
				textview_likes.setText(_data.get((int)_position).get("likes").toString());
			}
			if (_data.get((int)_position).containsKey("downloads")) {
				textview_dwnd.setText(_data.get((int)_position).get("downloads").toString());
			}
			if (_data.get((int)_position).containsKey("comments")) {
				textview_cmt.setText(_data.get((int)_position).get("comments").toString());
			}
			if (_data.get((int)_position).containsKey("icon")) {
				Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("icon").toString())).into(imageview_ic);
			}
			
			return _view;
		}
	}
	
	public class Listview3Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview3Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_view = _inflater.inflate(R.layout.fp_item, null);
			}
			
			final LinearLayout main = _view.findViewById(R.id.main);
			final LinearLayout linear_bg = _view.findViewById(R.id.linear_bg);
			final ImageView img_file = _view.findViewById(R.id.img_file);
			final TextView txt_filename = _view.findViewById(R.id.txt_filename);
			
			_Elevation(main, 7);
			_gd(linear_bg, 4, "#ffffff");
			if (_position == 0) {
				txt_filename.setText("Tools");
			}
			if (_position == 1) {
				txt_filename.setText("UI & UX");
			}
			if (_position == 2) {
				txt_filename.setText("Social");
			}
			if (_position == 3) {
				txt_filename.setText("VideoGraphy");
			}
			if (_position == 4) {
				txt_filename.setText("Bussiness");
				img_file.setImageResource(R.drawable.default_image);
			}
			if (_position == 5) {
				txt_filename.setText("Books & References");
			}
			if (_position == 6) {
				txt_filename.setText("Entertainment");
			}
			if (_position == 7) {
				txt_filename.setText("Example & Tutorials");
			}
			if (_position == 8) {
				txt_filename.setText("Games");
			}
			if (_position == 9) {
				txt_filename.setText("Photography");
			}
			if (_position == 10) {
				txt_filename.setText("Productivity");
			}
			if (_position == 11) {
				txt_filename.setText("Music & Video");
			}
			if (_position == 12) {
				txt_filename.setText("Multi - Device");
			}
			if (_position == 13) {
				txt_filename.setText("Education");
			}
			if (_position == 14) {
				txt_filename.setText("Communication");
			}
			if (_position == 15) {
				txt_filename.setText("Others");
			}
			
			return _view;
		}
	}
	
	public class Listview4Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview4Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_view = _inflater.inflate(R.layout.news, null);
			}
			
			final LinearLayout base = _view.findViewById(R.id.base);
			final LinearLayout title_property = _view.findViewById(R.id.title_property);
			final LinearLayout jmg_properry = _view.findViewById(R.id.jmg_properry);
			final LinearLayout news_property = _view.findViewById(R.id.news_property);
			final LinearLayout only_for_time = _view.findViewById(R.id.only_for_time);
			final ImageView imageview_header = _view.findViewById(R.id.imageview_header);
			final TextView headline = _view.findViewById(R.id.headline);
			final ImageView imageview_news = _view.findViewById(R.id.imageview_news);
			final TextView textview_news = _view.findViewById(R.id.textview_news);
			final TextView textview_time = _view.findViewById(R.id.textview_time);
			
			textview_news.setTextIsSelectable(true);
			
			imageview_header.setColorFilter(Color.parseColor("#3D5AFE"));
			_Elevation(base, 5);
			_rippleRoundStroke(base, "#FFFFFF", "#FFFFFF", 20, 0, "#FFFFFF");
			textview_news.setClickable(true);
			android.text.util.Linkify.addLinks(textview_news, android.text.util.Linkify.ALL);
			textview_news.setLinkTextColor(Color.parseColor("#009688"));
			textview_news.setLinksClickable(true);
			if (!_data.get((int)_position).containsKey("img")) {
				jmg_properry.setVisibility(View.GONE);
			}
			else {
				jmg_properry.setVisibility(View.VISIBLE);
				Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("img").toString())).into(imageview_news);
			}
			if (_data.get((int)_position).containsKey("news")) {
				textview_news.setText(_data.get((int)_position).get("news").toString());
			}
			if (_data.get((int)_position).containsKey("time")) {
				textview_time.setText(_data.get((int)_position).get("time").toString());
			}
			if (_data.get((int)_position).containsKey("headline")) {
				headline.setText(newsmap.get((int)_position).get("headline").toString());
			}
			base.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (FirebaseAuth.getInstance().getCurrentUser().getEmail().equals("mskshafi99@gmail.com")) {
						delete.setTitle("Delete?");
						delete.setMessage("Are You Sure?");
						delete.setPositiveButton("DELETE", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								_ProgresbarShow("Deleting");
								news.child(news_keys.get((int)(_position))).removeValue();
								SketchwareUtil.showMessage(getApplicationContext(), "Deleted!");
								_ProgresbarDimiss();
							}
						});
						delete.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								
							}
						});
						delete.create().show();
					}
				}
			});
			jmg_properry.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (newsmap.get((int)_position).containsKey("img")) {
						if (!newsmap.get((int)_position).get("img").toString().equals("")) {
							view.setClass(getApplicationContext(), FullviewActivity.class);
							view.putExtra("main", newsmap.get((int)_position).get("img").toString());
							startActivity(view);
						}
					}
				}
			});
			
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