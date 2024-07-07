package com.nzis.ignatovsoft.nhis.services.mappers;

import com.nzis.ignatovsoft.nhis.models.generated.Header;
import com.nzis.ignatovsoft.nhis.models.generated.NomenclatureIdBase;
import com.nzis.ignatovsoft.nhis.models.nhis.nomenclatures.c001.ContentsC001;
import com.nzis.ignatovsoft.nhis.models.nhis.nomenclatures.c001.MessageC001;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.StringWriter;

import static com.nzis.ignatovsoft.nhis.services.HeadersGenerator.generateHeaders;

public class RequiredNomenclaturesMarshalling {


    public String getMarshalledRequestBody(String nomenclatureType) {

        try {
            return marshalRequestBody(nomenclatureType);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String marshalRequestBody(String nomenclatureType) throws JAXBException {

        Header header = generateHeaders(HeadersInfoConstants.MESSAGE_TYPE_C001);
        ContentsC001 contents = generateContents(nomenclatureType);

        MessageC001 messageC001 = new MessageC001();
        messageC001.setContents(contents);
        messageC001.setHeader(header);

        JAXBContext context = JAXBContext.newInstance(MessageC001.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

        StringWriter sw = new StringWriter();
        marshaller.marshal(messageC001, sw);
        return sw.toString();

    }

    private ContentsC001 generateContents(String nomenclatureType) {
        ContentsC001 contentsC001 = new ContentsC001();
        NomenclatureIdBase nomenclatureId = new NomenclatureIdBase();
        nomenclatureId.setValue(nomenclatureType);
        contentsC001.getNomenclatureId().add(nomenclatureId);
        return contentsC001;
    }
}
