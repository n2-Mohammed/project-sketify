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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
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

public class CategoryActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String category = "";
	private double n = 0;
	private String fontName = "";
	private String typeace = "";
	private HashMap<String, Object> map = new HashMap<>();
	private double search_n1 = 0;
	private double search_n = 0;
	private HashMap<String, Object> check = new HashMap<>();
	private String strokeclr = "";
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<String> string = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout main;
	private LinearLayout progress;
	private LinearLayout linear4;
	private LinearLayout searchbar;
	private LinearLayout toolbar;
	private ImageView imageview1;
	private TextView textview15;
	private ImageView imageview3;
	private ImageView imageview2;
	private EditText search_text;
	private ListView listview1;
	private TextView tnothing;
	private ProgressBar progressbar1;
	
	private DatabaseReference data1 = _firebase.getReference("data1");
	private ChildEventListener _data1_child_listener;
	private Intent intent = new Intent();
	private TimerTask timer;
	private SharedPreferences data;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.category);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		main = findViewById(R.id.main);
		progress = findViewById(R.id.progress);
		linear4 = findViewById(R.id.linear4);
		searchbar = findViewById(R.id.searchbar);
		toolbar = findViewById(R.id.toolbar);
		imageview1 = findViewById(R.id.imageview1);
		textview15 = findViewById(R.id.textview15);
		imageview3 = findViewById(R.id.imageview3);
		imageview2 = findViewById(R.id.imageview2);
		search_text = findViewById(R.id.search_text);
		listview1 = findViewById(R.id.listview1);
		tnothing = findViewById(R.id.tnothing);
		progressbar1 = findViewById(R.id.progressbar1);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				searchbar.setVisibility(View.VISIBLE);
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				searchbar.setVisibility(View.GONE);
				listview1.setAdapter(new Listview1Adapter(listmap));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			}
		});
		
		search_text.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (!data.getString("new", "").equals("")) {
					listmap = new Gson().fromJson(data.getString("new", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
					if (_charSeq.length() > 0) {
						search_n1 = listmap.size() - 1;
						search_n = listmap.size();
						for(int _repeat76 = 0; _repeat76 < (int)(search_n); _repeat76++) {
							if (listmap.get((int)search_n1).get("title").toString().toLowerCase().contains(_charSeq.toLowerCase())) {
								
							}
							else {
								listmap.remove((int)(search_n1));
							}
							search_n1--;
						}
					}
					listview1.setAdapter(new Listview1Adapter(listmap));
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				intent.setClass(getApplicationContext(), ProjectViewActivity.class);
				intent.putExtra("key", listmap.get((int)_position).get("key").toString());
				intent.putExtra("uid", listmap.get((int)_position).get("uid").toString());
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
		
		_data1_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				_custom_loading(true);
				if (_childValue.isEmpty()) {
					main.setVisibility(View.VISIBLE);
					tnothing.setVisibility(View.VISIBLE);
					progress.setVisibility(View.GONE);
					listview1.setVisibility(View.GONE);
				}
				else {
					if (_childValue.get("category").toString().equals(category)) {
						listmap.add((int)0, _childValue);
						if (!_childValue.get("category").toString().equals("")) {
							string.add(_childValue.get("category").toString());
						}
					}
					listview1.setAdapter(new Listview1Adapter(listmap));
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					if (string.size() == 0) {
						main.setVisibility(View.VISIBLE);
						tnothing.setVisibility(View.VISIBLE);
						progress.setVisibility(View.GONE);
						listview1.setVisibility(View.GONE);
					}
					else {
						main.setVisibility(View.VISIBLE);
						tnothing.setVisibility(View.GONE);
						progress.setVisibility(View.GONE);
						listview1.setVisibility(View.VISIBLE);
					}
				}
				timer = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_custom_loading(false);
							}
						});
					}
				};
				_timer.schedule(timer, (int)(999));
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.get("category").toString().equals(category)) {
					n = 0;
					for(int _repeat16 = 0; _repeat16 < (int)(listmap.size()); _repeat16++) {
						if (listmap.get((int)n).get("key").toString().equals(_childKey)) {
							listmap.remove((int)(n));
							listmap.add((int)n, _childValue);
						}
						n++;
					}
				}
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
				if (_childValue.get("uid").toString().equals(category)) {
					n = 0;
					for(int _repeat16 = 0; _repeat16 < (int)(listmap.size()); _repeat16++) {
						if (listmap.get((int)n).get("key").toString().equals(_childKey)) {
							listmap.remove((int)(n));
						}
						n++;
					}
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
		data1.addChildEventListener(_data1_child_listener);
	}
	
	private void initializeLogic() {
		searchbar.setVisibility(View.GONE);
		main.setVisibility(View.GONE);
		tnothing.setVisibility(View.GONE);
		progress.setVisibility(View.VISIBLE);
		textview15.setText(getIntent().getStringExtra("c"));
		category = getIntent().getStringExtra("c");
		_custom_loading(true);
		_changeActivityFont("regular");
		_Elevation(toolbar, 7);
		_removeScollBar(listview1);
		_rippleRoundStroke(imageview1, "#536DFE", "#E0E0E0", 50, 0, "#FFFFFF");
		_rippleRoundStroke(imageview3, "#536DFE", "#E0E0E0", 50, 0, "#FFFFFF");
		_rippleRoundStroke(imageview2, "#536DFE", "#E0E0E0", 50, 0, "#FFFFFF");
		
		listview1.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
		listview1.setStackFromBottom(false);
		listview1.setSelector(android.R.color.transparent);
	}
	
	public void _Elevation(final View _view, final double _number) {
		
		_view.setElevation((int)_number);
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
	
	
	public void _Ripple_Drawable(final View _view, final String _c) {
		android.content.res.ColorStateList clr = new android.content.res.ColorStateList(new int[][]{new int[]{}},new int[]{Color.parseColor(_c)}); android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(clr, null, null); _view.setBackground(ripdr);
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
	
	
	public void _custom_loading(final boolean _visibility) {
		_cus(_visibility);
	}
	
	
	public void _removeScollBar(final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
	}
	
	
	public void _cus(final boolean _visibility) {
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
			
			LinearLayout linear = (LinearLayout) _view.findViewById(R.id.linear);
			
			
			strokeclr = "#FFFFFF";
			android.graphics.drawable.GradientDrawable Gh = new android.graphics.drawable.GradientDrawable();
			Gh.setColor(Color.parseColor("#FFFFFF"));
			Gh.setCornerRadius((float)50);
			Gh.setStroke((int) 0,
			Color.parseColor("#" + strokeclr.replace("#", "")));
			android.graphics.drawable.RippleDrawable Rh = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#EEEEEE")}), Gh, null);
			linear.setBackground(Rh);
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
			
			imageview5.setColorFilter(Color.parseColor("#536DFE"));
			if (_data.get((int)_position).containsKey("visibility")) {
				if (_data.get((int)_position).get("visibility").toString().equals("true")) {
					linear1.setVisibility(View.VISIBLE);
					
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
					if (_data.get((int)_position).containsKey("name")) {
						textview_uploader.setText(_data.get((int)_position).get("name").toString());
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
				}
				else {
					if (_data.get((int)_position).get("uid").toString().equals("")) {
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
						if (_data.get((int)_position).containsKey("name")) {
							textview_uploader.setText(_data.get((int)_position).get("name").toString());
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
						linear1.setVisibility(View.VISIBLE);
					}
					else {
						linear1.setVisibility(View.GONE);
						
					}
				}
			}
			else {
				linear1.setVisibility(View.VISIBLE);
				
				if (_data.get((int)_position).containsKey("name")) {
					textview_uploader.setText(_data.get((int)_position).get("name").toString());
				}
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