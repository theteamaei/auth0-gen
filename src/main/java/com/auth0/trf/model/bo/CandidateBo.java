package com.auth0.trf.model.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = "CANDIDAT")
public class CandidateBo implements Serializable {

    @Id
    @Column(name = "CANDIDATE_NUMBER", nullable = false)
    private String candidateNumber;

    @Id
    @Column(name = "CENTRE_NUMBER", updatable = false)
    private String centreNumber;

    @Id
    @Column(name = "TEST_DATE")
    private Date testDate;

    @Column(name = "FAMILY_NAME")
    private String familyName;

    @Column(name = "GIVEN_NAME")
    private String givenName;

    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "CERTID")
    private String certid;

    @Column(name = "ID_NUMBER")
    private String idNumber;

    @Column(name = "RESIT")
    private Integer resit;

    @Column(name = "RESIT_DATE")
    private Date resitDate;

    @Column(name = "OVERALL_RESULT")
    private Integer overallResult;

    @Column(name = "R_BAND_SCORE")
    private Integer rBandScore;

    @Column(name = "L_BAND_SCORE")
    private Integer lBandScore;

    @Column(name = "W_BAND_SCORE")
    private Integer wBandScore;

    @Column(name = "S_BAND_SCORE")
    private Integer sBandScore;

    @Column(name = "PHOTO")
    private Blob photo;

    public String getCandidateNumber() {
        return candidateNumber;
    }

    public void setCandidateNumber(String candidateNumber) {
        this.candidateNumber = candidateNumber;
    }

    public String getCentreNumber() {
        return centreNumber;
    }

    public void setCentreNumber(String centreNumber) {
        this.centreNumber = centreNumber;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCertid() {
        return certid;
    }

    public void setCertid(String certid) {
        this.certid = certid;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public Integer getResit() {
        return resit;
    }

    public void setResit(Integer resit) {
        this.resit = resit;
    }

    public Date getResitDate() {
        return resitDate;
    }

    public void setResitDate(Date resitDate) {
        this.resitDate = resitDate;
    }

    public Integer getOverallResult() {
        return overallResult;
    }

    public void setOverallResult(Integer overallResult) {
        this.overallResult = overallResult;
    }

    public Integer getrBandScore() {
        return rBandScore;
    }

    public void setrBandScore(Integer rBandScore) {
        this.rBandScore = rBandScore;
    }

    public Integer getlBandScore() {
        return lBandScore;
    }

    public void setlBandScore(Integer lBandScore) {
        this.lBandScore = lBandScore;
    }

    public Integer getwBandScore() {
        return wBandScore;
    }

    public void setwBandScore(Integer wBandScore) {
        this.wBandScore = wBandScore;
    }

    public Integer getsBandScore() {
        return sBandScore;
    }

    public void setsBandScore(Integer sBandScore) {
        this.sBandScore = sBandScore;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

}
