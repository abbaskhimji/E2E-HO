package com.test.model;

public class FileInfo {

    private String fileType;

    private String mimeType;

    private String fileName;

    private String fileExtension;

    private boolean isSupported;

    public FileInfo(String fileType, String mimeType, String fileName, boolean isSupported) {
        this.fileType = fileType;
        this.mimeType = mimeType;
        this.fileName = fileName;
        this.fileExtension = fileName.split("\\.")[1];
        this.isSupported = isSupported;
    }

    public String getFileType() {
        return fileType;
    }

    public String getMimeType() {
        return mimeType;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public boolean isSupported() {
        return isSupported;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileInfo fileInfo = (FileInfo) o;

        if (isSupported != fileInfo.isSupported) return false;
        if (fileType != null ? !fileType.equals(fileInfo.fileType) : fileInfo.fileType != null) return false;
        if (mimeType != null ? !mimeType.equals(fileInfo.mimeType) : fileInfo.mimeType != null) return false;
        if (fileName != null ? !fileName.equals(fileInfo.fileName) : fileInfo.fileName != null) return false;
        return fileExtension != null ? fileExtension.equals(fileInfo.fileExtension) : fileInfo.fileExtension == null;

    }

    @Override
    public int hashCode() {
        int result = fileType != null ? fileType.hashCode() : 0;
        result = 31 * result + (mimeType != null ? mimeType.hashCode() : 0);
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (fileExtension != null ? fileExtension.hashCode() : 0);
        result = 31 * result + (isSupported ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "fileType='" + fileType + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileExtension='" + fileExtension + '\'' +
                ", isSupported=" + isSupported +
                '}';
    }

}
