import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pablo_daniel.interficies.R
import com.pablo_daniel.interficies.clases.CustomAdapter
import com.pablo_daniel.interficies.clases.ListItem

class NewsFragment: Fragment() {

    private lateinit var items: List<ListItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        items = listOf(
            ListItem(R.drawable.newsimage1, "Texto para la imagen 1", NewsInfoFragment::class.java) { position ->
                navigateToNewsInfoActivity(items[position].text)
            },
            ListItem(R.drawable.newsimage2, "Texto para la imagen 2", NewsInfoFragment::class.java) { position ->
                navigateToNewsInfoActivity(items[position].text)
            },
            ListItem(R.drawable.newsimage2, "Texto para la imagen 3", NewsInfoFragment::class.java) { position ->
                navigateToNewsInfoActivity(items[position].text)
            },
            ListItem(R.drawable.newsimage2, "Texto para la imagen 4", NewsInfoFragment::class.java) { position ->
                navigateToNewsInfoActivity(items[position].text)
            }
        )

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = CustomAdapter(requireContext(), items)

        val dividerItemDecoration = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)

        return view
    }

    private fun navigateToNewsInfoActivity(textoDinamico: String) {
        val intent = Intent(requireContext(), NewsInfoFragment::class.java)
        intent.putExtra("textoDinamico", textoDinamico)
        startActivity(intent)
    }
}
