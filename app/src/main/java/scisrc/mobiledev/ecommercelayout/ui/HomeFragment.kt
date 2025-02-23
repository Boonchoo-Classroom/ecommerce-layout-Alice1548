package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var productAdapter: ProductAdapter
    private lateinit var promoAdapter: ProductAdapter

    private val productList = mutableListOf<Product>()
    private val promoList = mutableListOf<Product>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 🔹 ตั้งค่า RecyclerView สำหรับสินค้าแนะนำ
        binding.recyclerViewProducts.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        productAdapter = ProductAdapter(productList)
        binding.recyclerViewProducts.adapter = productAdapter

        // 🔹 ตั้งค่า RecyclerView สำหรับโปรโมชั่น
        binding.recyclerViewPromos.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        promoAdapter = ProductAdapter(promoList)
        binding.recyclerViewPromos.adapter = promoAdapter

        // 🔹 โหลดข้อมูล
        loadProducts()
        loadPromotions()
    }

    private fun loadProducts() {
        productList.add(Product("ส้มตำ", "129 บาท", R.drawable.somtom, " อร่อยชัวร์"))
        productList.add(Product("ไก่ย่าง", " 20 บาท", R.drawable.kai, "อร่อยชัวร์"))
        productList.add(Product("คอหมูย่าง", " 50 บาท", R.drawable.pork, "อร่อยชัวร์"))
        productList.add(Product("ข้าวเหนียว", " 10 บาท", R.drawable.khow, "อร่อยชัวร์"))
        productAdapter.notifyDataSetChanged()
    }

    private fun loadPromotions() {
        promoList.add(Product("ไก่ย่าง", "ลดเหลือ 15 บาท", R.drawable.kai, "น่ากินสุดๆ"))
        promoList.add(Product("คอหมูย่าง", "ลดเหลือ 40 บาท", R.drawable.pork, "น่ากินสุดๆ"))
        promoList.add(Product("ส้มตำ", "ลดเหลือ 79 บาท", R.drawable.somtom, "น่ากินสุดๆ"))
        promoList.add(Product("ข้าวเหนียว", "ลดเหลือ 5 บาท", R.drawable.khow, "น่ากินสุดๆ"))
        promoAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
