package com.test;

import com.test.model.FileInfo;

import java.io.IOException;
import java.util.List;

public interface FileService {

    List<FileInfo> getFileInfo(String path) throws IOException;

}
