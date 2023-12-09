module com.nzis.ignatovsoft {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.xml.crypto;
    requires org.hibernate.orm.core;
    requires java.naming;

    opens com.nzis.ignatovsoft to javafx.fxml;
    exports com.nzis.ignatovsoft;
    exports com.nzis.ignatovsoft.services;
    exports com.nzis.ignatovsoft.models;
    exports com.nzis.ignatovsoft.front.models;
    exports com.nzis.ignatovsoft.front.controllers;
    opens com.nzis.ignatovsoft.services to javafx.fxml;
    exports com.nzis.ignatovsoft.models.openexam;
}