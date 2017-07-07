package com.test;

import com.test.model.FileInfo;
import com.test.service.FileServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
	

    public static void main(String[] args) throws IOException {
        List<String> unsupportedFileTypes = new ArrayList<>();
        //currently unsupported file type is html
		unsupportedFileTypes.add("text/html");
		FileServiceImpl instance = new FileServiceImpl(unsupportedFileTypes);
		List<FileInfo> fileInfo = instance.getFileInfo(args[0]);
        System.out.println("Supported File Types");
        fileInfo.stream().filter(FileInfo::isSupported).forEach(System.out::println);
		System.out.println("Unsupported File Types");
        fileInfo.stream().filter(fileInfo1 -> !fileInfo1.isSupported()).forEach(System.out::println);
    }
}
