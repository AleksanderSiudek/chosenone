package com.example.chosenone;

import java.util.Objects;

public class Member {
    private final Long id; // np. numer lokalu albo UUID
    private final String imieNazwisko;

    public Member(Long id, String imieNazwisko) {

        if (id == null || id < 0) {
            throw new IllegalArgumentException("Id cannot be empty or null");
        }
        if (imieNazwisko == null || imieNazwisko.isBlank()) {
            throw new IllegalArgumentException("NameAndUsername cannot be empty or null");
        }
        this.id = id;
        this.imieNazwisko = imieNazwisko;
    }

    public Long getId() {
        return id;
    }

    public String getImieNazwisko() {
        return imieNazwisko;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        var member = (Member) o;
        return Objects.equals(id, member.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}