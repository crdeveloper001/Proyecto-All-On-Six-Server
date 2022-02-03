package com.example.allon6webserver.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailDTO {

    private String name;
    private String email;
    private int phone;
    private String typeContactSelection;
    private String passPort;
    private String procedureSelection;

    @Override
    public String toString() {
        return "EmailDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", typeContactSelection='" + typeContactSelection + '\'' +
                ", passPort='" + passPort + '\'' +
                ", procedureSelection='" + procedureSelection + '\'' +
                '}';
    }
}
