package com.app.swagliv.model.store;

public class FileResponse {

    private String File_URL;

    public FileResponse(String file_URL) {
        File_URL = file_URL;
    }

    public String getFile_URL() {
        return File_URL;
    }

    public void setFile_URL(String file_URL) {
        File_URL = file_URL;
    }
}
