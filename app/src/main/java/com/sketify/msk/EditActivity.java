package com.sketify.msk;

import android.Manifest;
import android.animation.*;
import android.animation.ObjectAnimator;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
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
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
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
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import java.io.*;
import java.io.File;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class EditActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private String name = "";
	private String bio = "";
	private String url = "";
	private String durl = "";
	private String img_path = "";
	private String img_name = "";
	private HashMap<String, Object> map = new HashMap<>();
	private String fontName = "";
	private String typeace = "";
	private String flag_url = "";
	private HashMap<String, Object> Country = new HashMap<>();
	private String country_code = "";
	private String ectra = "";
	private String key = "";
	private String email = "";
	private boolean netOk = false;
	
	private ArrayList<String> list = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> items = new ArrayList<>();
	private ArrayList<String> filePath = new ArrayList<>();
	
	private LinearLayout linear5;
	private LinearLayout linear1;
	private ImageView imageview3;
	private TextView textview15;
	private TextView textview16;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private Button button1;
	private ProgressBar progressbar1;
	private TextView textview17;
	private ImageView imageview1;
	private ImageView imageview2;
	private TextView textview1;
	private EditText edittext2;
	private TextView textview2;
	private EditText edittext3;
	
	private StorageReference profile = _firebase_storage.getReference("profile");
	private OnCompleteListener<Uri> _profile_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _profile_download_success_listener;
	private OnSuccessListener _profile_delete_success_listener;
	private OnProgressListener _profile_upload_progress_listener;
	private OnProgressListener _profile_download_progress_listener;
	private OnFailureListener _profile_failure_listener;
	
	private DatabaseReference users = _firebase.getReference("users");
	private ChildEventListener _users_child_listener;
	private FirebaseAuth aith;
	private OnCompleteListener<AuthResult> _aith_create_user_listener;
	private OnCompleteListener<AuthResult> _aith_sign_in_listener;
	private OnCompleteListener<Void> _aith_reset_password_listener;
	private OnCompleteListener<Void> aith_updateEmailListener;
	private OnCompleteListener<Void> aith_updatePasswordListener;
	private OnCompleteListener<Void> aith_emailVerificationSentListener;
	private OnCompleteListener<Void> aith_deleteUserListener;
	private OnCompleteListener<Void> aith_updateProfileListener;
	private OnCompleteListener<AuthResult> aith_phoneAuthListener;
	private OnCompleteListener<AuthResult> aith_googleSignInListener;
	
	private AlertDialog.Builder exit;
	private Intent filePic = new Intent();
	private SharedPreferences file;
	private Intent t = new Intent();
	private ObjectAnimator oa_d = new ObjectAnimator();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.edit);
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
		linear5 = findViewById(R.id.linear5);
		linear1 = findViewById(R.id.linear1);
		imageview3 = findViewById(R.id.imageview3);
		textview15 = findViewById(R.id.textview15);
		textview16 = findViewById(R.id.textview16);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		button1 = findViewById(R.id.button1);
		progressbar1 = findViewById(R.id.progressbar1);
		textview17 = findViewById(R.id.textview17);
		imageview1 = findViewById(R.id.imageview1);
		imageview2 = findViewById(R.id.imageview2);
		textview1 = findViewById(R.id.textview1);
		edittext2 = findViewById(R.id.edittext2);
		textview2 = findViewById(R.id.textview2);
		edittext3 = findViewById(R.id.edittext3);
		aith = FirebaseAuth.getInstance();
		exit = new AlertDialog.Builder(this);
		file = getSharedPreferences("file", Activity.MODE_PRIVATE);
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				onBackPressed();
			}
		});
		
		textview16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (netOk) {
					if (img_path.equals("") && img_name.equals("")) {
						_ProgresbarShow("Updating Profile...");
						map = new HashMap<>();
						map.put("profile", url);
						map.put("bio", edittext3.getText().toString());
						map.put("name", edittext2.getText().toString());
						users.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
						map.clear();
						
						SketchwareUtil.showMessage(getApplicationContext(), "Profile Saved Successfully");
						img_path = "";
						img_name = "";
						_ProgresbarDimiss();
						finish();
					}
					else {
						_ProgresbarShow("Updating Profile...");
						profile.child(img_name).putFile(Uri.fromFile(new File(img_path))).addOnFailureListener(_profile_failure_listener).addOnProgressListener(_profile_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
							@Override
							public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
								return profile.child(img_name).getDownloadUrl();
							}}).addOnCompleteListener(_profile_upload_success_listener);
					}
				}
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				progressbar1.setVisibility(View.VISIBLE);
				if (!email.equals("")) {
					aith.sendPasswordResetEmail(email).addOnCompleteListener(_aith_reset_password_listener);
				}
				else {
					t.setClass(getApplicationContext(), MainActivity.class);
					t.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(t);
					SketchwareUtil.showMessage(getApplicationContext(), "Error Occured Wrong Id!");
					finish();
				}
				button1.setVisibility(View.GONE);
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				filePic.setClass(getApplicationContext(), FilepicActivity.class);
				filePic.putExtra("extension", ".png, .apng, .gif, .jpeg, .jpg");
				startActivity(filePic);
			}
		});
		
		_profile_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_profile_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_profile_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				img_path = "";
				img_name = "";
				if (!url.equals("")) {
					_firebase_storage.getReferenceFromUrl(url).delete().addOnSuccessListener(_profile_delete_success_listener).addOnFailureListener(_profile_failure_listener);
				}
				map = new HashMap<>();
				map.put("profile", _downloadUrl);
				map.put("bio", edittext3.getText().toString());
				map.put("name", edittext2.getText().toString());
				users.child(key).updateChildren(map);
				map.clear();
				SketchwareUtil.showMessage(getApplicationContext(), "Profile Updated");
				url = "";
				bio = "";
				name = "";
				finish();
			}
		};
		
		_profile_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_profile_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_profile_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_users_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				netOk = true;
				if (_childKey.equals(key)) {
					if (_childValue.containsKey("name")) {
						edittext2.setText(_childValue.get("name").toString());
					}
					if (_childValue.containsKey("bio")) {
						edittext3.setText(_childValue.get("bio").toString());
					}
					if (_childValue.containsKey("email")) {
						email = _childValue.get("email").toString();
					}
					if (_childValue.containsKey("profile")) {
						if (!_childValue.get("profile").toString().equals("avator") && !_childValue.get("profile").toString().equals("")) {
							_setCircleImageURL(imageview1, _childValue.get("profile").toString(), 1, "#FFFFFF");
							url = _childValue.get("profile").toString();
						}
						else {
							if (_childValue.get("profile").toString().equals("avator")) {
								imageview1.setImageResource(R.drawable.default_avatar);
								url = "";
							}
							else {
								if (!_childValue.get("profile").toString().equals("")) {
									_setCircleImageURL(imageview1, _childValue.get("profile").toString(), 1, "#FFFFFF");
									url = _childValue.get("profile").toString();
								}
							}
						}
					}
					else {
						imageview1.setImageResource(R.drawable.default_avatar);
						url = "";
					}
				}
				else {
					
				}
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
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		users.addChildEventListener(_users_child_listener);
		
		aith_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		aith_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		aith_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		aith_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		aith_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		aith_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		aith_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_aith_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_aith_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_aith_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				if (_success) {
					progressbar1.setVisibility(View.GONE);
					textview17.setVisibility(View.VISIBLE);
					textview17.setText("Reset Email Sent Successfully to \"".concat(FirebaseAuth.getInstance().getCurrentUser().getEmail().concat("\".")));
				}
				else {
					progressbar1.setVisibility(View.GONE);
					button1.setVisibility(View.VISIBLE);
					textview17.setVisibility(View.GONE);
					SketchwareUtil.showMessage(getApplicationContext(), "Error Occured!");
				}
			}
		};
	}
	
	private void initializeLogic() {
		key = getIntent().getStringExtra("key");
		img_path = "";
		img_name = "";
		progressbar1.setVisibility(View.GONE);
		textview17.setVisibility(View.GONE);
		_changeActivityFont("calculator");
		_gd(imageview2, 85, "#FFFFFF");
		_Progress_Create();
		_Elevation(linear5, 8);
		_rippleRoundStroke(imageview3, "#536DFE", "#FFFFFF", 50, 0, "#536DFE");
		_rippleRoundStroke(textview16, "#536DFE", "#FFFFFF", 0, 0, "#536DFE");
	}
	
	@Override
	public void onBackPressed() {
		exit.setTitle("Exit Edit!");
		exit.setMessage("Exiting Edit Page Will Erase All The Unsaved Datas!");
		exit.setPositiveButton("YES", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				finish();
			}
		});
		exit.setNegativeButton("NO", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				
			}
		});
		exit.create().show();
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (!file.getString("picked_path", "").equals("")) {
			filePath.add((int)(0), file.getString("picked_path", ""));
			img_path = file.getString("picked_path", "");
			img_name = Uri.parse(file.getString("picked_path", "")).getLastPathSegment();
			imageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(file.getString("picked_path", ""), 1024, 1024));
			file.edit().putString("picked_path", "").commit();
		}
	}
	public void _gd(final View _view, final double _numb, final String _color) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		gd.setCornerRadius((int)_numb);
		_view.setBackground(gd);
	}
	
	
	public void _ProgresbarShow(final String _title) {
		prog = new ProgressDialog(EditActivity.this);
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
	
	
	public void _Progress_Create() {
	}
	private SpannableString spannable;
	private ProgressDialog prog;
	{
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
	
	
	public void _setCircleImagePath(final ImageView _imageview, final String _path, final double _strokeWidth, final String _strokeColor) {
		Glide.with(getApplicationContext()).load(Uri.fromFile(new java.io.File(_path))).transform(new BorderTransformation2(this, (float)_strokeWidth, Color.parseColor(_strokeColor))).into(_imageview);
	}
	public class BorderTransformation2 extends com.bumptech.glide.load.resource.bitmap.BitmapTransformation {
		
		private float strokeWidth;
		private int strokeColor;
		
		    public BorderTransformation2(Context context, float strokeWidth, int strokeColor) {
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