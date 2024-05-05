package com.example.model.ResumeBundle.Members.Persist;

import com.example.model.ID;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.UUID;

@Entity
@Table(appliesTo = "PlainTextPDFWord")
public class ResumeBundlePersist implements ID {

    @Id
    @SequenceGenerator(
            name = "resumebundle_sequence",
            sequenceName = "resumebundle_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "resumebundle_sequence"
    )
    private Long id;
    private String name;
    private String plainTextToMatch;
    private UUID pdfGuid;
    private UUID wordGuid;
    private UUID plainTextGuid;
    private UUID jobDescriptionGuid;
    private String jobDescriptionName;

    public ResumeBundlePersist() {
    }

    public ResumeBundlePersist(
            @JsonProperty("id") Long id,
            @JsonProperty("name") String name,
            @JsonProperty("plainTextToMatch") String plainTextToMatch,
            @JsonProperty("pdfGuid") UUID pdfGuid,
            @JsonProperty("wordGuid") UUID wordGuid,
            @JsonProperty("plainTextGuid") UUID plainTextGuid,
            @JsonProperty("jobDescriptionGuid") UUID jobDescriptionGuid) {
        this.id = id;
        this.pdfGuid = pdfGuid;
        this.wordGuid = wordGuid;
        this.plainTextGuid = plainTextGuid;
        this.jobDescriptionGuid = jobDescriptionGuid;
        this.plainTextToMatch = plainTextToMatch;
        this.name = name;
    }

    public ResumeBundlePersist(
            @JsonProperty("plainTextToMatch") String plainTextToMatch,
            @JsonProperty("pdfGuid") UUID pdfGuid,
            @JsonProperty("wordGuid") UUID wordGuid,
            @JsonProperty("plainTextGuid") UUID plainTextGuid,
            @JsonProperty("name") String name) {
        this.plainTextToMatch = plainTextToMatch;
        this.pdfGuid = pdfGuid;
        this.wordGuid = wordGuid;
        this.plainTextGuid = plainTextGuid;
        this.name = name;
    }

    public ResumeBundlePersist(
            String plainTextToMatch,
            String bundleName) {
        this.plainTextToMatch = plainTextToMatch;
        name = bundleName;
    }

    public ResumeBundlePersist(
            FileBundle fileBundle,
            String bundleName,
            UUID uuid) {
        plainTextToMatch = fileBundle.getPlainTextToMatch();
        pdfGuid = uuid;
        wordGuid = uuid;
        plainTextGuid = uuid;
        jobDescriptionGuid = uuid;
        name = bundleName;
    }

    public ResumeBundlePersist(
            @JsonProperty("uuidString")
            UUID uuidString,
            @JsonProperty("bundleName")
            String bundleName,
            @JsonProperty("jobDescriptionName")
            String jobDescriptionName) {
        //This essentially means that
        //if there is no associated file (like plain text)
        // and the file needs to be written
        // it would pull the guid as the name of the file.
        this.plainTextGuid = uuidString;
        this.pdfGuid = uuidString;
        this.wordGuid = uuidString;
        this.jobDescriptionGuid = uuidString;
        this.jobDescriptionName = jobDescriptionName;
        this.name = bundleName;
    }

    public ResumeBundlePersist(ResultSet resultSet) throws SQLException {
        setId(resultSet.getLong("id"));
        setName(resultSet.getString("name"));
        setPlainTextToMatch(resultSet.getString("plainTextToMatch"));
        setPlainTextGuid(resultSet.getString("plaintextguid") != null ?
                UUID.fromString(resultSet.getString("plaintextguid")) : null);
        setPdfGuid(resultSet.getString("pdfguid") != null ?
                UUID.fromString(resultSet.getString("pdfguid")) : null);
        setWordGuid(resultSet.getString("wordGuid") != null ?
                UUID.fromString(resultSet.getString("wordGuid")) : null);
        setJobDescriptionGuid(resultSet.getString("jobDescriptionGuid") != null ?
                UUID.fromString(resultSet.getString("jobDescriptionGuid")) : null);
    }

    @Column
    public Hashtable<String, ArrayList<String>> getTieredMatchKeywords() {
        return new Hashtable<>();
    }

    @Column
    public String getPlainTextToMatch() {
        return plainTextToMatch;
    }

    public void setPlainTextToMatch(String plainTextToMatch) {
        this.plainTextToMatch = plainTextToMatch;
    }

    @Column
    public String getJobDescriptionName() {
        return jobDescriptionName;
    }

    public void setJobDescriptionName(String jobDescriptionName) {
        this.jobDescriptionName = jobDescriptionName;
    }

    @Column
    public UUID getPdfGuid() {
        return pdfGuid;
    }

    public void setPdfGuid(UUID pdfGuid) {
        this.pdfGuid = pdfGuid;
    }

    @Column
    public UUID getWordGuid() {
        return wordGuid;
    }

    public void setWordGuid(UUID wordGuid) {
        this.wordGuid = wordGuid;
    }

    @Column
    public UUID getPlainTextGuid() {
        return plainTextGuid;
    }

    public void setPlainTextGuid(UUID plainTextGuid) {
        this.plainTextGuid = plainTextGuid;
    }

    @Column
    public UUID getJobDescriptionGuid() {
        return jobDescriptionGuid;
    }

    public void setJobDescriptionGuid(UUID jobDescriptionGuid) {
        this.jobDescriptionGuid = jobDescriptionGuid;
    }

    @Column
    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
