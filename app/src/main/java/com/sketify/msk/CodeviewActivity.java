package com.sketify.msk;

import android.animation.*;
import android.app.*;
import android.app.AlertDialog;
import android.content.*;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
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
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class CodeviewActivity extends AppCompatActivity {
	
	private FloatingActionButton _fab;
	private String key = "";
	private String fontName = "";
	private String typeace = "";
	private double regex1 = 0;
	private double regex2 = 0;
	private double regex3 = 0;
	private double regex4 = 0;
	private double regex5 = 0;
	private double regex6 = 0;
	private double regex7 = 0;
	private double regex8 = 0;
	private double regex9 = 0;
	private double regex10 = 0;
	
	private LinearLayout linear1;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private ImageView imageview1;
	private TextView textview15;
	private ScrollView vscroll5;
	private LinearLayout linear2;
	private LinearLayout title;
	private LinearLayout linear7;
	private LinearLayout code_main;
	private TextView title_text;
	private TextView textview17;
	private TextView textview_about;
	private LinearLayout code_title_main;
	private HorizontalScrollView hscroll1;
	private TextView textview19;
	private ImageView imageview2;
	private TextView html;
	
	private FirebaseAuth getemail;
	private OnCompleteListener<AuthResult> _getemail_create_user_listener;
	private OnCompleteListener<AuthResult> _getemail_sign_in_listener;
	private OnCompleteListener<Void> _getemail_reset_password_listener;
	private OnCompleteListener<Void> getemail_updateEmailListener;
	private OnCompleteListener<Void> getemail_updatePasswordListener;
	private OnCompleteListener<Void> getemail_emailVerificationSentListener;
	private OnCompleteListener<Void> getemail_deleteUserListener;
	private OnCompleteListener<Void> getemail_updateProfileListener;
	private OnCompleteListener<AuthResult> getemail_phoneAuthListener;
	private OnCompleteListener<AuthResult> getemail_googleSignInListener;
	
	private AlertDialog.Builder dialog;
	private AlertDialog.Builder delete;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.codeview);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_fab = findViewById(R.id._fab);
		
		linear1 = findViewById(R.id.linear1);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		imageview1 = findViewById(R.id.imageview1);
		textview15 = findViewById(R.id.textview15);
		vscroll5 = findViewById(R.id.vscroll5);
		linear2 = findViewById(R.id.linear2);
		title = findViewById(R.id.title);
		linear7 = findViewById(R.id.linear7);
		code_main = findViewById(R.id.code_main);
		title_text = findViewById(R.id.title_text);
		textview17 = findViewById(R.id.textview17);
		textview_about = findViewById(R.id.textview_about);
		code_title_main = findViewById(R.id.code_title_main);
		hscroll1 = findViewById(R.id.hscroll1);
		textview19 = findViewById(R.id.textview19);
		imageview2 = findViewById(R.id.imageview2);
		html = findViewById(R.id.html);
		getemail = FirebaseAuth.getInstance();
		dialog = new AlertDialog.Builder(this);
		delete = new AlertDialog.Builder(this);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", html.getText().toString()));
				_SnackBar(false, true, false, "Copied!");
			}
		});
		
		getemail_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		getemail_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		getemail_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		getemail_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		getemail_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		getemail_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		getemail_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_getemail_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_getemail_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_getemail_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		_srt(html);
		textview15.setText(getIntent().getStringExtra("title"));
		title_text.setText(getIntent().getStringExtra("title"));
		html.setText(getIntent().getStringExtra("code"));
		if (getIntent().getStringExtra("about").equals("")) {
			linear7.setVisibility(View.GONE);
		}
		else {
			linear7.setVisibility(View.VISIBLE);
			textview_about.setText(getIntent().getStringExtra("about"));
		}
		html.setTextIsSelectable(true);
		if (FirebaseAuth.getInstance().getCurrentUser().getEmail().equals("mskshafi99@gmail.com")) {
			_fab.setVisibility(View.VISIBLE);
		}
		else {
			_fab.setVisibility(View.GONE);
		}
		code_main.setElevation(15f);
		_changeActivityFont("regular");
		_rippleRoundStroke(imageview2, "#FFFFFF", "#E0E0E0", 0, 3, "#FFFFFF");
		_rippleRoundStroke(imageview1, "#536DFE", "#E0E0E0", 50, 0, "#FFFFFF");
		_Elevation(code_main, 7);
		_rippleRoundStroke(code_main, "#FFFFFF", "#FFFFFF", 30, 0, "#FFFFFF");
		_Elevation(linear7, 7);
		_rippleRoundStroke(linear7, "#FFFFFF", "#FFFFFF", 30, 0, "#FFFFFF");
		_Elevation(title, 7);
		_rippleRoundStroke(title, "#FFFFFF", "#FFFFFF", 30, 0, "#FFFFFF");
		_removeScollBar(vscroll5);
		_removeScollBar(hscroll1);
	}
	
	public void _Elevation(final View _view, final double _number) {
		
		_view.setElevation((float)_number);
	}
	
	
	public void _SnackBar(final boolean _isLong, final boolean _isShort, final boolean _isIndefinite, final String _text) {
		// linear1 is your main or base of the UI
		if (_isLong) {
			com.google.android.material.snackbar.Snackbar.make(linear1, _text, com.google.android.material.snackbar.Snackbar.LENGTH_LONG).show();
		}
		else {
			if (_isShort) {
				com.google.android.material.snackbar.Snackbar.make(linear1, _text, com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).show();
			}
			else {
				if (_isIndefinite) {
					com.google.android.material.snackbar.Snackbar.make(linear1, _text, com.google.android.material.snackbar.Snackbar.LENGTH_INDEFINITE).show();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), _text);
				}
			}
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
	
	
	public void _makeLinksClickable(final TextView _textView) {
		try {
			String _color = "#0871ff";
			_textView.setClickable(true);
			android.text.util.Linkify.addLinks(_textView, android.text.util.Linkify.ALL);
			_textView.setLinkTextColor(Color.parseColor(_color));
			_textView.setLinksClickable(true); } catch (Exception e) { };
	}
	
	
	public void _removeScollBar(final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
	}
	
	
	public void _srt(final TextView _view) {
		final String secondaryColor = "#678cb1";
		final String primaryColor = "#86b55a";
		final String numbersColor = "#f6c921";
		final String quotesColor = "#ff1744";
		final String commentsColor = "#9e9e9e";
		final String charColor = "#ff5722";
		final TextView regex1 = new TextView(this);
		final TextView regex2 = new TextView(this);
		final TextView regex3 = new TextView(this);
		final TextView regex4 = new TextView(this);
		final TextView regex5 = new TextView(this);
		final TextView regex6 = new TextView(this);
		final TextView regex7 = new TextView(this);
		final TextView regex8 = new TextView(this);
		final TextView regex9 = new TextView(this);
		final TextView regex10 = new TextView(this);
		final TextView regex11 = new TextView(this);
		
		regex1.setText("\\b(out|print|println|valueOf|toString|concat|equals|for|while|switch|getText");
		
		regex2.setText("|println|printf|print|out|parseInt|round|sqrt|charAt|compareTo|compareToIgnoreCase|concat|contains|contentEquals|equals|length|toLowerCase|trim|toUpperCase|toString|valueOf|substring|startsWith|split|replace|replaceAll|lastIndexOf|size)\\b");
		
		regex3.setText("\\b(public|private|protected|void|switch|case|class|import|package|extends|Activity|TextView|EditText|LinearLayout|CharSequence|String|int|onCreate|ArrayList|float|if|else|static|Intent|Button|SharedPreferences");
		
		regex4.setText("|abstract|assert|boolean|break|byte|case|catch|char|class|const|continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|implements|import|instanceof|interface|long|native|new|package|private|protected|");
		
		regex5.setText("public|return|short|static|strictfp|super|switch|synchronized|this|throw|throws|transient|try|void|volatile|while|true|false|null)\\b");
		
		regex6.setText("\\b([0-9]+)\\b");
		
		regex7.setText("(\\w+)(\\()+");
		
		regex8.setText("\\@\\s*(\\w+)");
		
		regex9.setText("\"(.*?)\"|'(.*?)'");
		
		regex10.setText("/\\*(?:.|[\\n\\r])*?\\*/|//.*");
		
		regex11.setText("\\b(Uzuakoli|Amoji|Bright|Ndudirim|Ezinwanne|Lightworker|Isuochi|Abia|Ngodo)\\b");
		_view.addTextChangedListener(new TextWatcher() {
			ColorScheme keywords1 = new ColorScheme(java.util.regex.Pattern.compile(regex1.getText().toString().concat(regex2.getText().toString())), Color.parseColor(secondaryColor));
			
			ColorScheme keywords2 = new ColorScheme(java.util.regex.Pattern.compile(regex3.getText().toString().concat(regex4.getText().toString().concat(regex5.getText().toString()))), Color.parseColor(primaryColor));
			
			ColorScheme keywords3 = new ColorScheme(java.util.regex.Pattern.compile(regex6.getText().toString()), Color.parseColor(numbersColor));
			
			ColorScheme keywords4 = new ColorScheme(java.util.regex.Pattern.compile(regex7.getText().toString()), Color.parseColor(secondaryColor));
			
			ColorScheme keywords5 = new ColorScheme(java.util.regex.Pattern.compile(regex9.getText().toString()), Color.parseColor(quotesColor));
			
			ColorScheme keywords6 = new ColorScheme(java.util.regex.Pattern.compile(regex10.getText().toString()), Color.parseColor(commentsColor));
			
			ColorScheme keywords7 = new ColorScheme(java.util.regex.Pattern.compile(regex8.getText().toString()), Color.parseColor(numbersColor));
			
			
			ColorScheme keywords8 = new ColorScheme(java.util.regex.Pattern.compile(regex11.getText().toString()), Color.parseColor(charColor));
			
			final ColorScheme[] schemes = {keywords1, keywords2, keywords3, keywords4, keywords5, keywords6, keywords7, keywords8}; @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { } @Override public void onTextChanged(CharSequence s, int start, int before, int count) { } @Override public void afterTextChanged(Editable s) { removeSpans(s, android.text.style.ForegroundColorSpan.class); for(ColorScheme scheme : schemes) { for(java.util.regex.Matcher m = scheme.pattern.matcher(s);
					
					m.find();) { if (scheme == keywords4) { s.setSpan(new android.text.style.ForegroundColorSpan(scheme.color), m.start(), m.end()-1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
						} 
						else { s.setSpan(new android.text.style.ForegroundColorSpan(scheme.color), m.start(), m.end(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); } } } } void removeSpans(Editable e, Class type) { android.text.style.CharacterStyle[] spans = e.getSpans(0, e.length(), type); for (android.text.style.CharacterStyle span : spans) { e.removeSpan(span); } } class ColorScheme { final java.util.regex.Pattern pattern; final int color; ColorScheme(java.util.regex.Pattern pattern, int color) { this.pattern = pattern; this.color = color; } } });
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