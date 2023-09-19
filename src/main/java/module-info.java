module com.derekporcelli.two_zero_four_eight {
    requires javafx.controls;
    requires javafx.fxml;
    
    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    
    opens com.derekporcelli.two_zero_four_eight to javafx.fxml;
    exports com.derekporcelli.two_zero_four_eight;
}