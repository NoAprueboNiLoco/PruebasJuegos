module com.example.interfaces {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;


    opens com.example.interfaces to javafx.fxml;
    opens Controllers;
    opens Factory;
    opens Relations;
    opens Models;
    opens Interfaces;
    opens HibernateImplementation;

    exports com.example.interfaces;
    exports Controllers;
    exports Factory;
    exports Relations;
    exports Models;
    exports Interfaces;
    exports HibernateImplementation;


}