package com.sketify.msk;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.ClipData;
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
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
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
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.FirebaseApp;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.text.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class ProjectManagerActivity extends AppCompatActivity {
	
	public final int REQ_CD_FP = 101;
	
	private Timer _timer = new Timer();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private String SK_Manager_Path = "";
	private String sketchware_path = "";
	private String new_id = "";
	private HashMap<String, Object> clo_temp = new HashMap<>();
	private String output = "";
	private double number = 0;
	private HashMap<String, Object> temp_map1 = new HashMap<>();
	private String temp_decrypted = "";
	private String FONT = "";
	private String decrypted = "";
	private String encrypted = "";
	private boolean projectManager = false;
	private String info_text = "";
	private boolean bottomOpen = false;
	private boolean confirmationOpen = false;
	private boolean restore = false;
	private boolean rest = false;
	private String restoreId = "";
	private String sketifyDirectory = "";
	private String Name = "";
	private String path = "";
	private double restore_position = 0;
	private double temp_num = 0;
	private double n = 0;
	private String output_filename = "";
	private double n_filename = 0;
	private double B = 0;
	private double KB = 0;
	private double MB = 0;
	private double GB = 0;
	private double TB = 0;
	private double PB = 0;
	private boolean sk_apk = false;
	private boolean androidstudioapk = false;
	private String apk_size = "";
	private boolean sk_project = false;
	private boolean android_studii = false;
	private String project_size = "";
	private String tempPath = "";
	private String file_size = "";
	private boolean error = false;
	
	private ArrayList<String> temp_str1 = new ArrayList<>();
	private ArrayList<String> copy_list = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> temp_listmap1 = new ArrayList<>();
	private ArrayList<String> temp = new ArrayList<>();
	private ArrayList<String> skList = new ArrayList<>();
	private ArrayList<String> templiststring = new ArrayList<>();
	
	private LinearLayout linear1;
	private ListView listview1;
	private TextView textview1;
	
	private TimerTask timer;
	private Intent fp = new Intent(Intent.ACTION_GET_CONTENT);
	private AlertDialog.Builder dialog;
	private SharedPreferences export;
	private Intent fpick = new Intent();
	private SharedPreferences file;
	private SharedPreferences transferdata;
	private Intent intent = new Intent();
	private SharedPreferences settings;
	private TimerTask t;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.project_manager);
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
		linear1 = findViewById(R.id.linear1);
		listview1 = findViewById(R.id.listview1);
		textview1 = findViewById(R.id.textview1);
		fp.setType("*/*");
		fp.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		dialog = new AlertDialog.Builder(this);
		export = getSharedPreferences("export", Activity.MODE_PRIVATE);
		file = getSharedPreferences("file", Activity.MODE_PRIVATE);
		transferdata = getSharedPreferences("transferdata", Activity.MODE_PRIVATE);
		settings = getSharedPreferences("settings", Activity.MODE_PRIVATE);
	}
	
	private void initializeLogic() {
		textview1.setVisibility(View.GONE);
		SK_Manager_Path = FileUtil.getExternalStorageDir().concat("/Android/data/com.sketify.msk/");
		sketchware_path = FileUtil.getExternalStorageDir().concat("/.sketchware/");
		sketifyDirectory = FileUtil.getExternalStorageDir().concat("/Sketify/");
		if (!FileUtil.isExistFile(SK_Manager_Path)) {
			FileUtil.makeDir(SK_Manager_Path);
		}
		_extra();
		if (getIntent().getStringExtra("mode").equals("project")) {
			projectManager = true;
			setTitle("Project Manager");
		}
		if (getIntent().getStringExtra("mode").equals("export")) {
			projectManager = false;
			setTitle("Sketchware Projects");
		}
		if (getIntent().getStringExtra("mode").equals("transfer")) {
			_RestoreProject(SK_Manager_Path.concat(".project/".concat("temp.zip")));
		}
		_Refresh();
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_FP:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				_Rest(_filePath.get((int)(0)));
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (!file.getString("picked_path", "").equals("")) {
			if (restore) {
				file.edit().putString("picked_path", "").commit();
				_Restore(file.getString("picked_path", ""));
			}
			else {
				if (rest) {
					_Rest(file.getString("picked_path", ""));
					file.edit().putString("picked_path", "").commit();
				}
			}
		}
		restoreId = "";
		restore = false;
		rest = false;
	}
	public void _Encrypt(final String _path) {
		try {
			javax.crypto.Cipher instance = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
			byte[] bytes = "sketchwaresecure".getBytes();
			instance.init(1, new javax.crypto.spec.SecretKeySpec(bytes, "AES"), new javax.crypto.spec.IvParameterSpec(bytes));
			new java.io.RandomAccessFile(_path, "rw").write(instance.doFinal(output.getBytes()));
		} catch(Exception e) {
			showMessage(e.toString());
		}
	}
	
	
	public void _Decrypt(final String _path) {
		try {
			javax.crypto.Cipher instance = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
			byte[] bytes = "sketchwaresecure".getBytes();
			instance.init(2, new javax.crypto.spec.SecretKeySpec(bytes, "AES"), new javax.crypto.spec.IvParameterSpec(bytes));
			java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(_path, "r");
			byte[] bArr = new byte[((int) randomAccessFile.length())];
			randomAccessFile.readFully(bArr);
			output = new String(instance.doFinal(bArr));
		} catch(Exception e) {
			showMessage(e.toString());
		}
	}
	
	
	public void _Clone(final String _ID) {
		new AsyncTask<String, String, String>() {
			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				_ProgresbarShow("Cloneing...");
			}
			@Override
			protected String doInBackground(String... arg0) {
				try {
					_New_ID_Generation();
					FileUtil.makeDir(sketchware_path.concat("data/".concat(String.valueOf((long)(restore_position)))));
					FileUtil.makeDir(sketchware_path.concat("mysc/list/".concat(String.valueOf((long)(restore_position)))));
					FileUtil.makeDir(sketchware_path.concat("resources/fonts/".concat(String.valueOf((long)(restore_position)))));
					FileUtil.makeDir(sketchware_path.concat("resources/icons/".concat(String.valueOf((long)(restore_position)))));
					FileUtil.makeDir(sketchware_path.concat("resources/images/".concat(String.valueOf((long)(restore_position)))));
					FileUtil.makeDir(sketchware_path.concat("resources/sounds/".concat(String.valueOf((long)(restore_position)))));
					_Copy(sketchware_path.concat("data/".concat(_ID)), sketchware_path.concat("data/".concat(String.valueOf((long)(restore_position)))));
					_Copy(sketchware_path.concat("mysc/list/".concat(_ID)), sketchware_path.concat("mysc/list/".concat(String.valueOf((long)(restore_position)))));
					_Copy(sketchware_path.concat("resources/fonts/".concat(_ID)), sketchware_path.concat("resources/fonts/".concat(String.valueOf((long)(restore_position)))));
					_Copy(sketchware_path.concat("resources/icons/".concat(_ID)), sketchware_path.concat("resources/icons/".concat(String.valueOf((long)(restore_position)))));
					_Copy(sketchware_path.concat("resources/images/".concat(_ID)), sketchware_path.concat("resources/images/".concat(String.valueOf((long)(restore_position)))));
					_Copy(sketchware_path.concat("resources/sounds/".concat(_ID)), sketchware_path.concat("resources/sounds/".concat(String.valueOf((long)(restore_position)))));
					_Decrypt(sketchware_path.concat("mysc/list/".concat(String.valueOf((long)(restore_position)).concat("/project"))));
					clo_temp = new HashMap<>();
					clo_temp = new Gson().fromJson(output, new TypeToken<HashMap<String, Object>>(){}.getType());
					clo_temp.put("sc_id", String.valueOf((long)(restore_position)));
					output = new Gson().toJson(clo_temp);
					_Encrypt(sketchware_path.concat("mysc/list/".concat(String.valueOf((long)(restore_position)).concat("/project"))));
				} catch(Exception e) {}
				return null;
			}
			@Override
			protected void onPostExecute(String result) {
				super.onPostExecute(result);
				if (settings.getString("faster", "").equals("false")) {
					timer = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									SketchwareUtil.showMessage(getApplicationContext(), "$Project Cloned");
									_Refresh();
								}
							});
						}
					};
					_timer.schedule(timer, (int)(999));
				}
				else {
					timer = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									_ProgresbarDimiss();
									SketchwareUtil.showMessage(getApplicationContext(), "$Project Cloned");
									_Refresh();
								}
							});
						}
					};
					_timer.schedule(timer, (int)(500));
				}
			} 
		}.execute();
	}
	
	
	public void _Copy(final String _F, final String _T) {
		FileUtil.makeDir(_T.concat("/"));
		copy_list.clear();
		FileUtil.listDir(_F.concat("/"), copy_list);
		number = 0;
		for(int _repeat11 = 0; _repeat11 < (int)(copy_list.size()); _repeat11++) {
			if (FileUtil.isFile(copy_list.get((int)(number)))) {
				FileUtil.copyFile(copy_list.get((int)(number)), _T.concat("/".concat(Uri.parse(copy_list.get((int)(number))).getLastPathSegment())));
			}
			number++;
		}
	}
	
	
	public void _Load_Projects() {
		temp_str1.clear();
		temp_listmap1.clear();
		temp_map1.clear();
		FileUtil.listDir(FileUtil.getExternalStorageDir().concat("/.sketchware/mysc/list/"), temp_str1);
		Collections.sort(temp_str1, String.CASE_INSENSITIVE_ORDER);
		number = 0;
		for(int _repeat18 = 0; _repeat18 < (int)(temp_str1.size()); _repeat18++) {
			if (FileUtil.isExistFile(FileUtil.getExternalStorageDir().concat("/.sketchware/mysc/list/".concat(Uri.parse(temp_str1.get((int)(number))).getLastPathSegment().concat("/project"))))) {
				try {
					javax.crypto.Cipher instance = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
					byte[] bytes = "sketchwaresecure".getBytes();
					instance.init(2, new javax.crypto.spec.SecretKeySpec(bytes, "AES"), new javax.crypto.spec.IvParameterSpec(bytes));
					java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(FileUtil.getExternalStorageDir().concat("/.sketchware/mysc/list/".concat(Uri.parse(temp_str1.get((int)(number))).getLastPathSegment().concat("/project"))), "r");
					byte[] bArr = new byte[((int) randomAccessFile.length())];
					randomAccessFile.readFully(bArr);
					temp_decrypted = new String(instance.doFinal(bArr));
					temp_map1 = new HashMap<>();
					temp_map1 = new Gson().fromJson(temp_decrypted, new TypeToken<HashMap<String, Object>>(){}.getType());
					temp_listmap1.add(temp_map1);
				} catch(Exception e) {
					showMessage(e.toString());
				}
			}
			number++;
		}
		Collections.reverse(temp_listmap1);
	}
	
	
	public void _zip(final String _source, final String _destination) {
		FileUtil.writeFile("Don't Remove it Thanks.\nModified By: Manish Nirmal", "This Block Added for Manage Permission");
		try {
			java.util.zip.ZipOutputStream os = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(_destination));
					zip(os, _source, null);
					os.close();
		}
		
		catch(java.io.IOException e) {}
	}
	private void zip(java.util.zip.ZipOutputStream os, String filePath, String name) throws java.io.IOException
		{
				java.io.File file = new java.io.File(filePath);
				java.util.zip.ZipEntry entry = new java.util.zip.ZipEntry((name != null ? name + java.io.File.separator : "") + file.getName() + (file.isDirectory() ? java.io.File.separator : ""));
				os.putNextEntry(entry);
				
				if(file.isFile()) {
						java.io.InputStream is = new java.io.FileInputStream(file);
						int size = is.available();
						byte[] buff = new byte[size];
						int len = is.read(buff);
						os.write(buff, 0, len);
						return;
				}
				
				java.io.File[] fileArr = file.listFiles();
				for(java.io.File subFile : fileArr) {
						zip(os, subFile.getAbsolutePath(), entry.getName());
				}
	}
	
	
	public void _UnZip(final String _fileZip, final String _destDir) {
		try
		{
			java.io.File outdir = new java.io.File(_destDir);
			java.util.zip.ZipInputStream zin = new java.util.zip.ZipInputStream(new java.io.FileInputStream(_fileZip));
			java.util.zip.ZipEntry entry;
			String name, dir;
			while ((entry = zin.getNextEntry()) != null)
			{
				name = entry.getName();
				if(entry.isDirectory())
				{
					mkdirs(outdir, name);
					continue;
				}
				
				/* this part is necessary because file entry can come before
* directory entry where is file located
* i.e.:
* /foo/foo.txt
* /foo/
*/
				
				dir = dirpart(name);
				if(dir != null)
				mkdirs(outdir, dir);
				
				extractFile(zin, outdir, name);
			}
			zin.close();
		}
		catch (java.io.IOException e)
		{
			e.printStackTrace();
		}
	}
	private static void extractFile(java.util.zip.ZipInputStream in, java.io.File outdir, String name) throws java.io.IOException
	{
		byte[] buffer = new byte[4096];
		java.io.BufferedOutputStream out = new java.io.BufferedOutputStream(new java.io.FileOutputStream(new java.io.File(outdir, name)));
		int count = -1;
		while ((count = in.read(buffer)) != -1)
		out.write(buffer, 0, count);
		out.close();
	}
	
	private static void mkdirs(java.io.File outdir, String path)
	{
		java.io.File d = new java.io.File(outdir, path);
		if(!d.exists())
		d.mkdirs();
	}
	
	private static String dirpart(String name)
	{
		int s = name.lastIndexOf(java.io.File.separatorChar);
		return s == -1 ? null : name.substring(0, s);
	}
	
	
	public void _ProgresbarShow(final String _title) {
		prog = new ProgressDialog(ProjectManagerActivity.this);
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
	
	
	public void _Elevation(final View _view, final double _number) {
		
		_view.setElevation((int)_number);
	}
	
	
	public void _Create_Spannbale(final String _text) {
		s = new SpannableString(_text);
	}
	
	
	public void _Spannable_Bold(final double _n, final double _n1) {
		s.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), (int)_n, (int)_n1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
	}
	
	
	public void _Encrypt_String(final String _str) {
		try {
			javax.crypto.SecretKey key = generateKey("skmanager!secure"); 
			javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("AES"); 
			c.init(javax.crypto.Cipher.ENCRYPT_MODE, key); 
			byte[] encVal = c.doFinal(_str.getBytes());
			encrypted = android.util.Base64.encodeToString(encVal,android.util.Base64.DEFAULT);
		} catch (Exception ex) {
		}
	}
	
	
	public void _Decrypt_String(final String _str) {
		try {
			javax.crypto.spec.SecretKeySpec key = (javax.crypto.spec.SecretKeySpec) generateKey("skmanager!secure");
			javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("AES");
			c.init(javax.crypto.Cipher.DECRYPT_MODE, key); 
			byte[] decode = android.util.Base64.decode(_str, android.util.Base64.DEFAULT); 
			byte[] decval = c.doFinal(decode);
			decrypted = new String(decval); 
		} catch (Exception ex) {
		}
	}
	
	
	public void _Refresh() {
		new AsyncTask<String, String, String>() {
			@Override
			protected void onPreExecute() {
				super.onPreExecute();
			}
			@Override
			protected String doInBackground(String... arg0) {
				try {
					_Load_Projects();
				} catch(Exception e) {}
				return null;
			}
			@Override
			protected void onPostExecute(String result) {
				super.onPostExecute(result);
				listview1.setAdapter(new Listview1Adapter(temp_listmap1));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				if (temp_listmap1.size() == 0) {
					listview1.setVisibility(View.GONE);
					textview1.setVisibility(View.VISIBLE);
				}
				else {
					listview1.setVisibility(View.VISIBLE);
					textview1.setVisibility(View.GONE);
				}
			} 
		}.execute();
	}
	
	
	public void _AES_Library() {
	}
	private javax.crypto.SecretKey generateKey(String pwd) throws Exception {
		
		final java.security.MessageDigest digest = java.security.MessageDigest.getInstance("SHA-256");
		
		byte[] b = pwd.getBytes("UTF-8");
		
		digest.update(b,0,b.length);
		
		byte[] key = digest.digest();
		
		javax.crypto.spec.SecretKeySpec sec = new javax.crypto.spec.SecretKeySpec(key, "AES");
		
		return sec;
	}
	
	
	public void _extra() {
	}
	private ProgressDialog prog;
	private SpannableString s;
	{
	}
	
	
	public void _Rest(final String _ID) {
		new AsyncTask<String, String, String>() {
			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				_ProgresbarShow("Restoring...");
			}
			@Override
			protected String doInBackground(String... arg0) {
				try {
					path = _ID;
					Name = Uri.parse(_ID).getLastPathSegment();
					_RenameFileDirectory(_ID, Uri.parse(_ID).getLastPathSegment(), "temp.zip");
					if (FileUtil.isExistFile(SK_Manager_Path.concat("backups/".concat("temp")))) {
						FileUtil.deleteFile(SK_Manager_Path.concat("backups/".concat("temp")));
					}
					_UnZip(_ID.replace(Uri.parse(_ID).getLastPathSegment(), "temp.zip"), SK_Manager_Path.concat("backups/"));
					if (FileUtil.isExistFile(SK_Manager_Path.concat("backups/temp/").concat("/resources/sounds/")) && (FileUtil.isExistFile(SK_Manager_Path.concat("backups/temp/").concat("/resources/images/")) && (FileUtil.isExistFile(SK_Manager_Path.concat("backups/temp/").concat("/resources/icons")) && (FileUtil.isExistFile(SK_Manager_Path.concat("backups/temp/").concat("/resources/fonts")) && (FileUtil.isExistFile(SK_Manager_Path.concat("backups/temp/").concat("/mysc/list/")) && FileUtil.isExistFile(SK_Manager_Path.concat("backups/temp/").concat("data/"))))))) {
						error = false;
						_New_ID_Generation();
						new_id = String.valueOf((long)(restore_position));
						FileUtil.makeDir(sketchware_path.concat("data/".concat(String.valueOf((long)(restore_position)))));
						FileUtil.makeDir(sketchware_path.concat("mysc/list/".concat(String.valueOf((long)(restore_position)))));
						FileUtil.makeDir(sketchware_path.concat("resources/fonts/".concat(String.valueOf((long)(restore_position)))));
						FileUtil.makeDir(sketchware_path.concat("resources/icons/".concat(String.valueOf((long)(restore_position)))));
						FileUtil.makeDir(sketchware_path.concat("resources/images/".concat(String.valueOf((long)(restore_position)))));
						FileUtil.makeDir(sketchware_path.concat("resources/sounds/".concat(String.valueOf((long)(restore_position)))));
						_Copy(SK_Manager_Path.concat("backups/temp/").concat("data/"), sketchware_path.concat("data/".concat(new_id.concat("/"))));
						_Copy(SK_Manager_Path.concat("backups/temp/").concat("/mysc/list/"), sketchware_path.concat("mysc/list/".concat(new_id.concat("/"))));
						_Copy(SK_Manager_Path.concat("backups/temp/").concat("/resources/fonts"), sketchware_path.concat("resources/fonts/".concat(new_id.concat("/"))));
						_Copy(SK_Manager_Path.concat("backups/temp/").concat("/resources/icons"), sketchware_path.concat("resources/icons/".concat(new_id.concat("/"))));
						_Copy(SK_Manager_Path.concat("backups/temp/").concat("/resources/images/"), sketchware_path.concat("resources/images/".concat(new_id.concat("/"))));
						_Copy(SK_Manager_Path.concat("backups/temp/").concat("/resources/sounds/"), sketchware_path.concat("resources/sounds/".concat(new_id.concat("/"))));
						_Decrypt(sketchware_path.concat("mysc/list/".concat(new_id.concat("/project"))));
						clo_temp = new HashMap<>();
						clo_temp = new Gson().fromJson(output, new TypeToken<HashMap<String, Object>>(){}.getType());
						clo_temp.put("sc_id", new_id);
						output = new Gson().toJson(clo_temp);
						_Encrypt(sketchware_path.concat("mysc/list/".concat(new_id.concat("/project"))));
					}
					else {
						error = true;
						_ProgresbarDimiss();
						_RenameFileDirectory(_ID.replace(Uri.parse(_ID).getLastPathSegment(), "temp.zip"), "temp.zip", Name);
						new_id = "";
						_Refresh();
						SketchwareUtil.showMessage(getApplicationContext(), "An Error Occured!");
					}
				} catch(Exception e) {}
				return null;
			}
			@Override
			protected void onPostExecute(String result) {
				super.onPostExecute(result);
				if (!error) {
					timer = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									_ProgresbarDimiss();
									_RenameFileDirectory(_ID.replace(Uri.parse(_ID).getLastPathSegment(), "temp.zip"), "temp.zip", Name);
									new_id = "";
									_Refresh();
									SketchwareUtil.showMessage(getApplicationContext(), "New Project Created!");
								}
							});
						}
					};
					_timer.schedule(timer, (int)(999));
				}
			} 
		}.execute();
	}
	
	
	public void _gd(final View _view, final double _numb, final String _color) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		gd.setCornerRadius((int)_numb);
		_view.setBackground(gd);
	}
	
	
	public void _Save(final String _ID, final String _NAME) {
		new AsyncTask<String, String, String>() {
			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				_ProgresbarShow("Exporting...");
			}
			@Override
			protected String doInBackground(String... arg0) {
				try {
					_antiDuplicateName(FileUtil.getExternalStorageDir().concat("/Sketify/".concat("SW Projects/")), _NAME, ".sk");
					if (FileUtil.isExistFile(SK_Manager_Path.concat(".backups/".concat("temp")))) {
						FileUtil.deleteFile(SK_Manager_Path.concat(".backups/".concat("temp")));
					}
					FileUtil.makeDir(SK_Manager_Path.concat(".backups/".concat("temp".concat("/data/"))));
					FileUtil.makeDir(SK_Manager_Path.concat(".backups/".concat("temp".concat("/mysc/list/"))));
					FileUtil.makeDir(SK_Manager_Path.concat(".backups/".concat("temp".concat("/resources/fonts/"))));
					FileUtil.makeDir(SK_Manager_Path.concat(".backups/".concat("temp".concat("/resources/icons/"))));
					FileUtil.makeDir(SK_Manager_Path.concat(".backups/".concat("temp".concat("/resources/images/"))));
					FileUtil.makeDir(SK_Manager_Path.concat(".backups/".concat("temp".concat("/resources/sounds/"))));
					_Copy(sketchware_path.concat("data/".concat(_ID)), SK_Manager_Path.concat(".backups/".concat("temp".concat("/data/"))));
					_Copy(sketchware_path.concat("mysc/list/".concat(_ID)), SK_Manager_Path.concat(".backups/".concat("temp".concat("/mysc/list/"))));
					_Copy(sketchware_path.concat("resources/fonts/".concat(_ID)), SK_Manager_Path.concat(".backups/".concat("temp".concat("/resources/fonts/"))));
					_Copy(sketchware_path.concat("resources/icons/".concat(_ID)), SK_Manager_Path.concat(".backups/".concat("temp".concat("/resources/icons/"))));
					_Copy(sketchware_path.concat("resources/images/".concat(_ID)), SK_Manager_Path.concat(".backups/".concat("temp".concat("/resources/images/"))));
					_Copy(sketchware_path.concat("resources/sounds/".concat(_ID)), SK_Manager_Path.concat(".backups/".concat("temp".concat("/resources/sounds/"))));
					if (!FileUtil.isExistFile(FileUtil.getExternalStorageDir().concat("/Sketify/".concat("SW Projects")))) {
						FileUtil.makeDir(FileUtil.getExternalStorageDir().concat("/Sketify/".concat("SW Projects")));
					}
					_zip(SK_Manager_Path.concat(".backups/".concat("temp")), FileUtil.getExternalStorageDir().concat("/Sketify/".concat("SW Projects/")).concat(output_filename));
				} catch(Exception e) {}
				return null;
			}
			@Override
			protected void onPostExecute(String result) {
				super.onPostExecute(result);
				timer = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_ProgresbarDimiss();
								FileUtil.deleteFile(SK_Manager_Path.concat(".backups"));
								FileUtil.deleteFile(SK_Manager_Path.concat(".exporter"));
								_Share(FileUtil.getExternalStorageDir().concat("/Sketify/".concat("SW Projects/")).concat(output_filename), "Share");
								_Refresh();
								SketchwareUtil.showMessage(getApplicationContext(), "#Project Saved");
							}
						});
					}
				};
				_timer.schedule(timer, (int)(999));
			} 
		}.execute();
	}
	
	
	public void _Export(final String _ID, final String _NAME) {
		new AsyncTask<String, String, String>() {
			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				_ProgresbarShow("Exporting...");
			}
			@Override
			protected String doInBackground(String... arg0) {
				try {
					if (FileUtil.isExistFile(SK_Manager_Path.concat(".backups/".concat("temp")))) {
						FileUtil.deleteFile(SK_Manager_Path.concat(".backups/".concat("temp")));
					}
					FileUtil.makeDir(SK_Manager_Path.concat(".backups/".concat("temp".concat("/data/"))));
					FileUtil.makeDir(SK_Manager_Path.concat(".backups/".concat("temp".concat("/mysc/list/"))));
					FileUtil.makeDir(SK_Manager_Path.concat(".backups/".concat("temp".concat("/resources/fonts/"))));
					FileUtil.makeDir(SK_Manager_Path.concat(".backups/".concat("temp".concat("/resources/icons/"))));
					FileUtil.makeDir(SK_Manager_Path.concat(".backups/".concat("temp".concat("/resources/images/"))));
					FileUtil.makeDir(SK_Manager_Path.concat(".backups/".concat("temp".concat("/resources/sounds/"))));
					_Copy(sketchware_path.concat("data/".concat(_ID)), SK_Manager_Path.concat(".backups/".concat("temp".concat("/data/"))));
					_Copy(sketchware_path.concat("mysc/list/".concat(_ID)), SK_Manager_Path.concat(".backups/".concat("temp".concat("/mysc/list/"))));
					_Copy(sketchware_path.concat("resources/fonts/".concat(_ID)), SK_Manager_Path.concat(".backups/".concat("temp".concat("/resources/fonts/"))));
					_Copy(sketchware_path.concat("resources/icons/".concat(_ID)), SK_Manager_Path.concat(".backups/".concat("temp".concat("/resources/icons/"))));
					_Copy(sketchware_path.concat("resources/images/".concat(_ID)), SK_Manager_Path.concat(".backups/".concat("temp".concat("/resources/images/"))));
					_Copy(sketchware_path.concat("resources/sounds/".concat(_ID)), SK_Manager_Path.concat(".backups/".concat("temp".concat("/resources/sounds/"))));
					if (!FileUtil.isExistFile(SK_Manager_Path.concat(".exported"))) {
						FileUtil.makeDir(SK_Manager_Path.concat(".exported"));
					}
					_zip(SK_Manager_Path.concat(".backups/".concat("temp")), SK_Manager_Path.concat(".exported/".concat("exported.sk")));
				} catch(Exception e) {}
				return null;
			}
			@Override
			protected void onPostExecute(String result) {
				super.onPostExecute(result);
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								FileUtil.deleteFile(SK_Manager_Path.concat(".backups"));
								export.edit().putString("exported", "true").commit();
								_ProgresbarDimiss();
								finish();
							}
						});
					}
				};
				_timer.schedule(t, (int)(999));
			} 
		}.execute();
	}
	
	
	public void _RestoreProject(final String _ID) {
		new AsyncTask<String, String, String>() {
			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				_ProgresbarShow("Transfering Project To Sketchware..");
			}
			@Override
			protected String doInBackground(String... arg0) {
				try {
					if (FileUtil.isExistFile(SK_Manager_Path.concat("backups/".concat("temp")))) {
						FileUtil.deleteFile(SK_Manager_Path.concat("backups/".concat("temp")));
					}
					_UnZip(_ID, SK_Manager_Path.concat("backups/"));
					_New_ID_Generation();
					new_id = String.valueOf((long)(restore_position));
					FileUtil.makeDir(sketchware_path.concat("data/".concat(new_id)));
					FileUtil.makeDir(sketchware_path.concat("mysc/list/".concat(new_id)));
					FileUtil.makeDir(sketchware_path.concat("resources/fonts/".concat(new_id)));
					FileUtil.makeDir(sketchware_path.concat("resources/icons/".concat(new_id)));
					FileUtil.makeDir(sketchware_path.concat("resources/images/".concat(new_id)));
					FileUtil.makeDir(sketchware_path.concat("resources/sounds/".concat(new_id)));
					_Copy(SK_Manager_Path.concat("backups/temp/").concat("data/".concat("")), sketchware_path.concat("data/".concat(new_id)));
					_Copy(SK_Manager_Path.concat("backups/temp/").concat("mysc/list/".concat("")), sketchware_path.concat("mysc/list/".concat(new_id)));
					_Copy(SK_Manager_Path.concat("backups/temp/").concat("resources/fonts/".concat("")), sketchware_path.concat("resources/fonts/".concat(new_id)));
					_Copy(SK_Manager_Path.concat("backups/temp/").concat("resources/icons/".concat("")), sketchware_path.concat("resources/icons/".concat(new_id)));
					_Copy(SK_Manager_Path.concat("backups/temp/").concat("resources/images/".concat("")), sketchware_path.concat("resources/images/".concat(new_id)));
					_Copy(SK_Manager_Path.concat("backups/temp/").concat("resources/sounds/".concat("")), sketchware_path.concat("resources/sounds/".concat(new_id)));
					_Decrypt(sketchware_path.concat("mysc/list/".concat(new_id.concat("/project"))));
					clo_temp = new HashMap<>();
					clo_temp = new Gson().fromJson(output, new TypeToken<HashMap<String, Object>>(){}.getType());
					clo_temp.put("sc_id", new_id);
					output = new Gson().toJson(clo_temp);
					_Encrypt(sketchware_path.concat("mysc/list/".concat(new_id.concat("/project"))));
				} catch(Exception e) {}
				return null;
			}
			@Override
			protected void onPostExecute(String result) {
				super.onPostExecute(result);
				timer = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_Refresh();
								timer = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												FileUtil.deleteFile(SK_Manager_Path.concat(".project"));
												FileUtil.deleteFile(SK_Manager_Path.concat(".exported"));
												FileUtil.deleteFile(SK_Manager_Path.concat("backups"));
												transferdata.edit().putString("transfer", "true").commit();
												_ProgresbarDimiss();
												finish();
											}
										});
									}
								};
								_timer.schedule(timer, (int)(2000));
							}
						});
					}
				};
				_timer.schedule(timer, (int)(1000));
				
			} 
		}.execute();
	}
	
	
	public void _RenameFileDirectory(final String _directory, final String _file1, final String _file2) {
		java.io.File directory = new java.io.File(path.substring(0, path.lastIndexOf("/"))); java.io.File oldfile = new java.io.File(_directory); java.io.File newfile = new java.io.File(directory, _file2); oldfile.renameTo(newfile);
	}
	
	
	public void _CreateIcon() {
	}
	@Override
	public boolean onCreateOptionsMenu (Menu menu){
		menu.add(0, 0, 0, "Refresh").setIcon(R.drawable.ic_plus_white).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()){
			case 0:
			fpick.setClass(getApplicationContext(), FilepicActivity.class);
			fpick.putExtra("extension", ".sk");
			startActivity(fpick);
			restore = false;
			rest = true;
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	public void _New_ID_Generation() {
		this.templiststring.clear();
		
		this.restore_position = 0.0d;
		
		this.temp_num = 0.0d;
		
		if (FileUtil.isExistFile(FileUtil.getExternalStorageDir().concat("/.sketchware/mysc/list/"))) {
			
			this.n = 0.0d;
			
			FileUtil.listDir(FileUtil.getExternalStorageDir().concat("/.sketchware/mysc/list/"), this.templiststring);
			
			int i = 0;
			
			while (true) {
				
				int i2 = i;
				
				if (i2 >= this.templiststring.size()) {
					
					this.templiststring.clear();
					
					return;
					
				}
				
				try {
					
					this.temp_num = Double.parseDouble(Uri.parse((String) this.templiststring.get((int) this.n)).getLastPathSegment());
					
				} catch (Exception e) {
					
				}
				
				if (this.restore_position < this.temp_num) {
					
					this.restore_position = this.temp_num + 1.0d;
					
				} else if (this.restore_position == this.temp_num) {
					
					this.restore_position += 1.0d;
					
				}
				
				this.n += 1.0d;
				
				i = i2 + 1;
				
			}
			
		} else {
			
			this.restore_position = 600.0d;
			
		}
		
		
		new_id = String.valueOf((long)(restore_position));
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
	
	
	public void _Share(final String _str1, final String _str2) {
		com.google.android.material.snackbar.Snackbar.make(linear1, "Your Project was Saved!", com.google.android.material.snackbar.Snackbar.LENGTH_INDEFINITE)
		.setAction("SHARE", new OnClickListener() {
				@Override
				public void onClick(View v) {
				intent = new Intent("android.intent.action.SEND");
				
				intent.setType("*/*");
				
				intent.putExtra("android.intent.extra.STREAM", Uri.parse(_str1));
				
				startActivity(Intent.createChooser(intent, _str2));
				
				return;
				}
		}).show();
	}
	
	
	public void _antiDuplicateName(final String _str, final String _str2, final String _str3) {
		if (!FileUtil.isExistFile(_str)) {
			
			FileUtil.makeDir(_str);
			
			this.output_filename = _str2.concat(_str3);
			
		} else if (FileUtil.isExistFile(_str.concat(_str2).concat(_str3))) {
			
			this.n_filename = 1.0d;
			
			while (FileUtil.isExistFile(_str.concat(_str2).concat(" (".concat(String.valueOf((long) this.n_filename).concat(") "))).concat(_str3))) {
				
				this.n_filename += 1.0d;
				
			}
			
			this.output_filename = _str2.concat(" (".concat(String.valueOf((long) this.n_filename).concat(") "))).concat(_str3);
			
		} else {
			
			this.output_filename = _str2.concat(_str3);
			
		}
		
		
	}
	
	
	public void _Restore(final String _ID) {
		new AsyncTask<String, String, String>() {
			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				_ProgresbarShow("Restoring...");
			}
			@Override
			protected String doInBackground(String... arg0) {
				try {
					if (!restoreId.equals("")) {
						path = _ID;
						Name = Uri.parse(_ID).getLastPathSegment();
						_RenameFileDirectory(_ID, Uri.parse(_ID).getLastPathSegment(), "temp.zip");
						if (FileUtil.isExistFile(SK_Manager_Path.concat("backups"))) {
							FileUtil.deleteFile(SK_Manager_Path.concat("backups"));
						}
						if (!FileUtil.isExistFile(SK_Manager_Path.concat("backups"))) {
							FileUtil.makeDir(SK_Manager_Path.concat("backups"));
						}
						_UnZip(_ID.replace(Uri.parse(_ID).getLastPathSegment(), "temp.zip"), SK_Manager_Path.concat("backups/"));
						_Copy(SK_Manager_Path.concat("backups/temp/").concat("data/"), sketchware_path.concat("data/".concat(restoreId)));
						_Copy(SK_Manager_Path.concat("backups/temp/").concat("/mysc/list/"), sketchware_path.concat("mysc/list/".concat(restoreId)));
						_Copy(SK_Manager_Path.concat("backups/temp/").concat("/resources/fonts"), sketchware_path.concat("resources/fonts/".concat(restoreId)));
						_Copy(SK_Manager_Path.concat("backups/temp/").concat("/resources/icons"), sketchware_path.concat("resources/icons/".concat(restoreId)));
						_Copy(SK_Manager_Path.concat("backups/temp/").concat("/resources/images/"), sketchware_path.concat("resources/images/".concat(restoreId)));
						_Copy(SK_Manager_Path.concat("backups/temp/").concat("/resources/sounds/"), sketchware_path.concat("resources/sounds/".concat(restoreId)));
						_Decrypt(sketchware_path.concat("mysc/list/".concat(restoreId.concat("/project"))));
						clo_temp = new HashMap<>();
						clo_temp = new Gson().fromJson(output, new TypeToken<HashMap<String, Object>>(){}.getType());
						clo_temp.put("sc_id", restoreId);
						output = new Gson().toJson(clo_temp);
						_Encrypt(sketchware_path.concat("mysc/list/".concat(restoreId.concat("/project"))));
					}
				} catch(Exception e) {}
				return null;
			}
			@Override
			protected void onPostExecute(String result) {
				super.onPostExecute(result);
				timer = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_ProgresbarDimiss();
								_RenameFileDirectory(_ID.replace(Uri.parse(_ID).getLastPathSegment(), "temp.zip"), "temp.zip", Name);
								restoreId = "";
								_Refresh();
								SketchwareUtil.showMessage(getApplicationContext(), "Restored Successfully!");
							}
						});
					}
				};
				_timer.schedule(timer, (int)(999));
			} 
		}.execute();
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
				_view = _inflater.inflate(R.layout.item, null);
			}
			
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final LinearLayout background = _view.findViewById(R.id.background);
			final LinearLayout top = _view.findViewById(R.id.top);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final LinearLayout confirmation = _view.findViewById(R.id.confirmation);
			final ImageView icon = _view.findViewById(R.id.icon);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final ImageView callpose = _view.findViewById(R.id.callpose);
			final TextView title = _view.findViewById(R.id.title);
			final LinearLayout bottom = _view.findViewById(R.id.bottom);
			final LinearLayout backup = _view.findViewById(R.id.backup);
			final LinearLayout restoree = _view.findViewById(R.id.restoree);
			final LinearLayout clone = _view.findViewById(R.id.clone);
			final LinearLayout info = _view.findViewById(R.id.info);
			final ImageView imageview3 = _view.findViewById(R.id.imageview3);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final ImageView imageview4 = _view.findViewById(R.id.imageview4);
			final TextView textview4 = _view.findViewById(R.id.textview4);
			final ImageView imageview5 = _view.findViewById(R.id.imageview5);
			final TextView textview5 = _view.findViewById(R.id.textview5);
			final ImageView imageview6 = _view.findViewById(R.id.imageview6);
			final TextView textview6 = _view.findViewById(R.id.textview6);
			final LinearLayout confirm = _view.findViewById(R.id.confirm);
			final ImageView imageview8 = _view.findViewById(R.id.imageview8);
			final TextView textview9 = _view.findViewById(R.id.textview9);
			
			try {
				imageview8.setColorFilter(Color.parseColor("#8BC34A"));
				_rippleRoundStroke(callpose, "#FFFFFF", "#BDBDBD", 50, 0, "#FFFFFF");
				_rippleRoundStroke(backup, "#FFFFFF", "#BDBDBD", 20, 3, "#FFFFFF");
				_rippleRoundStroke(info, "#FFFFFF", "#BDBDBD", 20, 3, "#FFFFFF");
				_rippleRoundStroke(restoree, "#FFFFFF", "#BDBDBD", 20, 3, "#FFFFFF");
				_rippleRoundStroke(clone, "#FFFFFF", "#BDBDBD", 20, 3, "#FFFFFF");
				_Elevation(background, 9);
				_rippleRoundStroke(background, "#FFFFFF", "#FFFFFF", 0, 0, "#EEEEEE");
				title.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/regular.ttf"), 0);
				bottom.setVisibility(View.GONE);
				confirmation.setVisibility(View.GONE);
				if (_data.get((int)_position).containsKey("sc_id")) {
					linear1.setVisibility(View.VISIBLE);
					if (_data.get((int)_position).containsKey("custom_icon")) {
						if (_data.get((int)_position).get("custom_icon").toString().equals("true")) {
							if (FileUtil.isExistFile(FileUtil.getExternalStorageDir().concat("/.sketchware/resources/icons/".concat(_data.get((int)_position).get("sc_id").toString().concat("/icon.png"))))) {
								if (BitmapFactory.decodeFile(FileUtil.getExternalStorageDir().concat("/.sketchware/resources/icons/".concat(_data.get((int)_position).get("sc_id").toString().concat("/icon.png")))) != null) {
									
									try {
										    
										icon.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(FileUtil.getExternalStorageDir().concat("/.sketchware/resources/icons/".concat(_data.get((int)_position).get("sc_id").toString().concat("/icon.png"))), 1024, 1024));
									} catch(Exception _e){
										    Log.e("try/catch error", _e.toString());
									}
								}
								else {
									icon.setImageResource(R.drawable.android_icon);
								}
							}
							else {
								icon.setImageResource(R.drawable.android_icon);
							}
						}
						else {
							icon.setImageResource(R.drawable.android_icon);
						}
					}
					else {
						icon.setImageResource(R.drawable.android_icon);
					}
					if (_data.get((int)_position).containsKey("my_app_name")) {
						title.setText(_data.get((int)_position).get("my_app_name").toString());
					}
				}
				else {
					linear1.setVisibility(View.GONE);
				}
				if (projectManager) {
					callpose.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View _view) {
							if (bottomOpen) {
								bottomOpen = false;
								bottom.setVisibility(View.GONE);
								confirmation.setVisibility(View.GONE);
								callpose.setImageResource(R.drawable.ic_arrow_drop_down_grey);
							}
							else {
								bottomOpen = true;
								callpose.setImageResource(R.drawable.ic_arrow_drop_up_grey);
								backup.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
										_Save(_data.get((int)_position).get("sc_id").toString(), _data.get((int)_position).get("my_ws_name").toString());
									}
								});
								restoree.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
										fpick.setClass(getApplicationContext(), FilepicActivity.class);
										fpick.putExtra("extension", ".sk");
										startActivity(fpick);
										restore = true;
										rest = false;
										restoreId = _data.get((int)_position).get("sc_id").toString();
									}
								});
								clone.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
										_Clone(_data.get((int)_position).get("sc_id").toString());
									}
								});
								info.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
										dialog.setTitle("Project Info");
										info_text = "App Name :\n%appname\n\nProject name : %projectname\n\nPackage :\n%package\n\nProject ID : %projectid\n\nVersion Name : %versionname\n\nVersion Code :\n%versioncode\n\n";
										info_text = info_text.replace("%appname", _data.get((int)_position).get("my_ws_name").toString());
										info_text = info_text.replace("%projectname", _data.get((int)_position).get("my_app_name").toString().trim());
										info_text = info_text.replace("%package", _data.get((int)_position).get("my_sc_pkg_name").toString().trim());
										info_text = info_text.replace("%projectid", _data.get((int)_position).get("sc_id").toString().trim());
										info_text = info_text.replace("%versionname", _data.get((int)_position).get("sc_ver_name").toString().trim());
										info_text = info_text.replace("%versioncode", _data.get((int)_position).get("sc_ver_code").toString().trim());
										_Create_Spannbale(info_text);
										_Spannable_Bold(info_text.indexOf("App Name :"), info_text.indexOf("App Name :") + 10);
										_Spannable_Bold(info_text.indexOf("Project name :"), info_text.indexOf("Project name :") + 14);
										_Spannable_Bold(info_text.indexOf("Package :"), info_text.indexOf("Package :") + 9);
										_Spannable_Bold(info_text.indexOf("Project ID :"), info_text.indexOf("Project ID :") + 12);
										_Spannable_Bold(info_text.indexOf("Version Name :"), info_text.indexOf("Version Name :") + 14);
										_Spannable_Bold(info_text.indexOf("Version Code :"), info_text.indexOf("Version Code :") + 14);
										dialog.setMessage(s);
										dialog.setPositiveButton("DONE", new DialogInterface.OnClickListener() {
											@Override
											public void onClick(DialogInterface _dialog, int _which) {
												
											}
										});
										dialog.create().show();
									}
								});
								bottom.setVisibility(View.VISIBLE);
								confirmation.setVisibility(View.GONE);
							}
						}
					});
					background.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View _view) {
							if (bottomOpen) {
								bottomOpen = false;
								bottom.setVisibility(View.GONE);
								confirmation.setVisibility(View.GONE);
								callpose.setImageResource(R.drawable.ic_arrow_drop_down_grey);
							}
							else {
								bottomOpen = true;
								callpose.setImageResource(R.drawable.ic_arrow_drop_up_grey);
								backup.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
										_Save(_data.get((int)_position).get("sc_id").toString(), _data.get((int)_position).get("my_ws_name").toString());
									}
								});
								restoree.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
										fpick.setClass(getApplicationContext(), FilepicActivity.class);
										fpick.putExtra("extension", ".sk");
										startActivity(fpick);
										restore = true;
										rest = false;
										restoreId = _data.get((int)_position).get("sc_id").toString();
									}
								});
								clone.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
										_Clone(_data.get((int)_position).get("sc_id").toString());
									}
								});
								info.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
										dialog.setTitle("Project Info");
										info_text = "App Name :\n%appname\n\nProject name : %projectname\n\nPackage :\n\n\n\n %package\n\nProject ID : %projectid\n\nVersion Name : %versionname\n\nVersion Code :\n%versioncode\n\n";
										info_text = info_text.replace("%appname", _data.get((int)_position).get("my_ws_name").toString());
										info_text = info_text.replace("%projectname", _data.get((int)_position).get("my_app_name").toString().trim());
										info_text = info_text.replace("%package", _data.get((int)_position).get("my_sc_pkg_name").toString().trim());
										info_text = info_text.replace("%projectid", _data.get((int)_position).get("sc_id").toString().trim());
										info_text = info_text.replace("%versionname", _data.get((int)_position).get("sc_ver_name").toString().trim());
										info_text = info_text.replace("%versioncode", _data.get((int)_position).get("sc_ver_code").toString().trim());
										_Create_Spannbale(info_text);
										_Spannable_Bold(info_text.indexOf("App Name :"), info_text.indexOf("App Name :") + 10);
										_Spannable_Bold(info_text.indexOf("Project name :"), info_text.indexOf("Project name :") + 14);
										_Spannable_Bold(info_text.indexOf("Package :"), info_text.indexOf("Package :") + 9);
										_Spannable_Bold(info_text.indexOf("Project ID :"), info_text.indexOf("Project ID :") + 12);
										_Spannable_Bold(info_text.indexOf("Version Name :"), info_text.indexOf("Version Name :") + 14);
										_Spannable_Bold(info_text.indexOf("Version Code :"), info_text.indexOf("Version Code :") + 14);
										dialog.setMessage(s);
										dialog.setPositiveButton("DONE", new DialogInterface.OnClickListener() {
											@Override
											public void onClick(DialogInterface _dialog, int _which) {
												
											}
										});
										dialog.create().show();
									}
								});
								bottom.setVisibility(View.VISIBLE);
								confirmation.setVisibility(View.GONE);
							}
						}
					});
				}
				else {
					callpose.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View _view) {
							if (confirmationOpen) {
								confirmationOpen = false;
								callpose.setImageResource(R.drawable.ic_arrow_drop_down_grey);
								confirmation.setVisibility(View.GONE);
								bottom.setVisibility(View.GONE);
							}
							else {
								confirmation.setVisibility(View.VISIBLE);
								confirmationOpen = true;
								callpose.setImageResource(R.drawable.ic_arrow_drop_up_grey);
								confirm.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
										_Export(_data.get((int)_position).get("sc_id").toString(), _data.get((int)_position).get("my_ws_name").toString());
									}
								});
								bottom.setVisibility(View.GONE);
							}
						}
					});
					background.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View _view) {
							if (confirmationOpen) {
								confirmationOpen = false;
								callpose.setImageResource(R.drawable.ic_arrow_drop_down_grey);
								confirmation.setVisibility(View.GONE);
								bottom.setVisibility(View.GONE);
							}
							else {
								confirmation.setVisibility(View.VISIBLE);
								confirmationOpen = true;
								callpose.setImageResource(R.drawable.ic_arrow_drop_up_grey);
								confirm.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View _view) {
										_Export(_data.get((int)_position).get("sc_id").toString(), _data.get((int)_position).get("my_ws_name").toString());
									}
								});
								bottom.setVisibility(View.GONE);
							}
						}
					});
				}
			} catch(Exception _e){
				
				    //here do something when try detects error
				    Log.e("try/catch error", _e.toString());
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