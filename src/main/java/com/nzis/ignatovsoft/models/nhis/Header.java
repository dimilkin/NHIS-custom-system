package com.nzis.ignatovsoft.models.nhis;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Header {

    @XmlElement(required = true)
    private String sender;
    @XmlElement(required = true)
    private String senderId;
    @XmlElement(required = true)
    private String senderISName;
    @XmlElement(required = true)
    private String recipient;
    @XmlElement(required = true)
    private String recipientId;
    @XmlElement(required = true)
    private String messageId;
    @XmlElement(required = true)
    private String messageType;
    @XmlElement(required = true)
    private String createdOn; //Date

    public Header() {
    }

    public Header(String sender, String senderId, String senderISName, String recipient, String recipientId,
                  String messageId, String messageType, String createdOn) {
        this.sender = sender;
        this.senderId = senderId;
        this.senderISName = senderISName;
        this.recipient = recipient;
        this.recipientId = recipientId;
        this.messageId = messageId;
        this.messageType = messageType;
        this.createdOn = createdOn;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getSenderISName() {
        return senderISName;
    }

    public void setSenderISName(String senderISName) {
        this.senderISName = senderISName;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }
}
