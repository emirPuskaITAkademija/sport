module ba.smoki.sport {
    requires java.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.sql.rowset;
    requires mysql.connector.j;


    opens ba.smoki.sport to javafx.fxml;
    opens ba.smoki.sport.sport to javafx.base;
    exports ba.smoki.sport;
}