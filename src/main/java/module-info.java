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
    requires java.naming;
    requires java.net.http;
    requires jakarta.xml.bind;

    opens com.nzis.ignatovsoft to javafx.fxml;
    opens com.nzis.ignatovsoft.models.nhis to jakarta.xml.bind;
    opens com.nzis.ignatovsoft.services to javafx.fxml;
    opens com.nzis.ignatovsoft.models.generated.https.www_his to jakarta.xml.bind;

    exports com.nzis.ignatovsoft;
    exports com.nzis.ignatovsoft.services;
    exports com.nzis.ignatovsoft.front.models;
    exports com.nzis.ignatovsoft.front.controllers;
    exports com.nzis.ignatovsoft.models.nhis;
}