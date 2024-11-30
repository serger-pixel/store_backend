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

    private String _fileName;
    private String _fileType;
    private int _fileSize;

    @Lob
    private byte[] _bytes;

    public Image(int id, String fileName, String filePath, String fileType, int fileSize) {
        this._id = id;
        this._fileName = fileName;
        this._fileType = fileType;
        this._fileSize = fileSize;
    }

    public int getId() {
        return _id;
    }

    public int getFileSize() {
        return _fileSize;
    }

    public String getFileType() {
        return _fileType;
    }

    public String getFileName() {
        return _fileName;
    }

    public void setId(int id) {
        this._id = _id;
    }

    public void setFileSize(int fileSize) {
        this._fileSize = _fileSize;
    }

    public void setFileType(String fileType) {
        this._fileType = _fileType;
    }

    public void setFileName(String fileName) {
        this._fileName = _fileName;
    }

    public void setBytes(byte[] bytes){
        this._bytes = bytes;
    }

    public byte[] getBytes(){
        return this._bytes;
    }
}