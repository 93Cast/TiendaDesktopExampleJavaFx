package sv.arrupe.tienda;

import sv.arrupe.tienda.dao.ProductoDAO;
import sv.arrupe.tienda.model.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtPrecio;
    @FXML private TextField txtStock;
    @FXML private TableView<Producto> tablaProductos;
    @FXML private TableColumn<Producto, Integer> colId;
    @FXML private TableColumn<Producto, String> colNombre;
    @FXML private TableColumn<Producto, Double> colPrecio;
    @FXML private TableColumn<Producto, Integer> colStock;

    private ProductoDAO dao = new ProductoDAO();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(data ->
                new javafx.beans.property.SimpleIntegerProperty(data.getValue().getId()).asObject());
        colNombre.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(data.getValue().getNombre()));
        colPrecio.setCellValueFactory(data ->
                new javafx.beans.property.SimpleDoubleProperty(data.getValue().getPrecio()).asObject());
        colStock.setCellValueFactory(data ->
                new javafx.beans.property.SimpleIntegerProperty(data.getValue().getStock()).asObject());

        cargarDatos();
    }

    private void cargarDatos() {
        ObservableList<Producto> lista = FXCollections.observableArrayList(dao.listar());
        tablaProductos.setItems(lista);
    }

    @FXML
    private void agregarProducto() {
        Producto p = new Producto(
                txtNombre.getText(),
                Double.parseDouble(txtPrecio.getText()),
                Integer.parseInt(txtStock.getText())
        );

        dao.insertar(p);
        cargarDatos();
    }

    @FXML
    private void eliminarProducto() {
        Producto seleccionado = tablaProductos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            dao.eliminar(seleccionado.getId());
            cargarDatos();
        }
    }
}