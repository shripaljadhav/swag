package com.app.swagliv.model.store;

public class Category {

    private String _id;
    private String label;

    public Category(String _id, String label) {
        this._id = _id;
        this.label = label;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
