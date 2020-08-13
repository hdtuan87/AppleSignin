package tuanhd.libs.signinwithapple

import android.content.Context
import android.webkit.WebView

class SignInAppleWebView (context: Context?, callbackScheme: String, callback: (String) -> Unit): WebView(context){
    init {
        settings.apply {
            javaScriptEnabled = true
            javaScriptCanOpenWindowsAutomatically = true
        }

        webViewClient =
            SignInAppleWebClient(callbackScheme, callback)
    }
}