package tuanhd.libs.signinapple

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import tuanhd.libs.signinwithapple.SignInAppleWebView

class SignInWithAppleFragment : Fragment() {
    companion object {
        private const val KEY_URL = "KEY_URL"

        fun newInstance(url: String): Fragment {
            val f = SignInWithAppleFragment()
            val args = Bundle().apply {
                putString(KEY_URL, url)
            }
            f.arguments = args
            return f
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val webView = SignInAppleWebView(context, "apple.signin.moneylover://callback/") {
            Log.e("SignInWithAppleFragment", "callback: $it")
        }
        webView.loadUrl(arguments!!.getString(KEY_URL))
        return webView
    }
}