package com.sketify.msk;

import android.animation.*;
import android.app.*;
import android.content.*;
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
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
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
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class LikedProjectsActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private String key = "";
	private String uid = "";
	private HashMap<String, Object> map = new HashMap<>();
	private double num = 0;
	private boolean project = false;
	
	private ArrayList<String> users = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<String> keys = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listprojects = new ArrayList<>();
	
	private LinearLayout users_listview;
	private LinearLayout projects_listview;
	private ListView listview1;
	private LinearLayout nothing;
	private ImageView imageview1;
	private TextView textview1;
	private ListView listview2;
	private LinearLayout nothing_;
	private ImageView imageview2;
	private TextView textview2;
	
	private DatabaseReference likes = _firebase.getReference("likes");
	private ChildEventListener _likes_child_listener;
	private DatabaseReference userss = _firebase.getReference("users");
	private ChildEventListener _userss_child_listener;
	private DatabaseReference data1 = _firebase.getReference("data1");
	private ChildEventListener _data1_child_listener;
	private Intent intent = new Intent();
	private Intent vprofile = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.liked_projects);
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
		users_listview = findViewById(R.id.users_listview);
		projects_listview = findViewById(R.id.projects_listview);
		listview1 = findViewById(R.id.listview1);
		nothing = findViewById(R.id.nothing);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		listview2 = findViewById(R.id.listview2);
		nothing_ = findViewById(R.id.nothing_);
		imageview2 = findViewById(R.id.imageview2);
		textview2 = findViewById(R.id.textview2);
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				vprofile.setClass(getApplicationContext(), ProfileActivity.class);
				vprofile.putExtra("uid", listmap.get((int)_position).get("uid").toString());
				startActivity(vprofile);
			}
		});
		
		listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				intent.setClass(getApplicationContext(), ProjectViewActivity.class);
				intent.putExtra("key", listprojects.get((int)_position).get("key").toString());
				intent.putExtra("uid", listprojects.get((int)_position).get("uid").toString());
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
		
		_likes_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (project) {
					if (_childValue.get("value").toString().equals("true")) {
						if (_childValue.get("key").toString().equals(key)) {
							if (!_childValue.get("uid").toString().equals("")) {
								users.add(_childValue.get("uid").toString());
							}
							if (users.size() == 0) {
								nothing.setVisibility(View.VISIBLE);
								listview1.setVisibility(View.GONE);
							}
							else {
								nothing.setVisibility(View.GONE);
								listview1.setVisibility(View.VISIBLE);
							}
						}
					}
					else {
						if (users.size() == 0) {
							nothing.setVisibility(View.VISIBLE);
							listview1.setVisibility(View.GONE);
						}
						else {
							nothing.setVisibility(View.GONE);
							listview1.setVisibility(View.VISIBLE);
						}
					}
				}
				else {
					if (_childValue.get("uid").toString().equals(uid)) {
						if (_childValue.get("value").toString().equals("true")) {
							if (!_childValue.get("key").toString().equals("")) {
								keys.add(_childValue.get("key").toString());
							}
							if (keys.size() == 0) {
								nothing_.setVisibility(View.VISIBLE);
								listview2.setVisibility(View.GONE);
							}
							else {
								nothing_.setVisibility(View.GONE);
								listview2.setVisibility(View.VISIBLE);
							}
						}
					}
					if (keys.size() == 0) {
						nothing_.setVisibility(View.VISIBLE);
						listview2.setVisibility(View.GONE);
					}
					else {
						nothing_.setVisibility(View.GONE);
						listview2.setVisibility(View.VISIBLE);
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (project) {
					if (_childValue.get("key").toString().equals(key)) {
						if (_childValue.get("value").toString().equals("true")) {
							num = 0;
							for(int _repeat11 = 0; _repeat11 < (int)(users.size()); _repeat11++) {
								if (users.get((int)(num)).equals(_childValue.get("uid").toString())) {
									users.remove((int)(num));
									users.add(_childValue.get("uid").toString());
								}
								num++;
							}
							if (users.size() == 0) {
								nothing.setVisibility(View.VISIBLE);
								listview1.setVisibility(View.GONE);
							}
							listview1.setAdapter(new Listview1Adapter(listmap));
						}
						if (_childValue.get("value").toString().equals("false")) {
							num = 0;
							for(int _repeat42 = 0; _repeat42 < (int)(users.size()); _repeat42++) {
								if (users.get((int)(num)).equals(_childValue.get("uid").toString())) {
									users.remove((int)(num));
								}
								num++;
							}
							if (users.size() == 0) {
								nothing.setVisibility(View.VISIBLE);
								listview1.setVisibility(View.GONE);
							}
							listview1.setAdapter(new Listview1Adapter(listmap));
						}
					}
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				}
				else {
					if (_childValue.get("uid").toString().equals(uid)) {
						if (_childValue.get("value").toString().equals("true")) {
							num = 0;
							for(int _repeat68 = 0; _repeat68 < (int)(keys.size()); _repeat68++) {
								if (keys.get((int)(num)).equals(_childValue.get("key").toString())) {
									keys.remove((int)(num));
									keys.add(_childValue.get("key").toString());
								}
								num++;
							}
							if (keys.size() == 0) {
								nothing_.setVisibility(View.VISIBLE);
								listview2.setVisibility(View.GONE);
							}
							listview2.setAdapter(new Listview2Adapter(listprojects));
						}
						if (_childValue.get("value").toString().equals("false")) {
							num = 0;
							for(int _repeat87 = 0; _repeat87 < (int)(keys.size()); _repeat87++) {
								if (keys.get((int)(num)).equals(_childValue.get("key").toString())) {
									keys.remove((int)(num));
								}
								num++;
							}
							if (keys.size() == 0) {
								nothing_.setVisibility(View.VISIBLE);
								listview2.setVisibility(View.GONE);
							}
							listview2.setAdapter(new Listview2Adapter(listprojects));
						}
					}
					((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
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
				if (project) {
					if (_childValue.get("key").toString().equals(key)) {
						if (users.contains(_childValue.get("uid").toString())) {
							users.remove((int)(users.indexOf(_childValue.get("uid").toString())));
						}
						if (users.size() == 0) {
							nothing.setVisibility(View.VISIBLE);
							listview1.setVisibility(View.GONE);
						}
					}
				}
				else {
					if (_childValue.get("uid").toString().equals(uid)) {
						if (keys.contains(_childValue.get("key").toString())) {
							keys.remove((int)(keys.indexOf(_childValue.get("key").toString())));
						}
						if (keys.size() == 0) {
							nothing_.setVisibility(View.VISIBLE);
							listview2.setVisibility(View.GONE);
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
		likes.addChildEventListener(_likes_child_listener);
		
		_userss_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (users.contains(_childKey)) {
					listmap.add((int)0, _childValue);
					listview1.setAdapter(new Listview1Adapter(listmap));
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				num = 0;
				for(int _repeat46 = 0; _repeat46 < (int)(listmap.size()); _repeat46++) {
					if (listmap.get((int)num).get("uid").toString().equals(_childKey)) {
						listmap.remove((int)(num));
						listmap.add((int)num, _childValue);
					}
					num++;
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
		userss.addChildEventListener(_userss_child_listener);
		
		_data1_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (keys.contains(_childKey)) {
					listprojects.add((int)0, _childValue);
					listview2.setAdapter(new Listview2Adapter(listprojects));
					((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				num = 0;
				for(int _repeat11 = 0; _repeat11 < (int)(listprojects.size()); _repeat11++) {
					if (listprojects.get((int)num).get("key").toString().equals(_childKey)) {
						listprojects.remove((int)(num));
						listprojects.add((int)num, _childValue);
					}
					num++;
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
				if (_childKey.equals(key)) {
					if (keys.contains(_childKey)) {
						keys.remove((int)(keys.indexOf(_childKey)));
						listprojects.remove((int)(keys.indexOf(_childKey)));
					}
					listview2.setAdapter(new Listview2Adapter(listprojects));
					((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
				}
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		data1.addChildEventListener(_data1_child_listener);
	}
	
	private void initializeLogic() {
		if (getIntent().getStringExtra("mode").equals("project")) {
			key = getIntent().getStringExtra("key");
			project = true;
			setTitle("Users who Liked Project");
			projects_listview.setVisibility(View.GONE);
		}
		else {
			uid = getIntent().getStringExtra("uid");
			project = false;
			setTitle("Liked Projects");
			users_listview.setVisibility(View.GONE);
		}
		imageview2.setColorFilter(Color.parseColor("#F44336"));
		
		listview2.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
		listview2.setStackFromBottom(false);
		listview1.setSelector(android.R.color.transparent);
		listview2.setSelector(android.R.color.transparent);
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
				_view = _inflater.inflate(R.layout.user, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			_Elevation(linear1, 7);
			_rippleRoundStroke(linear1, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
			if (_data.get((int)_position).containsKey("name")) {
				textview1.setText(_data.get((int)_position).get("name").toString());
			}
			if (_data.get((int)_position).containsKey("profile")) {
				if (_data.get((int)_position).get("profile").toString().equals("")) {
					imageview1.setImageResource(R.drawable.default_avatar);
				}
				else {
					if (_data.get((int)_position).get("profile").toString().equals("avator")) {
						imageview1.setImageResource(R.drawable.default_avatar);
					}
					else {
						_setCircleImageURL(imageview1, _data.get((int)_position).get("profile").toString(), 3, "#3F51B5");
					}
				}
			}
			else {
				imageview1.setImageResource(R.drawable.default_avatar);
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