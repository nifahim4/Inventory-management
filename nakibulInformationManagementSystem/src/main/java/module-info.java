module bd.edu.seu.nakibulinformationmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens bd.edu.seu.nakibulinformationmanagementsystem to javafx.fxml;
    exports bd.edu.seu.nakibulinformationmanagementsystem;
}