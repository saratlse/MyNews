// Generated code from Butter Knife. Do not modify!
package com.example.mynews.Controllers;

import android.view.Menu;
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

public class SearchArticlesActivity_ViewBinding implements Unbinder {
  private SearchArticlesActivity target;

  @UiThread
  public SearchArticlesActivity_ViewBinding(SearchArticlesActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SearchArticlesActivity_ViewBinding(SearchArticlesActivity target, View source) {
    this.target = target;

    target.mMenu = Utils.findRequiredViewAsType(source, R.id.menu, "field 'mMenu'", Menu.class);
    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'mToolbar'", Toolbar.class);
    target.mSearchQueryTerm = Utils.findRequiredViewAsType(source, R.id.search_query_term_editText, "field 'mSearchQueryTerm'", EditText.class);
    target.mSearchBeginDate = Utils.findRequiredViewAsType(source, R.id.search_begin_date, "field 'mSearchBeginDate'", EditText.class);
    target.mSearchEndDate = Utils.findRequiredViewAsType(source, R.id.search_end_date, "field 'mSearchEndDate'", EditText.class);
    target.mCheckBox = Utils.findRequiredViewAsType(source, R.id.checkbox_container, "field 'mCheckBox'", CheckBox.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SearchArticlesActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mMenu = null;
    target.mToolbar = null;
    target.mSearchQueryTerm = null;
    target.mSearchBeginDate = null;
    target.mSearchEndDate = null;
    target.mCheckBox = null;
  }
}
