package com.sketify.msk;

import android.animation.*;
import android.app.*;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
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
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.firebase.FirebaseApp;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class AboutActivity extends AppCompatActivity {
	
	private String fontName = "";
	private String typeace = "";
	
	private LinearLayout center;
	private ScrollView vscroll1;
	private LinearLayout linear67;
	private LinearLayout linear69;
	private LinearLayout linear71;
	private ScrollView vscroll2;
	private LinearLayout linear66;
	private ScrollView vscroll3;
	private LinearLayout linear55;
	private LinearLayout linear48;
	private LinearLayout linear51;
	private LinearLayout email;
	private LinearLayout linear75;
	private LinearLayout blog;
	private LinearLayout aboutt;
	private LinearLayout linear64;
	private LinearLayout linear65;
	private LinearLayout linear72;
	private LinearLayout linear57;
	private LinearLayout log;
	private LinearLayout linear73;
	private LinearLayout website;
	private LinearLayout discord;
	private LinearLayout telegramn;
	private LinearLayout linear59;
	private LinearLayout specialthanks;
	private LinearLayout linear63;
	private LinearLayout terms;
	private LinearLayout policy;
	private LinearLayout linear50;
	private LinearLayout linear49;
	private ImageView imageview8;
	private TextView textview23;
	private TextView textview24;
	private TextView textview25;
	private TextView textview26;
	private TextView textview27;
	private TextView textview59;
	private TextView textview60;
	private TextView textview28;
	private TextView textview29;
	private TextView textview31;
	private TextView textview32;
	private TextView textview45;
	private ImageView msk;
	private TextView textview47;
	private ImageView imageview_yahaya;
	private TextView textview48;
	private TextView textview33;
	private TextView textview35;
	private TextView textview36;
	private TextView textview49;
	private ImageView imageview13;
	private TextView textview51;
	private TextView web;
	private ImageView imageview14;
	private TextView textview52;
	private TextView textview54;
	private ImageView imageview15;
	private TextView textview53;
	private TextView textview55;
	private TextView textview37;
	private ImageView imageview_sketchub;
	private TextView textview39;
	private TextView textview56;
	private TextView textview41;
	private TextView textview42;
	private TextView textview44;
	
	private AlertDialog.Builder about;
	private Intent view = new Intent();
	private AlertDialog.Builder read;
	private Intent sketchub = new Intent();
	private Intent emai = new Intent();
	private Intent blogg = new Intent();
	private Intent termss = new Intent();
	private Intent yahaya = new Intent();
	private Intent admin = new Intent();
	private Intent supportt = new Intent();
	private Intent policyy = new Intent();
	private Intent webs = new Intent();
	private Intent discordd = new Intent();
	private Intent telegram = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.about);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		center = findViewById(R.id.center);
		vscroll1 = findViewById(R.id.vscroll1);
		linear67 = findViewById(R.id.linear67);
		linear69 = findViewById(R.id.linear69);
		linear71 = findViewById(R.id.linear71);
		vscroll2 = findViewById(R.id.vscroll2);
		linear66 = findViewById(R.id.linear66);
		vscroll3 = findViewById(R.id.vscroll3);
		linear55 = findViewById(R.id.linear55);
		linear48 = findViewById(R.id.linear48);
		linear51 = findViewById(R.id.linear51);
		email = findViewById(R.id.email);
		linear75 = findViewById(R.id.linear75);
		blog = findViewById(R.id.blog);
		aboutt = findViewById(R.id.aboutt);
		linear64 = findViewById(R.id.linear64);
		linear65 = findViewById(R.id.linear65);
		linear72 = findViewById(R.id.linear72);
		linear57 = findViewById(R.id.linear57);
		log = findViewById(R.id.log);
		linear73 = findViewById(R.id.linear73);
		website = findViewById(R.id.website);
		discord = findViewById(R.id.discord);
		telegramn = findViewById(R.id.telegramn);
		linear59 = findViewById(R.id.linear59);
		specialthanks = findViewById(R.id.specialthanks);
		linear63 = findViewById(R.id.linear63);
		terms = findViewById(R.id.terms);
		policy = findViewById(R.id.policy);
		linear50 = findViewById(R.id.linear50);
		linear49 = findViewById(R.id.linear49);
		imageview8 = findViewById(R.id.imageview8);
		textview23 = findViewById(R.id.textview23);
		textview24 = findViewById(R.id.textview24);
		textview25 = findViewById(R.id.textview25);
		textview26 = findViewById(R.id.textview26);
		textview27 = findViewById(R.id.textview27);
		textview59 = findViewById(R.id.textview59);
		textview60 = findViewById(R.id.textview60);
		textview28 = findViewById(R.id.textview28);
		textview29 = findViewById(R.id.textview29);
		textview31 = findViewById(R.id.textview31);
		textview32 = findViewById(R.id.textview32);
		textview45 = findViewById(R.id.textview45);
		msk = findViewById(R.id.msk);
		textview47 = findViewById(R.id.textview47);
		imageview_yahaya = findViewById(R.id.imageview_yahaya);
		textview48 = findViewById(R.id.textview48);
		textview33 = findViewById(R.id.textview33);
		textview35 = findViewById(R.id.textview35);
		textview36 = findViewById(R.id.textview36);
		textview49 = findViewById(R.id.textview49);
		imageview13 = findViewById(R.id.imageview13);
		textview51 = findViewById(R.id.textview51);
		web = findViewById(R.id.web);
		imageview14 = findViewById(R.id.imageview14);
		textview52 = findViewById(R.id.textview52);
		textview54 = findViewById(R.id.textview54);
		imageview15 = findViewById(R.id.imageview15);
		textview53 = findViewById(R.id.textview53);
		textview55 = findViewById(R.id.textview55);
		textview37 = findViewById(R.id.textview37);
		imageview_sketchub = findViewById(R.id.imageview_sketchub);
		textview39 = findViewById(R.id.textview39);
		textview56 = findViewById(R.id.textview56);
		textview41 = findViewById(R.id.textview41);
		textview42 = findViewById(R.id.textview42);
		textview44 = findViewById(R.id.textview44);
		about = new AlertDialog.Builder(this);
		read = new AlertDialog.Builder(this);
		
		email.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				supportt.setAction(Intent.ACTION_VIEW);
				supportt.setData(Uri.parse("mailto:sketifyofficial@gmail.com"));
				supportt.putExtra("subject", "Report (or) Message From Sketify User");
				startActivity(supportt);
			}
		});
		
		linear75.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				webs.setAction(Intent.ACTION_VIEW);
				webs.setData(Uri.parse("https://sketify.tk"));
				startActivity(webs);
			}
		});
		
		blog.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				blogg.setAction(Intent.ACTION_VIEW);
				blogg.setData(Uri.parse("https://sketify.blogspot.com"));
				blogg.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(blogg);
			}
		});
		
		linear65.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				admin.setClass(getApplicationContext(), WebActivity.class);
				admin.putExtra("url", "https://youtube.com/channel/UCQfkZXnb2fdmqqSWijGINqw");
				startActivity(admin);
			}
		});
		
		linear72.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				yahaya.setClass(getApplicationContext(), WebActivity.class);
				yahaya.putExtra("url", "https://youtube.com/channel/UCYy5Jq08aDk3h505SIrynyw");
				startActivity(yahaya);
			}
		});
		
		website.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				webs.setAction(Intent.ACTION_VIEW);
				webs.setData(Uri.parse(web.getText().toString()));
				webs.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(webs);
			}
		});
		
		discord.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				discordd.setClass(getApplicationContext(), WebActivity.class);
				discordd.putExtra("url", "https://discord.gg/syvRM3vean");
				startActivity(discordd);
			}
		});
		
		telegramn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				telegram.setClass(getApplicationContext(), WebActivity.class);
				telegram.putExtra("url", "http://t.me/sketifychannel");
				startActivity(telegram);
			}
		});
		
		specialthanks.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sketchub.setAction(Intent.ACTION_VIEW);
				sketchub.setData(Uri.parse("https://sketchub.in/"));
				sketchub.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(sketchub);
			}
		});
		
		terms.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				termss.setClass(getApplicationContext(), WebActivity.class);
				termss.putExtra("url", "https://sketify.blogspot.com/2021/01/terms-conditions-on-on-sketify.html?m=1");
				termss.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(termss);
			}
		});
		
		policy.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				policyy.setClass(getApplicationContext(), WebActivity.class);
				policyy.putExtra("url", "https://kasimobiles.online/privacy-policy");
				policyy.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(policyy);
			}
		});
		
		textview32.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				about.setTitle("About");
				about.setMessage("Sketify was An Unofficial Project Store Created,Designed & Full Efforts By Ms - Muhammed Shafi.\nSketify Was Designed By as A Model Of Sketchub (But Its Not a Copy). My Efforts Is Gived Me This Big Opportunity, Thanks For All Users In Sketify Who Give's Sketify Thumbs Up!");
				about.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				about.setCancelable(false);
				about.create().show();
			}
		});
		
		textview36.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				read.setTitle("Change Log");
				read.setMessage("~ v1.2\n\n- UI Added\n- Added \"Settings\" In Menu\n- Visual Effects\n- Popularity\n- News\n- Category Environment\n& More...");
				read.setPositiveButton("DONE", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				read.create().show();
			}
		});
	}
	
	private void initializeLogic() {
		_changeActivityFont("calculator");
		_rippleRoundStroke(specialthanks, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(email, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(blog, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(aboutt, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(linear75, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(terms, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(policy, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(log, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(linear65, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(linear66, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(website, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(discord, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(telegramn, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(linear72, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(msk, "#FFFFFF", "#EEEEEE", 50, 0, "#FFFFFF");
		_rippleRoundStroke(imageview_yahaya, "#FFFFFF", "#EEEEEE", 50, 3, "#FFFFFF");
		_rippleRoundStroke(imageview_sketchub, "#FFFFFF", "#EEEEEE", 50, 3, "#FFFFFF");
		_Elevation(linear75, 7);
		_Elevation(email, 7);
		_Elevation(aboutt, 7);
		_Elevation(log, 7);
		_Elevation(specialthanks, 7);
		_Elevation(terms, 7);
		_Elevation(policy, 7);
		_Elevation(linear48, 7);
		_Elevation(linear65, 7);
		_Elevation(linear66, 7);
		_Elevation(website, 7);
		_Elevation(discord, 7);
		_Elevation(telegramn, 7);
		_Elevation(linear72, 7);
		_Elevation(blog, 7);
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
	
	
	public void _Elevation(final View _view, final double _number) {
		
		_view.setElevation((int)_number);
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