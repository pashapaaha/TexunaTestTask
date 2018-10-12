class DataColumn {

    private SettingsColumn setting;
    private String value;

    SettingsColumn getSetting() {
        return setting;
    }

    String getValue() {
        return value;
    }

    DataColumn(SettingsColumn setting, String value) {
        this.setting = setting;
        this.value = value;
    }
}
