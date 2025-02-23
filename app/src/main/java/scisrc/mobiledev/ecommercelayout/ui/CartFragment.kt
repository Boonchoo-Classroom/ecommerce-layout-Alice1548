package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    private lateinit var cartAdapter: ProductAdapter
    private val cartList = mutableListOf<Product>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 🔹 ตั้งค่า RecyclerView สำหรับตะกร้าสินค้า
        binding.recyclerViewCart.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        cartAdapter = ProductAdapter(cartList)
        binding.recyclerViewCart.adapter = cartAdapter

        loadCartItems()
    }

    private fun loadCartItems() {
        cartList.clear()
        cartList.add(Product("ไก่ย่าง", "20 บาท", R.drawable.kai, "อร่อยชัวร์")) // ✅ เพิ่มสินค้าลงในตะกร้า
        cartAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
