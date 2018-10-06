class DataColumn {

    private String title;
    private String value;

    String getTitle() {
        return title;
    }

    String getValue() {
        return value;
    }

    DataColumn(String title, String value) {
        this.title = title;
        this.value = value;
    }
}
