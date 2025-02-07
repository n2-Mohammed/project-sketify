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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.google.firebase.FirebaseApp;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class FilepicActivity extends AppCompatActivity {
	
	public final int REQ_CD_FP = 101;
	public final int REQ_CD_IMAGE = 102;
	
	private String path_bind = "";
	private String current_filepath = "";
	private double n_f = 0;
	private HashMap<String, Object> map_file = new HashMap<>();
	private String extension = "";
	private double f_position = 0;
	private String fontName = "";
	private String typeace = "";
	private String ext = "";
	
	private ArrayList<String> file_list = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> file_lm = new ArrayList<>();
	private ArrayList<String> file_list_2 = new ArrayList<>();
	
	private LinearLayout linear_d_main;
	private LinearLayout linear_toolbr;
	private ListView listview_d;
	private LinearLayout linear_grid;
	private ImageView d_back;
	private TextView txt_path;
	private ImageView imageview1;
	private ImageView img_switch;
	private TextView textview1;
	
	private SharedPreferences file;
	private Intent fp = new Intent(Intent.ACTION_GET_CONTENT);
	private AlertDialog.Builder dialog;
	private SharedPreferences donot;
	private Intent image = new Intent(Intent.ACTION_GET_CONTENT);
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.filepic);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
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
		linear_d_main = findViewById(R.id.linear_d_main);
		linear_toolbr = findViewById(R.id.linear_toolbr);
		listview_d = findViewById(R.id.listview_d);
		linear_grid = findViewById(R.id.linear_grid);
		d_back = findViewById(R.id.d_back);
		txt_path = findViewById(R.id.txt_path);
		imageview1 = findViewById(R.id.imageview1);
		img_switch = findViewById(R.id.img_switch);
		textview1 = findViewById(R.id.textview1);
		file = getSharedPreferences("file", Activity.MODE_PRIVATE);
		fp.setType("*/*");
		fp.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		dialog = new AlertDialog.Builder(this);
		donot = getSharedPreferences("donot", Activity.MODE_PRIVATE);
		image.setType("image/*");
		image.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		
		listview_d.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (file_lm.get((int)_position).get("type").toString().equals("folder")) {
					_go_to(file_lm.get((int)_position).get("path").toString());
					_refresh();
				}
				else {
					file.edit().putString("picked_path", file_lm.get((int)_position).get("path").toString()).commit();
					finish();
				}
			}
		});
		
		d_back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (donot.getString("visible", "").equals("true")) {
					dialog.setTitle("⚠️Notice");
					dialog.setMessage("App May Crash When Pick From External Picker. So,Try To Use Gallery Or File Manager To Pick Files.");
					final CheckBox cb1 = new CheckBox(FilepicActivity.this); cb1.setText("Do not show this Again"); LinearLayout.LayoutParams lpar = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT); cb1.setLayoutParams(lpar); dialog.setView(cb1); 
					
					
					dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							if(cb1.isChecked()){
								donot.edit().remove("visible").commit();
								donot.edit().putString("visible", "false").commit();
								if (getIntent().getStringExtra("extension").contains(".png, .apng, .gif, .jpeg, .jpg")) {
									startActivityForResult(image, REQ_CD_IMAGE);
								}
								else {
									if (getIntent().getStringExtra("extension").contains(".zip")) {
										ext = ".zip";
										startActivityForResult(fp, REQ_CD_FP);
									}
									else {
										if (getIntent().getStringExtra("extension").contains(".apk")) {
											ext = ".apk";
											startActivityForResult(fp, REQ_CD_FP);
										}
										else {
											if (getIntent().getStringExtra("extension").contains(".sh-zip")) {
												ext = ".sh-zip";
												startActivityForResult(fp, REQ_CD_FP);
											}
										}
									}
								}
								
							} else { 
								
								donot.edit().remove("visible").commit();
								donot.edit().putString("visible", "true").commit();
								if (getIntent().getStringExtra("extension").contains(".png, .apng, .gif, .jpeg, .jpg")) {
									startActivityForResult(image, REQ_CD_IMAGE);
								}
								else {
									if (getIntent().getStringExtra("extension").contains(".zip")) {
										ext = ".zip";
										startActivityForResult(fp, REQ_CD_FP);
									}
									else {
										if (getIntent().getStringExtra("extension").contains(".apk")) {
											ext = ".apk";
											startActivityForResult(fp, REQ_CD_FP);
										}
										else {
											if (getIntent().getStringExtra("extension").contains(".sh-zip")) {
												ext = ".sh-zip";
												startActivityForResult(fp, REQ_CD_FP);
											}
										}
									}
								}
							}
						}
					});
					dialog.setCancelable(false);
					dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					dialog.create().show();
				}
				else {
					if (donot.getString("visible", "").equals("false")) {
						if (getIntent().getStringExtra("extension").contains(".png, .apng, .gif, .jpeg, .jpg")) {
							startActivityForResult(image, REQ_CD_IMAGE);
						}
						else {
							if (getIntent().getStringExtra("extension").contains(".zip")) {
								ext = ".zip";
								startActivityForResult(fp, REQ_CD_FP);
							}
							else {
								if (getIntent().getStringExtra("extension").contains(".apk")) {
									ext = ".apk";
									startActivityForResult(fp, REQ_CD_FP);
								}
								else {
									if (getIntent().getStringExtra("extension").contains(".sh-zip")) {
										ext = ".sh-zip";
										startActivityForResult(fp, REQ_CD_FP);
									}
								}
							}
						}
					}
					else {
						dialog.setTitle("⚠️Notice");
						dialog.setMessage("App May Crash When Pick From External Picker. So,Try To Use Gallery Or File Manager To Pick Files.");
						final CheckBox cb1 = new CheckBox(FilepicActivity.this); cb1.setText("Do not show this Again"); LinearLayout.LayoutParams lpar = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT); cb1.setLayoutParams(lpar); dialog.setView(cb1); 
						
						dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								if(cb1.isChecked()){
									donot.edit().remove("visible").commit();
									donot.edit().putString("visible", "false").commit();
									if (getIntent().getStringExtra("extension").contains(".png, .apng, .gif, .jpeg, .jpg")) {
										startActivityForResult(image, REQ_CD_IMAGE);
									}
									else {
										if (getIntent().getStringExtra("extension").contains(".zip")) {
											ext = ".zip";
											startActivityForResult(fp, REQ_CD_FP);
										}
										else {
											if (getIntent().getStringExtra("extension").contains(".apk")) {
												ext = ".apk";
												startActivityForResult(fp, REQ_CD_FP);
											}
											else {
												if (getIntent().getStringExtra("extension").contains(".sh-zip")) {
													ext = ".sh-zip";
													startActivityForResult(fp, REQ_CD_FP);
												}
											}
										}
									}
									
								} else { 
									
									donot.edit().remove("visible").commit();
									donot.edit().putString("visible", "true").commit();
									if (getIntent().getStringExtra("extension").contains(".png, .apng, .gif, .jpeg, .jpg")) {
										startActivityForResult(image, REQ_CD_IMAGE);
									}
									else {
										if (getIntent().getStringExtra("extension").contains(".zip")) {
											ext = ".zip";
											startActivityForResult(fp, REQ_CD_FP);
										}
										else {
											if (getIntent().getStringExtra("extension").contains(".apk")) {
												ext = ".apk";
												startActivityForResult(fp, REQ_CD_FP);
											}
											else {
												if (getIntent().getStringExtra("extension").contains(".sh-zip")) {
													ext = ".sh-zip";
													startActivityForResult(fp, REQ_CD_FP);
												}
											}
										}
									}
								}
							}
						});
						dialog.setCancelable(false);
						dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								
							}
						});
						dialog.create().show();
					}
				}
			}
		});
		
		img_switch.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (file.getString("filepicker_type", "").equals("listview")) {
					file.edit().putString("filepicker_type", "gridview").commit();
					img_switch.setImageResource(R.drawable.ic_menu_black);
				}
				else {
					file.edit().putString("filepicker_type", "listview").commit();
					img_switch.setImageResource(R.drawable.icon4);
				}
				_refresh();
			}
		});
	}
	
	private void initializeLogic() {
		_changeActivityFont("calculator");
		file.edit().putString("picked_path", "").commit();
		_go_to(FileUtil.getExternalStorageDir());
		img_switch.setImageResource(R.drawable.ic_menu_black);
		if (file.getString("filepicker_type", "").equals("")) {
			file.edit().putString("filepicker_type", "listview").commit();
		}
		else {
			if (file.getString("filepicker_type", "").equals("listview")) {
				listview_d.setAdapter(new Listview_dAdapter(file_lm));
			}
			else {
				listview_d.setVisibility(View.GONE);
				img_switch.setImageResource(R.drawable.ic_menu_black);
				_install_gridview();
			}
		}
		_Create_Sharp(imageview1, 20, "#FFFFFF");
		_Create_Sharp(img_switch, 20, "#FFFFFF");
		_Create_Sharp(d_back, 20, "#FFFFFF");
		_Ripple_Drawable(imageview1, "#EEEEEE");
		_Ripple_Drawable(img_switch, "#EEEEEE");
		_Ripple_Drawable(d_back, "#EEEEEE");
		_rippleRoundStroke(d_back, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(img_switch, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(imageview1, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(txt_path, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
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
				if (!ext.equals("")) {
					if (_filePath.get((int)(0)).endsWith(ext)) {
						file.edit().putString("picked_path", _filePath.get((int)(0))).commit();
						finish();
					}
					else {
						file.edit().remove("picked_path").commit();
						SketchwareUtil.showMessage(getApplicationContext(), "Only ".concat(getIntent().getStringExtra("extension").concat(" Accepted")));
					}
				}
			}
			else {
				
			}
			break;
			
			case REQ_CD_IMAGE:
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
				file.edit().putString("picked_path", _filePath.get((int)(0))).commit();
				finish();
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		if (txt_path.getText().toString().equals("/storage")) {
			file.edit().remove("picked_path").commit();
			file.edit().putString("picked_path", "").commit();
			finish();
		}
		else {
			_go_to(current_filepath.substring((int)(0), (int)((current_filepath.length() - Uri.parse(current_filepath).getLastPathSegment().length()) - 1)));
			_refresh();
		}
	}
	public void _go_to(final String _path) {
		if (FileUtil.isDirectory(_path)) {
			current_filepath = _path;
			file_list.clear();
			file_lm.clear();
			file_list_2.clear();
			FileUtil.listDir(_path, file_list);
			Collections.sort(file_list, String.CASE_INSENSITIVE_ORDER);
			n_f = 0;
			for(int _repeat20 = 0; _repeat20 < (int)(file_list.size()); _repeat20++) {
				if (FileUtil.isDirectory(file_list.get((int)(n_f)))) {
					map_file = new HashMap<>();
					map_file.put("type", "folder");
					map_file.put("name", Uri.parse(file_list.get((int)(n_f))).getLastPathSegment());
					map_file.put("path", file_list.get((int)(n_f)));
					file_lm.add(map_file);
				}
				else {
					file_list_2.add(file_list.get((int)(n_f)));
				}
				n_f++;
			}
			file_list.clear();
			n_f = 0;
			for(int _repeat48 = 0; _repeat48 < (int)(file_list_2.size()); _repeat48++) {
				_get_extension(file_list_2.get((int)(n_f)));
				if (getIntent().getStringExtra("extension").contains(extension)) {
					map_file = new HashMap<>();
					map_file.put("type", "file");
					map_file.put("name", Uri.parse(file_list_2.get((int)(n_f))).getLastPathSegment());
					map_file.put("path", file_list_2.get((int)(n_f)));
					file_lm.add(map_file);
				}
				n_f++;
			}
			file_list_2.clear();
			txt_path.setText(_path);
		}
		else {
			
		}
	}
	
	
	public void _refresh() {
		txt_path.setText(current_filepath);
		if (file.getString("filepicker_type", "").equals("listview")) {
			listview_d.setAdapter(new Listview_dAdapter(file_lm));
			listview_d.setVisibility(View.VISIBLE);
		}
		else {
			listview_d.setVisibility(View.GONE);
			_install_gridview();
		}
	}
	
	
	public void _install_gridview() {
		linear_grid.removeAllViews();
		grid = new GridView(FilepicActivity.this);
				
				grid.setLayoutParams(new GridView.LayoutParams(GridLayout.LayoutParams.MATCH_PARENT, GridLayout.LayoutParams.WRAP_CONTENT));
				
				grid.setNumColumns(3);
				
				grid.setBackgroundColor(Color.WHITE);
				
				grid.setVerticalSpacing(5);
				
				grid.setHorizontalSpacing(5);
				
				grid.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
				
				grid.setAdapter(new Gridview1Adapter(file_lm));
				
				linear_grid.addView(grid);
				grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
						  @Override
						  public void onItemClick(AdapterView parent, View view, int _pos, long id) {
							
				f_position = new Double(_pos);
				if (file_lm.get((int)f_position).get("type").toString().equals("folder")) {
					_go_to(file_lm.get((int)f_position).get("path").toString());
					_refresh();
				}
				else {
					file.edit().putString("picked_path", file_lm.get((int)f_position).get("path").toString()).commit();
					finish();
				}
			}});
		
		}
		
		private GridView grid;
		
		
		public class Gridview1Adapter extends BaseAdapter {
						ArrayList<HashMap<String, Object>> _data;
						public Gridview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
												_v = _inflater.inflate(R.layout.fp_griditem, null);
									}
									
			final LinearLayout linear_bg = (LinearLayout) _v.findViewById(R.id.linear_bg);
						final ImageView img_file = (ImageView) _v.findViewById(R.id.img_file);
						final TextView txt_filename = (TextView) _v.findViewById(R.id.txt_filename);
						
						if (_data.get((int)_position).get("type").toString().equals("folder")) {
								img_file.setImageResource(R.drawable.folder_80px);
						}
						else {
								path_bind = _data.get((int)_position).get("path").toString();
								if (path_bind.endsWith(".gif") || (path_bind.endsWith(".png") || (path_bind.endsWith(".jpeg") || (path_bind.endsWith(".jpg") || path_bind.endsWith(".apng"))))) {
										_setImageFromFile(img_file, path_bind);
								}
								else {
										img_file.setImageResource(R.drawable.file_80px);
								}
						}
						txt_filename.setText(_data.get((int)_position).get("name").toString());
						
			return _v;}
	}
	
	
	public void _setImageFromFile(final ImageView _img, final String _path) {
		
		java.io.File file = new java.io.File(_path);
		Uri imageUri = Uri.fromFile(file);
		
		Glide.with(getApplicationContext ()).load(imageUri).into(_img);
	}
	
	
	public void _get_extension(final String _path) {
		try{
			extension = _path.substring((int)(_path.lastIndexOf(".")), (int)(_path.length()));
		} catch (Exception e){
			extension = "unknown";
		}
		extension = extension.toLowerCase().trim();
	}
	
	
	public void _Create_Sharp(final View _view, final double _numb, final String _color) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		gd.setCornerRadius((int)_numb);
		_view.setBackground(gd);
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
	
	public class Listview_dAdapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview_dAdapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_view = _inflater.inflate(R.layout.fp_item, null);
			}
			
			final LinearLayout main = _view.findViewById(R.id.main);
			final LinearLayout linear_bg = _view.findViewById(R.id.linear_bg);
			final ImageView img_file = _view.findViewById(R.id.img_file);
			final TextView txt_filename = _view.findViewById(R.id.txt_filename);
			
			_rippleRoundStroke(main, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
			if (_data.get((int)_position).get("type").toString().equals("folder")) {
				img_file.setImageResource(R.drawable.folder_80px);
			}
			else {
				path_bind = _data.get((int)_position).get("path").toString();
				if (path_bind.endsWith(".gif") || (path_bind.endsWith(".png") || (path_bind.endsWith(".jpeg") || (path_bind.endsWith(".jpg") || path_bind.endsWith(".apng"))))) {
					_setImageFromFile(img_file, path_bind);
				}
				else {
					img_file.setImageResource(R.drawable.file_80px);
				}
			}
			txt_filename.setText(_data.get((int)_position).get("name").toString());
			
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