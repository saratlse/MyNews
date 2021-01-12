// Generated code from Butter Knife. Do not modify!
package com.example.mynews.Controllers;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.mynews.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NotificationsActivity_ViewBinding implements Unbinder {
  private NotificationsActivity target;

  @UiThread
  public NotificationsActivity_ViewBinding(NotificationsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NotificationsActivity_ViewBinding(NotificationsActivity target, View source) {
    this.target = target;

    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'mToolbar'", Toolbar.class);
    target.mSearchQueryTerm = Utils.findRequiredViewAsType(source, R.id.search_query_term_editText, "field 'mSearchQueryTerm'", EditText.class);
    target.mSearchBeginDate = Utils.findRequiredViewAsType(source, R.id.search_begin_date, "field 'mSearchBeginDate'", EditText.class);
    target.mSearchEndDate = Utils.findRequiredViewAsType(source, R.id.search_end_date, "field 'mSearchEndDate'", EditText.class);
    target.mCheckBoxArts = Utils.findRequiredViewAsType(source, R.id.search_articles_arts, "field 'mCheckBoxArts'", CheckBox.class);
    target.mCheckBoxBusiness = Utils.findRequiredViewAsType(source, R.id.search_articles_business, "field 'mCheckBoxBusiness'", CheckBox.class);
    target.mCheckBoxEntrepreneurs = Utils.findRequiredViewAsType(source, R.id.search_articles_entrepreneurs, "field 'mCheckBoxEntrepreneurs'", CheckBox.class);
    target.mCheckBoxPolitics = Utils.findRequiredViewAsType(source, R.id.search_articles_politics, "field 'mCheckBoxPolitics'", CheckBox.class);
    target.mCheckboxSports = Utils.findRequiredViewAsType(source, R.id.search_articles_sports, "field 'mCheckboxSports'", CheckBox.class);
    target.mCheckBoxTravel = Utils.findRequiredViewAsType(source, R.id.search_articles_travel, "field 'mCheckBoxTravel'", CheckBox.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NotificationsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mToolbar = null;
    target.mSearchQueryTerm = null;
    target.mSearchBeginDate = null;
    target.mSearchEndDate = null;
    target.mCheckBoxArts = null;
    target.mCheckBoxBusiness = null;
    target.mCheckBoxEntrepreneurs = null;
    target.mCheckBoxPolitics = null;
    target.mCheckboxSports = null;
    target.mCheckBoxTravel = null;
  }
}
