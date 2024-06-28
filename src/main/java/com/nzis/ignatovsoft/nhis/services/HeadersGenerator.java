package com.nzis.ignatovsoft.nhis.services;

import com.nzis.ignatovsoft.configurations.application.DoctorInfo;
import com.nzis.ignatovsoft.nhis.models.generated.*;
import com.nzis.ignatovsoft.nhis.services.mappers.HeadersInfoConstants;

import java.util.Calendar;
import java.util.UUID;

public class HeadersGenerator {

    public static Header generateHeaders(String messageTypeValue) {
        DoctorInfo doctorInfo = new DoctorInfo();
        Header header = new Header();

        MessageSender sender = new MessageSender();
        sender.setValue(HeadersInfoConstants.SENDER_TYPE);
        header.setSender(sender);

        MessageSenderId senderId = new MessageSenderId();
        senderId.setValue(doctorInfo.getDoctorsId());
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

    private static String getRandomUUID () {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
