package com.nzis.ignatovsoft.models.nhis;
import com.nzis.ignatovsoft.models.entities.Patient;

import jakarta.xml.bind.annotation.*;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "message", namespace = "https://www.his.bg")
public class StartExaminationRequest {

    @XmlElement(name = "header", required = true)
    private Header header;

    @XmlElement(name = "contents", required = true)
    private Contents contents;

    public StartExaminationRequest() {
    }

    public StartExaminationRequest(Header header, Contents contents) {
        this.header = header;
        this.contents = contents;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Contents getContents() {
        return contents;
    }

    public void setContents(Contents contents) {
        this.contents = contents;
    }

    // Nested static classes for contents and examination
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Contents {
        @XmlElement(name = "examination")
        private Examination examination;

        @XmlElement(name = "subject")
        private Patient subject;

        @XmlElement(name = "performer")
        private Performer performer;

        public Contents(Examination examination, Patient subject, Performer performer) {
            this.examination = examination;
            this.subject = subject;
            this.performer = performer;
        }

        public Examination getExamination() {
            return examination;
        }

        public void setExamination(Examination examination) {
            this.examination = examination;
        }

        public Patient getSubject() {
            return subject;
        }

        public void setSubject(Patient subject) {
            this.subject = subject;
        }

        public Performer getPerformer() {
            return performer;
        }

        public void setPerformer(Performer performer) {
            this.performer = performer;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Examination {
        @XmlElement(name = "lrn")
        private String lrn;

        @XmlElement(name = "openDate")
        private String openDate;

        @XmlElement(name = "class")
        private String classBase;

        @XmlElement(name = "financingSource")
        private String financingSource;

        @XmlElement(name = "rhifAreaNumber")
        private String rhifAreaNumber;

        public Examination(String lrn, String openDate, String classBase, String financingSource, String rhifAreaNumber) {
            this.lrn = lrn;
            this.openDate = openDate;
            this.classBase = classBase;
            this.financingSource = financingSource;
            this.rhifAreaNumber = rhifAreaNumber;
        }

        public String getLrn() {
            return lrn;
        }

        public void setLrn(String lrn) {
            this.lrn = lrn;
        }

        public String getOpenDate() {
            return openDate;
        }

        public void setOpenDate(String openDate) {
            this.openDate = openDate;
        }

        public String getClassBase() {
            return classBase;
        }

        public void setClassBase(String classBase) {
            this.classBase = classBase;
        }

        public String getFinancingSource() {
            return financingSource;
        }

        public void setFinancingSource(String financingSource) {
            this.financingSource = financingSource;
        }

        public String getRhifAreaNumber() {
            return rhifAreaNumber;
        }

        public void setRhifAreaNumber(String rhifAreaNumber) {
            this.rhifAreaNumber = rhifAreaNumber;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Performer {
        @XmlElement(required = true)
        private String pmi;
        @XmlElement(required = true)
        private String qualification; //code
        @XmlElement(required = true)
        private String nhifCode; //code
        @XmlElement(required = true)
        private String practiceNumber;
        @XmlElement(required = true)
        private String role; //code

        public Performer(String pmi, String qualification, String nhifCode, String practiceNumber, String role) {
            this.pmi = pmi;
            this.qualification = qualification;
            this.nhifCode = nhifCode;
            this.practiceNumber = practiceNumber;
            this.role = role;
        }

        public String getPmi() {
            return pmi;
        }

        public void setPmi(String pmi) {
            this.pmi = pmi;
        }

        public String getQualification() {
            return qualification;
        }

        public void setQualification(String qualification) {
            this.qualification = qualification;
        }

        public String getNhifCode() {
            return nhifCode;
        }

        public void setNhifCode(String nhifCode) {
            this.nhifCode = nhifCode;
        }

        public String getPracticeNumber() {
            return practiceNumber;
        }

        public void setPracticeNumber(String practiceNumber) {
            this.practiceNumber = practiceNumber;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }


}
