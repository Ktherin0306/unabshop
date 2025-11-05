package me.angiesuarez.unabshop.ui.theme

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class FirestoreRepository {

    private val db = FirebaseFirestore.getInstance()
    private val productosRef = db.collection("productos")

    suspend fun agregarProducto(producto: Producto) {
        val docRef = productosRef.document()
        val nuevoProducto = producto.copy(id = docRef.id)
        docRef.set(nuevoProducto).await()
    }

    suspend fun obtenerProductos(): List<Producto> {
        val snapshot = productosRef.get().await()
        return snapshot.documents.mapNotNull { it.toObject(Producto::class.java) }
    }

    suspend fun eliminarProducto(id: String) {
        productosRef.document(id).delete().await()
    }
}
