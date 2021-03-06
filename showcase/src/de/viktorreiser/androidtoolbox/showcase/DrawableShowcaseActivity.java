package de.viktorreiser.androidtoolbox.showcase;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import de.viktorreiser.androidtoolbox.showcase.drawable.StatusTextDrawableActivity;

/**
 * List of custom drawable demonstrations.
 * 
 * @author Viktor Reiser &lt;<a href="mailto:viktorreiser@gmx.de">viktorreiser@gmx.de</a>&gt;
 */
public class DrawableShowcaseActivity extends Activity {
	
	// PRIVATE ====================================================================================
	
	private static final Object [][] mShowcases = new Object [] [] {
			new Object [] {
					StatusTextDrawableActivity.class,
					"Status text",
					"Scalable drawable which can be used for (e.g.) drawing and indicating a certain state"
			}
	};
	
	// PUBLIC =====================================================================================
	
	public static final String getActivityTitle(Class<?> activityClass) {
		return Showcase.getTitle(activityClass, mShowcases);
	}
	
	// OVERRIDDEN =================================================================================
	
	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		
		setTitle(AndroidToolboxShowcaseActivity.getShowcaseTitle(getClass()));
		
		Showcase.Adapter adapter = new Showcase.Adapter(this, mShowcases);
		
		ListView lv = new ListView(this);
		lv.setOnItemClickListener(adapter);
		lv.setAdapter(adapter);
		
		setContentView(lv);
	}
}
