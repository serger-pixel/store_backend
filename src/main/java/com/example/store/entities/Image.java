package com.example.store.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;



@Entity
@Table
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int _id;

    private String _fileType;
    private Long _fileSize;

    @Lob
    private byte[] _bytes;

    public Image(String fileType, Long fileSize, byte[] bytes) {
        this._fileType = fileType;
        this._fileSize = fileSize;
        this._bytes = bytes;
    }

    public int getId() {
        return _id;
    }

    public Long getFileSize() {
        return _fileSize;
    }

    public String getFileType() {
        return _fileType;
    }


    public void setId(int id) {
        this._id = id;
    }

    public void setFileSize(Long fileSize) {
        this._fileSize = fileSize;
    }

    public void setFileType(String fileType) {
        this._fileType = _fileType;
    }

    public void setBytes(byte[] bytes){
        this._bytes = bytes;
    }

    public byte[] getBytes(){
        return this._bytes;
    }
}