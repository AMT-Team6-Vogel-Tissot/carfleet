package ch.heigvd;

public class Values {
    private String title;
    private String text;

    public Values(String _title, String _text){
        title = _title;
        text = _text;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }
}
