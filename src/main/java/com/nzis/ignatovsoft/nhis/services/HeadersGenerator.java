package com.nzis.ignatovsoft.nhis.services;

import com.nzis.ignatovsoft.database.localdb.models.PracticeInfo;
import com.nzis.ignatovsoft.dataservices.SettingsDataService;
import com.nzis.ignatovsoft.nhis.models.generated.*;
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

    private static String getRandomUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
