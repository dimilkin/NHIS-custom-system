package com.nzis.ignatovsoft.nhis.models.nhis.v3.common;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "messageHeader", propOrder = {
        "sender",
        "senderId",
        "senderISName",
        "recipient",
        "recipientId",
        "messageId",
        "messageType",
        "createdOn"
})
public class MessageHeaderV3 {

    @XmlElement(name = "sender", namespace = "http://www.his.bg/", required = true)
    protected IntValueBase sender;
    @XmlElement(name = "senderId", namespace = "http://www.his.bg/", required = true)
    protected StringValueBase senderId;
    @XmlElement(name = "senderISName", namespace = "http://www.his.bg/")
    protected StringValueBase senderISName;
    @XmlElement(name = "recipient", namespace = "http://www.his.bg/", required = true)
    protected IntValueBase recipient;
    @XmlElement(name = "recipientId", namespace = "http://www.his.bg/", required = true)
    protected StringValueBase recipientId;
    @XmlElement(name = "messageId", namespace = "http://www.his.bg/", required = true)
    protected StringValueBase messageId;
    @XmlElement(name = "messageType", namespace = "http://www.his.bg/", required = true)
    protected StringValueBase messageType;
    @XmlElement(name = "createdOn", namespace = "http://www.his.bg/", required = true)
    protected DateTimeValueBase createdOn;

    public IntValueBase getSender() {
        return sender;
    }

    public void setSender(IntValueBase sender) {
        this.sender = sender;
    }

    public StringValueBase getSenderId() {
        return senderId;
    }

    public void setSenderId(StringValueBase senderId) {
        this.senderId = senderId;
    }

    public StringValueBase getSenderISName() {
        return senderISName;
    }

    public void setSenderISName(StringValueBase senderISName) {
        this.senderISName = senderISName;
    }

    public IntValueBase getRecipient() {
        return recipient;
    }

    public void setRecipient(IntValueBase recipient) {
        this.recipient = recipient;
    }

    public StringValueBase getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(StringValueBase recipientId) {
        this.recipientId = recipientId;
    }

    public StringValueBase getMessageId() {
        return messageId;
    }

    public void setMessageId(StringValueBase messageId) {
        this.messageId = messageId;
    }

    public StringValueBase getMessageType() {
        return messageType;
    }

    public void setMessageType(StringValueBase messageType) {
        this.messageType = messageType;
    }

    public DateTimeValueBase getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(DateTimeValueBase createdOn) {
        this.createdOn = createdOn;
    }
}
