package com.nzis.ignatovsoft.models.nhis.auth;
import jakarta.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contentsS001", namespace = "https://www.his.bg")
public class ContentsS001 {
    @XmlElement(name = "accessToken", namespace = "https://www.his.bg", required = true)
    protected AccessTokenBase accessToken;
    @XmlElement(name = "tokenType", namespace = "https://www.his.bg", required = true)
    protected TokenTypeBase tokenType;
    @XmlElement(name = "expiresIn", namespace = "https://www.his.bg", required = true)
    protected ExpiresInBase expiresIn;
    @XmlElement(name = "issuedOn", namespace = "https://www.his.bg", required = true)
    protected IssuedOnBase issuedOn;
    @XmlElement(name = "expiresOn", namespace = "https://www.his.bg", required = true)
    protected ExpiresOnBase expiresOn;

    public AccessTokenBase getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessTokenBase accessToken) {
        this.accessToken = accessToken;
    }

    public TokenTypeBase getTokenType() {
        return tokenType;
    }

    public void setTokenType(TokenTypeBase tokenType) {
        this.tokenType = tokenType;
    }

    public ExpiresInBase getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(ExpiresInBase expiresIn) {
        this.expiresIn = expiresIn;
    }

    public IssuedOnBase getIssuedOn() {
        return issuedOn;
    }

    public void setIssuedOn(IssuedOnBase issuedOn) {
        this.issuedOn = issuedOn;
    }

    public ExpiresOnBase getExpiresOn() {
        return expiresOn;
    }

    public void setExpiresOn(ExpiresOnBase expiresOn) {
        this.expiresOn = expiresOn;
    }
}
