class SettingsColumn {
    private String title;
    private int width;

    SettingsColumn(String title, int width) {
        this.title = title;
        this.width = width;
    }

    String getTitle() {
        return title;
    }

    int getWidth() {
        return width;
    }

}
