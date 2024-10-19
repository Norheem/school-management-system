package model;

import enums.ClassLevel;

public class Classes {

    private ClassLevel classLevel;

    public Classes() {
    }

    public Classes(ClassLevel classLevel) {
        this.classLevel = classLevel;
    }

    public ClassLevel getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(ClassLevel classLevel) {
        this.classLevel = classLevel;
    }
}
