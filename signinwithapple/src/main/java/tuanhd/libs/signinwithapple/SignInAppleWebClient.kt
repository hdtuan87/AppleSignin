package tuanhd.libs.signinwithapple

import android.net.Uri
import android.os.Build
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi

internal class SignInAppleWebClient(
    private val callbackScheme: String,
    private val callback: (String) -> Unit
) :
    WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        return isUrlOverridden(Uri.parse(url))
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        return isUrlOverridden(request?.url)
    }

    private fun isUrlOverridden(url: Uri?): Boolean {
        return when {
            url == null -> {
                false
            }
            url.toString().contains(callbackScheme) -> {
                parserURL(url.toString())
                true
            }
            else -> {
                false
            }
        }
    }

    private fun parserURL(url: String) {
        val obj = url.substring(callbackScheme.length, url.length)
        callback.invoke(obj)
    }
}