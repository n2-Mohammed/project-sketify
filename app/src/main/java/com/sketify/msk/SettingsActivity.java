package com.sketify.msk;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class SettingsActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private double n = 0;
	private boolean touch = false;
	private String fontName = "";
	private String typeace = "";
	
	private LinearLayout linear1;
	private LinearLayout linear5;
	private ScrollView vscroll1;
	private LinearLayout linear2;
	private LinearLayout linear50;
	private LinearLayout linear51;
	private LinearLayout editpr;
	private LinearLayout linear_log_out;
	private LinearLayout linear52;
	private LinearLayout new_;
	private LinearLayout popular;
	private LinearLayout verified_projects;
	private LinearLayout linear57;
	private ImageView imageview9;
	private TextView textview25;
	private ImageView imageview8;
	private TextView textview24;
	private ImageView imageview15;
	private TextView textview28;
	private ImageView imageview10;
	private TextView textview26;
	private TextView textview31;
	private CheckBox checkbox3;
	private TextView textview30;
	private CheckBox checkbox2;
	private TextView textview29;
	private CheckBox checkbox1;
	private LinearLayout linear56;
	private LinearLayout linear55;
	private TextView textview27;
	private ImageView imageview14;
	private TextView t_view;
	private ImageView imageview13;
	
	private Intent edit = new Intent();
	private SharedPreferences user_facility;
	private AlertDialog.Builder dialog;
	private Intent restarr = new Intent();
	private TimerTask timer;
	private FirebaseAuth auth;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private OnCompleteListener<Void> auth_updateEmailListener;
	private OnCompleteListener<Void> auth_updatePasswordListener;
	private OnCompleteListener<Void> auth_emailVerificationSentListener;
	private OnCompleteListener<Void> auth_deleteUserListener;
	private OnCompleteListener<Void> auth_updateProfileListener;
	private OnCompleteListener<AuthResult> auth_phoneAuthListener;
	private OnCompleteListener<AuthResult> auth_googleSignInListener;
	
	private AlertDialog.Builder delete;
	private SharedPreferences user;
	private AlertDialog.Builder lg_out;
	private Vibrator v;
	private SharedPreferences settings;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.settings);
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
		linear1 = findViewById(R.id.linear1);
		linear5 = findViewById(R.id.linear5);
		vscroll1 = findViewById(R.id.vscroll1);
		linear2 = findViewById(R.id.linear2);
		linear50 = findViewById(R.id.linear50);
		linear51 = findViewById(R.id.linear51);
		editpr = findViewById(R.id.editpr);
		linear_log_out = findViewById(R.id.linear_log_out);
		linear52 = findViewById(R.id.linear52);
		new_ = findViewById(R.id.new_);
		popular = findViewById(R.id.popular);
		verified_projects = findViewById(R.id.verified_projects);
		linear57 = findViewById(R.id.linear57);
		imageview9 = findViewById(R.id.imageview9);
		textview25 = findViewById(R.id.textview25);
		imageview8 = findViewById(R.id.imageview8);
		textview24 = findViewById(R.id.textview24);
		imageview15 = findViewById(R.id.imageview15);
		textview28 = findViewById(R.id.textview28);
		imageview10 = findViewById(R.id.imageview10);
		textview26 = findViewById(R.id.textview26);
		textview31 = findViewById(R.id.textview31);
		checkbox3 = findViewById(R.id.checkbox3);
		textview30 = findViewById(R.id.textview30);
		checkbox2 = findViewById(R.id.checkbox2);
		textview29 = findViewById(R.id.textview29);
		checkbox1 = findViewById(R.id.checkbox1);
		linear56 = findViewById(R.id.linear56);
		linear55 = findViewById(R.id.linear55);
		textview27 = findViewById(R.id.textview27);
		imageview14 = findViewById(R.id.imageview14);
		t_view = findViewById(R.id.t_view);
		imageview13 = findViewById(R.id.imageview13);
		user_facility = getSharedPreferences("facility", Activity.MODE_PRIVATE);
		dialog = new AlertDialog.Builder(this);
		auth = FirebaseAuth.getInstance();
		delete = new AlertDialog.Builder(this);
		user = getSharedPreferences("settings", Activity.MODE_PRIVATE);
		lg_out = new AlertDialog.Builder(this);
		v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		settings = getSharedPreferences("settings", Activity.MODE_PRIVATE);
		
		linear2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		editpr.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edit.setClass(getApplicationContext(), EditActivity.class);
				edit.putExtra("key", FirebaseAuth.getInstance().getCurrentUser().getUid());
				startActivity(edit);
			}
		});
		
		linear_log_out.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				lg_out.setTitle("Log Out");
				lg_out.setMessage("Are you sure You want to Log Out!?");
				lg_out.setPositiveButton("YES", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
							FirebaseAuth.getInstance().signOut();
							restarr.setClass(getApplicationContext(), MainActivity.class);
							startActivity(restarr);
							overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
							finish();
						}
						else {
							restarr.setClass(getApplicationContext(), MainActivity.class);
							restarr.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
							startActivity(restarr);
							overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
							finish();
						}
					}
				});
				lg_out.setNegativeButton("NO", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				lg_out.create().show();
			}
		});
		
		textview31.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		checkbox3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				touch = true;
			}
		});
		
		checkbox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				user.edit().putString("new", "true").commit();
				if (_isChecked) {
					user.edit().putString("new", "true").commit();
				}
				else {
					user.edit().putString("new", "false").commit();
				}
			}
		});
		
		checkbox2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				touch = true;
			}
		});
		
		checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				user.edit().putString("popular", "true").commit();
				if (_isChecked) {
					user.edit().putString("popular", "true").commit();
				}
				else {
					user.edit().putString("popular", "false").commit();
				}
			}
		});
		
		textview29.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				user.edit().putString("verified", "true").commit();
				if (_isChecked) {
					user.edit().putString("verified", "true").commit();
				}
				else {
					user.edit().putString("verified", "false").commit();
				}
			}
		});
		
		linear55.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				touch = true;
			}
		});
		
		imageview14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (t_view.getText().toString().equals("5")) {
					_SnackBar(false, true, false, "Minimum Project View Size Reached!");
				}
				else {
					_Touch();
					n--;
					t_view.setText(String.valueOf((long)(n)));
					n = Double.parseDouble(t_view.getText().toString());
					user_facility.edit().remove("view").commit();
					user_facility.edit().putString("view", String.valueOf((long)(n))).commit();
				}
			}
		});
		
		imageview13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (t_view.getText().toString().equals("30")) {
					_SnackBar(false, true, false, "Maximum View Size Reached!");
				}
				else {
					_Touch();
					n++;
					t_view.setText(String.valueOf((long)(n)));
					n = Double.parseDouble(t_view.getText().toString());
					user_facility.edit().remove("view").commit();
					user_facility.edit().putString("view", String.valueOf((long)(n))).commit();
				}
			}
		});
		
		auth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		auth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		_changeActivityFont("regular");
		_OnCreate();
		setTitle("Settings");
		if (!user_facility.getString("view", "").equals("")) {
			t_view.setText(user_facility.getString("view", ""));
		}
		else {
			user_facility.edit().putString("view", "8").commit();
			t_view.setText("8");
		}
		_Elevation(linear_log_out, 12);
		_Elevation(new_, 12);
		_Elevation(popular, 12);
		_Elevation(verified_projects, 12);
		_Elevation(linear55, 12);
		_Elevation(imageview14, 12);
		_Elevation(imageview13, 12);
		_click_effect(imageview14, "#EEEEEE");
		_click_effect(imageview13, "#EEEEEE");
		_rippleRoundStroke(imageview14, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(imageview13, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(linear_log_out, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_Elevation(editpr, 12);
		_rippleRoundStroke(editpr, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(new_, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(popular, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		_rippleRoundStroke(verified_projects, "#FFFFFF", "#E0E0E0", 20, 3, "#FFFFFF");
		linear55.setVisibility(View.GONE);
	}
	
	@Override
	public void onBackPressed() {
		dialog.setTitle("Note");
		dialog.setMessage("Please Restart The App & Wait For a Few Minutes to Apply Changes");
		dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				v.vibrate((long)(250));
				restarr.setClass(getApplicationContext(), MainActivity.class);
				restarr.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(restarr);
				finish();
			}
		});
		dialog.setCancelable(false);
		dialog.create().show();
	}
	public void _Elevation(final View _view, final double _number) {
		
		_view.setElevation((int)_number);
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
	
	
	public void _OnCreate() {
		if (user.getString("new", "").equals("true")) {
			checkbox3.setChecked(true);
		}
		else {
			checkbox3.setChecked(false);
		}
		if (user.getString("popular", "").equals("true")) {
			checkbox2.setChecked(true);
		}
		else {
			checkbox2.setChecked(false);
		}
		if (user.getString("verified", "").equals("true")) {
			checkbox1.setChecked(true);
		}
		else {
			checkbox1.setChecked(false);
		}
	}
	
	
	public void _Touch() {
		
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