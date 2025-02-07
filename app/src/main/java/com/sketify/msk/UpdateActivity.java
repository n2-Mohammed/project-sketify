package com.sketify.msk;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Context;
import android.content.Intent;
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
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.firebase.FirebaseApp;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class UpdateActivity extends AppCompatActivity {
	
	private String dr_link = "";
	private String url = "";
	
	private ScrollView vscroll1;
	private LinearLayout linear10;
	private LinearLayout linear1;
	private LinearLayout linear5;
	private ImageView imageview3;
	private LinearLayout linear2;
	private LinearLayout linear8;
	private LinearLayout linear4;
	private LinearLayout linear9;
	private LinearLayout linear7;
	private TextView textview7;
	private TextView textview3;
	private ImageView imageview2;
	private TextView version;
	private TextView textview6;
	private TextView updates;
	private Button button1;
	
	private Intent direct = new Intent();
	private Vibrator v;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.update);
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
		vscroll1 = findViewById(R.id.vscroll1);
		linear10 = findViewById(R.id.linear10);
		linear1 = findViewById(R.id.linear1);
		linear5 = findViewById(R.id.linear5);
		imageview3 = findViewById(R.id.imageview3);
		linear2 = findViewById(R.id.linear2);
		linear8 = findViewById(R.id.linear8);
		linear4 = findViewById(R.id.linear4);
		linear9 = findViewById(R.id.linear9);
		linear7 = findViewById(R.id.linear7);
		textview7 = findViewById(R.id.textview7);
		textview3 = findViewById(R.id.textview3);
		imageview2 = findViewById(R.id.imageview2);
		version = findViewById(R.id.version);
		textview6 = findViewById(R.id.textview6);
		updates = findViewById(R.id.updates);
		button1 = findViewById(R.id.button1);
		v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		
		textview7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				direct.setAction(Intent.ACTION_VIEW);
				direct.setData(Uri.parse(dr_link));
				startActivity(direct);
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!FileUtil.isExistFile("/Sketify/Latest")) {
					FileUtil.makeDir("/Sketify/Latest");
				}
				_Download_InstallApp(url, "/Sketify/Latest/", "/Sketify/Latest/".concat(URLUtil.guessFileName(url, null, null)));
			}
		});
	}
	
	private void initializeLogic() {
		v.vibrate((long)(400));
		url = getIntent().getStringExtra("url");
		dr_link = getIntent().getStringExtra("dr_link");
		version.setText(getIntent().getStringExtra("version"));
		updates.setText(getIntent().getStringExtra("updates"));
		updates.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 0);
		version.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 1);
		button1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 1);
		textview7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 0);
	}
	
	public void _Download_InstallApp(final String _url, final String _path, final String _install) {
		FileUtil.makeDir(FileUtil.getPackageDataDir(getApplicationContext()));
		android.net.ConnectivityManager connMgr = (android.net.ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
		android.net.NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		if (networkInfo != null && networkInfo.isConnected()) {
			
			
			final String urlDownload = _url;
			
			DownloadManager.Request request = new DownloadManager.Request(Uri.parse(urlDownload));
			
			final String fileName = URLUtil.guessFileName(urlDownload, null, null);
			
			request.setDescription("Updating");
			
			request.setTitle("Updating Sketify");
			
			request.allowScanningByMediaScanner();
			
			request.setDestinationInExternalPublicDir(_path, fileName);
			
			final DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
			
			final long downloadId = manager.enqueue(request);
			
			final ProgressDialog prog = new ProgressDialog(this);
			prog.setMax(100);
			prog.setIndeterminate(true);
			prog.setCancelable(false);
			prog.setCanceledOnTouchOutside(false);
			prog.setTitle("Update");
			
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
								
								prog.setTitle("Loading Data");
								prog.setMessage("Upgrading Version NEW\n\n Ratio —  " + dl_progress + "/100 \n\n");
								prog.show();
								if (dl_progress == 100) {
									
									prog.dismiss();
									
									showMessage("Install The Apk");
									
									StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
									Intent intent = new Intent(Intent.ACTION_INSTALL_PACKAGE);
									intent.setData(Uri.fromFile(new java.io.File(Environment.getExternalStorageDirectory(), _install)));
									startActivity(intent);
								}
								
							} });
					} } }).start();
			
			
		} else {
			showMessage("No Internet Connection.");
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