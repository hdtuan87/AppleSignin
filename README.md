# AppleSignin
Create webview signin with apple in the simplest way

#Use

cretate `layout_sign_in_apple` xml file:
```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal"
    android:id="@+id/container"
    android:minWidth="300dp"
    android:minHeight="500dp">

</LinearLayout>
```

Kotlin file:
```
  val webView = SignInAppleWebView(context, CALLBACK_URL) {
            callback.invoke(it)
            dismiss()
        }
  val lp = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
  webView.layoutParams = lp
        val redirectId = context.getString(R.string.redirect_id_apple)
        val url = SignInWithAppleService.makeUrl(
            CLIENT_ID,
            redirectId,
            scope = SCOPE
        )
   webView.loadUrl(url)
   setContentView(R.layout.layout_sign_in_apple)
   container.addView(webView)
```
