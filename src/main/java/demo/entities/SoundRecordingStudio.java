package demo.entities;

import javax.persistence.Embeddable;

// TODO определение встраиваемого класса (сущность без идентичности, на объектом уровне выделяющаяся из таблицы)
// представляет чистый POJO класс
// встаивается через композицию в другой класс

@Embeddable
public class SoundRecordingStudio {

    protected String address;
    protected String name;

    public SoundRecordingStudio() {
    }

    public SoundRecordingStudio(String address, String name) {
        this.address = address;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
