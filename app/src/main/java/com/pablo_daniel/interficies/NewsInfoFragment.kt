import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.pablo_daniel.interficies.R

class NewsInfoFragment : Fragment() {

    companion object {
        private const val ARG_TEXTO_DINAMICO = "ARG_TEXTO_DINAMICO"

        fun newInstance(textoDinamico: String): NewsInfoFragment {
            val fragment = NewsInfoFragment()
            val args = Bundle()
            args.putString(ARG_TEXTO_DINAMICO, textoDinamico)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news_info, container, false)
        val textContent: TextView = view.findViewById(R.id.textContent)

        // Obtén el texto dinámicamente de los argumentos del fragmento
        val textoDinamico = arguments?.getString(ARG_TEXTO_DINAMICO) ?: ""
        textContent.text = textoDinamico

        return view
    }
}

