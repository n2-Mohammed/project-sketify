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
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Spinner;
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
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
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
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import java.io.*;
import java.io.File;
import java.text.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class UploadActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private String icon_path = "";
	private String up_icon = "";
	private String up_edit = "";
	private String project_key = "";
	private HashMap<String, Object> temp_map1 = new HashMap<>();
	private double number = 0;
	private String temp_decrypted = "";
	private String name = "";
	private String ic_path = "";
	private String ic_name = "";
	private String description_ = "";
	private boolean projectset = false;
	private String iconset = "";
	private HashMap<String, Object> data_map = new HashMap<>();
	private String icon_url = "";
	private String visibility = "";
	private String comments = "";
	private String shot1_path = "";
	private String shot1_name = "";
	private String shot2_path = "";
	private String shot2_name = "";
	private String shot1_url = "";
	private String shot2_url = "";
	private String yt_url = "";
	private String whatsnew = "";
	private boolean sk_apk = false;
	private boolean sk_project = false;
	private HashMap<String, Object> user_dwds_map = new HashMap<>();
	private double user_dwnds = 0;
	private String key = "";
	private HashMap<String, Object> map2 = new HashMap<>();
	private String fontName = "";
	private String typeace = "";
	private boolean useless = false;
	private boolean spam = false;
	private boolean abuse = false;
	private boolean empty = false;
	private boolean illegal = false;
	private boolean copied = false;
	private boolean terms = false;
	private String visi = "";
	private boolean ulloading = false;
	private boolean shot1upd = false;
	private boolean shot2upd = false;
	private boolean iconupd = false;
	private String usr_name = "";
	private boolean apk_set = false;
	private String apk_path = "";
	private String apk_name = "";
	private boolean androidstudioapk = false;
	private boolean android_studii = false;
	private String project_patg = "";
	private String project_name = "";
	private boolean picking_ic = false;
	private boolean picking_shot1 = false;
	private boolean picking_shot2 = false;
	private boolean picking_project_file = false;
	private double user_projects = 0;
	private HashMap<String, Object> user_Pr = new HashMap<>();
	private boolean dem_Link = false;
	private String demoLink = "";
	private boolean netResponsed = false;
	private String Sketify_Directory = "";
	private String Sketify_Hidden_Path = "";
	private String Sketchware_Path = "";
	private String apk_size = "";
	private String project_size = "";
	private boolean edit = false;
	private String dwnd_url = "";
	private String sketchPath = "";
	private String sketifyDataDirectory = "";
	private String sketifyDirectory = "";
	private double B = 0;
	private double KB = 0;
	private double MB = 0;
	private double GB = 0;
	private double TB = 0;
	private double PB = 0;
	private String returnedSize = "";
	private HashMap<String, Object> typlist = new HashMap<>();
	private String path = "";
	private double soze = 0;
	private boolean yt_yrl_ok = false;
	private String file_size = "";
	private String one = "";
	private String uploadUrl = "";
	private String returnMessage = "";
	private String downloadUrl = "";
	private String filename = "";
	private String filepath = "";
	private boolean uploading = false;
	private String response = "";
	private String returnm = "";
	private String htmlProgram = "";
	private double fullProject = 0;
	
	private ArrayList<String> temp_str1 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> temp_listmap1 = new ArrayList<>();
	private ArrayList<String> type_of_upload = new ArrayList<>();
	private ArrayList<String> category = new ArrayList<>();
	private ArrayList<String> copy_list = new ArrayList<>();
	private ArrayList<String> filePath = new ArrayList<>();
	
	private LinearLayout linear_main_projects;
	private LinearLayout toolbar;
	private LinearLayout progress;
	private LinearLayout upload_main;
	private LinearLayout terms_main;
	private ImageView imageview1;
	private TextView textview15;
	private TextView textview26;
	private ProgressBar progressbar1;
	private ScrollView main;
	private LinearLayout linear5;
	private LinearLayout name_linear_ic;
	private LinearLayout linear4;
	private LinearLayout vidtrailer_lin;
	private LinearLayout des_linear;
	private LinearLayout linear42;
	private LinearLayout whatsnew_linear;
	private LinearLayout linear41;
	private LinearLayout attach_file_main;
	private LinearLayout linear53;
	private LinearLayout choosecat_linear;
	private LinearLayout linear51;
	private LinearLayout linear39;
	private LinearLayout lin_add;
	private LinearLayout linear17;
	private TextView textview31;
	private LinearLayout linear20;
	private ImageView icon_;
	private LinearLayout name_linear;
	private EditText title;
	private TextView textview27;
	private LinearLayout linear46;
	private TextView textview2;
	private HorizontalScrollView vscroll_thumb;
	private TextView textview1;
	private TextView textview20;
	private LinearLayout sc_bag;
	private ImageView sc1;
	private ImageView sc2;
	private TextView textview3;
	private EditText yturl;
	private TextView textview30;
	private LinearLayout linear47;
	private EditText description;
	private TextView textview28;
	private TextView textview4;
	private TextView textview21;
	private TextView textview5;
	private EditText edittext5;
	private TextView textview29;
	private LinearLayout typeofpro_linear;
	private LinearLayout spinner_typeoproject;
	private LinearLayout atch_file_linear;
	private LinearLayout readed_text;
	private TextView textview38;
	private LinearLayout demo_apk;
	private TextView textview6;
	private TextView textview22;
	private TextView textview17;
	private Spinner spinner1;
	private TextView attach_file;
	private ImageView imageview4;
	private ImageView imageview2;
	private TextView file_name;
	private TextView textview36;
	private EditText edittext7;
	private TextView textview37;
	private LinearLayout linear54;
	private TextView textview40;
	private LinearLayout lin_category_spinner;
	private TextView textview7;
	private TextView textview39;
	private TextView textview_category;
	private Spinner spinner3;
	private TextView textview9;
	private Switch switch1;
	private LinearLayout linear49;
	private Button button1;
	private ImageView imageview7;
	private TextView textview23;
	private Switch switch3;
	private Switch switch4;
	private Switch switch5;
	private Switch switch6;
	private Switch switch7;
	private Switch switch9;
	private TextView textview25;
	
	private DatabaseReference data1 = _firebase.getReference("data1");
	private ChildEventListener _data1_child_listener;
	private StorageReference icon = _firebase_storage.getReference("icon");
	private OnCompleteListener<Uri> _icon_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _icon_download_success_listener;
	private OnSuccessListener _icon_delete_success_listener;
	private OnProgressListener _icon_upload_progress_listener;
	private OnProgressListener _icon_download_progress_listener;
	private OnFailureListener _icon_failure_listener;
	
	private StorageReference project = _firebase_storage.getReference("project");
	private OnCompleteListener<Uri> _project_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _project_download_success_listener;
	private OnSuccessListener _project_delete_success_listener;
	private OnProgressListener _project_upload_progress_listener;
	private OnProgressListener _project_download_progress_listener;
	private OnFailureListener _project_failure_listener;
	
	private TimerTask timer;
	private AlertDialog.Builder p_publish_dialog;
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
	
	private DatabaseReference projects = _firebase.getReference("projects");
	private ChildEventListener _projects_child_listener;
	private TimerTask next;
	private Intent pick_apk = new Intent();
	private SharedPreferences file;
	private Intent pick_img = new Intent();
	private ObjectAnimator oa_d = new ObjectAnimator();
	private RequestNetwork net;
	private RequestNetwork.RequestListener _net_request_listener;
	private TimerTask internet;
	private TimerTask shot;
	private AlertDialog.Builder exit;
	private Calendar c = Calendar.getInstance();
	private Intent getproject = new Intent();
	private SharedPreferences export;
	private TimerTask uploade;
	private RequestNetwork get_html;
	private RequestNetwork.RequestListener _get_html_request_listener;
	private AlertDialog.Builder big_file_warn;
	private AlertDialog.Builder ad;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.upload);
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
		linear_main_projects = findViewById(R.id.linear_main_projects);
		toolbar = findViewById(R.id.toolbar);
		progress = findViewById(R.id.progress);
		upload_main = findViewById(R.id.upload_main);
		terms_main = findViewById(R.id.terms_main);
		imageview1 = findViewById(R.id.imageview1);
		textview15 = findViewById(R.id.textview15);
		textview26 = findViewById(R.id.textview26);
		progressbar1 = findViewById(R.id.progressbar1);
		main = findViewById(R.id.main);
		linear5 = findViewById(R.id.linear5);
		name_linear_ic = findViewById(R.id.name_linear_ic);
		linear4 = findViewById(R.id.linear4);
		vidtrailer_lin = findViewById(R.id.vidtrailer_lin);
		des_linear = findViewById(R.id.des_linear);
		linear42 = findViewById(R.id.linear42);
		whatsnew_linear = findViewById(R.id.whatsnew_linear);
		linear41 = findViewById(R.id.linear41);
		attach_file_main = findViewById(R.id.attach_file_main);
		linear53 = findViewById(R.id.linear53);
		choosecat_linear = findViewById(R.id.choosecat_linear);
		linear51 = findViewById(R.id.linear51);
		linear39 = findViewById(R.id.linear39);
		lin_add = findViewById(R.id.lin_add);
		linear17 = findViewById(R.id.linear17);
		textview31 = findViewById(R.id.textview31);
		linear20 = findViewById(R.id.linear20);
		icon_ = findViewById(R.id.icon_);
		name_linear = findViewById(R.id.name_linear);
		title = findViewById(R.id.title);
		textview27 = findViewById(R.id.textview27);
		linear46 = findViewById(R.id.linear46);
		textview2 = findViewById(R.id.textview2);
		vscroll_thumb = findViewById(R.id.vscroll_thumb);
		textview1 = findViewById(R.id.textview1);
		textview20 = findViewById(R.id.textview20);
		sc_bag = findViewById(R.id.sc_bag);
		sc1 = findViewById(R.id.sc1);
		sc2 = findViewById(R.id.sc2);
		textview3 = findViewById(R.id.textview3);
		yturl = findViewById(R.id.yturl);
		textview30 = findViewById(R.id.textview30);
		linear47 = findViewById(R.id.linear47);
		description = findViewById(R.id.description);
		textview28 = findViewById(R.id.textview28);
		textview4 = findViewById(R.id.textview4);
		textview21 = findViewById(R.id.textview21);
		textview5 = findViewById(R.id.textview5);
		edittext5 = findViewById(R.id.edittext5);
		textview29 = findViewById(R.id.textview29);
		typeofpro_linear = findViewById(R.id.typeofpro_linear);
		spinner_typeoproject = findViewById(R.id.spinner_typeoproject);
		atch_file_linear = findViewById(R.id.atch_file_linear);
		readed_text = findViewById(R.id.readed_text);
		textview38 = findViewById(R.id.textview38);
		demo_apk = findViewById(R.id.demo_apk);
		textview6 = findViewById(R.id.textview6);
		textview22 = findViewById(R.id.textview22);
		textview17 = findViewById(R.id.textview17);
		spinner1 = findViewById(R.id.spinner1);
		attach_file = findViewById(R.id.attach_file);
		imageview4 = findViewById(R.id.imageview4);
		imageview2 = findViewById(R.id.imageview2);
		file_name = findViewById(R.id.file_name);
		textview36 = findViewById(R.id.textview36);
		edittext7 = findViewById(R.id.edittext7);
		textview37 = findViewById(R.id.textview37);
		linear54 = findViewById(R.id.linear54);
		textview40 = findViewById(R.id.textview40);
		lin_category_spinner = findViewById(R.id.lin_category_spinner);
		textview7 = findViewById(R.id.textview7);
		textview39 = findViewById(R.id.textview39);
		textview_category = findViewById(R.id.textview_category);
		spinner3 = findViewById(R.id.spinner3);
		textview9 = findViewById(R.id.textview9);
		switch1 = findViewById(R.id.switch1);
		linear49 = findViewById(R.id.linear49);
		button1 = findViewById(R.id.button1);
		imageview7 = findViewById(R.id.imageview7);
		textview23 = findViewById(R.id.textview23);
		switch3 = findViewById(R.id.switch3);
		switch4 = findViewById(R.id.switch4);
		switch5 = findViewById(R.id.switch5);
		switch6 = findViewById(R.id.switch6);
		switch7 = findViewById(R.id.switch7);
		switch9 = findViewById(R.id.switch9);
		textview25 = findViewById(R.id.textview25);
		p_publish_dialog = new AlertDialog.Builder(this);
		auth = FirebaseAuth.getInstance();
		file = getSharedPreferences("file", Activity.MODE_PRIVATE);
		net = new RequestNetwork(this);
		exit = new AlertDialog.Builder(this);
		export = getSharedPreferences("export", Activity.MODE_PRIVATE);
		get_html = new RequestNetwork(this);
		big_file_warn = new AlertDialog.Builder(this);
		ad = new AlertDialog.Builder(this);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				onBackPressed();
			}
		});
		
		textview26.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edit) {
					if (description_.equals("")) {
						_SnackBar(true, false, false, "Enter Description Without Errors");
					}
					else {
						if (name.equals("")) {
							_SnackBar(true, false, false, "Enter Name Without Errors");
						}
						else {
							if (textview_category.getText().toString().equals("-- SELECT --")) {
								_SnackBar(true, false, false, "Select Category");
							}
							else {
								if (!yt_yrl_ok) {
									_SnackBar(true, false, false, "Check Youtube Video Url");
								}
								else {
									if (sk_project) {
										if (projectset) {
											textview26.setVisibility(View.GONE);
											terms_main.setVisibility(View.VISIBLE);
											visi = "true";
											upload_main.setVisibility(View.GONE);
											toolbar.setVisibility(View.GONE);
											useless = false;
											spam = false;
											abuse = false;
											empty = false;
											illegal = false;
											copied = false;
											terms = false;
										}
										else {
											_SnackBar(true, false, false, "Choose your Project");
										}
									}
									else {
										if (sk_apk) {
											if (apk_set) {
												textview26.setVisibility(View.GONE);
												terms_main.setVisibility(View.VISIBLE);
												visi = "true";
												upload_main.setVisibility(View.GONE);
												toolbar.setVisibility(View.GONE);
												useless = false;
												spam = false;
												abuse = false;
												empty = false;
												illegal = false;
												copied = false;
												terms = false;
											}
											else {
												_SnackBar(true, false, false, "Choose Apk");
											}
										}
										else {
											if (androidstudioapk) {
												if (apk_set) {
													textview26.setVisibility(View.GONE);
													terms_main.setVisibility(View.VISIBLE);
													visi = "true";
													upload_main.setVisibility(View.GONE);
													toolbar.setVisibility(View.GONE);
													useless = false;
													spam = false;
													abuse = false;
													empty = false;
													illegal = false;
													copied = false;
													terms = false;
												}
												else {
													_SnackBar(true, false, false, "Choose Apk");
												}
											}
											else {
												if (android_studii) {
													if (projectset) {
														textview26.setVisibility(View.GONE);
														terms_main.setVisibility(View.VISIBLE);
														visi = "true";
														upload_main.setVisibility(View.GONE);
														toolbar.setVisibility(View.GONE);
														useless = false;
														spam = false;
														abuse = false;
														empty = false;
														illegal = false;
														copied = false;
														terms = false;
													}
													else {
														_SnackBar(true, false, false, "Choose Project File");
													}
												}
												else {
													_SnackBar(true, false, false, "Select Project");
												}
											}
										}
									}
								}
							}
						}
					}
				}
				else {
					if (ic_name.equals("") || ic_path.equals("")) {
						_SnackBar(true, false, false, "Select Icon");
					}
					else {
						if (description_.equals("")) {
							_SnackBar(true, false, false, "Enter Description Without Errors");
						}
						else {
							if (name.equals("")) {
								_SnackBar(true, false, false, "Enter Name Without Errors");
							}
							else {
								if (shot1_path.equals("")) {
									_SnackBar(true, false, false, "Select Screenshot(s)");
								}
								else {
									if (shot2_path.equals("")) {
										_SnackBar(true, false, false, "Select Screenshot(s)");
									}
									else {
										if (textview_category.getText().toString().equals("-- SELECT --")) {
											_SnackBar(true, false, false, "Please Select Category");
										}
										else {
											if (!yt_yrl_ok) {
												_SnackBar(true, false, false, "Check YouTube Video Url!");
											}
											else {
												if (sk_project) {
													if (projectset) {
														if (ic_path.equals("")) {
															_SnackBar(true, false, false, "Please Select Icon");
														}
														else {
															textview26.setVisibility(View.GONE);
															terms_main.setVisibility(View.VISIBLE);
															visi = "true";
															upload_main.setVisibility(View.GONE);
															toolbar.setVisibility(View.GONE);
															useless = false;
															spam = false;
															abuse = false;
															empty = false;
															illegal = false;
															copied = false;
															terms = false;
														}
													}
													else {
														_SnackBar(true, false, false, "Please Select Project");
													}
												}
												else {
													if (sk_apk) {
														if (apk_set) {
															if (ic_path.equals("")) {
																_SnackBar(true, false, false, "Please Select Icon");
															}
															else {
																textview26.setVisibility(View.GONE);
																terms_main.setVisibility(View.VISIBLE);
																visi = "true";
																upload_main.setVisibility(View.GONE);
																toolbar.setVisibility(View.GONE);
																useless = false;
																spam = false;
																abuse = false;
																empty = false;
																illegal = false;
																copied = false;
																terms = false;
															}
														}
														else {
															_SnackBar(true, false, false, "Please Choose Apk");
														}
													}
													else {
														if (androidstudioapk) {
															if (apk_set) {
																if (ic_path.equals("")) {
																	SketchwareUtil.showMessage(getApplicationContext(), "Please Select Icon");
																}
																else {
																	textview26.setVisibility(View.GONE);
																	terms_main.setVisibility(View.VISIBLE);
																	visi = "true";
																	upload_main.setVisibility(View.GONE);
																	toolbar.setVisibility(View.GONE);
																	useless = false;
																	spam = false;
																	abuse = false;
																	empty = false;
																	illegal = false;
																	copied = false;
																	terms = false;
																}
															}
															else {
																_SnackBar(true, false, false, "Please Choose Apk");
															}
														}
														else {
															if (android_studii) {
																if (projectset) {
																	if (ic_path.equals("")) {
																		SketchwareUtil.showMessage(getApplicationContext(), "Please Select Icon");
																	}
																	else {
																		textview26.setVisibility(View.GONE);
																		terms_main.setVisibility(View.VISIBLE);
																		visi = "true";
																		upload_main.setVisibility(View.GONE);
																		toolbar.setVisibility(View.GONE);
																		useless = false;
																		spam = false;
																		abuse = false;
																		empty = false;
																		illegal = false;
																		copied = false;
																		terms = false;
																	}
																}
																else {
																	_SnackBar(true, false, false, "Select Project File");
																}
															}
															else {
																_SnackBar(true, false, false, "Please Select Project");
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		});
		
		icon_.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				picking_ic = true;
				picking_shot1 = false;
				picking_shot2 = false;
				picking_project_file = false;
				pick_img.setClass(getApplicationContext(), FilepicActivity.class);
				pick_img.putExtra("extension", ".png, .apng, .gif, .jpeg, .jpg");
				startActivity(pick_img);
			}
		});
		
		title.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (50 < _charSeq.length()) {
					name = "";
					textview27.setTextColor(0xFFF44336);
				}
				else {
					textview27.setTextColor(0xFF000000);
					if (_charSeq.equals("")) {
						textview27.setText("0".concat("/50"));
						name = "";
					}
					else {
						textview27.setText(String.valueOf((long)(_charSeq.length())).concat("/50"));
						name = _charSeq;
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
		
		sc1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				picking_ic = false;
				picking_project_file = false;
				picking_shot2 = false;
				picking_shot1 = true;
				pick_img.setClass(getApplicationContext(), FilepicActivity.class);
				pick_img.putExtra("extension", ".png, .apng, .gif, .jpeg, .jpg");
				startActivity(pick_img);
			}
		});
		
		sc2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				picking_ic = false;
				picking_shot1 = false;
				picking_shot2 = true;
				picking_project_file = false;
				pick_img.setClass(getApplicationContext(), FilepicActivity.class);
				pick_img.putExtra("extension", ".png, .apng, .gif, .jpeg, .jpg");
				startActivity(pick_img);
			}
		});
		
		yturl.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		yturl.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (_charSeq.trim().equals("")) {
					yt_yrl_ok = true;
					yt_url = "";
				}
				else {
					if (_charSeq.contains("http://") || _charSeq.contains("https://")) {
						if (_charSeq.contains("youtube.com") || _charSeq.contains("youtu.be")) {
							yt_yrl_ok = true;
							textview30.setVisibility(View.GONE);
							yt_url = _charSeq;
						}
						else {
							textview30.setVisibility(View.VISIBLE);
							yturl.setError("Invalid Url");
							yt_yrl_ok = false;
							yt_url = "";
						}
					}
					else {
						yturl.setError("Url Must Contains http:// or https://");
						textview30.setVisibility(View.GONE);
						SketchwareUtil.showMessage(getApplicationContext(), "Recheck Video Trailer Link");
						yt_url = "";
						yt_yrl_ok = false;
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
					description_ = "";
					textview28.setTextColor(0xFFF44336);
					SketchwareUtil.showMessage(getApplicationContext(), "Only 2000 Characters Maximum");
				}
				else {
					textview28.setTextColor(0xFF000000);
					if (_charSeq.equals("")) {
						description_ = "";
						textview28.setText("0".concat("/2000"));
					}
					else {
						description_ = _charSeq;
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
		
		edittext5.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (200 < _charSeq.length()) {
					whatsnew = "";
					textview29.setTextColor(0xFFF44336);
				}
				else {
					textview29.setTextColor(0xFF000000);
					whatsnew = _charSeq;
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
		
		spinner_typeoproject.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				_Sk_Spinner_Create(_position);
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edit) {
					if (sk_apk) {
						if (apk_set) {
							picking_project_file = true;
							picking_shot1 = false;
							picking_shot2 = false;
							picking_ic = false;
							pick_apk.setClass(getApplicationContext(), FilepicActivity.class);
							pick_apk.putExtra("extension", ".apk");
							startActivity(pick_apk);
						}
						else {
							picking_project_file = true;
							picking_shot1 = false;
							picking_shot2 = false;
							picking_ic = false;
							pick_apk.setClass(getApplicationContext(), FilepicActivity.class);
							pick_apk.putExtra("extension", ".apk");
							startActivity(pick_apk);
						}
					}
					else {
						if (sk_project) {
							if (projectset) {
								export.edit().putString("exported", "false").commit();
								getproject.setClass(getApplicationContext(), ProjectManagerActivity.class);
								getproject.putExtra("mode", "export");
								startActivity(getproject);
							}
							else {
								export.edit().putString("exported", "false").commit();
								getproject.setClass(getApplicationContext(), ProjectManagerActivity.class);
								getproject.putExtra("mode", "export");
								startActivity(getproject);
							}
						}
						else {
							if (androidstudioapk) {
								if (apk_set) {
									picking_project_file = true;
									picking_shot1 = false;
									picking_shot2 = false;
									picking_ic = false;
									pick_apk.setClass(getApplicationContext(), FilepicActivity.class);
									pick_apk.putExtra("extension", ".apk");
									startActivity(pick_apk);
								}
								else {
									picking_project_file = true;
									picking_shot1 = false;
									picking_shot2 = false;
									picking_ic = false;
									pick_apk.setClass(getApplicationContext(), FilepicActivity.class);
									pick_apk.putExtra("extension", ".apk");
									startActivity(pick_apk);
								}
							}
							else {
								if (android_studii) {
									if (projectset) {
										picking_project_file = true;
										picking_shot1 = false;
										picking_shot2 = false;
										picking_ic = false;
										pick_apk.setClass(getApplicationContext(), FilepicActivity.class);
										pick_apk.putExtra("extension", ".zip");
										startActivity(pick_apk);
									}
									else {
										picking_project_file = true;
										picking_shot1 = false;
										picking_shot2 = false;
										picking_ic = false;
										pick_apk.setClass(getApplicationContext(), FilepicActivity.class);
										pick_apk.putExtra("extension", ".zip");
										startActivity(pick_apk);
									}
								}
							}
						}
					}
					
				}
				else {
					
					if (sk_apk) {
						if (apk_set) {
							attach_file.setText("Alltach File");
							imageview4.setImageResource(R.drawable.plus);
							apk_set = false;
							demo_apk.setVisibility(View.GONE);
							readed_text.setVisibility(View.GONE);
							textview38.setVisibility(View.GONE);
						}
						else {
							picking_project_file = true;
							picking_shot1 = false;
							picking_shot2 = false;
							picking_ic = false;
							pick_apk.setClass(getApplicationContext(), FilepicActivity.class);
							pick_apk.putExtra("extension", ".apk");
							startActivity(pick_apk);
						}
					}
					else {
						if (sk_project) {
							if (projectset) {
								attach_file.setText("Alltach the File");
								projectset = false;
								demo_apk.setVisibility(View.GONE);
								readed_text.setVisibility(View.GONE);
								imageview4.setImageResource(R.drawable.plus);
								if (FileUtil.isExistFile(sketifyDataDirectory.concat(".exported/exported.sk"))) {
									FileUtil.deleteFile(sketifyDataDirectory.concat(".exported"));
								}
								if (FileUtil.isExistFile(sketifyDataDirectory.concat("backups"))) {
									FileUtil.deleteFile(sketifyDataDirectory.concat("backups"));
								}
								textview38.setVisibility(View.GONE);
							}
							else {
								export.edit().putString("exported", "false").commit();
								getproject.setClass(getApplicationContext(), ProjectManagerActivity.class);
								getproject.putExtra("mode", "export");
								startActivity(getproject);
							}
						}
						else {
							if (androidstudioapk) {
								if (apk_set) {
									attach_file.setText("Alltach File");
									imageview4.setImageResource(R.drawable.plus);
									apk_set = false;
									demo_apk.setVisibility(View.GONE);
									readed_text.setVisibility(View.GONE);
									textview38.setVisibility(View.GONE);
								}
								else {
									picking_project_file = true;
									picking_shot1 = false;
									picking_shot2 = false;
									picking_ic = false;
									pick_apk.setClass(getApplicationContext(), FilepicActivity.class);
									pick_apk.putExtra("extension", ".apk");
									startActivity(pick_apk);
								}
							}
							else {
								if (android_studii) {
									if (projectset) {
										attach_file.setText("Alltach File");
										imageview4.setImageResource(R.drawable.plus);
										projectset = false;
										readed_text.setVisibility(View.GONE);
										demo_apk.setVisibility(View.GONE);
										textview38.setVisibility(View.GONE);
										if (FileUtil.isExistFile(sketifyDataDirectory.concat("backups"))) {
											FileUtil.deleteFile(sketifyDataDirectory.concat("backups"));
										}
										if (FileUtil.isExistFile(sketifyDataDirectory.concat(".exported/exported.sk"))) {
											FileUtil.deleteFile(sketifyDataDirectory.concat(".exported"));
										}
										if (FileUtil.isExistFile(sketifyDataDirectory.concat(".exported/exported.zip"))) {
											FileUtil.deleteFile(sketifyDataDirectory.concat(".exported"));
										}
									}
									else {
										picking_project_file = true;
										picking_shot1 = false;
										picking_shot2 = false;
										picking_ic = false;
										pick_apk.setClass(getApplicationContext(), FilepicActivity.class);
										pick_apk.putExtra("extension", ".zip");
										startActivity(pick_apk);
									}
								}
							}
						}
					}
				}
			}
		});
		
		edittext7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		edittext7.addTextChangedListener(new TextWatcher() {
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
		
		lin_category_spinner.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == 0) {
					textview_category.setText("-- SELECT --");
				}
				if (_position == 1) {
					textview_category.setText("Tools");
				}
				if (_position == 2) {
					textview_category.setText("UI & UX");
				}
				if (_position == 3) {
					textview_category.setText("Social");
				}
				if (_position == 4) {
					textview_category.setText("VideoGraphy");
				}
				if (_position == 5) {
					textview_category.setText("Bussiness");
				}
				if (_position == 6) {
					textview_category.setText("Books & References");
				}
				if (_position == 7) {
					textview_category.setText("Entertainment");
				}
				if (_position == 8) {
					textview_category.setText("Example & Tutorials");
				}
				if (_position == 9) {
					textview_category.setText("Games");
				}
				if (_position == 10) {
					textview_category.setText("Photography");
				}
				if (_position == 11) {
					textview_category.setText("Productivity");
				}
				if (_position == 12) {
					textview_category.setText("Music & Video");
				}
				if (_position == 13) {
					textview_category.setText("Multi - Device");
				}
				if (_position == 14) {
					textview_category.setText("Education");
				}
				if (_position == 15) {
					textview_category.setText("Communication");
				}
				if (_position == 16) {
					textview_category.setText("Others");
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					comments = "true";
				}
				if (!_isChecked) {
					comments = "false";
				}
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (useless) {
					if (spam) {
						if (abuse) {
							if (empty) {
								if (copied) {
									if (illegal) {
										terms = true;
										visi = "false";
										terms_main.setVisibility(View.GONE);
										upload_main.setVisibility(View.VISIBLE);
										toolbar.setVisibility(View.VISIBLE);
										if (edit) {
											if (icon_url.equals("")) {
												SketchwareUtil.showMessage(getApplicationContext(), "Select Icon");
												textview26.setVisibility(View.VISIBLE);
												terms_main.setVisibility(View.GONE);
												upload_main.setVisibility(View.VISIBLE);
											}
											else {
												if (description_.equals("")) {
													SketchwareUtil.showMessage(getApplicationContext(), "Please Enter Description");
													textview26.setVisibility(View.VISIBLE);
													terms_main.setVisibility(View.GONE);
													upload_main.setVisibility(View.VISIBLE);
												}
												else {
													if (name.equals("")) {
														SketchwareUtil.showMessage(getApplicationContext(), "Please Enter Name");
														textview26.setVisibility(View.VISIBLE);
														terms_main.setVisibility(View.GONE);
														upload_main.setVisibility(View.VISIBLE);
													}
													else {
														if (shot1_url.equals("")) {
															SketchwareUtil.showMessage(getApplicationContext(), "Please Select Shot 1");
															textview26.setVisibility(View.VISIBLE);
															terms_main.setVisibility(View.GONE);
															upload_main.setVisibility(View.VISIBLE);
														}
														else {
															if (shot2_url.equals("")) {
																SketchwareUtil.showMessage(getApplicationContext(), "Please Select Shot 2");
																textview26.setVisibility(View.VISIBLE);
																terms_main.setVisibility(View.GONE);
																upload_main.setVisibility(View.VISIBLE);
															}
															else {
																if (textview_category.getText().toString().equals("-- SELECT --")) {
																	SketchwareUtil.showMessage(getApplicationContext(), "Please Select Category");
																	textview26.setVisibility(View.VISIBLE);
																	terms_main.setVisibility(View.GONE);
																	upload_main.setVisibility(View.VISIBLE);
																}
																else {
																	_CheckNetwork();
																	_Front_End_Upload();
																}
															}
														}
													}
												}
											}
										}
										else {
											if (ic_name.equals("") || ic_path.equals("")) {
												SketchwareUtil.showMessage(getApplicationContext(), "Select Icon");
												textview26.setVisibility(View.VISIBLE);
												terms_main.setVisibility(View.GONE);
												upload_main.setVisibility(View.VISIBLE);
											}
											else {
												if (description_.equals("")) {
													SketchwareUtil.showMessage(getApplicationContext(), "Please Enter Description");
													textview26.setVisibility(View.VISIBLE);
													terms_main.setVisibility(View.GONE);
													upload_main.setVisibility(View.VISIBLE);
												}
												else {
													if (name.equals("")) {
														SketchwareUtil.showMessage(getApplicationContext(), "Please Enter Name");
														textview26.setVisibility(View.VISIBLE);
														terms_main.setVisibility(View.GONE);
														upload_main.setVisibility(View.VISIBLE);
													}
													else {
														if (shot1_path.equals("")) {
															SketchwareUtil.showMessage(getApplicationContext(), "Please Select Shot 1");
															textview26.setVisibility(View.VISIBLE);
															terms_main.setVisibility(View.GONE);
															upload_main.setVisibility(View.VISIBLE);
														}
														else {
															if (shot2_path.equals("")) {
																SketchwareUtil.showMessage(getApplicationContext(), "Please Select Shot 2");
																textview26.setVisibility(View.VISIBLE);
																terms_main.setVisibility(View.GONE);
																upload_main.setVisibility(View.VISIBLE);
															}
															else {
																if (textview_category.getText().toString().equals("-- SELECT --")) {
																	SketchwareUtil.showMessage(getApplicationContext(), "Please Select Category");
																	textview26.setVisibility(View.VISIBLE);
																	terms_main.setVisibility(View.GONE);
																	upload_main.setVisibility(View.VISIBLE);
																}
																else {
																	_CheckNetwork();
																	_Front_End_Upload();
																}
															}
														}
													}
												}
											}
										}
									}
									else {
										
									}
								}
								else {
									
								}
							}
							else {
								
							}
						}
						else {
							
						}
					}
					else {
						
					}
				}
				else {
					
				}
			}
		});
		
		switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				spam = false;
				if (_isChecked) {
					spam = true;
				}
				else {
					spam = false;
				}
			}
		});
		
		switch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				abuse = false;
				if (_isChecked) {
					abuse = true;
				}
				else {
					abuse = false;
				}
			}
		});
		
		switch5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				empty = false;
				if (_isChecked) {
					empty = true;
				}
				else {
					empty = false;
				}
			}
		});
		
		switch6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				illegal = false;
				if (_isChecked) {
					illegal = true;
				}
				else {
					illegal = false;
				}
			}
		});
		
		switch7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				copied = false;
				if (_isChecked) {
					copied = true;
				}
				else {
					copied = false;
				}
			}
		});
		
		switch9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				useless = false;
				if (_isChecked) {
					useless = true;
				}
				else {
					useless = false;
				}
			}
		});
		
		_data1_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				fullProject++;
				if (edit) {
					if (_childKey.equals(getIntent().getStringExtra("key"))) {
						if (_childValue.containsKey("icon")) {
							Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("icon").toString())).into(icon_);
							icon_url = _childValue.get("icon").toString();
						}
						else {
							icon_.setImageResource(R.drawable.android_icon);
						}
						if (_childValue.containsKey("title")) {
							title.setText(_childValue.get("title").toString());
							file_name.setText(_childValue.get("title").toString());
						}
						if (_childValue.containsKey("project")) {
							dwnd_url = _childValue.get("project").toString();
							projectset = true;
							apk_set = false;
							if (_childValue.containsKey("size")) {
								project_size = _childValue.get("size").toString();
							}
						}
						else {
							if (_childValue.containsKey("apk")) {
								dwnd_url = _childValue.get("apk").toString();
								apk_set = true;
								projectset = false;
								if (_childValue.containsKey("size")) {
									apk_size = _childValue.get("size").toString();
								}
							}
						}
						if (_childValue.containsKey("description")) {
							description.setText(_childValue.get("description").toString());
						}
						if (_childValue.containsKey("comments_visibility")) {
							comments = _childValue.get("comments_visibility").toString();
							if (comments.equals("true")) {
								switch1.setChecked(true);
							}
							else {
								switch1.setChecked(false);
							}
						}
						if (_childValue.containsKey("shot1")) {
							Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("shot1").toString())).into(sc1);
							shot1_url = _childValue.get("shot1").toString();
						}
						if (_childValue.containsKey("shot2")) {
							Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("shot2").toString())).into(sc2);
							shot2_url = _childValue.get("shot2").toString();
						}
						if (_childValue.containsKey("yt_url")) {
							if (!_childValue.get("yt_url").toString().equals("")) {
								yturl.setText(_childValue.get("yt_url").toString());
								yt_url = _childValue.get("yt_url").toString();
							}
						}
						if (_childValue.containsKey("whatsnew")) {
							edittext5.setText(_childValue.get("whatsnew").toString());
							whatsnew = _childValue.get("whatsnew").toString();
						}
						if (_childValue.containsKey("project category")) {
							if (_childValue.get("project category").toString().equals("Sketchware Project")) {
								_Sk_Spinner_Create(2);
								_OpenOrea("skp");
							}
							else {
								if (_childValue.get("project category").toString().equals("Sketchware Apk")) {
									_Sk_Spinner_Create(1);
									_OpenOrea("ska");
								}
								else {
									if (_childValue.get("project category").toString().equals("Android Studio Apk")) {
										_Sk_Spinner_Create(3);
										_OpenOrea("asa");
									}
									else {
										if (_childValue.get("project category").toString().equals("Android Studio")) {
											_Sk_Spinner_Create(4);
											_OpenOrea("asp");
										}
										else {
											_Sk_Spinner_Create(0);
										}
									}
								}
							}
						}
						else {
							_Sk_Spinner_Create(0);
						}
					}
					if (_childValue.containsKey("demo")) {
						edittext7.setText(_childValue.get("demo").toString());
						demoLink = _childValue.get("demo").toString();
					}
					else {
						edittext7.setText(_childValue.get("demo").toString());
						demoLink = _childValue.get("demo").toString();
					}
					if (_childValue.containsKey("category")) {
						textview_category.setText(_childValue.get("category").toString());
					}
					if (_childValue.containsKey("size")) {
						if (apk_set) {
							apk_size = _childValue.get("size").toString();
						}
						else {
							if (projectset) {
								project_size = _childValue.get("size").toString();
							}
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
		data1.addChildEventListener(_data1_child_listener);
		
		_icon_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_icon_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_icon_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				icon_url = _downloadUrl;
				iconupd = true;
			}
		};
		
		_icon_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_icon_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_icon_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
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
				
			}
		};
		
		_project_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				_Upload(_downloadUrl);
			}
		};
		
		_project_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
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
				shot1_url = _downloadUrl;
				shot1upd = true;
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
				shot2_url = _downloadUrl;
				shot2upd = true;
				prog.setMessage("Uploading Project Files...");
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
		
		_users_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
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
		
		_projects_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if ((_childValue.containsKey("key") && _childValue.containsKey("value")) && _childValue.containsKey("uid")) {
					if (key.equals(_childValue.get("key").toString()) && _childValue.get("value").toString().equals("true")) {
						user_dwnds++;
						map2 = new HashMap<>();
						map2.put("projects", String.valueOf((long)(user_dwnds)));
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
				if (_childValue.get("key").toString().equals(key)) {
					if (_childValue.get("value").toString().equals("true")) {
						user_dwnds++;
						map2 = new HashMap<>();
						map2.put("projects", String.valueOf((long)(user_dwnds)));
						data1.child(key).updateChildren(map2);
						map2.clear();
					}
					else {
						user_dwnds--;
						map2 = new HashMap<>();
						map2.put("projects", String.valueOf((long)(user_dwnds)));
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
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		projects.addChildEventListener(_projects_child_listener);
		
		_net_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				htmlProgram = _response;
				netResponsed = true;
				terms_main.setVisibility(View.GONE);
				upload_main.setVisibility(View.VISIBLE);
				progress.setVisibility(View.GONE);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				upload_main.setVisibility(View.GONE);
				terms_main.setVisibility(View.GONE);
				progress.setVisibility(View.VISIBLE);
				final AlertDialog error_dialog = new AlertDialog.Builder(UploadActivity.this).create();
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
		
		_get_html_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
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
		fullProject = 0;
		edit = false;
		if (getIntent().getStringExtra("mode").equals("edit")) {
			edit = true;
			_Edit();
		}
		_Elevation(toolbar, 12);
		sketchPath = FileUtil.getExternalStorageDir().concat("/.sketchware/");
		sketifyDataDirectory = FileUtil.getExternalStorageDir().concat("/Android/data/com.sketify.msk/");
		sketifyDirectory = FileUtil.getExternalStorageDir().concat("/Sketify/");
		if (!FileUtil.isExistFile(sketchPath)) {
			FileUtil.makeDir(sketchPath);
		}
		if (!FileUtil.isExistFile(sketifyDataDirectory)) {
			FileUtil.makeDir(sketifyDataDirectory);
		}
		if (!FileUtil.isExistFile(sketifyDirectory)) {
			FileUtil.makeDir(sketifyDirectory);
		}
		progress.setVisibility(View.GONE);
		terms_main.setVisibility(View.GONE);
		textview30.setVisibility(View.GONE);
		demo_apk.setVisibility(View.GONE);
		textview37.setVisibility(View.GONE);
		readed_text.setVisibility(View.GONE);
		textview38.setVisibility(View.GONE);
		linear4.setVisibility(View.VISIBLE);
		whatsnew_linear.setVisibility(View.VISIBLE);
		vidtrailer_lin.setVisibility(View.VISIBLE);
		typeofpro_linear.setVisibility(View.VISIBLE);
		atch_file_linear.setVisibility(View.GONE);
		textview30.setVisibility(View.GONE);
		type_of_upload.add("--SELECT--");
		type_of_upload.add("Sketchware Apk");
		type_of_upload.add("Sketchware Project");
		type_of_upload.add("Android Studio Apk");
		type_of_upload.add("Android Studio");
		spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, type_of_upload));
		((ArrayAdapter)spinner1.getAdapter()).notifyDataSetChanged();
		category.add("--SELECT--");
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
		spinner3.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, category));
		((ArrayAdapter)spinner3.getAdapter()).notifyDataSetChanged();
		_Progress_Create();
		_Elevation(toolbar, 20);
		_Elevation(sc1, 7);
		_Elevation(sc2, 7);
		_Elevation(lin_category_spinner, 8);
		_Elevation(spinner_typeoproject, 8);
		_changeActivityFont("google_sans_regular");
		_rippleRoundStroke(whatsnew_linear, "#FFFFFF", "#E0E0E0", 20, 3, "#3F51B5");
		_rippleRoundStroke(vidtrailer_lin, "#FFFFFF", "#E0E0E0", 20, 3, "#3F51B5");
		_rippleRoundStroke(des_linear, "#FFFFFF", "#E0E0E0", 20, 3, "#3F51B5");
		_rippleRoundStroke(icon_, "#FFFFFF", "#E0E0E0", 20, 0, "#3F51B5");
		_rippleRoundStroke(attach_file_main, "#FFFFFF", "#E0E0E0", 20, 3, "#3F51B5");
		_rippleRoundStroke(name_linear_ic, "#FFFFFF", "#E0E0E0", 20, 3, "#3F51B5");
		_rippleRoundStroke(choosecat_linear, "#FFFFFF", "#BDBDBD", 20, 3, "#3F51B5");
		_rippleRoundStroke(lin_add, "#FFFFFF", "#E0E0E0", 20, 3, "#3F51B5");
		_rippleRoundStroke(imageview4, "#FFFFFF", "#BDBDBD", 20, 0, "#3F51B5");
		_rippleRoundStroke(imageview1, "#536DFE", "#FFFFFF", 50, 0, "#FFFFFF");
		_rippleRoundStroke(imageview4, "#FFFFFF", "#E0E0E0", 20, 0, "#3F51B5");
		_rippleRoundStroke(spinner_typeoproject, "#FFFFFF", "#E0E0E0", 20, 3, "#E0E0E0");
		_rippleRoundStroke(lin_category_spinner, "#FFFFFF", "#E0E0E0", 20, 3, "#E0E0E0");
		_rippleRoundStroke(sc1, "#FFFFFF", "#E0E0E0", 0, 3, "#EEEEEE");
		_rippleRoundStroke(sc2, "#FFFFFF", "#E0E0E0", 0, 3, "#EEEEEE");
		_SetCover(textview26, "#E0E0E0", "#FFFFFF", 20);
		terms = false;
		yt_yrl_ok = true;
		visi = "false";
		comments = "true";
		visibility = "true";
	}
	
	@Override
	public void onBackPressed() {
		if (visi.equals("true")) {
			terms_main.setVisibility(View.GONE);
			upload_main.setVisibility(View.VISIBLE);
			textview26.setVisibility(View.VISIBLE);
			toolbar.setVisibility(View.VISIBLE);
			switch1.setChecked(false);
			switch3.setChecked(false);
			switch4.setChecked(false);
			switch5.setChecked(false);
			switch6.setChecked(false);
			switch7.setChecked(false);
			switch9.setChecked(false);
			terms = false;
			visi = "false";
		}
		else {
			exit.setTitle("Exit");
			exit.setMessage("Are You Sure You want To Exit?, Your Changes Were Been Not Saved!");
			exit.setPositiveButton("YES", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					if (FileUtil.isExistFile(sketifyDataDirectory.concat(".exported/exported.sk"))) {
						FileUtil.deleteFile(sketifyDataDirectory.concat(".exported"));
					}
					if (FileUtil.isExistFile(sketifyDataDirectory.concat("backups"))) {
						FileUtil.deleteFile(sketifyDataDirectory.concat("backups"));
					}
					if (FileUtil.isExistFile(sketifyDataDirectory.concat(".project"))) {
						FileUtil.deleteFile(sketifyDataDirectory.concat(".project"));
					}
					finish();
				}
			});
			exit.setNegativeButton("NO", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					
				}
			});
			exit.create().show();
		}
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (!file.getString("picked_path", "").equals("")) {
			filePath.add((int)(0), file.getString("picked_path", ""));
			file.edit().putString("picked_path", "").commit();
			if (picking_project_file) {
				if (sk_apk) {
					if (filePath.get((int)(0)).contains(".apk".toLowerCase())) {
						apk_set = true;
						projectset = false;
						apk_path = filePath.get((int)(0));
						apk_name = Uri.parse(filePath.get((int)(0))).getLastPathSegment();
						file_name.setText(Uri.parse(filePath.get((int)(0))).getLastPathSegment());
						imageview4.setImageResource(R.drawable.ic_close_grey);
						demo_apk.setVisibility(View.GONE);
						readed_text.setVisibility(View.VISIBLE);
						_GetFileSize(apk_path);
						apk_size = returnedSize;
						if (apk_size.contains("MB")) {
							if (20 < Double.parseDouble(String.valueOf((long)(Double.parseDouble(apk_size.replace(" MB", "")))))) {
								attach_file.setText("Attach Apk File");
								imageview4.setImageResource(R.drawable.ic_add_black);
								apk_set = false;
								projectset = false;
								demo_apk.setVisibility(View.GONE);
								readed_text.setVisibility(View.GONE);
								apk_path = "";
								apk_name = "";
								apk_size = "";
								textview38.setVisibility(View.GONE);
								big_file_warn.setTitle("Big File");
								big_file_warn.setMessage("Your Choosed Files is Bigger than our Maximum 20MB Size. if you need to upload big files, you need to contact us.");
								big_file_warn.setPositiveButton("OK", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										
									}
								});
								big_file_warn.create().show();
							}
						}
					}
					else {
						attach_file.setText("Attach Apk File");
						imageview4.setImageResource(R.drawable.ic_add_black);
						apk_set = false;
						projectset = false;
						apk_path = "";
						apk_name = "";
						SketchwareUtil.showMessage(getApplicationContext(), "Apk Only");
						demo_apk.setVisibility(View.GONE);
						readed_text.setVisibility(View.GONE);
						textview38.setVisibility(View.GONE);
					}
				}
				else {
					if (androidstudioapk) {
						if (filePath.get((int)(0)).contains(".apk".toLowerCase())) {
							apk_set = true;
							projectset = false;
							apk_path = filePath.get((int)(0));
							apk_name = Uri.parse(filePath.get((int)(0))).getLastPathSegment();
							file_name.setText(Uri.parse(filePath.get((int)(0))).getLastPathSegment());
							imageview4.setImageResource(R.drawable.ic_close_grey);
							demo_apk.setVisibility(View.GONE);
							readed_text.setVisibility(View.VISIBLE);
							_GetFileSize(filePath.get((int)(0)));
							apk_size = returnedSize;
							if (apk_size.contains("MB")) {
								if (20 < Double.parseDouble(String.valueOf((long)(Double.parseDouble(apk_size.replace(" MB", "")))))) {
									attach_file.setText("Attach Apk File");
									imageview4.setImageResource(R.drawable.ic_add_black);
									apk_set = false;
									projectset = false;
									demo_apk.setVisibility(View.GONE);
									readed_text.setVisibility(View.GONE);
									apk_path = "";
									apk_name = "";
									apk_size = "";
									textview38.setVisibility(View.GONE);
									big_file_warn.setTitle("Big File");
									big_file_warn.setMessage("Your Choosed Files is Bigger than our Maximum 20MB Size. if you need to upload big files, you need to contact us.");
									big_file_warn.setPositiveButton("OK", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											
										}
									});
									big_file_warn.create().show();
								}
							}
						}
						else {
							attach_file.setText("Attach Apk File");
							imageview4.setImageResource(R.drawable.ic_add_black);
							apk_path = "";
							apk_name = "";
							SketchwareUtil.showMessage(getApplicationContext(), "Apk Only");
							apk_set = false;
							projectset = false;
							demo_apk.setVisibility(View.GONE);
							readed_text.setVisibility(View.GONE);
							textview38.setVisibility(View.GONE);
						}
					}
					else {
						if (android_studii) {
							if (filePath.get((int)(0)).contains(".zip".toLowerCase())) {
								apk_set = false;
								projectset = true;
								project_patg = filePath.get((int)(0));
								project_name = Uri.parse(filePath.get((int)(0))).getLastPathSegment();
								_GetFileSize(filePath.get((int)(0)));
								file_name.setText(Uri.parse(filePath.get((int)(0))).getLastPathSegment());
								demo_apk.setVisibility(View.VISIBLE);
								readed_text.setVisibility(View.VISIBLE);
								imageview4.setImageResource(R.drawable.ic_close_grey);
								textview38.setVisibility(View.VISIBLE);
								if (project_size.contains("MB")) {
									if (20 < Double.parseDouble(String.valueOf((long)(Double.parseDouble(project_size.replace(" MB", "")))))) {
										attach_file.setText("Attach Zip File");
										imageview4.setImageResource(R.drawable.ic_add_black);
										apk_set = false;
										projectset = false;
										demo_apk.setVisibility(View.GONE);
										readed_text.setVisibility(View.GONE);
										apk_path = "";
										apk_name = "";
										apk_size = "";
										textview38.setVisibility(View.GONE);
										big_file_warn.setTitle("Big File");
										big_file_warn.setMessage("Your Choosed Files is Bigger than our Maximum 20MB Size. if you need to upload big files, you need to contact us.");
										big_file_warn.setPositiveButton("OK", new DialogInterface.OnClickListener() {
											@Override
											public void onClick(DialogInterface _dialog, int _which) {
												
											}
										});
										big_file_warn.create().show();
									}
								}
							}
							else {
								file_name.setText("Attach Zip File");
								imageview4.setImageResource(R.drawable.ic_add_black);
								project_patg = "";
								project_name = "";
								SketchwareUtil.showMessage(getApplicationContext(), "Zip Files Only");
								apk_set = false;
								projectset = false;
								demo_apk.setVisibility(View.GONE);
								readed_text.setVisibility(View.GONE);
								textview38.setVisibility(View.GONE);
							}
						}
					}
				}
			}
			else {
				if (picking_ic) {
					ic_path = filePath.get((int)(0));
					ic_name = Uri.parse(filePath.get((int)(0))).getLastPathSegment();
					icon_.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(filePath.get((int)(0)), 1024, 1024));
				}
				else {
					if (picking_shot1) {
						shot1_path = filePath.get((int)(0));
						shot1_name = Uri.parse(filePath.get((int)(0))).getLastPathSegment();
						sc1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(filePath.get((int)(0)), 1024, 1024));
					}
					else {
						if (picking_shot2) {
							shot2_path = filePath.get((int)(0));
							shot2_name = Uri.parse(filePath.get((int)(0))).getLastPathSegment();
							sc2.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(filePath.get((int)(0)), 1024, 1024));
						}
						else {
							attach_file.setText("Attach File");
						}
					}
				}
			}
		}
		if (export.getString("exported", "").equals("true")) {
			if (FileUtil.isExistFile(FileUtil.getExternalStorageDir().concat("/Android/data/com.sketify.msk/".concat(".exported/exported.sk")))) {
				if (sk_project) {
					if (edit) {
						projectset = true;
						imageview4.setImageResource(R.drawable.ic_close_grey);
						demo_apk.setVisibility(View.VISIBLE);
						export.edit().putString("exported", "false").commit();
						_GetFileSize(FileUtil.getExternalStorageDir().concat("/Android/data/com.sketify.msk/".concat(".exported/exported.sk")));
						project_size = returnedSize;
						SketchwareUtil.showMessage(getApplicationContext(), returnedSize);
						file_name.setText("exported.sk");
						textview38.setVisibility(View.VISIBLE);
						readed_text.setVisibility(View.VISIBLE);
					}
					else {
						if (!projectset) {
							projectset = true;
							imageview4.setImageResource(R.drawable.ic_close_grey);
							demo_apk.setVisibility(View.VISIBLE);
							export.edit().putString("exported", "false").commit();
							_GetFileSize(FileUtil.getExternalStorageDir().concat("/Android/data/com.sketify.msk/".concat(".exported/exported.sk")));
							project_size = returnedSize;
							SketchwareUtil.showMessage(getApplicationContext(), returnedSize);
							readed_text.setVisibility(View.VISIBLE);
							file_name.setText("exported.sk");
							textview38.setVisibility(View.VISIBLE);
						}
					}
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
	
	
	public void _ProgresbarDimiss() {
		if(prog != null)
		{
			prog.dismiss();
		}
	}
	
	
	public void _ProgresbarShow(final String _title) {
		prog = new ProgressDialog(UploadActivity.this);
		prog.setMax(100);
		prog.setTitle("Please wait");
		prog.setMessage(_title);
		prog.setIndeterminate(true);
		prog.setCancelable(false);
		prog.show();
	}
	
	
	public void _Sk_Spinner_Create(final double _position) {
		if (_position == 0) {
			atch_file_linear.setVisibility(View.GONE);
			textview17.setText("--SELECT--");
			sk_apk = false;
			sk_project = false;
			androidstudioapk = false;
			android_studii = false;
		}
		if (_position == 1) {
			atch_file_linear.setVisibility(View.VISIBLE);
			textview17.setText("Sketchware Apk");
			sk_apk = true;
			sk_project = false;
			androidstudioapk = false;
			android_studii = false;
		}
		if (_position == 2) {
			atch_file_linear.setVisibility(View.VISIBLE);
			textview17.setText("Sketchware Project");
			sk_apk = false;
			sk_project = true;
			androidstudioapk = false;
			android_studii = false;
		}
		if (_position == 3) {
			atch_file_linear.setVisibility(View.VISIBLE);
			textview17.setText("Android Studio Apk");
			sk_apk = false;
			sk_project = false;
			androidstudioapk = true;
			android_studii = false;
		}
		if (_position == 4) {
			atch_file_linear.setVisibility(View.VISIBLE);
			textview17.setText("Android Studio");
			sk_apk = false;
			sk_project = false;
			androidstudioapk = false;
			android_studii = true;
		}
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
		textview26.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_bold.ttf"), 1);
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
	
	
	public void _SetCover(final View _view, final String _c, final String _color, final double _numb) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		gd.setCornerRadius((int)_numb);
		_view.setBackground(gd);
		android.content.res.ColorStateList clr = new android.content.res.ColorStateList(new int[][]{new int[]{}},new int[]{Color.parseColor(_c)}); android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(clr, null, null); _view.setBackground(ripdr);
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
	
	
	public void _CheckNetwork() {
		upload_main.setVisibility(View.GONE);
		terms_main.setVisibility(View.GONE);
		progress.setVisibility(View.VISIBLE);
		net.startRequestNetwork(RequestNetworkController.GET, "https://sketifyapp.000webhostapp.com/project_files/program.html", "dg", _net_request_listener);
	}
	
	
	public void _Front_End_Upload() {
		
		
		
		internet = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (netResponsed) {
							internet.cancel();
							if (edit) {
								if (sk_project) {
									if (projectset) {
										textview26.setVisibility(View.GONE);
										terms_main.setVisibility(View.GONE);
										upload_main.setVisibility(View.VISIBLE);
										_ProgresbarShow("Uploading Project Details...");
										if (!(shot1_path.equals("") && shot1_name.equals(""))) {
											if (!shot1_url.equals("")) {
												_firebase_storage.getReferenceFromUrl(shot1_url).delete().addOnSuccessListener(_shot1s_delete_success_listener).addOnFailureListener(_shot1s_failure_listener);
											}
											shot1s.child(shot1_name).putFile(Uri.fromFile(new File(shot1_path))).addOnFailureListener(_shot1s_failure_listener).addOnProgressListener(_shot1s_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
												@Override
												public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
													return shot1s.child(shot1_name).getDownloadUrl();
												}}).addOnCompleteListener(_shot1s_upload_success_listener);
										}
										else {
											shot1upd = true;
										}
										if (!(shot2_path.equals("") && shot2_name.equals(""))) {
											if (!shot2_url.equals("")) {
												_firebase_storage.getReferenceFromUrl(shot2_url).delete().addOnSuccessListener(_shot2s_delete_success_listener).addOnFailureListener(_shot2s_failure_listener);
											}
											shot2s.child(shot2_name).putFile(Uri.fromFile(new File(shot2_path))).addOnFailureListener(_shot2s_failure_listener).addOnProgressListener(_shot2s_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
												@Override
												public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
													return shot2s.child(shot2_name).getDownloadUrl();
												}}).addOnCompleteListener(_shot2s_upload_success_listener);
										}
										else {
											shot2upd = true;
										}
										if (!(ic_path.equals("") && ic_name.equals(""))) {
											if (!icon_url.equals("")) {
												_firebase_storage.getReferenceFromUrl(icon_url).delete().addOnSuccessListener(_icon_delete_success_listener).addOnFailureListener(_icon_failure_listener);
											}
											icon.child(ic_name).putFile(Uri.fromFile(new File(ic_path))).addOnFailureListener(_icon_failure_listener).addOnProgressListener(_icon_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
												@Override
												public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
													return icon.child(ic_name).getDownloadUrl();
												}}).addOnCompleteListener(_icon_upload_success_listener);
										}
										else {
											iconupd = true;
										}
										if (FileUtil.isExistFile(sketifyDataDirectory.concat(".exported/exported.sk"))) {
											project.child(name).putFile(Uri.fromFile(new File(sketifyDataDirectory.concat(".exported/exported.sk")))).addOnFailureListener(_project_failure_listener).addOnProgressListener(_project_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
												@Override
												public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
													return project.child(name).getDownloadUrl();
												}}).addOnCompleteListener(_project_upload_success_listener);
											if (!dwnd_url.equals("")) {
												_firebase_storage.getReferenceFromUrl(dwnd_url).delete().addOnSuccessListener(_project_delete_success_listener).addOnFailureListener(_project_failure_listener);
											}
										}
										else {
											_Upload(dwnd_url);
										}
									}
									else {
										SketchwareUtil.showMessage(getApplicationContext(), "Please Select Project");
										textview26.setVisibility(View.VISIBLE);
										terms_main.setVisibility(View.GONE);
										upload_main.setVisibility(View.VISIBLE);
									}
								}
								else {
									if (sk_apk) {
										if (apk_set) {
											textview26.setVisibility(View.GONE);
											terms_main.setVisibility(View.GONE);
											upload_main.setVisibility(View.VISIBLE);
											_ProgresbarShow("Uploading Project Details...");
											if (!(shot1_path.equals("") && shot1_name.equals(""))) {
												shot1s.child(shot1_name).putFile(Uri.fromFile(new File(shot1_path))).addOnFailureListener(_shot1s_failure_listener).addOnProgressListener(_shot1s_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
													@Override
													public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
														return shot1s.child(shot1_name).getDownloadUrl();
													}}).addOnCompleteListener(_shot1s_upload_success_listener);
												if (!shot1_url.equals("")) {
													_firebase_storage.getReferenceFromUrl(shot1_url).delete().addOnSuccessListener(_shot1s_delete_success_listener).addOnFailureListener(_shot1s_failure_listener);
												}
											}
											else {
												shot1upd = true;
											}
											if (!(shot2_path.equals("") && shot2_name.equals(""))) {
												shot2s.child(shot2_name).putFile(Uri.fromFile(new File(shot2_path))).addOnFailureListener(_shot2s_failure_listener).addOnProgressListener(_shot2s_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
													@Override
													public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
														return shot2s.child(shot2_name).getDownloadUrl();
													}}).addOnCompleteListener(_shot2s_upload_success_listener);
												if (!shot2_url.equals("")) {
													_firebase_storage.getReferenceFromUrl(shot2_url).delete().addOnSuccessListener(_shot2s_delete_success_listener).addOnFailureListener(_shot2s_failure_listener);
												}
											}
											else {
												shot2upd = true;
											}
											if (!(ic_path.equals("") && ic_name.equals(""))) {
												icon.child(ic_name).putFile(Uri.fromFile(new File(ic_path))).addOnFailureListener(_icon_failure_listener).addOnProgressListener(_icon_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
													@Override
													public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
														return icon.child(ic_name).getDownloadUrl();
													}}).addOnCompleteListener(_icon_upload_success_listener);
												if (!icon_url.equals("")) {
													_firebase_storage.getReferenceFromUrl(icon_url).delete().addOnSuccessListener(_icon_delete_success_listener).addOnFailureListener(_icon_failure_listener);
												}
											}
											else {
												iconupd = true;
											}
											if (!(apk_path.equals("") && apk_name.equals(""))) {
												if (!dwnd_url.equals("")) {
													_firebase_storage.getReferenceFromUrl(dwnd_url).delete().addOnSuccessListener(_project_delete_success_listener).addOnFailureListener(_project_failure_listener);
												}
												project.child(apk_name).putFile(Uri.fromFile(new File(apk_path))).addOnFailureListener(_project_failure_listener).addOnProgressListener(_project_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
													@Override
													public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
														return project.child(apk_name).getDownloadUrl();
													}}).addOnCompleteListener(_project_upload_success_listener);
											}
											else {
												_Upload(dwnd_url);
											}
										}
										else {
											SketchwareUtil.showMessage(getApplicationContext(), "Please Select Apk");
											textview26.setVisibility(View.VISIBLE);
											terms_main.setVisibility(View.GONE);
											upload_main.setVisibility(View.VISIBLE);
										}
									}
									else {
										if (androidstudioapk) {
											if (apk_set) {
												textview26.setVisibility(View.GONE);
												terms_main.setVisibility(View.GONE);
												upload_main.setVisibility(View.VISIBLE);
												_ProgresbarShow("Uploading Project Details...");
												if (!(shot1_path.equals("") && shot1_name.equals(""))) {
													shot1s.child(shot1_name).putFile(Uri.fromFile(new File(shot1_path))).addOnFailureListener(_shot1s_failure_listener).addOnProgressListener(_shot1s_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
														@Override
														public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
															return shot1s.child(shot1_name).getDownloadUrl();
														}}).addOnCompleteListener(_shot1s_upload_success_listener);
													if (!shot1_url.equals("")) {
														_firebase_storage.getReferenceFromUrl(shot1_url).delete().addOnSuccessListener(_shot1s_delete_success_listener).addOnFailureListener(_shot1s_failure_listener);
													}
												}
												else {
													shot1upd = true;
												}
												if (!(shot2_path.equals("") && shot2_name.equals(""))) {
													shot2s.child(shot2_name).putFile(Uri.fromFile(new File(shot2_path))).addOnFailureListener(_shot2s_failure_listener).addOnProgressListener(_shot2s_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
														@Override
														public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
															return shot2s.child(shot2_name).getDownloadUrl();
														}}).addOnCompleteListener(_shot2s_upload_success_listener);
													if (!shot2_url.equals("")) {
														_firebase_storage.getReferenceFromUrl(shot2_url).delete().addOnSuccessListener(_shot2s_delete_success_listener).addOnFailureListener(_shot2s_failure_listener);
													}
												}
												else {
													shot2upd = true;
												}
												if (!(ic_path.equals("") && ic_name.equals(""))) {
													icon.child(ic_name).putFile(Uri.fromFile(new File(ic_path))).addOnFailureListener(_icon_failure_listener).addOnProgressListener(_icon_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
														@Override
														public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
															return icon.child(ic_name).getDownloadUrl();
														}}).addOnCompleteListener(_icon_upload_success_listener);
													if (!icon_url.equals("")) {
														_firebase_storage.getReferenceFromUrl(icon_url).delete().addOnSuccessListener(_icon_delete_success_listener).addOnFailureListener(_icon_failure_listener);
													}
												}
												else {
													iconupd = true;
												}
												if (!(apk_path.equals("") && apk_name.equals(""))) {
													project.child(apk_name).putFile(Uri.fromFile(new File(apk_path))).addOnFailureListener(_project_failure_listener).addOnProgressListener(_project_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
														@Override
														public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
															return project.child(apk_name).getDownloadUrl();
														}}).addOnCompleteListener(_project_upload_success_listener);
													if (!dwnd_url.equals("")) {
														_firebase_storage.getReferenceFromUrl(dwnd_url).delete().addOnSuccessListener(_project_delete_success_listener).addOnFailureListener(_project_failure_listener);
													}
												}
												else {
													_Upload(dwnd_url);
												}
											}
											else {
												SketchwareUtil.showMessage(getApplicationContext(), "Please Select Apk");
												textview26.setVisibility(View.VISIBLE);
												terms_main.setVisibility(View.GONE);
												upload_main.setVisibility(View.VISIBLE);
											}
										}
										else {
											if (android_studii) {
												if (projectset) {
													textview26.setVisibility(View.GONE);
													terms_main.setVisibility(View.GONE);
													upload_main.setVisibility(View.VISIBLE);
													_ProgresbarShow("Uploading Project Details...");
													if (!(shot1_path.equals("") && shot1_name.equals(""))) {
														if (!shot1_url.equals("")) {
															_firebase_storage.getReferenceFromUrl(shot1_url).delete().addOnSuccessListener(_shot1s_delete_success_listener).addOnFailureListener(_shot1s_failure_listener);
														}
														shot1s.child(shot1_name).putFile(Uri.fromFile(new File(shot1_path))).addOnFailureListener(_shot1s_failure_listener).addOnProgressListener(_shot1s_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
															@Override
															public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
																return shot1s.child(shot1_name).getDownloadUrl();
															}}).addOnCompleteListener(_shot1s_upload_success_listener);
													}
													else {
														shot1upd = true;
													}
													if (!(shot2_path.equals("") && shot2_name.equals(""))) {
														if (!shot2_url.equals("")) {
															_firebase_storage.getReferenceFromUrl(shot2_url).delete().addOnSuccessListener(_shot2s_delete_success_listener).addOnFailureListener(_shot2s_failure_listener);
														}
														shot2s.child(shot2_name).putFile(Uri.fromFile(new File(shot2_path))).addOnFailureListener(_shot2s_failure_listener).addOnProgressListener(_shot2s_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
															@Override
															public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
																return shot2s.child(shot2_name).getDownloadUrl();
															}}).addOnCompleteListener(_shot2s_upload_success_listener);
													}
													else {
														shot2upd = true;
													}
													if (!(ic_path.equals("") && ic_name.equals(""))) {
														if (!icon_url.equals("")) {
															_firebase_storage.getReferenceFromUrl(icon_url).delete().addOnSuccessListener(_icon_delete_success_listener).addOnFailureListener(_icon_failure_listener);
														}
														icon.child(ic_name).putFile(Uri.fromFile(new File(ic_path))).addOnFailureListener(_icon_failure_listener).addOnProgressListener(_icon_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
															@Override
															public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
																return icon.child(ic_name).getDownloadUrl();
															}}).addOnCompleteListener(_icon_upload_success_listener);
													}
													else {
														iconupd = true;
													}
													if (!(project_patg.equals("") && project_name.equals(""))) {
														if (!dwnd_url.equals("")) {
															_firebase_storage.getReferenceFromUrl(dwnd_url).delete().addOnSuccessListener(_project_delete_success_listener).addOnFailureListener(_project_failure_listener);
														}
														project.child(project_name).putFile(Uri.fromFile(new File(project_patg))).addOnFailureListener(_project_failure_listener).addOnProgressListener(_project_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
															@Override
															public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
																return project.child(project_name).getDownloadUrl();
															}}).addOnCompleteListener(_project_upload_success_listener);
													}
													else {
														_Upload(dwnd_url);
													}
												}
												else {
													SketchwareUtil.showMessage(getApplicationContext(), "Please Select Project");
													textview26.setVisibility(View.VISIBLE);
													terms_main.setVisibility(View.GONE);
													upload_main.setVisibility(View.VISIBLE);
												}
											}
											else {
												final AlertDialog error_dialog = new AlertDialog.Builder(UploadActivity.this).create();
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
								
							}
							else {
								
								if (sk_project) {
									if (projectset) {
										if (ic_path.equals("")) {
											SketchwareUtil.showMessage(getApplicationContext(), "Please Select Icon");
											textview26.setVisibility(View.VISIBLE);
											terms_main.setVisibility(View.GONE);
											upload_main.setVisibility(View.VISIBLE);
										}
										else {
											textview26.setVisibility(View.GONE);
											terms_main.setVisibility(View.GONE);
											upload_main.setVisibility(View.VISIBLE);
											_ProgresbarShow("Uploading Project Details...");
											shot1s.child(shot1_name).putFile(Uri.fromFile(new File(shot1_path))).addOnFailureListener(_shot1s_failure_listener).addOnProgressListener(_shot1s_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
												@Override
												public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
													return shot1s.child(shot1_name).getDownloadUrl();
												}}).addOnCompleteListener(_shot1s_upload_success_listener);
											shot2s.child(shot2_name).putFile(Uri.fromFile(new File(shot2_path))).addOnFailureListener(_shot2s_failure_listener).addOnProgressListener(_shot2s_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
												@Override
												public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
													return shot2s.child(shot2_name).getDownloadUrl();
												}}).addOnCompleteListener(_shot2s_upload_success_listener);
											icon.child(ic_name).putFile(Uri.fromFile(new File(ic_path))).addOnFailureListener(_icon_failure_listener).addOnProgressListener(_icon_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
												@Override
												public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
													return icon.child(ic_name).getDownloadUrl();
												}}).addOnCompleteListener(_icon_upload_success_listener);
											project.child(name).putFile(Uri.fromFile(new File(sketifyDataDirectory.concat(".exported/exported.sk")))).addOnFailureListener(_project_failure_listener).addOnProgressListener(_project_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
												@Override
												public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
													return project.child(name).getDownloadUrl();
												}}).addOnCompleteListener(_project_upload_success_listener);
										}
									}
									else {
										SketchwareUtil.showMessage(getApplicationContext(), "Please Select Project");
										textview26.setVisibility(View.VISIBLE);
										terms_main.setVisibility(View.GONE);
										upload_main.setVisibility(View.VISIBLE);
									}
								}
								else {
									if (sk_apk) {
										if (apk_set) {
											if (ic_path.equals("")) {
												SketchwareUtil.showMessage(getApplicationContext(), "Please Select Icon");
												textview26.setVisibility(View.VISIBLE);
												terms_main.setVisibility(View.GONE);
												upload_main.setVisibility(View.VISIBLE);
											}
											else {
												textview26.setVisibility(View.GONE);
												terms_main.setVisibility(View.GONE);
												upload_main.setVisibility(View.VISIBLE);
												_ProgresbarShow("Uploading Project Details...");
												shot1s.child(shot1_name).putFile(Uri.fromFile(new File(shot1_path))).addOnFailureListener(_shot1s_failure_listener).addOnProgressListener(_shot1s_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
													@Override
													public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
														return shot1s.child(shot1_name).getDownloadUrl();
													}}).addOnCompleteListener(_shot1s_upload_success_listener);
												shot2s.child(shot2_name).putFile(Uri.fromFile(new File(shot2_path))).addOnFailureListener(_shot2s_failure_listener).addOnProgressListener(_shot2s_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
													@Override
													public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
														return shot2s.child(shot2_name).getDownloadUrl();
													}}).addOnCompleteListener(_shot2s_upload_success_listener);
												icon.child(ic_name).putFile(Uri.fromFile(new File(ic_path))).addOnFailureListener(_icon_failure_listener).addOnProgressListener(_icon_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
													@Override
													public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
														return icon.child(ic_name).getDownloadUrl();
													}}).addOnCompleteListener(_icon_upload_success_listener);
												project.child(apk_name).putFile(Uri.fromFile(new File(apk_path))).addOnFailureListener(_project_failure_listener).addOnProgressListener(_project_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
													@Override
													public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
														return project.child(apk_name).getDownloadUrl();
													}}).addOnCompleteListener(_project_upload_success_listener);
											}
										}
										else {
											SketchwareUtil.showMessage(getApplicationContext(), "Please Select Apk");
											textview26.setVisibility(View.VISIBLE);
											terms_main.setVisibility(View.GONE);
											upload_main.setVisibility(View.VISIBLE);
										}
									}
									else {
										if (androidstudioapk) {
											if (apk_set) {
												if (ic_path.equals("")) {
													SketchwareUtil.showMessage(getApplicationContext(), "Please Select Icon");
													textview26.setVisibility(View.VISIBLE);
													terms_main.setVisibility(View.GONE);
													upload_main.setVisibility(View.VISIBLE);
												}
												else {
													textview26.setVisibility(View.GONE);
													terms_main.setVisibility(View.GONE);
													upload_main.setVisibility(View.VISIBLE);
													_ProgresbarShow("Uploading Project Details...");
													shot1s.child(shot1_name).putFile(Uri.fromFile(new File(shot1_path))).addOnFailureListener(_shot1s_failure_listener).addOnProgressListener(_shot1s_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
														@Override
														public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
															return shot1s.child(shot1_name).getDownloadUrl();
														}}).addOnCompleteListener(_shot1s_upload_success_listener);
													shot2s.child(shot2_name).putFile(Uri.fromFile(new File(shot2_path))).addOnFailureListener(_shot2s_failure_listener).addOnProgressListener(_shot2s_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
														@Override
														public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
															return shot2s.child(shot2_name).getDownloadUrl();
														}}).addOnCompleteListener(_shot2s_upload_success_listener);
													icon.child(ic_name).putFile(Uri.fromFile(new File(ic_path))).addOnFailureListener(_icon_failure_listener).addOnProgressListener(_icon_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
														@Override
														public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
															return icon.child(ic_name).getDownloadUrl();
														}}).addOnCompleteListener(_icon_upload_success_listener);
													project.child(apk_name).putFile(Uri.fromFile(new File(apk_path))).addOnFailureListener(_project_failure_listener).addOnProgressListener(_project_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
														@Override
														public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
															return project.child(apk_name).getDownloadUrl();
														}}).addOnCompleteListener(_project_upload_success_listener);
												}
											}
											else {
												SketchwareUtil.showMessage(getApplicationContext(), "Please Select Apk");
												textview26.setVisibility(View.VISIBLE);
												terms_main.setVisibility(View.GONE);
												upload_main.setVisibility(View.VISIBLE);
											}
										}
										else {
											if (android_studii) {
												if (projectset) {
													if (ic_path.equals("")) {
														SketchwareUtil.showMessage(getApplicationContext(), "Please Select Icon");
														textview26.setVisibility(View.VISIBLE);
														terms_main.setVisibility(View.GONE);
														upload_main.setVisibility(View.VISIBLE);
													}
													else {
														textview26.setVisibility(View.GONE);
														terms_main.setVisibility(View.GONE);
														upload_main.setVisibility(View.VISIBLE);
														_ProgresbarShow("Uploading Project Details...");
														shot1s.child(shot1_name).putFile(Uri.fromFile(new File(shot1_path))).addOnFailureListener(_shot1s_failure_listener).addOnProgressListener(_shot1s_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
															@Override
															public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
																return shot1s.child(shot1_name).getDownloadUrl();
															}}).addOnCompleteListener(_shot1s_upload_success_listener);
														shot2s.child(shot2_name).putFile(Uri.fromFile(new File(shot2_path))).addOnFailureListener(_shot2s_failure_listener).addOnProgressListener(_shot2s_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
															@Override
															public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
																return shot2s.child(shot2_name).getDownloadUrl();
															}}).addOnCompleteListener(_shot2s_upload_success_listener);
														icon.child(ic_name).putFile(Uri.fromFile(new File(ic_path))).addOnFailureListener(_icon_failure_listener).addOnProgressListener(_icon_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
															@Override
															public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
																return icon.child(ic_name).getDownloadUrl();
															}}).addOnCompleteListener(_icon_upload_success_listener);
														project.child(project_name).putFile(Uri.fromFile(new File(project_patg))).addOnFailureListener(_project_failure_listener).addOnProgressListener(_project_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
															@Override
															public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
																return project.child(project_name).getDownloadUrl();
															}}).addOnCompleteListener(_project_upload_success_listener);
													}
												}
												else {
													SketchwareUtil.showMessage(getApplicationContext(), "Please Select Project");
													textview26.setVisibility(View.VISIBLE);
													terms_main.setVisibility(View.GONE);
													upload_main.setVisibility(View.VISIBLE);
												}
											}
											else {
												final AlertDialog error_dialog = new AlertDialog.Builder(UploadActivity.this).create();
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
							}
						}
						
						
						
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(internet, (int)(999), (int)(1000));
	}
	
	
	public void _Upload(final String _downloadUrl) {
		if (edit) {
			if (FileUtil.isExistFile(sketifyDataDirectory.concat(".exported/exported.zip"))) {
				FileUtil.deleteFile(sketifyDataDirectory.concat(".exported/exported.zip"));
			}
			next = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							if (shot1upd && (shot2upd && iconupd)) {
								next.cancel();
								data_map = new HashMap<>();
								if (!icon_url.equals("")) {
									data_map.put("icon", icon_url);
								}
								data_map.put("title", name);
								data_map.put("description", description_);
								if (sk_project || android_studii) {
									data_map.put("project", _downloadUrl);
									if (!project_size.equals("")) {
										data_map.put("size", project_size);
									}
								}
								else {
									if (sk_apk || androidstudioapk) {
										data_map.put("apk", _downloadUrl);
										if (!apk_size.equals("")) {
											data_map.put("size", apk_size);
										}
									}
								}
								data_map.put("category", textview_category.getText().toString());
								if (sk_project) {
									data_map.put("project category", "Sketchware Project");
									data_map.put("open", "true");
								}
								else {
									if (sk_apk) {
										data_map.put("project category", "Sketchware Apk");
										data_map.put("open", "false");
									}
									else {
										if (androidstudioapk) {
											data_map.put("project category", "Android Studio Apk");
											data_map.put("open", "false");
										}
										else {
											if (android_studii) {
												data_map.put("project category", "Android Studio");
												data_map.put("open", "true");
											}
										}
									}
								}
								data_map.put("whatsnew", whatsnew);
								if (dem_Link) {
									data_map.put("demo", demoLink);
								}
								else {
									data_map.put("demo", "");
								}
								data_map.put("yt_url", yt_url);
								data_map.put("shot1", shot1_url);
								data_map.put("shot2", shot2_url);
								data_map.put("comments_visibility", comments);
								data_map.put("visibility", visibility);
								data_map.put("verification", "false");
								if (new SimpleDateFormat("dd").format(c.getTime()).startsWith("0")) {
									data_map.put("time", "Last Updated In, ".concat(new SimpleDateFormat("dd").format(c.getTime()).replace("0", "").concat(", ".concat(new SimpleDateFormat("MMM").format(c.getTime()).concat(" - ".concat(" ".concat(new SimpleDateFormat("yyyy").format(c.getTime()))))))));
								}
								else {
									data_map.put("time", "Last Updated In,".concat(new SimpleDateFormat("dd").format(c.getTime()).concat(", ".concat(new SimpleDateFormat("MMM").format(c.getTime()).concat(" - ".concat(" ".concat(new SimpleDateFormat("yyyy").format(c.getTime()))))))));
								}
								data1.child(project_key).updateChildren(data_map);
								data_map.clear();
								_ProgresbarDimiss();
								final AlertDialog success = new AlertDialog.Builder(UploadActivity.this).create();
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
								s_ok.setOnClickListener(new View.OnClickListener(){
									    public void onClick(View v){
										success.dismiss();
										finish();
										up_icon = "";
										up_edit = "";
										iconset = "";
										project_key = "";
										shot1_path = "";
										shot1_name = "";
										shot2_path = "";
										shot2_name = "";
										shot1_url = "";
										shot2_url = "";
										apk_path = "";
										apk_name = "";
										project_patg = "";
										project_name = "";
										demoLink = "";
										yt_url = "";
										whatsnew = "";
										ic_path = "";
										ic_name = "";
									}});
								s_cancel.setOnClickListener(new View.OnClickListener(){
									    public void onClick(View v){
										success.dismiss();
									}});
								success.show();
								_bounce(s_header);
								/*
if (htmlProgram.equals("")) {

}
else {
one = htmlProgram.replace("%%title%%", name);
one = one.replace("%%ic_link%%", icon_url);
FileUtil.writeFile("/storage/emulated/0/Android/data/com.sketify.msk/".concat(project_key.concat(".html")), one);
returnMessage = "";
_UploadFile("/storage/emulated/0/Android/data/com.sketify.msk/".concat(project_key.concat(".html")));
}
*/
							}
						}
					});
				}
			};
			_timer.scheduleAtFixedRate(next, (int)(250), (int)(250));
		}
		else {
			project_key = String.valueOf((long)(fullProject + 1));
			if (FileUtil.isExistFile(sketifyDataDirectory.concat(".exported/exported.sk"))) {
				FileUtil.deleteFile(sketifyDataDirectory.concat(".exported/exported.sk"));
			}
			next = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							if (shot1upd && (shot2upd && iconupd)) {
								next.cancel();
								data_map = new HashMap<>();
								if (!icon_url.equals("")) {
									data_map.put("icon", icon_url);
								}
								data_map.put("title", name);
								data_map.put("description", description_);
								if (sk_project || android_studii) {
									data_map.put("project", _downloadUrl);
									data_map.put("size", project_size);
								}
								else {
									if (sk_apk || androidstudioapk) {
										data_map.put("apk", _downloadUrl);
										data_map.put("size", apk_size);
									}
								}
								data_map.put("category", textview_category.getText().toString());
								if (sk_project) {
									data_map.put("project category", "Sketchware Project");
									data_map.put("open", "true");
								}
								else {
									if (sk_apk) {
										data_map.put("project category", "Sketchware Apk");
										data_map.put("open", "false");
									}
									else {
										if (androidstudioapk) {
											data_map.put("project category", "Android Studio Apk");
											data_map.put("open", "false");
										}
										else {
											if (android_studii) {
												data_map.put("project category", "Android Studio");
												data_map.put("open", "true");
											}
										}
									}
								}
								data_map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
								data_map.put("name", usr_name);
								data_map.put("key", project_key);
								data_map.put("whatsnew", whatsnew);
								if (dem_Link) {
									data_map.put("demo", demoLink);
								}
								else {
									data_map.put("demo", "");
								}
								data_map.put("yt_url", yt_url);
								data_map.put("shot1", shot1_url);
								data_map.put("shot2", shot2_url);
								data_map.put("comments_visibility", comments);
								data_map.put("visibility", visibility);
								if (new SimpleDateFormat("dd").format(c.getTime()).startsWith("0")) {
									data_map.put("time", "Uploaded In, ".concat(new SimpleDateFormat("dd").format(c.getTime()).replace("0", "").concat(", ".concat(new SimpleDateFormat("MMM").format(c.getTime()).concat(" - ".concat(" ".concat(new SimpleDateFormat("yyyy").format(c.getTime()))))))));
								}
								else {
									data_map.put("time", "Uploaded In,".concat(new SimpleDateFormat("dd").format(c.getTime()).concat(", ".concat(new SimpleDateFormat("MMM").format(c.getTime()).concat(" - ".concat(" ".concat(new SimpleDateFormat("yyyy").format(c.getTime()))))))));
								}
								data_map.put("likes", "0");
								data_map.put("comments", "0");
								data_map.put("downloads", "0");
								data_map.put("verification", "false");
								data_map.put("editor", "false");
								data1.child(project_key).updateChildren(data_map);
								data_map.clear();
								user_projects++;
								user_Pr = new HashMap<>();
								user_Pr.put("projects", String.valueOf((long)(user_projects)));
								users.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(user_Pr);
								user_Pr.clear();
								_ProgresbarDimiss();
								final AlertDialog success = new AlertDialog.Builder(UploadActivity.this).create();
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
								s_ok.setOnClickListener(new View.OnClickListener(){
									    public void onClick(View v){
										success.dismiss();
										finish();
										up_icon = "";
										up_edit = "";
										iconset = "";
										project_key = "";
										shot1_path = "";
										shot1_name = "";
										shot2_path = "";
										shot2_name = "";
										shot1_url = "";
										shot2_url = "";
										apk_path = "";
										apk_name = "";
										project_patg = "";
										project_name = "";
										demoLink = "";
										yt_url = "";
										whatsnew = "";
										ic_path = "";
										ic_name = "";
									}});
								s_cancel.setOnClickListener(new View.OnClickListener(){
									    public void onClick(View v){
										success.dismiss();
									}});
								success.show();
								_bounce(s_header);
								/*
if (htmlProgram.equals("")) {

}
else {
one = htmlProgram.replace("%%title%%", name);
one = one.replace("%%ic_link%%", icon_url);
one = one.replace("%%pub_by%%", usr_name);
FileUtil.writeFile("/storage/emulated/0/Android/data/com.sketify.msk/".concat(project_key.concat(".html")), one);
returnMessage = "";
_UploadFile("/storage/emulated/0/Android/data/com.sketify.msk/".concat(project_key.concat(".html")));
}
*/
							}
						}
					});
				}
			};
			_timer.scheduleAtFixedRate(next, (int)(250), (int)(250));
		}
	}
	
	
	public void _SnackBar(final boolean _isLong, final boolean _isShort, final boolean _isIndefinite, final String _text) {
		// linear1 is your main or base of the UI
		if (_isLong) {
			com.google.android.material.snackbar.Snackbar.make(linear_main_projects, _text, com.google.android.material.snackbar.Snackbar.LENGTH_LONG).show();
		}
		else {
			if (_isShort) {
				com.google.android.material.snackbar.Snackbar.make(linear_main_projects, _text, com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).show();
			}
			else {
				if (_isIndefinite) {
					com.google.android.material.snackbar.Snackbar.make(linear_main_projects, _text, com.google.android.material.snackbar.Snackbar.LENGTH_INDEFINITE).show();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), _text);
				}
			}
		}
	}
	
	
	public void _Edit() {
		project_key = getIntent().getStringExtra("key");
	}
	
	
	public void _OpenOrea(final String _dura) {
		if (_dura.contains("ska")) {
			file_name.setText(_dura.replace("ska", ""));
			readed_text.setVisibility(View.VISIBLE);
			demo_apk.setVisibility(View.VISIBLE);
			imageview4.setImageResource(R.drawable.ic_close_grey);
		}
		if (_dura.contains("asa")) {
			file_name.setText(_dura.replace("asa", ""));
			readed_text.setVisibility(View.VISIBLE);
			demo_apk.setVisibility(View.VISIBLE);
			imageview4.setImageResource(R.drawable.ic_close_grey);
		}
		if (_dura.equals("skp")) {
			file_name.setText("exported.sk");
			readed_text.setVisibility(View.VISIBLE);
			demo_apk.setVisibility(View.VISIBLE);
			imageview4.setImageResource(R.drawable.ic_close_grey);
		}
		if (_dura.equals("asp")) {
			file_name.setText("exported.zip");
			readed_text.setVisibility(View.VISIBLE);
			demo_apk.setVisibility(View.VISIBLE);
			imageview4.setImageResource(R.drawable.ic_close_grey);
		}
	}
	
	
	public void _CalculateSize(final double _fileSize) {
		B = 1024;
		KB = B * B;
		MB = B * (B * B);
		GB = B * (B * (B * B));
		TB = B * (B * (B * (B * B)));
		PB = B * (B * (B * (B * (B * B))));
		if (_fileSize < B) {
			if (sk_apk || androidstudioapk) {
				apk_size = String.valueOf((long)(_fileSize)).concat(" B");
			}
			else {
				if (sk_project || android_studii) {
					project_size = String.valueOf((long)(_fileSize)).concat(" B");
				}
			}
		}
		else {
			if (_fileSize < KB) {
				if (sk_apk || androidstudioapk) {
					apk_size = new DecimalFormat("0.00").format(_fileSize / B).concat(" KB");
				}
				else {
					if (sk_project || android_studii) {
						project_size = new DecimalFormat("0.00").format(_fileSize / B).concat(" KB");
					}
				}
			}
			else {
				if (_fileSize < MB) {
					if (sk_apk || androidstudioapk) {
						apk_size = new DecimalFormat("0.00").format(_fileSize / KB).concat(" MB");
					}
					else {
						if (sk_project || android_studii) {
							project_size = new DecimalFormat("0.00").format(_fileSize / KB).concat(" MB");
						}
					}
				}
				else {
					if (_fileSize < GB) {
						if (sk_apk || androidstudioapk) {
							apk_size = new DecimalFormat("0.00").format(_fileSize / MB).concat(" GB");
						}
						else {
							if (sk_project || android_studii) {
								project_size = new DecimalFormat("0.00").format(_fileSize / MB).concat(" GB");
							}
						}
					}
					else {
						if (_fileSize < TB) {
							if (sk_apk || androidstudioapk) {
								apk_size = new DecimalFormat("0.00").format(_fileSize / GB).concat(" TB");
							}
							else {
								if (sk_project || android_studii) {
									project_size = new DecimalFormat("0.00").format(_fileSize / GB).concat(" TB");
								}
							}
						}
						else {
							if (_fileSize < PB) {
								if (sk_apk || androidstudioapk) {
									apk_size = new DecimalFormat("0.00").format(_fileSize / TB).concat(" PB");
								}
								else {
									if (sk_project || android_studii) {
										project_size = new DecimalFormat("0.00").format(_fileSize / TB).concat(" PB");
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	
	public void _RenameFileDirectory(final String _directory, final String _file1, final String _file2) {
		java.io.File directory = new java.io.File(path.substring(0, path.lastIndexOf("/"))); java.io.File oldfile = new java.io.File(_directory); java.io.File newfile = new java.io.File(directory, _file2); oldfile.renameTo(newfile);
	}
	
	
	public void _GetFileSize(final String _path) {
		java.io.File file = new java.io.File(_path);
		file_size = String.valueOf(file.length());
		B = 1024;
		KB = B * B;
		MB = B * (B * B);
		GB = B * (B * (B * B));
		TB = B * (B * (B * (B * B)));
		PB = B * (B * (B * (B * (B * B))));
		if (Double.parseDouble(file_size) < B) {
			returnedSize = String.valueOf((long)(Double.parseDouble(file_size))).concat(" B");
		}
		else {
			if (Double.parseDouble(file_size) < KB) {
				returnedSize = new DecimalFormat("0.00").format(Double.parseDouble(file_size) / B).concat(" KB");
			}
			else {
				if (Double.parseDouble(file_size) < MB) {
					returnedSize = new DecimalFormat("0.00").format(Double.parseDouble(file_size) / KB).concat(" MB");
				}
				else {
					if (Double.parseDouble(file_size) < GB) {
						returnedSize = new DecimalFormat("0.00").format(Double.parseDouble(file_size) / MB).concat(" GB");
					}
					else {
						if (Double.parseDouble(file_size) < TB) {
							returnedSize = new DecimalFormat("0.00").format(Double.parseDouble(file_size) / GB).concat(" TB");
						}
						else {
							if (Double.parseDouble(file_size) < PB) {
								returnedSize = new DecimalFormat("0.00").format(Double.parseDouble(file_size) / TB).concat(" PB");
							}
						}
					}
				}
			}
		}
	}
	
	
	public void _UploadFile(final String _path) {
		try{
			uploadFile(_path);
		} catch(java.io.IOException e){
		}
		uploade = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (!returnMessage.equals("")) {
							uploade.cancel();
							if (returnMessage.contains("Uploaded Project!")) {
								if (returnMessage.contains("http://projects.sketify.tk/project_files/")) {
									timer = new TimerTask() {
										@Override
										public void run() {
											runOnUiThread(new Runnable() {
												@Override
												public void run() {
													downloadUrl = returnMessage.substring((int)(returnMessage.indexOf("http://projects.sketify.tk/project_files/")), (int)(returnMessage.length()));
													returnMessage = returnMessage.replace(downloadUrl, "");
													_ProgresbarDimiss();
													final AlertDialog success = new AlertDialog.Builder(UploadActivity.this).create();
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
													s_ok.setOnClickListener(new View.OnClickListener(){
														    public void onClick(View v){
															success.dismiss();
															finish();
															up_icon = "";
															up_edit = "";
															iconset = "";
															project_key = "";
															shot1_path = "";
															shot1_name = "";
															shot2_path = "";
															shot2_name = "";
															shot1_url = "";
															shot2_url = "";
															apk_path = "";
															apk_name = "";
															project_patg = "";
															project_name = "";
															demoLink = "";
															yt_url = "";
															whatsnew = "";
															ic_path = "";
															ic_name = "";
															FileUtil.deleteFile("/storage/emulated/0/Android/data/com.sketify.msk/".concat(project_key.concat(".html")));
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
									_timer.schedule(timer, (int)(1000));
								}
								else {
									SketchwareUtil.showMessage(getApplicationContext(), "Sharing Interrupted!");
								}
							}
							else {
								if (returnMessage.contains("Database Connection Failed!")) {
									SketchwareUtil.showMessage(getApplicationContext(), "Connection Failed!!");
									_ProgresbarDimiss();
									finish();
								}
								if (returnMessage.contains("Error Uploading")) {
									SketchwareUtil.showMessage(getApplicationContext(), returnMessage);
									_ProgresbarDimiss();
									finish();
								}
								if (returnMessage.contains("Error:")) {
									SketchwareUtil.showMessage(getApplicationContext(), returnMessage);
									_ProgresbarDimiss();
									finish();
								}
							}
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(uploade, (int)(500), (int)(250));
	}
	
	
	public void _SetFileUploader() {
		
	}
	
	
	
	public String uploadFile (String imagePath) throws java.io.IOException {
		
		
		uploadUrl = "https://sketifyapp.000webhostapp.com/".concat("upload.php");
		String  response = "";
		
		
		
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		    java.io.BufferedReader br = null;
		    String fileName = imagePath;
		    java.net.HttpURLConnection conn = null;
		    java.io.DataOutputStream dos = null;  
		    String lineEnd = "\n";
		    String twoHyphens = "--";
		    String boundary = "*****";
		    int bytesRead, bytesAvailable, bufferSize;
		    byte[] buffer;
		    int maxBufferSize = 1 * 1024 * 1024;
		
		    
		
		java.io.File sourceFile = new java.io.File(imagePath);
		    if (!sourceFile.isFile()) {
			
			
			    
			
			showMessage("Can't Get Source - " + imagePath);
			
			returnMessage = "Source Unavailable - " + imagePath ;
			
			
			
			    } else {
			    try { 
				        
				
				java.io.FileInputStream fileInputStream = new java.io.FileInputStream(sourceFile);
				
				          //This is The Url To Your Php File in Website
				
				 java.net.URL url = new java.net.URL(uploadUrl);
				
				conn = (java.net.HttpURLConnection) url.openConnection(); 
				        conn.setDoInput(true); 
				        conn.setDoOutput(true); 
				        conn.setUseCaches(false); 
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Connection", "Keep-Alive");
				conn.setRequestProperty("ENCTYPE", "multipart/form-data");
				conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
				conn.setRequestProperty("uploadedfile", fileName); 
				        dos = new java.io.DataOutputStream(conn.getOutputStream());
				        dos.writeBytes(twoHyphens + boundary + lineEnd); 
				
				//Here uploadedfile is the key which will contain the filename and file so it should be same in .php file also
				
				dos.writeBytes("Content-Disposition: form-data; name=\"uploadedfile\";filename=\"" + fileName + "\"" + lineEnd);
				        dos.writeBytes(lineEnd);
				        bytesAvailable = fileInputStream.available(); 
				        bufferSize = Math.min(bytesAvailable, maxBufferSize);
				        buffer = new byte[bufferSize];
				        bytesRead = fileInputStream.read(buffer, 0, bufferSize);  
				
				while (bytesRead > 0) {
					            dos.write(buffer, 0, bufferSize);
					            bytesAvailable = fileInputStream.available();
					            bufferSize = Math.min(bytesAvailable, maxBufferSize);
					            bytesRead = fileInputStream.read(buffer, 0, bufferSize);   
					        }
				        dos.writeBytes(lineEnd);
				        dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
				        int serverResponseCode = conn.getResponseCode();
				        String serverResponseMessage = conn.getResponseMessage();
				
				       
				
				returnMessage = "Http Response Code : "+ serverResponseMessage + " - " + serverResponseCode ;
				
				if (200 <= conn.getResponseCode() && conn.getResponseCode() <= 299) {
					
					            // File Uploaded Successfully!
					
					       br = new
					
					java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream()));
					
					            java.io.InputStream responseStream = new java.io.BufferedInputStream(conn.getInputStream());
					
					            java.io.BufferedReader responseStreamReader = new java.io.BufferedReader(new java.io.InputStreamReader(responseStream));
					
					            String line = "";
					
					            java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();
					
					            while ((line = responseStreamReader.readLine()) != null) {
						                stringBuilder.append(line).append("\n");
						
						            }
					            
					           
					
					responseStreamReader.close();
					response = stringBuilder.toString();
					
					
					returnMessage = Html.fromHtml(response).toString();
					
					
					
					
					        } else {
					            
					
					br = new
					
					 java.io.BufferedReader(new java.io.InputStreamReader(conn.getErrorStream()));
					
					        }
				
				        fileInputStream.close();
				        dos.flush();
				        dos.close();
				
				    } catch (java.net.MalformedURLException ex) {
				
				        ex.printStackTrace();
				        
				    } catch (Exception e) 
			
			        
			
			    
			   
			
			
			    
			{
				e.printStackTrace();
			}
		}
		
		    return response;
		
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