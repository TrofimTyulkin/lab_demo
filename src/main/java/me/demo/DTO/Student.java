package me.demo.DTO;

import jakarta.persistence.Column;

import javax.xml.bind.annotation.XmlElement;

public record Student(
        String name,
        int id
) {
}
