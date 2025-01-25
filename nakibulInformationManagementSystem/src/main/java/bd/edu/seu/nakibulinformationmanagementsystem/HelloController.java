package bd.edu.seu.nakibulinformationmanagementsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TableView<Inventory> inventoryTableView;

    @FXML
    private TextField itemTextField;

    @FXML
    private TableColumn<Inventory, String> itemCol;

    @FXML
    private TableColumn<Inventory, Double> priceCol;

    @FXML
    private TableColumn<Inventory, Integer> quantityCol;

    @FXML
    private TextField quantityTextField;

    @FXML
    private TableColumn<Inventory, String> supplierCol;

    @FXML
    private TextField suppliersTextField;

    @FXML
    private TableColumn<Inventory, Double> totalPriceCol;

    @FXML
    private TextField unitTextField;

    @FXML
    void handlesResetAction(ActionEvent event) {
        itemTextField.clear();
        quantityTextField.clear();
        suppliersTextField.clear();
        unitTextField.clear();
    }

    @FXML
    void handlesSaveAction(ActionEvent event) {
        String item = itemTextField.getText();
        int quantity = Integer.parseInt(quantityTextField.getText());
        String supplier = suppliersTextField.getText();
        double price = Double.parseDouble(unitTextField.getText());
        double totalPrice = quantity * price;

        String insertQuery = String.format("INSERT INTO inventory VALUES('%s', %f, %d, '%s', %f)", item, price, quantity, supplier, totalPrice);
        try {
            DBConnection.getStatement().executeUpdate(insertQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private ObservableList<Inventory> getintInventoryList() {
        ObservableList<Inventory> inventoryList = FXCollections.observableArrayList();
        String selectQuery = "SELECT * FROM inventory";
        try {
            ResultSet resultSet = DBConnection.getStatement().executeQuery(selectQuery);
            while (resultSet.next()) {
                String item = resultSet.getString("item");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String supplier = resultSet.getString("supplier");
                double totalPrice = resultSet.getDouble("totalPrice");

                Inventory inventory = new Inventory(item, price, quantity, supplier, totalPrice);
                inventoryList.add(inventory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inventoryList;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemCol.setCellValueFactory(new PropertyValueFactory<>("item"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        supplierCol.setCellValueFactory(new PropertyValueFactory<>("supplier"));
        totalPriceCol.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));

        inventoryTableView.setItems(getintInventoryList());
    }
}