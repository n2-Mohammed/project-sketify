package com.sketify.msk;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.webkit.*;
import android.widget.*;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class SeemoreActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private double n = 0;
	private String charSeq = "";
	private double search_n1 = 0;
	private double search_n = 0;
	private double projects = 0;
	private HashMap<String, Object> map = new HashMap<>();
	
	private ArrayList<HashMap<String, Object>> gridmap = new ArrayList<>();
	
	private LinearLayout searchbar;
	private LinearLayout linear1;
	private EditText search;
	private ImageView img;
	
	private DatabaseReference data1 = _firebase.getReference("data1");
	private ChildEventListener _data1_child_listener;
	private Intent intent = new Intent();
	private SharedPreferences data;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.seemore);
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
		searchbar = findViewById(R.id.searchbar);
		linear1 = findViewById(R.id.linear1);
		search = findViewById(R.id.search);
		img = findViewById(R.id.img);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		search.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				charSeq = _charSeq.trim();
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		img.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (getIntent().getStringExtra("mode").equals("new")) {
					if (!data.getString("new", "").equals("")) {
						gridmap = new Gson().fromJson(data.getString("new", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
						if (charSeq.length() > 0) {
							search_n1 = gridmap.size() - 1;
							search_n = gridmap.size();
							for(int _repeat28 = 0; _repeat28 < (int)(search_n); _repeat28++) {
								if (gridmap.get((int)search_n1).get("title").toString().toLowerCase().contains(charSeq.toLowerCase())) {
									
								}
								else {
									gridmap.remove((int)(search_n1));
								}
								search_n1--;
							}
						}
						_gridview();
					}
				}
				if (getIntent().getStringExtra("mode").equals("user")) {
					if (!data.getString("user", "").equals("")) {
						gridmap = new Gson().fromJson(data.getString("user", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
						if (charSeq.length() > 0) {
							search_n1 = gridmap.size() - 1;
							search_n = gridmap.size();
							for(int _repeat124 = 0; _repeat124 < (int)(search_n); _repeat124++) {
								if (gridmap.get((int)search_n1).get("title").toString().toLowerCase().contains(charSeq.toLowerCase())) {
									
								}
								else {
									gridmap.remove((int)(search_n1));
								}
								search_n1--;
							}
						}
						_gridview();
					}
				}
				if (getIntent().getStringExtra("mode").equals("editor")) {
					if (!data.getString("editor", "").equals("")) {
						gridmap = new Gson().fromJson(data.getString("editor", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
						if (charSeq.length() > 0) {
							search_n1 = gridmap.size() - 1;
							search_n = gridmap.size();
							for(int _repeat93 = 0; _repeat93 < (int)(search_n); _repeat93++) {
								if (gridmap.get((int)search_n1).get("title").toString().toLowerCase().contains(charSeq.toLowerCase())) {
									
								}
								else {
									gridmap.remove((int)(search_n1));
								}
								search_n1--;
							}
						}
						_gridview();
					}
				}
				if (getIntent().getStringExtra("mode").equals("open")) {
					if (!data.getString("open", "").equals("")) {
						gridmap = new Gson().fromJson(data.getString("open", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
						if (charSeq.length() > 0) {
							search_n1 = gridmap.size() - 1;
							search_n = gridmap.size();
							for(int _repeat155 = 0; _repeat155 < (int)(search_n); _repeat155++) {
								if (gridmap.get((int)search_n1).get("title").toString().toLowerCase().contains(charSeq.toLowerCase())) {
									
								}
								else {
									gridmap.remove((int)(search_n1));
								}
								search_n1--;
							}
						}
						_gridview();
					}
				}
			}
		});
		
		_data1_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (getIntent().getStringExtra("mode").equals("new")) {
					gridmap.add((int)0, _childValue);
					_gridview();
					data.edit().putString("new", new Gson().toJson(gridmap)).commit();
				}
				if (getIntent().getStringExtra("mode").equals("popular")) {
					if (_childValue.containsKey("likes")) {
						gridmap.add((int)0, _childValue);
					}
					_gridview();
					_SortMap(gridmap, "likes", true, false);
					data.edit().putString("popular", new Gson().toJson(gridmap)).commit();
				}
				if (getIntent().getStringExtra("mode").equals("open")) {
					if (_childValue.containsKey("open")) {
						if (_childValue.get("open").toString().equals("true")) {
							gridmap.add((int)0, _childValue);
						}
					}
					_gridview();
					data.edit().putString("open", new Gson().toJson(gridmap)).commit();
				}
				if (getIntent().getStringExtra("mode").equals("editor")) {
					if (_childValue.containsKey("editor")) {
						if (_childValue.get("editor").toString().equals("true")) {
							gridmap.add((int)0, _childValue);
						}
					}
					_gridview();
					data.edit().putString("editor", new Gson().toJson(gridmap)).commit();
				}
				if (getIntent().getStringExtra("mode").equals("user")) {
					if (_childValue.get("uid").toString().equals(getIntent().getStringExtra("uid"))) {
						gridmap.add((int)0, _childValue);
					}
					_gridview();
					data.edit().putString("user", new Gson().toJson(gridmap)).commit();
				}
				_custom_loading(false);
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (getIntent().getStringExtra("mode").equals("new")) {
					n = 0;
					for(int _repeat11 = 0; _repeat11 < (int)(gridmap.size()); _repeat11++) {
						if (gridmap.get((int)n).get("key").toString().equals(_childKey)) {
							gridmap.remove((int)(n));
							gridmap.add((int)n, _childValue);
						}
						n++;
					}
					_gridview();
					data.edit().putString("new", new Gson().toJson(gridmap)).commit();
				}
				if (getIntent().getStringExtra("mode").equals("popular")) {
					if (_childValue.containsKey("likes")) {
						n = 0;
						for(int _repeat27 = 0; _repeat27 < (int)(gridmap.size()); _repeat27++) {
							if (gridmap.get((int)n).get("key").toString().equals(_childKey)) {
								gridmap.remove((int)(n));
								gridmap.add((int)n, _childValue);
							}
							n++;
						}
					}
					_gridview();
					_SortMap(gridmap, "likes", true, false);
					data.edit().putString("popular", new Gson().toJson(gridmap)).commit();
				}
				if (getIntent().getStringExtra("mode").equals("editor")) {
					if (_childValue.containsKey("editor")) {
						if (_childValue.get("editor").toString().equals("true")) {
							n = 0;
							for(int _repeat50 = 0; _repeat50 < (int)(gridmap.size()); _repeat50++) {
								if (gridmap.get((int)n).get("key").toString().equals(_childKey)) {
									gridmap.remove((int)(n));
									gridmap.add((int)n, _childValue);
								}
								n++;
							}
						}
					}
					_gridview();
					data.edit().putString("editor", new Gson().toJson(gridmap)).commit();
				}
				if (getIntent().getStringExtra("mode").equals("open")) {
					if (_childValue.containsKey("open")) {
						if (_childValue.get("open").toString().equals("true")) {
							n = 0;
							for(int _repeat130 = 0; _repeat130 < (int)(gridmap.size()); _repeat130++) {
								if (gridmap.get((int)n).get("key").toString().equals(_childKey)) {
									gridmap.remove((int)(n));
									gridmap.add((int)n, _childValue);
								}
								n++;
							}
						}
					}
					_gridview();
					data.edit().putString("open", new Gson().toJson(gridmap)).commit();
				}
				if (getIntent().getStringExtra("mode").equals("user")) {
					if (_childValue.get("uid").toString().equals(getIntent().getStringExtra("uid"))) {
						n = 0;
						for(int _repeat92 = 0; _repeat92 < (int)(gridmap.size()); _repeat92++) {
							if (gridmap.get((int)n).get("key").toString().equals(_childKey)) {
								gridmap.remove((int)(n));
								gridmap.add((int)n, _childValue);
							}
							n++;
						}
					}
					_gridview();
					data.edit().putString("user", new Gson().toJson(gridmap)).commit();
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
	}
	
	private void initializeLogic() {
		_toolbar.setTitleTextColor(Color.parseColor("#616161"));
		
		getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_grey);
		setTitle(getIntent().getStringExtra("title"));
		_Elevation(linear1, 7);
		_gd(linear1, 4, "#FFFFFF");
		_Elevation(searchbar, 7);
		_MENU();
		_Toolbar(false);
		_rippleRoundStroke(img, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_custom_loading(true);
		
	}
	
	public void _Elevation(final View _view, final double _number) {
		
		_view.setElevation((int)_number);
	}
	
	
	public void _gd(final View _view, final double _numb, final String _color) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		gd.setCornerRadius((int)_numb);
		_view.setBackground(gd);
	}
	
	
	public void _gridview() {
		GridView grid = new GridView(SeemoreActivity.this);
		
		grid.setLayoutParams(new GridView.LayoutParams(GridLayout.LayoutParams.MATCH_PARENT, GridLayout.LayoutParams.WRAP_CONTENT));
		
		grid.setNumColumns(3);
		
		grid.setColumnWidth(GridView.AUTO_FIT);
		
		grid.setBackgroundColor(Color.WHITE);
		
		grid.setVerticalSpacing(2);
		
		grid.setHorizontalSpacing(2);
		
		grid.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
		
		grid.setVerticalScrollBarEnabled(false);
		
		grid.setAdapter(new Listview1Adapter(gridmap));
		
		linear1.removeAllViews();
		
		linear1.addView(grid);
		
		((BaseAdapter)grid.getAdapter()).notifyDataSetChanged();
		
		grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {	@Override	public void onItemClick(AdapterView<?> parent, View view, int _pos, long id) {
				
				intent.setClass(getApplicationContext(), ProjectViewActivity.class);
				
				intent.putExtra("key", gridmap.get((int)_pos).get("key").toString());
				
				intent.putExtra("uid", gridmap.get((int)_pos).get("uid").toString());
								intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				
				startActivity(intent);
				
			}});
	}
	
	
	public void _extra() {
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
		
				public View getView(final int _position, View _view, ViewGroup _viewGroup) {
						LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
						View _v = _view;
						if (_v == null) {
								_v = _inflater.inflate(R.layout.grid, null);
						}
						
						final LinearLayout linear1 = (LinearLayout) _v.findViewById(R.id.linear1);
						final ImageView icon = (ImageView) _v.findViewById(R.id.icon);
						final TextView title = (TextView) _v.findViewById(R.id.title);
						final LinearLayout linear2 = (LinearLayout) _v.findViewById(R.id.linear2);
						final ImageView imageview1 = (ImageView) _v.findViewById(R.id.imageview1);
						final TextView likes = (TextView) _v.findViewById(R.id.likes);
						final ImageView imageview2 = (ImageView) _v.findViewById(R.id.imageview2);
						final TextView comments = (TextView) _v.findViewById(R.id.comments);
						
						if (_data.get((int)_position).containsKey("icon")) {
								Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("icon").toString())).into(icon);
						}
						else {
								icon.setImageResource(R.drawable.android_icon);
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
						
						return _v;
				}
	}
	
	
	public void _Toolbar(final boolean _v) {
		if (_v) {
			getSupportActionBar().show();
		}
		else {
			getSupportActionBar().hide();
		}
	}
	
	
	public void _MENU() {
	}
	@Override
	public boolean onCreateOptionsMenu (Menu menu){
		menu.add(0, 0, 0, "Search").setIcon(R.drawable.ic_search_grey).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()){
			case 0:
			searchbar.setVisibility(View.VISIBLE);
			_Toolbar(false);
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	public void _SortMap(final ArrayList<HashMap<String, Object>> _listMap, final String _key, final boolean _isNumber, final boolean _Ascending) {
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