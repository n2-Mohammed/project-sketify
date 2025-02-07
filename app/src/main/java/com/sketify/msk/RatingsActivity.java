package com.sketify.msk;

import android.animation.*;
import android.animation.ObjectAnimator;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
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

public class RatingsActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private boolean star1Clicked = false;
	private boolean star2Clicked = false;
	private boolean star3Clicked = false;
	private boolean star4Clicked = false;
	private boolean star5Clicked = false;
	private HashMap<String, Object> map = new HashMap<>();
	private String key = "";
	private double num = 0;
	private HashMap<String, Object> usernames = new HashMap<>();
	private HashMap<String, Object> profiles = new HashMap<>();
	private boolean No_1 = false;
	private boolean No_2 = false;
	private boolean ratingsIsOpened = false;
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<String> admins = new ArrayList<>();
	
	private LinearLayout rateus;
	private LinearLayout ratings;
	private TextView textview1;
	private LinearLayout stars;
	private LinearLayout content;
	private LinearLayout buttons;
	private LinearLayout view_reviews;
	private ImageView imageview1;
	private ImageView imageview2;
	private ImageView imageview3;
	private ImageView imageview4;
	private ImageView imageview5;
	private EditText feedback;
	private Button button4;
	private TextView all_revies_txt;
	private LinearLayout progress;
	private LinearLayout ratings_main;
	private ProgressBar progressbar1;
	private ListView listview1;
	
	private DatabaseReference reviews = _firebase.getReference("reviews");
	private ChildEventListener _reviews_child_listener;
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
	
	private DatabaseReference users = _firebase.getReference("users");
	private ChildEventListener _users_child_listener;
	private RequestNetwork net;
	private RequestNetwork.RequestListener _net_request_listener;
	private TimerTask timer;
	private AlertDialog.Builder delete;
	private ObjectAnimator oa_d = new ObjectAnimator();
	private Calendar c = Calendar.getInstance();
	private Intent VProf = new Intent();
	private Vibrator v;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.ratings);
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
		rateus = findViewById(R.id.rateus);
		ratings = findViewById(R.id.ratings);
		textview1 = findViewById(R.id.textview1);
		stars = findViewById(R.id.stars);
		content = findViewById(R.id.content);
		buttons = findViewById(R.id.buttons);
		view_reviews = findViewById(R.id.view_reviews);
		imageview1 = findViewById(R.id.imageview1);
		imageview2 = findViewById(R.id.imageview2);
		imageview3 = findViewById(R.id.imageview3);
		imageview4 = findViewById(R.id.imageview4);
		imageview5 = findViewById(R.id.imageview5);
		feedback = findViewById(R.id.feedback);
		button4 = findViewById(R.id.button4);
		all_revies_txt = findViewById(R.id.all_revies_txt);
		progress = findViewById(R.id.progress);
		ratings_main = findViewById(R.id.ratings_main);
		progressbar1 = findViewById(R.id.progressbar1);
		listview1 = findViewById(R.id.listview1);
		auth = FirebaseAuth.getInstance();
		net = new RequestNetwork(this);
		delete = new AlertDialog.Builder(this);
		v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		
		view_reviews.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				setTitle("Reviews");
				rateus.setVisibility(View.GONE);
				ratings.setVisibility(View.VISIBLE);
				progress.setVisibility(View.VISIBLE);
				ratings_main.setVisibility(View.GONE);
				ratingsIsOpened = true;
				net.startRequestNetwork(RequestNetworkController.GET, "https://sketify.tk", "a", _net_request_listener);
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview1.setImageResource(R.drawable.ic_favorite_grey);
				imageview2.setImageResource(R.drawable.ic_favorite_outline_black);
				imageview3.setImageResource(R.drawable.ic_favorite_outline_black);
				imageview4.setImageResource(R.drawable.ic_favorite_outline_black);
				imageview5.setImageResource(R.drawable.ic_favorite_outline_black);
				star1Clicked = true;
				star2Clicked = false;
				star3Clicked = false;
				star4Clicked = false;
				star5Clicked = false;
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview1.setImageResource(R.drawable.ic_favorite_grey);
				imageview2.setImageResource(R.drawable.ic_favorite_grey);
				imageview3.setImageResource(R.drawable.ic_favorite_outline_black);
				imageview4.setImageResource(R.drawable.ic_favorite_outline_black);
				imageview5.setImageResource(R.drawable.ic_favorite_outline_black);
				star1Clicked = true;
				star2Clicked = true;
				star3Clicked = false;
				star4Clicked = false;
				star5Clicked = false;
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview1.setImageResource(R.drawable.ic_favorite_grey);
				imageview2.setImageResource(R.drawable.ic_favorite_grey);
				imageview3.setImageResource(R.drawable.ic_favorite_grey);
				imageview4.setImageResource(R.drawable.ic_favorite_outline_black);
				imageview5.setImageResource(R.drawable.ic_favorite_outline_black);
				star1Clicked = true;
				star2Clicked = true;
				star3Clicked = true;
				star4Clicked = false;
				star5Clicked = false;
			}
		});
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview1.setImageResource(R.drawable.ic_favorite_grey);
				imageview2.setImageResource(R.drawable.ic_favorite_grey);
				imageview3.setImageResource(R.drawable.ic_favorite_grey);
				imageview4.setImageResource(R.drawable.ic_favorite_grey);
				imageview5.setImageResource(R.drawable.ic_favorite_outline_black);
				star1Clicked = true;
				star2Clicked = true;
				star3Clicked = true;
				star4Clicked = true;
				star5Clicked = false;
			}
		});
		
		imageview5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview1.setImageResource(R.drawable.ic_favorite_grey);
				imageview2.setImageResource(R.drawable.ic_favorite_grey);
				imageview3.setImageResource(R.drawable.ic_favorite_grey);
				imageview4.setImageResource(R.drawable.ic_favorite_grey);
				imageview5.setImageResource(R.drawable.ic_favorite_grey);
				star1Clicked = true;
				star2Clicked = true;
				star3Clicked = true;
				star4Clicked = true;
				star5Clicked = true;
			}
		});
		
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_custom_loading(true);
				if (!feedback.getText().toString().equals("")) {
					key = reviews.push().getKey();
					c = Calendar.getInstance();
					map = new HashMap<>();
					if (star5Clicked) {
						map.put("stars", "5");
					}
					else {
						if (star4Clicked) {
							map.put("stars", "4");
						}
						else {
							if (star3Clicked) {
								map.put("stars", "3");
							}
							else {
								if (star2Clicked) {
									map.put("stars", "2");
								}
								else {
									map.put("stars", "1");
								}
							}
						}
					}
					map.put("time", new SimpleDateFormat(" dd/MM/yyyy").format(c.getTime()));
					map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
					map.put("key", key);
					map.put("review", feedback.getText().toString());
					reviews.child(key).updateChildren(map);
					map.clear();
					timer = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									v.vibrate((long)(250));
									_SnackBar(true, false, false, "Thanks For Your Feedback!");
									_custom_loading(false);
								}
							});
						}
					};
					_timer.schedule(timer, (int)(999));
				}
				else {
					_SnackBar(true, false, false, "Please Enter Review First...");
					_custom_loading(false);
				}
			}
		});
		
		listview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (FirebaseAuth.getInstance().getCurrentUser().getEmail().equals("mskshafi99@gmail.com")) {
					delete.setTitle("Delete (Admin)");
					delete.setMessage("Are You Sure you want To Delete Your Your review??");
					delete.setPositiveButton("YES", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							rateus.setVisibility(View.GONE);
							ratings.setVisibility(View.VISIBLE);
							progress.setVisibility(View.VISIBLE);
							ratings_main.setVisibility(View.GONE);
							setTitle("Ratings");
							reviews.child(listmap.get((int)_position).get("key").toString()).removeValue();
							net.startRequestNetwork(RequestNetworkController.GET, "https://sketify.tk", "b", _net_request_listener);
							ratingsIsOpened = true;
						}
					});
					delete.setNegativeButton("NO", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					delete.create().show();
				}
				else {
					if (admins.contains(FirebaseAuth.getInstance().getCurrentUser().getEmail())) {
						delete.setTitle("Delete (Admin)");
						delete.setMessage("Are You Sure you want To Delete Your Your review??");
						delete.setPositiveButton("YES", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								rateus.setVisibility(View.GONE);
								ratings.setVisibility(View.VISIBLE);
								progress.setVisibility(View.VISIBLE);
								ratings_main.setVisibility(View.GONE);
								setTitle("Ratings");
								reviews.child(listmap.get((int)_position).get("key").toString()).removeValue();
								net.startRequestNetwork(RequestNetworkController.GET, "https://sketify.tk", "b", _net_request_listener);
								ratingsIsOpened = true;
							}
						});
						delete.setNegativeButton("NO", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								
							}
						});
						delete.create().show();
					}
					else {
						if (listmap.get((int)_position).get("uid").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
							delete.setTitle("Delete");
							delete.setMessage("Are You Sure you want To Delete Your Your review??");
							delete.setPositiveButton("YES", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									rateus.setVisibility(View.GONE);
									ratings.setVisibility(View.VISIBLE);
									progress.setVisibility(View.VISIBLE);
									ratings_main.setVisibility(View.GONE);
									setTitle("Ratings");
									reviews.child(listmap.get((int)_position).get("key").toString()).removeValue();
									net.startRequestNetwork(RequestNetworkController.GET, "https://sketify.tk", "b", _net_request_listener);
									ratingsIsOpened = true;
								}
							});
							delete.setNegativeButton("NO", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									
								}
							});
							delete.create().show();
						}
					}
				}
				return true;
			}
		});
		
		_reviews_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				No_1 = true;
				listmap.add((int)0, _childValue);
				listview1.setAdapter(new Listview1Adapter(listmap));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
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
				num = 0;
				for(int _repeat26 = 0; _repeat26 < (int)(listmap.size()); _repeat26++) {
					if (listmap.get((int)num).get("key").toString().equals(_childKey)) {
						listmap.remove((int)(num));
					}
					num++;
				}
				listview1.setAdapter(new Listview1Adapter(listmap));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		reviews.addChildEventListener(_reviews_child_listener);
		
		_users_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				No_2 = true;
				if (_childValue.containsKey("name")) {
					usernames.put(_childValue.get("uid").toString(), _childValue.get("name").toString());
				}
				if (_childValue.containsKey("profile")) {
					profiles.put(_childValue.get("uid").toString(), _childValue.get("profile").toString());
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("name")) {
					usernames.put(_childValue.get("uid").toString(), _childValue.get("name").toString());
				}
				if (_childValue.containsKey("profile")) {
					profiles.put(_childValue.get("uid").toString(), _childValue.get("profile").toString());
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
		
		_net_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				_Refresh();
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				rateus.setVisibility(View.GONE);
				ratings.setVisibility(View.VISIBLE);
				progress.setVisibility(View.VISIBLE);
				ratings_main.setVisibility(View.GONE);
				ratingsIsOpened = true;
				
				final AlertDialog error_dialog = new AlertDialog.Builder(RatingsActivity.this).create();
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
						net.startRequestNetwork(RequestNetworkController.GET, "https://sketify.tk", "c", _net_request_listener);
					}});
				e_cancel.setOnClickListener(new View.OnClickListener(){
					    public void onClick(View v){
						error_dialog.dismiss();
					}});
				error_dialog.show();
				_bounce(e_header);
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
		_rippleRoundStroke(view_reviews, "#FFFFFF", "#E0E0E0", 30, 0, "#FFFFFF");
		_rippleRoundStroke(button4, "#536DFE", "#FFFFFF", 20, 0, "#3F51B5");
		imageview1.performClick();
		listview1.setSelector(android.R.color.transparent);
		rateus.setVisibility(View.VISIBLE);
		ratings.setVisibility(View.GONE);
		ratingsIsOpened = false;
		setTitle("Rate Us");
	}
	
	@Override
	public void onBackPressed() {
		if (ratingsIsOpened) {
			rateus.setVisibility(View.VISIBLE);
			ratings.setVisibility(View.GONE);
			progress.setVisibility(View.VISIBLE);
			ratings_main.setVisibility(View.GONE);
			setTitle("Rate Us");
			ratingsIsOpened = false;
		}
		else {
			ratingsIsOpened = false;
			finish();
		}
	}
	public void _Refresh() {
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (No_1 && No_2) {
							timer.cancel();
							setTitle("Ratings");
							rateus.setVisibility(View.GONE);
							ratings.setVisibility(View.VISIBLE);
							ratings_main.setVisibility(View.VISIBLE);
							progress.setVisibility(View.GONE);
							ratingsIsOpened = true;
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(timer, (int)(250), (int)(650));
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
	
	
	public void _SnackBar(final boolean _isLong, final boolean _isShort, final boolean _isIndefinite, final String _text) {
		// linear1 is your main or base of the UI
		if (_isLong) {
			com.google.android.material.snackbar.Snackbar.make(rateus, _text, com.google.android.material.snackbar.Snackbar.LENGTH_LONG).show();
		}
		else {
			if (_isShort) {
				com.google.android.material.snackbar.Snackbar.make(rateus, _text, com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).show();
			}
			else {
				if (_isIndefinite) {
					com.google.android.material.snackbar.Snackbar.make(rateus, _text, com.google.android.material.snackbar.Snackbar.LENGTH_INDEFINITE).show();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), _text);
				}
			}
		}
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
				_view = _inflater.inflate(R.layout.review, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout top = _view.findViewById(R.id.top);
			final LinearLayout center = _view.findViewById(R.id.center);
			final LinearLayout bottom = _view.findViewById(R.id.bottom);
			final ImageView profile = _view.findViewById(R.id.profile);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final ImageView delete = _view.findViewById(R.id.delete);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final ImageView imageview2 = _view.findViewById(R.id.imageview2);
			final ImageView imageview3 = _view.findViewById(R.id.imageview3);
			final ImageView imageview4 = _view.findViewById(R.id.imageview4);
			final ImageView imageview5 = _view.findViewById(R.id.imageview5);
			final TextView time = _view.findViewById(R.id.time);
			final TextView msg = _view.findViewById(R.id.msg);
			
			_Elevation(linear1, 8);
			_rippleRoundStroke(linear1, "#FFFFFF", "#E0E0E0", 25, 0, "#FFFFFF");
			delete.setVisibility(View.GONE);
			if (_data.get((int)_position).containsKey("uid")) {
				if (usernames.containsKey(_data.get((int)_position).get("uid").toString())) {
					textview1.setText(usernames.get(_data.get((int)_position).get("uid").toString()).toString());
				}
				if (profiles.containsKey(_data.get((int)_position).get("uid").toString())) {
					if (profiles.get(_data.get((int)_position).get("uid").toString()).toString().equals("")) {
						profile.setImageResource(R.drawable.default_avatar);
					}
					else {
						if (profiles.get(_data.get((int)_position).get("uid").toString()).toString().equals("avator")) {
							profile.setImageResource(R.drawable.default_avatar);
						}
						else {
							_setCircleImageURL(profile, profiles.get(_data.get((int)_position).get("uid").toString()).toString(), 0, "#FFFFFF");
						}
					}
				}
			}
			if (_data.get((int)_position).containsKey("stars")) {
				if (_data.get((int)_position).get("stars").toString().equals("5")) {
					imageview1.setImageResource(R.drawable.ic_favorite_grey);
					imageview2.setImageResource(R.drawable.ic_favorite_grey);
					imageview3.setImageResource(R.drawable.ic_favorite_grey);
					imageview4.setImageResource(R.drawable.ic_favorite_grey);
					imageview5.setImageResource(R.drawable.ic_favorite_grey);
				}
				else {
					if (_data.get((int)_position).get("stars").toString().equals("4")) {
						imageview1.setImageResource(R.drawable.ic_favorite_grey);
						imageview2.setImageResource(R.drawable.ic_favorite_grey);
						imageview3.setImageResource(R.drawable.ic_favorite_grey);
						imageview4.setImageResource(R.drawable.ic_favorite_grey);
						imageview5.setImageResource(R.drawable.ic_favorite_outline_black);
					}
					else {
						if (_data.get((int)_position).get("stars").toString().equals("3")) {
							imageview1.setImageResource(R.drawable.ic_favorite_grey);
							imageview2.setImageResource(R.drawable.ic_favorite_grey);
							imageview3.setImageResource(R.drawable.ic_favorite_grey);
							imageview4.setImageResource(R.drawable.ic_favorite_outline_black);
							imageview5.setImageResource(R.drawable.ic_favorite_outline_black);
						}
						else {
							if (_data.get((int)_position).get("stars").toString().equals("2")) {
								imageview1.setImageResource(R.drawable.ic_favorite_grey);
								imageview2.setImageResource(R.drawable.ic_favorite_grey);
								imageview3.setImageResource(R.drawable.ic_favorite_outline_black);
								imageview4.setImageResource(R.drawable.ic_favorite_outline_black);
								imageview5.setImageResource(R.drawable.ic_favorite_outline_black);
							}
							else {
								if (_data.get((int)_position).get("stars").toString().equals("1")) {
									imageview1.setImageResource(R.drawable.ic_favorite_grey);
									imageview2.setImageResource(R.drawable.ic_favorite_outline_black);
									imageview3.setImageResource(R.drawable.ic_favorite_outline_black);
									imageview4.setImageResource(R.drawable.ic_favorite_outline_black);
									imageview5.setImageResource(R.drawable.ic_favorite_outline_black);
								}
							}
						}
					}
				}
			}
			if (_data.get((int)_position).containsKey("review")) {
				msg.setText(_data.get((int)_position).get("review").toString());
			}
			if (_data.get((int)_position).containsKey("time")) {
				time.setText(_data.get((int)_position).get("time").toString());
			}
			profile.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					VProf.setClass(getApplicationContext(), ProfileActivity.class);
					VProf.putExtra("uid", _data.get((int)_position).get("uid").toString());
					startActivity(VProf);
				}
			});
			textview1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					VProf.setClass(getApplicationContext(), ProfileActivity.class);
					VProf.putExtra("uid", _data.get((int)_position).get("uid").toString());
					startActivity(VProf);
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