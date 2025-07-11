import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

data class ShoppingItem(
    var id: Int,
    var name: String,
    var quantity: Int,
    var isEditing: Boolean = false
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListApp() {
    var sItems by remember { mutableStateOf(listOf<ShoppingItem>()) }

    var dialogBox by remember { mutableStateOf(false) }
    var itemsName by remember { mutableStateOf("") }
    var itemsQuantity by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
        verticalArrangement = Arrangement.Center,
    ) {
        Button(
            onClick = {
                dialogBox = true
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("items")
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(sItems) {
                // Display items here
            }
        }
    }

    if (dialogBox) {
        AlertDialog(
            onDismissRequest = { dialogBox = false },
            confirmButton = {}, // Add button logic if needed
            title = { Text("Adding Shopping items") },
            text = {
                Column {
                    OutlinedTextField(
                        value = itemsName,
                        onValueChange = { itemsName = it },
                        label = { Text("Enter Item's Name") }
                    )

                    Spacer(modifier = Modifier.padding(5.9.dp))

                    OutlinedTextField(
                        value = itemsQuantity,
                        onValueChange = { itemsQuantity = it },
                        label = { Text("Enter Item's Quantity") }
                    )
                }
            }
        )

    }
}
