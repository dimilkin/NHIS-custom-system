package com.nzis.ignatovsoft.nhis.services;

import com.nzis.ignatovsoft.database.localdb.models.PracticeInfo;
import com.nzis.ignatovsoft.dataservices.SettingsDataService;
import com.nzis.ignatovsoft.nhis.models.generated.*;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.DateTimeValueBase;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.IntValueBase;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.MessageHeaderV3;
import com.nzis.ignatovsoft.nhis.models.nhis.v3.common.StringValueBase;
import com.nzis.ignatovsoft.nhis.services.mappers.HeadersInfoConstants;

import java.util.Calendar;
import java.util.UUID;

public class HeadersGenerator {

    SettingsDataService settingsDataService = new SettingsDataService();
    PracticeInfo practiceInfo = settingsDataService.getSettings();

    public Header generateHeaders(String messageTypeValue) {;
        Header header = new Header();

        MessageSender sender = new MessageSender();
        sender.setValue(HeadersInfoConstants.SENDER_TYPE);
        header.setSender(sender);

        MessageSenderId senderId = new MessageSenderId();
        senderId.setValue(practiceInfo.getDoctorId());
        header.setSenderId(senderId);

        MessageSenderISName senderISName = new MessageSenderISName();
        senderISName.setValue("IgnatovSoft");
        header.setSenderISName(senderISName);

        MessageRecipient recipient = new MessageRecipient();
        recipient.setValue("4");
        header.setRecipient(recipient);

        MessageRecipientId recipientId = new MessageRecipientId();
        recipientId.setValue("NHIS");
        header.setRecipientId(recipientId);

        MessageId messageId = new MessageId();
        messageId.setValue(getRandomUUID());
        header.setMessageId(messageId);

        MessageType messageType = new MessageType();
        messageType.setValue(messageTypeValue);
        header.setMessageType(messageType);

        MessageCreatedOn createdOn = new MessageCreatedOn();
        createdOn.setValue(Calendar.getInstance());
        header.setCreatedOn(createdOn);

        return header;
    }

    public MessageHeaderV3 generateHeadersV3(String messageTypeValue) {
        MessageHeaderV3 header = new MessageHeaderV3();

        header.setSender(new IntValueBase(Integer.parseInt(HeadersInfoConstants.SENDER_TYPE)));
        header.setSenderId(new StringValueBase(practiceInfo.getDoctorId()));
        header.setSenderISName(new StringValueBase("IgnatovSoft"));
        header.setRecipient(new IntValueBase(Integer.parseInt(HeadersInfoConstants.RECIPIENT)));
        header.setRecipientId(new StringValueBase(HeadersInfoConstants.RECIPIENT_ID));
        header.setMessageId(new StringValueBase(getRandomUUID()));
        header.setMessageType(new StringValueBase(messageTypeValue));
        header.setCreatedOn(new DateTimeValueBase(Calendar.getInstance()));

        return header;
    }

    private static String getRandomUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
