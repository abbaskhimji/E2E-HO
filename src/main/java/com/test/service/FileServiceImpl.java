package com.test.service;

import com.test.FileService;
import com.test.model.FileInfo;
import org.apache.tika.Tika;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.mime.MimeTypes;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileServiceImpl implements FileService {

    private List<String> unsupportedFileTypes;

    public FileServiceImpl(List<String> unsupportedFileTypes) {
        this.unsupportedFileTypes = unsupportedFileTypes;
    }

    public List<FileInfo> getFileInfo(String path) throws IOException {
        return Files.list(Paths.get(path)).map(this::toFileInfo).collect(Collectors.toList());
    }

    private FileInfo toFileInfo(Path path) {
        final Tika tika = new Tika();
        try (InputStream is = Files.newInputStream(path)){
            String fileType = tika.detect(path);
            MediaType mediaType = getMediaType(path);
            return new FileInfo(fileType, mediaType.getType(), path.getFileName().toString(), !unsupportedFileTypes.contains(fileType));
        } catch (IOException e) {
            System.err.println("Failed to detect type of path " + path);
            throw new IllegalArgumentException(e);
        }
    }

    private MediaType getMediaType(Path path) throws IOException {
        MimeTypes mimeTypes = new MimeTypes();
        try (InputStream is = new BufferedInputStream(Files.newInputStream(path))){
            return mimeTypes.detect(is, new Metadata());
        }
    }
}
