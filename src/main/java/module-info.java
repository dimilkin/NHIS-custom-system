module com.nzis.ignatovsoft {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;

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
    opens com.nzis.ignatovsoft.nhis.models.nhis to jakarta.xml.bind;
    opens com.nzis.ignatovsoft.nhis.services to javafx.fxml;
    opens com.nzis.ignatovsoft.nhis.models.nhis.auth to jakarta.xml.bind;
    opens com.nzis.ignatovsoft.nhis.models.nhis.x001 to jakarta.xml.bind;
    opens com.nzis.ignatovsoft.nhis.models.generated to org.glassfish.jaxb.runtime;

    exports com.nzis.ignatovsoft;
    exports com.nzis.ignatovsoft.nhis.services;
    exports com.nzis.ignatovsoft.front.models;
    exports com.nzis.ignatovsoft.front.controllers;
    exports com.nzis.ignatovsoft.nhis.models.nhis;
    exports com.nzis.ignatovsoft.nhis.models.generated;
    exports com.nzis.ignatovsoft.dtos;
}