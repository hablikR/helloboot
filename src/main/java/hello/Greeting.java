package hello;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeting {

    @JsonProperty("greeting")
    private final String content;

    public Greeting(String content) {

        this.content = content;
    }

    public String getContent() {
        return content;
    }
}