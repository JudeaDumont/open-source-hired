package com.example.model.ResumeBundle.Members.Persist;

import com.example.model.ID;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(appliesTo = "PlainTextPDFWord")
public class FileBundle implements ID {

    @Id
    @SequenceGenerator(
            name = "plaintextpdfword_sequence",
            sequenceName = "plaintextpdfword_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "plaintextpdfword_sequence"
    )
    private Long id;
    private String name;

    private String plainTextToMatch;
    private UUID pdfGuid;
    private UUID wordGuid;

    public FileBundle() {
    }

    public FileBundle(
            @JsonProperty("plainTextToMatch") String plainTextToMatch,
            @JsonProperty("pdfGuid") UUID pdfGuid,
            @JsonProperty("wordGuid") UUID wordGuid) {
        this.plainTextToMatch = plainTextToMatch;
        this.pdfGuid = pdfGuid;
        this.wordGuid = wordGuid;
    }

    public FileBundle(UUID uuid, String plainTextToMatch) {
        setPdfGuid(uuid);
        setWordGuid(uuid);
        setPlainTextToMatch(plainTextToMatch);
    }

    @Column
    public String getPlainTextToMatch() {
        return plainTextToMatch;
    }

    public void setPlainTextToMatch(String plainTextToMatch) {
        this.plainTextToMatch = plainTextToMatch;
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
}
