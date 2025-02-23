package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.databinding.FragmentProductsBinding

class ProductsFragment : Fragment() {

    private var _binding: FragmentProductsBinding? = null
    private val binding get() = _binding!!

    private lateinit var productAdapter: ProductAdapter
    private val productList = mutableListOf<Product>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 🔹 ตั้งค่า RecyclerView สำหรับรายการสินค้า
        binding.recyclerViewProducts.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        productAdapter = ProductAdapter(productList)
        binding.recyclerViewProducts.adapter = productAdapter

        loadProducts()
    }

    private fun loadProducts() {
        productList.clear()
        productList.add(Product("ส้มตำ", "129 บาท", R.drawable.somtom, "อร่อยชัวร์"))
        productList.add(Product("ไก่ย่าง", "20 บาท", R.drawable.kai, "อร่อยชัวร์"))
        productList.add(Product("คอหมูย่าง", "50 บาท", R.drawable.pork, "อร่อยชัวร์"))
        productList.add(Product("ข้าวเหนียว", "10 บาท", R.drawable.khow, "อร่อยชัวร์"))
        productAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
