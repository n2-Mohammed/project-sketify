package com.sketify.msk;

import android.Manifest;
import android.animation.*;
import android.animation.ObjectAnimator;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.Context;
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
import android.os.Vibrator;
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
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
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
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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

public class ProjectViewActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private FloatingActionButton _fab;
	private boolean int_isLoaded = false;
	private String key = "";
	private String uid = "";
	private String URL = "";
	private String icon_URL = "";
	private String SKETCHLIB_PATH = "";
	private String SKETCHLIB_PATH_HIDE = "";
	private String SKETCHWARE_PATH = "";
	private String new_id = "";
	private HashMap<String, Object> decrypt_map = new HashMap<>();
	private String temp_decrypted = "";
	private double number = 0;
	private double like_num = 0;
	private double comment_num = 0;
	private boolean liked = false;
	private String like_key = "";
	private HashMap<String, Object> map = new HashMap<>();
	private HashMap<String, Object> map2 = new HashMap<>();
	private String download_key = "";
	private double download_num = 0;
	private HashMap<String, Object> d_map = new HashMap<>();
	private boolean verified = false;
	private boolean comment_visibility = false;
	private String fontName = "";
	private String typeace = "";
	private HashMap<String, Object> admin_role_map = new HashMap<>();
	private HashMap<String, Object> user_like = new HashMap<>();
	private HashMap<String, Object> usr_dwnds = new HashMap<>();
	private String shot1url = "";
	private String shot2url = "";
	private HashMap<String, Object> reprt = new HashMap<>();
	private boolean whatnewopened = false;
	private String id = "";
	private String id2 = "";
	private String ytvideo = "";
	private boolean project_ok = false;
	private boolean apk_ok = false;
	private double n = 0;
	private boolean downloaded = false;
	private String pathapk = "";
	private String profule = "";
	private double progresss = 0;
	private boolean as = false;
	private String as_path = "";
	private HashMap<String, Object> verification = new HashMap<>();
	private double ad_count = 0;
	private double rep_ = 0;
	private String d_Url = "";
	private boolean NetOk = false;
	private String Sketify_Directory = "";
	private String Sketify_Hidden_Path = "";
	private String Sketchware_Path = "";
	private String share_url = "";
	private HashMap<String, Object> short_mapper = new HashMap<>();
	private String url_to_short = "";
	private String json = "";
	private HashMap<String, Object> share_sender = new HashMap<>();
	private String share = "";
	private String SK_Manager_Path = "";
	private String sketchware_path = "";
	private HashMap<String, Object> clo_temp = new HashMap<>();
	private String output = "";
	private double a = 0;
	private String msg = "";
	private double user_projects = 0;
	private double string_likes = 0;
	private boolean Admin = false;
	private boolean Moderator = false;
	private boolean Editor = false;
	private boolean verifiedUser = false;
	private boolean exit = false;
	private HashMap<String, Object> rep = new HashMap<>();
	private boolean privated = false;
	private boolean Cprivated = false;
	private boolean No_1 = false;
	private boolean No_2 = false;
	private double adn = 0;
	private double mdn = 0;
	
	private ArrayList<String> temp = new ArrayList<>();
	private ArrayList<String> temp_str1 = new ArrayList<>();
	private ArrayList<String> copy_list = new ArrayList<>();
	private ArrayList<String> admins = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listColor = new ArrayList<>();
	private ArrayList<String> moderators = new ArrayList<>();
	
	private LinearLayout toolbar_outer;
	private LinearLayout progress_main;
	private ScrollView vscroll1;
	private LinearLayout toolbar;
	private ImageView backk;
	private TextView textview10;
	private ImageView imageview23;
	private ImageView arrow_down_more;
	private ImageView verify;
	private TextView nothing;
	private ProgressBar progressbar1;
	private LinearLayout back;
	private LinearLayout linear1;
	private LinearLayout linear47;
	private LinearLayout linear46;
	private LinearLayout linear4;
	private LinearLayout linear_down;
	private LinearLayout linear16;
	private HorizontalScrollView hscroll5;
	private ImageView icon;
	private LinearLayout linear18;
	private TextView title;
	private TextView username;
	private LinearLayout linear44;
	private LinearLayout sketch_apk;
	private LinearLayout sketch_project;
	private LinearLayout category_linear;
	private LinearLayout verified_r_project;
	private LinearLayout android_studio;
	private LinearLayout editor;
	private LinearLayout android_studio_apk;
	private TextView textview46;
	private TextView textview47;
	private TextView textview_category;
	private ImageView imageview22;
	private TextView textview49;
	private TextView textview50;
	private ImageView imageview26;
	private TextView textview56;
	private TextView textview51;
	private LinearLayout linear9;
	private LinearLayout like_linear;
	private LinearLayout cmt_linear;
	private LinearLayout dwnd_linear;
	private ImageView like_btn;
	private LinearLayout linear11;
	private TextView likes;
	private TextView textview11;
	private ImageView imageview6;
	private LinearLayout linear13;
	private TextView comments;
	private TextView textview53;
	private ImageView imageview7;
	private LinearLayout linear15;
	private TextView download_cnt;
	private TextView textview14;
	private LinearLayout progress_bar;
	private Button download_btn;
	private TextView demo_link;
	private ProgressBar progress;
	private TextView textview27;
	private ScrollView vscroll2;
	private LinearLayout linear20;
	private LinearLayout whats_new_linear;
	private LinearLayout linear23;
	private LinearLayout linear21;
	private LinearLayout pub_by_ban;
	private LinearLayout linear27;
	private LinearLayout share_lin;
	private LinearLayout report_lin;
	private LinearLayout linear52;
	private LinearLayout linear35;
	private TextView what_new;
	private ImageView wn_img;
	private TextView textview17;
	private ImageView imageview18;
	private HorizontalScrollView hscroll1;
	private LinearLayout linear_inner_sc;
	private LinearLayout vid_linear;
	private ImageView shot1;
	private ImageView shot2;
	private Button button1;
	private ImageView yt_thumb;
	private LinearLayout linear37;
	private TextView textview16;
	private TextView textview15;
	private LinearLayout linear34;
	private LinearLayout linear53;
	private TextView time;
	private LinearLayout linear48;
	private TextView textview57;
	private LinearLayout adview_l;
	private TextView textview58;
	private LinearLayout pub_by;
	private TextView textview26;
	private LinearLayout pub_by_in;
	private ImageView imageview_pub_ic;
	private LinearLayout pub_by_inner;
	private LinearLayout linear29;
	private HorizontalScrollView hscroll2;
	private TextView textview_publisher;
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
	private LinearLayout linear57;
	private LinearLayout linear56;
	private LinearLayout linear58;
	private TextView textview59;
	private ImageView imageview24;
	private TextView textview55;
	private ImageView imageview25;
	private TextView textview54;
	
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
	
	private DatabaseReference data1 = _firebase.getReference("data1");
	private ChildEventListener _data1_child_listener;
	private DatabaseReference users = _firebase.getReference("users");
	private ChildEventListener _users_child_listener;
	private StorageReference project = _firebase_storage.getReference("project");
	private OnCompleteListener<Uri> _project_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _project_download_success_listener;
	private OnSuccessListener _project_delete_success_listener;
	private OnProgressListener _project_upload_progress_listener;
	private OnProgressListener _project_download_progress_listener;
	private OnFailureListener _project_failure_listener;
	
	private AlertDialog.Builder delete;
	private TimerTask timer;
	private DatabaseReference like = _firebase.getReference("likes");
	private ChildEventListener _like_child_listener;
	private DatabaseReference comment = _firebase.getReference("comments");
	private ChildEventListener _comment_child_listener;
	private Intent intent = new Intent();
	private Intent fullview = new Intent();
	private AlertDialog.Builder report;
	private Intent c_view = new Intent();
	private RequestNetwork Network;
	private RequestNetwork.RequestListener _Network_request_listener;
	private Intent apkb = new Intent();
	private Intent install = new Intent();
	private Intent view = new Intent();
	private AlertDialog.Builder Verified;
	private ObjectAnimator oa_d = new ObjectAnimator();
	private DatabaseReference admin_users = _firebase.getReference("admin");
	private ChildEventListener _admin_users_child_listener;
	private Intent reprtt = new Intent();
	private Intent dm_link = new Intent();
	private RequestNetwork short_ur;
	private RequestNetwork.RequestListener _short_ur_request_listener;
	private Intent transfer = new Intent();
	private SharedPreferences transferdata;
	private Intent edit = new Intent();
	private Intent view_profile = new Intent();
	private Intent LProjects = new Intent();
	private StorageReference shot1s = _firebase_storage.getReference("shot1");
	private OnCompleteListener<Uri> _shot1s_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _shot1s_download_success_listener;
	private OnSuccessListener _shot1s_delete_success_listener;
	private OnProgressListener _shot1s_upload_progress_listener;
	private OnProgressListener _shot1s_download_progress_listener;
	private OnFailureListener _shot1s_failure_listener;
	
	private StorageReference shot2s = _firebase_storage.getReference("shot2");
	private OnCompleteListener<Uri> _shot2s_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _shot2s_download_success_listener;
	private OnSuccessListener _shot2s_delete_success_listener;
	private OnProgressListener _shot2s_upload_progress_listener;
	private OnProgressListener _shot2s_download_progress_listener;
	private OnFailureListener _shot2s_failure_listener;
	
	private StorageReference icon_ = _firebase_storage.getReference("icon");
	private OnCompleteListener<Uri> _icon__upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _icon__download_success_listener;
	private OnSuccessListener _icon__delete_success_listener;
	private OnProgressListener _icon__upload_progress_listener;
	private OnProgressListener _icon__download_progress_listener;
	private OnFailureListener _icon__failure_listener;
	
	private Vibrator v;
	private TimerTask t;
	private Intent acc_bab = new Intent();
	private TimerTask two;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.project_view);
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
		
		toolbar_outer = findViewById(R.id.toolbar_outer);
		progress_main = findViewById(R.id.progress_main);
		vscroll1 = findViewById(R.id.vscroll1);
		toolbar = findViewById(R.id.toolbar);
		backk = findViewById(R.id.backk);
		textview10 = findViewById(R.id.textview10);
		imageview23 = findViewById(R.id.imageview23);
		arrow_down_more = findViewById(R.id.arrow_down_more);
		verify = findViewById(R.id.verify);
		nothing = findViewById(R.id.nothing);
		progressbar1 = findViewById(R.id.progressbar1);
		back = findViewById(R.id.back);
		linear1 = findViewById(R.id.linear1);
		linear47 = findViewById(R.id.linear47);
		linear46 = findViewById(R.id.linear46);
		linear4 = findViewById(R.id.linear4);
		linear_down = findViewById(R.id.linear_down);
		linear16 = findViewById(R.id.linear16);
		hscroll5 = findViewById(R.id.hscroll5);
		icon = findViewById(R.id.icon);
		linear18 = findViewById(R.id.linear18);
		title = findViewById(R.id.title);
		username = findViewById(R.id.username);
		linear44 = findViewById(R.id.linear44);
		sketch_apk = findViewById(R.id.sketch_apk);
		sketch_project = findViewById(R.id.sketch_project);
		category_linear = findViewById(R.id.category_linear);
		verified_r_project = findViewById(R.id.verified_r_project);
		android_studio = findViewById(R.id.android_studio);
		editor = findViewById(R.id.editor);
		android_studio_apk = findViewById(R.id.android_studio_apk);
		textview46 = findViewById(R.id.textview46);
		textview47 = findViewById(R.id.textview47);
		textview_category = findViewById(R.id.textview_category);
		imageview22 = findViewById(R.id.imageview22);
		textview49 = findViewById(R.id.textview49);
		textview50 = findViewById(R.id.textview50);
		imageview26 = findViewById(R.id.imageview26);
		textview56 = findViewById(R.id.textview56);
		textview51 = findViewById(R.id.textview51);
		linear9 = findViewById(R.id.linear9);
		like_linear = findViewById(R.id.like_linear);
		cmt_linear = findViewById(R.id.cmt_linear);
		dwnd_linear = findViewById(R.id.dwnd_linear);
		like_btn = findViewById(R.id.like_btn);
		linear11 = findViewById(R.id.linear11);
		likes = findViewById(R.id.likes);
		textview11 = findViewById(R.id.textview11);
		imageview6 = findViewById(R.id.imageview6);
		linear13 = findViewById(R.id.linear13);
		comments = findViewById(R.id.comments);
		textview53 = findViewById(R.id.textview53);
		imageview7 = findViewById(R.id.imageview7);
		linear15 = findViewById(R.id.linear15);
		download_cnt = findViewById(R.id.download_cnt);
		textview14 = findViewById(R.id.textview14);
		progress_bar = findViewById(R.id.progress_bar);
		download_btn = findViewById(R.id.download_btn);
		demo_link = findViewById(R.id.demo_link);
		progress = findViewById(R.id.progress);
		textview27 = findViewById(R.id.textview27);
		vscroll2 = findViewById(R.id.vscroll2);
		linear20 = findViewById(R.id.linear20);
		whats_new_linear = findViewById(R.id.whats_new_linear);
		linear23 = findViewById(R.id.linear23);
		linear21 = findViewById(R.id.linear21);
		pub_by_ban = findViewById(R.id.pub_by_ban);
		linear27 = findViewById(R.id.linear27);
		share_lin = findViewById(R.id.share_lin);
		report_lin = findViewById(R.id.report_lin);
		linear52 = findViewById(R.id.linear52);
		linear35 = findViewById(R.id.linear35);
		what_new = findViewById(R.id.what_new);
		wn_img = findViewById(R.id.wn_img);
		textview17 = findViewById(R.id.textview17);
		imageview18 = findViewById(R.id.imageview18);
		hscroll1 = findViewById(R.id.hscroll1);
		linear_inner_sc = findViewById(R.id.linear_inner_sc);
		vid_linear = findViewById(R.id.vid_linear);
		shot1 = findViewById(R.id.shot1);
		shot2 = findViewById(R.id.shot2);
		button1 = findViewById(R.id.button1);
		yt_thumb = findViewById(R.id.yt_thumb);
		linear37 = findViewById(R.id.linear37);
		textview16 = findViewById(R.id.textview16);
		textview15 = findViewById(R.id.textview15);
		linear34 = findViewById(R.id.linear34);
		linear53 = findViewById(R.id.linear53);
		time = findViewById(R.id.time);
		linear48 = findViewById(R.id.linear48);
		textview57 = findViewById(R.id.textview57);
		adview_l = findViewById(R.id.adview_l);
		textview58 = findViewById(R.id.textview58);
		pub_by = findViewById(R.id.pub_by);
		textview26 = findViewById(R.id.textview26);
		pub_by_in = findViewById(R.id.pub_by_in);
		imageview_pub_ic = findViewById(R.id.imageview_pub_ic);
		pub_by_inner = findViewById(R.id.pub_by_inner);
		linear29 = findViewById(R.id.linear29);
		hscroll2 = findViewById(R.id.hscroll2);
		textview_publisher = findViewById(R.id.textview_publisher);
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
		linear57 = findViewById(R.id.linear57);
		linear56 = findViewById(R.id.linear56);
		linear58 = findViewById(R.id.linear58);
		textview59 = findViewById(R.id.textview59);
		imageview24 = findViewById(R.id.imageview24);
		textview55 = findViewById(R.id.textview55);
		imageview25 = findViewById(R.id.imageview25);
		textview54 = findViewById(R.id.textview54);
		auth = FirebaseAuth.getInstance();
		delete = new AlertDialog.Builder(this);
		report = new AlertDialog.Builder(this);
		Network = new RequestNetwork(this);
		Verified = new AlertDialog.Builder(this);
		short_ur = new RequestNetwork(this);
		transferdata = getSharedPreferences("transferdata", Activity.MODE_PRIVATE);
		v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		
		backk.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				onBackPressed();
			}
		});
		
		imageview23.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				report.setTitle("Extra Actions Administrator??");
				report.setPositiveButton("Make As Admin", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						if (Admin) {
							admin_role_map = new HashMap<>();
							admin_role_map.put("role", "developer");
							users.child(uid).updateChildren(admin_role_map);
							admin_role_map.clear();
						}
						else {
							admin_role_map = new HashMap<>();
							admin_role_map.put("role", "admin");
							users.child(uid).updateChildren(admin_role_map);
							admin_role_map.clear();
						}
					}
				});
				report.setNegativeButton("Make As Moderator", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						if (Moderator) {
							admin_role_map = new HashMap<>();
							admin_role_map.put("role", "developer");
							users.child(uid).updateChildren(admin_role_map);
							admin_role_map.clear();
						}
						else {
							admin_role_map = new HashMap<>();
							admin_role_map.put("role", "moderator");
							users.child(uid).updateChildren(admin_role_map);
							admin_role_map.clear();
						}
					}
				});
				report.setNeutralButton("EDITOR", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						if (Editor) {
							admin_role_map = new HashMap<>();
							admin_role_map.put("editor", "false");
							data1.child(key).updateChildren(admin_role_map);
							admin_role_map.clear();
						}
						else {
							admin_role_map = new HashMap<>();
							admin_role_map.put("editor", "true");
							data1.child(key).updateChildren(admin_role_map);
							admin_role_map.clear();
						}
					}
				});
				report.create().show();
			}
		});
		
		arrow_down_more.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (NetOk) {
					if (admins.contains(FirebaseAuth.getInstance().getCurrentUser().getEmail())) {
						delete.setTitle("Admin Any Actions?");
						delete.setPositiveButton("Verify User", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								admin_role_map = new HashMap<>();
								admin_role_map.put("role", "verified");
								users.child(uid).updateChildren(admin_role_map);
								admin_role_map.clear();
							}
						});
						delete.setNegativeButton("Verify Project", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								verification = new HashMap<>();
								verification.put("verification", "true");
								data1.child(key).updateChildren(verification);
								verification.clear();
							}
						});
						delete.setNeutralButton("Delete", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								_ProgresbarShow("Deleteing...");
								usr_dwnds = new HashMap<>();
								usr_dwnds.put("value", "false");
								usr_dwnds.put("likes", likes.getText().toString());
								users.child(uid).updateChildren(usr_dwnds);
								usr_dwnds.clear();
								usr_dwnds = new HashMap<>();
								usr_dwnds.put("value", "false");
								usr_dwnds.put("downloads", download_cnt.getText().toString());
								users.child(uid).updateChildren(usr_dwnds);
								usr_dwnds.clear();
								if (!icon_URL.equals("")) {
									_firebase_storage.getReferenceFromUrl(icon_URL).delete().addOnSuccessListener(_icon__delete_success_listener).addOnFailureListener(_icon__failure_listener);
								}
								if (!URL.equals("")) {
									_firebase_storage.getReferenceFromUrl(URL).delete().addOnSuccessListener(_project_delete_success_listener).addOnFailureListener(_project_failure_listener);
								}
								if (!shot1url.equals("")) {
									_firebase_storage.getReferenceFromUrl(shot1url).delete().addOnSuccessListener(_shot1s_delete_success_listener).addOnFailureListener(_shot1s_failure_listener);
								}
								if (!shot2url.equals("")) {
									_firebase_storage.getReferenceFromUrl(shot2url).delete().addOnSuccessListener(_shot2s_delete_success_listener).addOnFailureListener(_shot2s_failure_listener);
								}
								timer = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												data1.child(key).removeValue();
												like.child(key).removeValue();
												comment.child(key).removeValue();
												timer = new TimerTask() {
													@Override
													public void run() {
														runOnUiThread(new Runnable() {
															@Override
															public void run() {
																_ProgresbarDimiss();
																intent.setClass(getApplicationContext(), HomeActivity.class);
																intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
																startActivity(intent);
																finish();
															}
														});
													}
												};
												_timer.schedule(timer, (int)(750));
											}
										});
									}
								};
								_timer.schedule(timer, (int)(500));
							}
						});
						delete.create().show();
					}
					else {
						if (FirebaseAuth.getInstance().getCurrentUser().getUid().equals(uid)) {
							delete.setTitle("Options");
							delete.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									_ProgresbarShow("Deleteing...");
									usr_dwnds = new HashMap<>();
									usr_dwnds.put("value", "false");
									usr_dwnds.put("likes", likes.getText().toString());
									users.child(uid).updateChildren(usr_dwnds);
									usr_dwnds.clear();
									usr_dwnds = new HashMap<>();
									usr_dwnds.put("value", "false");
									usr_dwnds.put("downloads", download_cnt.getText().toString());
									users.child(uid).updateChildren(usr_dwnds);
									usr_dwnds.clear();
									if (!icon_URL.equals("")) {
										_firebase_storage.getReferenceFromUrl(icon_URL).delete().addOnSuccessListener(_icon__delete_success_listener).addOnFailureListener(_icon__failure_listener);
									}
									if (!URL.equals("")) {
										_firebase_storage.getReferenceFromUrl(URL).delete().addOnSuccessListener(_project_delete_success_listener).addOnFailureListener(_project_failure_listener);
									}
									if (!shot1url.equals("")) {
										_firebase_storage.getReferenceFromUrl(shot1url).delete().addOnSuccessListener(_shot1s_delete_success_listener).addOnFailureListener(_shot1s_failure_listener);
									}
									if (!shot2url.equals("")) {
										_firebase_storage.getReferenceFromUrl(shot2url).delete().addOnSuccessListener(_shot2s_delete_success_listener).addOnFailureListener(_shot2s_failure_listener);
									}
									timer = new TimerTask() {
										@Override
										public void run() {
											runOnUiThread(new Runnable() {
												@Override
												public void run() {
													data1.child(key).removeValue();
													timer = new TimerTask() {
														@Override
														public void run() {
															runOnUiThread(new Runnable() {
																@Override
																public void run() {
																	_ProgresbarDimiss();
																	intent.setClass(getApplicationContext(), HomeActivity.class);
																	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
																	startActivity(intent);
																	finish();
																}
															});
														}
													};
													_timer.schedule(timer, (int)(750));
												}
											});
										}
									};
									_timer.schedule(timer, (int)(500));
								}
							});
							delete.setNegativeButton("Share", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									_Share("Share Using", "http://projects.sketify.tk/?id=".concat(key));
								}
							});
							delete.setNeutralButton("Report", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									reprtt.setClass(getApplicationContext(), ReportActivity.class);
									reprtt.putExtra("user", username.getText().toString());
									reprtt.putExtra("img", icon_URL);
									reprtt.putExtra("title", title.getText().toString());
									reprtt.putExtra("key", key);
									reprtt.putExtra("mode", "project");
									startActivity(reprtt);
								}
							});
							delete.create().show();
						}
						else {
							delete.setTitle("Options");
							delete.setPositiveButton("Share", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									_Share("Share Using", "http://projects.sketify.tk/?id=".concat(key));
								}
							});
							delete.setNeutralButton("Report", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									reprtt.setClass(getApplicationContext(), ReportActivity.class);
									reprtt.putExtra("user", username.getText().toString());
									reprtt.putExtra("img", icon_URL);
									reprtt.putExtra("title", title.getText().toString());
									reprtt.putExtra("key", key);
									reprtt.putExtra("mode", "project");
									startActivity(reprtt);
								}
							});
							delete.create().show();
						}
					}
				}
			}
		});
		
		verify.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (NetOk) {
					if (moderators.contains(FirebaseAuth.getInstance().getCurrentUser().getEmail()) || admins.contains(FirebaseAuth.getInstance().getCurrentUser().getEmail())) {
						if (verified) {
							map2 = new HashMap<>();
							map2.put("verification", "false");
							data1.child(key).updateChildren(map2);
							map2.clear();
							SketchwareUtil.showMessage(getApplicationContext(), "Not Verified");
							verified_r_project.setVisibility(View.GONE);
							finish();
						}
						else {
							map2 = new HashMap<>();
							map2.put("verification", "true");
							data1.child(key).updateChildren(map2);
							map2.clear();
							SketchwareUtil.showMessage(getApplicationContext(), "Verified Project!!");
							verified_r_project.setVisibility(View.VISIBLE);
							finish();
						}
					}
					else {
						if (verified) {
							SketchwareUtil.showMessage(getApplicationContext(), "Verified Project!!");
							verified_r_project.setVisibility(View.VISIBLE);
						}
						else {
							SketchwareUtil.showMessage(getApplicationContext(), "Unverified Project!");
							verified_r_project.setVisibility(View.GONE);
						}
					}
				}
			}
		});
		
		icon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				fullview.setClass(getApplicationContext(), FullviewActivity.class);
				fullview.putExtra("main", icon_URL);
				startActivity(fullview);
			}
		});
		
		username.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		category_linear.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				c_view.setClass(getApplicationContext(), CategoryActivity.class);
				c_view.putExtra("c", textview_category.getText().toString());
				startActivity(c_view);
			}
		});
		
		verified_r_project.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Verified.setTitle("Verified Product");
				Verified.setMessage("This Project is A Verified Project!\n\nAnytime You Upload Your Project to Sketify, You want to Wait For Our Team To Verify Your Project.\n\nTip: If You want To Verify Your Project Earlier, You want to Upload Valid Screenshots,Decent Icon with Attractive Title & Detailed Description.\n\nProblem :\nif your project doesn't verified For A Long Time You want To Check The Comments And Your Project Carefully For Any Problems.Thanks.");
				Verified.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				Verified.create().show();
			}
		});
		
		like_linear.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_custom_loading(true);
				timer = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_custom_loading(false);
								if (liked) {
									map = new HashMap<>();
									map.put("value", "false");
									map.put("key", key);
									map.put("like_key", like_key);
									map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
									like.child(like_key).updateChildren(map);
								}
								else {
									map = new HashMap<>();
									map.put("value", "true");
									map.put("key", key);
									map.put("like_key", like_key);
									map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
									like.child(like_key).updateChildren(map);
								}
							}
						});
					}
				};
				_timer.schedule(timer, (int)(999));
			}
		});
		
		cmt_linear.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (comment_visibility) {
					intent.setClass(getApplicationContext(), CommentsActivity.class);
					intent.putExtra("title", title.getText().toString());
					intent.putExtra("key", key);
					intent.putExtra("uid", uid);
					intent.putExtra("value", "true");
					startActivity(intent);
				}
				else {
					intent.setClass(getApplicationContext(), CommentsActivity.class);
					intent.putExtra("title", title.getText().toString());
					intent.putExtra("key", key);
					intent.putExtra("uid", uid);
					intent.putExtra("value", "false");
					startActivity(intent);
				}
			}
		});
		
		dwnd_linear.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		download_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final AlertDialog success_dialog = new AlertDialog.Builder(ProjectViewActivity.this).create();
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
				
				
				s_msg.setText("Are You Sure Download This File?");
				s_title.setText("Confirm");
				s_ok.setOnClickListener(new View.OnClickListener(){
					    public void onClick(View v){
						success_dialog.dismiss();
						_custom_loading(true);
						timer = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										_custom_loading(false);
										if (apk_ok) {
											progresss = 0;
											for(int _repeat318 = 0; _repeat318 < (int)(progresss); _repeat318++) {
												progresss++;
												progress.setProgress((int)progresss);
												textview27.setText(String.valueOf((long)(progresss)).concat("%"));
												if (String.valueOf((long)(progress.getProgress())).equals("100")) {
													
												}
											}
											download_num++;
											usr_dwnds = new HashMap<>();
											usr_dwnds.put("value", "true");
											usr_dwnds.put("downloads", String.valueOf((long)(download_num)));
											data1.child(key).updateChildren(usr_dwnds);
											usr_dwnds.clear();
											textview27.setText("0%");
											if (!FileUtil.isExistFile("/Sketify".concat("/").concat("Downloads/"))) {
												FileUtil.makeDir("/Sketify".concat("/").concat("Downloads/"));
											}
											_Download(URL, "/Sketify".concat("/").concat("Downloads/"));
											download_btn.setVisibility(View.GONE);
											progress_bar.setVisibility(View.VISIBLE);
											progress.setMax((int)100);
											progress.setProgress((int)0);
										}
										else {
											if (as) {
												download_num++;
												usr_dwnds.put("value", "true");
												usr_dwnds.put("downloads", String.valueOf((long)(download_num)));
												data1.child(key).updateChildren(usr_dwnds);
												usr_dwnds.clear();
												if (!FileUtil.isExistFile(Sketify_Directory.concat("Android Studio/"))) {
													FileUtil.makeDir(Sketify_Directory.concat("Android Studio/"));
												}
												as_path = Sketify_Directory.concat("Android Studio/").concat(URLUtil.guessFileName( URL, null, null));
												_firebase_storage.getReferenceFromUrl(URL).getFile(new File(Sketify_Directory.concat("Android Studio/").concat(URLUtil.guessFileName( URL, null, null)))).addOnSuccessListener(_project_download_success_listener).addOnFailureListener(_project_failure_listener).addOnProgressListener(_project_download_progress_listener);
												download_btn.setVisibility(View.GONE);
												progress_bar.setVisibility(View.VISIBLE);
												progress.setMax((int)100);
												progress.setProgress((int)0);
												textview27.setText("0%");
											}
											else {
												if (project_ok) {
													download_num++;
													usr_dwnds.put("value", "true");
													usr_dwnds.put("downloads", String.valueOf((long)(download_num)));
													data1.child(key).updateChildren(usr_dwnds);
													usr_dwnds.clear();
													if (!FileUtil.isExistFile(Sketify_Hidden_Path.concat(".project/"))) {
														FileUtil.makeDir(Sketify_Hidden_Path.concat(".project/"));
													}
													_firebase_storage.getReferenceFromUrl(URL).getFile(new File(Sketify_Hidden_Path.concat(".project/temp.zip"))).addOnSuccessListener(_project_download_success_listener).addOnFailureListener(_project_failure_listener).addOnProgressListener(_project_download_progress_listener);
													download_btn.setVisibility(View.GONE);
													progress_bar.setVisibility(View.VISIBLE);
													progress.setMax((int)100);
													progress.setProgress((int)0);
													textview27.setText("0%");
												}
											}
										}
									}
								});
							}
						};
						_timer.schedule(timer, (int)(999));
					}});
				s_cancel.setOnClickListener(new View.OnClickListener(){
					    public void onClick(View v){
						success_dialog.dismiss();
					}});
				success_dialog.show();
				_bounce(s_header);
			}
		});
		
		demo_link.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				msg = "This Demo Link was Redirected To ".concat(d_Url.concat(" By The Uploader, Are You Sure You Want To Go There?"));
				_Create_Spannbale(msg);
				_Spannable_Bold(msg.indexOf(d_Url), msg.indexOf(d_Url) + d_Url.length());
				final AlertDialog success_dialog = new AlertDialog.Builder(ProjectViewActivity.this).create();
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
				
				
				
				s_msg.setText(s);
				s_title.setText("Confirm");
				s_ok.setOnClickListener(new View.OnClickListener(){
					    public void onClick(View v){
						success_dialog.dismiss();
						dm_link.setAction(Intent.ACTION_VIEW);
						dm_link.setData(Uri.parse(d_Url));
						startActivity(dm_link);
					}});
				s_cancel.setOnClickListener(new View.OnClickListener(){
					    public void onClick(View v){
						success_dialog.dismiss();
					}});
				success_dialog.show();
				_bounce(s_header);
			}
		});
		
		share_lin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Share("Share Using", "http://projects.sketify.tk/?id=".concat(key));
			}
		});
		
		report_lin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				reprtt.setClass(getApplicationContext(), ReportActivity.class);
				reprtt.putExtra("user", username.getText().toString());
				reprtt.putExtra("img", icon_URL);
				reprtt.putExtra("title", title.getText().toString());
				reprtt.putExtra("key", key);
				reprtt.putExtra("mode", "project");
				startActivity(reprtt);
			}
		});
		
		linear35.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (whatnewopened) {
					what_new.setVisibility(View.GONE);
					imageview18.setImageResource(R.drawable.ic_arrow_drop_down_grey);
					whatnewopened = false;
				}
				else {
					what_new.setVisibility(View.VISIBLE);
					imageview18.setImageResource(R.drawable.ic_arrow_drop_up_grey);
					whatnewopened = true;
				}
			}
		});
		
		imageview18.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (whatnewopened) {
					what_new.setVisibility(View.GONE);
					imageview18.setImageResource(R.drawable.ic_arrow_drop_down_grey);
					whatnewopened = false;
				}
				else {
					what_new.setVisibility(View.VISIBLE);
					imageview18.setImageResource(R.drawable.ic_arrow_drop_up_grey);
					whatnewopened = true;
				}
			}
		});
		
		shot1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				fullview.setClass(getApplicationContext(), FullviewActivity.class);
				fullview.putExtra("main", shot1url);
				startActivity(fullview);
			}
		});
		
		shot2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				fullview.setClass(getApplicationContext(), FullviewActivity.class);
				fullview.putExtra("main", shot2url);
				startActivity(fullview);
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				view.setAction(Intent.ACTION_VIEW);
				view.setData(Uri.parse(ytvideo));
				startActivity(view);
			}
		});
		
		yt_thumb.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				fullview.setClass(getApplicationContext(), FullviewActivity.class);
				fullview.putExtra("main", id2);
				startActivity(fullview);
			}
		});
		
		pub_by.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!uid.equals("")) {
					view_profile.setClass(getApplicationContext(), ProfileActivity.class);
					view_profile.putExtra("uid", uid);
					startActivity(view_profile);
				}
			}
		});
		
		imageview_pub_ic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (profule.equals("")) {
					fullview.setClass(getApplicationContext(), FullviewActivity.class);
					fullview.putExtra("main", "avator");
					startActivity(fullview);
				}
				else {
					fullview.setClass(getApplicationContext(), FullviewActivity.class);
					fullview.putExtra("main", profule);
					startActivity(fullview);
				}
			}
		});
		
		pub_by_inner.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				pub_by.performClick();
			}
		});
		
		textview_publisher.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		linear33.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				pub_by.performClick();
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edit.setClass(getApplicationContext(), UploadActivity.class);
				edit.putExtra("key", key);
				edit.putExtra("mode", "edit");
				startActivity(edit);
			}
		});
		
		_data1_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(key)) {
					No_1 = true;
					if (_childValue.containsKey("visibility")) {
						if (_childValue.get("visibility").toString().equals("false")) {
							if (!_childValue.get("uid").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
								timer = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												if (NetOk) {
													timer.cancel();
													privated = true;
													_Toolbar(false);
													vscroll1.setVisibility(View.GONE);
													progress_main.setVisibility(View.VISIBLE);
													nothing.setVisibility(View.VISIBLE);
													progressbar1.setVisibility(View.GONE);
													
													// Create Dialog Error
													                          
													final AlertDialog error_dialog = new AlertDialog.Builder(ProjectViewActivity.this).create();
													
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
													                          
													e_msg.setText("This Project is Private");
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
										});
									}
								};
								_timer.scheduleAtFixedRate(timer, (int)(250), (int)(250));
							}
							else {
								_GetData(_childKey, _childValue);
							}
						}
						else {
							_GetData(_childKey, _childValue);
						}
					}
					else {
						_GetData(_childKey, _childValue);
					}
					textview15.setClickable(true);
					android.text.util.Linkify.addLinks(textview15, android.text.util.Linkify.ALL);
					textview15.setLinkTextColor(Color.parseColor("#2196F3"));
					textview15.setLinksClickable(true);
					
					what_new.setClickable(true);
					android.text.util.Linkify.addLinks(what_new, android.text.util.Linkify.ALL);
					what_new.setLinkTextColor(Color.parseColor("#2196F3"));
					what_new.setLinksClickable(true);
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(key)) {
					if (_childValue.containsKey("icon")) {
						Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("icon").toString())).into(icon);
						icon_URL = _childValue.get("icon").toString();
					}
					else {
						icon.setImageResource(R.drawable.android_icon);
					}
					if (_childValue.containsKey("title")) {
						title.setText(_childValue.get("title").toString());
						textview10.setText(_childValue.get("title").toString());
					}
					if (_childValue.containsKey("likes")) {
						likes.setText(_childValue.get("likes").toString());
					}
					if (_childValue.containsKey("comments")) {
						comments.setText(_childValue.get("comments").toString());
					}
					if (_childValue.containsKey("project")) {
						URL = _childValue.get("project").toString();
						project_ok = true;
						apk_ok = false;
					}
					else {
						if (_childValue.containsKey("apk")) {
							URL = _childValue.get("apk").toString();
							apk_ok = true;
							project_ok = false;
						}
					}
					if (_childValue.containsKey("downloads")) {
						download_cnt.setText(_childValue.get("downloads").toString());
						download_num = Double.parseDouble(_childValue.get("downloads").toString());
					}
					if (_childValue.containsKey("description")) {
						textview15.setText(_childValue.get("description").toString());
					}
					if (_childValue.containsKey("comments_visibility")) {
						if (_childValue.get("comments_visibility").toString().equals("true")) {
							comment_visibility = true;
						}
						else {
							if (_childValue.get("comments_visibility").toString().equals("false")) {
								comment_visibility = false;
							}
							else {
								comment_visibility = true;
							}
						}
					}
					if (_childValue.containsKey("shot1")) {
						Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("shot1").toString())).into(shot1);
						shot1url = "";
						shot1url = _childValue.get("shot1").toString();
					}
					if (_childValue.containsKey("shot2")) {
						Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("shot2").toString())).into(shot2);
						shot2url = "";
						shot2url = _childValue.get("shot2").toString();
					}
					if (_childValue.containsKey("yt_url")) {
						if (_childValue.get("yt_url").toString().equals("")) {
							vid_linear.setVisibility(View.GONE);
						}
						else {
							if (_childValue.get("yt_url").toString().contains("https://")) {
								ytvideo = _childValue.get("yt_url").toString();
								id = _childValue.get("yt_url").toString().replace("https://youtu.be/", "");
								id2 = "https://i.ytimg.com/vi/".concat(id.concat("/maxresdefault.jpg"));
								vid_linear.setVisibility(View.GONE);
								if (!id2.equals("")) {
									vid_linear.setVisibility(View.VISIBLE);
									Glide.with(getApplicationContext()).load(Uri.parse(id2)).into(yt_thumb);
								}
							}
							else {
								vid_linear.setVisibility(View.GONE);
							}
						}
					}
					if (_childValue.containsKey("whatsnew")) {
						if (_childValue.get("whatsnew").toString().equals("")) {
							whats_new_linear.setVisibility(View.GONE);
						}
						else {
							whats_new_linear.setVisibility(View.VISIBLE);
							what_new.setText(_childValue.get("whatsnew").toString());
						}
					}
					if (_childValue.containsKey("project category")) {
						if (_childValue.get("project category").toString().equals("Sketchware Project")) {
							sketch_apk.setVisibility(View.GONE);
							sketch_project.setVisibility(View.VISIBLE);
							verified_r_project.setVisibility(View.GONE);
							android_studio_apk.setVisibility(View.GONE);
							android_studio.setVisibility(View.GONE);
							as = false;
						}
						else {
							if (_childValue.get("project category").toString().equals("Sketchware Apk")) {
								sketch_apk.setVisibility(View.VISIBLE);
								sketch_project.setVisibility(View.GONE);
								verified_r_project.setVisibility(View.GONE);
								android_studio_apk.setVisibility(View.GONE);
								android_studio.setVisibility(View.GONE);
								as = false;
							}
							else {
								if (_childValue.get("project category").toString().equals("Android Studio Apk")) {
									sketch_apk.setVisibility(View.GONE);
									sketch_project.setVisibility(View.GONE);
									verified_r_project.setVisibility(View.GONE);
									android_studio_apk.setVisibility(View.VISIBLE);
									android_studio.setVisibility(View.GONE);
									as = false;
								}
								else {
									if (_childValue.get("project category").toString().equals("Android Studio")) {
										sketch_apk.setVisibility(View.GONE);
										sketch_project.setVisibility(View.GONE);
										verified_r_project.setVisibility(View.GONE);
										android_studio_apk.setVisibility(View.GONE);
										android_studio.setVisibility(View.VISIBLE);
										as = true;
									}
									else {
										sketch_apk.setVisibility(View.GONE);
										sketch_project.setVisibility(View.VISIBLE);
										verified_r_project.setVisibility(View.GONE);
										android_studio_apk.setVisibility(View.GONE);
										android_studio.setVisibility(View.GONE);
									}
								}
							}
						}
					}
					else {
						sketch_apk.setVisibility(View.GONE);
						sketch_project.setVisibility(View.VISIBLE);
						verified_r_project.setVisibility(View.GONE);
						android_studio_apk.setVisibility(View.GONE);
						android_studio.setVisibility(View.GONE);
					}
					if (_childValue.containsKey("short_url")) {
						share = _childValue.get("short_url").toString();
					}
					else {
						url_to_short = "https://projects.sketify.tk/project?id=prefix-9a71e0719545676a138b25f1a00c30e4dfba301d?&&".concat(key.concat("&&afl=https://sketify.tk&efr=1"));
						json = "{\n   \"longDynamicLink\": \"https://project.sketify.tk/?link=".concat(url_to_short.concat("\",\n     \"suffix\": {\n    \"option\": \"SHORT\"\n   }\n}"));
						short_mapper = new Gson().fromJson(json, new TypeToken<HashMap<String, Object>>(){}.getType());
						short_ur.setParams(short_mapper, RequestNetworkController.REQUEST_BODY);
						short_ur.startRequestNetwork(RequestNetworkController.POST, "https://firebasedynamiclinks.googleapis.com/v1/shortLinks?key=AIzaSyC1-BdIOp_HBnf1Nq0MrOw4C6Cc2HryaV8", "any", _short_ur_request_listener);
					}
					if (_childValue.containsKey("time")) {
						time.setText(_childValue.get("time").toString());
					}
					else {
						time.setVisibility(View.GONE);
					}
					if (_childValue.containsKey("demo")) {
						if (!_childValue.get("demo").toString().equals("")) {
							demo_link.setVisibility(View.VISIBLE);
							d_Url = _childValue.get("demo").toString();
						}
						else {
							demo_link.setVisibility(View.GONE);
						}
					}
					else {
						demo_link.setVisibility(View.GONE);
					}
					if (_childValue.containsKey("editor")) {
						if (_childValue.get("editor").toString().equals("true")) {
							editor.setVisibility(View.VISIBLE);
							Editor = true;
						}
						else {
							editor.setVisibility(View.GONE);
							Editor = false;
						}
					}
					else {
						editor.setVisibility(View.GONE);
					}
					if (_childValue.containsKey("category")) {
						category_linear.setVisibility(View.VISIBLE);
						textview_category.setText(_childValue.get("category").toString());
					}
					else {
						category_linear.setVisibility(View.GONE);
					}
					if (_childValue.containsKey("size")) {
						download_btn.setText("DOWNLOAD (".concat(_childValue.get("size").toString().concat(")")));
					}
					if (_childValue.containsKey("verification")) {
						if (_childValue.get("verification").toString().equals("true")) {
							verified = true;
							verify.setImageResource(R.drawable.ic_hdr_strong_white);
							verified_r_project.setVisibility(View.VISIBLE);
						}
						else {
							verified = false;
							verify.setImageResource(R.drawable.ic_hdr_weak_white);
							verified_r_project.setVisibility(View.GONE);
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
				if (_childKey.equals(uid)) {
					No_2 = true;
					if (_childValue.containsKey("status")) {
						if (!_childValue.get("status").toString().equals("banned")) {
							pub_by_ban.setVisibility(View.GONE);
							if (_childValue.containsKey("name")) {
								username.setText(_childValue.get("name").toString());
								textview_publisher.setText(_childValue.get("name").toString());
							}
							if (_childValue.containsKey("profile")) {
								if (!_childValue.get("profile").toString().equals("")) {
									if (!_childValue.get("profile").toString().equals("avator")) {
										_setCircleImageURL(imageview_pub_ic, _childValue.get("profile").toString(), 3, "#FFFFFF");
										profule = _childValue.get("profile").toString();
									}
									else {
										imageview_pub_ic.setImageResource(R.drawable.default_avatar);
										profule = _childValue.get("profile").toString();
									}
								}
								else {
									imageview_pub_ic.setImageResource(R.drawable.default_avatar);
									profule = _childValue.get("profile").toString();
								}
							}
							else {
								imageview_pub_ic.setImageResource(R.drawable.default_avatar);
								profule = _childValue.get("profile").toString();
							}
							if (_childValue.containsKey("role")) {
								if (_childValue.get("role").toString().equals("admin")) {
									admin.setVisibility(View.VISIBLE);
									moderator.setVisibility(View.GONE);
									verified_linear.setVisibility(View.GONE);
									premium.setVisibility(View.GONE);
									developer.setVisibility(View.GONE);
									vip.setVisibility(View.GONE);
									Admin = true;
									Moderator = false;
									verifiedUser = false;
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
									Moderator = true;
									Admin = false;
									verifiedUser = false;
								}
								if (_childValue.get("role").toString().equals("verified")) {
									admin.setVisibility(View.GONE);
									moderator.setVisibility(View.GONE);
									verified_linear.setVisibility(View.VISIBLE);
									premium.setVisibility(View.GONE);
									developer.setVisibility(View.GONE);
									vip.setVisibility(View.GONE);
									verifiedUser = true;
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
						}
						else {
							pub_by_ban.setVisibility(View.VISIBLE);
							pub_by.setVisibility(View.GONE);
							username.setVisibility(View.GONE);
						}
					}
					else {
						pub_by_ban.setVisibility(View.VISIBLE);
						pub_by.setVisibility(View.GONE);
						username.setVisibility(View.GONE);
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(uid)) {
					if (_childValue.containsKey("name")) {
						username.setText(_childValue.get("name").toString());
						textview_publisher.setText(_childValue.get("name").toString());
					}
					if (_childValue.containsKey("profile")) {
						if (!_childValue.get("profile").toString().equals("")) {
							_setCircleImageURL(imageview_pub_ic, _childValue.get("profile").toString(), 3, "#FFFFFF");
							profule = _childValue.get("profile").toString();
						}
						else {
							imageview_pub_ic.setImageResource(R.drawable.default_avatar);
							profule = _childValue.get("profile").toString();
						}
					}
					else {
						imageview_pub_ic.setImageResource(R.drawable.default_avatar);
						profule = _childValue.get("profile").toString();
					}
					if (_childValue.containsKey("role")) {
						if (_childValue.get("role").toString().equals("admin")) {
							admin.setVisibility(View.VISIBLE);
							moderator.setVisibility(View.GONE);
							verified_linear.setVisibility(View.GONE);
							premium.setVisibility(View.GONE);
							developer.setVisibility(View.GONE);
							vip.setVisibility(View.GONE);
							Admin = true;
							Moderator = false;
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
							Moderator = true;
							Admin = false;
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
		
		_project_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_project_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				progress.setProgress((int)_progressValue);
				textview27.setText(String.valueOf((long)(progress.getProgress())).concat("%"));
			}
		};
		
		_project_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				
			}
		};
		
		_project_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				v.vibrate((long)(500));
				if (!as) {
					if (project_ok) {
						progress.setProgress((int)100);
						textview27.setText(String.valueOf((long)(100)).concat("%"));
						progress_bar.setVisibility(View.GONE);
						download_btn.setVisibility(View.VISIBLE);
						progress.setProgress((int)0);
						textview27.setText("0%");
						transfer.setClass(getApplicationContext(), ProjectManagerActivity.class);
						transfer.putExtra("mode", "transfer");
						startActivity(transfer);
					}
					else {
						if (apk_ok) {
							
							showMessage( "Apk Saved To" + pathapk);
							
							progress.setProgress((int)(100));
							
							progress_bar.setVisibility(View.GONE);
							
							download_btn.setVisibility(View.VISIBLE);
							
							progress.setProgress((int)(0));
							
							textview27.setText("0%");
							
							
							
						}
					}
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Project Saved To ".concat(as_path));
					progress_bar.setVisibility(View.GONE);
					download_btn.setVisibility(View.VISIBLE);
					progress.setProgress((int)0);
					textview27.setText("0%");
				}
			}
		};
		
		_project_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_project_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				progress_bar.setVisibility(View.GONE);
				download_btn.setVisibility(View.VISIBLE);
				progress.setProgress((int)0);
				textview27.setText("0%");
				SketchwareUtil.showMessage(getApplicationContext(), _message);
			}
		};
		
		_like_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if ((_childValue.containsKey("key") && _childValue.containsKey("value")) && _childValue.containsKey("uid")) {
					if (key.equals(_childValue.get("key").toString()) && _childValue.get("value").toString().equals("true")) {
						like_num++;
						map2 = new HashMap<>();
						map2.put("likes", String.valueOf((long)(like_num)));
						data1.child(key).updateChildren(map2);
						map2.clear();
						user_like = new HashMap<>();
						user_like.put("likes", String.valueOf((long)(like_num)));
						users.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(user_like);
						user_like.clear();
					}
					if (key.equals(_childValue.get("key").toString()) && _childValue.get("uid").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
						if (_childValue.get("value").toString().equals("true")) {
							like_btn.setImageResource(R.drawable.love_48dp);
							liked = true;
						}
						else {
							like_btn.setImageResource(R.drawable.ic_favorite_outline_black);
							liked = false;
						}
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.get("key").toString().equals(key)) {
					if (_childValue.get("value").toString().equals("true")) {
						like_num++;
						map2 = new HashMap<>();
						map2.put("likes", String.valueOf((long)(like_num)));
						data1.child(key).updateChildren(map2);
						map2.clear();
						user_like = new HashMap<>();
						user_like.put("value", "true");
						users.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(user_like);
						user_like.clear();
					}
					else {
						like_num--;
						map2 = new HashMap<>();
						map2.put("likes", String.valueOf((long)(like_num)));
						data1.child(key).updateChildren(map2);
						map2.clear();
						user_like = new HashMap<>();
						user_like.put("value", "false");
						users.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(user_like);
						user_like.clear();
					}
				}
				if (_childValue.get("key").toString().equals(key) && _childValue.get("uid").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					if (_childValue.get("value").toString().equals("true")) {
						like_btn.setImageResource(R.drawable.love_48dp);
						liked = true;
					}
					else {
						like_btn.setImageResource(R.drawable.ic_favorite_outline_black);
						liked = false;
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
		like.addChildEventListener(_like_child_listener);
		
		_comment_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("post_key")) {
					if (key.equals(_childValue.get("post_key").toString())) {
						comment_num++;
						map2 = new HashMap<>();
						map2.put("comments", String.valueOf((long)(comment_num)));
						data1.child(key).updateChildren(map2);
						map2.clear();
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("post_key")) {
					if (key.equals(_childValue.get("post_key").toString())) {
						comment_num++;
						map2 = new HashMap<>();
						map2.put("comments", String.valueOf((long)(comment_num)));
						data1.child(key).updateChildren(map2);
						map2.clear();
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
				if (_childValue.containsKey("post_key")) {
					if (key.equals(_childValue.get("post_key").toString())) {
						comment_num--;
						map2 = new HashMap<>();
						map2.put("comments", String.valueOf((long)(comment_num)));
						data1.child(key).updateChildren(map2);
						map2.clear();
					}
				}
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		comment.addChildEventListener(_comment_child_listener);
		
		_Network_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				if (Cprivated) {
					two = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									if (No_1 && No_2) {
										_Toolbar(true);
										progress_main.setVisibility(View.GONE);
										vscroll1.setVisibility(View.VISIBLE);
										toolbar.setVisibility(View.VISIBLE);
										if (uid.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
											_fab.show();
										}
										NetOk = true;
									}
								}
							});
						}
					};
					_timer.scheduleAtFixedRate(two, (int)(500), (int)(250));
				}
				else {
					t = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									if (!privated) {
										Cprivated = true;
										two = new TimerTask() {
											@Override
											public void run() {
												runOnUiThread(new Runnable() {
													@Override
													public void run() {
														if (No_1 && No_2) {
															_Toolbar(true);
															progress_main.setVisibility(View.GONE);
															vscroll1.setVisibility(View.VISIBLE);
															toolbar.setVisibility(View.VISIBLE);
															if (uid.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
																_fab.show();
															}
															NetOk = true;
														}
													}
												});
											}
										};
										_timer.scheduleAtFixedRate(two, (int)(500), (int)(250));
									}
								}
							});
						}
					};
					_timer.schedule(t, (int)(500));
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				if (!exit) {
					vscroll1.setVisibility(View.GONE);
					progress_main.setVisibility(View.VISIBLE);
					_fab.hide();
					final AlertDialog error_dialog = new AlertDialog.Builder(ProjectViewActivity.this).create();
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
					e_ok.setText("RETRY");
					
					e_cancel.setText("CLOSE");
					e_ok.setOnClickListener(new View.OnClickListener(){
						    public void onClick(View v){
							error_dialog.dismiss();
							NetOk = false;
							Network.startRequestNetwork(RequestNetworkController.GET, "https://gmail.com", "t", _Network_request_listener);
						}});
					e_cancel.setOnClickListener(new View.OnClickListener(){
						    public void onClick(View v){
							error_dialog.dismiss();
							finish();
						}});
					error_dialog.show();
					_bounce(e_header);
				}
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
					for(int _repeat163 = 0; _repeat163 < (int)(50); _repeat163++) {
						if (_childValue.containsKey("admin".concat(String.valueOf((long)(adn))).trim())) {
							if (!admins.contains(_childValue.get("admin".concat(String.valueOf((long)(adn))).trim()).toString())) {
								admins.add(_childValue.get("admin".concat(String.valueOf((long)(adn))).trim()).toString());
							}
							adn++;
						}
					}
					if (admins.contains(FirebaseAuth.getInstance().getCurrentUser().getEmail())) {
						imageview23.setVisibility(View.VISIBLE);
						_fab.show();
					}
					mdn = 0;
					for(int _repeat202 = 0; _repeat202 < (int)(50); _repeat202++) {
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
					for(int _repeat208 = 0; _repeat208 < (int)(50); _repeat208++) {
						if (_childValue.containsKey("admin".concat(String.valueOf((long)(adn))).trim())) {
							if (!admins.contains(_childValue.get("admin".concat(String.valueOf((long)(adn))).trim()).toString())) {
								admins.add(_childValue.get("admin".concat(String.valueOf((long)(adn))).trim()).toString());
								admins.remove((int)(admins.indexOf(_childValue.get("admin".concat(String.valueOf((long)(adn))).trim()).toString())));
							}
							adn++;
						}
					}
					if (admins.contains(FirebaseAuth.getInstance().getCurrentUser().getEmail())) {
						imageview23.setVisibility(View.VISIBLE);
						_fab.show();
					}
					mdn = 0;
					for(int _repeat239 = 0; _repeat239 < (int)(50); _repeat239++) {
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
					for(int _repeat244 = 0; _repeat244 < (int)(adn); _repeat244++) {
						if (_childValue.containsKey("admin".concat(String.valueOf((long)(adn))).trim())) {
							if (admins.contains(_childValue.get("admin".concat(String.valueOf((long)(adn))).trim()).toString())) {
								admins.remove((int)(admins.indexOf(_childValue.get("admin".concat(String.valueOf((long)(adn))).trim()).toString())));
							}
							adn++;
						}
					}
					if (admins.contains(FirebaseAuth.getInstance().getCurrentUser().getEmail())) {
						imageview23.setVisibility(View.VISIBLE);
						_fab.show();
					}
					else {
						imageview23.setVisibility(View.GONE);
						_fab.hide();
					}
					mdn = 0;
					for(int _repeat332 = 0; _repeat332 < (int)(mdn); _repeat332++) {
						if (_childValue.containsKey("moderator".concat(String.valueOf((long)(mdn))).trim())) {
							if (moderators.contains(_childValue.get("moderator".concat(String.valueOf((long)(mdn))).trim()).toString())) {
								moderators.remove((int)(moderators.indexOf(_childValue.get("moderator".concat(String.valueOf((long)(mdn))).trim()).toString())));
							}
							mdn++;
						}
					}
					if (moderators.contains(FirebaseAuth.getInstance().getCurrentUser().getEmail())) {
						imageview23.setVisibility(View.VISIBLE);
						_fab.show();
					}
					else {
						imageview23.setVisibility(View.GONE);
						_fab.hide();
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
		
		_short_ur_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				try{
					map = new Gson().fromJson(_response, new TypeToken<HashMap<String, Object>>(){}.getType());
					share_url = map.get("shortLink").toString();
					share_sender = new HashMap<>();
					share_sender.put("short_url", share_url);
					data1.child(key).updateChildren(share_sender);
					share_sender.clear();
				} catch (Exception e){
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_shot1s_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_shot1s_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_shot1s_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				
			}
		};
		
		_shot1s_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_shot1s_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_shot1s_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_shot2s_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_shot2s_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_shot2s_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				
			}
		};
		
		_shot2s_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_shot2s_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_shot2s_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_icon__upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_icon__download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_icon__upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				
			}
		};
		
		_icon__download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_icon__delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_icon__failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
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
		setTitle("Project Detail");
		whatnewopened = false;
		what_new.setVisibility(View.GONE);
		vscroll1.setVisibility(View.GONE);
		progress_main.setVisibility(View.VISIBLE);
		progress_bar.setVisibility(View.GONE);
		nothing.setVisibility(View.GONE);
		_Toolbar(false);
		_Elevation(sketch_apk, 17);
		_Elevation(sketch_project, 17);
		_Elevation(category_linear, 17);
		_Elevation(verified_r_project, 17);
		_Elevation(android_studio_apk, 17);
		_Elevation(android_studio, 17);
		_Elevation(editor, 17);
		int_isLoaded = false;
		_Elevation(toolbar, 15);
		_Elevation(linear23, 7);
		_Elevation(whats_new_linear, 9);
		_gd(linear1, 4, "#ffffff");
		_gd(download_btn, 10, "#3D5AFE");
		_gd(sketch_apk, 7, "#ffffff");
		_gd(sketch_project, 7, "#ffffff");
		_gd(category_linear, 7, "#ffffff");
		_gd(verified_r_project, 7, "#ffffff");
		_gd(android_studio, 7, "#ffffff");
		_gd(android_studio_apk, 7, "#ffffff");
		_gd(editor, 7, "#ffffff");
		textview15.setClickable(true);
		android.text.util.Linkify.addLinks(textview15, android.text.util.Linkify.ALL);
		textview15.setLinkTextColor(Color.parseColor("#009688"));
		textview15.setLinksClickable(true);
		key = getIntent().getStringExtra("key");
		uid = getIntent().getStringExtra("uid");
		_extrab();
		like_num = 0;
		comment_num = 0;
		download_num = 0;
		liked = false;
		like_key = key.concat("-likes-".concat(FirebaseAuth.getInstance().getCurrentUser().getUid()));
		_Elevation(linear21, 20);
		_Elevation(hscroll1, 20);
		_Elevation(linear9, 9);
		whats_new_linear.setElevation(15f);
		_rippleRoundStroke(sketch_apk, "#536DFE", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(sketch_project, "#536DFE", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(category_linear, "#536DFE", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(verified_r_project, "#536DFE", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(android_studio, "#536DFE", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(editor, "#536DFE", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(android_studio_apk, "#536DFE", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(linear46, "#FFFFFF", "#536DFE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(pub_by, "#536DFE", "#536DFE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(icon, "#FFFFFF", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(vip, "#536DFE", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(developer, "#536DFE", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(premium, "#536DFE", "#536DFE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(verified_linear, "#536DFE", "#536DFE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(admin, "#536DFE", "#536DFE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(moderator, "#536DFE", "#536DFE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(like_linear, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(cmt_linear, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(dwnd_linear, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(backk, "#536DFE", "#FFFFFF", 50, 0, "#FFFFFF");
		_rippleRoundStroke(verify, "#536DFE", "#FFFFFF", 50, 0, "#FFFFFF");
		_rippleRoundStroke(arrow_down_more, "#536DFE", "#FFFFFF", 50, 0, "#FFFFFF");
		_Elevation(linear46, 7);
		_Elevation(toolbar, 7);
		_OnCreate();
		textview17.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 1);
		title.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_medium.ttf"), 1);
		textview_publisher.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_bold.ttf"), 1);
		Network.startRequestNetwork(RequestNetworkController.GET, "https://sketify.tk", "a", _Network_request_listener);
	}
	
	@Override
	public void onBackPressed() {
		exit = true;
		if (int_isLoaded) {
			
			int_isLoaded = false;
		}
		else {
			finish();
		}
	}
	
	@Override
	public void onStart() {
		super.onStart();
		exit = false;
		if (transferdata.getString("transfer", "").equals("true")) {
			progress_bar.setVisibility(View.GONE);
			download_btn.setVisibility(View.VISIBLE);
			progress.setProgress((int)0);
			textview27.setText("0%");
			final AlertDialog success_dialog = new AlertDialog.Builder(ProjectViewActivity.this).create();
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
			
			s_msg.setText("Project Successfully Transferred To Sketchware");
			s_ok.setOnClickListener(new View.OnClickListener(){
				    public void onClick(View v){
					success_dialog.dismiss();
					transferdata.edit().putString("transfer", "false").commit();
				}});
			s_cancel.setOnClickListener(new View.OnClickListener(){
				    public void onClick(View v){
					success_dialog.dismiss();
				}});
			success_dialog.show();
			_bounce(s_header);
			if (FileUtil.isExistFile(SKETCHLIB_PATH_HIDE.concat("temp"))) {
				FileUtil.deleteFile(SKETCHLIB_PATH_HIDE.concat("temp"));
			}
		}
		else {
			if (transferdata.getString("transfer", "").equals("false")) {
				/*
NetOk = false;
vscroll1.setVisibility(View.GONE);
toolbar.setVisibility(View.VISIBLE);
progress_main.setVisibility(View.VISIBLE);
_Toolbar(false);
Network.startRequestNetwork(RequestNetworkController.GET, "https://sketify.tk", "c", _Network_request_listener);
*/
			}
		}
	}
	
	@Override
	public void onStop() {
		super.onStop();
		exit = true;
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		exit = true;
	}
	public void _Elevation(final View _view, final double _number) {
		
		_view.setElevation((float)_number);
	}
	
	
	public void _gd(final View _view, final double _numb, final String _color) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		gd.setCornerRadius((int)_numb);
		_view.setBackground(gd);
	}
	
	
	public void _ProgresbarShow(final String _title) {
		prog = new ProgressDialog(ProjectViewActivity.this);
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
	
	
	public void _extrab() {
	}
	private ProgressDialog prog;
	private SpannableString s;
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
	}
	
	
	public void _Share(final String _label, final String _text) {
		Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_SUBJECT, _label); i.putExtra(android.content.Intent.EXTRA_TEXT, _text); startActivity(Intent.createChooser(i,_label));
	}
	
	
	public void _InstallApk(final String _path, final String _url) {
		
	}
	
	
	public void _Download(final String _url, final String _path) {
		FileUtil.makeDir(_path);
		if (URLUtil.guessFileName(_url, null, null).contains(".apk")) {
			pathapk = _path.concat(URLUtil.guessFileName(_url, null, null));
			android.net.ConnectivityManager connMgr = (android.net.ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
			android.net.NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
			if (networkInfo != null && networkInfo.isConnected()) {
				
				
				final String urlDownload = _url;
				
				DownloadManager.Request request = new DownloadManager.Request(Uri.parse(urlDownload));
				
				final String fileName = URLUtil.guessFileName(urlDownload, null, null);
				
				request.setDescription("Downloading File [ Sketify ]");
				
				request.setTitle(title.getText());
				
				request.allowScanningByMediaScanner();
				
				request.setNotificationVisibility(1);
				
				request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
				
				request.setDestinationInExternalPublicDir(_path, fileName);
				
				final DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
				
				final long downloadId = manager.enqueue(request);
				
				new Thread(new Runnable() {
					@Override
					public void run() {
						
						boolean downloading = true;
						
						while (downloading) {
							
							DownloadManager.Query q = new DownloadManager.Query();
							
							q.setFilterById(downloadId);
							
							android.database.Cursor cursor = manager.query(q);
							
							cursor.moveToFirst();
							
							int bytes_downloaded = cursor.getInt(cursor .getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
							
							int bytes_total = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));
							
							if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_SUCCESSFUL) {
								
								downloading = false;
								
							}
							
							final int dl_progress = (int) ((bytes_downloaded * 100l) / bytes_total);
							
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									
									
									progress.setProgress(dl_progress);
									
									textview27.setText(dl_progress +  "%");
									
									if (dl_progress == 100) {
										
										
										
										final AlertDialog success_dialog = new AlertDialog.Builder(ProjectViewActivity.this).create();
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
										_setBgCorners(s_ok, 8, "#64DD17");
										_setBgCorners(s_cancel, 8, "#64DD17");
										s_header.setElevation(5);
										s_cancel.setVisibility(View.GONE);
										s_div.setVisibility(View.GONE);
										     
										
										
										
										s_msg.setText("Apk Saved Successfully In Path  " + pathapk );
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
										
										showMessage( "Apk Saved To" + pathapk);
										
										progress.setProgress((int)(100));
										
										progress_bar.setVisibility(View.GONE);
										
										download_btn.setVisibility(View.VISIBLE);
										
										progress.setProgress((int)(0));
										
										textview27.setText("0%");
										
										
										
										
									}
									
								} });
						} } }).start();
				
				
			} else {
				showMessage("File Download Interrupted!");
				
				finishAffinity();
				
			}
			
			_Install_Package(pathapk);
		}
		else {
			pathapk = _path.concat(URLUtil.guessFileName(_url, null, null));
			android.net.ConnectivityManager connMgr = (android.net.ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
			android.net.NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
			if (networkInfo != null && networkInfo.isConnected()) {
				
				
				final String urlDownload = _url;
				
				DownloadManager.Request request = new DownloadManager.Request(Uri.parse(urlDownload));
				
				final String fileName = URLUtil.guessFileName(urlDownload, null, null);
				
				request.setDescription("Downloading File [ Sketify ]");
				
				request.setTitle(title.getText());
				
				request.allowScanningByMediaScanner();
				
				request.setNotificationVisibility(1);
				
				request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
				
				request.setDestinationInExternalPublicDir(_path, fileName);
				
				final DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
				
				final long downloadId = manager.enqueue(request);
				
				new Thread(new Runnable() {
					@Override
					public void run() {
						
						boolean downloading = true;
						
						while (downloading) {
							
							DownloadManager.Query q = new DownloadManager.Query();
							
							q.setFilterById(downloadId);
							
							android.database.Cursor cursor = manager.query(q);
							
							cursor.moveToFirst();
							
							int bytes_downloaded = cursor.getInt(cursor .getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
							
							int bytes_total = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));
							
							if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_SUCCESSFUL) {
								
								downloading = false;
								
							}
							
							final int dl_progress = (int) ((bytes_downloaded * 100l) / bytes_total);
							
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									
									
									progress.setProgress(dl_progress);
									
									textview27.setText(dl_progress +  "%");
									
									if (dl_progress == 100) {
										
										
										
										final AlertDialog success_dialog = new AlertDialog.Builder(ProjectViewActivity.this).create();
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
										_setBgCorners(s_ok, 8, "#64DD17");
										_setBgCorners(s_cancel, 8, "#64DD17");
										s_header.setElevation(5);
										s_cancel.setVisibility(View.GONE);
										s_div.setVisibility(View.GONE);
										     
										
										
										
										s_msg.setText("Apk Saved Successfully In Path  " + pathapk );
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
										
										showMessage( "Apk Saved To" + pathapk);
										
										progress.setProgress((int)(100));
										
										progress_bar.setVisibility(View.GONE);
										
										download_btn.setVisibility(View.VISIBLE);
										
										progress.setProgress((int)(0));
										
										textview27.setText("0%");
										
										
										
										
									}
									
								} });
						} } }).start();
				
				
			} else {
				showMessage("File Download Interrupted!");
				
				finishAffinity();
				
			}
			
			_Install_Package(pathapk);
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
	
	
	public void _makeLinksClickable(final TextView _textView) {
		/*

try {

_textView.setClickable(true);

Linkify.addLinks(_textView, 15);

_textView.setLinkTextColor(Color.parseColor("#2196F3"));

_textView.setLinksClickable(true);

} catch (Exception e) {

}

*/
	}
	
	
	public void _removeScollBar(final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
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
	
	
	public void _Install_Package(final String _appPath) {
		
	}
	
	
	public void _Moreblocks() {
		_extrab();
		_gd(imageview18, 30, "#FFFFFF");
		_removeScollBar(hscroll1);
		_removeScollBar(hscroll2);
		_removeScollBar(hscroll5);
		_removeScollBar(vscroll1);
		_Elevation(sketch_apk, 17);
		_Elevation(sketch_project, 17);
		_Elevation(category_linear, 17);
		_Elevation(verified_r_project, 17);
		_Elevation(android_studio_apk, 17);
		_Elevation(android_studio, 17);
		_Elevation(editor, 17);
		_makeLinksClickable(textview15);
		_makeLinksClickable(what_new);
		_Elevation(toolbar, 7);
		_Elevation(linear23, 7);
		_gd(linear1, 4, "#ffffff");
		_gd(download_btn, 30, "#3D5AFE");
		_gd(sketch_apk, 7, "#ffffff");
		_gd(sketch_project, 7, "#ffffff");
		_gd(category_linear, 7, "#ffffff");
		_gd(verified_r_project, 7, "#ffffff");
		_gd(android_studio, 7, "#ffffff");
		_gd(android_studio_apk, 7, "#ffffff");
		_gd(editor, 7, "#ffffff");
		_Elevation(linear21, 20);
		_Elevation(hscroll1, 20);
		_Elevation(linear9, 9);
		_rippleRoundStroke(whats_new_linear, "#FFFFFF", "#EEEEEE", 20, 3, "#536DFE");
		_rippleRoundStroke(sketch_apk, "#536DFE", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(sketch_project, "#536DFE", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(category_linear, "#536DFE", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(verified_r_project, "#536DFE", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(android_studio, "#536DFE", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(android_studio_apk, "#536DFE", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(editor, "#536DFE", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(linear46, "#FFFFFF", "#536DFE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(whats_new_linear, "#FFFFFF", "#536DFE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(pub_by, "#536DFE", "#536DFE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(imageview_pub_ic, "#FFFFFF", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(icon, "#FFFFFF", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(imageview_pub_ic, "#FFFFFF", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(vip, "#536DFE", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(developer, "#536DFE", "#EEEEEE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(premium, "#536DFE", "#536DFE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(verified_linear, "#536DFE", "#536DFE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(admin, "#536DFE", "#536DFE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(moderator, "#536DFE", "#536DFE", 20, 3, "#FFFFFF");
		_rippleRoundStroke(like_linear, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(cmt_linear, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(dwnd_linear, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(imageview18, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(backk, "#536DFE", "#FFFFFF", 20, 0, "#FFFFFF");
		_rippleRoundStroke(verify, "#536DFE", "#FFFFFF", 20, 0, "#FFFFFF");
		_rippleRoundStroke(whats_new_linear, "#FFFFFF", "#FFFFFF", 20, 2, "#536DFE");
		_rippleRoundStroke(arrow_down_more, "#536DFE", "#FFFFFF", 20, 0, "#FFFFFF");
		_Elevation(linear46, 7);
		_Elevation(toolbar, 7);
	}
	
	
	public void _OnCreate() {
		getSupportActionBar().setTitle(null);
		
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(false);
		
		_toolbar.setContentInsetStartWithNavigation(0);
		
		_toolbar.setContentInsetsAbsolute(0, 0);
		
		
		
		toolbar_outer.removeView(toolbar);
		_toolbar.addView(toolbar);
		like_linear.setOnLongClickListener(new View.OnLongClickListener() {@Override public boolean onLongClick(View v){ 
				
				
				LProjects.setClass(getApplicationContext(), LikedProjectsActivity.class);
				LProjects.putExtra("key", key);
				LProjects.putExtra("mode", "project");
				startActivity(LProjects);
				return false;
			}});
		demo_link.setPaintFlags(demo_link.getPaintFlags()  |  Paint.UNDERLINE_TEXT_FLAG);
		
		textview15.setTextIsSelectable(true);
		
		what_new.setTextIsSelectable(true);
		imageview6.setColorFilter(Color.parseColor("#FFA000"));
		
		imageview26.setColorFilter(Color.parseColor("#FFFFFF"));
		
		imageview7.setColorFilter(Color.parseColor("#3D5AFE"));
		
		like_btn.setColorFilter(Color.parseColor("#F44336"));
		
		imageview18.setColorFilter(Color.parseColor("#536DFE"));
		
		wn_img.setColorFilter(Color.parseColor("#536DFE"));
		
		admin_ic.setColorFilter(Color.parseColor("#FFFFFF"));
		
		moderator_ic.setColorFilter(Color.parseColor("#FFFFFF"));
		
		vip_ic.setColorFilter(Color.parseColor("#FFFFFF"));
		
		premium_ic.setColorFilter(Color.parseColor("#FFFFFF"));
		
		developer_ic.setColorFilter(Color.parseColor("#FFFFFF"));
		
		verified_ic.setColorFilter(Color.parseColor("#FFFFFF"));
		Moderator = false;
		Admin = false;
		exit = true;
		progress_main.setVisibility(View.VISIBLE);
		vscroll1.setVisibility(View.GONE);
		toolbar.setVisibility(View.GONE);
		_Toolbar(false);
		_fab.hide();
		_Elevation(whats_new_linear, 9);
		_removeScollBar(hscroll5);
		_removeScollBar(hscroll2);
		_removeScollBar(hscroll1);
		_removeScollBar(hscroll1);
		_makeLinksClickable(textview15);
		_makeLinksClickable(what_new);
		_Toolbar(true);
		_rippleRoundStroke(share_lin, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(report_lin, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(whats_new_linear, "#FFFFFF", "#FFFFFF", 20, 1, "#FFFFFF");
		_changeActivityFont("regular");
		Sketify_Directory = FileUtil.getExternalStorageDir().concat("/Sketify/");
		Sketify_Hidden_Path = FileUtil.getExternalStorageDir().concat("/Android/data/com.sketify.msk/");
		Sketchware_Path = FileUtil.getExternalStorageDir().concat("/.sketchware/");
		if (!FileUtil.isExistFile(Sketify_Directory)) {
			FileUtil.makeDir(Sketify_Directory);
		}
		if (!FileUtil.isExistFile(Sketify_Hidden_Path)) {
			FileUtil.makeDir(Sketify_Hidden_Path);
		}
		if (!FileUtil.isExistFile(Sketchware_Path)) {
			FileUtil.makeDir(Sketchware_Path);
		}
		textview11.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 1);
		textview53.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 1);
		textview14.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 1);
		likes.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 1);
		comments.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 1);
		download_cnt.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 1);
		download_btn.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_medium.ttf"), 0);
		title.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 1);
		imageview23.setVisibility(View.GONE);
	}
	
	
	public void _Toolbar(final boolean _v) {
		if (_v) {
			getSupportActionBar().show();
		}
		else {
			getSupportActionBar().hide();
		}
	}
	
	
	public void _Spannable_Bold(final double _n, final double _n1) {
		s.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), (int)_n, (int)_n1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
	}
	
	
	public void _Create_Spannbale(final String _text) {
		s = new SpannableString(_text);
	}
	
	
	public void _GetData(final String _childKey, final HashMap<String, Object> _childValue) {
		textview15.setClickable(true);
		android.text.util.Linkify.addLinks(textview15, android.text.util.Linkify.ALL);
		textview15.setLinkTextColor(Color.parseColor("#009688"));
		textview15.setLinksClickable(true);
		if (_childValue.containsKey("icon")) {
			Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("icon").toString())).into(icon);
			icon_URL = _childValue.get("icon").toString();
		}
		else {
			icon.setImageResource(R.drawable.android_icon);
		}
		if (_childValue.containsKey("title")) {
			title.setText(_childValue.get("title").toString());
			textview10.setText(_childValue.get("title").toString());
		}
		if (_childValue.containsKey("likes")) {
			likes.setText(_childValue.get("likes").toString());
		}
		if (_childValue.containsKey("comments")) {
			comments.setText(_childValue.get("comments").toString());
		}
		if (_childValue.containsKey("project")) {
			URL = _childValue.get("project").toString();
			project_ok = true;
			apk_ok = false;
		}
		else {
			if (_childValue.containsKey("apk")) {
				URL = _childValue.get("apk").toString();
				apk_ok = true;
				project_ok = false;
			}
		}
		if (_childValue.containsKey("downloads")) {
			download_cnt.setText(_childValue.get("downloads").toString());
			download_num = Double.parseDouble(_childValue.get("downloads").toString());
		}
		if (_childValue.containsKey("description")) {
			textview15.setText(_childValue.get("description").toString());
		}
		if (_childValue.containsKey("comments_visibility")) {
			if (_childValue.get("comments_visibility").toString().equals("true")) {
				comment_visibility = true;
			}
			else {
				if (_childValue.get("comments_visibility").toString().equals("false")) {
					comment_visibility = false;
				}
				else {
					comment_visibility = true;
				}
			}
		}
		if (_childValue.containsKey("shot1")) {
			shot1url = "";
			shot1url = _childValue.get("shot1").toString();
			Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("shot1").toString())).into(shot1);
		}
		if (_childValue.containsKey("shot2")) {
			shot2url = "";
			shot2url = _childValue.get("shot2").toString();
			Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("shot2").toString())).into(shot2);
		}
		if (_childValue.containsKey("yt_url")) {
			if (_childValue.get("yt_url").toString().equals("")) {
				vid_linear.setVisibility(View.GONE);
			}
			else {
				if (_childValue.get("yt_url").toString().contains("https://")) {
					ytvideo = _childValue.get("yt_url").toString();
					id = _childValue.get("yt_url").toString().replace("https://youtu.be/", "");
					id2 = "https://i.ytimg.com/vi/".concat(id.concat("/maxresdefault.jpg"));
					vid_linear.setVisibility(View.GONE);
					if (!id2.equals("")) {
						vid_linear.setVisibility(View.VISIBLE);
						Glide.with(getApplicationContext()).load(Uri.parse(id2)).into(yt_thumb);
					}
				}
				else {
					vid_linear.setVisibility(View.GONE);
				}
			}
		}
		if (_childValue.containsKey("whatsnew")) {
			if (_childValue.get("whatsnew").toString().equals("")) {
				whats_new_linear.setVisibility(View.GONE);
			}
			else {
				whats_new_linear.setVisibility(View.VISIBLE);
				what_new.setText(_childValue.get("whatsnew").toString());
			}
		}
		if (_childValue.containsKey("project category")) {
			if (_childValue.get("project category").toString().equals("Sketchware Project")) {
				sketch_apk.setVisibility(View.GONE);
				sketch_project.setVisibility(View.VISIBLE);
				verified_r_project.setVisibility(View.GONE);
				android_studio_apk.setVisibility(View.GONE);
				android_studio.setVisibility(View.GONE);
				as = false;
			}
			else {
				if (_childValue.get("project category").toString().equals("Sketchware Apk")) {
					sketch_apk.setVisibility(View.VISIBLE);
					sketch_project.setVisibility(View.GONE);
					verified_r_project.setVisibility(View.GONE);
					android_studio_apk.setVisibility(View.GONE);
					android_studio.setVisibility(View.GONE);
					as = false;
				}
				else {
					if (_childValue.get("project category").toString().equals("Android Studio Apk")) {
						sketch_apk.setVisibility(View.GONE);
						sketch_project.setVisibility(View.GONE);
						verified_r_project.setVisibility(View.GONE);
						android_studio_apk.setVisibility(View.VISIBLE);
						android_studio.setVisibility(View.GONE);
						as = false;
					}
					else {
						if (_childValue.get("project category").toString().equals("Android Studio")) {
							sketch_apk.setVisibility(View.GONE);
							sketch_project.setVisibility(View.GONE);
							verified_r_project.setVisibility(View.GONE);
							android_studio_apk.setVisibility(View.GONE);
							android_studio.setVisibility(View.VISIBLE);
							as = true;
						}
						else {
							sketch_apk.setVisibility(View.GONE);
							sketch_project.setVisibility(View.VISIBLE);
							verified_r_project.setVisibility(View.GONE);
							android_studio_apk.setVisibility(View.GONE);
							android_studio.setVisibility(View.GONE);
						}
					}
				}
			}
		}
		else {
			sketch_apk.setVisibility(View.GONE);
			sketch_project.setVisibility(View.VISIBLE);
			verified_r_project.setVisibility(View.GONE);
			android_studio_apk.setVisibility(View.GONE);
			android_studio.setVisibility(View.GONE);
		}
		if (_childValue.containsKey("short_url")) {
			share = _childValue.get("short_url").toString();
		}
		else {
			url_to_short = "https://projects.sketify.tk/project?id=prefix-9a71e0719545676a138b25f1a00c30e4dfba301d?&&".concat(key.concat("&&afl=https://sketify.tk&efr=1"));
			json = "{\n   \"longDynamicLink\": \"https://project.sketify.tk/?link=".concat(url_to_short.concat("\",\n     \"suffix\": {\n    \"option\": \"SHORT\"\n   }\n}"));
			short_mapper = new Gson().fromJson(json, new TypeToken<HashMap<String, Object>>(){}.getType());
			short_ur.setParams(short_mapper, RequestNetworkController.REQUEST_BODY);
			short_ur.startRequestNetwork(RequestNetworkController.POST, "https://firebasedynamiclinks.googleapis.com/v1/shortLinks?key=AIzaSyC1-BdIOp_HBnf1Nq0MrOw4C6Cc2HryaV8", "any", _short_ur_request_listener);
		}
		if (_childValue.containsKey("time")) {
			time.setText(_childValue.get("time").toString());
		}
		else {
			time.setVisibility(View.GONE);
		}
		if (_childValue.containsKey("demo")) {
			if (!_childValue.get("demo").toString().equals("")) {
				demo_link.setVisibility(View.VISIBLE);
				d_Url = _childValue.get("demo").toString();
			}
			else {
				demo_link.setVisibility(View.GONE);
			}
		}
		else {
			demo_link.setVisibility(View.GONE);
		}
		if (_childValue.containsKey("editor")) {
			if (_childValue.get("editor").toString().equals("true")) {
				editor.setVisibility(View.VISIBLE);
				Editor = true;
			}
			else {
				editor.setVisibility(View.GONE);
				Editor = false;
			}
		}
		else {
			editor.setVisibility(View.GONE);
		}
		if (_childValue.containsKey("category")) {
			category_linear.setVisibility(View.VISIBLE);
			textview_category.setText(_childValue.get("category").toString());
		}
		else {
			category_linear.setVisibility(View.GONE);
		}
		if (_childValue.containsKey("size")) {
			if (_childValue.get("size").toString().trim().equals("")) {
				download_btn.setText("DOWNLOAD (".concat("FILE NOT FOUND".concat(")")));
			}
			else {
				download_btn.setText("DOWNLOAD (".concat(_childValue.get("size").toString().concat(")")));
			}
		}
		if (_childValue.containsKey("verification")) {
			if (_childValue.get("verification").toString().equals("true")) {
				verified = true;
				verify.setImageResource(R.drawable.ic_hdr_strong_white);
				verified_r_project.setVisibility(View.VISIBLE);
			}
			else {
				verified = false;
				verify.setImageResource(R.drawable.ic_hdr_weak_white);
				verified_r_project.setVisibility(View.GONE);
			}
		}
		textview15.setClickable(true);
		android.text.util.Linkify.addLinks(textview15, android.text.util.Linkify.ALL);
		textview15.setLinkTextColor(Color.parseColor("#009688"));
		textview15.setLinksClickable(true);
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