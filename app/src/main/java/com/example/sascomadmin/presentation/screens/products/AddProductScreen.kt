import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.sascomadmin.data.model.Product
import com.example.sascomadmin.presentation.viewmodel.ProductViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductScreen(
    viewModel: ProductViewModel = hiltViewModel(),
    onProductAdded: () -> Unit,
    navController: NavController
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var imageUrl by remember { mutableStateOf("") }
    var brand by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var stock by remember { mutableStateOf("") }
    var discountPercentage by remember { mutableStateOf("") }
    var thumbnail by remember { mutableStateOf("") }
    var rating by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Add Product") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(scrollState)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("Title") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = description, onValueChange = { description = it }, label = { Text("Description") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = price, onValueChange = { price = it }, label = { Text("Price") }, modifier = Modifier.fillMaxWidth())

            OutlinedTextField(value = brand, onValueChange = { brand = it }, label = { Text("Brand") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = category, onValueChange = { category = it }, label = { Text("Category") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = stock, onValueChange = { stock = it }, label = { Text("Stock") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = discountPercentage, onValueChange = { discountPercentage = it }, label = { Text("Discount %") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = rating, onValueChange = { rating = it }, label = { Text("Rating") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = imageUrl, onValueChange = { imageUrl = it }, label = { Text("Image URL") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = thumbnail, onValueChange = { thumbnail = it }, label = { Text("Thumbnail URL") }, modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val product = Product(
                        id = System.currentTimeMillis().toInt(),
                        title = title,
                        description = description,
                        price = price.toDoubleOrNull() ?: 0.0,
                        images = listOf(imageUrl),
                        category = category,
                        stock = stock.toIntOrNull() ?: 0,
                        rating = rating.toDoubleOrNull() ?: 0.0,
                        discountPercentage = discountPercentage.toDoubleOrNull() ?: 0.0,
                        brand = brand
                    )
                    viewModel.addProduct(product)
                    onProductAdded()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Add Product")
            }
        }
    }
}
