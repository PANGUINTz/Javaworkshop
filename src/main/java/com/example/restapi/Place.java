package com.example.restapi;

import java.util.Arrays;

public class Place {
    private  String html_attributions[];
    private  Result result;
    private String status;

    public String[] getHtml_attributions() {
        return html_attributions;
    }

    public void setHtml_attributions(String[] html_attributions) {
        this.html_attributions = html_attributions;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Place{" +
                "html_attributions=" + Arrays.toString(html_attributions) +
                ", result=" + result +
                ", status='" + status + '\'' +
                '}';
    }
}
