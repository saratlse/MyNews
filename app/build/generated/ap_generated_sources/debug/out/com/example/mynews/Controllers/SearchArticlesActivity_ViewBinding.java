// Generated code from Butter Knife. Do not modify!
package com.example.mynews.Controllers;

import android.view.View;
import android.widget.Button;
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

public class SearchArticlesActivity_ViewBinding implements Unbinder {
  private SearchArticlesActivity target;

  @UiThread
  public SearchArticlesActivity_ViewBinding(SearchArticlesActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SearchArticlesActivity_ViewBinding(SearchArticlesActivity target, View source) {
    this.target = target;

    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'mToolbar'", Toolbar.class);
    target.mSearchQueryTerm = Utils.findRequiredViewAsType(source, R.id.search_query_term_editText, "field 'mSearchQueryTerm'", EditText.class);
    target.mSearchBeginDate = Utils.findRequiredViewAsType(source, R.id.search_begin_date, "field 'mSearchBeginDate'", EditText.class);
    target.mSearchEndDate = Utils.findRequiredViewAsType(source, R.id.search_end_date, "field 'mSearchEndDate'", EditText.class);
    target.mCheckBoxArts = Utils.findRequiredViewAsType(source, R.id.search_articles_arts, "field 'mCheckBoxArts'", CheckBox.class);
    target.mCheckBoxBusiness = Utils.findRequiredViewAsType(source, R.id.search_articles_business, "field 'mCheckBoxBusiness'", CheckBox.class);
    target.mCheckBoxEntrepreneurs = Utils.findRequiredViewAsType(source, R.id.search_articles_entrepreneurs, "field 'mCheckBoxEntrepreneurs'", CheckBox.class);
    target.mButton = Utils.findRequiredViewAsType(source, R.id.search_button, "field 'mButton'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SearchArticlesActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mToolbar = null;
    target.mSearchQueryTerm = null;
    target.mSearchBeginDate = null;
    target.mSearchEndDate = null;
    target.mCheckBoxArts = null;
    target.mCheckBoxBusiness = null;
    target.mCheckBoxEntrepreneurs = null;
    target.mButton = null;
  }
}
