package com.example.store.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

/**
 * Класс-сущность изображения
 */
@Entity
@Table
@NoArgsConstructor
public class Image {

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int _id;

    /**
     * Тип файла
     */
    private String _fileType;

    /**
     * Размер файла
     */
    private Long _fileSize;

    /**
     * Изображение в байтах
     */
    @Lob
    private byte[] _bytes;

    /**
     * Конструтор
     * @param fileType тип файла
     * @param fileSize размер файла
     * @param bytes изображение в байтах
     */
    public Image(String fileType, Long fileSize, byte[] bytes) {
        this._fileType = fileType;
        this._fileSize = fileSize;
        this._bytes = bytes;
    }

    /**
     * Получение идентификатора
     * @return идентификатор
     */
    public int getId() {
        return _id;
    }

    /**
     * Получение размера файла
     * @return размер файла
     */
    public Long getFileSize() {
        return _fileSize;
    }

    /**
     * Получение типа файла
     * @return тип файла
     */
    public String getFileType() {
        return _fileType;
    }

    /**
     * Установка идентификатора изображения
     * @param id идентификатор
     */
    public void setId(int id) {
        this._id = id;
    }

    /**
     * Установка размера файла
     * @param fileSize размер файла
     */
    public void setFileSize(Long fileSize) {
        this._fileSize = fileSize;
    }

    /**
     * Установка типа файла
     * @param fileType тип файла
     */
    public void setFileType(String fileType) {
        this._fileType = _fileType;
    }

    /**
     * Установка изображение в байтах
     * @param bytes изображение в байтах
     */
    public void setBytes(byte[] bytes){
        this._bytes = bytes;
    }

    /**
     * Получение изображения в байтах
     * @return изображение в байтах
     */
    public byte[] getBytes(){
        return this._bytes;
    }
}