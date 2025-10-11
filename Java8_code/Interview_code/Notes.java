package Java8.InterviewQuestion;


public class Notes {
    int id;
    String note_name;
    int pages;

    public Notes(int id, String note_name, int pages) {
        this.id = id;
        this.note_name = note_name;
        this.pages = pages;
    }

    public Notes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote_name() {
        return note_name;
    }

    public void setNote_name(String note_name) {
        this.note_name = note_name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
