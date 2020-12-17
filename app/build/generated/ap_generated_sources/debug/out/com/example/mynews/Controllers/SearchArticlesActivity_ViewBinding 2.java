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
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.mynews.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchArticlesActivity_ViewBinding implements Unbinder {
  private SearchArticlesActivity target;

  private View view7f080147;

  @UiThread
  public SearchArticlesActivity_ViewBinding(SearchArticlesActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SearchArticlesActivity_ViewBinding(final SearchArticlesActivity target, View source) {
    this.target = target;

    View view;
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
    view = Utils.findRequiredView(source, R.id.search_button, "field 'searchButton' and method 'searchButtonClicked'");
    target.searchButton = Utils.castView(view, R.id.search_button, "field 'searchButton'", Button.class);
    view7f080147 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.searchButtonClicked(p0);
      }
    });
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
    target.mCheckBoxPolitics = null;
    target.mCheckboxSports = null;
    target.mCheckBoxTravel = null;
    target.searchButton = null;

    view7f080147.setOnClickListener(null);
    view7f080147 = null;
  }
}
