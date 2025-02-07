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
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public class WebActivity extends AppCompatActivity {
	
	private String url = "";
	private String fontName = "";
	private String typeace = "";
	
	private LinearLayout linear;
	private LinearLayout pl;
	private LinearLayout linear1;
	private ImageView imageview1;
	private LinearLayout linear5;
	private ImageView imageview3;
	private TextView textview_title;
	private TextView textview2;
	private WebView webview1;
	
	private Intent view = new Intent();
	private RequestNetwork net;
	private RequestNetwork.RequestListener _net_request_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.web);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear = findViewById(R.id.linear);
		pl = findViewById(R.id.pl);
		linear1 = findViewById(R.id.linear1);
		imageview1 = findViewById(R.id.imageview1);
		linear5 = findViewById(R.id.linear5);
		imageview3 = findViewById(R.id.imageview3);
		textview_title = findViewById(R.id.textview_title);
		textview2 = findViewById(R.id.textview2);
		webview1 = findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		net = new RequestNetwork(this);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				view.setAction(Intent.ACTION_VIEW);
				view.setData(Uri.parse(url));
				startActivity(view);
			}
		});
		
		webview1.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				pl.setVisibility(View.VISIBLE);
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				textview_title.setText(webview1.getTitle());
				textview2.setText(_url);
				WebSettings webSettings = webview1.getSettings(); 
				webSettings.setJavaScriptEnabled(true); 
				webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
				if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
					webSettings.setAllowFileAccessFromFileURLs(true); 
					webSettings.setAllowUniversalAccessFromFileURLs(true);
				}
				pl.setVisibility(View.GONE);
				super.onPageFinished(_param1, _param2);
			}
		});
		
		_net_request_listener = new RequestNetwork.RequestListener() {
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
				SketchwareUtil.showMessage(getApplicationContext(), _message);
				finish();
			}
		};
	}
	
	private void initializeLogic() {
		net.startRequestNetwork(RequestNetworkController.GET, getIntent().getStringExtra("url"), "", _net_request_listener);
		_Elevation(linear, 7);
		_changeActivityFont("calculator");
		url = getIntent().getStringExtra("url");
		if (getIntent().getStringExtra("url").contains("https://")) {
			url = getIntent().getStringExtra("url").replace("https://", "http://");
		}
		webview1.loadUrl(url);
		_rippleRoundStroke(imageview1, "#FFFFFF", "#BDBDBD", 20, 3, "#FFFFFF");
		_rippleRoundStroke(imageview3, "#FFFFFF", "#BDBDBD", 20, 3, "#FFFFFF");
		webview1.getSettings().setBuiltInZoomControls(true);webview1.getSettings().setDisplayZoomControls(false);
		webview1.setDownloadListener(new DownloadListener() {     public void onDownloadStart(String url, String userAgent,                 String contentDisposition, String mimetype,                 long contentLength) {         Intent i = new Intent(Intent.ACTION_VIEW);         i.setData(Uri.parse(url));         startActivity(i);     } });
		webview1.getSettings().setAppCacheMaxSize(5*1024*1024); 
		webview1.getSettings().setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath()); 
		webview1.getSettings().setAllowFileAccess(true);
		webview1.getSettings().setAppCacheEnabled(true);
		webview1.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		webview1.getSettings().setLoadWithOverviewMode(true);
		webview1.getSettings().setUseWideViewPort(true);
		webview1.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
		webview1.getSettings().setDomStorageEnabled(true);
		webview1.getSettings().setSaveFormData(true);
		webview1.setDownloadListener(new DownloadListener() {
			public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
				FileName = URLUtil.guessFileName(url, contentDisposition, mimetype);
				new DownloadFile().execute(Uri.parse(url).toString());
			}});
		
		
		
	}
	private ProgressDialog mProgressDialog;
	private java.io.File PathDir = Environment.getExternalStorageDirectory();
	private String PathName = "Downloads_File";
	private String FileName = "";
	private class DownloadFile extends AsyncTask<String, Integer, String> {
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			checkAndCreateDirectory(PathName);
			mProgressDialog = new ProgressDialog(WebActivity.this);
			mProgressDialog.setTitle(FileName);
			mProgressDialog.setMessage("Downloading " + FileName + ". Please wait...");
			mProgressDialog.setIndeterminate(false);
			mProgressDialog.setMax(100);
			mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			mProgressDialog.show();
		}
		@Override
		protected String doInBackground(String... Url) {
			try {
				java.net.URL url = new java.net.URL(Url[0]);
				java.net.URLConnection connection = url.openConnection();
				connection.connect();
				int fileLength = connection.getContentLength();
				//String filepath = Environment.getExternalStorageDirectory().getPath();
				java.io.InputStream input = new java.io.BufferedInputStream(url.openStream());
				java.io.OutputStream output = new java.io.FileOutputStream(PathDir + "/" + PathName + "/" + FileName);
				byte data[] = new byte[1024];
				long total = 0;
				int count;
				while ((count = input.read(data)) != -1) {
					total += count;
					publishProgress((int) (total * 100 / fileLength));
					output.write(data, 0, count);
				}
				output.flush();
				output.close();
				input.close();
			} catch (Exception e) {
				showMessage(e.getMessage().toString());
				e.printStackTrace();
			}
			return null;
		}
		@Override
		protected void onProgressUpdate(Integer... progress) {
			super.onProgressUpdate(progress);
			mProgressDialog.setProgress(progress[0]);
		}
		@Override
		protected void onPostExecute(String unused) {
			mProgressDialog.dismiss();
			showMessage("Download Complite");
		}
	}
	public void checkAndCreateDirectory(String PathName){
		java.io.File new_dir = new java.io.File(PathDir + "/" + PathName);
		if (!new_dir.exists()){
			new_dir.mkdirs();
		}
		webview1.setOnTouchListener(new View.OnTouchListener() {
			Boolean tF;
			@Override public boolean onTouch(View v, MotionEvent event) {
				showMessage("Aan");
				tF = true;
				switch (event.getAction()) {
					case MotionEvent.ACTION_DOWN: tF = false;
					showMessage("0");
				}
				return tF;
			}
		});
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		//Speed Webview
		webview1.getSettings().setAppCacheMaxSize(5*1024*1024); 
		webview1.getSettings().setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath()); 
		webview1.getSettings().setAllowFileAccess(true);
		webview1.getSettings().setAppCacheEnabled(true);
		webview1.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		webview1.getSettings().setLoadWithOverviewMode(true);
		webview1.getSettings().setUseWideViewPort(true);
		webview1.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
		webview1.getSettings().setDomStorageEnabled(true);
		webview1.getSettings().setSaveFormData(true);
		 /*
final androidx.swiperefreshlayout.widget sr = new androidx.swiperefreshlayout.widget(this);
sr.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT, android.widget.LinearLayout.LayoutParams.MATCH_PARENT));
linear1.addView(sr);
final WebView wb = new WebView(this);
wb.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT, android.widget.LinearLayout.LayoutParams.MATCH_PARENT));
wb.getSettings().setJavaScriptEnabled(true);
sr.addView(wb);
wb.setWebViewClient(new WebViewClient() { public void onPageFinished(WebView view, String url) { sr.setRefreshing(false);
}}); 
sr.setOnRefreshListener( new androidx.swiperefreshlayout.widget.OnRefreshListener() { @Override public void onRefresh() { wb.reload(); } } );

*/
		//Progress
		final android.widget.ProgressBar prog = new android.widget.ProgressBar(this,null, android.R.attr.progressBarStyleHorizontal);
		prog.setPadding(0,0,0,0);
		prog.setIndeterminate(false);
		prog.setFitsSystemWindows(true);
		prog.setProgress(0);
		prog.setScrollBarStyle(android.widget.ProgressBar.SCROLLBARS_OUTSIDE_INSET);
		prog.setMax(100);
		ViewGroup.LayoutParams vlp = new ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		prog.setLayoutParams(vlp);
		pl.addView(prog);
		webview1.setWebChromeClient(new WebChromeClient() {
			@Override public void onProgressChanged(WebView view, int newProgress) {
				prog.setProgress(newProgress);
			}
		});
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