// Generated code from Butter Knife. Do not modify!
package com.example.mynews.Controllers;

import android.view.View;
import android.webkit.WebView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.mynews.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WebViewActivity_ViewBinding implements Unbinder {
  private WebViewActivity target;

  @UiThread
  public WebViewActivity_ViewBinding(WebViewActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WebViewActivity_ViewBinding(WebViewActivity target, View source) {
    this.target = target;

    target.webView = Utils.findRequiredViewAsType(source, R.id.webView, "field 'webView'", WebView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WebViewActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.webView = null;
  }
}
